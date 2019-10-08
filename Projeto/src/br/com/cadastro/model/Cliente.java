package br.com.cadastro.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cliente {
	private Integer Codigo;
	@Size(min=1 , message="Preencher Campo")
	private String Nome;
	@Size(min=1 , message="Preencher Campo")
	private String Endereco;
	@NotNull(message="Campo em Branco")
	private Integer Numero;
	@NotNull(message="Campo em Branco")
	private String Bairro;
	@NotNull(message="Campo em Branco")
	private String Cidade;
	@NotNull(message="Campo em Branco")
	private String UF;
	@NotNull(message="Campo em Branco")
	private String CEP;
	@NotNull(message="Campo em Branco")
	private String email;
	@NotNull(message="Campo em Branco")
	private String Telefone;
	@NotNull(message="Campo em Branco")
	private String Celular;
	@NotNull(message="Campo em Branco")
	private String Contato;
	@NotNull(message="Campo em Branco")
	private String Tecnico;
	@NotNull(message="Campo em Branco")
	private String Complemento;
	@NotNull(message="Campo em Branco")
	private String Foto;
	@NotNull(message="Campo em Branco")
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}
	public Integer getNumero() {
		return Numero;
	}
	public void setNumero(Integer Numero) {
		this.Numero = Numero;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String Bairro) {
		this.Bairro = Bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String Cidade) {
		this.Cidade = Cidade;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String Celular) {
		this.Celular = Celular;
	}
	public String getContato() {
		return Contato;
	}
	public void setContato(String Contato) {
		this.Contato = Contato;
	}
	public String getTecnico() {
		return Tecnico;
	}
	public void setTecnico(String Tecnico) {
		this.Tecnico = Tecnico;
	}
	public String getComplemento() {
		return Complemento;
	}
	public void setComplemento(String Complemento) {
		this.Complemento = Complemento;
	}
	public String getFoto() {
		return Foto;
	}
	public void setFoto(String Foto) {
		this.Foto = Foto;
	}
}