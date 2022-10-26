package com.crud;

public class TeacherDAOFactory {
	public static TeacherDAO createTeacherDAO() {
		return(new TeacherDAOImpl());
	}

}
