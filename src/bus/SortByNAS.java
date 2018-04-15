package bus;

import java.util.Comparator;

public class SortByNAS implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getNas().compareTo(e2.getNas()) < 0)
			return -1;
		else if (e1.getNas().compareTo(e2.getNas()) > 0)
			return 1;
		return 0;
	}
}