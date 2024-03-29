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
	<p><font><h5 class="display-5">Produto C�digo: ${Produto.cod_item}</h5> </font></p>
	<input type="hidden" name="Cod_item" value="${Produto.cod_item}" />
				
	<label for="Servi�o">Servi�o</label>  
	<input type="text" name="Servi�o" value="${Produto.servi�o}" > 
	<form:errors path="Produto.Servi�o" cssStyle="color:#B71C1C"/><br />

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
</div>	
</body>
</html>