package jaxb;
import javax.xml.bind.*;

import java.io.*;

public class Jaxb {
	@SuppressWarnings("restriction")
	public void marshall() {
		TestObject testObj = new TestObject("A001","Blub","asda",200);
		try {
			JAXBContext jc = JAXBContext.newInstance(TestObject.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(testObj, System.out);
			ms.marshal(testObj, new File("TestObject.xml"));
			
		} catch (JAXBException e) {
			System.out.println(""+ e.getMessage());
		}
	}
	
	@SuppressWarnings("restriction")
	public void unmarshell() {
		try {
			JAXBContext jc = JAXBContext.newInstance(TestObject.class);
			Unmarshaller ums = jc.createUnmarshaller();
			TestObject tobj = (TestObject)ums.unmarshal(new File("TestObject.xml"));
			System.out.println("Testobject information");
			System.out.println("id: " + tobj.getId());
			System.out.println("Name: " + tobj.getName());
			System.out.println("Address: "+  tobj.getAddress());
			System.out.println("Salary: " + tobj.getSalary());
		}catch(Exception e){
			System.out.println(""+ e.getMessage());
		}
	}
}
