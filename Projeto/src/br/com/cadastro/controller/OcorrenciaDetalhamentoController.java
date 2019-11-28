package br.com.cadastro.controller
;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.dao.OcorrenciaDetalhamentoDAO;
import br.com.cadastro.model.OcorrenciaDetalhamentoView;

@Controller
public class OcorrenciaDetalhamentoController {

	@Autowired
    OcorrenciaDetalhamentoDAO daoOcorrenciaDetalhamento;
	   
    @Autowired
    UsuarioDAO daoUsuario;
    
	@RequestMapping("editaOcorrenciaDetalhamento")
	public String edita(Integer Id, Model modelOcorrenciaDetalhamentoView) throws ClassNotFoundException {
        modelOcorrenciaDetalhamentoView.addAttribute("ocorrencia", daoOcorrenciaDetalhamento.buscaPorOcorrenciaDetalhamento(Id));
        return "ocorrencia/edita";
    }
}
