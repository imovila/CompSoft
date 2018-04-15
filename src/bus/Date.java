package bus;

import java.io.Serializable;

public class Date implements Serializable {
	
	private static final long serialVersionUID = -2761522375450569974L;
	private int year;
	private int month;
	private int day;

	public int getYear() {
		return year;
	}
	public void setYear(int year) throws RaiseException {
		Validation.validYear(String.valueOf(year));
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) throws RaiseException {
		Validation.validMonth(String.valueOf(month));
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) throws RaiseException {
		Validation.validDay(String.valueOf(day));
		this.day = day;
	}

	public Date() {
		super();
		this.year = 0;
		this.month = 0;
		this.day = 0;
	}
	
	public Date(int year, int month, int day) throws RaiseException {
		super();
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public Date(Date date) throws RaiseException {
		setYear(date.year);
		setMonth(date.month);
		setDay(date.day);
	}

	@Override
	public String toString() {
		return String.valueOf(year) + "/" + month + "/" + day;
	}
	
}