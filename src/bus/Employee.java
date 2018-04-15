package bus;

public abstract class Employee extends Person {

	private static final long serialVersionUID = -5841418207906080466L;
	private int id;
	private String code;
	private Date hiredate;
	private String nas;
	private EmployeeCategory category;
	private Address address;
	private Email email;
	private Phone phone;
	private double extrapay;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code.trim();
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) throws RaiseException {
		this.hiredate = hiredate;
	}
	public String getNas() {
		return nas;
	}
	public void setNas(String nas) throws RaiseException {
		Validation.validNAS(nas);
		this.nas = nas.trim();
	}
	public EmployeeCategory getCategory() {
		return category;
	}
	public void setCategory(EmployeeCategory category) {
		this.category = category;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public double getExtrapay() {
		return extrapay;
	}
	public void setExtrapay(double extrapay) throws RaiseException {
		Validation.validDouble(String.valueOf(extrapay));
		this.extrapay = extrapay;
	}
	
	public Employee(int empID) throws RaiseException {
		super();
		this.id = empID;
	}
	
	public Employee() throws RaiseException {
		super();
		this.id = Sequence.getIdx();
	}
	
	public Employee(String code, Date hiredate, String nas, EmployeeCategory category, 
			Address address, Email email, Phone phone, double extrapay) throws RaiseException {
		super();
		this.id = Sequence.getIdx();
		this.code = code;
		this.hiredate = hiredate;
		setNas(nas);
		this.category = category;
		this.address = address;
		this.email = email;
		this.phone = phone;
		setExtrapay(extrapay);
	}

	public Employee(Employee employee) throws RaiseException {
		this.id = Sequence.getIdx();
		this.code = employee.code;
		this.hiredate = employee.hiredate;
		setNas(employee.nas);
		this.category = employee.category;
		this.address = employee.address;
		this.email = employee.email;
		this.phone = employee.phone;
		setExtrapay(employee.extrapay);
	}
	public Employee(String code, String fn, String ln, Date birthdate, EmployeeCategory ec, 
						String nas, Date hd, Address ads, Phone phone, Email mail, double extrapay) throws RaiseException {
		super(fn, ln, birthdate);
		this.id = Sequence.getIdx();
		this.code = code;
		this.hiredate = hd;
		setNas(nas);
		this.category = ec;
		this.address = ads;
		this.phone = phone;
		this.email = mail;		
		setExtrapay(extrapay);
	}
	
	public abstract float getPay();
}