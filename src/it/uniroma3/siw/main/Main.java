package it.uniroma3.siw.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.uniroma3.siw.models.Address;
import it.uniroma3.siw.models.Company;
import it.uniroma3.siw.models.Course;
import it.uniroma3.siw.models.Teacher;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("courses");
		EntityManager em = emf.createEntityManager();

		// Clean up
		Query deleteAllCompanies = em.createQuery("DELETE FROM Company c");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		deleteAllCompanies.executeUpdate();
		tx.commit();

		Query deleteAllTeachers = em.createQuery("DELETE FROM Teacher c");
		tx = em.getTransaction();
		tx.begin();
		deleteAllTeachers.executeUpdate();
		tx.commit();

		Query deleteAllCourses = em.createQuery("DELETE FROM Course c");
		tx = em.getTransaction();
		tx.begin();
		deleteAllCourses.executeUpdate();
		tx.commit();

		// Test persistence
		Company c = new Company();
		c.setBusinessName("Pippo SpA");
		c.setBusinessAddress(new Address("Via Flaminia","1234", "Rome", "RM", "00100"));
		c.setPhoneNumber("+39 06 1234567");
		c.setVatNumber("0123456789");

		Teacher t = new Teacher();

		Course c1 = new Course();
		c1.setCourseLengthInMonths(3);
		c1.setLecturer(t);
		c1.setStartDate(new Date());
		c1.setName("Pluto");
		Course c2 = new Course();
		c2.setCourseLengthInMonths(4);
		c2.setLecturer(t);
		c2.setStartDate(new Date());
		c2.setName("Paperino");

		t.setFirstName("Paolo");
		t.setLastName("Merialdo");
		t.setDateOfBirth(new Date());
		t.setVatNumber("12341234");
		t.setPlaceOfBirth("Rome");
		List<Course> l = new ArrayList<>();
		l.add(c1);
		l.add(c2);
		t.setCoursesHeld(l);

		tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		em.persist(t);
		em.persist(c1);
		em.persist(c2);
		tx.commit();

		em.close();
		emf.close();

	}

}
