package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.ClienteDAO;
import br.com.cadastro.model.Cliente;

@Controller
public class ClienteController {
	
    @Autowired
    ClienteDAO daoCliente;
    
    @RequestMapping("listaClientes")
    public String lista(Model modelCliente) throws ClassNotFoundException {
        modelCliente.addAttribute("clientes", daoCliente.lista());
        return "cliente/lista";
	}

	@RequestMapping("novoCliente")
	public String form() {
		return "cliente/insere";
	}
	
	@RequestMapping("adicionaCliente")
	public String adiciona(@Valid Cliente cliente, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Nome") || result.hasFieldErrors("Endereco") || result.hasFieldErrors("Numero") || result.hasFieldErrors("Bairro") || result.hasFieldErrors("Cidade")) {
			 return "cliente/insere";
	     }
		daoCliente.adiciona(cliente);
		return "redirect:listaClientes";
	}
	
	@RequestMapping("editaCliente")
    public String edita(Integer Codigo, Model modelCliente) throws ClassNotFoundException {
        modelCliente.addAttribute("cliente", daoCliente.buscaPorCodigo(Codigo));
        return "cliente/edita";
    }
	
	@RequestMapping("alteraCliente")
	public String altera(@Valid Cliente cliente, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Nome") || result.hasFieldErrors("Endereco") || result.hasFieldErrors("Numero") || result.hasFieldErrors("Bairro") || result.hasFieldErrors("Cidade")) {
			 return "cliente/edita";
	     }
		daoCliente.altera(cliente);
        return "redirect:listaClientes";
    }

    @RequestMapping("removeCliente")
    public String remove(Cliente cliente) throws ClassNotFoundException {
    	daoCliente.remove(cliente);
        return "redirect:listaClientes";
    }
}