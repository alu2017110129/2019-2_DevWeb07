<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Usuários</title>
</head>
<body>
<form action="adicionaUsuario" method="post" class="form-horizontal">
	<font > <h2 class="display-4">Cadastro de Usuários</h2> </font>

	<div class="form-row">
		<div class="form-group col-md-12">		
			<label for="Nome">Nome</label>  
			<input type="text" class="form-control" id="inputNome" value="${usuario.nome}">
 			<form:errors path="usuario.nome" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="Login">Login</label>
			<input type="text" class="form-control" id="inputlogin" value="${usuario.login}">
			<form:errors path="usuario.login" cssStyle="color:#B71C1C"/><br />
		</div>
		<div class="form-group col-md-6">		
			<label for="Senha">Senha</label>  
			<input type="password" class="form-control" id="inputSenha" value="${usuario.senha}">
			<form:errors path="usuario.senha" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<label for="DataNascimento">Data Nascimento</label>  
			<input class="form-control" type="date" id="inputDataNascimento" value ="${usuario.dataNascimento}">
		</div>
		<div class="form-group col-md-4">
			<label for="Altura">Altura</label>  
			<input type="text" class="form-control" id="inputaAltura" value="${usuario.altura}">
		</div>	
	</div>
	<div>
		<div>
			<button type="submit" class="btn btn-primary">Grava Inclusão</button>
			<button type="reset" class="btn btn-primary">Cancela Inclusão</button>
		</div>
	</div>
</form>
</body>
</html>