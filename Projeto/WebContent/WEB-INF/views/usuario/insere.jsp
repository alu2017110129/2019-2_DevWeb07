<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Usu�rios</title>
</head>
<body>
<div class="mx-auto" style="width: 700px;">
<form action="adicionaUsuario" method="post" class="form-horizontal">
	<font > <h2 ALIGN="CENTER" class="display-4">Cadastro de Usu�rios</h2> </font>
	<hr>
	<div class="form-row">
		<div class="form-group col-md-10">		
			<label for="Nome">Nome</label>  
			<input type="text" class="form-control" name="nome" value="${usuario.nome}">
 			<form:errors path="usuario.nome" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<label for="Login">Login</label>
			<input type="text" class="form-control" name="login" value="${usuario.login}">
			<form:errors path="usuario.login" cssStyle="color:#B71C1C"/><br />
		</div>
		<div class="form-group col-md-4">		
			<label for="Senha">Senha</label>  
			<input type="password" class="form-control" name="senha" value="${usuario.senha}">
			<form:errors path="usuario.senha" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<label for="DataNascimento">Data Nascimento</label>  
			<input class="form-control" type="text" name="dataNascimento" value="<fmt:formatDate value ="${usuario.dataNascimento}" pattern="dd/MM/yyyy" />">
			<form:errors path="usuario.dataNascimento" cssStyle="color:#B71C1C"/><br />
		</div>
		<div class="form-group col-md-2">
			<label for="Altura">Altura</label>  
			<input type="text" class="form-control" name="altura" value="${usuario.altura}">
			<form:errors path="usuario.altura" cssStyle="color:#B71C1C"/><br />
		</div>	
	</div>
	<br><br>
	<div class="form-row">
        <div class="form-group col-md-5">
            <button type="submit" value="Criar" class="btn btn-primary">Confirma Inclus�o</button>
        </div>
        <div class="form-group col-md-5">
 			<a href="listaUsuarios" id="cancel" name="cancel" class="btn btn-primary">Cancela Inclus�o</a>
        </div>
    </div>    		
</form>
</div>
</body>
</html>