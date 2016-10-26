package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {
	
	private static DB singleton = new DB();
	private static EntityManager em;
	
	private DB(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");
		em = emf.createEntityManager();
	}
	
	public static DB getInstance(){
		return singleton;
	}
	
	public EntityManager getEntityManager(){
		return em;
	}

}
