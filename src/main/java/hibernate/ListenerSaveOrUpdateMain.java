/*  NUR TEST KLASSE */
  package hibernate;
  


import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dbimport.Header;

 
public class ListenerSaveOrUpdateMain  {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long before = System.nanoTime();
		
		
		String data = "";
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();
			
			String hql = "SELECT h.id, h.uid, h.createdDate, h.seqRevDate, h.txtRevDate FROM headers h";
			int id;
			Object testObj;
			Query<?> query = session.createQuery(hql);
			List<Object[]> list = (List<Object[]>) query.list();
			for(Object[] obj:list) {
				id = (int) obj[0];
				testObj = session.get(Header.class, id);
				System.out.println(testObj);
			}
			long after = System.nanoTime();
			System.out.println(before);
			System.out.println(after);
			System.out.println((after - before)/1e9);
			transaction.commit();
		} catch(Exception e) {
				
		}
	}
}



 