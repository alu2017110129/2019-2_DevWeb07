<?php
	require_once('functions.php'); 
	view($_GET['id']);
?>

<?php include(HEADER_TEMPLATE); ?>

<h2>id do Cliente: <?php echo $cliente['id']; ?></h2>
<hr>

<?php if (!empty($_SESSION['message'])) : ?>
	<div class="alert alert-<?php echo $_SESSION['type']; ?>"><?php echo $_SESSION['message']; ?></div>
<?php endif; ?>

<dl class="dl-horizontal">
	<dt>Nome / Razão Social:</dt>
	<dd><?php echo $cliente['Nome']; ?></dd>
</dl>

<dl class="dl-horizontal">
	<dt>CEP:</dt>
	<dd><?php echo $cliente['CEP']; ?></dd>

	<dt>Endereço:</dt>	
	<dd><?php echo $cliente['Endereço']; ?></dd>

	<dt>Número:</dt>
	<dd><?php echo $cliente['Número']; ?></dd>

	<dt>Complemento:</dt>
	<dd><?php echo $cliente['Complemento']; ?></dd>

	<dt>Bairro:</dt>
	<dd><?php echo $cliente['Bairro']; ?></dd>

	<dt>Cidade:</dt>
	<dd><?php echo $cliente['Cidade']; ?></dd>

	<dt>Estado:</dt>
	<dd><?php echo $cliente['UF']; ?></dd>
</dl>

<dl class="dl-horizontal">
	<dt>E-mail:</dt>
	<dd><?php echo $cliente['email']; ?></dd>

	<dt>Telefone:</dt>
	<dd><?php echo $cliente['Telefone']; ?></dd>

	<dt>Celular:</dt>
	<dd><?php echo $cliente['Celular']; ?></dd>
</dl>

<div id="actions" class="row">
	<div class="col-md-12">
	  <a href="edit.php?id=<?php echo $cliente['id']; ?>" class="btn btn-primary">Editar</a>
	  <a href="index.php" class="btn btn-default">Voltar</a>
	</div>
</div>

<?php include(FOOTER_TEMPLATE); ?>