package br.com.condominioweb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.condominioweb.dao.ApartamentoDAO;
import br.com.condominioweb.dao.MoradorDAO;
import br.com.condominioweb.util.JSFUtil;
import br.com.condominioweb.vo.Apartamento;
import br.com.condominioweb.vo.Morador;

//teste de pull

@ManagedBean(name="moradorBean")
@ViewScoped
public class MoradorBean{
	
	private Morador morador = new Morador();
	private MoradorDAO moradorDAO = new MoradorDAO();
	private List<Morador> listarMorador = new ArrayList<Morador>();

	//Redirect
	private static final String SUCESSO_NOVO_CADASTRO = "sucesso.xhtml";
	private static final String SUCESSO_REMOVER_CADASTRO = "sucessoRemover.xhtml";
	
	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}
	
	public List<Morador> getListarMorador() {
		return listarMorador;
	}

	public void setListarMorador(List<Morador> listarMorador) {
		this.listarMorador = listarMorador;
	}

	@PostConstruct
	public void unit() {
		listarMorador();
	}
	
	/**
	 * Adicionando novo morador
	 * @return
	 */
	public void novoMorador() {
		try {
			moradorDAO.salvar(morador);
			JSFUtil.adicionarMensagemSucesso("Morador salvo com sucesso.");
			FacesContext.getCurrentInstance().getExternalContext().redirect(SUCESSO_NOVO_CADASTRO);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar salvar um novo morador.");
		}
	}
	
	
	/**
	 * Excluindo morador
	 */
	public void deletaMorador() {
		try {
			moradorDAO.remover(morador);
			JSFUtil.adicionarMensagemSucesso("Morador removido com sucesso.");
			FacesContext.getCurrentInstance().getExternalContext().redirect(SUCESSO_REMOVER_CADASTRO);
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar remover um morador. ");
		}
	}
	
	
	/**
	 * Listando moradores ArrayList
	 */
	public void listarMorador() {
		try {
			listarMorador = moradorDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Moradores listados com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar listar moradores.");
		}
	}
}
