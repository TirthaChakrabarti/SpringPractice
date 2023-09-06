package serviceImplementation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import service.ExamTip;
import service.Teacher;

@Component
//The name of the bean id becomes small camel Caseing by default
//id = physicsTeacher
@Scope("singleton")
public class PhysicsTeacher implements Teacher {
	
	ExamTip examTip;

	public PhysicsTeacher() {

	}
	
	@Autowired
	public PhysicsTeacher(@Qualifier("revisionTip")ExamTip TheExamTip) {
		this.examTip = TheExamTip;
	}

	@Override
	public String getHomework() {
		return "Practice real life Physics problems";
	}

	@Override
	public String getExamTip() {
		return examTip.getExamTip();
	}
	
	//Create two methods: 1) @PostConstruct and 2) @PreDestroy
	//rules --> return type must be void, naming can be anything, won't accept any argument
	
	@PostConstruct
	public void insidePostConstruct() {
		System.out.println("Inside post construct");
		System.out.println();
	}
	
	@PreDestroy
	public void insidePreDestroy() {
		System.out.println();
		System.out.println("Pre destroy is getting executed");
	}
}
