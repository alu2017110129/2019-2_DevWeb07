<?php 
  require_once('functions.php'); 
  add();
?>

<?php include(HEADER_TEMPLATE); ?>

<h2>Novo Cliente</h2>

<form action="add.php" method="post">
  <!-- area de campos do form -->
  <hr />
  <div class="row">
  
    <div class="form-group col-md-10">
      <label for="campo1">Nome / Razão Social</label>
      <input type="text" class="form-control" name="cliente['Nome']">
    </div> 
  </div>	
  <div class="row">	
    <div class="form-group col-md-3">
      <label for="campo2">CEP</label>
      <input type="text" class="form-control" name="cliente['CEP']">
    </div>
	
    <div class="form-group col-md-7">
      <label for="campo3">Endereço</label>
      <input type="text" class="form-control" name="cliente['Endereço']">
    </div>
	
  </div>
  <div class="row">
    <div class="form-group col-md-2">
      <label for="campo4">Número</label>
      <input type="text" class="form-control" name="cliente['Número']">
    </div>
	
    <div class="form-group col-md-3">
      <label for="campo5">Complemento</label>
      <input type="text" class="form-control" name="cliente['complemento']">
    </div>
	
    <div class="form-group col-md-5">
      <label for="campo6">Bairro</label>
      <input type="text" class="form-control" name="cliente['Bairro']">
    </div>
	
  </div>
  <div class="row">
    <div class="form-group col-md-4">
      <label for="campo7">Cidade</label>
      <input type="text" class="form-control" name="cliente['Cidade']">
    </div>
	
    <div class="form-group col-md-1">
      <label for="campo8">Estado</label>
      <input type="text" class="form-control" name="cliente['Estado']">
    </div>
	
    <div class="form-group col-md-7">
      <label for="campo9">E-mail</label>
      <input type="text" class="form-control" name="cliente['E-mail']">
    </div>		
	
  </div>  
  <div class="row">
    <div class="form-group col-md-3">
      <label for="campo10">Telefone</label>
      <input type="text" class="form-control" name="cliente['Telefone']">
    </div>
	
    <div class="form-group col-md-3">
      <label for="campo11">Celular</label>
      <input type="text" class="form-control" name="cliente['Celular']">
    </div>
	
	<div class="form-group col-md-6">
      <label for="campo12">Técnico</label>
      <input type="text" class="form-control" name="cliente['Técnico']">
    </div>
	
  </div>
  
  <div id="actions" class="row">
    <div class="col-md-12">
      <button type="submit" class="btn btn-primary btn-lg">Salvar</button>
      <a href="index.php" class="btn btn-default btn-lg">Cancelar</a>
    </div>
  </div>
</form>

<?php include(FOOTER_TEMPLATE); ?>