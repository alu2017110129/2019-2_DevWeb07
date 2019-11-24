select usuarios.login, clientes.Nome, ocorrencias.Data, ocorrencias.Ocorrência, ocorrencias.Marca, ocorrencias.Modelo, ocorrencias.Tipo, ocorrencias.Voltagem,ocorrencias.Problema,ocorrencias.Defeito
from ocorrencias inner join clientes on ocorrencias.CodCli = clientes.Codigo inner join usuarios on clientes.Tecnico = usuarios.id
where ocorrencias.Ocorrência = 5;