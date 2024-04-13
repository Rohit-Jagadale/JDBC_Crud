package com.JDBCModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student {
	int studId;
	String studName;
	String email;
	double percentage;
	String grade;
	static Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);

	
	public static Connection getConn()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractice","root","Rohit@1410");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public void insertData() {
		
		try {
			
			getConn();
			
			System.out.print("Enter Student Id : ");
			studId=sc.nextInt();
			System.out.print("Enter Student Name : ");
			sc.nextLine();
			studName=sc.next();
			System.out.print("Enter Student Email : ");
			email=sc.next();
			System.out.print("Enter Percentage : ");
			percentage=sc.nextDouble();
			System.out.print("Enter Grade : ");
			grade=sc.next();
			
			String query = "insert into student values(?,?,?,?,?)";
			ps=conn.prepareStatement(query);
			ps.setInt(1, studId);
			ps.setString(2, studName);
			ps.setString(3, email);
			ps.setDouble(4, percentage);
			ps.setString(5, grade);
			
			int save=ps.executeUpdate();
			if(save>0)
			{
				System.out.println("**************************************");
				System.out.println("Record Save Successfully...");
				System.out.println("**************************************");
			}
			else {
				System.out.println("Record Save failed...");
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readData()
	{
		try {
			getConn();
			
			String query = "Select * from student";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getString(5));
			}
			System.out.println("*************************************");
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateData() {
		try {
			getConn();
			
			System.out.print("Enter Student Id : ");
			studId=sc.nextInt();
			System.out.print("Enter Student Name : ");
			sc.nextLine();
			studName=sc.next();
			System.out.print("Enter Student Email : ");
			email=sc.next();
			System.out.print("Enter Percentage : ");
			percentage=sc.nextDouble();
			System.out.print("Enter Grade : ");
			grade=sc.next();
			
			String query = "update student set studName=?, email=?, percentage=?, grade=? where studId=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, studName);
			ps.setString(2, email);
			ps.setDouble(3, percentage);
			ps.setString(4, grade);
			ps.setInt(5, studId);
			
			int update=ps.executeUpdate();
			if(update>0)
			{
				System.out.println("**************************************");
				System.out.println("Update Data Successfully...");
				System.out.println("**************************************");
			}
			else {
				System.out.println("Update failed");
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData() {
		try {
			getConn();
			
			System.out.print("Enter Student Id : ");
			studId=sc.nextInt();
			
			String query = "delete from student where studId=?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, studId);
			
			int delete = ps.executeUpdate();
			if(delete>0) {
				System.out.println("**************************************");
				System.out.println("Data Delete Successfully...");
				System.out.println("**************************************");
			}
			else {
				System.out.println("Data Delete Failed...");
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exitStudent()
	{
		try {
			System.out.println("Thank You For Visiting...");
			System.out.println("**************************************");
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
