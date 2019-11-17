package com.mietlicki.jpa.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mietlicki.jpa.app.entity.Employee;

public class HibernateExerciseApp {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//add new employee
		//createEmployee(factory);
		
		//find employee by id
		//getEmployeeById(factory, 2);
		
		//find employees by company
		getEmployeeByCompany(factory, "Autonomo");

		//delete employee by id
		//deleteEmployee(factory, 1);
	}
	
	
	public static void createEmployee(SessionFactory factory) {
		
		Session session = factory.getCurrentSession();
		Employee employee1 = new Employee("Luiz","Mietlicki","Autonomo");
		Employee employee2 = new Employee("Gustavo","Mietlicki","Unemployed");
		Employee employee3 = new Employee("Guilherme","Mietlicki","Melitta");
		Employee employee4 = new Employee("Selma","Rodrigues","Unemployed");
		
		try {
			session.beginTransaction();
			System.out.println("Adding the employee into the database...");
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.save(employee4);
			session.getTransaction().commit();
			
			System.out.println("done.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}
	
	
	public static Employee getEmployeeById(SessionFactory factory, int employeeId) {
		
		Employee employee = new Employee();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Starting session...\n");
			session.beginTransaction();
			
			System.out.println("\nFind employee by ID");
			employee = session.get(Employee.class, employeeId);
			System.out.println("\nEmployee: "+employee);
			
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
		return employee;
	}
	
	public static List<Employee> getEmployeeByCompany(SessionFactory factory, String company){
		
		Session session = factory.getCurrentSession();
		List<Employee> employees = new ArrayList<Employee>();
		
		try{
			System.out.println("starting transaction...\n");
			session.beginTransaction();
			
			employees = session.createQuery("from Employee e where e.company =: company").setParameter("company", company).getResultList();
			session.getTransaction().commit();
			
			for(Employee employee : employees) {
				System.out.println(employee);
			}
			
			System.out.println("\nDone!");
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		return employees;
	}
	
	public static void deleteEmployee(SessionFactory factory, int employeeId) {
		
		Session session = factory.getCurrentSession();
		
		Employee employee = new Employee();
		
		try {
			System.out.println("Starting transaction...\n");
			session.beginTransaction();
			
			System.out.println("Deleting employee...\n");
			employee = session.get(Employee.class, employeeId);
			System.out.println("Employee to be deleted: "+ employee + "\n");
			
			session.delete(employee);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
