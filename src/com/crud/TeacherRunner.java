package com.crud;

import java.util.Scanner;

public class TeacherRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		TeacherDAO teacherDAO=TeacherDAOFactory.createTeacherDAO();
		System.out.println("Welcome to the software:-) ");
		while(true) {
			try {
				 int choice;
				 System.out.println("To insert query enter '1' ");
				 System.out.println("To fetch all record enter '2' ");
				 System.out.println("To update an existing record enter '3' ");
				 System.out.println("To delete record enter '4' ");
				 System.out.println("To rejoin a record enter '5' ");
				 System.out.println("To exist the programme enter '6' ");
				 System.out.println("-------------------------");
				
				 System.out.print("Enter your choice 1/2/3/4/5/6 ");
				 choice=sc.nextInt();
				 System.out.println("-------------------------");
				 switch(choice) {
				 case 1:
					 Teacher teacher=teacherDAO.input();
					 String result=teacherDAO.create(teacher);
					 System.out.println(result);
					 System.out.println("---------------------");
					 break;
				 case 2:
					 result=teacherDAO.fetchAll();
					 System.out.println(result);
					 break;
				 case 3:
					 System.out.println("Enter information of existing record only: ");
					 teacher=teacherDAO.input();
					 result=teacherDAO.update(teacher);
					 System.out.println(result);
					 break;
				 case 4:
					 System.out.print("Enter existing teacher id to delete: ");
					 int teachid=sc.nextInt();
					 result=teacherDAO.delete(teachid);
					 System.out.println(result);
					 break;
				 case 5:
					System.out.print("Enter teacher id to rejoin: ");
					int teachids=sc.nextInt();
					result=teacherDAO.rejoin(teachids);
					System.out.println(result);
					break;
				case 6:
					 System.out.println("(-:Thank you for using my software:-)");
					 System.exit(0);
					 break;
					 
				 }
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

	}

}
