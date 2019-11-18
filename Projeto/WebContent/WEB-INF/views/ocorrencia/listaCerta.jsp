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
<!-- 	<title>Sistema Cadastro de Ocorrências</title>  -->
</head>
<body>
  <div>
	<table class="table">
		<thead class="thead-ligth">
			<tr>
				<th></th>
	  			<th><a href="novaOcorrencia" class="btn btn-primary btn-info">Cadastrar nova Ocorrência</a>
				<th></th>
				<th><h3>MANUTENÇÃO DE OCORRÊNCIAS</h3></th>
				<th></th>
			</tr>
		</thead>
	</table>
    <table class="table table-striped" BORDER="1">
	  <thead class="thead-dark">
		<tr>
			<th>Nro.Ocorrência</th>
			<th>Data</th>
			<th>Nome Razão Social</th>
			<th>Tipo</th>
	  		<th>Marca</th>
			<th>Modelo</th>
			<th>Problema Informado</th>
			<th>Problema Detectado</th>
			<th></th>
			<th></th>
		  </tr>
		</thead>		
 		<c:forEach items="${ocorrencias}" var="ocorrencia">
			<tr>
				<td>${ocorrencia.ocorrencia}</td>
				<td>${ocorrencia.data}</td>
				<td>${ocorrencia.nome_razão_social}</td>				
				<td>${ocorrencia.Tipo}</td>
				<td>${ocorrencia.Marca}</td>
				<td>${ocorrencia.Modelo}</td>
				<td>${ocorrencia.Problema_Informado}</td>
				<td>${ocorrencia.Problema_Detectado}</td>	
				<td><a href="editaOcorrencia?Ocorrência=${ocorrencia.Ocorrência}" title="EDITAR">Editar</a></td>
				<td><a href="removeOcorrencia?Ocorrência=${ocorrencia.Ocorrência}" title="EXCLUIR">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
  </div>
  <c:import url="/WEB-INF/views/principal/footer.jsp"/>
</body>
</html>