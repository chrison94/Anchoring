package test;

import functions.*;

public class Main {
   
   public static void main(String[] args) {
       HibernateQueryFilm hq = new HibernateQueryFilm();
       WavesJ wj = new WavesJ();
       Hashing hs = new Hashing();
       String rtStatement;
       
       try {              
           hq.doNewQuery(); 
           rtStatement = hs.inputStreamDigest();
           if(rtStatement != "Fehler") {
        	   wj.transaction(rtStatement);   
           }
           
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

}