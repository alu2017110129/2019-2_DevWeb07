<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Produtoss</title>
</head>
<body>
	<p>
	  <a href="novoProduto" class="btn-primary btn-lg btn-block">Cadastrar novo Produto</a>
	</p>
    <table class="table table-striped">
	  <thead class="thead-dark">
		<tr>
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
</body>
<c:import url="/WEB-INF/views/principal/footer.jsp"/>
</html>