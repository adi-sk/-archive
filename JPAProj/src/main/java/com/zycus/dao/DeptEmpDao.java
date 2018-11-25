package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.zycus.entity.Department;
import com.zycus.entity.Employee;
import com.zycus.util.JPAUtil;

public class DeptEmpDao extends GenericDao {

	//select * from emp
	public List<Employee> fetchAllEmployees() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> emp = criteria.from(Employee.class);
		criteria.select(emp);
		
		List<Employee> emps = entityManager.createQuery(criteria).getResultList();
		return emps;
	}

	public List<Object[]> fetchEmployeeNumberAndName() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		Root<Employee> emp = criteria.from(Employee.class);
		criteria.multiselect(emp.get("empno"),emp.get("name"));
		
		List<Object[]> emps = entityManager.createQuery(criteria).getResultList();
		return emps;
	}
	
	public List<Employee> fetchEmployeesBySalary(double salary) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> emp = criteria.from(Employee.class);
		criteria.select(emp);
		criteria.where(builder.ge(emp.<Double>get("salary"), salary));
		
		List<Employee> emps = entityManager.createQuery(criteria).getResultList();
		return emps;
	}
	
	//select * from emp where salary >= 10000 and name like 'M%'
	public List<Employee> fetchEmployeesBySalaryAndName(double salary, String namePattern) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> emp = criteria.from(Employee.class);
		criteria.select(emp);
		criteria.where(
				builder.and(
							builder.ge(emp.<Double>get("salary"), salary),
							builder.like(emp.<String>get("name"), "%"+namePattern+"%")));
		
		List<Employee> emps = entityManager.createQuery(criteria).getResultList();
		return emps;
	}
	
	public List<Employee> fetchEmployeesByDepartmentName(String deptName) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> emp = criteria.from(Employee.class);
		Join<Employee, Department> dept = emp.join("department", JoinType.INNER);
		
		criteria.select(emp);
		criteria.where(builder.equal(dept.<String>get("name"), deptName));
		
		List<Employee> emps = entityManager.createQuery(criteria).getResultList();
		return emps;
		
	}
}











