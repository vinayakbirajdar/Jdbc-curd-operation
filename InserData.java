package com.std;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InserData {
	
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projects","postgres","1234567");
			System.out.println("Connection");
			
			PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?)");
			
			System.out.println("Enter the id of student");
			ps.setInt(1, sc.nextInt());
			sc.nextLine();
			
			System.out.println("enter the name of the student");
			ps.setString(2, sc.nextLine());
			
			System.out.println("Enter the student grade");
			ps.setString(3, sc.nextLine());
			
			ps.execute();
			
			System.out.println("Data inserted !!!");

			
		}
		catch(SQLException s)
		{
			s.fillInStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.fillInStackTrace();
		}
	}

}
