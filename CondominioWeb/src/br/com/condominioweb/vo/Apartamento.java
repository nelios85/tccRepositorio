package br.com.condominioweb.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Apartamento")
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String bloco;
	
	private String numeroApartamento;
	
	private String qtdMorador;
	
	private String ocorrencia;
	
	//Relacionamento implementado
	@ManyToMany(mappedBy="apartamentos", cascade=CascadeType.ALL)
	private List<Morador> moradores = new ArrayList<Morador>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBloco() {
		return bloco;
	}
	
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	
	public String getNumeroApartamento() {
		return numeroApartamento;
	}
	
	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}
	
	public List<Morador> getMoradores() {
		return moradores;
	}
	
	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}
	
	public String getQtdMorador() {
		return qtdMorador;
	}
	
	public void setQtdMorador(String qtdMorador) {
		this.qtdMorador = qtdMorador;
	}
	public String getOcorrencia() {
		return ocorrencia;
	}
	
	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
}
