package bus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DataCollection implements Serializable{

	private static final long serialVersionUID = -4545201320641979127L;
	private ArrayList<Employee> myArray;

	public ArrayList<Employee> getMyArray() {
		return myArray;
	}

	public void setMyArray(ArrayList<Employee> myArray) {
		this.myArray = myArray;
	}

	public DataCollection() {
		super();
		this.myArray = new ArrayList<>();
	}

	public DataCollection(ArrayList<Employee> myArray) {
		super();
		this.myArray = myArray;
	}
	
	public void Add(Employee employee) {
		this.myArray.add(employee);
	}

	public String GetCode(String fn, String ln, Date birthdate, String category) {
		return ln.substring(0,3).toUpperCase() + fn.substring(0,1).toUpperCase() +
				( String.valueOf(birthdate.getDay()).length() <2 ? ('0' + String.valueOf(birthdate.getDay()) ) : String.valueOf(birthdate.getDay()) ) +
				( String.valueOf(birthdate.getMonth()).length() !=2 ? ('0' + String.valueOf(birthdate.getMonth())) : String.valueOf(birthdate.getMonth()) ) +
				String.valueOf(birthdate.getYear()).substring(2,4) + category;
	}
	
	public void Add(String fn, String ln, Date birthdate, EmployeeCategory ec, 
				PartTimeCategory parttimecat, String nas, Date hd, double hweeknr, 
				double weeksal, Contract contract, Address ads, Phone phone, Email mail, double extrapay) throws RaiseException {
		Employee emp = new Consultant(GetCode(fn, ln, birthdate, "P"), fn, ln, birthdate, ec, 
						parttimecat, nas, hd, hweeknr, weeksal, contract, ads, phone, mail, extrapay);
		this.myArray.add(emp);
	}

	public void Add(String fn, String ln, Date birthdate, EmployeeCategory ec, 
			PartTimeCategory parttimecat, String nas, Date hd, double salary, 
			Contract contract, Address ads, Phone phone, Email mail, double extrapay) throws RaiseException {
		Employee emp = new Intern(GetCode(fn, ln, birthdate, "P"), fn, ln, birthdate, 
				ec, parttimecat, nas, hd, salary, contract, ads, phone, mail, extrapay);
		this.myArray.add(emp);
	}
	
	public void Add(String fn, String ln, Date birthdate, EmployeeCategory ec, 
					FullTimeCategory fulltimecat, String nas, Date hd, float salary, 
					Address ads, Phone phone, Email mail, double extrapay) throws RaiseException {
		Employee emp = new FullTime(GetCode(fn, ln, birthdate, "F"), fn, ln, birthdate, 
						ec, fulltimecat, nas, hd, salary, ads, phone, mail, extrapay);
		this.myArray.add(emp);
	}
	
	public void Remove(int idx) {
		this.myArray.remove(idx);
	}

	public boolean Remove(String nas) {
		for (Employee employee : myArray) {
			if (employee.getNas().trim().equals(nas.trim()))
			{
				this.myArray.remove(employee);
				return true;
			}
		}
		return false;
	}
	
	public Employee SearchByNAS(String nas) {
		for (Employee employee : myArray) {
			if(employee.getNas().trim().equals(nas.trim()))
				return employee;
		}
		return null;
	}
	
	public Employee SearchByCode(String code) {
		for (Employee employee : myArray) {
			if(employee.getCode().trim().equals(code.trim()))
				return employee;
		}
		return null;
	}

	public boolean UpdateByNAS(String nas, float salary, float extrapay, FullTimeCategory fcategory) throws RaiseException {
		for (int i = 0; i < this.myArray.size(); i++) {
			if(this.myArray.get(i).getNas().trim().equals(nas.trim())) {
				Employee emp = new FullTime(this.myArray.get(i).getId());
				emp.setFirstname(this.myArray.get(i).getFirstname());
				emp.setLastname(this.myArray.get(i).getLastname());
				emp.setCode(this.myArray.get(i).getCode());
				emp.setHiredate(this.myArray.get(i).getHiredate());
				emp.setNas(this.myArray.get(i).getNas());
				emp.setCategory(EmployeeCategory.fulltime);
				((FullTime)emp).setFullTImeCategory(fcategory);
				((FullTime)emp).setSalary(salary);
				emp.setAddress(this.myArray.get(i).getAddress());
				emp.setPhone(this.myArray.get(i).getPhone());
				emp.setEmail(this.myArray.get(i).getEmail());
				emp.setExtrapay(extrapay);
				this.myArray.set(i, emp);
				return true;
			}
		}
		return false;
	}

	public void SetEmployee(Employee emp, Scanner in) throws RaiseException {
		while (true) {	
			try{
				System.out.print("\t\tFirst name = ");
				emp.setFirstname(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		while (true) {
			try{
				System.out.print("\t\tLast name = ");
				emp.setLastname(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}

		System.out.print("\t\tBirth date:");
		Date bd = new Date();
		while (true) {	
			try {
				System.out.print("\n\t\t\tyear = ");
				bd.setYear(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}		
		while (true) {	
			try {
				System.out.print("\t\t\tmonth = ");
				bd.setMonth(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tday = ");
				bd.setDay(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}
		emp.setBirthdate(bd);

		while (true) {	
			try {
				System.out.print("\t\tNAS = ");
				emp.setNas(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		
		
		System.out.print("\t\tHire date:");
		Date hd = new Date();
		while (true) {	
			try {
				System.out.print("\n\t\t\tyear = ");
				hd.setYear(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}		
		while (true) {	
			try {
				System.out.print("\t\t\tmonth = ");
				hd.setMonth(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tday = ");
				hd.setDay(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}
		emp.setHiredate(hd);
		
		String code = GetCode(emp.getLastname(), emp.getFirstname(), 
				emp.getBirthdate(), emp.getCategory().toString().substring(0,1));
		emp.setCode(code);

		System.out.print("\t\tAddress:");
		Address address = new Address();
		while (true) {	
			try {
				System.out.print("\n\t\t\tApartment = ");
				address.setAppartment(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tStreet number = ");
				address.setHouse(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}		
		System.out.print("\t\t\tStreet type (1. ave, 2. st, 3. blvd) = ");
		int strtype = in.nextInt();
		address.setStreettype(StreetType.valueOf((strtype == 1 ? "ave" : strtype == 2 ? "st" : "blvd")));	
		in.nextLine();
		while (true) {	
			try {
				System.out.print("\t\t\tStreet name = ");
				address.setStreetname(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tCity name = ");
				address.setCity(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tCountry name = ");
				address.setCountry(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tPostal code = ");
				address.setPostalCode(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		emp.setAddress(address);

		System.out.print("\t\tPhone:");
		Phone phone = new Phone();
		while (true) {	
			try {
				System.out.print("\n\t\t\tCountry code = ");
				phone.setCountrycode(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tRegionl code = ");
				phone.setRegionalcode(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tLocal code = ");
				phone.setNumber(Integer.parseInt(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}				
		emp.setPhone(phone);

		System.out.print("\t\tEmail:");
		Email email = new Email();
		while (true) {	
			try {
				System.out.print("\n\t\t\tUser name = ");
				email.setUsername(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tSubdomain name = ");
				email.setDomain(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		while (true) {	
			try {
				System.out.print("\t\t\tDomain name = ");
				email.setTopdomain(in.nextLine());
				break;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		emp.setEmail(email);

		while (true) {	
			try {
				System.out.print("\t\t\tExtra pay = ");
				emp.setExtrapay(Double.parseDouble(in.nextLine()));
				break;
			}
			catch(Exception e) {
				if (e instanceof NumberFormatException)
					System.out.println("\n\t\t\tNot in format !\n");
				else
					System.out.println(e.getMessage());
			}			
		}
		
		myArray.add(emp);
	}
	
	public void SortByNas() {
		Collections.sort(this.myArray, new SortByNAS());
	}
	
	public void SortByPostalCode() {
		Collections.sort(this.myArray, new SortByPostalCode());
	}

	public void SortByFirstLastName() {
		Collections.sort(this.myArray, new SortByFirstLastName());
	}
	
	public int GetNUmberOfEmployee() {
		return this.myArray.size();
	}
	
	public ArrayList<Employee> GetEmployeeList(){
		return this.myArray;
	}
	
	@Override
	public String toString() {
		return "\n--------------\nEmployee list:\n--------------" + myArray.toString().replace('[', ' ').replace(']', ' ');
	}
}