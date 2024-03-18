package com.auca.view;

import static org.junit.Assert.*;

import org.junit.Test;
import com.auca.controller.Dao;
import com.auca.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class DaoTest {

//	@Test
//	public void coursePerDepartmentAndSemesterTest() throws SQLException {
//		Dao course = new Dao();
//		Department dp = new Department();
//		Semester sm = new Semester();
//		Scanner sc = new Scanner(System.in);
//		int result = 0;
//		System.out.println("Enter Semester ID: ");
//		int semID = sc.nextInt();
//		System.out.println("Enter Department ID:");
//		int dpID = sc.nextInt();
//		sm.setSemester_id(semID);
//		dp.setDepartment_id(dpID);
//		ResultSet rs = course.coursePerDepartmentAndSemester(dp, sm);
//		if(rs.next()) {
//			result = 1;
//		}
//		assertEquals(result, 1);
//	}
//	
	@Test
	public void coursePerStudentTest() throws SQLException {
		Dao course = new Dao();
		Student st = new Student();
		Scanner sc = new Scanner(System.in);
		int result = 0;
		System.out.println("Enter Student ID: ");
		int stID = sc.nextInt();
		st.setID(stID);
		ResultSet rs = course.coursePerStudent(st);
		if(rs.next()) {
		result = 1;

		}
		assertEquals(result, 1);
	}

//	@Test
//	public void studentPerSemesterTest() throws SQLException {
//		Dao student = new Dao();
//		Scanner sc = new Scanner(System.in);
//		Semester sem = new Semester();
//		int result = 0;
//		System.out.println("Enter semester ID:");
//		int sem_ID = sc.nextInt();
//		sem.setSemester_id(sem_ID);
//		ResultSet rs = student.studentPerSemester(sem);
//		if (rs.next()) {
//			result = 1;
//		}
//		assertEquals(result, 1);
//	}

//	@Test
//	public void studentDepartmentAndSemesterTest() throws SQLException {
//		Dao student = new Dao();
//		Scanner sc = new Scanner(System.in);
//		Department dp = new Department();
//		Semester sem = new Semester();
//		int result = 0;
//		System.out.println("Enter semester ID:");
//		int sem_ID = sc.nextInt();
//		System.out.println("Enter Department ID");
//		int dpID = sc.nextInt();
//		sem.setSemester_id(sem_ID);
//		dp.setDepartment_id(dpID);
//		ResultSet rs = student.studentPerDepartmentAndSemester(dp, sem);
//		if (rs.next()) {
//		result = 1;
//		}
//		assertEquals(result, 1);
//	}

	@Test
	public void studentPerCourseAndSemesterTest() throws SQLException {
		Dao student = new Dao();
		Scanner sc = new Scanner(System.in);
		Course c = new Course();
		Semester sem = new Semester();
		int result = 0;
		System.out.println("Enter semester ID:");
		int sem_ID = sc.nextInt();
		System.out.println("Enter Course ID:");
		int cID = sc.nextInt();
		sem.setSemester_id(sem_ID);
		c.setCourse_id(cID);
		ResultSet rs = student.studentPerCourseAndSemester(c, sem);
		if (rs.next()) {
		result = 1;
		}
		assertEquals(result, 1);
	}

}
