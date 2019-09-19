package eecs2030.lab2;

import java.util.Objects;

/*
 * NOTE TO STUDENTS: The four methods you need to complete can 
 * be found at the end of this file.
 */

public class Domino implements Comparable<Domino> {

	/**
	 * The smallest possible value for a side of a domino.
	 */
	public static final int MIN_VALUE = 0;

	/**
	 * The largest possible value for a side of a domino.
	 */
	public static final int MAX_VALUE = 6;

	/**
	 * The two values on the domino.
	 */
	private int val1;
	private int val2;

	public Domino() {
		this(0, 0);
	}

	public Domino(int value1, int value2) {
		if (!isValueOK(value1) || !isValueOK(value2)) {
			throw new IllegalArgumentException();
		}
		this.val1 = value1;
		this.val2 = value2;
	}

	public Domino(Domino other) {
		this(other.val1, other.val2);
	}

	private static boolean isValueOK(int value) {
		return value >= MIN_VALUE && value <= MAX_VALUE;
	}

	@Override
	public int hashCode() {
		return this.getSmallerValue() + 11 * this.getLargerValue();
	}

	@Override
	public String toString() {
		return "[" + this.getSmallerValue() + " : " + this.getLargerValue() + "]";
	}

	/*
	 * You need to implement the four methods below. Both compareTo and equals
	 * should make use of getSmallerValue and getLargerValue.
	 */

	public int getSmallerValue() {
		return this.val1 <= this.val2 ? val1 : val2;
	}

	public int getLargerValue() {
		return this.val1 >= this.val2 ? val1 : val2;
	}

	@Override
	public int compareTo(Domino other) {
		if (other.getSmallerValue() == this.getSmallerValue()) {
			if (other.getLargerValue() == this.getLargerValue())
				return 0;
			else if (other.getLargerValue() > this.getLargerValue())
				return -1;
			else if (other.getLargerValue() < this.getLargerValue())
				return 1;
		} else if (other.getSmallerValue() > this.getSmallerValue())
			return -1;
		else if (other.getSmallerValue() < this.getSmallerValue())
			return 1;
		return 1;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		// null check
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domino domino = (Domino) obj;
		return (Objects.equals(val1, domino.val1) && Objects.equals(val2, domino.val2))
				|| (Objects.equals(val1, domino.val2) && Objects.equals(val2, domino.val1));
	}

}