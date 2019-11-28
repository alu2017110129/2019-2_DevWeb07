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
	<p><font><h5 class="display-5">Ocorrência Nº  ${ocorrenciadetalhamento.id}</h5> </font></p>
	<input type="hidden" name="id" value="${ocorrenciadetalhamento.id}" />

    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="sel1">Técnico:</label>
            <select class="form-control" id="sel1">
           		<option>${ocorrenciadetalhamentos.login}</option>
            </select>
        </div>        
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="inputData">Data</label>
			<input type="text" class="form-control" id="imputData" value ="<fmt:formatDate value="${ocorrenciadetalhamento.data.time}" pattern="dd/MM/yyyy" />">
		</div>
        <div class="form-group col-md-1">
            <label for="inputAddress">Cod.cliente</label>
            <input type="text" class="form-control" id="imputCodCli" value="${ocorrenciadetalhamento.codCli}">
		</div>
        <div class="form-group col-md-7">
            <label for="inputNome">Nome / Razão Social</label>
            <input type="text" class="form-control" id="imputNome" value="${ocorrenciadetalhamento.cliente}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="inpuTipo">Tipo</label>
            <input type="text" class="form-control" id="inputTipo" value="${ocorrenciadetalhamento.tipo}">
        </div>
        <div class="form-group col-md-2">
            <label for="inputMarca">Marca</label>
            <input type="text" class="form-control" id="inputMarca" value="${ocorrenciadetalhamento.marca}">
        </div>
        <div class="form-group col-md-3">
            <label for="inputModelo">Modelo</label>
            <input type="text" class="form-control" id="inputModelo" value="${ocorrenciadetalhamento.modelo}">
        </div>
        <div class="form-group col-md-2">
            <label for="inputSerie">Nro.Série</label>
            <input type="text" class="form-control" id="inputSérie" value="${ocorrenciadetalhamento.serie}">
        </div>
        <div class="form-group col-md-1">
            <label for="inputVoltagem">Voltagem</label>
            <input type="text" class="form-control" id="inputvoltagem" value="${ocorrenciadetalhamento.voltagem}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-5">
            <label for="inputNumero">Problema informado</label>
            <input type="text" class="form-control" id="imputProblema" value="${ocorrenciadetalhamento.problema}">
        </div>
        <div class="form-group col-md-5">
            <label for="inputComplemento">Defeito Detectado</label >
            <input type="text" class="form-control" id="imputDefeito" value="${ocorrenciadetalhamento.defeito}">
        </div>
    </div>
    <script>
    daoDetalhamento.buscaPorOcorrencia(Ocorrência)   
    </script>
 	<div class="row">
  		<div class="col-md-1">Cod.Item</div>
		<div class="col-md-1">Quant</div>
		<div class="col-md-4">Descrição Produto / Serviço</div>
		<div class="col-md-1">Custo</div>
		<div class="col-md-1">Preço</div>
		<div class="col-md-4">Observações</div>
	</div>
	<c:forEach items="${ocorrenciadetalhamento}" var="detalhe">
	    <div class="form-row">
        	<div class="form-group col-md-1">
            	<label for="inputNumero"></label>
            	<input type="text" class="form-control" id=CodItem value="${ocorrenciadetalhamentos.coditem}">
        	</div>
        	<div class="form-group col-md-1">
            	<label for="inputComplemento"></label >
            	<input type="text" class="form-control" id=Quant value="${ocorrenciadetalhamentos.quant}">
            </div>
        	<div class="form-group col-md-4">
 	       		<label for="inputComplemento"></label >
        		<input type="text" class="form-control" id=Descrição_Peça_serviço value="${ocorrenciadetalhamentos.descrição_Peça_serviço}">
        	</div>
    		<div class="form-group col-md-1">
    			<label for="inputComplemento"></label >
    			<input type="text" class="form-control" id=Custo value="${ocorrenciadetalhamentos.custo}">
    		</div>
			<div class="form-group col-md-1">
				<label for="inputComplemento"></label >
				<input type="text" class="form-control" id=Valor value="${ocorrenciadetalhamentos.valor}">
			</div>
			<div class="form-group col-md-4">
				<label for="inputComplemento"></label >
				<input type="text" class="form-control" id=Observação value="${ocorrenciadetalhamentos.observação}">
			</div>
		</div>
 	</c:forEach>    
    
    
	<div class="form-row"> 				
		<div class="form-group col-md-3">
      		<button type="submit" value="alterar" class="btn btn-primary">Altera Cliente</button>
    	</div>
    	<div class="form-group col-md-3">
   			<a href="listaOcorrencias" id="cancel" name="cancel" class="btn btn-primary">Cancela Alteração</a>
		</div>
	</div>
    <c:import url="/WEB-INF/views/principal/footer.jsp"/>
  </form>
</div>
</body>
</html>