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

import br.com.cadastro.model.Produto;

@Repository
public class ProdutoDAO {
	Connection connection;
	
	@Autowired
	public ProdutoDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Produto Produto){
		String sql = "insert into Produtos (Cod_item, Serviço, Custo_R, Valor_R, Fornecedor, Margem) " +
					"values (?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, Produto.getCod_item());
			stmt.setString(2, Produto.getServiço());
			stmt.setString(3, Produto.getCusto_R());
			stmt.setString(4, Produto.getValor_R());
			stmt.setString(5, Produto.getFornecedor());
			stmt.setString(6, Produto.getMargem());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Produto> lista(){
		try{
			List<Produto> Produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM Produtos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Produto Produto = new Produto();
												
				Produto.setCod_item(rs.getInt("cod_item"));
				Produto.setServiço(rs.getString("serviço"));
				Produto.setCusto_R(rs.getString("custo_R"));
				Produto.setValor_R(rs.getString("valor_R"));
				Produto.setFornecedor(rs.getString("fornecedor"));
				Produto.setMargem(rs.getString("margem"));
				Produtos.add(Produto);
			}
			rs.close();
			stmt.close();
			return Produtos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Produto Produto){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from Produtos where Codigo = ?");
			
			stmt.setInt(1, Produto.getCod_item());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Produto buscaPorCodigo(Integer codigo){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from Produtos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(codigo == rs.getInt("Codigo"))
				{
					Produto Produto = new Produto();

					Produto.setCod_item(rs.getInt("Codigo"));
					Produto.setServiço(rs.getString("Serviço"));
					Produto.setCusto_R(rs.getString("custo"));
					Produto.setValor_R(rs.getString("Valor"));
					Produto.setFornecedor(rs.getString("fornecedor"));
					Produto.setMargem(rs.getString("Margem"));
					
					return Produto;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Produto Produto){
		String sql = "update Produtos set Nome=? , Endereco=?, Numero=?, Bairro=?, Cidade=?, Estado=? where Codigo=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, Produto.getCod_item());
			stmt.setString(2, Produto.getServiço());
			stmt.setString(3, Produto.getCusto_R());
			stmt.setString(4, Produto.getValor_R());
			stmt.setString(5, Produto.getFornecedor());
			stmt.setString(6, Produto.getMargem());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
