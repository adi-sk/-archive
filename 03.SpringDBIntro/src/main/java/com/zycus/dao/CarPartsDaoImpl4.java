package com.zycus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.entity.CarPart;

@Component("carPartsDao4")
public class CarPartsDaoImpl4 implements CarPartsDao {

	//dependency
	//@Autowired
	@PersistenceContext //for injecting the EntityManager, @Autowired doesn't work
	private EntityManager entityManager;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart);
	}

	public List<CarPart> getAvailableParts() {
		return entityManager.createQuery("select obj from CarPart as obj").getResultList();
	}
}



