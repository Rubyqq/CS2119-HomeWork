package Mengyi_HW3;

import java.util.GregorianCalendar;

/**
 * Class Appointment that extend from Event
 * @author Mengyi, Emily
 *
 */
public class Appointment extends Event {
	private String appointmentType;
	
	/**
	 * 
	 * @param contact gives information of the contact
	 * @param dateAndtime gives the information of the date of the contact making the appointment
	 * @param appointmentType gives the information of the type of appointment
	 */
	public Appointment(Contact contact, GregorianCalendar dateAndtime, String appointmentType){
		super(contact, dateAndtime);
		this.appointmentType = appointmentType;
	}
	
	/**
	 * 
	 * @return gives the type of the appointment
	 */
	public String getType(){
		return this.appointmentType;
	}
	
	/**
	 * make the appointment type to sting type
	 */
	public String toString(){
		return super.toString()+appointmentType;
		
	}
	

}
