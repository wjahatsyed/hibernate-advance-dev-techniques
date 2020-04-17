package com.wjahatsyed.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wjahatsyed.hibernate.demo.entity.Address;
import com.wjahatsyed.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			// create the object
			Student student = new Student("Wajahat", "Adil", "wajahat@binaryvibes.com");
			Address homeAddress = new Address("University Road", "Karachi", "75300");
			// start a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving student and address");
			student.setHomeAddress(homeAddress);
			session.persist(student);

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
