<?php 
  require_once('functions.php'); 

  if (isset($_GET['id'])){
    delete($_GET['id']);
  } else {
    die("ERRO: id não definido.");
  }
?>