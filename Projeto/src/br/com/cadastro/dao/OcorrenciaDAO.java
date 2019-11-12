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
	
	public void adiciona(Ocorrencia Ocorrencia){
		String sql = "insert into ocorrencias (Ocorrência,Data,CodCli,Nome_Razão_Social,Tipo,Marca,Modelo,Série,Voltagem,Problema_Informado,Defeito_Detectado,Hora,Concluído,Cancelado,Pago,Data_Pagto,Entregue,Valor_Total,NroParc,Valor_Parcela) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1,Ocorrencia.getOcorrencia());
			if(Ocorrencia.getData() != null)
			{
				stmt.setDate(3, new java.sql.Date(Ocorrencia.getData().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(3, null);
			}
			stmt.setInt(4,Ocorrencia.getCodCli());
			stmt.setString(5,Ocorrencia.getNome_Razão_Social());
			stmt.setString(6,Ocorrencia.getTipo());
			stmt.setString(7,Ocorrencia.getMarca());
			stmt.setString(8,Ocorrencia.getModelo());
			stmt.setString(9,Ocorrencia.getSérie());
			stmt.setString(10, Ocorrencia.getVoltagem());
			stmt.setString(11,Ocorrencia.getProblema_Informado());
			stmt.setString(12,Ocorrencia.getDefeito_Detectado());
			stmt.setString(13, Ocorrencia.getHora());
			stmt.setBoolean(14, Ocorrencia.isConcluído());
			stmt.setBoolean(15,Ocorrencia.isCancelado());
			stmt.setBoolean(16, Ocorrencia.isPago());
			stmt.setString(17, Ocorrencia.getEntregue());
			if(Ocorrencia.getData() != null)
			{
				stmt.setDate(18, new java.sql.Date(Ocorrencia.getData_Pagto().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(18, null);
			}
			stmt.setString(19,Ocorrencia.getValor_Total());
			stmt.setString(20, Ocorrencia.getNroParc());
			stmt.setString(21, Ocorrencia.getValor_Parcela());

			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Ocorrencia> lista(){
		try{
			List<Ocorrencia> Ocorrencias = new ArrayList<Ocorrencia>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM ocorrencias");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Ocorrencia Ocorrencia = new Ocorrencia();

				Ocorrencia.setOcorrencia(rs.getInt("Ocorrencia"));
				if(rs.getDate("Data") != null){
					Calendar Data = Calendar.getInstance();
					Data.setTime(rs.getDate("Data"));
					Ocorrencia.setData(Data);
				}
				Ocorrencia.setCodCli(rs.getInt("CodCli"));
				Ocorrencia.setNome_Razão_Social(rs.getString("Nome_Razão_Social"));
				Ocorrencia.setTipo(rs.getString("Tipo"));
				Ocorrencia.setMarca(rs.getString("Marca"));
				Ocorrencia.setModelo(rs.getString("Modelo"));
				Ocorrencia.setSérie(rs.getString("Série"));
				Ocorrencia.setVoltagem(rs.getString("Voltagem"));
				Ocorrencia.setProblema_Informado(rs.getString("Problema_Informado"));
				Ocorrencia.setDefeito_Detectado(rs.getString("Defeito_Detectado"));
				Ocorrencia.setHora(rs.getString("Hora"));
				Ocorrencia.setConcluído(rs.getBoolean("Concluído"));
				Ocorrencia.setCancelado(rs.getBoolean("Cancelado"));
				Ocorrencia.setPago(rs.getBoolean("Pago"));
				if(rs.getDate("Data") != null){
					Calendar Data = Calendar.getInstance();
					Data.setTime(rs.getDate("Data_Pagto"));
					Ocorrencia.setData(Data);
				}
				Ocorrencia.setEntregue(rs.getString("Entregue"));
				Ocorrencia.setValor_Total(rs.getString("Valor_Total"));
				Ocorrencia.setNroParc(rs.getString("NroParc"));
				Ocorrencia.setValor_Parcela(rs.getString("Valor_Parcela"));

				Ocorrencias.add(Ocorrencia);
			}
			rs.close();
			stmt.close();
			return Ocorrencias;
	
			
			}catch(SQLException e){

				throw new RuntimeException(e);
		}
	}
	
	public void remove(Ocorrencia Ocorrencia){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from ocorrencias where Ocorrência = ?");
			
			stmt.setInt(1, Ocorrencia.getOcorrencia());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Ocorrencia buscaPorOcorrencia(Integer Ocorrência){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from Ocorrencias");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(Ocorrência == rs.getInt("Ocorrencia"))
				{
					Ocorrencia Ocorrencia = new Ocorrencia();

					Ocorrencia.setOcorrencia(rs.getInt("Ocorrencia"));
					Ocorrencia.setNome(rs.getString("Nome"));
					if(rs.getDate("Data") != null){
						Calendar Data = Calendar.getInstance();
						Data.setTime(rs.getDate("Data"));
						Ocorrencia.setData(Data);
					}
					Ocorrencia.setCodCli(rs.getInt("CodCli"));
					Ocorrencia.setNome_Razão_Social(rs.getString("Nome_Razão_Social"));
					Ocorrencia.setTipo(rs.getString("Tipo"));
					Ocorrencia.setMarca(rs.getString("Marca"));
					Ocorrencia.setModelo(rs.getString("Modelo"));
					Ocorrencia.setSérie(rs.getString("Série"));
					Ocorrencia.setVoltagem(rs.getString("Voltagem"));
					Ocorrencia.setProblema_Informado(rs.getString("Problema_Informado"));
					Ocorrencia.setDefeito_Detectado(rs.getString("Defeito_Detectado"));
					Ocorrencia.setHora(rs.getString("Hora"));
					Ocorrencia.setConcluído(rs.getBoolean("Concluído"));
					Ocorrencia.setCancelado(rs.getBoolean("Cancelado"));
					Ocorrencia.setPago(rs.getBoolean("Pago"));
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
		String sql = "update ocorrencias set Data=?, CodCli=?, Nome_Razão_Social=?, Tipo=?, Marca=?, Modelo=?, Série=?, Voltagem=?, Problema_Informado=?, Defeito_Detectado=?, Hora=?, Concluído=?, Cancelado=?, Pago=?, Data_Pagto=?, Entregue=?, Valor_Total=?, NroParc=?, Valor_Parcela=? where Ocorrência=?";
		
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
			stmt.setString(4,Ocorrencia.getNome_Razão_Social());
			stmt.setString(5,Ocorrencia.getTipo());
			stmt.setString(6,Ocorrencia.getMarca());
			stmt.setString(7,Ocorrencia.getModelo());
			stmt.setString(8,Ocorrencia.getSérie());
			stmt.setString(9, Ocorrencia.getVoltagem());
			stmt.setString(10,Ocorrencia.getProblema_Informado());
			stmt.setString(11,Ocorrencia.getDefeito_Detectado());
			stmt.setString(12, Ocorrencia.getHora());
			stmt.setBoolean(13, Ocorrencia.isConcluído());
			stmt.setBoolean(14,Ocorrencia.isCancelado());
			stmt.setBoolean(15, Ocorrencia.isPago());
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
