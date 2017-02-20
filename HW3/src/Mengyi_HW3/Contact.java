package Mengyi_HW3;

/**
 * Create a class name Contact gives name and telephone number of each contact
 * @author Mengyi, Emily
 *
 */

public class Contact {
	private String name;
	private int telephoneNumber;
	
	/**
	 * 
	 * @param name gives the name of the contact
	 * @param telephoneNumber gives the telephone number of the contact
	 */
	public Contact(String name, int telephoneNumber){
		this.name = name;
		this.telephoneNumber = telephoneNumber;
	}
	
	/**
	 * this method gives name and telephone number into a string type
	 */
	public String toString(){
		
		return name + telephoneNumber;
		
	}
	
	/**
	 * 
	 * @return name of the contact
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * 
	 * @return telephone number of the contact
	 */
	public int getPhone(){
		return this.telephoneNumber;
	}
}
