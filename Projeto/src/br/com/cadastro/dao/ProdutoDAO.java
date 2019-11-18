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
		String sql = "insert into produtos (Cod_item, Serviço, Custo_R, Valor_R, Fornecedor, Margem) " +
					"values (?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, produto.getCod_item());
			stmt.setString(2, produto.getServiço());
			stmt.setString(3, produto.getCusto_R());
			stmt.setString(4, produto.getValor_R());
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
												
				produto.setCod_item(rs.getInt("cod_item"));
				produto.setServiço(rs.getString("serviço"));
				produto.setCusto_R(rs.getString("custo_R"));
				produto.setValor_R(rs.getString("valor_R"));
				produto.setFornecedor(rs.getString("fornecedor"));
				produto.setMargem(rs.getString("margem"));
				
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
			("delete from produtos where Codigo = ?");
			
			stmt.setInt(1, produto.getCod_item());
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
					Produto produto = new Produto();

					produto.setCod_item(rs.getInt("Codigo"));
					produto.setServiço(rs.getString("Serviço"));
					produto.setCusto_R(rs.getString("custo"));
					produto.setValor_R(rs.getString("Valor"));
					produto.setFornecedor(rs.getString("fornecedor"));
					produto.setMargem(rs.getString("Margem"));
					
					return produto;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Produto produto){
		String sql = "update produtos set Nome=? , Endereco=?, Numero=?, Bairro=?, Cidade=?, Estado=? where Codigo=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, produto.getCod_item());
			stmt.setString(2, produto.getServiço());
			stmt.setString(3, produto.getCusto_R());
			stmt.setString(4, produto.getValor_R());
			stmt.setString(5, produto.getFornecedor());
			stmt.setString(6, produto.getMargem());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
