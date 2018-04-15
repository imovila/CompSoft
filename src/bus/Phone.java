package bus;

import java.io.Serializable;

public class Phone implements Serializable{

	private static final long serialVersionUID = 709038918581247932L;
	private int countrycode;
	private int regionalcode;
	private int number;

	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) throws RaiseException {
		Validation.validCountryCode(String.valueOf(countrycode));
		this.countrycode = countrycode;
	}
	public int getRegionalcode() {
		return regionalcode;
	}
	public void setRegionalcode(int regionalcode) throws RaiseException {
		Validation.validRegionalCode(String.valueOf(regionalcode));
		this.regionalcode = regionalcode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) throws RaiseException {
		Validation.validLocalCode(String.valueOf(number));
		this.number = number;
	}

	public Phone() {
		super();
	}
	public Phone(int countrycode, int regionalcode, int number) throws RaiseException {
		super();
		setCountrycode(countrycode);
		setRegionalcode(regionalcode);
		setNumber(number);
	}
	public Phone(Phone phone) throws RaiseException {
		setCountrycode(phone.countrycode);
		setRegionalcode(phone.regionalcode);
		setNumber(phone.number);
	}
	
	@Override
	public String toString() {
		return "+" + countrycode + " (" + regionalcode + ") " + number;
	}
}