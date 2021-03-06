package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects
			Instructor instructor = new Instructor("Gustavo", "Mietlicki", "gustavorm@hotmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com.br/gustavomietlicki", "play guitar");
			
			//set the instructor detail object
			instructor.setInstructorDetailId(instructorDetail);
			
			//start the transaction
			session.beginTransaction();
			
			//this will ALSO save the instructor detail object because of the CascadeType.ALL
			System.out.println("Saving Instructor..." + instructor);
			session.save(instructor);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
