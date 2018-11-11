package jaxb;

import javax.xml.bind.annotation.*;

@SuppressWarnings("restriction")
@XmlRootElement(name="TestObject")
public class TestObject{
	private String id,name,address;
	private int salary;
	
	@XmlElement
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public TestObject(String id, String name, String address, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	public TestObject() {
		super();
	}
	
	
}