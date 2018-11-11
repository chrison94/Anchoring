package hibernate;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.film;


 
public class ListenerSaveOrUpdateMain  {
	private static Logger logger = LogManager
            .getLogger(ListenerSaveOrUpdateMain.class);
public static void main(String[] args) {
    	Session session = null;
    	Transaction transaction = null;
	   

       try {
//    	   for(int i = 0; i < 2; i++) {
    	   session = HibernateUtils.getSessionFactory().openSession();
//    	   transaction = session.getTransaction();
//          transaction.begin();
    	   session.beginTransaction();
           film f = new film();
           f.setIsOriginalTitle(true);
           f.setTitle("TestTitle");
           f.setTitleId("tt1000001");
           f.setLanguage("DE");
           f.setOrdering(123);
           f.setRegion("Europe");
           session.save(f);
         
           Query<?> query=session.createQuery("update film set title='Hallo i bims' where id=11583");
             query.executeUpdate();
             
             
           session.getTransaction().commit();
           session.close();
       //}
    	   
    	   
           HibernateUtils.shutdown();
           
       } catch (Exception e) {
           e.printStackTrace();
           // Rollback in case of an error occurred.
           session.getTransaction().rollback();
       }
   }


}
