package bus;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Consultant extends PartTime implements Serializable {
	private static final long serialVersionUID = -6062913200745021033L;
	private double hourweeknumber;
	private double hoursalary;
	
	public double getHourweeknumber() {
		return hourweeknumber;
	}
	public void setHourweeknumber(float hourweeknumber) throws RaiseException {
		Validation.validDouble(String.valueOf(hourweeknumber));
		this.hourweeknumber = hourweeknumber;
	}
	public double getHoursalary() {
		return hoursalary;
	}
	public void setHoursalary(float hoursalary) throws RaiseException {
		Validation.validDouble(String.valueOf(hoursalary));
		this.hoursalary = hoursalary;
	}
	
	public Consultant() throws RaiseException {
		super();
	}
	
	public Consultant(String code, String fn, String ln, Date birthdate, EmployeeCategory ec,
			PartTimeCategory ptc, String nas, Date hd, double hweeknr, double hoursal, 
			Contract contract, Address ads, Phone phone, Email mail, double extrapay) throws RaiseException {
		super(code, fn, ln, birthdate, ec, ptc, nas, hd, contract, ads, phone, mail, extrapay);
		setHourweeknumber((float) hweeknr);
		setHoursalary((float) hoursal);
	}
	
	@Override
	public float getPay() {
		return (float) (getHoursalary() * (float)getHourweeknumber() * 14 + super.getExtrapay());
	}

	public String toString() {
		return "\n\tid=" + super.getId() + "\n\t\tcode: " + super.getCode() + "\n\t\tfirst name: " +
				super.getFirstname() + "\n\t\tlast name: " + super.getLastname() + 
				"\n\t\tbirth date: " + super.getBirthdate() + "\n\t\tcateory: " + 
				super.getCategory() + "\n\t\tsubcategory: " + super.getPartTimeCategory() + "\n\t\tNAS: " + 
				super.getNas() + "\n\t\thire date: " + super.getHiredate() + 
				"\n\t\tNumber hour per week: " + hourweeknumber + "\n\t\tSalary per hour: " + 
				new DecimalFormat(".##").format(hoursalary) + "$\n\t\tContract: " + super.getContract() +
				"\n\t\tAddress: " + super.getAddress() + "\n\t\tPhone: " + super.getPhone() +
				"\n\t\tEmail: " + super.getEmail() + 
				"\n\t\tExtra pay: " + new DecimalFormat(".##").format(super.getExtrapay()) +
				"$\n\t\t-> Salary: " + new DecimalFormat(".##").format(getPay()) + "$\n";
	}
}