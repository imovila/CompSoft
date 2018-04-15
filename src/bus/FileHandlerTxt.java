package bus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileHandlerTxt {
	private static String path = "src/data/DataCollectionFile.txt";

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		setPath(path);
	}

	public static File getFile() {
		return new File(getPath());
	}

	public static boolean WriteFromFile(ArrayList<Employee> myList) {
		try {
			FileWriter myFile = new FileWriter(getFile());
			for (Employee emp : myList) {
				myFile.write(String.valueOf(emp.getId()) + "|" + emp.getCode() + "|" + emp.getFirstname() + "|"
						+ emp.getLastname() + "|" + emp.getBirthdate() + "|" + emp.getHiredate() + "|" + emp.getNas()
						+ "|" + emp.getCategory().toString() + "|"
						+ (emp.getCategory().toString() == "parttime"
								? ((PartTime) emp).getPartTimeCategory().toString() == "Consultant"
										? ((PartTime) emp).getPartTimeCategory().toString() + "|"
												+ String.valueOf(((Consultant) emp).getHoursalary()) + "|"
												+ String.valueOf(((Consultant) emp).getHourweeknumber()) + "|"
												+ ((PartTime) emp).getContract()
										: ((PartTime) emp).getPartTimeCategory().toString() + "|"
												+ String.valueOf(((Intern) emp).getSalary()) + "|"
												+ ((PartTime) emp).getContract()
								: ((FullTime) emp).getFullTImeCategory().toString() + "|"
										+ ((FullTime) emp).getSalary())
						+ "|" + emp.getAddress() + "|" + emp.getPhone() + "|" + emp.getEmail() + "|" + emp.getExtrapay() + "\n");
			}
			myFile.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public static ArrayList<Employee> ReadFromFile() throws RaiseException {
		try {
			ArrayList<Employee> myArray = new ArrayList<>();
			Scanner scanner = new Scanner(getFile());
			StringTokenizer token = null;

			while (scanner.hasNextLine()) {
				Employee emp = null;
				boolean ptimec = false, ptimei = false;

				String curLine = scanner.nextLine().replace("number=", "").
				 replace("datein=", "").replace("dateout=", "").
				 replace("#", "").replace("+", "").replace("(", "").replace(")", "");

				token = new StringTokenizer(curLine, "|");

				if (curLine.indexOf("parttime") != -1) {
					if (curLine.indexOf("Consultant") != -1) {
						emp = new Consultant();
						ptimec = true;
					} else {
						emp = new Intern();
						ptimei = true;
					}
				} else
					emp = new FullTime();

				emp.setId(Integer.parseInt(token.nextToken()));
				emp.setCode(token.nextToken());
				emp.setLastname(token.nextToken());
				emp.setFirstname(token.nextToken());

				String birthdatesplit[] = token.nextToken().split("/");
				Date birthdate = new Date(Integer.parseInt(birthdatesplit[0]), Integer.parseInt(birthdatesplit[1]),
						Integer.parseInt(birthdatesplit[2]));
				emp.setBirthdate(birthdate);
				String hiredatesplit[] = token.nextToken().split("/");
				Date hiredate = new Date(Integer.parseInt(hiredatesplit[0]), Integer.parseInt(hiredatesplit[1]),
						Integer.parseInt(hiredatesplit[2]));
				emp.setHiredate(hiredate);
				emp.setNas(token.nextToken());
				emp.setCategory(EmployeeCategory.valueOf(token.nextToken()));
				if (ptimec || ptimei) {
					((PartTime) emp).setPartTimeCategory(PartTimeCategory.valueOf(token.nextToken()));
					if (ptimec) {
						((Consultant) emp).setHoursalary(Float.parseFloat(token.nextToken()));
						((Consultant) emp).setHourweeknumber(Float.parseFloat(token.nextToken()));
					} else if (ptimei) {
						((Intern) emp).setSalary(Float.parseFloat(token.nextToken()));
					}
					String contractsplit[] = token.nextToken().replace(" ", "").split(",");
					String dateinsplit[] = contractsplit[1].replace(" ", "").split("/");
					Date datein = new Date(Integer.parseInt(dateinsplit[0]), Integer.parseInt(dateinsplit[1]),
							Integer.parseInt(dateinsplit[2]));

					String dateoutsplit[] = contractsplit[2].replace(" ", "").split("/");
					Date dateout = new Date(Integer.parseInt(dateoutsplit[0]), Integer.parseInt(dateoutsplit[1]),
							Integer.parseInt(dateoutsplit[2]));

					((PartTime) emp).setContract(new Contract(contractsplit[0], datein, dateout));

				} else {
					((FullTime) emp).setFullTImeCategory(FullTimeCategory.valueOf(token.nextToken()));
					((FullTime) emp).setSalary(Float.parseFloat(token.nextToken()));
				}

				String address[] = token.nextToken().replace(" ", "").split(",");
				int app = Integer.parseInt(address[0].substring(0, address[0].indexOf("-")));
				int strnumb = Integer.parseInt(address[0].substring(address[0].indexOf("-") + 1, address[0].length()));

				String stype = address[1].substring(0, address[1].indexOf("."));
				String sname = address[1].substring(address[1].indexOf(".") + 1, address[1].length());
				emp.setAddress(new Address(StreetType.valueOf(stype), app, strnumb, 
								sname, address[2], address[3], address[4]));
				
				String phone[] = token.nextToken().split(" ");
				emp.setPhone(new Phone(Integer.parseInt(phone[0]), Integer.parseInt(phone[1]), Integer.parseInt(phone[2])));

				String mail = token.nextToken();
				String uname = mail.substring(0, mail.indexOf("@"));
				String domen = mail.substring(mail.indexOf("@") + 1, mail.indexOf("."));
				String subdomen = mail.substring(mail.indexOf(".") + 1, mail.length());
				emp.setEmail(new Email(uname, domen, subdomen));

				emp.setExtrapay(Float.parseFloat(token.nextToken()));
				
				myArray.add(emp);
			}
			return myArray;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}