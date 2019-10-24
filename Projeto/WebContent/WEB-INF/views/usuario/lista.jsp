<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Usuarios</title>
</head>
<body>
  <p>	
	<a href="novoUsuario" class="btn btn-primary btn-lg btn-block">Cadastrar novo Usuário</a>
  </p>
  <table class="table table-striped">
	 <thead class="thead-dark">
	    <tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Login</th>
			<th>Data de Nascimento</th>
			<th>Altura</th>
			<th></th>
			<th></th>
		</tr>
	 </thead>	
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.login}</td>
				<td><fmt:formatDate value="${usuario.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
				<td>${usuario.altura}</td>
				<td><a href="editaUsuario?id=${usuario.id}" title="Editar">Editar</a></td>
				<td><a href="removeUsuario?id=${usuario.id}" title="Excluir">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<c:import url="/WEB-INF/views/principal/footer.jsp"/>
</html>
