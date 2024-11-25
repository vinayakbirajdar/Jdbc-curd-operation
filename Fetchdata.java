package com.std;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Fetchdata {
	
	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projects","postgres","1234567");
			System.out.println("Connection");
			
			Statement stm = con.createStatement();
			System.out.println("Statemenrt");
			
			ResultSet rs = stm.executeQuery("select * from Student");
			System.out.println("Resultset");
			
			while(rs.next())
			{
				System.out.println("Student id is: "+rs.getInt("id"));
				System.out.println("Student name is: "+rs.getString("name"));
				System.out.println("Student Grade is: "+rs.getString("grade"));
				
			}	
			
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
