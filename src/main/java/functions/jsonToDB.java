package functions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.query.Query;
import hibernate.HibernateUtils;

public class jsonToDB {
    
    private String jsonString;
    
    public jsonToDB() {
    }
    
    
    public void insertJsonToDB(String jsonString) {
        JSONObject jsonobject = new JSONObject(jsonString);
        JSONArray tabellennamen = jsonobject.names();
        for(int i = 0; i < tabellennamen.length();i++) {
            String tabelle = tabellennamen.getString(i);
            JSONObject datas = jsonobject.getJSONObject(tabelle);
            for(int a = 0; a < datas.length();a++) {
                String spaltenname = datas.names().get(a).toString();
                String spaltenwert = datas.get(spaltenname).toString();
                System.out.println(spaltenname + " - " + spaltenwert);
                //HQL bauen
            }
        }
    }
    public void updateJsonToDB(String jsonString) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<?> query = session.createQuery("update accessions set name = 123 where id = 1");
        query.executeUpdate();
        /*Session session = HibernateUtils.getSessionFactory().openSession();
        JSONObject jsonobject = new JSONObject(jsonString);
        JSONArray tabellennamen = jsonobject.names();
        for(int i = 0; i < tabellennamen.length();i++) {
            String tabelle = tabellennamen.getString(i);
            JSONObject datas = jsonobject.getJSONObject(tabelle);
            String setQuery = "";
            for(int a = 0; a < datas.length();a++) {
                String spaltenname = datas.names().get(a).toString();
                String spaltenwert = datas.get(spaltenname).toString();
                System.out.println(spaltenname + " - " + spaltenwert);
                if(!spaltenname.equals("id")) {
                    setQuery += spaltenname + " = :"+spaltenname+",";               //HQL bauen
                }
            }
            System.out.println(setQuery);
//          Query query = session.createQuery("update " + tabelle + " set "+setQuery.substring(0, setQuery.length()-1) +" where id = :id");
//          for(int a = 0; a < datas.length();a++) {
//              String spaltenname = datas.names().get(a).toString();
//              String spaltenwert = datas.get(spaltenname).toString();
//              query.setParameter(spaltenname, spaltenwert);
//          }
            Query query = session.createQuery("update authors set fkRefinfoId=10 where id=1");
            System.out.println(query.getQueryString());
            try {
                
                query.executeUpdate();
            } catch (Exception e){
                e.printStackTrace();
            }
        
        }
        session.close();*/
    }
}