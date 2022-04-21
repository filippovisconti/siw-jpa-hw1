package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.models.Address;
import it.uniroma3.siw.models.Company;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("courses");
		EntityManager em = emf.createEntityManager();

		Company c = new Company();
		c.setBusinessName("Pippo SpA");
		c.setBusinessAddress(new Address("Via Flaminia","1234", "Rome", "RM", "00100"));
		c.setPhoneNumber("+39 06 1234567");
		c.setVatNumber("0123456789");
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		
		em.close();
		emf.close();

	}

}
