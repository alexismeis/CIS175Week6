package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Classroom;

/**
 * @author alexismeis - aameis
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */
public class ClassroomHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebGrade");
	
	public void insertClassroom(Classroom c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Classroom> showAllClassrooms() {
		EntityManager em = emfactory.createEntityManager();
		List<Classroom> allClassrooms = em.createQuery("SELECT c FROM Classroom c").getResultList();
		return allClassrooms;
	}
	
	public Classroom findClassroom(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Classroom> typedQuery = em.createQuery("select cl from Classroom cl where cl.classroomName = :selectedName", Classroom.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Classroom foundClassroom;
		try {
			foundClassroom = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundClassroom = new Classroom(nameToLookUp);
		}
		em.close();
		
		return foundClassroom;
	}
}
