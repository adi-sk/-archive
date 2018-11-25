package com.zycus.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zycus.dao.CarPartsDao;
import com.zycus.entity.CarPart;

public class CarPartsDaoTest {

	@Test
	public void addCarPart() {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("app-config.xml");
		CarPartsDao dao = (CarPartsDao) context.getBean("carPartsDao1");
		
		CarPart carPart = new CarPart();
		carPart.setPartNo(111);
		carPart.setPartName("Nut&Bolt");
		carPart.setCarModel("Maruti 800");
		carPart.setPrice(100);
		carPart.setQuantity(99);
		dao.addNewPart(carPart);
	}

}
