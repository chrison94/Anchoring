package listener;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

import functions.CreateLists;
import functions.Hashing;
import functions.WavesDataTransactions;

public class SaveOrUpdateEventListenerImp implements SaveOrUpdateEventListener {

	private static final long serialVersionUID = 1L;
	CreateLists cl = new CreateLists();
	ExecutorService executorUp = Executors.newFixedThreadPool(10);
	int countTrans = 0;

	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent sa) throws HibernateException {
		if (countTrans == 30) {
			try {
				Thread.sleep(1000);
				countTrans = 0;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String methodName;
		String hashResult = null;
		Hashing hs = new Hashing();
		try {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			long getTimestamp = time.getTime();
			Thread.sleep(1);
			Object cla = sa.getEntity();
			Class<?> c = cla.getClass();

			Object entryId = null;
			List<Object> data = new ArrayList<Object>();
			List<Method> allMethods = new ArrayList<Method>(Arrays.asList((c.getDeclaredMethods())));

			Collections.sort(allMethods, new Comparator<Method>() {
				@Override
				public int compare(Method method1, Method method2) {
					return method1.getName().compareToIgnoreCase(method2.getName());
				}
			});
			for (Method m : allMethods) {
				methodName = m.getName();

				if (!data.contains(c.getSimpleName())) {
					data.add(c.getSimpleName());
				}
				if (methodName.toLowerCase().contains("getid")) {
					entryId = m.invoke(cla);
				}
				if (methodName.toLowerCase().contains("get")) {
					Object result = m.invoke(cla);
					data.add(result);
				}
			}
			hashResult = hs.DatabaseEntryHash(data);

			if (!cl.getHashList().contains(hashResult)) {
				cl.addHashList(hashResult);
				cl.addTimestamp(getTimestamp);
				cl.addTableName(c.getSimpleName());
				cl.addDbEntry(entryId.toString());
			} else {
				int indexOfEntry = cl.getHashList().indexOf(hashResult);

				/* remove double entry */
				cl.removeEntry(indexOfEntry);

				/* add new entry */
				cl.addHashList(hashResult);
				cl.addTimestamp(getTimestamp);
				cl.addTableName(c.getSimpleName());
				cl.addDbEntry(entryId.toString());
			}
			if (cl.getHashListSize() == 100) {
				List<Object> hashListTmp = cl.getHashList().stream().collect(toList());
				List<Object> timestampListTmp = cl.getTimestampList().stream().collect(toList());
				List<Object> tableNameListTmp = cl.getTableNameList().stream().collect(toList());
				List<Object> entryListTmp = cl.getEntryIDList().stream().collect(toList());
				executorUp.submit(new WavesDataTransactions(hashListTmp, timestampListTmp, tableNameListTmp, entryListTmp));
				cl.clearLists();
				countTrans += 2;
			}

			if (c.getSimpleName().contains("triggeranchor")) {				
				int indexOfEntry = cl.getHashList().indexOf(hashResult);
				cl.removeEntry(indexOfEntry);				
				List<Object> hashListTmp = cl.getHashList().stream().collect(toList());
				List<Object> timestampListTmp = cl.getTimestampList().stream().collect(toList());
				List<Object> tableNameListTmp = cl.getTableNameList().stream().collect(toList());
				List<Object> entryListTmp = cl.getEntryIDList().stream().collect(toList());
				executorUp.submit(new WavesDataTransactions(hashListTmp, timestampListTmp, tableNameListTmp, entryListTmp));
				cl.clearLists();
			}

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}