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
<form action="alteraCliente" method="post" class="form-horizontal">
	<font > <h2 class="display-4">Alteração de Clientes</h2> </font>

    <div class="form-row">
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
            <label class="form-check-label" for="inlineCheckbox1">Incluir</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
            <label class="form-check-label" for="inlineCheckbox2">Alterar</label>
        </div> 
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
            <label class="form-check-label" for="inlineCheckbox3">Excluir</label>
        </div>
        <div class="form-group col-md-2">
            <label for="inputEmail4">Cod.Cliente</label>
			<input readonly type="number" class="form-control" id="number" value="${cliente.codigo}">            
        </div>
        
        <div class="form-group col-md-2">
            <label for="sel1">Técnico:</label>
            <select class="form-control" id="sel1">
            	<option selected>Deisi</option>
            	<option selected>Facco</option>
            	<option selected>Aluno</option>
            </select>
        </div>
        
    </div>
    <div class="form-row">
        <div class="form-group col-md-9">
            <label for="inputAddress">Nome / Razão Social</label>
            <input type="text" class="form-control" id="imputNome" value="${cliente.nome}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="inputZip">CEP</label>
            <input type="text" class="form-control" id="inputCep" value="${cliente.CEP}">
        </div>
        <div class="form-group col-md-7">
            <label for="inputPassword4">Endereço</label>
            <input type="text" class="form-control" id="inputEndereco" value="${cliente.endereco}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="inputNumero">Número</label>
            <input type="number" class="form-control" id="imputNumero" value="${cliente.numero}">
        </div>
        <div class="form-group col-md-2">
            <label for="inputComplemento">Complemento</label>
            <input type="text" class="form-control" id="imputComplemento">
        </div>
        <div class="form-group col-md-5">
            <label for="inputBairro">Bairro</label>
            <input type="text" class="form-control" id="imputBairro" value ="${cliente.bairro}">
        </div>
        <div class="form-group col-md-3">
            <label for="inputFoto"> .Â </label>
            <button type="submit" class="btn btn-primary"> > > > P r o c u r a r__F o t o < < < </button>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="inputCity">Cidade</label>
            <input type="text" class="form-control" id="inputCity"  value="${cliente.cidade}">
        </div>
        <div class="form-group col-md-2">
            <label for="inputState">Estado</label>
            <select id="inputState" class="form-control">
                <option selected>Escolha...</option>
                <option>...</option>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label for="inputCity">E-mail</label>
            <input type="text" class="form-control" id="email">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-3">
            <label for="inputCelular">Celular</label>
            <input type="number" class="form-control" id="number" placeholder="(51) 99999-9999">
        </div>
        <div class="form-group col-md-3">
            <label for="inputResidencial">Residencial</label>
            <input type="number" class="form-control" id="number" placeholder="(51) 9999-9999">
        </div>
        <div class="form-group col-md-3">
            <button type="submit" value="Alterar" class="btn btn-primary">Grava Cliente</button>
        </div>
        <div class="form-group col-md-3">
            <button type="submit" class="btn btn-primary">Cancela Alteração</button>
        </div>
    </div>
</form>
</body>
</html>