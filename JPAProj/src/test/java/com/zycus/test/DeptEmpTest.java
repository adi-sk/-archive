package com.zycus.test;

import org.junit.Test;

import com.zycus.dao.GenericDao;
import com.zycus.entity.Department;
import com.zycus.entity.Employee;

public class DeptEmpTest {

	@Test
	public void addDept() {
		Department d1 = new Department();
		d1.setDeptno(10);
		d1.setName("HR");
		d1.setLocation("Seepz");

		Department d2 = new Department();
		d2.setDeptno(20);
		d2.setName("IT");
		d2.setLocation("Powai");

		GenericDao dao = new  GenericDao();
		dao.add(d1);
		dao.add(d2);
	}

	@Test
	public void addEmp() {
		GenericDao dao = new  GenericDao();
		Department dept = dao.fetchById(Department.class, 10);
		
		Employee emp = new Employee();
		emp.setEmpno(1001);
		emp.setName("Majrul");
		emp.setSalary(9999);
		emp.setDepartment(dept);
		
		
		dao.add(emp);
	}

	@Test
	public void addEmp2() {
		GenericDao dao = new  GenericDao();
		Department dept = dao.fetchById(Department.class, 10);
		
		Employee emp = new Employee();
		emp.setEmpno(1001);
		emp.setName("Majrul");
		emp.setSalary(9999);
		//emp.setDepartment(dept);
		dept.getEmployees().add(emp);
		
		dao.update(dept);
	}

	
}
