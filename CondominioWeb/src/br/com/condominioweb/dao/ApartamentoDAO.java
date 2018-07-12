package br.com.condominioweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.condominioweb.vo.Apartamento;

public class ApartamentoDAO{
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	
	public ApartamentoDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("nelio");
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * Salvar areaCondominio = bloco, numero apartamento, numero de moradores e tipo de morador.
	 * @param apartamento
	 */
	public void salvar(Apartamento apartamento) {
		entityManager.getTransaction().begin();
		entityManager.merge(apartamento);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Remove areaCondominio
	 * @param apartamento
	 */
	public void remover(Apartamento apartamento){
		entityManager.getTransaction().begin();
		Query q = entityManager.createNativeQuery("DELETE FROM areacondominio WHERE id="+apartamento.getId());
		q.executeUpdate();
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}
	
	
	/**
	 * Lista Apartamento (Bloco, numero apartamento, quantidade de moradores e tipo de morador)
	 * @return lista
	 */
	public List<Apartamento> listar(){
		entityManager.getTransaction().begin();
		Query consulta = entityManager.createQuery("FROM Apartamento");
		List<Apartamento> lista = consulta.getResultList();
		entityManager.getTransaction();
		entityManagerFactory.close();
		return lista;
	}
}
