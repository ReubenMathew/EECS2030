package test2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A bill that includes an itemized list of purchased items, the
 * date of purchase, and the total price of the bill.
 * The itemized bill and its list form a composition. 
 * The itemized bill and its date form a composition.
 * The total price of the bill is guaranteed to be equal to the sum
 * of the prices of the items in the bill.
 * 
 */
public class ItemizedBill {

	/**
	 * The date of purchase of this bill. 
	 */
	private Date date;
	
	/**
	 * The total price of this bill.
	 */
	private int total;
	
    /**
     * The list of items for this bill. 
     */
    private List<Item> items;
    
    /**
     * Initialize this bill so that it has the current date,
     * a total price of zero, and an empty list of items.
     */
    public ItemizedBill() {
    	date = new Date();
    	total = 0;
    	items = new ArrayList<Item>();
    	
    }
    
    /**
     * Initialize this bill from a list of purchased items. The total
     * price of the bill is computed as the sum of the prices of the
     * purchased items. The date of purchase is equal to the specified
     * date.
     * 
     * @param date the date for this bill
     * @param items a list of purchased items
     */
    public ItemizedBill(Date date, List<Item> items) {
    	this.date = (Date) date.clone();

    	List<Item> foo = new ArrayList<Item>();
    	for (Item i : items)
    		foo.add(i);
    	this.items = foo;
    	
    	for(Item i : items)
    		total += i.getPrice();
    }
    
    /**
     * Initialize this bill by copying another bill. The total
     * price of the bill, the date of purchase, and
     * the list of items purchased are all copied from the
     * other bill.
     * 
     * @param other the bill to copy
     */
    public ItemizedBill(ItemizedBill other) {
    	this.date = other.getDate();
    	this.items = other.getItems();
    	this.total = other.getTotal();
    }

    /**
     * Returns the list of items purchased for this bill.
     * The returned list cannot be used to modify this bill nor
     * the items in this bill.
     * 
     * @return the list of items purchased for this bill
     */
    public List<Item> getItems() {
    	List<Item> foo = new ArrayList<Item>();
    	for (Item i : this.items)
    		foo.add(i);
    	return foo;
    }
    
    /**
     * Add an item to the list of items purchased for this bill.
     * Modifying the item after adding it to the bill does not
     * affect the bill.
     * The total price of the bill is updated to include the price
     * of the added item.
     * 
     * @param item add an item to the list of items purchased for this bill
     */
    public void addItem(Item item) {
        this.items.add(item);   
        total += item.getPrice();
    }
    
    /**
     * Removes the specified item from the list and updates the total
     * price of the bill. Only one item is removed from the bill if
     * there are duplicate items equal to the specified item.
     * 
     * @param item the item to remove from this bill
     * @throws NoSuchElementException if this bill does not have the
     * specified item
     */
    public void removeItem(Item item) {
    	if (!this.items.contains(item))
    		throw new NoSuchElementException();
    	total -= item.getPrice();
    	this.items.remove(item);
    	
    }
    
    
    /**
     * Returns a copy of the most expensive item in this bill.
     * If there is more than one item that has the highest price
     * then a copy of any one of those items will be returned.
     * 
     * @return a copy of the most expensive item in this bill
     * @throws IllegalArgumentException if this bill has no items
     */
    public Item getMostExpensiveItem() {
    	// YOU MAY NOT MODIFY THIS METHOD
    	if (this.items.isEmpty()) {
    		throw new IllegalArgumentException();
    	}
    	return getMostExpensiveItem(this.items);
    }
    
    
    /**
     * Recursively searches the list <code>t</code> for the most expensive 
     * item. Returns a copy of the most expensive item in <code>t</code>. 
     * If there is more than one item that has the highest price
     * then a copy of any one of those items will be returned.
     * 
     * @param t a non-empty list of items
     * @return a copy of the most expensive item in t
     */
    private static Item getMostExpensiveItem(List<Item> t) {
    	Item champion = t.get(0);
    	for (Item challenger: t) {
    		if (challenger.getPrice() > champion.getPrice()) {
    			champion = challenger;
    		}
    	}
    	return new Item(champion.getDescription(),champion.getPrice());
    }
    
    
    /**
     * Returns a new date equal to the date of this bill.
     * 
     * @return a new date equal to the date of this bill
     */
    public Date getDate() {
    	
    	return (Date) date.clone();
    }

    /**
     * Returns the total price of this bill.
     * 
     * @return the total price of this bill
     */
    public int getTotal() {
    	
    	return this.total;
    }
  
}
