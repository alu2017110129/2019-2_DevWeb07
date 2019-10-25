<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro Cliente</title>
</head>
<body>
<c:import url="/WEB-INF/views/principal/menu.jsp"/>
<br />Cadastro de Clientes <br /><br />
	
	<form action="adicionaCliente" method="post">
				<label for="Nome">Nome</label>  
				<input type="text" name="nome" value="${cliente.nome}" >
				<form:errors path="cliente.Nome" cssStyle="color:#B71C1C"/><br />
	
				<label for="Endereco">Endereco</label>  
				<input type="text" name="Endereco" value="${cliente.Endereco}" >
				<form:errors path="cliente.Endereco" cssStyle="color:#B71C1C"/><br />
	
				<label for="Numero">Numero</label>  
				<input type="text" name="Numero" value="${cliente.Numero}" >
				<form:errors path="cliente.Numero" cssStyle="color:#B71C1C"/><br />
			
				<label for="Bairro">Bairro</label>  
				<input type="text" name="bairro" value="${cliente.Bairro}">
				<form:errors path="cliente.Bairro" cssStyle="color:#B71C1C"/><br />
				
				<label for="Cidade">Cidade</label>  
				<input type="text" name="Cidade" value ="${Cidade}">
				<form:errors path="cliente.Cidade" cssStyle="color:#B71C1C"/><br />

				<input type="submit" value="Criar">
		
	</form>
</body>
</html>