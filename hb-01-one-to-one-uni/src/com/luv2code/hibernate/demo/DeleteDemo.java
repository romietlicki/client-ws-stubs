package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int theId = 1;
			Instructor instructor = new Instructor();
			
			//start the transaction
			session.beginTransaction();
			
			//it will get the instructor by id and delete it, it will ALSO delete from InstructorDetail because of the CascadeType.ALL
			instructor = session.get(Instructor.class, theId);
			
			if(instructor != null) {
				System.out.println("Deleting...");
				session.delete(instructor);
			}

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
