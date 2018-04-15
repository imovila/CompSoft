
package prod;

import java.io.IOException;
import java.util.Scanner;

import bus.*;

public class Tester {

	public static void main(String[] args) throws RaiseException, IOException, ClassNotFoundException {
		DataCollection myDC = new DataCollection();
		Scanner in = new Scanner(System.in);
		Integer option = 0;
		
		////For test
		myDC.Add("DOJO", "JOJO", new Date(1960, 12, 9), EmployeeCategory.fulltime, FullTimeCategory.Analyst,
				"222222222", new Date(2000, 10, 19), 75000, new Address(StreetType.ave, 7, 100, "Terra", "Belle", "Utopia", "11111"), 
				new Phone(1, 222, 5533337), new Email("dojo", "dom", "com"), 1500.25);
		
		myDC.Add("MIMI", "KITY", new Date(1960, 12, 9), EmployeeCategory.parttime, PartTimeCategory.Consultant,
				"111111111", new Date(2015,12,11), 35.5, 12.25, new Contract("ADRF14455", new Date(2017,10,1), new Date(2017,12,1)),
				new Address(StreetType.blvd, 999, 5000, "Moon", "Sun", "CountrySun", "222"), 
				new Phone(1, 333, 7775555), new Email("mimi", "yahoo", "fr"), 500.18);
		////////

		do {
			System.out.println("\n- -- --- IT Soft Company, Personal management --- -- -");
			System.out.println("\t1. Adding a new employee");
			System.out.println("\t2. Searching employee");
			System.out.println("\t3. Modifying an employee (transfering employee to full time)");
			System.out.println("\t4. Removing an employee");
			System.out.println("\t5. Sorting the list of employees");
			System.out.println("\t6. Display list of employees");	
			System.out.println("\t7. Display number of employees");				
			System.out.println("\t8. Write to TXT file");
			System.out.println("\t9. Read from TXT file");
			System.out.println("\t10. Write to BIN file");
			System.out.println("\t11. Read from BIN file");
			System.out.println("\t[For exit : 0]");	
			System.out.print("\n\tOption = ");		
			option = in.nextInt();
			in.nextLine();
			//option = in.nextLine().charAt(0);
			
			switch(option) {
			case 1:{		
				System.out.println("\t~ ~~ ~~~ Adding a new employee ~~~ ~~ ~");				
				Employee emp = null;
				System.out.print("\t\tCategory of employee (1. Fulltime; 2. Parttime) = ");
				switch(in.nextInt()) {
				case 1:{
					emp = new FullTime();
					emp.setCategory(EmployeeCategory.valueOf("fulltime"));
					System.out.print("\t\tFull time category (1. Director; 2. Secretary; 3. Programmer; 4. Analyst) = ");
					int fc = in.nextInt();
					if (fc == 1)
						((FullTime)emp).setFullTImeCategory(FullTimeCategory.valueOf("Director"));
					else if (fc == 2)
						((FullTime)emp).setFullTImeCategory(FullTimeCategory.valueOf("Secretary"));
					else if (fc == 3)
						((FullTime)emp).setFullTImeCategory(FullTimeCategory.valueOf("Programmer"));
					else if (fc == 4)
						((FullTime)emp).setFullTImeCategory(FullTimeCategory.valueOf("Analyst"));
					in.nextLine();
					
					while (true) {
						try {
							System.out.print("\t\tSalary = ");
							((FullTime)emp).setSalary(Float.parseFloat(in.nextLine()));
							break;
						}
						catch(Exception e) {
							if (e instanceof NumberFormatException)
								System.out.println("\n\t\t\tNot in format !\n");
							else
								System.out.println(e.getMessage());
						}
					}
					break;
				}
				case 2:{
					System.out.print("\t\tPart time category (1. Consultant; 2. Student) = ");
					int pc = in.nextInt();
					in.nextLine();
					if (pc == 1) {
						emp = new Consultant();
						((PartTime)emp).setPartTimeCategory(PartTimeCategory.valueOf("Consultant"));
						while (true) {
							try {
								System.out.print("\t\tNumber hour per week = ");
								((Consultant)emp).setHourweeknumber(Float.parseFloat(in.nextLine()));
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
								System.out.print("\t\tSalary per hour = ");
								((Consultant)emp).setHoursalary(Float.parseFloat(in.nextLine()));
								break;
							}
							catch(Exception e) {
								if (e instanceof NumberFormatException)
									System.out.println("\n\t\t\tNot in format !\n");
								else
									System.out.println(e.getMessage());
							}
						}
						
					}
					else if (pc == 2) {
						emp = new Intern();
						((PartTime)emp).setPartTimeCategory(PartTimeCategory.valueOf("Intern"));						
						while (true) {
							try {
								System.out.print("\t\tTrimestrial salary = ");
								((Intern)emp).setSalary(Float.parseFloat(in.nextLine()));
								break;
							}
							catch(Exception e) {
								if (e instanceof NumberFormatException)
									System.out.println("\n\t\t\tNot in format !\n");
								else
									System.out.println(e.getMessage());
							}
						}
					}

					emp.setCategory(EmployeeCategory.valueOf("parttime"));
					System.out.print("\t\tContract:");
					Contract contract = new Contract();
					while (true) {
						try {
							System.out.print("\n\t\t\tnumber = ");
							contract.setNumber(in.nextLine());
							break;
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
										
					System.out.print("\t\t\tDate in: ");
					Date din = new Date();
					while (true) {	
						try {
							System.out.print("\n\t\t\tyear = ");
							din.setYear(Integer.parseInt(in.nextLine()));
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
							din.setMonth(Integer.parseInt(in.nextLine()));
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
							din.setDay(Integer.parseInt(in.nextLine()));
							break;
						}
						catch(Exception e) {
							if (e instanceof NumberFormatException)
								System.out.println("\n\t\t\tNot in format !\n");
							else
								System.out.println(e.getMessage());
						}			
					}
					contract.setDatein(din);

					System.out.print("\t\t\tDate out: ");
					Date dout = new Date();
					while (true) {	
						try {
							System.out.print("\n\t\t\tyear = ");
							dout.setYear(Integer.parseInt(in.nextLine()));
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
							dout.setMonth(Integer.parseInt(in.nextLine()));
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
							dout.setDay(Integer.parseInt(in.nextLine()));
							break;
						}
						catch(Exception e) {
							if (e instanceof NumberFormatException)
								System.out.println("\n\t\t\tNot in format !\n");
							else
								System.out.println(e.getMessage());
						}			
					}
					contract.setDateout(dout);

					((PartTime)emp).setContract(contract);
					break;
				}				
				}//end switch category

				myDC.SetEmployee(emp, in);
				break;
			}
			case 2:{
				Employee empSearch = null;
				System.out.println("\n\tChoose an option :");
				System.out.println("\t1. Search by NAS");
				System.out.println("\t2. Search by Code");
				System.out.print("\tOption = ");				
				int op = in.nextInt();
				in.nextLine();
				switch(op)
				{
					case 1:
						System.out.println("\n\t~ ~~ ~~~ Search employee by NAS ~~~ ~~ ~");
						System.out.print("\n\tEnter NAS for search: ");
						empSearch = myDC.SearchByNAS(in.nextLine());
						break;
					case 2:
						System.out.println("\n\t~ ~~ ~~~ Search employee by CODE ~~~ ~~ ~");
						System.out.print("\n\tEnter CODE for search: ");
						empSearch = myDC.SearchByCode(in.nextLine());
						break;
				}				
				System.out.println("\n\t- -- --- Employee found --- -- -\n\t" +  (empSearch == null ? "\n\t\tNo data found !" : empSearch) );
				break;
			}
			case 3:{
				System.out.println("\n\t~ ~~ ~~~ Transfering employee to full time ~~~ ~~ ~");
				String nas = ""; 
				System.out.print("\n\tEnter NAS for search and update the category: ");
				nas = in.nextLine();
				float salary = 0; 
				System.out.print("\n\tEnter anual salary for full time employee: ");
				salary = in.nextFloat();
				System.out.print("\n\tEnter new extra pay for employee: ");
				float extrapay = in.nextFloat();
				int fcategory = 0;
				System.out.print("\n\tEnter full time category (1. Director; 2. Secretary; 3. Programmer; 4. Analyst): ");
				fcategory = in.nextInt();
				if (myDC.UpdateByNAS(nas, salary, extrapay,
						(fcategory == 1 ? FullTimeCategory.Director : 
							fcategory == 2 ? FullTimeCategory.Secretary :	
								fcategory == 3 ? FullTimeCategory.Programmer :
									FullTimeCategory.Analyst)))
					System.out.println("\n\t--> Successfully updated ! <--");
				else {
					System.out.println("\n\t--> Unsuccessfully updated. Verify NAS ! <--");						
					}					
				in.nextLine();
				break;
			}
			case 4:{
				System.out.println("\n\t~ ~~ ~~~ Removing an employee (by NAS) ~~~ ~~ ~");
				System.out.print("\n\tEnter NAS for search and update the category: ");
				if (myDC.Remove(in.nextLine()))
					System.out.println("\n\t--> Successfully deleted ! <--");
				else {
					System.out.println("\n\t--> Unsuccessfully deleted. Verify NAS ! <--");						
					}
				break;
			}
			case 5:{
				System.out.println("\n\tChoose an option :");
				System.out.println("\t1. Sorting the list of employees NAS");
				System.out.println("\t2. Sorting the list of employees by postal code");
				System.out.println("\t3. Sorting the list of employees by first and last name");				
				System.out.print("\tOption = ");			
				int op = in.nextInt();
				in.nextLine();
				switch(op)
				{
					case 1:
						System.out.println("\n\t~ ~~ ~~~ Sorting the list of employees by NAS ~~~ ~~ ~");
						myDC.SortByNas();
						System.out.println(myDC);
						break;
					case 2:
						System.out.println("\n\t~ ~~ ~~~ Sorting the list of employees by postal code ~~~ ~~ ~");
						myDC.SortByPostalCode();
						System.out.println(myDC);
						break;
					case 3:
						System.out.println("\n\t~ ~~ ~~~ Sorting the list of employees by first and last name ~~~ ~~ ~");
						myDC.SortByFirstLastName();
						System.out.println(myDC);
						break;
				}
				break;
			}
			case 6: {
				System.out.println(myDC);
				break;
			}
			case 7: {
				System.out.println("\n\t~ ~~ ~~~ Total nomber of employees ~~~ ~~ ~");
				System.out.println("\t\t" + myDC.GetNUmberOfEmployee() + " employees");
				break;
			}
			case 8: {
				System.out.println("\n\t~ ~~ ~~~ Write to TXT file ~~~ ~~ ~");
				if (FileHandlerTxt.WriteFromFile(myDC.GetEmployeeList()))
					System.out.println("\n\t--> Successful Writing ! <--");
				else
					System.out.println("\n\t--> Unsuccessful Writing ! <--");
				break;
			}
			case 9: {
				System.out.println("\n\t~ ~~ ~~~ Read from TXT file ~~~ ~~ ~");
				System.out.println(FileHandlerTxt.ReadFromFile());
				break;
			}
			case 10: {
				System.out.println("\n\t~ ~~ ~~~ Write to BIN file ~~~ ~~ ~");
				if (FileHandlerSer.WriteToBinFile(myDC.GetEmployeeList()))
					System.out.println("\n\t--> Successful Writing ! <--");
				else
					System.out.println("\n\t--> Unsuccessful Writing ! <--");
				break;
			}
			case 11: {
				System.out.println("\n\t~ ~~ ~~~ Read from BIN file ~~~ ~~ ~");
				System.out.println(FileHandlerSer.ReadFromBinFile());
				break;
			}

			}
		}while(option != 0);
	}

}