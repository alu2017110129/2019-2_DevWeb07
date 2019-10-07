<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro Clientes</title>
</head>
<body>
<c:import url="/WEB-INF/views/principal/menu.jsp"/>
	<br />
	<a href="novoCliente">Cadastrar novo Cliente</a>
	<br />
	<br />
	<table>
		<tr>
			<th>Codigo</th>
			<th>Nome</th>
			<th>Endereco</th>
			<th>Numero</th>			
			<th>Bairro</th>
			<th>Cidade</th>
			<th>UF</th>	
			<th>CEP</th>	
			<th>Email</th>	
			<th>Telefone</th>	
			<th>Celular</th>	
			<th>Contato</th>	
			<th>Técnico</th>	
			<th>Complemento</th>	
			<th>Foto</th>	
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${clientes}" var="cliente">
			<tr>
  			    <td>${cliente.Codigo}</td>
				<td>${cliente.Nome}</td>
				<td>${cliente.Endereco}</td>
				<td>${cliente.Numero}</td>
				<td>${cliente.Bairro}</td>
				<td>${cliente.Cidade}</td>	
				<td>${cliente.UF}</td>	
				<td>${cliente.CEP}</td>	
				<td>${cliente.email}</td>	
				<td>${cliente.Telefone}</td>	
				<td>${cliente.Celular}</td>	
				<td>${cliente.Contato}</td>	
				<td>${cliente.Técnico}</td>	
				<td>${cliente.Complemento}</td>	
				<td>${cliente.Foto}</td>							
				<td><a href="editaCliente?Codigo=${cliente.Codigo}" title="Editar">Editar</a></td>
				<td><a href="removeCliente?Codigo=${cliente.Codigo}" title="Excluir">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>