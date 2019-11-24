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
	
	public void adiciona(Produto produto){
		String sql = "insert into produtos (Id, Serviço, Custo, Valor, Fornecedor, Margem) " +
					"values (?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, produto.getId());
			stmt.setString(2, produto.getServiço());
			stmt.setString(3, produto.getCusto());
			stmt.setString(4, produto.getValor());
			stmt.setString(5, produto.getFornecedor());
			stmt.setString(6, produto.getMargem());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Produto> lista(){
		try{
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM produtos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Produto produto = new Produto();
												
				produto.setId(rs.getInt("Id"));
				produto.setServiço(rs.getString("Serviço"));
				produto.setCusto(rs.getString("Custo"));
				produto.setValor(rs.getString("Valor"));
				produto.setFornecedor(rs.getString("Fornecedor"));
				produto.setMargem(rs.getString("Margem"));
				
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Produto produto){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from produtos where Id = ?");
			
			stmt.setInt(1, produto.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Produto buscaPorCodigo(Integer Id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(Id == rs.getInt("Id"))
				{
					Produto produto = new Produto();

					produto.setId(rs.getInt("Id"));
					produto.setServiço(rs.getString("Serviço"));
					produto.setCusto(rs.getString("Custo"));
					produto.setValor(rs.getString("Valor"));
					produto.setFornecedor(rs.getString("Fornecedor"));
					produto.setMargem(rs.getString("Margem"));
					
					stmt.close();
					return produto;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Produto produto){
		String sql = "update produtos set Serviço=? , Custo=?, Valor=?, Fornecedor=?, Margem=? where Id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, produto.getServiço());
			stmt.setString(2, produto.getCusto());
			stmt.setString(3, produto.getValor());
			stmt.setString(4, produto.getFornecedor()); 
			stmt.setString(5, produto.getMargem());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
