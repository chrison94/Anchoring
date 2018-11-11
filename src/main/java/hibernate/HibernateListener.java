package hibernate;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

import entities.film;

public class HibernateListener implements SaveOrUpdateEventListener {
   
	 private static Logger logger = LogManager
	            .getLogger(HibernateListener.class);
	   private static final long serialVersionUID = 1L;


	
   public void onSaveOrUpdate(SaveOrUpdateEvent e) throws HibernateException {

	   logger.info("Save or Update called");

      Object obj = e.getEntity();
      if (obj instanceof film) {
         film film = (film) obj;
         System.out.println(film);
      }
   }
}