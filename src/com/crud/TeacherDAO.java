package com.crud;

public interface TeacherDAO {
	String create(Teacher teacher);
	String fetchAll();
	Teacher input();
	String update(Teacher teacher);
	String delete(int teacherid);
	String rejoin(int teacherid);
	

}
