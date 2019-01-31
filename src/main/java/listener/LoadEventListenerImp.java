package listener;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;


public class LoadEventListenerImp implements LoadEventListener {
	   
	   private static final long serialVersionUID = 2L;

	@Override
	public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
