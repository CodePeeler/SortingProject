package com.simon.dom;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "shop")
public class Shop {

	String name;
	String staffName[];
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */	
	//@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the staffName
	 */
	public String[] getStaffName() {
		return staffName;
	}
	
	/**
	 * @param staffName the staffName to set
	 */
	//@XmlElement
	public void setStaffName(String[] staffName) {
		this.staffName = staffName;
	}

}