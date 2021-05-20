package au.com.alura.manager.servelet;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

	private static List<Company> list = new ArrayList<>();
	
	static {
		Company company = new Company();
		company.setName("Vittor");
		list.add(company);
		Company company2 = new Company();
		company2.setName("NahVih");
		list.add(company2);
	}
	
	public void add(Company company) {
		DataBase.list.add(company);		
	}

	public List<Company> getCompany(){
		return DataBase.list;
	}
	
}
