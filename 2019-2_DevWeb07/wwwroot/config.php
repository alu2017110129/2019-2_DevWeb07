<?php

/**server=185.224.138.91;user id=u399797101_facco;password=Jlfs012010zz;persistsecurityinfo=True;database=u399797101_ocorr"*/

/** O nome do banco de dados*/
define('DB_NAME', 'u399797101_ocorr');

/** Usuário do banco de dados MySQL */
define('DB_USER', 'u399797101_facco');

/** Senha do banco de dados MySQL */
define('DB_PASSWORD', 'Jlfs012010zz');

/** nome do host do MySQL */
define('DB_HOST', '185.224.138.91');

/** caminho absoluto para a pasta do sistema **/
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');
	
/** caminho no server para o sistema **/
if ( !defined('BASEURL') )
	define('BASEURL', '/crud-bootstrap-php/');
	
/** caminho do arquivo de banco de dados **/
if ( !defined('DBAPI') )
	define('DBAPI', ABSPATH . 'inc/database.php');