package com.std;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projects","postgres","1234567");
			
			PreparedStatement ps = con.prepareStatement("delete from student where id = ?");
			
			System.out.println("Enter the id of the student to be deleted");
			ps.setInt(1,sc.nextInt());
			
			int result = ps.executeUpdate();
			
			if(result > 0)
			{
				System.out.println("Data deleted");
			}
			else
			{
				System.out.println("Data not deleted");
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
