package Mengyi_HW3;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Create class named Meeting extends from Event
 * @author Mengyi
 *
 */
public class Meeting extends Event{
	private ArrayList<String>attendees;
	
	/**
	 * 
	 * @param contact gives the contact information of the person who made the appointment
	 * @param dateAndtime gives the date information of the meeting
	 */
	public Meeting(Contact contact, GregorianCalendar dateAndtime){ 
		super(contact, dateAndtime);
		attendees = new ArrayList<String>();
	}
	
	/**
	 * This method add attendees to a meeting
	 * @param AttendeeName
	 */
	
	public void addAttendee(String attendeeName){
		attendees.add(attendeeName);
	}
	
	/**
	 * 
	 * @return This method return the array list with attendees in the array list
	 */
	
	public ArrayList<String> getAttendees(){
		return attendees;
	}
}
