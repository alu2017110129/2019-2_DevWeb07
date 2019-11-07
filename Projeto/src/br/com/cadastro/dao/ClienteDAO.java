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

import br.com.cadastro.model.Cliente;

@Repository
public class ClienteDAO {
	Connection connection;
	
	@Autowired
	public ClienteDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Cliente cliente){
		String sql = "insert into clientes (Codigo, Nome, Endereco, Numero, Bairro, Cidade, UF, CEP, email, Telefone, Celular, Contato, Técnico, Complemento, Foto) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, cliente.getCodigo());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndereco());
			stmt.setInt(4, cliente.getNumero());
			stmt.setString(5, cliente.getBairro());
			stmt.setString(6, cliente.getCidade());
			
			//faltam outros campos
						
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Cliente> lista(){
		try{
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM clientes");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Cliente cliente = new Cliente();
												
				cliente.setCodigo(rs.getInt("Codigo"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setEndereco(rs.getString("Endereco"));
				cliente.setNumero(rs.getInt("Numero"));
				cliente.setBairro(rs.getString("Bairro"));
				cliente.setCidade(rs.getString("Cidade"));
				cliente.setUF(rs.getString("UF"));
				cliente.setCEP(rs.getString("CEP"));
				cliente.setemail(rs.getString("email"));
				cliente.setTelefone(rs.getString("Telefone"));
				cliente.setCelular(rs.getString("Celular"));
				cliente.setContato(rs.getString("Contato"));
				cliente.setTecnico(rs.getString("Tecnico"));
				cliente.setComplemento(rs.getString("Complemento"));
				cliente.setFoto(rs.getString("Foto"));

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
	
			
			}catch(SQLException e){

				throw new RuntimeException(e);
		}
	}
	
	public void remove(Cliente cliente){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from clientes where Codigo = ?");
			
			stmt.setInt(1, cliente.getCodigo());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Cliente buscaPorCodigo(Integer codigo){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(codigo == rs.getInt("Codigo"))
				{
					Cliente cliente = new Cliente();

					cliente.setCodigo(rs.getInt("Codigo"));
					cliente.setNome(rs.getString("Nome"));
					cliente.setEndereco(rs.getString("Endereco"));
					cliente.setNumero(rs.getInt("Numero"));
					cliente.setBairro(rs.getString("Bairro"));
					cliente.setCidade(rs.getString("Cidade"));
					cliente.setUF(rs.getString("UF"));
					cliente.setCEP(rs.getString("CEP"));
					cliente.setTelefone(rs.getString("Telefone"));
					cliente.setCelular(rs.getString("Celular"));
					cliente.setemail(rs.getString("email"));
					cliente.setComplemento(rs.getString("Complemento"));
					
					return cliente;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Cliente cliente){
		String sql = "update clientes set nome=?, endereco=?, numero=?, bairro=?, cidade=?, UF=?, telefone=?, celular=?, CEP=?, email=?, complemento=? where codigo=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getNumero());
			stmt.setString(4, cliente.getBairro());
			stmt.setString(5, cliente.getCidade());
			stmt.setString(6, cliente.getUF());
			stmt.setString(7, cliente.getTelefone());
			stmt.setString(8, cliente.getCelular());
			stmt.setString(9, cliente.getCEP());
			stmt.setString(10, cliente.getemail());
			stmt.setString(11, cliente.getComplemento());
			stmt.setInt(12, cliente.getCodigo());
							
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
