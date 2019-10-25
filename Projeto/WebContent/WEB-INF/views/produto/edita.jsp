<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro Produtos</title>
</head>
<body>
	<c:import url="/WEB-INF/views/principal/menu.jsp"/>
	<br />Alterar Produto: ${Produto.Cod_item}	
	<br />
	<br />
	
	<form action="alteraProduto" method="post" class="form-horizontal">
	
	<input type="hidden" name="Cod_item" value="${Produto.cod_item}" />
				
	<label for="Serviço">Serviço</label>  
	<input type="text" name="Serviço" value="${Produto.serviço}" > 
	<form:errors path="Produto.Serviço" cssStyle="color:#B71C1C"/><br />

	<label for="Custo">Endereco</label>  
	<input type="text" name="Custo" value="${Produto.custo_R}" >
	<form:errors path="Produto.Endereco" cssStyle="color:#B71C1C"/><br />

	<label for="Valor">Valor</label>  	
	<input type="text" name="Valor" value="${Produto.valor_R}">
	<form:errors path="Produto.valor_R" cssStyle="color:#B71C1C"/><br />
	
	<label for="Fornecedor">Fornecedor</label>  
	<input type="text" name="Fornecedor" value ="${Produto.fornecedor}"> 
	<form:errors path="Produto.fornecedor" cssStyle="color:#B71C1C"/><br />
	
	<label for="Margem">Margem</label>  
	<input type="text" name="Margem" value="${Produto.margem}" >
	<form:errors path="Produto.margem" cssStyle="color:#B71C1C"/><br />
		
	<input type="submit" value="Alterar">
	
	</form>
	
</body>
</html>