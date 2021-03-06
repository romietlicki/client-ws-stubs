package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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

			//delete student with id 1
			/*System.out.println("Deleting the student: " + theStudent);
			session.delete(theStudent);*/
			
			//delete student with id = 2
			System.out.println("Deleting student with id =2...");
			session.createQuery("delete from Student where id = 2").executeUpdate();
			
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
