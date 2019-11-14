package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.cadastro.model.Ocorrencia;

@Repository
public class OcorrenciaDAO {
	Connection connection;
	
	@Autowired
	public OcorrenciaDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Ocorrencia ocorrencia){
		String sql = "insert into ocorrencias (Ocorr�ncia,Data,CodCli,Nome_Raz�o_Social,Tipo,Marca,Modelo,S�rie,Voltagem,Problema_Informado,Defeito_Detectado,Hora,Conclu�do,Cancelado,Pago,Data_Pagto,Entregue,Valor_Total,NroParc,Valor_Parcela) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1,ocorrencia.getOcorrencia());
			if(ocorrencia.getData() != null)
			{
				stmt.setDate(3, new java.sql.Date(ocorrencia.getData().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(3, null);
			}
			stmt.setInt(4,ocorrencia.getCodCli());
			stmt.setString(5,ocorrencia.getNome_Raz�o_Social());
			stmt.setString(6,ocorrencia.getTipo());
			stmt.setString(7,ocorrencia.getMarca());
			stmt.setString(8,ocorrencia.getModelo());
			stmt.setString(9,ocorrencia.getS�rie());
			stmt.setString(10,ocorrencia.getVoltagem());
			stmt.setString(11,ocorrencia.getProblema_Informado());
			stmt.setString(12,ocorrencia.getDefeito_Detectado());
			stmt.setString(13,ocorrencia.getHora());
			stmt.setString(14,ocorrencia.getConclu�do());
			stmt.setString(15,ocorrencia.getCancelado());
			stmt.setString(16,ocorrencia.getPago());
			stmt.setString(17,ocorrencia.getEntregue());
			if(ocorrencia.getData() != null)
			{
				stmt.setDate(18, new java.sql.Date(ocorrencia.getData_Pagto().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(18, null);
			}
			stmt.setString(19,ocorrencia.getValor_Total());
			stmt.setString(20,ocorrencia.getNroParc());
			stmt.setString(21,ocorrencia.getValor_Parcela());

			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Ocorrencia> lista(){
		try{
			List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM ocorrencias");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Ocorrencia ocorrencia = new Ocorrencia();

				ocorrencia.setOcorrencia(rs.getInt("Ocorr�ncia"));
				if(rs.getDate("Data") != null){
					Calendar Data = Calendar.getInstance();
					Data.setTime(rs.getDate("Data"));
					ocorrencia.setData(Data);
				}
				ocorrencia.setCodCli(rs.getInt("CodCli"));
				ocorrencia.setNome_Raz�o_Social(rs.getString("Nome_Raz�o_Social"));
				ocorrencia.setTipo(rs.getString("Tipo"));
				ocorrencia.setMarca(rs.getString("Marca"));
				ocorrencia.setModelo(rs.getString("Modelo"));
				ocorrencia.setS�rie(rs.getString("S�rie"));
				ocorrencia.setVoltagem(rs.getString("Voltagem"));
				ocorrencia.setProblema_Informado(rs.getString("Problema_Informado"));
				ocorrencia.setDefeito_Detectado(rs.getString("Defeito_Detectado"));
				ocorrencia.setHora(rs.getString("Hora"));
				ocorrencia.setConclu�do(rs.getString("Conclu�do"));
				ocorrencia.setCancelado(rs.getString("Cancelado"));
				ocorrencia.setPago(rs.getString("Pago"));
				if(rs.getDate("Data_Pagto") != null){
					Calendar Data = Calendar.getInstance();
					Data.setTime(rs.getDate("Data_Pagto"));
					ocorrencia.setData(Data);
				}
				ocorrencia.setEntregue(rs.getString("Entregue"));
				ocorrencia.setValor_Total(rs.getString("Valor_Total"));
				ocorrencia.setNroParc(rs.getString("NroParc"));
				ocorrencia.setValor_Parcela(rs.getString("Valor_Parcela"));

				ocorrencias.add(ocorrencia);
			}
			rs.close();
			stmt.close();
			return ocorrencias;
	
			
			}catch(SQLException e){

				throw new RuntimeException(e);
		}
	}
	
	public void remove(Ocorrencia Ocorrencia){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from ocorrencias where Ocorr�ncia = ?");
			
			stmt.setInt(1, Ocorrencia.getOcorrencia());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Ocorrencia buscaPorOcorrencia(Integer Ocorr�ncia){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from Ocorrencias");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(Ocorr�ncia == rs.getInt("Ocorr�ncia"))
				{
					Ocorrencia Ocorrencia = new Ocorrencia();

					Ocorrencia.setOcorrencia(rs.getInt("Ocorr�ncia"));
					Ocorrencia.setNome_Raz�o_Social(rs.getString("Nome_Raz�o_Social"));
					if(rs.getDate("Data") != null){
						Calendar Data = Calendar.getInstance();
						Data.setTime(rs.getDate("Data"));
						Ocorrencia.setData(Data);
					}
					Ocorrencia.setCodCli(rs.getInt("CodCli"));
					Ocorrencia.setNome_Raz�o_Social(rs.getString("Nome_Raz�o_Social"));
					Ocorrencia.setTipo(rs.getString("Tipo"));
					Ocorrencia.setMarca(rs.getString("Marca"));
					Ocorrencia.setModelo(rs.getString("Modelo"));
					Ocorrencia.setS�rie(rs.getString("S�rie"));
					Ocorrencia.setVoltagem(rs.getString("Voltagem"));
					Ocorrencia.setProblema_Informado(rs.getString("Problema_Informado"));
					Ocorrencia.setDefeito_Detectado(rs.getString("Defeito_Detectado"));
					Ocorrencia.setHora(rs.getString("Hora"));
					Ocorrencia.setConclu�do(rs.getString("Conclu�do"));
					Ocorrencia.setCancelado(rs.getString("Cancelado"));
					Ocorrencia.setPago(rs.getString("Pago"));
					if(rs.getDate("Data") != null){
						Calendar Data = Calendar.getInstance();
						Data.setTime(rs.getDate("Data_Pagto"));
						Ocorrencia.setData(Data);
					}
					Ocorrencia.setEntregue(rs.getString("Entregue"));
					Ocorrencia.setValor_Total(rs.getString("Valor_Total"));
					Ocorrencia.setNroParc(rs.getString("NroParc"));
					Ocorrencia.setValor_Parcela(rs.getString("Valor_Parcela"));
					
					return Ocorrencia;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Ocorrencia Ocorrencia){
		String sql = "update ocorrencias set Data=?, CodCli=?, Nome_Raz�o_Social=?, Tipo=?, Marca=?, Modelo=?, S�rie=?, Voltagem=?, Problema_Informado=?, Defeito_Detectado=?, Hora=?, Conclu�do=?, Cancelado=?, Pago=?, Data_Pagto=?, Entregue=?, Valor_Total=?, NroParc=?, Valor_Parcela=? where Ocorr�ncia=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1,Ocorrencia.getOcorrencia());
			if(Ocorrencia.getData() != null)
			{
				stmt.setDate(2, new java.sql.Date(Ocorrencia.getData().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(2, null);
			}
			stmt.setInt(3,Ocorrencia.getCodCli());
			stmt.setString(4,Ocorrencia.getNome_Raz�o_Social());
			stmt.setString(5,Ocorrencia.getTipo());
			stmt.setString(6,Ocorrencia.getMarca());
			stmt.setString(7,Ocorrencia.getModelo());
			stmt.setString(8,Ocorrencia.getS�rie());
			stmt.setString(9, Ocorrencia.getVoltagem());
			stmt.setString(10,Ocorrencia.getProblema_Informado());
			stmt.setString(11,Ocorrencia.getDefeito_Detectado());
			stmt.setString(12, Ocorrencia.getHora());
			stmt.setString(13, Ocorrencia.getConclu�do());
			stmt.setString(14,Ocorrencia.getCancelado());
			stmt.setString(15, Ocorrencia.getPago());
			stmt.setString(16, Ocorrencia.getEntregue());
			if(Ocorrencia.getData() != null)
			{
				stmt.setDate(17, new java.sql.Date(Ocorrencia.getData_Pagto().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(17, null);
			}
			stmt.setString(18,Ocorrencia.getValor_Total());
			stmt.setString(19, Ocorrencia.getNroParc());
			stmt.setString(20, Ocorrencia.getValor_Parcela());
							
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
