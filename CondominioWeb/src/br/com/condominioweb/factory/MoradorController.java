package br.com.condominioweb.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.condominioweb.vo.Morador;

public class MoradorController {
		
	EntityManagerFactory emf;
	EntityManager em;
	
	public MoradorController() {
		emf = Persistence.createEntityManagerFactory("condominio");
		em = emf.createEntityManager();
	}

	public void salvar(Morador morador) {
		em.getTransaction().begin();
		em.merge(morador);
		em.getTransaction().commit();
		em.close();
	}
}
