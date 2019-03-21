package functions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.query.Query;
import hibernate.HibernateUtils;
public class JsonToDB {
    
    private String jsonString;
    
    public JsonToDB() {
    }
    
    public void updateJsonToDB(String jsonString) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        JSONObject jsonobject = new JSONObject(jsonString);
        JSONArray tabellennamen = jsonobject.names();
        for(int i = 0; i < tabellennamen.length();i++) {
            String tabelle = tabellennamen.getString(i);
            JSONObject datas = jsonobject.getJSONObject(tabelle);
            String setQuery = "";
            for(int a = 0; a < datas.length();a++) {
                String spaltenname = datas.names().get(a).toString();
                String spaltenwert = datas.get(spaltenname).toString();
//              System.out.println(spaltenname + " - " + spaltenwert);
                if(!spaltenname.equals("id")) {
                    setQuery += spaltenname + " = :"+spaltenname+",";               //HQL bauen
                }
            }
//          System.out.println(setQuery);
            Query query = session.createQuery("update " + tabelle + " set "+setQuery.substring(0, setQuery.length()-1) +" where id = :id");
            for(int a = 0; a < datas.length();a++) {
                String spaltenname = datas.names().get(a).toString();
                query.setParameter(spaltenname, datas.get(spaltenname));
            }
//          System.out.println(query.getQueryString());
            try {
                session.beginTransaction();
                query.executeUpdate();                
                session.getTransaction().commit();
            } catch (Exception e){
                e.printStackTrace();
            }
        
        }
        session.close();
    }
}