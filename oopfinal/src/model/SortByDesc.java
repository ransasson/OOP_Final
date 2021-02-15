package model;

import java.util.Comparator;

public class SortByDesc implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return (o1.compareTo(o2))*-1;
	}

}
