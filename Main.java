import java.sql.*;
import java.util.Scanner;

public class Main {
	static Connection conn=null;
	public static void main(String args[]) throws Exception {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/ffahid";
			String username="ffahid";
			String password="samantha";
			conn=DriverManager.getConnection(jdbcURL,username,password);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		Information_Processing IP = new Information_Processing(conn);
		/*
		Medical_Record mr=new Medical_Record(conn);
		Reports r=new Reports(conn);
		Billing_func b=new Billing_func(conn);
		System.out.println("Select an option");
		*/
		System.out.println("1.Information Processing\n2.Reports\n3.Medical_Record\n4.Billing\n0.end");
		Scanner reader = new Scanner(System.in);
		int input=0;
		input=reader.nextInt();
		while(true) {
			if(input==0) {
				System.out.println("Thank you for using the service");
				break;
			}
		switch(input) {
		case 1:
			IP.menu();
			break;
		/*
		case 2:
			r.mymenu();
			break;
		case 3:
			mr.menu();
			break;
		case 4:
			b.billing_menu();
			break;
			*/
		}
		System.out.println("\n\n\nSelect an option");
		System.out.println("1.Information Processing\n2.Reports\n3.Services\n4.Billing\n0.end\n");
			if (reader.hasNextInt())
				input = reader.nextInt();
		}
		IP.close();
		/*
		r.close();
		b.close();
		mr.close();
		*/
		reader.close();
	}
}