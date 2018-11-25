package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.zycus.entity.Account;
import com.zycus.entity.Operation;
import com.zycus.util.JPAUtil;

public class AccountDao extends GenericDao {

	public double fetchBalance(int acno) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select a.balance from Account a where a.acno = :no";
		Query query = entityManager.createQuery(jpql); //JPQL
		query.setParameter("no", acno); //substituting :acno with actual value
		return (Double) query.getSingleResult();
	}
	
	public List<Operation> fetchStatement(int acno) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select obj from Operation obj "
				+ "where obj.account.acno = :no "
				+ "order by obj.txDate DESC";
		Query query = entityManager.createQuery(jpql); //JPQL
		query.setParameter("no", acno);
		query.setMaxResults(3);
		return query.getResultList();
	}
	
	public List<Account> fetchAccountsByTransactionAmount(double amount) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select distinct acc from Account acc join acc.operations op where op.amount >= :amt";
		Query query = entityManager.createQuery(jpql); //JPQL
		query.setParameter("amt", amount);
		return query.getResultList();
	}
	
	public List<Account> fetchAccountsByHighestTransactionAmount() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select distinct acc from Account acc join acc.operations op where op.amount = (select max(amount) from Operation)";
		Query query = entityManager.createQuery(jpql); //JPQL
		return query.getResultList();
	}
	
}








