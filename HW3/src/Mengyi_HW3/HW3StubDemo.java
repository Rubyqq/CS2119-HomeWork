package Mengyi_HW3;

import java.util.GregorianCalendar;
import java.util.ArrayList;


public class HW3StubDemo {
	
	/**
	 * This is the main method used to test the functions in each class. 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		/* This program checks the syntax of your constructors and methods.
		 * Your classes MUST compile with this program, with no errors.
		 * Do not change any of the code in this program.
		 */
		
		// check constructors
		Contact glynis = new Contact("Glynis", 8315252);
		Contact glyni = new Contact("Glyni", 8315252);
		GregorianCalendar today = new GregorianCalendar(2016, 11, 10, 16, 0);
		GregorianCalendar yesterday = new GregorianCalendar(2016, 10, 10, 16, 0);
		Meeting m = new Meeting(glynis, today);
		Appointment a = new Appointment (glynis, today, "office hour");
		Appointment b = new Appointment (glyni, yesterday, "office hour");
		AppointmentBook book = new AppointmentBook();
		
		// check Contact methods
		String name = glynis.getName();
		int phoneNum = glynis.getPhone();
		name = glynis.toString();
		
		// check Appointment methods
		name = a.getType();
		name = a.toString();
		
		// check Meeting methods
		m.addAttendee("Joe");
		ArrayList<String> people = m.getAttendees();
		name = m.toString();
		
		// check AppointmentBook methods
		book.addEvent(a);
		book.addEvent(m);
		book.addEvent(b);
		//System.out.print(book.getEventsForDate().size());
		ArrayList<Event> todaysEvents = book.getEventsForDate(today);
		System.out.println(todaysEvents);
		
		
		System.out.println("Compiles OK");
	

	}

}



