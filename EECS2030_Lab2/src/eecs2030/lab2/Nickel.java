package eecs2030.lab2;

public class Nickel implements Comparable<Nickel> {
 	

	/** A class representing a Canadian nickel. The monetary value of nickel is defined to be five cents. Nickels were first minted in the year 1858. A nickel has an issue year which is the year in which the nickel was issued by the mint. */
	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;
	
	public Nickel(int year) {
		if (year < 1858) {
			throw new IllegalArgumentException();
		} else {
			this.year = year;
		}
	}

	public int issueYear() {
		return this.year;
	}

	public int compareTo(Nickel other) {
		return (this.year - other.year);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if(obj == null)
			return false;
		else if(obj.getClass() != this.getClass())
			return false;
		else
			return true;
	}

	public int hashCode() {
		return issueYear();
	}
}
