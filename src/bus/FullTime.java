package bus;

import java.text.DecimalFormat;

public class FullTime extends Employee {

	private static final long serialVersionUID = 582717992314712600L;
	private FullTimeCategory fullTImeCategory;
	private float salary;

	public FullTimeCategory getFullTImeCategory() {
		return fullTImeCategory;
	}
	public void setFullTImeCategory(FullTimeCategory fullTImeCategory) {
		this.fullTImeCategory = fullTImeCategory;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) throws RaiseException {
		Validation.validDouble(String.valueOf(salary));
		this.salary = salary;
	}

	public FullTime() throws RaiseException {
		super();
	}
	
	public FullTime(int empID) throws RaiseException {
		super(empID);
	}

	public FullTime(FullTimeCategory fullTImeCategory, float salary) throws RaiseException {
		super();
		this.fullTImeCategory = fullTImeCategory;
		setSalary(salary);
	}
	
	public FullTime(String code, String fn, String ln, Date birthdate, EmployeeCategory ec, 
					FullTimeCategory ftc, String nas, Date hd, float sal, Address ads, 
					Phone phone, Email mail, double extrapay) throws RaiseException {
		super(code, fn, ln, birthdate, ec, nas, hd, ads, phone, mail, extrapay);
		this.fullTImeCategory = ftc;
		setSalary(sal);
	}

	@Override
	public float getPay() {
		return (float) (getSalary() / 52 * 2 + super.getExtrapay());
	}
	
	@Override
	public String toString() {
		return "\n\tid=" + super.getId() + "\n\t\tcode: " + super.getCode() + "\n\t\tfirst name:" +
				super.getFirstname() + "\n\t\tlast name: " + super.getLastname() +
				"\n\t\tbirth date: " + super.getBirthdate() + "\n\t\tcateory: " + 
				super.getCategory() + "\n\t\tsubcategory: " + fullTImeCategory + "\n\t\tNAS: " + super.getNas() +
				"\n\t\thire date: " + super.getHiredate() + "\n\t\tsalary: " + new DecimalFormat("#0.##").format(salary) + 
				"$\n\t\tAddress: " + super.getAddress() + "\n\t\tPhone: " + super.getPhone() + 
				"\n\t\tEmail:" + super.getEmail() + "\n\t\tExtra pay:" + new DecimalFormat("#0.##").format(super.getExtrapay()) + 
				"$\n\t\t-> Salary: " + new DecimalFormat("#0.##").format(getPay()) + "$\n";
	}
}