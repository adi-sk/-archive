package com.zycus.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zycus.entity.Customer;
import com.zycus.util.HibernateUtil;

public class CustomerDao {

	public void add(Customer customer) {
		//Step 1. Create/Obtain SessionFactory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//Step 2. Create/Obtain Session object
		Session session = sessionFactory.getCurrentSession();
		//Step 3. Start/Participate in a Transaction
		Transaction tx = session.beginTransaction();
		
		//Now we can insert/update/delete/select whatever we want
		session.save(customer); //save method generates insert query
		
		tx.commit();
	}
	
	public void update(Customer customer) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.update(customer); //update method generates update query
		
		tx.commit();
	}
	
	public void remove(int customerId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, customerId);
		session.delete(customer); //delete method generates delete query
		
		tx.commit();
	}

	public Customer fetchById(int customerId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			//get method generates select query
			Customer customer = (Customer) session.get(Customer.class, customerId);
			return customer;
		}
		finally {
			session.close();
		}
	}
	
	
	public List<Customer> fetchAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select c from Customer as c"); //HQL
		try {
			return query.list();
		}
		finally {
			session.close();
		}
	}
}












