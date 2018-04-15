package bus;

public class Validation {

	public static void validInt(String s) throws RaiseException {
		if ((!s.matches("\\d")) && (Integer.parseInt(s)<0))
			throw new RaiseException("\n\t\t\tIt is not in the required format for the integer number !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validDouble(String s) throws RaiseException {
		if (!s.matches("^\\d+(\\.\\d+)?"))
			throw new RaiseException("\n\t\t\tIt is not in the required format for the decimal number !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validDay(String s) throws RaiseException {
		if (!s.matches("^([1][0-9]|[2][0-9]|[3][0-1]|[1-9])$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the day !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validMonth(String s) throws RaiseException {
		if (!s.matches("^([1][0-2]|[1-9])$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the month !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validYear(String s) throws RaiseException {
		if (!s.matches("^\\d{4}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the year {YYYY}!\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validContractNumber(String s) throws RaiseException {
		if (!s.matches("^([a-zA-Z](\\d+)?){4,}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the contract number {letters and numbers, more 4} !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validAppartment(String s) throws RaiseException {
		if (!s.matches("^\\d{1,5}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the appartment {nnnnn} !\n\t\t\tPlease reentry data ! \r\n") ;
	}
	
	public static void validStreetNumber(String s) throws RaiseException {
		if (!s.matches("^\\d{3,8}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the street number {nnnnnnnn} !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validName(String s) throws RaiseException {
		if (!s.matches("^([a-zA-Z]\\s?){3,30}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the name {letters, more 3} !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validNAS(String s) throws RaiseException {
		if (!s.matches("^\\d{9}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the NAS {numbers, 9} !\n\t\t\tPlease reentry data ! \r\n");
	}	
	
	public static void validPostalCode(String s) throws RaiseException {
		if (!s.matches("^([a-z]\\d[a-z]\\d[a-z]\\d)$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the postal code !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validCountryCode(String s) throws RaiseException {
		if (!s.matches("^(\\d){1,3}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the country code {numbers, 3} !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validRegionalCode(String s) throws RaiseException {
		if (!s.matches("^(\\d){3}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the regional code {numbers, 3} !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validLocalCode(String s) throws RaiseException {
		if (!s.matches("^(\\d){7}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the local code {numbers, 7} !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validUserName(String s) throws RaiseException {
		if (!s.matches("^([a-z]([\\.\\-])?){2,30}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the user name {letters or .-, more 2} !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validSubDomain(String s) throws RaiseException {
		if (!s.matches("^([a-z]){2,30}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the subdomain {letters, more 2} !\n\t\t\tPlease reentry data ! \r\n");
	}
	
	public static void validDomain(String s) throws RaiseException {
		if (!s.matches("^([a-z]){2,8}$"))
		throw new RaiseException("\n\t\t\tIt is not in the required format for the domain {letters, more 2} !\n\t\t\tPlease reentry data ! \r\n");
	}

}