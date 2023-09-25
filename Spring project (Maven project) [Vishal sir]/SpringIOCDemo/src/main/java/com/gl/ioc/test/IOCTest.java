package com.gl.ioc.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.gl.ioc.model.Car;
import com.gl.ioc.model.Student;

public class IOCTest {

	public static void main(String[] args) {

//		Normally we create object manually like below but in Spring we don't do this
//		Student student = new Student();

		System.out.println("Using Core Container/Bean Factory:\n");
		Resource resource = new ClassPathResource("com/gl/ioc/resource/spring.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("Bean is not yet created.");
		System.out.println("invoking getBean() method...\n");
		Student theStudent = (Student) factory.getBean("student");
		System.out.println("\nNow bean is created.");
		System.out.println("Now calling demo method...");
		theStudent.show();

		System.out.println();

		System.out.println("Using Advanced Container/Application Context:\n");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/gl/ioc/resource/spring.xml");
		System.out.println("\nBean is created directly for singleton scope! For prototype scope, bean is not created.");
		System.out.println("Now invoking getBean() method multiple times...\n");
		context.getBean("student");
		context.getBean("student");
		context.getBean("student");
		System.out.println("\nIf bean creation is not repeated, bean scope is singleton (by default or defines in xml).");
		System.out.println("If bean creation is repeated, bean scope is prototype. (defined in xml)");

		System.out.println();

		System.out.println("Data injection into bean with IoC (setter injection by 'property' tag):");
		Student student1 = (Student) context.getBean("student");
		System.out.println(student1);

		System.out.println("Data injection into bean with IoC (Constructor injection by 'constructor-arg' tag):");
		Student student2 = (Student) context.getBean("st");
		System.out.println(student2);
		
		System.out.println();
		
		System.out.println("Secondary type Dependency Injection test using XML:");
		Car c = context.getBean(Car.class);
		System.out.println(c);
	}

}
