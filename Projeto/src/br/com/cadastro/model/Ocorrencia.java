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
	private boolean Concluído;
	@NotNull(message="Campo em Branco")
	private boolean Cancelado;
	@NotNull(message="Campo em Branco")
	private boolean Pago;
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
	public void setOcorrencia(Integer ocorrencia) {
		Ocorrencia = ocorrencia;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Calendar getData() {
		return Data;
	}
	public void setData(Calendar data) {
		Data = data;
	}
	public Integer getCodCli() {
		return CodCli;
	}
	public void setCodCli(Integer codCli) {
		CodCli = codCli;
	}
	public String getNome_Razão_Social() {
		return Nome_Razão_Social;
	}
	public void setNome_Razão_Social(String nome_Razão_Social) {
		Nome_Razão_Social = nome_Razão_Social;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getSérie() {
		return Série;
	}
	public void setSérie(String série) {
		Série = série;
	}
	public String getVoltagem() {
		return Voltagem;
	}
	public void setVoltagem(String voltagem) {
		Voltagem = voltagem;
	}
	public String getProblema_Informado() {
		return Problema_Informado;
	}
	public void setProblema_Informado(String problema_Informado) {
		Problema_Informado = problema_Informado;
	}
	public String getDefeito_Detectado() {
		return Defeito_Detectado;
	}
	public void setDefeito_Detectado(String defeito_Detectado) {
		Defeito_Detectado = defeito_Detectado;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
		Hora = hora;
	}
	public boolean isConcluído() {
		return Concluído;
	}
	public void setConcluído(boolean concluído) {
		Concluído = concluído;
	}
	public boolean isCancelado() {
		return Cancelado;
	}
	public void setCancelado(boolean cancelado) {
		Cancelado = cancelado;
	}
	public boolean isPago() {
		return Pago;
	}
	public void setPago(boolean pago) {
		Pago = pago;
	}
	public Calendar getData_Pagto() {
		return Data_Pagto;
	}
	public void setData_Pagto(Calendar data_Pagto) {
		Data_Pagto = data_Pagto;
	}
	public String getEntregue() {
		return Entregue;
	}
	public void setEntregue(String entregue) {
		Entregue = entregue;
	}
	public String getValor_Total() {
		return Valor_Total;
	}
	public void setValor_Total(String valor_Total) {
		Valor_Total = valor_Total;
	}
	public String getNroParc() {
		return NroParc;
	}
	public void setNroParc(String nroParc) {
		NroParc = nroParc;
	}
	public String getValor_Parcela() {
		return Valor_Parcela;
	}
	public void setValor_Parcela(String valor_Parcela) {
		Valor_Parcela = valor_Parcela;
	}	
}