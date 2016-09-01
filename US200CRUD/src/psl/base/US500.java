package psl.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class US500 
{
	private String first_name;
	private String last_name; 
	private String company_name;
	private String address;
	private String city;
	private String county;
	private String state;
	private int zip;
	private String phone1;
	private String phone2;
	private String email;
	private String web;
	
	public US500(String first_name, String last_name, String company_name, String address, String city, String county,
			String state, int zip, String phone1, String phone2, String email, String web) 
	{
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.company_name = company_name;
		this.address = address;
		this.city = city;
		this.county = county;
		this.state = state;
		this.zip = zip;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.web = web;
	}
	public US500() 
	{
		this.first_name = "first_name";
		this.last_name = "last_name";
		this.company_name = "company_name";
		this.address = "address";
		this.city = "city";
		this.county = "county";
		this.state = "state";
		this.zip = -1;
		this.phone1 = "phone1";
		this.phone2 = "phone2";
		this.email = "email";
		this.web = "web";
	}
	
	@XmlElement
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	@XmlElement
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	@XmlElement
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	@XmlElement
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@XmlElement
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@XmlElement
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	@XmlElement
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@XmlElement
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@XmlElement
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	@XmlElement
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	@Override
	public String toString() {
		return "US500 [first_name=" + first_name + ", last_name=" + last_name + ", company_name=" + company_name
				+ ", address=" + address + ", city=" + city + ", county=" + county + ", state=" + state + ", zip=" + zip
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", email=" + email + ", web=" + web + "]";
	}
	
	
	
	

}
