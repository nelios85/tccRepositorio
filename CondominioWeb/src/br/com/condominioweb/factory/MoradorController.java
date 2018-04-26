package br.com.condominioweb.factory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.condominioweb.vo.Morador;

public class MoradorController {
	
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

	public MoradorController() {
		entityManagerFactory = Persistence.createEntityManagerFactory("nelio");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void salvar(Morador morador) {
		entityManager.getTransaction().begin();
	//	entityManager.merge(morador);
		entityManager.persist(morador);
		entityManager.getTransaction().commit();
	}
	
	public void remover(Morador morador){
		entityManager.getTransaction().begin();
		Query q = entityManager.createNativeQuery("DELETE FROM morador WHERE id="+morador.getId());
		q.executeUpdate();
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}
	
	public List<Morador> listar(){
		entityManager.getTransaction().begin();
		Query consulta = entityManager.createQuery("SELECT * FROM morador");
		List<Morador> lista = consulta.getResultList();
		entityManager.getTransaction();
		entityManagerFactory.close();
		return lista;
	}
	
/*	public static void main(String[] args) {
		Morador m1 = new Morador();
		
		m1.setNome("Nelio Santos");
		m1.setEmail("nelios.souza@gmail.com");
		m1.setSenha("1234");
		m1.setTelefone(12345565);
		m1.setTipo("Subsíndico");

		MoradorController con = new MoradorController();
		con.salvar(m1);
	}	*/
}