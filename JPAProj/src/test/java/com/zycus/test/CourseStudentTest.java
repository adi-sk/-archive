package com.zycus.test;

import org.junit.Test;

import com.zycus.dao.GenericDao;
import com.zycus.entity.Course;
import com.zycus.entity.Student;

public class CourseStudentTest {

	@Test
	public void addFewCourses() {
		GenericDao dao = new GenericDao();
		Course c1 = new Course();
		c1.setName("Java");
		c1.setDuration(48);
		c1.setFees(4500);
		dao.add(c1);
		Course c2 = new Course();
		c2.setName(".NET");
		c2.setDuration(48);
		c2.setFees(4500);
		dao.add(c1);
	}

	@Test
	public void addFewStudents() {
		GenericDao dao = new GenericDao();
		Student s1 = new Student();
		s1.setName("Saurabh");
		s1.setAddress("Mumbai");
		dao.add(s1);
		
		Student s2 = new Student();
		s2.setName("Sonali");
		s2.setAddress("Mumbai");
		dao.add(s2);
	}
	
	@Test
	public void enrollAStudentForSomeCourse() {
		GenericDao dao = new GenericDao();
		Course c1 = dao.fetchById(Course.class, 1);
		Student s1 = dao.fetchById(Student.class, 1);
		//c1.getStudents().add(s1);
		//OR
		s1.getCourses().add(c1);
		dao.update(s1);
	}


}
