package bus;

import java.io.Serializable;

public class Contract implements Serializable{

	private static final long serialVersionUID = 5192423087176553363L;
	private String number;
	private Date datein;
	private Date dateout;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) throws RaiseException {
		Validation.validContractNumber(number);
		this.number = number;
	}
	public Date getDatein() {
		return datein;
	}
	public void setDatein(Date datein) {
		this.datein = datein;
	}
	public Date getDateout() {
		return dateout;
	}
	public void setDateout(Date dateout) {
		this.dateout = dateout;
	}
	
	public Contract() {}

	public Contract(String number, Date datein, Date dateout) throws RaiseException {
		super();
		setNumber(number);
		this.datein = datein;
		this.dateout = dateout;
	}
	
	@Override
	public String toString() {
		return "number=" + number + ", datein=" + datein + ", dateout=" + dateout;
	}
}