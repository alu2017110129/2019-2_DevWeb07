<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="resources/css/styles.css">

<head>
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Clientes</title>
</head>
<body>
  <div>
	<table class="table">
	  <thead class="thead-ligth">
		<tr>
			<th></th>
	  		<th><a href="novoCliente" class="btn btn-primary btn-info">Cadastrar novo Cliente</a>
			<th></th>
			<th><h3>MANUTENÇÃO DE CLIENTES</h3></th>
			<th></th>
		</tr>
	  </thead>
	</table>	
    <table class="table table-striped" BORDER="1">
	  <thead class="thead-dark">
		<tr>
			<th>Codigo</th>
			<th align="center">Nome</th>
			<th align="center">Endereco</th>
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
				<td ALIGN="left" WIDTH="12000">${cliente.nome}</td>
				<td ALIGN="left" WIDTH="12000">${cliente.endereco}</td>
				<td>${cliente.numero}</td>
<!-- 			<td>${cliente.bairro}</td>
				<td>${cliente.cidade}</td>
				<td>${cliente.UF}</td>
				<td>${cliente.CEP}</td>	
				<td>${cliente.email}</td> -->	
				<td>${cliente.telefone}</td>
				<td>${cliente.celular}</td>	
 				<td>${cliente.contato}</td>	
<!--			<td>${cliente.tecnico}</td>	
				<td>${cliente.complemento}</td>	
				<td>${cliente.foto}</td> -->	
				<td><a href="editaCliente?Codigo=${cliente.codigo}" title="EDITAR">EDITAR</a></td>
				<td><a href="removeCliente?Codigo=${cliente.codigo}" title="EXCLUIR">EXCLUIR</a></td>
			</tr>
		</c:forEach>
	  </table>
  	</div>
	<c:import url="/WEB-INF/views/principal/footer.jsp"/>
  </body>
</html>