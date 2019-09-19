package eecs2030.lab2;

public class Nickel implements Comparable<Nickel> {

	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;
	
	public Nickel(int year) {
		if (year < 1858)
			throw new IllegalArgumentException();
		this.year = year;
	}

	public int issueYear() {
		return this.year;
	}
	
	public int compareTo(Nickel other) {
		return (other.year-this.year);
	}
	
	public boolean equals(Object obj) {
		return true;
	}

	public int hashCode() {
		return issueYear();
	}
}
