<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Produtos</title>
</head>
<body>
<div class="mx-auto" style="width: 800px;">
<form action="adicionaUsuario" align="center" method="post" class="form-horizontal">
	<font > <h2 class="display-4" align="center">Cadastro de Produtos</h2> </font>
	<hr>
	<div class="form-row">
		<div class="form-group col-md-8">		
			<label for="Nome">Serviço</label>  
			<input type="text" class="form-control" name="serviço" value="${produtos.serviço}">
 			<form:errors path="produto.Serviço" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<label for="Login">Custo</label>
			<input type="text" class="form-control" name="custo" value="${produtos.custo}">
			<form:errors path="produto.custo" cssStyle="color:#B71C1C"/><br />
		</div>
		<div class="form-group col-md-4">		
			<label for="Senha">Valor</label>  
			<input type="password" class="form-control" name="valor" value="${produtos.valor}">
			<form:errors path="produtos.valor" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="Altura">Fornecedor</label>  
			<input type="text" class="form-control" name="fornecedor" value="${produto.fornecedor}">
			<form:errors path="produto.fornecedor" cssStyle="color:#B71C1C"/><br />
		</div>	
		<div class="form-group col-md-2">
			<label for="Altura">Margem</label>  
			<input type="text" class="form-control" name="margem" value="${produto.margem}">
			<form:errors path="produto.margem" cssStyle="color:#B71C1C"/><br />
		</div>	
	</div>
	<br><br>
	<div class="form-row">
        <div class="form-group col-md-5">
            <button type="submit" value="Criar" class="btn btn-primary">Confirma Inclusão</button>
        </div>
        <div class="form-group col-md-5">
 			<a href="listaProdutos" id="cancel" name="cancel" class="btn btn-primary">Cancela Inclusão</a> 
        </div>
    </div>    		
</form>
</div>
</body>
</html>