package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. 
 * A piggy bank owns a collection (or possibly collections) of coins,
 * but does not own the coins themselves.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins
 * from the piggy bank.
 */
public class OwnedPiggyBank {
	// YOU NEED TO ADD A FIELD OR FIELDS TO STORE THE COINS
	
	
	private List<Coin> coins;
	private Owner owner;

	/**
	 * Initializes this piggy bank so that it has the specified owner
	 * and no coins.
	 * 
	 * @param owner
	 *            the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		this.coins = new ArrayList<Coin>();
		this.owner = owner;
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy
	 * bank will have the same owner and the same number and type of coins as
	 * the other piggy bank.
	 * 
	 * @param other
	 *            the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
		this.coins = new ArrayList<>(other.coins);
		this.owner = other.owner;
	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {
		return this.owner;
	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins
	 *            a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {
		for(Coin c : coins)
			this.coins.add(c);
		System.out.println(coins.toString() + " " + this.coins.toString());
	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin
	 *            a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {
		for(Coin c : coins)
			if(c.equals(coin))
				return true;
		return false;
	}

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value
	 * of the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank,
	 * then the coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user
	 *            the person trying to remove the coin
	 * @param coin
	 *            a coin
	 * @return a coin equal to the value of the specified coin from this piggy
	 *         bank, or null if user is not the owner of this piggy bank
	 * @pre. the piggy bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {
		if( !user.equals(this.owner))
			return null;
		for(Coin c : coins) {
			if(c.equals(coin))
				coins.remove(c);
				return c;
		}
		return null;
	}

	/**
	 * Allows the owner of this piggy bank to remove
	 * the smallest number of coins whose total value in cents is equal
	 * to the specified value in cents from this piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to
	 * the owner of this piggy bank.
	 * 
	 * @param user
	 *            the person trying to remove coins from this piggy bank
	 * @param value
	 *            a value in cents
	 * @return the smallest number of coins whose total value in cents is equal
	 *         to the specified value in cents from this piggy bank 
	 * @pre. the piggy bank contains a group of coins whose total value is equal
	 *         to specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		List<Coin> removed = new ArrayList<>();
		if( !user.equals(this.owner))
			return removed;
		
		
		
		Collections.sort(this.coins);
		Collections.reverse(this.coins);
		System.out.println(this.coins.toString());
		for(Coin c : this.coins) {
			if(value >= c.getValue()) {
//				System.out.println(value + " " + c.getValue() + " " + removed.toString());
				value -= c.getValue();
				removed.add(c);
			}
		}
		for(Coin c : removed)
			this.coins.remove(c);

		return removed;
	}
	
	

	
	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list
	 * has its coins in sorted order (from smallest value to largest value;
	 * i.e., pennies first, followed by nickels, dimes, quarters, loonies, and
	 * toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {
		Collections.sort(this.coins);
		List<Coin> foo = new ArrayList<>();
		for (Coin c : this.coins) {
			Coin bar = new Coin(c);
			foo.add(bar);
		}
		return foo;
	}

	
	/**
	 * Counts the number of coins equal to the specified coin
	 * in this piggy bank.
	 * 
	 * <p>
	 * NOTE TO STUDENTS: You should create a private static 
	 * helper method that recursively counts the number of 
	 * coins in a specified list, array, or map depending on
	 * how you chose to implement the piggy bank. This method
	 * should then call the recursive method to get the required
	 * count.
	 * 
	 * @param coin a coin
	 * @return the number of coins equal to the specified coin
	 * in this piggy bank
	 */
	public int numberOf(Coin coin) {
		// YOU SHOULD MAKE A PRIVATE RECURSIVE HELPER METHOD AND CALL 
		// THE HELPER METHOD
		
		return numberOfHelper(0,this.coins,coin);
	}
	
	private static int numberOfHelper(int n, List<Coin> coins, Coin coin) {
		if(n == coins.size()) 
			return 0;
		
		if (coin.equals(coins.get(n)))
			return 1+numberOfHelper(n+1, coins, coin);
		return numberOfHelper(n+1, coins, coin);
	}
	
	// ADD A PRIVATE STATIC HELPER METHOD HERE
	
	
	
}
