package driver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Teacher;
import serviceImplementation.CSTeacher;
import serviceImplementation.GkTeacher;
import serviceImplementation.HindiTeacher;
import serviceImplementation.MathTeacher;
import serviceImplementation.PhysicsTeacher;

public class SpringDriver {

	public static void main(String[] args) {

		// Load the Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean from Spring container
		Teacher teacher1 = context.getBean("hindiTeacher", HindiTeacher.class);
		Teacher teacher2 = context.getBean("mathTeacher", MathTeacher.class);
		Teacher teacher3 = context.getBean("gkTeacher", GkTeacher.class);
		Teacher teacher4 = context.getBean("teacher", GkTeacher.class);
		
		Teacher teacher5 = context.getBean("gKTeacher", GkTeacher.class);
		Teacher teacher6 = context.getBean("gKTeacher", GkTeacher.class);
		
		Teacher teacher7 = context.getBean("GKTeacher", GkTeacher.class);
		Teacher teacher8 = context.getBean("GKTeacher", GkTeacher.class);
		
		Teacher teacher9 = context.getBean("hindiTeacher2", HindiTeacher.class);
		
		Teacher teacher10 = context.getBean("physicsTeacher", PhysicsTeacher.class);
		Teacher teacher11 = context.getBean("physicsTeacher", PhysicsTeacher.class);
		
		Teacher teacher12 = context.getBean("Harshit", CSTeacher.class);
		Teacher teacher13 = context.getBean("Harshit", CSTeacher.class);
		
		// Call methods on the bean
		System.out.println(teacher1.getHomework());
		System.out.println(teacher2.getHomework());
		System.out.println(teacher3.getHomework());
		System.out.println(teacher4.getHomework());
		
		System.out.println();
		
		if(teacher5 == teacher6) {
			System.out.println("Teacher5 and Teacher6 are same bean/object");
		}
		else {
			System.out.println("Teacher5 and Teacher6 are not same beans/objects");
		}
		
		System.out.println("Teacher5: "+teacher5);
		System.out.println("Teacher6: "+teacher6);
		
		System.out.println();
		
		if(teacher7 == teacher8) {
			System.out.println("Teacher7 and Teacher8 are same bean/object");
		}
		else {
			System.out.println("Teacher7 and Teacher8 are not same beans/objects");
		}
		
		System.out.println("Teacher7: "+teacher7);
		System.out.println("Teacher8: "+teacher8);
		
		System.out.println();
		
		System.out.println(teacher9.getHomework());
		
		System.out.println();
		
		System.out.println("Exam tip from Hindi Teacher: "+teacher1.getExamTip());
		System.out.println("Exam tip from Math Teacher: "+teacher2.getExamTip());
		System.out.println("Exam tip from GK Teacher: "+teacher3.getExamTip());
		
		System.out.println();
		
		System.out.println("XML+Java Annotation approach...\n");
		System.out.println(teacher10.getHomework());
		System.out.println(teacher11.getHomework());
		System.out.println(teacher12.getHomework());
		System.out.println(teacher13.getHomework());
		
		System.out.println();
		
		System.out.println("Exam tip from Physics Teacher: "+teacher10.getExamTip());
		System.out.println("Exam tip from CS Teacher: "+teacher13.getExamTip());
		
		System.out.println();
		
		if(teacher10 == teacher11) {
			System.out.println("Teacher10 and Teacher11 are same bean/object");
		}
		else {
			System.out.println("Teacher10 and Teacher11 are not same beans/objects");
		}
		
		System.out.println();
		
		if(teacher12 == teacher13) {
			System.out.println("Teacher12 and Teacher13 are same bean/object");
		}
		else {
			System.out.println("Teacher12 and Teacher13 are not same beans/objects");
		}		
		
		System.out.println();
		
		System.out.println("Teacher10: "+teacher10);
		System.out.println("Teacher11: "+teacher11);
		System.out.println("Teacher12: "+teacher12);
		System.out.println("Teacher13: "+teacher13);
		
		// Close the context
		context.close();
	}

}
