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
import br.com.cadastro.dao.DetalhamentoDAO;
import br.com.cadastro.model.Ocorrencia;

@Controller
public class OcorrenciaController {
	
	@Autowired
    OcorrenciaDAO daoOcorrencia;
	
	@Autowired
	ClienteDAO daoCliente;
    
    @Autowired
    UsuarioDAO daoUsuario;
    
	@Autowired
    DetalhamentoDAO daoDetalhamento;
   
	@RequestMapping("novaOcorrencia")
	public String form(Model modelUsuario) {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "ocorrencia/insere";
	}
	
/*Como rodar junto com o de cima*/	
	
	@RequestMapping("listaDetalhamento")
	public String form1(Integer id, Model modelDetalhamento) throws ClassNotFoundException {
		modelDetalhamento.addAttribute("detalhamentos", daoDetalhamento.buscaPorOcorrencia(id));
		return "ocorrencia/insere";
	}
	
	@RequestMapping("listaOcorrencias")
    public String lista(Model modelOcorrencia) throws ClassNotFoundException {
        modelOcorrencia.addAttribute("ocorrencias", daoOcorrencia.lista());
        return "ocorrencia/lista";
	}
	
	@RequestMapping("adicionaOcorrencia")
	public String adiciona(@Valid Ocorrencia Ocorrencia, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Ocorrência") || result.hasFieldErrors("Data") || result.hasFieldErrors("Cliente") || result.hasFieldErrors("Tipo") || result.hasFieldErrors("Marca")) {
			 return "ocorrencia/insere";
	     }
		daoOcorrencia.adiciona(Ocorrencia);
		return "redirect:listaOcorrencias";
	}
	
	@RequestMapping("editaOcorrencia")
    public String edita(Integer Ocorrência, Model modelOcorrencia) throws ClassNotFoundException {
        modelOcorrencia.addAttribute("ocorrencia", daoOcorrencia.buscaPorOcorrencia(Ocorrência));
        return "ocorrencia/edita";
    }
	
	@RequestMapping("alteraOcorrencia")
	public String altera(@Valid Ocorrencia Ocorrencia, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Nome") || result.hasFieldErrors("Endereco") || result.hasFieldErrors("Numero") || result.hasFieldErrors("Bairro") || result.hasFieldErrors("Cidade")) {
			 return "ocorrencia/edita";
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