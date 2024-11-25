package com.std;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	
	
	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projects","postgres","1234567");
	
			PreparedStatement ps = con.prepareStatement("update student set grade = ? where id = ?");
			
			System.out.println("Enter the id of the student needed to update");
			ps.setInt(2, sc.nextInt());
			sc.nextLine();
			
			System.out.println("Enter the grade ");
			ps.setString(1,sc.nextLine());


			int result = ps.executeUpdate();
			
			if(result > 0)
			{
				System.out.println("Data updated");
			}
			else
			{
				System.out.println("Data not updated");
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


