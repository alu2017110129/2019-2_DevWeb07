package br.com.cadastro.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Produto {
	private Integer Id;
	@Size(min=1 , message="Preencher Campo")
	private String Serviço;
	@Size(min=1 , message="Preencher Campo")
	private String Custo;
	@NotNull(message="Campo em Branco")
	private String Valor;
	@NotNull(message="Campo em Branco")
	private String Fornecedor;
	@NotNull(message="Campo em Branco")
	private String Margem;
	@NotNull(message="Campo em Branco")

	public Integer getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}
	public String getServiço() {
		return Serviço;
	}
	public void setServiço(String serviço) {
		this.Serviço = serviço;
	}
	public String getCusto() {
		return Custo;
	}
	public void setCusto(String Custo) {
		this.Custo = Custo;
	}
	public String getValor() {
		return Valor;
	}
	public void setValor(String Valor) {
		this.Valor = Valor;
	}
	public String getFornecedor() {
		return Fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.Fornecedor = fornecedor;
	}
	public String getMargem() {
		return Margem;
	}
	public void setMargem(String margem) {
		this.Margem = margem;
	}
}