package com.cg.jpainitialsetup.main;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.cg.jpainitialsetup.domain.UserDetail;
public class ApplicationStartup {
 
	public static void main(String[] args)
	{
		UserDetail userDetail= new UserDetail();
		//userDetail.setId(102);
		userDetail.setName("Shivam2");
		userDetail.setContact("5423441");
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(userDetail);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
