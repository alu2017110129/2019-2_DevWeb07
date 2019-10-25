package br.com.cadastro.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Produto {
	private Integer Cod_item;
	@Size(min=1 , message="Preencher Campo")
	private String Serviço;
	@Size(min=1 , message="Preencher Campo")
	private String Custo_R;
	@NotNull(message="Campo em Branco")
	private String Valor_R;
	@NotNull(message="Campo em Branco")
	private String Bairro;
	@NotNull(message="Campo em Branco")
	private String Fornecedor;
	@NotNull(message="Campo em Branco")
	private String Margem;
	@NotNull(message="Campo em Branco")
	public Integer getCod_item() {
		return Cod_item;
	}
	public void setCod_item(Integer cod_item) {
		Cod_item = cod_item;
	}
	public String getServiço() {
		return Serviço;
	}
	public void setServiço(String serviço) {
		Serviço = serviço;
	}
	public String getCusto_R() {
		return Custo_R;
	}
	public void setCusto_R(String custo_R) {
		Custo_R = custo_R;
	}
	public String getValor_R() {
		return Valor_R;
	}
	public void setValor_R(String valor_R) {
		Valor_R = valor_R;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getFornecedor() {
		return Fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		Fornecedor = fornecedor;
	}
	public String getMargem() {
		return Margem;
	}
	public void setMargem(String margem) {
		Margem = margem;
	}
}
	
	