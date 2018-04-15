package bus;

public abstract class PartTime extends Employee {

	private static final long serialVersionUID = -1735085474675708164L;
	private PartTimeCategory partTimeCategory;
	private Contract contract;
	
	public PartTimeCategory getPartTimeCategory() {
		return partTimeCategory;
	}
	public void setPartTimeCategory(PartTimeCategory partTimeCategory) {
		this.partTimeCategory = partTimeCategory;
	}

	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public PartTime() throws RaiseException {
		super();
	}

	public PartTime(PartTimeCategory partTimeCategory, Contract contract) throws RaiseException {
		super();
		this.partTimeCategory = partTimeCategory;
		this.contract = contract;
	}

	public PartTime(String code, String fn, String ln, Date birthdate, EmployeeCategory ec, 
					PartTimeCategory ptc, String nas, Date hd, Contract contract, Address ads, 
					Phone phone, Email mail, double extrapay) throws RaiseException {
		super(code, fn, ln, birthdate, ec, nas, hd, ads, phone, mail, extrapay);
		this.partTimeCategory = ptc;
		this.contract = contract;
	}

	@Override
	public abstract float getPay();
}