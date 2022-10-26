package com.crud;

import java.sql.*;
import java.util.*;

public class TeacherDAOImpl implements TeacherDAO {

	String driver="com.mysql.cj.jdbc.Driver";
	String dburl="jdbc:mysql://localhost:3306/mydb";
	String username="root";
	String password="";
	private Connection con=null;
	void createConnection() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl, username, password);
			System.out.println("Connection established with database!!!!");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	@Override
	public String create(Teacher teacher) {
		String result="";
		try {
			createConnection();
			String query="insert into teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, teacher.getTeacherid());
			ps.setString(2, teacher.getFname());
			ps.setString(3, teacher.getLname());
			ps.setString(4, teacher.getGender());
			ps.setString(5, teacher.getAddress());
			ps.setString(6, teacher.getCity());
			ps.setString(7, teacher.getPin());
			ps.setString(8, teacher.getMobileno());
			ps.setString(9, teacher.getQualification());
			ps.setString(10, teacher.getDesignation());
			ps.setString(11, teacher.getSpecialization());
			ps.setString(12, teacher.getBithdate());
			ps.setString(13, teacher.getJoiningdate());
			ps.setString(14, "Active");
			int res=ps.executeUpdate();
			result=res+" record/s successfully inserted into teacher table";
			ps.close();
			con.close();
		}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	}
	@Override
	public String fetchAll() {
		String result="";
		try {
			createConnection();
			String query="select * from teacher "
					+ " where "
					+ " currentstatus='Active' ";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next()==true) {
				for(int i=1;i<=14;i++) {
					result+=rs.getString(i)+"\t";
				}
				result+="\n";
			}
			rs.close();
			con.close();
		}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	}
	@Override
	public Teacher input() {
		Teacher teacher=new Teacher();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Teacher's first name: ");
		teacher.setFname(sc.nextLine());
		
		System.out.print("Enter Teacher's last name: ");
		teacher.setLname(sc.nextLine());
		
		System.out.print("Enter Teacher's gender: ");
		teacher.setGender(sc.nextLine());

		System.out.print("Enter Teacher's address: ");
		teacher.setAddress(sc.nextLine());
		
		System.out.print("Enter Teacher's city: ");
		teacher.setCity(sc.nextLine());
		
		System.out.print("Enter Teacher's pin: ");
		teacher.setPin(sc.nextLine());
		
		System.out.print("Enter Teacher's mobile number: ");
		teacher.setMobileno(sc.nextLine());
		
		System.out.print("Enter Teacher's Qualification: ");
		teacher.setQualification(sc.nextLine());
		
		System.out.print("Enter Teacher's designation: ");
		teacher.setDesignation(sc.nextLine());
		
		System.out.print("Enter Teacher's specialization: ");
		teacher.setSpecialization(sc.nextLine());
		
		System.out.print("Enter Teacher's birth date: ");
		teacher.setBithdate(sc.nextLine());
		
		System.out.print("Enter Teacher's joining date: ");
		teacher.setJoiningdate(sc.nextLine());
		
		System.out.print("Enter Teacher's id: ");
		teacher.setTeacherid(sc.nextInt());
		
		return (teacher);
	}
	@Override
	public String update(Teacher teacher) {
		String result="";
		try {
			createConnection();
			String query="update teacher set "
					+ "fname=?, "
					+ "lname=?, "
					+ "gender=?, "
					+ "address=?, "
					+ "city=?, "
					+ "pin=?, "
					+ "mobileno=?, "
					+ "qualification=?, "
					+ "designation=?, "
					+ "specialization=?, "
					+ "birthdate=?, "
					+ "joiningdate=?,"
					+ "currentstatus=? "
					+ "where "
					+ "teacherid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, teacher.getFname());
			ps.setString(2, teacher.getLname());
			ps.setString(3, teacher.getGender());
			ps.setString(4, teacher.getAddress());
			ps.setString(5, teacher.getCity());
			ps.setString(6, teacher.getPin());
			ps.setString(7, teacher.getMobileno());
			ps.setString(8, teacher.getQualification());
			ps.setString(9, teacher.getDesignation());
			ps.setString(10, teacher.getSpecialization());
			ps.setString(11, teacher.getBithdate());
			ps.setString(12, teacher.getJoiningdate());
			ps.setString(13, "Active");
			ps.setInt(14, teacher.getTeacherid());
			int res=ps.executeUpdate();
			result=res+" record/s successfully updated in teacher table";
			ps.close();
			con.close();
			
		}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	
	
	}
	@Override
	public String delete(int teacherid) {
		String result="";
		try {
			createConnection();
			
			String query="update teacher set "+
					" currentstatus='Close' "+
								" where teacherid=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, teacherid);
			int res=ps.executeUpdate();
			result=res+" record/s sucessfully deleted from teacher table";
			
			ps.close();
			con.close();
			
		}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	
	
	}
	@Override
	public String rejoin(int teacherid) {
		String result="";
		try {
			createConnection();
			String query="update teacher set "
					+ "currentstatus='Active' "
					+ "where "
					+ "teacherid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, teacherid);
			int res=ps.executeUpdate();
			result=res+" record/s successfully rejoined from teacher table";
			ps.close();
			con.close();
			
		}
		catch(Exception e) {
			result=e.toString();
		}
		return result;
	
	
	}
}


	


