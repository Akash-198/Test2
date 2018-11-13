package com.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demoadd {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/capsv4_db?user=Akash&password=mysql";
			con=DriverManager.getConnection(url);
			
			con.setAutoCommit(false);
			String sql="insert into emp_info values(?,?,?,?)";
			Scanner in=new Scanner(System.in);
			String option="";
			pstmt=con.prepareStatement(sql);
			while(true) {
				System.out.println("enter id");
				int id=Integer.parseInt(in.nextLine());
				System.out.println("enter the name");
				String name=in.nextLine();
				System.out.println("enter the email");
				String email=in.nextLine();
				System.out.println("enter the salary");
				int salary=Integer.parseInt(in.nextLine());
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, email);
				pstmt.setInt(4, salary);
				pstmt.addBatch();
				
				int[] count=pstmt.executeBatch();
				option=in.nextLine();
				if(option.equalsIgnoreCase("exit"))
				{
					break;
				}
				
			}
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
