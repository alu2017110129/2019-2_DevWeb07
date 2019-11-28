package br.com.cadastro.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class OcorrenciaDetalhamentoView {
	private Integer Id;
	@Size(min=1 , message="Preencher Campo")	
	private Calendar Data;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Integer CodCli;
	@NotNull(message="Campo em Branco")
	private String Cliente;
	@Size(min=1 , message="Preencher Campo")	
	private String Tipo;
	@NotNull(message="Campo em Branco")
	private String Marca;
	@NotNull(message="Campo em Branco")
	private String Modelo;
	@NotNull(message="Campo em Branco")
	private String Serie;
	@NotNull(message="Campo em Branco")
	private String Voltagem;
	@NotNull(message="Campo em Branco")
	private String Problema;
	@NotNull(message="Campo em Branco")
	private String Defeito;
	@NotNull(message="Campo em Branco")
	private String Hora;
	@NotNull(message="Campo em Branco")
	private String Concluido;
	@NotNull(message="Campo em Branco")
	private String Cancelado;
	@NotNull(message="Campo em Branco")
	private String Pago;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar Data_Pagto;
	@NotNull(message="Campo em Branco")
	private String Entregue;
	@NotNull(message="Campo em Branco")
	private String Valor_Total;
	@NotNull(message="Campo em Branco")
	private Integer NroParc;
	@NotNull(message="Campo em Branco")
	private String Valor_Parcela;
	@NotNull(message="Campo em Branco")
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}
	public Calendar getData() {
		return Data;
	}
	public void setData(Calendar Data) {
		this.Data = Data;
	}
	public Integer getCodCli() {
		return CodCli;
	}
	public void setCodCli(Integer CodCli) {
		this.CodCli = CodCli;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String Cliente) {
		this.Cliente = Cliente;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String Marca) {
		this.Marca = Marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String Modelo) {
		this.Modelo = Modelo;
	}
	public String getSerie() {
		return Serie;
	}
	public void setSerie(String Serie) {
		this.Serie = Serie;
	}
	public String getVoltagem() {
		return Voltagem;
	}
	public void setVoltagem(String Voltagem) {
		this.Voltagem = Voltagem;
	}
	public String getProblema() {
		return Problema;
	}
	public void setProblema(String Problema) {
		this.Problema = Problema;
	}
	public String getDefeito() {
		return Defeito;
	}
	public void setDefeito(String Defeito) {
		this.Defeito = Defeito;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String Hora) {
		this.Hora = Hora;
	}
	public String getConcluido() {
		return Concluido;
	}
	public void setConcluido(String Concluido) {
		this.Concluido = Concluido;
	}
	public String getCancelado() {
		return Cancelado;
	}
	public void setCancelado(String Cancelado) {
		this.Cancelado = Cancelado;
	}
	public String getPago() {
		return Pago;
	}
	public void setPago(String Pago) {
		this.Pago = Pago;
	}
	public Calendar getData_Pagto() {
		return Data_Pagto;
	}
	public void setData_Pagto(Calendar Data_Pagto) {
		this.Data_Pagto = Data_Pagto;
	}
	public String getEntregue() {
		return Entregue;
	}
	public void setEntregue(String Entregue) {
		this.Entregue = Entregue;
	}
	public String getValor_Total() {
		return Valor_Total;
	}
	public void setValor_Total(String Valor_Total) {
		this.Valor_Total = Valor_Total;
	}
	public Integer getNroParc() {
		return NroParc;
	}
	public void setNroParc(Integer NroParc) {
		this.NroParc = NroParc;
	}
	public String getValor_Parcela() {
		return Valor_Parcela;
	}
	public void setValor_Parcela(String Valor_Parcela) {
		this.Valor_Parcela = Valor_Parcela;
	}		
	
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
