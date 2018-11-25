package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Repository //alternative for Component
@Transactional
public class CrudRepository { //create,read,update,delete

	@PersistenceContext
	private EntityManager entityManager;
	
	public void add(Object object) {
		entityManager.persist(object);
	}
	
	public void update(Object object) {
		entityManager.merge(object);
	}
	
	public void remove(Class clazz, Object id) {
		Object object = entityManager.find(clazz, id);
		entityManager.remove(object);
	}

	public <E> E fetchById(Class<E> clazz, Object id) {
		E e = entityManager.find(clazz, id);
		return e;
	}
	
	public <E> List<E> fetchAll(Class<E> clazz) {
		String jpql = "select o from "+clazz.getName()+" as o";
		Query query = entityManager.createQuery(jpql); //JPQL
		return query.getResultList();
	}
}












