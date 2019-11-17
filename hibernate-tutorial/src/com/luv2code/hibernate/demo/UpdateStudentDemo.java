package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			//star the transaction
			session.beginTransaction();
	
			System.out.println("\nGetting student id : " + studentId);
			
			
			//get student by id
			Student theStudent = session.get(Student.class, studentId);
			
			System.out.println("\nUpdating Student... " +theStudent);
			
			theStudent.setFirstName("Gustavo");
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
			
			
			//NEW CODE for updating all the email of student table
			
			//create session
			session = factory.getCurrentSession();
			//star the transaction
			session.beginTransaction();
			
			System.out.println("Update email for all the students");
			
			session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> listStudent) {
		for(Student tempStudent : listStudent) {
			System.out.println(tempStudent);
		}
	}

}
