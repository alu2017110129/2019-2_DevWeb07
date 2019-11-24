package br.com.cadastro.jdbc;
import java.sql.*;

public class ConnectionFactory {

	public Connection getConnection() throws ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
        	return DriverManager.getConnection("jdbc:mysql://185.224.138.91/u399797101_conta?autoReconnect=true", "u399797101_root", "FaccJan2010jlfs");
        }catch(SQLException e){
        	System.out.println("Erro de conexao");
			throw new RuntimeException(e+"\nNAO FOI POSSIVEL CONECTAR NO BANCO DE DADOS");
		}       
	}	
}