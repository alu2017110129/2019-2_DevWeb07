<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Clientes</title>
</head>
<body>
<div class="mx-auto" style="width: 1000px;">
<form action="alteraCliente" method="post" class="form-horizontal">
	<font > <h4 class="display-4">Alteração de Clientes</h4> </font>
	<p><font><h5 class="display-5">Cliente Código: ${cliente.codigo}</h5> </font></p>
	<input type="hidden" name="codigo" value="${cliente.codigo}" />
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="sel1">Técnico:</label>
            <select class="form-control" id="sel1">
			<c:forEach items="${usuarios}" var="usuario">
            		<option>${usuario.login}</option>
 			</c:forEach>
            </select>
        </div>        
    </div>
    <div class="form-row">
        <div class="form-group col-md-8">
            <label for="Nome">Nome / Razão Social</label>
            <input type="text" class="form-control" name="nome" value="${cliente.nome}">
			<form:errors path="cliente.nome" cssStyle="color:#B71C1C"/><br />
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="CEP">CEP</label>
            <input type="text" class="form-control" name="CEP" value="${cliente.CEP}">
        </div>
        <div class="form-group col-md-6">
            <label for="Endereço">Endereço</label>
            <input type="text" class="form-control" name="endereco" value="${cliente.endereco}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="Número">Número</label>
            <input type="text" class="form-control" name="numero" value="${cliente.numero}">
        </div>
        <div class="form-group col-md-2">
            <label for="Complemento">Complemento</label>
            <input type="text" class="form-control" name="complemento" value="${cliente.complemento}"> 
        </div>
        <div class="form-group col-md-4">
            <label for="Bairro">Bairro</label>
            <input type="text" class="form-control" name="bairro" value ="${cliente.bairro}">
        </div>
        <div class="form-group col-md-3">
        		<div class="invisible">
            		<label for="inputFoto">Procura Foto</label>
            	</div>
            <button type="submit" class="btn btn-info btn-block">Procurar Foto</button>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="Cidade">Cidade</label>
            <input type="text" class="form-control" name="cidade"  value="${cliente.cidade}">
        </div>
        <div class="form-group col-md-2">
            <label for="Estado">Estado</label>
            <input type="text" class="form-control" name="UF"  value="${cliente.UF}">
        </div>
        <div class="form-group col-md-5">
            <label for="Email">E-mail</label>
            <input type="text" class="form-control" name="email" value="${cliente.email}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-3">
            <label for="Celular">Celular</label>
            <input type="text" class="form-control" name="celular" value="${cliente.celular}">
		</div>
        <div class="form-group col-md-3">
            <label for="Residencial">Residencial</label>
            <input type="text" class="form-control" name="telefone" value="${cliente.telefone}">
        </div>
    	<div class="form-group col-md-3">
        	<div class="invisible">
            	<label for="inputFoto">Altera Cliente</label>
            </div>    	
            <button type="submit" value="alterar" class="btn btn-primary">Altera Cliente</button>
		</div>
    	<div class="form-group col-md-3">
        	<div class="invisible">
            	<label for="cancel">Cancela Alteração</label>
            </div>
            <button type="submit" value="cancel" href="listaCliente" class="btn btn-secondary">Cancela Alteração</button>
        </div>
	</div>
</form>
	<c:import url="/WEB-INF/views/principal/footer.jsp"/>
</div>
</body>
</html>