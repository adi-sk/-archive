package com.zycus.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("a")
public class ClassA {

	@Autowired
	private ClassB classB;
	
	public void method() {
		classB.method();
	}
}
