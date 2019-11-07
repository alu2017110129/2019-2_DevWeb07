<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="resources/css/styles.css">

<head>
	<title>Sistema Cadastro Usuarios</title>
</head>
<body>
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
  <div class="mx-auto" style="width: 2000px;">
	<table class="table">
  		<thead class="thead-ligth">
			<tr>
				<th></th>
				<th><a href="novoUsuario" class="btn btn-primary btn-info">Cadastrar novo Usuário</a></th>
				<th></th>
				<th><h3>MANUTENÇÃO DE USUÁRIOS</h3></th>
				<th></th>
			</tr>
		</thead>
	</table>
	<table class="table table-striped" BORDER="1">
  		<thead class="thead-dark">
  			<tr>
 				<th>Id</th>
				<th align="center">Nome</th>
				<th >Login</th>
				<th align="center">Data de Nascimento</th>
				<th >Altura</th>
				<th >Alterar</th>
				<th >Excluir</th>
			</tr>
		</thead>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td ALIGN="left" WIDTH="2000">${usuario.nome}</td>
				<td>${usuario.login}</td>
				<td ALIGN="left" WIDTH="800"><fmt:formatDate value="${usuario.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
				<td>${usuario.altura}</td>
				<td><a href="editaUsuario?id=${usuario.id}" title="Editar">EDITAR</a></td>
				<td><a href="removeUsuario?id=${usuario.id}" title="Excluir">EXCLUIR</a></td>
			</tr>
		</c:forEach>
	</table>
  </div>
</body>
<c:import url="/WEB-INF/views/principal/footer.jsp"/>
</html>