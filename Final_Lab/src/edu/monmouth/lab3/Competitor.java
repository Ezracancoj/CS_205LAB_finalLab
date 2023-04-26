package edu.monmouth.lab3;

public class Competitor implements Comparable<Competitor>{
	private String name;
	private int score;
	
	public Competitor(String name, int score) {
		setName(name);
		setScore(score);
	}

	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	private void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public boolean equals(Object other){
		boolean isEqual = true;
		if(other == null) {
			return false;
		}
		if(!(other instanceof Competitor)) {
			return false;
		}
		Competitor obj = (Competitor) other;
		
		if(obj.score != obj.score) {
			isEqual = false;
		}
		return isEqual;
	}
	@Override public String toString() {
		return "Competitor[Name="+name+" Score="+score+"]";
	}


	@Override
	//Note: Only the score attribute needs to be included in the equals() and compareTo() methods
	public int compareTo(Competitor other) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		if(other.score == this.score) {
			return EQUAL;
		}
		if(other.score > this.score) {
			return BEFORE;
		}
		else {
			return AFTER;
		}
	}

}
