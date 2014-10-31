package br.com.aulaweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.jpa.internal.EntityManagerImpl;

public  class  Dao {
	
	private EntityManagerFactory emf;
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public Dao () {
		emf = Persistence.createEntityManagerFactory("Aulaweb");
		
	}
	
	public Session getSession () {
		
		
		if (getEntityManager().getDelegate() instanceof EntityManagerFactory) {
			
			EntityManagerImpl entityManagerImpl = (EntityManagerImpl) getEntityManager();
			
			return entityManagerImpl.getSession();
		}else 
			
			return (Session) getEntityManager().getDelegate();
		
		
	}

}