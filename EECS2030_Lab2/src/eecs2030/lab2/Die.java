package eecs2030.lab2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


/*
 * NOTE TO STUDENTS: 
 * The constructor that you need to complete can be found on line 47.
 * 
 * The two methods you need to complete can be found at the end of this file.
 */



public class Die implements Comparable<Die> {

	/**
	 * A random number generator to simulate rolling the die.
	 * DO NOT CHANGE THE DECLARATION OF rng. THE UNIT TESTS RELY
	 * ON BEGIN ABLE TO ACCESS THE RANDOM NUMBER GENERATOR.
	 */
	Random rng = new Random();
	
	/**
	 * The array of face values.
	 */
	private int[] faces;
		
	/**
	 * The current value of the die.
	 */
	private int value;
	
	/**
	 * The number of faces on a die.
	 */
	public static int NUMBER_OF_FACES = 6;
	

	/*
	 * You need to implement the no-argument constructor below, and the
	 * methods compareTo and equals found at the end of the class.
	 */
	
	public Die() {
		
	}
	

	private static boolean isInAscendingOrder(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}
		return true;
	}
	

	public Die(int[] faces) {
		if (faces.length != 6) {
			throw new IllegalArgumentException();
		}
		if (!Die.isInAscendingOrder(faces)) {
			throw new IllegalArgumentException();
		}
		this.faces = Arrays.copyOf(faces, NUMBER_OF_FACES);
		this.value = this.faces[0];
	}
	

	public void setValueToFace(int face) {
		if (face < 0 || face >= NUMBER_OF_FACES) {
			throw new IllegalArgumentException();
		}
		this.value = this.faces[face];
	}
	

	public int value() {
		return this.value;
	}
	

	public int roll() {
		int idx = rng.nextInt(Die.NUMBER_OF_FACES);
		this.value = this.faces[idx];
		return this.value;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(this.value, this.faces);
	}

	
	/*
	 * You need to implement the compareTo and equals methods below.
	 * 
	 */
	
	@Override
	public int compareTo(Die other) {
		
	}
	

	@Override
	public boolean equals(Object obj) {
		// The method Arrays.equals may be useful for helping
		// to implement this method.
		
	}
	

}
