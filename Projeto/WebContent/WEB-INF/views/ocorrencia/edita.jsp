<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="/WEB-INF/views/principal/cab.jsp"/>
	<title>Sistema Cadastro Ocorrências</title>
</head>
<body>

<div class="mx-auto" style="width: 1100px;">	

  <form action="alteraOcorrencia" method="post" class="form-horizontal">
	<font><h2 ALIGN="CENTER" class="display-4">Cadastro de Ocorrências</h2></font> </font>
	<p><font><h5 class="display-5">Ocorrência Nº: ${ocorrencia.ocorrencia}</h5> </font></p>
	<input type="hidden" name="codigo" value="${ocorrencia.ocorrencia}" />

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
        <div class="form-group col-md-2">
            <label for="inputData">Data</label>
            <input type="text" class="form-control" id="imputData" value="${ocorrencia.data}">
        </div>
        <div class="form-group col-md-1">
            <label for="inputOcorrêcia">Ocorrência</label>
            <input type="text" class="form-control" id="imputOcorrencia" value="${ocorrencia.ocorrencia}">
        </div>    
        <div class="form-group col-md-7">
            <label for="inputNome">Nome / Razão Social</label>
            <input type="text" class="form-control" id="imputNome" value="${ocorrencia.nome_razao_social}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="inpuTipo">Tipo</label>
            <input type="text" class="form-control" id="inputTipo" value="${ocorrencia.tipo}">
        </div>
        <div class="form-group col-md-2">
            <label for="inputMarca">Marca</label>
            <input type="text" class="form-control" id="inputMarca" value="${ocorrencia.marca}">
        </div>
        <div class="form-group col-md-3">
            <label for="inputModelo">Modelo</label>
            <input type="text" class="form-control" id="inputModelo" value="${ocorrencia.modelo}">
        </div>
        <div class="form-group col-md-2">
            <label for="inputSerie">Nro.Série</label>
            <input type="text" class="form-control" id="inputSérie" value="${ocorrencia.serie}">
        </div>
        <div class="form-group col-md-1">
            <label for="inputVoltagem">Voltagem</label>
            <input type="text" class="form-control" id="inputvoltagem" value="${ocorrencia.voltagem}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-5">
            <label for="inputNumero">Problema informado</label>
            <input type="text" class="form-control" id="imputProblema" value="${ocorrencia.Problema}">
        </div>
        <div class="form-group col-md-5">
            <label for="inputComplemento">Defeito Detectado</label >
            <input type="text" class="form-control" id="imputDefeito" value="${ocorrencia.Defeito}">
        </div>
    </div>
	<div class="row">
  		<div class="col-md-1">Cod.Item</div>
		<div class="col-md-1">Quant</div>
		<div class="col-md-4">Descrição Produto / Serviço</div>
		<div class="col-md-1">Custo</div>
		<div class="col-md-1">Preço</div>
		<div class="col-md-4">Observações</div>
	</div>
	<c:forEach items="${detalhamento}" var="detalhe">
	    <div class="form-row">
        	<div class="form-group col-md-1">
            	<label for="inputNumero"></label>
            	<input type="text" class="form-control" id=CodItem value="${detalhamentos.Coditem}">
        	</div>
        	<div class="form-group col-md-1">
            	<label for="inputComplemento"></label >
            	<input type="text" class="form-control" id=Quant value="${detalhamentos.Quant}">
            </div>
        	<div class="form-group col-md-4">
 	       		<label for="inputComplemento"></label >
        		<input type="text" class="form-control" id=Descrição_Peça_serviço value="${detalhamentos.Descrição_Peça_serviço}">
        	</div>
    		<div class="form-group col-md-1">
    			<label for="inputComplemento"></label >
    			<input type="text" class="form-control" id=Custo value="${detalhamentos.Custo}">
    		</div>
			<div class="form-group col-md-1">
				<label for="inputComplemento"></label >
				<input type="text" class="form-control" id=Valor value="${detalhamentos.Valor}">
			</div>
			<div class="form-group col-md-4">
				<label for="inputComplemento"></label >
				<input type="text" class="form-control" id=Observação value="${detalhamentos.Observação}">
			</div>
		</div>
 	</c:forEach>			
	<div class="form-group col-md-3">
    	<label for="inputFoto"></label>
      	<button type="submit" value="alterar" class="btn btn-primary">Altera Cliente</button>
    </div>
    <div class="form-group col-md-3">
   		<label for="inputFoto"></label>
        <button type="submit" value="cancel" class="btn btn-secondary">Cancela Alteração</button>
	</div>
    <c:import url="/WEB-INF/views/principal/footer.jsp"/>
  </form>
</div>
</body>
</html>