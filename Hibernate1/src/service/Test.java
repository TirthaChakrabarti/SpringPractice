package service;

import java.util.List;		
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Connecting to database");
		SessionFactory factory = null;
		Session session = null;
		
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		System.out.println("Created");
		
		Transaction tx = null;
		
		//Create/Insert
//		try {
//			session = factory.getCurrentSession();
//			tx = session.beginTransaction();
//			
//			Teacher t1 = new Teacher("tirtha", "Chakrabarti", "chakrabartitirtha@gmail.com");
//			Teacher t2 = new Teacher("Ankan", "Bandopadhyay", "ankanbandopadhyay@gmail.com");
//			
//			session.save(t1);
//			session.save(t2);
//			tx.commit();
//		}
		
		//Read/Select
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			
//			Teacher teacher = session.get(Teacher.class, 1);
//			System.out.println("teacher "+teacher);
			
			List <Teacher> teachers = session.createQuery("from Teacher").list(); //declaration can be done here
//			Iteration can be done here
//			List declaration and Iteration can be outside the session
			for(Teacher teacher:teachers) {
				System.out.println(teacher);
			}
			tx.commit();
		}
		
		//Update
//		try {
//			session = factory.getCurrentSession();
//			tx = session.beginTransaction();
//			Teacher teacher = session.get(Teacher.class, 2);
//			System.out.println(teacher);
//			System.out.println("Updating the teacher");
//			teacher.setF_name("Barnana");
////			session.update(teacher); [To update single record]
		
////			Hibernate Query Language (HQL) [Teacher is class here, not the table so capital T needed]
//			session.createQuery("Update Teacher set email='Barnana@gmail.com' where f_name = 'Barnana'")
//			.executeUpdate();
//			tx.commit();
//		}
		
		//Delete
//		try {
//			session = factory.getCurrentSession();
//			tx = session.beginTransaction();
//			Teacher teacher = session.get(Teacher.class, 2);
//			System.out.println(teacher);
//			System.out.println("Deleting...");
////			session.delete(teacher);
		
//			session.createQuery("delete from Teacher where email='chakrabartitirtha@gmail.com' ").executeUpdate();
//			tx.commit();
//		}
		catch(Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
