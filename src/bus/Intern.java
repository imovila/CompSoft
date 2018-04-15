package bus;

import java.text.DecimalFormat;

public class Intern extends PartTime {

	private static final long serialVersionUID = -4276291637891870583L;
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws RaiseException {
		Validation.validDouble(String.valueOf(salary));
		this.salary = salary;
	}

	public Intern() throws RaiseException {
		super();
	}
	
	public Intern(double salary) throws RaiseException {
		super();
		this.salary = salary;
	}

	public Intern(String code, String fn, String ln, Date birthdate, EmployeeCategory ec, 
				PartTimeCategory ptc, String nas, Date hd, double salary, Contract contract, 
				Address ads, Phone phone, Email mail, double extrapay) throws RaiseException {
		super(code, fn, ln, birthdate, ec, ptc, nas, hd, contract, ads, phone, mail, extrapay);
		setSalary(salary);
	}
	
	public String toString() {
		return "\n\tid=" + super.getId() + "\n\t\tcode: " + super.getCode() + "\n\t\tfirst name: " +
				super.getFirstname() + "\n\t\tlast name: " + super.getLastname() + 
				"\n\t\tbirth date: " + super.getBirthdate() + "\n\t\tcateory: " + 
				super.getCategory() + "\n\t\tsubcategory: " + super.getPartTimeCategory() + "\n\t\tNAS: " + super.getNas() +
				"\n\t\thire date: " + super.getHiredate() + "\n\t\tSalary: " + new DecimalFormat(".##").format(salary) + 
				"$\n\t\tContract: " + super.getContract() + "\n\t\tAddress: " + super.getAddress() + 
				"\n\t\tPhone: " + super.getPhone() + "\n\t\tEmail: " + super.getEmail() +
				"\n\t\tExtra pay: " + new DecimalFormat(".##").format(super.getExtrapay()) +
				"$\n\t\t-> Salary: " + new DecimalFormat(".##").format(getPay()) + "$\n";
	}
	
	@Override
	public float getPay() {
		return (float) ((this.salary / 6) + super.getExtrapay());
	}	
}