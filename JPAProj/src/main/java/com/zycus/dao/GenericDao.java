package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.zycus.entity.Customer;
import com.zycus.util.JPAUtil;

public class GenericDao {

	public void add(Object object) {
		//Step 1. Create/Obtain EntityManagerFactory object
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		//Step 2. Create/Obtain EntityManager object
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//Step 3. Start/Participate in a Transaction
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		//Now we can insert/update/delete/select whatever we want
		entityManager.persist(object); //persist method generates insert query
		
		tx.commit();
		entityManager.close();
	}
	
	public void update(Object object) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		entityManager.merge(object); //merge method generates update query
		
		tx.commit();
		entityManager.close();
	}
	
	public void remove(Class clazz, Object id) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		Object object = entityManager.find(clazz, id);
		entityManager.remove(object); //remove method generates delete query
		
		tx.commit();
		entityManager.close();
	}

	public <E> E fetchById(Class<E> clazz, Object id) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			//get method generates select query
			E e = entityManager.find(clazz, id);
			return e;
		}
		finally {
			entityManager.close();
		}
	}
	
	
	public <E> List<E> fetchAll(Class<E> clazz) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select o from "+clazz.getName()+" as o";
		Query query = entityManager.createQuery(jpql); //JPQL
		try {
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}
}












