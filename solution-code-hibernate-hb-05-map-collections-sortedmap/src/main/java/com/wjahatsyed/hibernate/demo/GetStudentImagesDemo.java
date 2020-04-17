package com.wjahatsyed.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wjahatsyed.hibernate.demo.entity.Student;

public class GetStudentImagesDemo {
	public static void main(String[] args) {
		// create Session Factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		// create student object
		try {
			session.beginTransaction();
			int id = 1;
			Student student = session.get(Student.class, id);
			System.out.println("Getting student " + student);
			
			System.out.println("Associated students: " +student.getImages());
			
			session.getTransaction().commit();
			

		} finally {
			// clean up code
			session.close();
			factory.close();
		}

	}
}
