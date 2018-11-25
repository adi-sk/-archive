package com.zycus.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zycus.component.HelloWorld;
import com.zycus.component.TextEditor;

public class SpringTest {

	@Test
	public void testHelloWorld() {
		//Loading the IoC Container
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("app-config.xml");
		
		//Accessing HelloWorld
		HelloWorld hw = (HelloWorld) context.getBean("hw"); //id
		System.out.println(hw.sayHello());
	}
	
	@Test
	public void testTextEditor() {
		//Loading the IoC Container
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("app-config.xml");
		
		TextEditor te = (TextEditor) context.getBean("te");
		te.load("abc.txt");
	}
}










