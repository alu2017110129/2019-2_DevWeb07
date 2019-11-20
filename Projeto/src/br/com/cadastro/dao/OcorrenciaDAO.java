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
		String sql = "insert into ocorrencias (Ocorrência,Data,CodCli,Cliente,Tipo,Marca,Modelo,Série,Voltagem,Problema,Defeito,Hora,Concluído,Cancelado,Pago,Data_Pagto,Entregue,Valor_Total,NroParc,Valor_Parcela) " +
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
			stmt.setString(5,ocorrencia.getCliente());
			stmt.setString(6,ocorrencia.getTipo());
			stmt.setString(7,ocorrencia.getMarca());
			stmt.setString(8,ocorrencia.getModelo());
			stmt.setString(9,ocorrencia.getSerie());
			stmt.setString(10,ocorrencia.getVoltagem());
			stmt.setString(11,ocorrencia.getProblema());
			stmt.setString(12,ocorrencia.getDefeito());
			stmt.setString(13,ocorrencia.getHora());
			stmt.setString(14,ocorrencia.getConcluido());
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
			stmt.setInt(20,ocorrencia.getNroParc());
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

				ocorrencia.setOcorrencia(rs.getInt("Ocorrência"));
				if(rs.getDate("Data") != null){
					Calendar Data = Calendar.getInstance();
					Data.setTime(rs.getDate("Data"));
					ocorrencia.setData(Data);
				}
				ocorrencia.setCodCli(rs.getInt("CodCli"));
				ocorrencia.setCliente(rs.getString("Cliente"));
				ocorrencia.setTipo(rs.getString("Tipo"));
				ocorrencia.setMarca(rs.getString("Marca"));
				ocorrencia.setModelo(rs.getString("Modelo"));
				ocorrencia.setSerie(rs.getString("Série"));
				ocorrencia.setVoltagem(rs.getString("Voltagem"));
				ocorrencia.setProblema(rs.getString("Problema"));
				ocorrencia.setDefeito(rs.getString("Defeito"));
				ocorrencia.setHora(rs.getString("Hora"));
				ocorrencia.setConcluido(rs.getString("Concluído"));
				ocorrencia.setCancelado(rs.getString("Cancelado"));
				ocorrencia.setPago(rs.getString("Pago"));
				if(rs.getDate("Data_Pagto") != null){
					Calendar Data = Calendar.getInstance();
					Data.setTime(rs.getDate("Data_Pagto"));
					ocorrencia.setData(Data);
				}
				ocorrencia.setEntregue(rs.getString("Entregue"));
				ocorrencia.setValor_Total(rs.getString("Valor_Total"));
				ocorrencia.setNroParc(rs.getInt("NroParc"));
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
			("delete from ocorrencias where Ocorrência = ?");
			
			stmt.setInt(1, Ocorrencia.getOcorrencia());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Ocorrencia buscaPorOcorrencia(Integer id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from ocorrencias");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getInt("Ocorrência"))
				{
					Ocorrencia ocorrencia = new Ocorrencia();

					ocorrencia.setOcorrencia(rs.getInt("Ocorrência"));
					ocorrencia.setCliente(rs.getString("Cliente"));
					if(rs.getDate("Data") != null){
						Calendar Data = Calendar.getInstance();
						Data.setTime(rs.getDate("Data"));
						ocorrencia.setData(Data);
					}
					ocorrencia.setCodCli(rs.getInt("CodCli"));
					ocorrencia.setTipo(rs.getString("Tipo"));
					ocorrencia.setMarca(rs.getString("Marca"));
					ocorrencia.setModelo(rs.getString("Modelo"));
					ocorrencia.setSerie(rs.getString("Série"));
					ocorrencia.setVoltagem(rs.getString("Voltagem"));
					ocorrencia.setProblema(rs.getString("Problema"));
					ocorrencia.setDefeito(rs.getString("Defeito"));
					ocorrencia.setHora(rs.getString("Hora"));
					ocorrencia.setConcluido(rs.getString("Concluído"));
					ocorrencia.setCancelado(rs.getString("Cancelado"));
					ocorrencia.setPago(rs.getString("Pago"));
					if(rs.getDate("Data") != null){
						Calendar Data = Calendar.getInstance();
						Data.setTime(rs.getDate("Data_Pagto"));
						ocorrencia.setData(Data);
					}
					ocorrencia.setEntregue(rs.getString("Entregue"));
					ocorrencia.setValor_Total(rs.getString("Valor_Total"));
					ocorrencia.setNroParc(rs.getInt("NroParc"));
					ocorrencia.setValor_Parcela(rs.getString("Valor_Parcela"));
					
					return ocorrencia;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Ocorrencia Ocorrencia){
		String sql = "update ocorrencias set Data=?, CodCli=?, Cliente=?, Tipo=?, Marca=?, Modelo=?, Série=?, Voltagem=?, Problema=?, Defeito=?, Hora=?, Concluído=?, Cancelado=?, Pago=?, Data_Pagto=?, Entregue=?, Valor_Total=?, NroParc=?, Valor_Parcela=? where Ocorrência=?";
		
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
			stmt.setString(4,Ocorrencia.getCliente());
			stmt.setString(5,Ocorrencia.getTipo());
			stmt.setString(6,Ocorrencia.getMarca());
			stmt.setString(7,Ocorrencia.getModelo());
			stmt.setString(8,Ocorrencia.getSerie());
			stmt.setString(9, Ocorrencia.getVoltagem());
			stmt.setString(10,Ocorrencia.getProblema());
			stmt.setString(11,Ocorrencia.getDefeito());
			stmt.setString(12, Ocorrencia.getHora());
			stmt.setString(13, Ocorrencia.getConcluido());
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
			stmt.setInt(19, Ocorrencia.getNroParc());
			stmt.setString(20, Ocorrencia.getValor_Parcela());
							
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}	
}
