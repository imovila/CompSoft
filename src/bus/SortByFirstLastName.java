package bus;

import java.util.Comparator;

public class SortByFirstLastName implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if ((e1.getFirstname() + e1.getLastname()).compareTo(e2.getFirstname() + e2.getLastname()) < 0)
			return -1;
		else if ((e1.getFirstname() + e1.getLastname()).compareTo(e2.getFirstname() + e2.getLastname()) > 0)
			return 1;
		return 0;
	}
}