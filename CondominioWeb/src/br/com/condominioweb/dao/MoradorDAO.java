package br.com.condominioweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.condominioweb.vo.Morador;

public class MoradorDAO {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("nelio");
	private EntityManager em = factory.createEntityManager();
	
	public void inserirMorador(Morador morador) {
		try {
			em.persist(morador);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
