package br.com.condominioweb.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import br.com.condominioweb.vo.AreaCondominio;
import br.com.condominioweb.vo.Morador;

@ViewScoped
public class CondominioBean {
	
	private Morador morador;
	private AreaCondominio areaCondominio;

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

	@PostConstruct
	public void unit() {
		
	}
	
	
}
