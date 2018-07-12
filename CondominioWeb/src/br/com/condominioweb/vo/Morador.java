package br.com.condominioweb.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "Morador")
@SecondaryTable(name = "health_care", pkJoinColumns =
{@PrimaryKeyJoinColumn(name = "id")})
public class Morador {

	@Id
	private Long id;

	@Column
	private String nome;

	@Column
	private String sobrenome;

	@Column
	private int cpf;

	@Column
	private String senha;

	@Column
	private String tipo;

	@Column
	private int telefone;

	@Column
	private String email;

	@Column
	private String ocorrencia;

	@ManyToMany
	@JoinTable(name="morador_tem_apartamentos",joinColumns=
	{@JoinColumn(name="morador_id")}, inverseJoinColumns=
		{@JoinColumn(name="apartamento_id")})
	private List<Apartamento> apartamentos;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public List getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List apartamentos) {
		this.apartamentos = apartamentos;
	}

}
