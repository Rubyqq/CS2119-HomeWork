package Mengyi_HW3;

import java.util.GregorianCalendar;

/**
 * This is the event class
 * @author Mengyi, Emily
 *
 */
public abstract class Event {
	private Contact contact;
	private GregorianCalendar dateAndtime;
	
	/**
	 * 
	 * @param contact gives the information of the contact
	 * @param dateAndtime gives the information of the date of the contact attend a event
	 */
	public Event(Contact contact, GregorianCalendar dateAndtime){
		this.contact = contact;
		this.dateAndtime= dateAndtime;
	}

	/**
	 * Gives the information of contact information and date information into a string type
	 */
	public String toString(){
		int year = dateAndtime.get(GregorianCalendar.YEAR);
		int month = dateAndtime.get(GregorianCalendar.MONTH);
		int dayOfMonth = dateAndtime.get(GregorianCalendar.DAY_OF_MONTH);
		int hourOfDay = dateAndtime.get(GregorianCalendar.HOUR_OF_DAY);
		int minute = dateAndtime.get(GregorianCalendar.MINUTE);
		
		return "Contact Information:" + this.contact+ " "+"Date Information: " + Integer.toString(year)+ " "+ Integer.toString(month) + " " + Integer.toString(dayOfMonth) + 
				" " + Integer.toString(hourOfDay) + " " + Integer.toString(minute);
	}
	
	/**
	 * 
	 * @return gives the contact information
	 */
	public Contact getContact(){
		return this.contact;
	}
	
	/**
	 * 
	 * @return Information of date of the event
	 */
	public GregorianCalendar getdateAndtime(){
		return this.dateAndtime;
	}
}
