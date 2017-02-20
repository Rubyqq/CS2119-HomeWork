package Mengyi_HW3;

import java.util.ArrayList;


import java.util.GregorianCalendar;

/**
 * This is the class of AppointmentBook that manage event 
 * @author Mengyi, Emily
 *
 */

public class AppointmentBook {
	private ArrayList<Event>event;
	
	/**
	 * Constructor of the appointment book
	 */
	
	public AppointmentBook(){
		event = new ArrayList<Event>();
	}
	
	/**
	 * This method return void and add event e into appointment book
	 * @param Event 
	 */
	
	public void addEvent(Event e){
		for(Event x: event){
			if(x.getdateAndtime().equals(e.getdateAndtime())){
				return;
			}
		}
		event.add(e);
	} 
	
	/**
	 * 
	 * @param d
	 * @return return the arraylist with event with same date
	 */
	
	public ArrayList<Event> getEventsForDate(GregorianCalendar d){
		ArrayList<Event>eventWithSameDate = new ArrayList<Event>();
		for (Event x: event){
			if(x.getdateAndtime().equals(d)){
				eventWithSameDate.add(x);
			}
		}
		return eventWithSameDate;
	} 
	
	public int numEvents(){
		return this.event.size();
	}
	

}







