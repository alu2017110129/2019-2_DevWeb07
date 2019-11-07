<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/styles.css">


<head>
	<title>Sistema Cadastro Produtoss</title>
</head>
<body>
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<div class="mx-auto" style="width: 2000px;">
    <table class="table">
	  <thead class="thead-ligth">
		<tr>
			<th></th>
			<th><a href="novoProduto" class="btn btn-primary btn-info">Cadastrar novo Produto</a></th>
			<th>Codigo</th>
			<th>Serviço</th>
			<th>Custo</th>
			<th>Valor</th>
	  		<th>Fornecedor</th>
			<th>Margem</th>
			<th></th>
			<th></th>
		  </tr>
		</thead>
		<c:forEach items="${Produtos}" var="Produto">
			<tr>
				<td>${Produto.cod_item}</td>
				<td>${Produto.serviço}</td>
				<td>${Produto.custo_R}</td>
				<td>${Produto.valor_R}</td>
	 			<td>${Produto.fornecedor}</td>
				<td>${Produto.margem}</td>
				<td><a href="editaProduto?Cod_item=${Produto.cod_item}" title="Editar">Editar</a></td>
				<td><a href="removeProduto?Cod_item=${Produto.cod_item}" title="Excluir">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
<c:import url="/WEB-INF/views/principal/footer.jsp"/>
</html>