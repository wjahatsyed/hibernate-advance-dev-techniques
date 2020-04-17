package com.wjahatsyed.hibernate.demo;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wjahatsyed.hibernate.demo.entity.Student;

public class CreateStudentImagesMapDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// create the object
			Student student = new Student("Wajahat", "Adil", "wajahat@binaryvibes.com");
			Map<String, String> images = student.getImages();
			images.put("images1.jpg", "Desc 1");
			images.put("images2.jpg", "Desc 2");
			images.put("images3.jpg", "Desc 3");

			// start a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving student and images");
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
