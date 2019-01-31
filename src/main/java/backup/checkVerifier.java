package backup;

import hibernate.HibernateUtils;
import oracle.net.aso.b;

import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import dbimport.backup;

public class checkVerifier {
	//init
	
	public static void main(String[] args) {
	    checkVerifier cv = new checkVerifier();
	    String dataTransString = cv.hibernateEntry("as");
	    if(dataTransString != null) {
	    	System.out.println(dataTransString);
	    }
	}
	private String hibernateEntry(String hashString) {
		try {
			String data = "";
			Session session = null;
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = "SELECT b.hashString,b.timestamp FROM backup b WHERE b.hashString = hashString";
			
			Query<?> query = session.createQuery(hql);
			List<String> list = (List<String>) query.list();
			
			for(Object obj:list) {
				System.out.println(obj);
				data = data + obj.toString();
				System.out.println(data);
			}
			String dataTransString = DigestUtils.sha256Hex(data);
			return dataTransString;
		}
		catch(Exception e){
			return null;
		}
		finally {
			HibernateUtils.shutdown();
		}
	}
}

