<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro</title>
</head>
<body>

	<div class="form-row">
		<div class="form-group col-md-2">				
			<label for="Codigo">C�digo</label>
			<input readonly type="text" class="form-control" id="imputid" value="${usuario.id}" />
		</div>
	</div>
	
<form action="alteraUsuario" method="post" class="form-horizontal">

	<font > <h2 class="display-4">Altera��o de Usu�rio</h2> </font>
<br />
		Alterar usuario: ${usuario.id}
<br />
<br />
		<input type="hidden" name="id" value="${usuario.id}" />
		
 	<div class="form-row">
		<div class="form-group col-md-10">				
			<label for="Nome">Nome</label>  
			<input type="text" class="form-control" name="nome" value="${usuario.nome}" > 
			<form:errors path="usuario.nome" cssStyle="color:#B71C1C"/>
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-md-4">				
			<label for="Login">Login</label>  
			<input type="text" class="form-control" name="login" value="${usuario.login}" >
			<form:errors path="usuario.login" cssStyle="color:#B71C1C"/>
		</div>
		
		<div class="form-group col-md-4">
			<label for="Senha">Senha</label>  	
			<input type="password" class="form-control" name="senha" value="${usuario.senha}">
			<form:errors path="usuario.senha" cssStyle="color:#B71C1C"/>
		</div>
	</div>
	<div class="form-row">		
		<div class="form-group col-md-4">				
			<label for="DataNascimento">Data Nascimento</label>  
			<input type="text" class="form-control" name="dataNascimento" value ="<fmt:formatDate value="${usuario.dataNascimento.time}" pattern="dd/MM/yyyy" />" >
			<form:errors path="usuario.dataNascimento" cssStyle="color:#B71C1C"/>
		</div>
		<div class="form-group col-md-2">				
			<label for="Altura">Altura</label>  
			<input type="text" class="form-control" name="altura" value="${usuario.altura}" >
			<form:errors path="usuario.altura" cssStyle="color:#B71C1C"/>
		</div>
	</div>
	<div class="form-row">
        <div class="form-group col-md-3">
            <button type="submit" value="alterar" class="btn btn-primary">Grava Cliente</button>
        </div>
        <div class="form-group col-md-3">
            <button type="submit" value="cancel" class="btn btn-primary">Cancela Altera��o</button>
        </div>
    </div>
    
    <input type="submit" value="Alterar">
        	
</form>
</body>
</html>