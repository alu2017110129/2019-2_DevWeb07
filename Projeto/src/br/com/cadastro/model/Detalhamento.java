package br.com.cadastro.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Detalhamento {

	private Integer Ocorr�ncia;
	@Size(min=1 , message="Preencher Campo")	
	private Integer CodItem;
	@NotNull(message="Campo em Branco")
	private Integer Quant;
	@Size(min=1 , message="Preencher Campo")	
	private String Descri��o_Pe�a_Servi�o;
	@NotNull(message="Campo em Branco")
	private String Custo;
	@NotNull(message="Campo em Branco")
	private String Valor;
	@NotNull(message="Campo em Branco")
	private String Observa��o;
	@NotNull(message="Campo em Branco")
	private Integer Ordem;
	@NotNull(message="Campo em Branco")
	
	public Integer getOcorr�ncia() {
		return Ocorr�ncia;
	}
	public void setOcorr�ncia(Integer ocorr�ncia) {
		Ocorr�ncia = ocorr�ncia;
	}
	public Integer getCodItem() {
		return CodItem;
	}
	public void setCodItem(Integer codItem) {
		CodItem = codItem;
	}
	public Integer getQuant() {
		return Quant;
	}
	public void setQuant(Integer quant) {
		Quant = quant;
	}
	public String getDescri��o_Pe�a_Servi�o() {
		return Descri��o_Pe�a_Servi�o;
	}
	public void setDescri��o_Pe�a_Servi�o(String descri��o_Pe�a_Servi�o) {
		Descri��o_Pe�a_Servi�o = descri��o_Pe�a_Servi�o;
	}
	public String getCusto() {
		return Custo;
	}
	public void setCusto(String custo) {
		Custo = custo;
	}
	public String getValor() {
		return Valor;
	}
	public void setValor(String valor) {
		Valor = valor;
	}
	public String getObserva��o() {
		return Observa��o;
	}
	public void setObserva��o(String observa��o) {
		Observa��o = observa��o;
	}
	public Integer getOrdem() {
		return Ordem;
	}
	public void setOrdem(Integer ordem) {
		Ordem = ordem;
	}	
}