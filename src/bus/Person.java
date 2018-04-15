package bus;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = -8643323994613863931L;
	private String firstname;
	private String lastname;
	private Date birthdate;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) throws RaiseException {
		Validation.validName(firstname.trim());
		this.firstname = firstname.trim();
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) throws RaiseException {
		Validation.validName(lastname.trim());
		this.lastname = lastname.trim();
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public Person() throws RaiseException {
		super();
		this.firstname = "";
		this.lastname = "";
		this.birthdate = new Date(1900, 1, 1);
	}
	
	public Person(String firstname, String lastname, Date birthdate) throws RaiseException {
		super();
		setFirstname(firstname);
		setLastname(lastname);
		this.birthdate = birthdate;
	}
	
	public Person(Person person) throws RaiseException{
		setFirstname(person.firstname);
		setLastname(person.lastname);
		this.birthdate = person.birthdate;
	}

	@Override
	public String toString() {
		return "firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate;
	}
}