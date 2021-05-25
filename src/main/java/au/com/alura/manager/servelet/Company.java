package au.com.alura.manager.servelet;

import java.util.Date;

public class Company {

	private Integer id;
	private String name;
	private Date openingDay = new Date(); 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOpeningDay() {
		return openingDay;
	}
	public void setOpeningDay(Date openingDay) {
		this.openingDay = openingDay;
	}
	
}
