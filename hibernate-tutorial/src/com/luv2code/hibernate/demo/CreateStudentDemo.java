package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save java object
			
			//create the student object
			System.out.println("Creating a new Student object...");
			Student student1 = new Student("Luiz", "Carlos", "luizcarlos@gmail.com");
			Student student2 = new Student("Guilherme", "Rodrigues", "guilhermerodrigues@hotmail.com");
			Student student3 = new Student("Selma", "Rodrigues", "selma.rodrigues@yahoo.com");
			
			//star the transaction
			session.beginTransaction();
			//save the student objetc
			System.out.println("Savind the student");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
