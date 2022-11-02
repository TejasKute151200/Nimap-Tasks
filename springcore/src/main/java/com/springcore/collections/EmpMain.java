package com.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	
public static void main(String[] args) {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collections/collectionConfig.xml");
	Emp e = (Emp) context.getBean("emp1");
    
	System.out.println(e.getId());
	System.out.println(e.getName());
	System.out.println(e.getPhones());
	System.out.println(e.getCourses());
	
}
}
