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
import br.com.cadastro.model.Detalhamento;

@Repository
public class DetalhamentoDAO {
	Connection connection;
	
	@Autowired
	public DetalhamentoDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Detalhamento Detalhamento){
		String sql = "insert into detalhamentos (Ocorrência, codItem, Quant, Descriçao_Peça_Serviço, Custo, Valor, Observação, Ordem) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1,Detalhamento.getOcorrência());
			stmt.setInt(2,Detalhamento.getCodItem());
			stmt.setInt(3,Detalhamento.getQuant());
			stmt.setString(4,Detalhamento.getDescrição_Peça_Serviço());
			stmt.setString(5,Detalhamento.getCusto());
			stmt.setString(6,Detalhamento.getValor());
			stmt.setString(7,Detalhamento.getObservação());
			stmt.setInt(8,Detalhamento.getOrdem());

			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Detalhamento> lista(){
		try{
			List<Detalhamento> Detalhamentos = new ArrayList<Detalhamento>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM Detalhamentos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Detalhamento Detalhamento = new Detalhamento();

				Detalhamento.setDetalhamento(rs.getInt("Ocorrência"));
				if(rs.getDate("Data") != null){
					Calendar Data = Calendar.getInstance();
					Data.setTime(rs.getDate("Data"));
					Detalhamento.setData(Data);
				}
				Detalhamento.setCodCli(rs.getInt("CodCli"));
				Detalhamento.setNome_Razão_Social(rs.getString("Nome_Razão_Social"));
				Detalhamento.setTipo(rs.getString("Tipo"));
				Detalhamento.setMarca(rs.getString("Marca"));
				Detalhamento.setModelo(rs.getString("Modelo"));
				Detalhamento.setSerie(rs.getString("Série"));
				Detalhamento.setVoltagem(rs.getString("Voltagem"));
				Detalhamento.setProblema_Informado(rs.getString("Problema_Informado"));
				Detalhamento.setDefeito_Detectado(rs.getString("Defeito_Detectado"));
				Detalhamento.setHora(rs.getString("Hora"));
				Detalhamento.setConcluido(rs.getString("Concluído"));
				Detalhamento.setCancelado(rs.getString("Cancelado"));
				Detalhamento.setPago(rs.getString("Pago"));
				if(rs.getDate("Data_Pagto") != null){
					Calendar Data = Calendar.getInstance();
					Data.setTime(rs.getDate("Data_Pagto"));
					Detalhamento.setData(Data);
				}
				Detalhamento.setEntregue(rs.getString("Entregue"));
				Detalhamento.setValor_Total(rs.getString("Valor_Total"));
				Detalhamento.setNroParc(rs.getInt("NroParc"));
				Detalhamento.setValor_Parcela(rs.getString("Valor_Parcela"));

				Detalhamentos.add(Detalhamento);
			}
			rs.close();
			stmt.close();
			return Detalhamentos;
	
			
			}catch(SQLException e){

				throw new RuntimeException(e);
		}
	}
	
	public void remove(Detalhamento Detalhamento){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from Detalhamentos where Ocorrência = ?");
			
			stmt.setInt(1, Detalhamento.getDetalhamento());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Detalhamento buscaPorDetalhamento(Integer Ocorrência){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from Detalhamentos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(Ocorrência == rs.getInt("Ocorrência"))
				{
					Detalhamento Detalhamento = new Detalhamento();

					Detalhamento.setDetalhamento(rs.getInt("Ocorrência"));
					Detalhamento.setNome_Razão_Social(rs.getString("Nome_Razão_Social"));
					if(rs.getDate("Data") != null){
						Calendar Data = Calendar.getInstance();
						Data.setTime(rs.getDate("Data"));
						Detalhamento.setData(Data);
					}
					Detalhamento.setCodCli(rs.getInt("CodCli"));
					Detalhamento.setTipo(rs.getString("Tipo"));
					Detalhamento.setMarca(rs.getString("Marca"));
					Detalhamento.setModelo(rs.getString("Modelo"));
					Detalhamento.setSerie(rs.getString("Série"));
					Detalhamento.setVoltagem(rs.getString("Voltagem"));
					Detalhamento.setProblema_Informado(rs.getString("Problema_Informado"));
					Detalhamento.setDefeito_Detectado(rs.getString("Defeito_Detectado"));
					Detalhamento.setHora(rs.getString("Hora"));
					Detalhamento.setConcluido(rs.getString("Concluído"));
					Detalhamento.setCancelado(rs.getString("Cancelado"));
					Detalhamento.setPago(rs.getString("Pago"));
					if(rs.getDate("Data") != null){
						Calendar Data = Calendar.getInstance();
						Data.setTime(rs.getDate("Data_Pagto"));
						Detalhamento.setData(Data);
					}
					Detalhamento.setEntregue(rs.getString("Entregue"));
					Detalhamento.setValor_Total(rs.getString("Valor_Total"));
					Detalhamento.setNroParc(rs.getInt("NroParc"));
					Detalhamento.setValor_Parcela(rs.getString("Valor_Parcela"));
					
					return Detalhamento;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Detalhamento Detalhamento){
		String sql = "update Detalhamentos set Data=?, CodCli=?, Nome_Razão_Social=?, Tipo=?, Marca=?, Modelo=?, Série=?, Voltagem=?, Problema_Informado=?, Defeito_Detectado=?, Hora=?, Concluído=?, Cancelado=?, Pago=?, Data_Pagto=?, Entregue=?, Valor_Total=?, NroParc=?, Valor_Parcela=? where Ocorrência=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1,Detalhamento.getDetalhamento());
			if(Detalhamento.getData() != null)
			{
				stmt.setDate(2, new java.sql.Date(Detalhamento.getData().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(2, null);
			}
			stmt.setInt(3,Detalhamento.getCodCli());
			stmt.setString(4,Detalhamento.getNome_Razão_Social());
			stmt.setString(5,Detalhamento.getTipo());
			stmt.setString(6,Detalhamento.getMarca());
			stmt.setString(7,Detalhamento.getModelo());
			stmt.setString(8,Detalhamento.getSerie());
			stmt.setString(9, Detalhamento.getVoltagem());
			stmt.setString(10,Detalhamento.getProblema_Informado());
			stmt.setString(11,Detalhamento.getDefeito_Detectado());
			stmt.setString(12, Detalhamento.getHora());
			stmt.setString(13, Detalhamento.getConcluido());
			stmt.setString(14,Detalhamento.getCancelado());
			stmt.setString(15, Detalhamento.getPago());
			stmt.setString(16, Detalhamento.getEntregue());
			if(Detalhamento.getData() != null)
			{
				stmt.setDate(17, new java.sql.Date(Detalhamento.getData_Pagto().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(17, null);
			}
			stmt.setString(18,Detalhamento.getValor_Total());
			stmt.setInt(19, Detalhamento.getNroParc());
			stmt.setString(20, Detalhamento.getValor_Parcela());
							
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
