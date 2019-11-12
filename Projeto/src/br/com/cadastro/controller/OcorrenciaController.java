package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.OcorrenciaDAO;
import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.dao.ClienteDAO;

import br.com.cadastro.model.Ocorrencia;

@Controller
public class OcorrenciaController {
	
	@Autowired
    OcorrenciaDAO daoOcorrencia;
    
	@Autowired

	ClienteDAO daoCliente;
    
    /*Adição consulta usuário no cadastro do cliente*/
    @Autowired
    UsuarioDAO daoUsuario;
    
    @RequestMapping("listaOcorrencias")
    public String lista(Model modelOcorrencia) throws ClassNotFoundException {
        modelOcorrencia.addAttribute("Ocorrencias", daoOcorrencia.lista());
        return "Ocorrencia/lista";
	}

	@RequestMapping("novoOcorrencia")
	public String form(Model modelUsuario) {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "Ocorrencia/insere";
	}
	
	@RequestMapping("adicionaOcorrencia")
	public String adiciona(@Valid Ocorrencia Ocorrencia, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Nome") || result.hasFieldErrors("Endereco") || result.hasFieldErrors("Numero") || result.hasFieldErrors("Bairro") || result.hasFieldErrors("Cidade")) {
			 return "Ocorrencia/insere";
	     }
		daoOcorrencia.adiciona(Ocorrencia);
		return "redirect:listaOcorrencias";
	}
	
	@RequestMapping("editaOcorrencia")
    public String edita(Integer Codigo, Model modelOcorrencia) throws ClassNotFoundException {
        modelOcorrencia.addAttribute("Ocorrencia", daoOcorrencia.buscaPorOcorrencia(Codigo));
        return "Ocorrencia/edita";
    }
	
	@RequestMapping("alteraOcorrencia")
	public String altera(@Valid Ocorrencia Ocorrencia, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Nome") || result.hasFieldErrors("Endereco") || result.hasFieldErrors("Numero") || result.hasFieldErrors("Bairro") || result.hasFieldErrors("Cidade")) {
			 return "Ocorrencia/edita";
	     }
		daoOcorrencia.altera(Ocorrencia);
        return "redirect:listaOcorrencias";
    }

    @RequestMapping("removeOcorrencia")
    public String remove(Ocorrencia Ocorrencia) throws ClassNotFoundException {
    	daoOcorrencia.remove(Ocorrencia);
        return "redirect:listaOcorrencias";
    }
}