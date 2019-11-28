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

import br.com.cadastro.model.OcorrenciaDetalhamentoView;
import br.com.cadastro.model.Usuario;

@Repository
public class OcorrenciaDetalhamentoDAO {
	Connection connection;

	@Autowired
	public OcorrenciaDetalhamentoDAO(DataSource dataSource) throws ClassNotFoundException{
		
		try {		
		if (this.connection != dataSource.getConnection()){
            this.connection = dataSource.getConnection();}
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}	
	
	public OcorrenciaDetalhamentoView buscaPorOcorrenciaDetalhamento(Integer id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from ocorrencias"
					+ " inner join detalhamentos on ocorrencias.Id = detalhamentos.Ocorrência"
					+ " where ocorrencias.id = ?;");

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
					OcorrenciaDetalhamentoView ocorrenciadetalhamento = new OcorrenciaDetalhamentoView();
					
					ocorrenciadetalhamento.setId(rs.getInt("Id"));
					if(rs.getDate("Data") != null){
						Calendar data = Calendar.getInstance();
						data.setTime(rs.getDate("Data"));
						ocorrenciadetalhamento.setData(data);
					}	
					ocorrenciadetalhamento.setCodCli(rs.getInt("CodCli"));
					ocorrenciadetalhamento.setCliente(rs.getString("Cliente"));
					ocorrenciadetalhamento.setTipo(rs.getString("Tipo"));
					ocorrenciadetalhamento.setMarca(rs.getString("Marca"));
					ocorrenciadetalhamento.setModelo(rs.getString("Modelo"));
					ocorrenciadetalhamento.setSerie(rs.getString("Serie"));
					ocorrenciadetalhamento.setVoltagem(rs.getString("Voltagem"));
					ocorrenciadetalhamento.setProblema(rs.getString("Problema"));
					ocorrenciadetalhamento.setDefeito(rs.getString("Defeito"));
					ocorrenciadetalhamento.setHora(rs.getString("Hora"));
					ocorrenciadetalhamento.setConcluido(rs.getString("Concluido"));
					ocorrenciadetalhamento.setCancelado(rs.getString("Cancelado"));
					ocorrenciadetalhamento.setPago(rs.getString("Pago"));
					if(rs.getDate("Data_Pagto") != null){
						Calendar dataPagto = Calendar.getInstance();
						dataPagto.setTime(rs.getDate("Data_Pagto"));
						ocorrenciadetalhamento.setData_Pagto(dataPagto);
					}
					ocorrenciadetalhamento.setEntregue(rs.getString("Entregue"));
					ocorrenciadetalhamento.setValor_Total(rs.getString("Valor_Total"));
					ocorrenciadetalhamento.setNroParc(rs.getInt("NroParc"));
					ocorrenciadetalhamento.setCodItem(rs.getInt("CodItem"));
					ocorrenciadetalhamento.setQuant(rs.getInt("Quant"));
					ocorrenciadetalhamento.setDescrição_Peça_Serviço(rs.getString("Descrição_Peça_Serviço"));
					ocorrenciadetalhamento.setCusto(rs.getString("Custo"));
					ocorrenciadetalhamento.setValor(rs.getString("Valor"));
					ocorrenciadetalhamento.setObservação(rs.getString("Observação"));

					
					stmt.close();
					return ocorrenciadetalhamento;
			}
			
			return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}

}
