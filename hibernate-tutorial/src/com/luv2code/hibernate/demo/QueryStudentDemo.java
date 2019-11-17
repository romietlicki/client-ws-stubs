package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//star the transaction
			session.beginTransaction();
	
			//query the students
			List<Student> listStudent = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(listStudent);
			
			listStudent = session.createQuery("from Student s where s.lastName = 'Mietlicki'").getResultList();
			
			System.out.println("Students who have last name Mietlicki \n");
			displayStudents(listStudent);
			
			
			listStudent = session.createQuery("from Student s where s.lastName = 'Mietlicki' or s.firstName = 'Rodrigo'").getResultList();
			
			System.out.println("\nStudents who have the first name as Rodrigo or last name as Mietlicki");
			displayStudents(listStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
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
