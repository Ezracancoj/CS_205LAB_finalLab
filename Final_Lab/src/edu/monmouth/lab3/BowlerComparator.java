package edu.monmouth.lab3;

import java.util.Comparator;

//11. Create a class named BowlerComparator (in package edu.monmouth.lab3) that implements the Comparator interface. 
public class BowlerComparator implements Comparator<Competitor>{
	
	@Override //Define the compare() method such that scores are ordered opposite of Competitor’s natural ordering:
	public int compare(Competitor o1, Competitor o2) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		if(o1.getScore() == o2.getScore()) {
			return EQUAL;
		}
		if(o2.getScore() < o1.getScore()) {
			return BEFORE;
		}
		else {
			return AFTER;
		}
	}

}
