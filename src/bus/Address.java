package bus;

import java.io.Serializable;

public class Address implements Serializable{
	private static final long serialVersionUID = 6989026832556288343L;
	private StreetType streettype;
	private String streetname;
	private int house;
	private int appartment;
	private String city;
	private String postalCode;
	private String country;

	public StreetType getStreettype() {
		return streettype;
	}
	public void setStreettype(StreetType streettype) {
		this.streettype = streettype;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) throws RaiseException {
		Validation.validName(streetname.trim());
		this.streetname = streetname.trim();
	}
	public int getHouse() {
		return house;
	}
	public void setHouse(int house) throws RaiseException {
		Validation.validInt(String.valueOf(house));
		this.house = house;
	}
	public int getAppartment() {
		return appartment;
	}
	public void setAppartment(int appartment) throws RaiseException {
		Validation.validAppartment(String.valueOf(appartment));		
		this.appartment = appartment;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) throws RaiseException {
		Validation.validName(city);
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) throws RaiseException {
		Validation.validPostalCode(postalCode);
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) throws RaiseException {
		Validation.validName(country);
		this.country = country;
	}
	
	public Address() {
		super();
	}
	public Address(StreetType streetype, int appartment, int house, String streetname,
			String city, String country, String postalCode) {
		super();
		this.streettype = streetype;
		this.streetname = streetname;
		this.house = house;
		this.appartment = appartment;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
	}
	public Address(Address address) {
		this.streettype = address.streettype;
		this.streetname = address.streetname;
		this.house = address.house;
		this.appartment = address.appartment;
		this.city = address.city;
		this.country = address.country;
		this.postalCode = address.postalCode;
	}

	@Override
	public String toString() {
		return "#" + appartment + "-" + house + ", " + streettype + ". " +
				streetname + ", " + city + ", " + country + ", " + postalCode;
	}
}