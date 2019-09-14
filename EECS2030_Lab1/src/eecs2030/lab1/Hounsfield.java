package eecs2030.lab1;

/**
 * A class that represents a Hounsfield unit. Hounsfield units are the units of
 * measurement used in computed tomography (CT or CAT) scanning.
 * 
 * <p>
 * The Hounsfield scale is defined by specifying the radiodensity of air as
 * {@code -1000} Hounsfield units and the radiodensity of distilled water as
 * {@code 0} Hounsfield units. Adjacent tissues in the human body can be
 * distinguished from one another if their radiodensities differ; see
 * <a href="https://en.wikipedia.org/wiki/Hounsfield_scale">the Wikipedia
 * page</a> for a table of typical Hounsfield values for tissues of the human
 * body.
 * 
 * <p>
 * CT scanners for medical purposes typically restrict the value of reported
 * Hounsfield units to integers in the range {@code -1024} to {@code 3071} so
 * that a Hounsfield unit can be encoded as a 12-bit value. This class uses the
 * values {@code -1024} and {@code 3071} to represent the minimum and maximum,
 * respectively, allowable Hounsfield unit values.
 *
 */
public class Hounsfield {

	/**
	 * The integer value of this Hounsfield unit
	 */
	private int value;

	/**
	 * The minimum Hounsfield unit reported by medical CT scanners Look up the
	 * correct value in the documentation
	 */
	public static final int MIN_VALUE = -1024;

	/**
	 * The maximum Hounsfield unit reported by medical CT scanners Look up the
	 * correct value in the documentation
	 */
	public static final int MAX_VALUE = 3071;

	/**
	 * Initializes this Hounsfield unit to have a value of zero.
	 */
	public Hounsfield() {
		// A constructor should assign every non-static field a value.
		// Change the next line to assign the correct value to this.value
		// or use constructor chaining.
		//
		// Implement the get method before trying to run the JUnit test.
		// If you used constructor chaining you will also have to implement
		// the next constructor before running the JUnit test.
		this.value = 0;
	}

	/**
	 * Initializes this Hounsfield unit to have the specified value.
	 * 
	 * @param value the value of this Hounsfield unit
	 * @throws IllegalArgumentException if {@code value} is less than the minimum
	 *                                  Hounsfield unit reported by medical CT
	 *                                  scanners or greater than the maximum
	 *                                  Hounsfield unit reported by medical CT
	 *                                  scanners
	 */
	public Hounsfield(int value) {
		checkValue(value);
		this.value = value;

	}

	/**
	 * Initializes this Hounsfield unit by copying the value from the specified
	 * other Hounsfield unit.
	 * 
	 * @param other the Hounsfield unit to copy the value from
	 */
	public Hounsfield(Hounsfield other) {
		// Assign a value to this.value by copying other.value
		this.value = other.value;
	}

	/**
	 * Throws an {@code IllegalArgumentException} if the specified value is less
	 * than the minimum Hounsfield unit reported by medical CT scanners or greater
	 * than the maximum Hounsfield unit reported by medical CT scanners.
	 * 
	 * @param value a value to check
	 * @throws IllegalArgumentException if the specified value is less than the
	 *                                  minimum Hounsfield unit reported by medical
	 *                                  CT scanners or greater than the maximum
	 *                                  Hounsfield unit reported by medical CT
	 *                                  scanners.
	 */
	private static void checkValue(int value) {
		if ((value < MIN_VALUE) || (value > MAX_VALUE)) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns the value of this Hounsfield unit.
	 * 
	 * @return the value of this Hounsfield unit
	 */
	public int get() {
		// Change the next line to return the value of this.value

		return this.value;
	}

	/**
	 * Sets the value of this Hounsfield unit to the specified value returning the
	 * value that was overwritten.
	 * 
	 * @param value the value to set this Hounsfield unit to
	 * @return the overwritten value of this Hounsfield unit
	 * @throws IllegalArgumentException if the specified value is less than the
	 *                                  minimum Hounsfield unit reported by medical
	 *                                  CT scanners or greater than the maximum
	 *                                  Hounsfield unit reported by medical CT
	 *                                  scanners.
	 */
	public int set(int value) {
		int old = this.value;
		checkValue(value);
		this.value = value;
		return old;
	}

	/**
	 * Returns a string representation of this Hounsfield unit. The returned string
	 * is the numeric value of this Hounsfield unit (formatted as an integer)
	 * followed by a space followed by the string {@code "HU"}.
	 */
	@Override
	public String toString() {
		// Change the next line to return the approriate string
		String s = this.value + " HU";
		return s;
	}
}
