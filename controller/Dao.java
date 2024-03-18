package com.auca.controller;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.auca.model.*;

public class Dao {
	
	private String url = "jdbc:mysql://localhost:3306/course";
	private String uname = "root";
	private String password = "ISI@S*ck";
	
	public ResultSet studentPerSemester(Semester sem) {
		try {
			
			Connection con = DriverManager.getConnection(url,uname,password);
			String sql = "select st.student_id,concat(st.first_name,' ',st.last_name) \r\n"
					+ "from student_registration sr\r\n"
					+ "join student st on st.student_id = sr.student_id\r\n"
					+ "join semester sm on sm.semester_id = sr.semester_id\r\n"
					+ "where sm.semester_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, sem.getSemester_id());
			ResultSet rs = st.executeQuery();
			return rs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet studentPerDepartmentAndSemester(Department dp, Semester sem) {
		
		try {
			
			Connection con = DriverManager.getConnection(url,uname,password);
			String sql = "select st.student_id,concat(st.first_name,' ',st.last_name),\r\n"
					+ "sm.semester_name,dp.name from student_registration sr\r\n"
					+ "join student st on st.student_id = sr.student_id\r\n"
					+ "join semester sm on sm.semester_id = sr.semester_id\r\n"
					+ "join department dp on dp.department_id = sr.department_id\r\n"
					+ "where dp.department_id = ? and sm.semester_id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, dp.getDepartment_id());
			st.setInt(2, sem.getSemester_id());
			ResultSet rs = st.executeQuery();
			return rs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet studentPerCourseAndSemester(Course c,Semester sem) {
		
		try {
			
			Connection con = DriverManager.getConnection(url,uname,password);
			String sql = "select st.student_id,concat(st.first_name,' ',st.last_name),\r\n"
					+ "sm.semester_name,c.course_name from student_registration sr\r\n"
					+ "join student st on st.student_id = sr.student_id\r\n"
					+ "join semester sm on sm.semester_id = sr.semester_id\r\n"
					+ "join course c on sr.semester_id = c.semester_id and sr.department_id = c.department_id\r\n"
					+ "where sm.semester_id = ? and c.course_id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, sem.getSemester_id());
			st.setInt(2, c.getCourse_id());
			ResultSet rs = st.executeQuery();
			
			return rs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public ResultSet coursePerDepartmentAndSemester(Department dp, Semester sem) {
		
		try {
			
			Connection con = DriverManager.getConnection(url,uname,password);
			String sql = "select c.course_name,sm.semester_name , dp.name from course c\r\n"
					+ "join semester sm on c.semester_id = sm.semester_id\r\n"
					+ "join department dp on dp.department_id = c.department_id\r\n"
					+ "where sm.semester_id = ? and dp.department_id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(2, dp.getDepartment_id());
			st.setInt(1, sem.getSemester_id());
			ResultSet rs = st.executeQuery();
			
			return rs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet coursePerStudent(Student stu) {
		
		try {
			
			Connection con = DriverManager.getConnection(url,uname,password);
			String sql = "select concat(st.first_name,' ',st.last_name),\r\n"
					+ "sm.semester_name,c.course_name from student_registration sr\r\n"
					+ "join student st on st.student_id = sr.student_id\r\n"
					+ "join semester sm on sm.semester_id = sr.semester_id\r\n"
					+ "join course c on sr.semester_id = c.semester_id and sr.department_id = c.department_id\r\n"
					+ "where st.student_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, stu.getID());
			ResultSet rs = st.executeQuery();
			
			return rs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
			

}
