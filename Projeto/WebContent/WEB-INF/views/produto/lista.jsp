<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="resources/css/styles.css">
 
<head>
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Produtoss</title>
</head>
<body>
<div class="mx-auto" style="width: 1000px;">
    <table class="table">
	  <thead class="thead-ligth">
		<tr>
			<th></th>
			<th><a href="novoProduto" class="btn btn-primary btn-info">Cadastrar novo Produto</a></th>
			<th></th>
			<th><h3>MANUTENÇÃO DE PRODUTOS</h3></th>
			<th></th>
		</tr>
	  </thead>
	</table>
	<table class="table table-striped" BORDER="1">
  		<thead class="thead-dark">
  		  <tr>
			<th>Codigo</th>
			<th>Descrição Produtos / Serviço</th>
			<th>Custo</th>
			<th>Valor</th>
	  		<th>Fornecedor</th>
			<th>Margem</th>
			<th>Alterar</th>
			<th>Excluir</th>
		  </tr>
		</thead>
 		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td>${produto.id}</td>
 				<td>${produto.serviço}</td>
				<td>${produto.custo}</td>
				<td>${produto.valor}</td>				
	 			<td>${produto.fornecedor}</td>
				<td>${produto.margem}</td>
				<td><a href="editaProduto?Id=${produto.id}" title="Editar">EDITAR</a></td>
				<td><a href="removeProduto?Id=${produto.id}" title="Excluir">EXCLUIR</a></td>
			</tr>
		</c:forEach>
	  </table>
	</div>  
</body>
</html>