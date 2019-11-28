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
import br.com.cadastro.model.Usuario;

@Repository
public class OcorrenciaDAO {
	Connection connection;
	
	@Autowired
	public OcorrenciaDAO(DataSource dataSource) throws ClassNotFoundException{
		
		try {		
		if (this.connection != dataSource.getConnection()){
            this.connection = dataSource.getConnection();}
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}	
	public void adiciona(Ocorrencia ocorrencia){
		String sql = "insert into ocorrencias (Id,Data,CodCli,Cliente,Tipo,Marca,Modelo,Série,Voltagem,Problema,Defeito,Hora,Concluído,Cancelado,Pago,Data_Pagto,Entregue,Valor_Total,NroParc,Valor_Parcela) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1,ocorrencia.getId());
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

				ocorrencia.setId(rs.getInt("Id"));
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
				ocorrencia.setSerie(rs.getString("Serie"));
				ocorrencia.setVoltagem(rs.getString("Voltagem"));
				ocorrencia.setProblema(rs.getString("Problema"));
				ocorrencia.setDefeito(rs.getString("Defeito"));
				ocorrencia.setHora(rs.getString("Hora"));
				ocorrencia.setConcluido(rs.getString("Concluido"));
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
			
			stmt.setInt(1, Ocorrencia.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Ocorrencia buscaPorOcorrencia(Integer id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select usuarios.login, clientes.Nome, ocorrencias.Data, ocorrencias.CodCli, ocorrencias.Cliente, ocorrencias.Id, ocorrencias.Marca, ocorrencias.Modelo, ocorrencias.Tipo, ocorrencias.Serie, ocorrencias.Voltagem,ocorrencias.Problema,ocorrencias.Defeito, ocorrencias.Hora, ocorrencias.Concluido, ocorrencias.Cancelado, ocorrencias.Pago, ocorrencias.Data_Pagto, ocorrencias.Entregue, ocorrencias.Valor_Total, ocorrencias.NroParc, ocorrencias.Valor_Parcela\n" + 
					"from ocorrencias \n" + 
					"inner join clientes on ocorrencias.CodCli = clientes.Codigo\n" + 
					"inner join usuarios on clientes.Tecnico = usuarios.id\n" + 
					"where ocorrencias.Id = ?;");

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
					Ocorrencia ocorrencia = new Ocorrencia();
					Usuario usuario = new Usuario();

					usuario.setLogin(rs.getString("login"));
					ocorrencia.setId(rs.getInt("Id"));
					if(rs.getDate("Data") != null){
						Calendar data = Calendar.getInstance();
						data.setTime(rs.getDate("Data"));
						ocorrencia.setData(data);
					}	
					ocorrencia.setCodCli(rs.getInt("CodCli"));
					ocorrencia.setCliente(rs.getString("Cliente"));
					ocorrencia.setTipo(rs.getString("Tipo"));
					ocorrencia.setMarca(rs.getString("Marca"));
					ocorrencia.setModelo(rs.getString("Modelo"));
					ocorrencia.setSerie(rs.getString("Serie"));
					ocorrencia.setVoltagem(rs.getString("Voltagem"));
					ocorrencia.setProblema(rs.getString("Problema"));
					ocorrencia.setDefeito(rs.getString("Defeito"));
					ocorrencia.setHora(rs.getString("Hora"));
					ocorrencia.setConcluido(rs.getString("Concluido"));
					ocorrencia.setCancelado(rs.getString("Cancelado"));
					ocorrencia.setPago(rs.getString("Pago"));
					if(rs.getDate("Data_Pagto") != null){
						Calendar dataPagto = Calendar.getInstance();
						dataPagto.setTime(rs.getDate("Data_Pagto"));
						ocorrencia.setData_Pagto(dataPagto);
					}
					ocorrencia.setEntregue(rs.getString("Entregue"));
					ocorrencia.setValor_Total(rs.getString("Valor_Total"));
					ocorrencia.setNroParc(rs.getInt("NroParc"));
					
					stmt.close();
					return ocorrencia;
			}
			
			return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	public void altera(Ocorrencia ocorrencia){
		String sql = "update ocorrencias set Data=?, CodCli=?, Cliente=?, Tipo=?, Marca=?, Modelo=?, Serie=?, Voltagem=?, Problema=?, Defeito=?, Hora=?, Concluido=?, Cancelado=?, Pago=?, Data_Pagto=?, Entregue=?, Valor_Total=?, NroParc=?, Valor_Parcela=? where Ocorrência=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1,ocorrencia.getId());
			if(ocorrencia.getData() != null)
			{
				stmt.setDate(2, new java.sql.Date(ocorrencia.getData().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(2, null);
			}
			stmt.setInt(3,ocorrencia.getCodCli());
			stmt.setString(4,ocorrencia.getCliente());
			stmt.setString(5,ocorrencia.getTipo());
			stmt.setString(6,ocorrencia.getMarca());
			stmt.setString(7,ocorrencia.getModelo());
			stmt.setString(8,ocorrencia.getSerie());
			stmt.setString(9,ocorrencia.getVoltagem());
			stmt.setString(10,ocorrencia.getProblema());
			stmt.setString(11,ocorrencia.getDefeito());
			stmt.setString(12,ocorrencia.getHora());
			stmt.setString(13,ocorrencia.getConcluido());
			stmt.setString(14,ocorrencia.getCancelado());
			stmt.setString(15,ocorrencia.getPago());
			stmt.setString(16,ocorrencia.getEntregue());
			if(ocorrencia.getData() != null)
			{
				stmt.setDate(17, new java.sql.Date(ocorrencia.getData_Pagto().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(17, null);
			}
			stmt.setString(18,ocorrencia.getValor_Total());
			stmt.setInt(19, ocorrencia.getNroParc());
			stmt.setString(20,ocorrencia.getValor_Parcela());
							
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}