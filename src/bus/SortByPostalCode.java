package bus;

import java.util.Comparator;

public class SortByPostalCode implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getAddress().getPostalCode().compareTo(e2.getAddress().getPostalCode()) > 0)
			return 1;
		else if (e1.getAddress().getPostalCode().compareTo(e2.getAddress().getPostalCode()) < 0)
			return -1;
		else
			return 0;
	}
}
