package com.wjahatsyed.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wjahatsyed.hibernate.demo.entity.Instructor;
import com.wjahatsyed.hibernate.demo.entity.Student;


public class CreateUserStudentInstructorDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			// create the object
			Student tempStudent1 = new Student("Wajahat", "Adil", "wajahat@binaryvibes.com", "Hibernate");
			Instructor tempInstructor = new Instructor("Zeeshan", "Adil", "zeeshan@altanova.com", 20000.00);

			// start a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving student and address");

			session.persist(tempStudent1);
			session.persist(tempInstructor);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			// clean up code
			session.close();
			factory.close();
		}

	}
}
