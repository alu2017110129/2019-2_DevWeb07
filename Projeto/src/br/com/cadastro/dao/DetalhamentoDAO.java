package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			("SELECT * FROM detalhamentos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Detalhamento Detalhamento = new Detalhamento();

				Detalhamento.setOcorrência(rs.getInt("Ocorrência"));
				Detalhamento.setCodItem(rs.getInt("CodItem"));
				Detalhamento.setQuant(rs.getInt("Quant"));
				Detalhamento.setDescrição_Peça_Serviço(rs.getString("Descrição_Peça_Serviço"));
				Detalhamento.setCusto(rs.getString("Custo"));
				Detalhamento.setValor(rs.getString("Valor"));
				Detalhamento.setObservação(rs.getString("Observação"));
				Detalhamento.setOrdem(rs.getInt("Ordem"));

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
			
			stmt.setInt(1, Detalhamento.getOcorrência());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Detalhamento buscaPorOcorrencia(Integer Ocorrência){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from Detalhamentos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(Ocorrência == rs.getInt("Ocorrência"))
				{
					Detalhamento Detalhamento = new Detalhamento();

					Detalhamento.setOcorrência(rs.getInt("Ocorrência"));
					Detalhamento.setCodItem(rs.getInt("CodItem"));
					Detalhamento.setQuant(rs.getInt("Quant"));
					Detalhamento.setDescrição_Peça_Serviço(rs.getString("Descrição_Peça_Serviço"));
					Detalhamento.setCusto(rs.getString("Custo"));
					Detalhamento.setValor(rs.getString("Valor"));
					Detalhamento.setObservação(rs.getString("Observação"));
					Detalhamento.setOrdem(rs.getInt("Ordem"));

					return Detalhamento;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Detalhamento Detalhamento){
		String sql = "update detalhamentos set CodItem=?, Quant=?, Descrição_Peça_Serviço=?, Custo=?, Valor=?, Observação=?, Ordem=? where Ocorrência=?";
		
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
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
