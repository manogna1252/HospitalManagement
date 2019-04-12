//package jdbc_demo;

import java.sql.*;
import java.util.*;

/* this particular class deals with information processing mainly categorized as
 * insert/update/delete hotel/staff/room/customer
 */
public class Information_Processing {
	Connection conn;
	static PreparedStatement stmt;
	static ResultSet rs;
	static String str, str1,staff_name, job_title, dob, address, department, phone_number, gender;
	int action;
	int staff_id;
	static Scanner reader = new Scanner(System.in);
	static int input = 0;
	public Information_Processing(Connection conn) {
		try {
			this.conn = conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this close() function closed the result set, statement and connection
	public void close() {
		close(rs);
		close(stmt);
		close(conn);
	}

	public void menu() {
		// asking the user to choose from the list
		System.out.println("Information processing\n");
		System.out.println("Enter a number according to the list to perform that task:\n" + "1. Add a Staff member\n"
				+ "2.Update Staff details\n" + "3.Delete Staff Member\n");
		input = reader.nextInt();
		switch (input) {
		case 1:
			// enter a new location
			int staff_selection;
			System.out.println("New Staff Member:");
			System.out.println("Whom do you want to add?\n:");
			System.out.println("1. Doctor\n"
							+  "2. Nurse\n" 
							+  "3. Receptionist\n");
			staff_selection = reader.nextInt();
			System.out.println("Enter the following");
			reader.nextLine();
			System.out.println("staff_id\n: ");
			staff_id = reader.nextInt();
			System.out.println("staff_name\n: ");
			reader.nextLine();
			staff_name = reader.nextLine();
			System.out.println("dob in  YYYY-MM-DD\n: ");
			dob = reader.nextLine();
			System.out.println("Gender: ('male', 'female', 'other')?\n: ");
			gender = reader.nextLine();
			System.out.println("phone number\n: ");
			phone_number = reader.nextLine();
			System.out.println("address\n: ");
			address = reader.nextLine();
			switch (staff_selection){
				case 1: 
					String professional_title;
					//String department;
					String test_id;
					System.out.println("Enter the following");
					System.out.println("department\n: ");
					department = reader.nextLine();
					System.out.println("test_id the doctor can perform\n: ");
					test_id = reader.nextLine();
					System.out.println("professional_title\n: ");
					professional_title = reader.nextLine();
					str = "INSERT INTO Staff(staff_id, name, dob, gender, job_title, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
					str1 = "INSERT INTO Doctor(doctor_id, professional_title, department, test_id) VALUES (?, ? ,?, ?)";
					try {
					stmt = conn.prepareStatement(str);
					stmt.setInt(1, staff_id);
					stmt.setString(2, staff_name);
					stmt.setDate(3, java.sql.Date.valueOf(dob));
					stmt.setString(4, gender);
					stmt.setString(5, "Doctor");
					stmt.setString(6, phone_number);
					stmt.setString(7, address);
					action = stmt.executeUpdate();
					if (action == 1)
						System.out.println("inserted into staff table succesfully");
						action = 0;
					} 
					catch (SQLException e) {
						e.printStackTrace();
						System.out.println("staff table insert failed");
					}
					
					//insert into doctor table
					try {
					stmt = conn.prepareStatement(str1);
					stmt.setInt(1, staff_id);
					stmt.setString(2, professional_title);
					stmt.setString(3, department);
					stmt.setString(4, test_id);
					action = stmt.executeUpdate();
					if (action == 1)
						System.out.println("inserted into doctor table succesfully");
						action = 0;
					} 
					catch (SQLException e) {
						e.printStackTrace();
						System.out.println("doctor table insert failed");
					}
					
					
				break;
					//String department;
					System.out.println("Enter the following");
					System.out.println("department\n: ");
					department = reader.nextLine();
					str = "INSERT INTO Staff(staff_id, name, dob, gender, job_title, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
					str1 = "INSERT INTO Nurse(nurse_id, department) VALUES (?, ? )";
					try {
					stmt = conn.prepareStatement(str);
					stmt.setInt(1, staff_id);
					stmt.setString(2, staff_name);
					stmt.setDate(3, java.sql.Date.valueOf(dob));
					stmt.setString(4, gender);
					stmt.setString(5, "Nurse");
					stmt.setString(6, phone_number);
					stmt.setString(7, address);
					action = stmt.executeUpdate();
					if (action == 1)
						System.out.println("inserted into staff table succesfully");
						action = 0;
					} 
					catch (SQLException e) {
						e.printStackTrace();
						System.out.println("staff table insert failed");
					}
					
					//insert into nurse table
					try {
					stmt = conn.prepareStatement(str1);
					stmt.setInt(1, staff_id);
					stmt.setString(2, department);
					action = stmt.executeUpdate();
					if (action == 1)
						System.out.println("inserted into nurse table succesfully");
						action = 0;
					} 
					catch (SQLException e) {
						e.printStackTrace();
						System.out.println("nurse table insert failed");
					}
					
				break;
				
				case 3: 
					System.out.println("Enter the following");
					System.out.println("department\n: ");
					department = reader.nextLine();
					str = "INSERT INTO Staff(staff_id, name, dob, gender, job_title, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
					str1 = "INSERT INTO Receptionist(receptionist_id, department) VALUES (?, ? )";
					try {
					stmt = conn.prepareStatement(str);
					stmt.setInt(1, staff_id);
					stmt.setString(2, staff_name);
					stmt.setDate(3, java.sql.Date.valueOf(dob));
					stmt.setString(4, gender);
					stmt.setString(5, "Receptionist");
					stmt.setString(6, phone_number);
					stmt.setString(7, address);
					action = stmt.executeUpdate();
					if (action == 1)
						System.out.println("inserted into staff table succesfully");
						action = 0;
					} 
					catch (SQLException e) {
						e.printStackTrace();
						System.out.println("staff table insert failed");
					}
					
					//insert into receptionist table
					try {
					stmt = conn.prepareStatement(str1);
					stmt.setInt(1, staff_id);
					stmt.setString(2, department);
					action = stmt.executeUpdate();
					if (action == 1)
						System.out.println("inserted into receptionist table succesfully");
						action = 0;
					} 
					catch (SQLException e) {
						e.printStackTrace();
						System.out.println("receptionist table insert failed");
					}
				
				break;
				
			}
			break;
			
			//case 2:
				break;	
			}
		}
	}

	// to close the connection, statement, resultset
	static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Throwable whatever) {
			}
		}
	}

	static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Throwable whatever) {
			}
		}
	}

	static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Throwable whatever) {
			}
		}
	}

}