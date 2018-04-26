package br.com.condominioweb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;

import br.com.condominioweb.dao.MoradorDAO;
import br.com.condominioweb.factory.MoradorController;
import br.com.condominioweb.util.JSFUtil;
import br.com.condominioweb.vo.AreaCondominio;
import br.com.condominioweb.vo.Morador;
import net.bytebuddy.description.annotation.AnnotationList.Empty;

@ManagedBean(name="condominioBean")
@ViewScoped
public class CondominioBean {
	
	private Morador morador;
	private MoradorDAO moradorDAO = new MoradorDAO();
	private AreaCondominio areaCondominio;
	private MoradorController moradorController = new MoradorController();
	private List<Morador> listarMorador = new ArrayList<Morador>();

	public MoradorDAO getMoradorDAO() {
		return moradorDAO;
	}

	public void setMoradorDAO(MoradorDAO moradorDAO) {
		this.moradorDAO = moradorDAO;
	}

	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	public AreaCondominio getAreaCondominio() {
		return areaCondominio;
	}

	public void setAreaCondominio(AreaCondominio areaCondominio) {
		this.areaCondominio = areaCondominio;
	}
	
	public MoradorController getMoradorController() {
		return moradorController;
	}

	public void setMoradorController(MoradorController moradorController) {
		this.moradorController = moradorController;
	}
	
	public List<Morador> getListarMorador() {
		return listarMorador;
	}

	public void setListarMorador(List<Morador> listarMorador) {
		this.listarMorador = listarMorador;
	}
	
	@PostConstruct
	public void unit() {
		
	}
	
	/**
	 * adicionar novo morador com moradorController
	 */
	public void novoMorador() {
		try {
			morador = new Morador();
			moradorController = new MoradorController();
			moradorController.salvar(morador);
			JSFUtil.adicionarMensagemSucesso("Morador salvo com sucesso.");
			System.out.println("Salvando...");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar salvar um novo morador.");
		}
	}
	
	/**
	 * MoradorDAO
	 */
	public void adicionarUsuario() {
		moradorDAO.inserirMorador(morador);
		System.out.println("adicionado como MoradorDAO");
	}
	
	public void deletaMorador() {
		try {
			moradorController.remover(morador);
			JSFUtil.adicionarMensagemSucesso("Morador removido com sucesso.");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar remover um morador. ");
		}
	}
	
	public void listarMorador() {
		try {
			listarMorador = moradorController.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar listar moradores.");
		}
		
	}
	
}
