<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro de Usuários</title>
</head>
<body>
<div class="mx-auto" style="width: 800px;">

<form action="alteraUsuario" method="post" class="form-horizontal">
	<p><font><h4 class="display-4">Alteração de Usuário</h4> </font></p>
	<p><font><h5 class="display-5">Usuário Código: ${usuario.id}</h5> </font></p>
	<input type="hidden" name="id" value="${usuario.id}" />
		
 	<div class="form-row">
		<div class="form-group col-md-8">				
			<label for="Nome">Nome</label>  
			<input type="text" class="form-control" name="nome" value="${usuario.nome}" > 
			<form:errors path="usuario.nome" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-md-4">				
			<label for="Login">Login</label>  
			<input type="text" class="form-control" name="login" value="${usuario.login}" >
			<form:errors path="usuario.login" cssStyle="color:#B71C1C"/><br />
		</div>
		
		<div class="form-group col-md-4">
			<label for="Senha">Senha</label>
			<input type="password" class="form-control" name="senha" value="${usuario.senha}">
			<form:errors path="usuario.senha" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
	<div class="form-row">		
		<div class="form-group col-md-2">				
			<label for="DataNascimento">Data Nascimento</label>
			<input type="text" class="calendar" name="dataNascimento" value ="<fmt:formatDate value="${usuario.dataNascimento.time}.datepicker()" pattern="dd/MM/yyyy" />" >
			<form:errors path="usuario.dataNascimento" cssStyle="color:#B71C1C"/><br />
		</div>
		<div class="form-group col-md-1">				
			<label for="Altura">Altura</label>  
			<input type="text" class="form-control" name="altura" value="${usuario.altura}" >
			<form:errors path="usuario.altura" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
	<div class="form-row">
        <div class="form-group col-md-3">
            <button type="submit" value="alterar" class="btn btn-primary">Confirma Alteração</button>
        </div>
        <div class="form-group col-md-3">
			<a href="listaUsuarios" id="cancel" name="cancel" class="btn btn-primary">Cancela Alteração</a>
        </div>
    </div> 
	<c:import url="/WEB-INF/views/principal/footer.jsp"/>       
</form>
</div>
</body>
</html>