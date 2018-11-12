
import javax.naming.spi.ObjectFactory;
import javax.xml.bind.*;

import dbimport.Feature;
import dbimport.ProteinDatabase;
import dbimport.ProteinEntry;
import dbimport.Xref;

import java.io.*;

@SuppressWarnings("restriction")
public class Jaxb {
	public void marshall() {
//		TestObject testObj = new TestObject("aa","afgf","era",2);
//		try {
//			JAXBContext jc = JAXBContext.newInstance(TestObject.class);
//			Marshaller ms = jc.createMarshaller();
//			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			ms.marshal(testObj, System.out);
//			ms.marshal(testObj, new File("t4.xml"));
//		} catch (JAXBException e) {
//			System.out.println(""+ e.getMessage());
//		}
	}
	
	public void unmarshell(boolean ausgabe) {
		System.out.println("Start");
		ProteinDatabase t = JAXB.unmarshal(new File("pswd7003.xml"),ProteinDatabase.class);
		
		//JAXBContext jc = JAXBContext.newInstance(ProteinDatabase.class);
		
		//Unmarshaller ums = jc.createUnmarshaller();
		//ProteinDatabase t = (ProteinDatabase)ums.unmarshal(new File("pswd7003.xml"));
		
		
		String entires = "";
		if(t != null && t.getProteinEntries() != null && ausgabe) {
			for(ProteinEntry e : t.getProteinEntries()) {
				entires += "\n";
				entires += "\nProtein : " + ((e.getProtein() != null ) ? e.getProtein().toString() : "null");
				entires += "\norganism : " + ((e.getOrganism() != null ) ? e.getOrganism().toString() : "null");
				for(dbimport.Reference r : e.getReferences()) {
					entires += "AccInfo: \n"+((r != null && r.getAccinfo() != null) ? r.getAccinfo().toString(): "null");
					if(r != null && r.getAccinfo() != null &&  r.getAccinfo().getXrefs() != null) {
						for(Xref x : r.getAccinfo().getXrefs().getXrefs()) {
							entires += "\nXref " + ((x != null) ? x.toString() : "null");
						}
					}
					
					entires += "Refinfo: \n"+((r != null && r.getRefinfo() != null) ? r.getRefinfo().toString(): "null");
				}
				entires += "\nGenetics : " + e.getGenetics();
				if(e.getClassification() != null) {
					entires += "\nClassifications : ";
					for(String classi : e.getClassification()) {
						entires += "\nClassification : " + classi;
					}
				}
				
				if(e.getKeywords() != null) {
					entires += "\nKeywords : ";
					for(String keyW : e.getKeywords()) {
						entires += "\nKeyword : " + keyW;
					}
				}
				
				if(e.getFeatures() != null) {
					entires += "\nKeywords : ";
					for(Feature ftr : e.getFeatures()) {
						entires += "\nKeyword : " + ftr.toString();
					}
				}
				
				entires += "Summary:  " + ((e.getSummary() != null) ? e.getSummary().toString() : "null") ;
				entires += "ProteinEntry: \n Sequence : " + e.getSequence();
				entires += "\n";
			}
			
			System.out.println("ProteinDatabase information");
			System.out.println("db " +( (t != null &&  t.getDatabase() != null) ? t.getDatabase() : "null") +"\n" + entires );
		}
		
		System.out.println("End");

	}
}