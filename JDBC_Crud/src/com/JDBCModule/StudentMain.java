package com.JDBCModule;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		
		int ch;
		Scanner sc = new Scanner(System.in);
		
		Student stud = new Student();
		
		do {
			System.out.println("1: Insert Student Data");
			System.out.println("2: Display Student Data");
			System.out.println("3: Update Student Data");
			System.out.println("4: Delete Student Data");
			System.out.println("5: Exit");
			System.out.println("Enter u r Choice");
			ch=sc.nextInt();
			System.out.println("**************************************");
			
			switch(ch)
			{
				case 1:
					stud.insertData();
					break;
					
				case 2:
					stud.readData();
					break;
					
				case 3:
					stud.updateData();
					break;
					
				case 4:
					stud.deleteData();
					break;
					
				case 5:
					stud.exitStudent();
					break;
					
				default :
					System.out.println("Enter the right choice for perform the operation");
				
			}
		}	
		while(ch<=5);
	}
}
