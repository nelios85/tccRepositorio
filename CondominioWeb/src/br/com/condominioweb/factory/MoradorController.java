package br.com.condominioweb.factory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
		emf.close();
	}
	
	public void remover(Morador morador){
		em.getTransaction().begin();
		Query q = em.createNativeQuery("DELETE FROM morador WHERE id="+morador.getId());
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}
	
	public List<Morador> listar(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("SELECT * FROM morador");
		List<Morador> lista = consulta.getResultList();
		em.getTransaction();
		emf.close();
		return lista;
	}
	
/*	public static void main(String[] args) {
		Morador m1 = new Morador();
		
		m1.setNome("Nelio Santos");
		m1.setEmail("neli.souza@gmail.com");
		m1.setSenha("ssdd");
		m1.setTelefone(12345565);
		m1.setTipo("Morador");

		MoradorController con = new MoradorController();
		con.salvar(m1);
		
	} */
}
