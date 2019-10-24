<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Clientes</title>
</head>
<body>
	<p>
	  <a href="novoCliente" class="btn-primary btn-lg btn-block">Cadastrar novo Cliente</a>
	</p>
    <table class="table table-striped">
	  <thead class="thead-dark">
		<tr>
			<th>Codigo</th>
			<th>Nome</th>
			<th>Endereco</th>
			<th>Numero</th>
<!--  		<th>Bairro</th>
			<th>Cidade</th>
			<th>UF</th>
			<th>CEP</th>
			<th>Email</th> -->	
			<th>Telefone</th>
			<th>Celular</th>
			<th>Contato</th>
<!-- 		<th>Técnico</th>
			<th>Complemento</th>
			<th>Foto</th> -->	
			<th></th>
			<th></th>
		  </tr>
		</thead>
		<c:forEach items="${clientes}" var="cliente">
			<tr>
				<td>${cliente.codigo}</td>
				<td>${cliente.nome}</td>
				<td>${cliente.endereco}</td>
				<td>${cliente.numero}</td>
<!-- 			<td>${cliente.bairro}</td>
				<td>${cliente.cidade}</td>
				<td>${cliente.UF}</td>
				<td>${cliente.CEP}</td>	
				<td>${cliente.email}</td> -->	
				<td>${cliente.telefone}</td>
				<td>${cliente.celular}</td>	
<!-- 			<td>${cliente.contato}</td>	
				<td>${cliente.tecnico}</td>	
				<td>${cliente.complemento}</td>	
				<td>${cliente.foto}</td> -->	
				<td><a href="editaCliente?Codigo=${cliente.codigo}" title="Editar">Editar</a></td>
				<td><a href="removeCliente?Codigo=${cliente.codigo}" title="Excluir">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<c:import url="/WEB-INF/views/principal/footer.jsp"/>
</html>