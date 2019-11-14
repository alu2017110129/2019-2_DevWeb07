package br.com.cadastro.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Ocorrencia {
	@NotNull(message="Campo em Branco")
	private Integer Ocorrencia;
	@Size(min=1 , message="Preencher Campo")
	private String Nome;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar Data;
	@NotNull(message="Campo em Branco")
	private Integer CodCli;
	@NotNull(message="Campo em Branco")
	private String Nome_Razão_Social;
	@NotNull(message="Campo em Branco")
	private String Tipo;
	@NotNull(message="Campo em Branco")
	private String Marca;
	@NotNull(message="Campo em Branco")
	private String Modelo;
	@NotNull(message="Campo em Branco")
	private String Série;
	@NotNull(message="Campo em Branco")
	private String Voltagem;
	@NotNull(message="Campo em Branco")
	private String Problema_Informado;
	@NotNull(message="Campo em Branco")
	private String Defeito_Detectado;
	@NotNull(message="Campo em Branco")
	private String Hora;
	@NotNull(message="Campo em Branco")
	private String Concluído;
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
	private String NroParc;
	@NotNull(message="Campo em Branco")
	private String Valor_Parcela;
	
	public Integer getOcorrencia() {
		return Ocorrencia;
	}
	public void setOcorrencia(Integer Ocorrencia) {
		this.Ocorrencia = Ocorrencia;
	}
	public String getNome_Razão_Social() {
		return Nome_Razão_Social;
	}
	public void setNome_Razão_Social(String Nome_Razão_Social) {
		this.Nome_Razão_Social = Nome_Razão_Social;
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
	public String getSérie() {
		return Série;
	}
	public void setSérie(String Série) {
		this.Série = Série;
	}
	public String getVoltagem() {
		return Voltagem;
	}
	public void setVoltagem(String Voltagem) {
		this.Voltagem = Voltagem;
	}
	public String getProblema_Informado() {
		return Problema_Informado;
	}
	public void setProblema_Informado(String Problema_Informado) {
		this.Problema_Informado = Problema_Informado;
	}
	public String getDefeito_Detectado() {
		return Defeito_Detectado;
	}
	public void setDefeito_Detectado(String Defeito_Detectado) {
		this.Defeito_Detectado = Defeito_Detectado;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String Hora) {
		this.Hora = Hora;
	}
	public String getConcluído() {
		return Concluído;
	}
	public void setConcluído(String Concluído) {
		this.Concluído = Concluído;
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
	public String getNroParc() {
		return NroParc;
	}
	public void setNroParc(String NroParc) {
		this.NroParc = NroParc;
	}
	public String getValor_Parcela() {
		return Valor_Parcela;
	}
	public void setValor_Parcela(String Valor_Parcela) {
		this.Valor_Parcela = Valor_Parcela;
	}	
}