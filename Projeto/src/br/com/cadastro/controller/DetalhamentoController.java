package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cadastro.dao.DetalhamentoDAO;
import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.dao.ClienteDAO;
import br.com.cadastro.model.Detalhamento;

@Controller
public class DetalhamentoController {
	
	@Autowired
    DetalhamentoDAO daoDetalhamento;
	
	@Autowired
	ClienteDAO daoCliente;
    
    @Autowired
    UsuarioDAO daoUsuario;
    
	@RequestMapping("novaDetalhamento")
	public String form(Model modelUsuario) {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "Detalhamento/insere";
	}
	@RequestMapping("listaDetalhamentos")
    public String lista(Model modelDetalhamento) throws ClassNotFoundException {
        modelDetalhamento.addAttribute("Detalhamentos", daoDetalhamento.lista());
        return "Detalhamento/lista";
	}
	
	@RequestMapping("adicionaDetalhamento")
	public String adiciona(@Valid Detalhamento Detalhamento, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Ocorrência") || result.hasFieldErrors("Data") || result.hasFieldErrors("Nome_Razão_Social") || result.hasFieldErrors("Tipo") || result.hasFieldErrors("Marca")) {
			 return "Detalhamento/insere";
	     }
		daoDetalhamento.adiciona(Detalhamento);
		return "redirect:listaDetalhamentos";
	}
	
	@RequestMapping("editaDetalhamento")
    public String edita(Integer Codigo, Model modelDetalhamento) throws ClassNotFoundException {
        modelDetalhamento.addAttribute("Detalhamento", daoDetalhamento.buscaPorDetalhamento(Codigo));
        return "Detalhamento/edita";
    }
	
	@RequestMapping("alteraDetalhamento")
	public String altera(@Valid Detalhamento Detalhamento, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Nome") || result.hasFieldErrors("Endereco") || result.hasFieldErrors("Numero") || result.hasFieldErrors("Bairro") || result.hasFieldErrors("Cidade")) {
			 return "Detalhamento/edita";
	     }
		daoDetalhamento.altera(Detalhamento);
        return "redirect:listaDetalhamentos";
    }

    @RequestMapping("removeDetalhamento")
    public String remove(Detalhamento Detalhamento) throws ClassNotFoundException {
    	daoDetalhamento.remove(Detalhamento);
        return "redirect:listaDetalhamentos";
    }
}