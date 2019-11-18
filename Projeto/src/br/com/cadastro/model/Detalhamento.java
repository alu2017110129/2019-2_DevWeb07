package br.com.cadastro.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Detalhamento {

	private Integer Ocorrência;
	@Size(min=1 , message="Preencher Campo")	
	private Integer CodItem;
	@NotNull(message="Campo em Branco")
	private Integer Quant;
	@Size(min=1 , message="Preencher Campo")	
	private String Descrição_Peça_Serviço;
	@NotNull(message="Campo em Branco")
	private String Custo;
	@NotNull(message="Campo em Branco")
	private String Valor;
	@NotNull(message="Campo em Branco")
	private String Observação;
	@NotNull(message="Campo em Branco")
	private Integer Ordem;
	@NotNull(message="Campo em Branco")
	
	public Integer getOcorrência() {
		return Ocorrência;
	}
	public void setOcorrência(Integer ocorrência) {
		Ocorrência = ocorrência;
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
	public String getDescrição_Peça_Serviço() {
		return Descrição_Peça_Serviço;
	}
	public void setDescrição_Peça_Serviço(String descrição_Peça_Serviço) {
		Descrição_Peça_Serviço = descrição_Peça_Serviço;
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
	public String getObservação() {
		return Observação;
	}
	public void setObservação(String observação) {
		Observação = observação;
	}
	public Integer getOrdem() {
		return Ordem;
	}
	public void setOrdem(Integer ordem) {
		Ordem = ordem;
	}	
}