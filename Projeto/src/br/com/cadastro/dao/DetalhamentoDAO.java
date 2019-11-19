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
		String sql = "insert into detalhamentos (Ocorr�ncia, codItem, Quant, Descri�ao_Pe�a_Servi�o, Custo, Valor, Observa��o, Ordem) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1,Detalhamento.getOcorr�ncia());
			stmt.setInt(2,Detalhamento.getCodItem());
			stmt.setInt(3,Detalhamento.getQuant());
			stmt.setString(4,Detalhamento.getDescri��o_Pe�a_Servi�o());
			stmt.setString(5,Detalhamento.getCusto());
			stmt.setString(6,Detalhamento.getValor());
			stmt.setString(7,Detalhamento.getObserva��o());
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

				Detalhamento.setOcorr�ncia(rs.getInt("Ocorr�ncia"));
				Detalhamento.setCodItem(rs.getInt("CodItem"));
				Detalhamento.setQuant(rs.getInt("Quant"));
				Detalhamento.setDescri��o_Pe�a_Servi�o(rs.getString("Descri��o_Pe�a_Servi�o"));
				Detalhamento.setCusto(rs.getString("Custo"));
				Detalhamento.setValor(rs.getString("Valor"));
				Detalhamento.setObserva��o(rs.getString("Observa��o"));
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
			("delete from Detalhamentos where Ocorr�ncia = ?");
			
			stmt.setInt(1, Detalhamento.getOcorr�ncia());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Detalhamento buscaPorOcorrencia(Integer Ocorr�ncia){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from Detalhamentos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(Ocorr�ncia == rs.getInt("Ocorr�ncia"))
				{
					Detalhamento Detalhamento = new Detalhamento();

					Detalhamento.setOcorr�ncia(rs.getInt("Ocorr�ncia"));
					Detalhamento.setCodItem(rs.getInt("CodItem"));
					Detalhamento.setQuant(rs.getInt("Quant"));
					Detalhamento.setDescri��o_Pe�a_Servi�o(rs.getString("Descri��o_Pe�a_Servi�o"));
					Detalhamento.setCusto(rs.getString("Custo"));
					Detalhamento.setValor(rs.getString("Valor"));
					Detalhamento.setObserva��o(rs.getString("Observa��o"));
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
		String sql = "update detalhamentos set CodItem=?, Quant=?, Descri��o_Pe�a_Servi�o=?, Custo=?, Valor=?, Observa��o=?, Ordem=? where Ocorr�ncia=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1,Detalhamento.getOcorr�ncia());
			stmt.setInt(2,Detalhamento.getCodItem());			
			stmt.setInt(3,Detalhamento.getQuant());
			stmt.setString(4,Detalhamento.getDescri��o_Pe�a_Servi�o());
			stmt.setString(5,Detalhamento.getCusto());
			stmt.setString(6,Detalhamento.getValor());
			stmt.setString(7,Detalhamento.getObserva��o());
			stmt.setInt(8,Detalhamento.getOrdem());
							
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
