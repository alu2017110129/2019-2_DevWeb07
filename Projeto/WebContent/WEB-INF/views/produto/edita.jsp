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

<form action="alteraProduto" method="post" class="form-horizontal">
	<p><font><h4 class="display-4">Altera��o de Produto</h4> </font></p>
	<p><font><h5 class="display-5">Produto C�digo: ${produto.id}</h5> </font></p>
	<input type="hidden" name="Id" value="${produto.id}" />

    <div class="form-row">
        <div class="form-group col-md-8">				
			<label for="Servi�o">Servi�o</label>  
			<input type="text" name="Servi�o" value="${produto.servi�o}" > 
			<form:errors path="produto.Servi�o" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
    <div class="form-row">
        <div class="form-group col-md-2">				
			<label for="Custo">Custo</label>  
			<input type="text" name="Custo" value="${produto.Custo}" >
			<form:errors path="produto.Endereco" cssStyle="color:#B71C1C"/><br />
		</div>
        <div class="form-group col-md-2">				
			<label for="Valor">Valor</label>  	
			<input type="text" name="Valor" value="${produto.valor}">
			<form:errors path="produto.Valor" cssStyle="color:#B71C1C"/><br />
		</div>
        <div class="form-group col-md-4">						
			<label for="Fornecedor">Fornecedor</label>  
			<input type="text" name="Fornecedor" value ="${produto.fornecedor}"> 
			<form:errors path="produto.fornecedor" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
    <div class="form-row">
        <div class="form-group col-md-2">				
			<label for="Margem">Margem</label>  
			<input type="text" name="Margem" value="${produto.margem}" >
			<form:errors path="produto.margem" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
			
	<input type="submit" value="Alterar">
	
</form>
</div>	
</body>
</html>