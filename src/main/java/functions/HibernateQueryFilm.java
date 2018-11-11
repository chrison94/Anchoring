package functions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entities.film;
import hibernate.HibernateUtils;
 
public class HibernateQueryFilm {
   
   public void doNewQuery() {
       SessionFactory factory = HibernateUtils.getSessionFactory();
       Session session = factory.getCurrentSession();
              
       try {              
           session.getTransaction().begin();
      
           String sql = "Select f from " + film.class.getName() + " f"
                  + " order by f.titleId"; 
   
           // Create Query
           Query<film> query = session.createQuery(sql);
           FileWriter writer = new FileWriter("test.txt");
           BufferedWriter bufferedWriter = new BufferedWriter(writer);
          
           // Execute Query
           List<film> movies = query.getResultList();
 
           for (film flm : movies) {
        	   /* bufferedWriter input */
       			bufferedWriter.write(flm.getId() + ' ');
       			bufferedWriter.write(flm.getTitleId() + ' ');
       			bufferedWriter.write(flm.getOrdering() + ' ');
       			bufferedWriter.write(flm.getTitle() + ' ');
       			bufferedWriter.write(flm.getRegion() + ' ');
       			bufferedWriter.write(flm.getLanguage() + ' ');
       			bufferedWriter.write(flm.getTypes() + ' ');
       			bufferedWriter.write(flm.getAttributes() + ' ');
       			bufferedWriter.write(String.valueOf(flm.getIsOriginalTitle()));
       			bufferedWriter.newLine();
           	}
           bufferedWriter.close();           
           
           // Commit data.
           session.getTransaction().commit();
       } catch (Exception e) {
           e.printStackTrace();
           // Rollback in case of an error occurred.
           session.getTransaction().rollback();
       }
   }


}
