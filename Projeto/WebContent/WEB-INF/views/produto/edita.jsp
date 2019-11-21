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
	<p><font><h4 class="display-4">Alteração de Produto</h4> </font></p>
		<hr>
	<p class="font-weight-bold"><font><h5 class="display-5">Produto Código: ${produto.id}</h5> </font></p>
	<hr>
	<input type="hidden" name="Id" value="${produto.id}" />

    <div class="form-row">
        <div class="form-group col-md-8">				
			<label for="Serviço">Serviço</label>  
			<input type="text" class="form-control" name="Serviço" value="${produto.serviço}" > 
			<form:errors path="produto.Serviço" cssStyle="color:#B71C1C"/><br />
		</div>
	</div>
    <div class="form-row">
        <div class="form-group col-md-2">				
			<label for="Custo">Custo</label>  
			<input type="text" class="form-control" name="custo" value="${produto.custo}" >
			<form:errors path="produto.custo" cssStyle="color:#B71C1C"/><br />
		</div>
        <div class="form-group col-md-2">				
			<label for="Valor">Valor</label>  	
			<input type="text" class="form-control" name="Valor" value="${produto.valor}">
			<form:errors path="produto.Valor" cssStyle="color:#B71C1C"/><br />
		</div>
        <div class="form-group col-md-4">						
			<label for="Fornecedor">Fornecedor</label>  
			<input type="text" class="form-control" name="Fornecedor" value ="${produto.fornecedor}"> 
			<form:errors path="produto.fornecedor" cssStyle="color:#B71C1C"/><br />
		</div>

	</div>
    <div class="form-row">
        <div class="form-group col-md-2">				
			<label for="Margem">Margem</label>  
			<input type="text" class="form-control" name="Margem" value="${produto.margem}" >
			<form:errors path="produto.margem" cssStyle="color:#B71C1C"/><br />
		</div>
	  	<div class="form-group col-md-3">
        	<div class="invisible">
            	<label for="inputFoto">Altera Produto</label>
			</div>    	
            <button type="submit" value="alterar" class="btn btn-primary">Confirma Alteração</button>
        </div>
        <div class="form-group col-md-3">
        	<div class="invisible">
            	<label for="inputFoto">cabcela Alteração</label>
			</div>    	
			<a href="listaProdutos" id="cancel" name="cancel" class="btn btn-primary">Cancela Alteração</a>
        </div>
	</div>
</form>
</div>	
</body>
</html>