package au.com.alura.manager.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataBase {

	private static List<Company> list = new ArrayList<>();
	private static Integer id = 1;
	
	static {
		Company company = new Company();
		company.setId(id++);
		company.setName("Vittor");
		list.add(company);
		Company company2 = new Company();
		company2.setId(id++);
		company2.setName("NahVih");
		list.add(company2);
	}
	
	public void add(Company company) {
		company.setId(DataBase.id++);
		DataBase.list.add(company);	
		
	}

	public List<Company> getCompany(){
		return DataBase.list;
	}

	public void removeCompany(Integer id) {
		
		Iterator<Company> it = list.iterator();
		while (it.hasNext()) {
			Company company = it.next();
			if (company.getId() == id) {
				it.remove();
			}
		}

	}

	public Company editCompany(Integer id) {
		for (Company company : list) {
			if(company.getId() == id) {
				return company;
			}			
		}
		return null;
	}
	
}
