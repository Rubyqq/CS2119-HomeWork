package HW6;

//STEP 1. Import required packages
import java.sql.*;

public class HW6Starter {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://mysql.wpi.edu/";
	static final String DB_NAME = "small_gs_example";

	//  Database credentials

	static final String USER = "restricted_gs";  
	static final String PASS = "jMLuBo";  

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt;
		try{
			//STEP 2: Register JDBC driver
			//  IF AN EXCEPTION OCCURS HERE, MAKE SURE YOU'VE ADDED THE MYSQL 
			//  CONNECTOR FILE TO THE PROJECT'S BUILD PATH
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);

			
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM PARTICIPANT WHERE PARTICIPANT_NM = 'Amanda'";	
			String sql1 = "SHOW COLUMNS FROM MEETING";
			String sql2 = "SELECT MEETING_NM FROM MEETING, TIME_SLOT WHERE DAY_OF_WEEK = 'Monday' AND TIME_SLOT.MEETING_ID = MEETING.MEETING_ID";
			String sql3_1 = "SELECT COUNT(PARTICIPANT_NM), MEETING_NM FROM MEETING, PARTICIPANT, PARTICIPANT_MEETING_REL WHERE PARTICIPANT.PARTICIPANT_ID = 1105 AND MEETING.MEETING_ID ";
			String sql3_2 = " = PARTICIPANT_MEETING_REL.MEETING_ID AND PARTICIPANT_MEETING_REL.PARTICIPANT_ID = PARTICIPANT.PARTICIPANT_ID";
			String sql4_1 = "SELECT DISTINCT PARTICIPANT_NM, PARTICIPANT.PARTICIPANT_ID FROM PARTICIPANT, PARTICIPANT_MEETING_REL WHERE PARTICIPANT.PARTICIPANT_ID = PARTICIPANT_MEETING_REL.PARTICIPANT_ID AND ";
			String sql4_2 = " PARTICIPANT_MEETING_REL.IS_OWNER=1";
			String sql5_1 = "SELECT MEETING.MEETING_NM, PARTICIPANT.PARTICIPANT_NM FROM MEETING, PARTICIPANT, TIME_SLOT, PARTICIPANT_MEETING_REL ";
			String sql5_2 = " WHERE MEETING.MEETING_ID = PARTICIPANT_MEETING_REL.MEETING_ID AND PARTICIPANT.PARTICIPANT_ID = PARTICIPANT_MEETING_REL.PARTICIPANT_ID "; 
			String sql5_3 = " AND TIME_SLOT.MEETING_ID = MEETING.MEETING_ID AND TIME_SLOT.DAY_OF_WEEK = 'Tuesday' AND PARTICIPANT.PARTICIPANT_ID = 768";
			String sql6_1 = "UPDATE MEETING SET MEETING_NM = 'HAHA' WHERE MEETING_ID = 1081"; 
			String sql6_2 = "SELECT * FROM MEETING WHERE MEETING_ID = 1081";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
			String str = rs.getString("PARTICIPANT_NM");
			int id = rs.getInt("PARTICIPANT_ID");
			System.out.println("Participant " + str + " has ID " + id);
			}
			System.out.println("");
			
			System.out.println("PROBLEM 1: Column names for the MEETING relation");
			rs = stmt.executeQuery(sql1);
			while(rs.next()){
			String str = rs.getString(1);
			System.out.println(str);
			}
			System.out.println("");
			
			System.out.println("PROBLEM 2: Meeting names that are held on Monday");
			rs = stmt.executeQuery(sql2);
			while(rs.next()){
			String str = rs.getString("MEETING_NM");
			System.out.println("The columns in MEETING are: " + str);
			}
			System.out.println("");
			
			System.out.println("PROBLEM 3: Count the number of participants in the meeting with ID 1105");
			rs = stmt.executeQuery(sql3_1+sql3_2);
			while(rs.next()){
			int participants = rs.getInt(1);
			System.out.println(participants);
			}
			System.out.println("");
			
			System.out.println("PROBLEM 4: Display the names and IDs of all participants who run at least one meeting");
			rs = stmt.executeQuery(sql4_1+sql4_2);
			while(rs.next()){
			String str = rs.getString("PARTICIPANT_NM");
			int str1=rs.getInt("PARTICIPANT_ID");
			System.out.println("Participant name that run at least one meeting is: " + str);
			System.out.println("The ID of the participant is: " + str1);
			System.out.println("");
			}
			System.out.println("");
			
			System.out.println("PROBLEM 5: Display the names of all meetings that are held on Tuesday in which the particpant with ID 768 participates");
			rs = stmt.executeQuery(sql5_1+sql5_2+sql5_3);
			while(rs.next()){
			String str = rs.getString("MEETING_NM");
			String str1 = rs.getString("PARTICIPANT_NM");
			System.out.println("Meeting name is: " + str);
			System.out.println("Participant name is: " + str1);
			System.out.println("");
			}
			System.out.println("");
			
			System.out.println("PROBLEM 6: Change the name of the meeting that has ID 1081 and display all information of the meeting");
			int rs1 = stmt.executeUpdate(sql6_1);
			rs = stmt.executeQuery(sql6_2);
			while(rs.next()){
			int str = rs.getInt("MEETING_ID");	
			String str1 = rs.getString("MEETING_NM");
			int str2 = rs.getInt("FINAL_TIME_SLOT_ID");
			String str3 = rs.getString("STATE");
			System.out.println("Meeting ID is: " + str + " " + "name is: " + str1 + " " + "final time slot is: " + str2 + " " + "state is: " + str3);
			}
			System.out.println("");

			
			//STEP 5: Extract data from result set
			
		
		
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main

}
