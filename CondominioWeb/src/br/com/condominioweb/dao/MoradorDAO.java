package br.com.condominioweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.condominioweb.vo.Morador;

public class MoradorDAO{
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public MoradorDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("nelio");
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * Cadastrando novo morador
	 * @param morador
	 */
	public void salvar(Morador morador) {
		entityManager.getTransaction().begin();
	//	entityManager.merge(morador);
		entityManager.persist(morador);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Removendo morador pelo id
	 * @param morador
	 */
	public void remover(Morador morador){
		entityManager.getTransaction().begin();
		Query q = entityManager.createNativeQuery("DELETE FROM morador WHERE id="+morador.getId());
		q.executeUpdate();
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}
	
	
	/**
	 * Listando moradores
	 * @return lista
	 */
	public List<Morador> listar(){
		entityManager.getTransaction().begin();
		Query consulta = entityManager.createQuery("FROM Morador");
		List<Morador> lista = consulta.getResultList();
		entityManager.getTransaction();
		entityManagerFactory.close();
		return lista;
	}
	
}
