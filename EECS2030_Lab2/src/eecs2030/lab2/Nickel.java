package eecs2030.lab2;

public class Nickel implements Comparable<Nickel> {

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
		if (obj == null)
			return false;
		if (obj.getClass() != getClass())
			return false;
		Nickel nickel = (Nickel) obj;
		return (CENTS == nickel.CENTS);
	}

	public int hashCode() {
		return issueYear();
	}
}
