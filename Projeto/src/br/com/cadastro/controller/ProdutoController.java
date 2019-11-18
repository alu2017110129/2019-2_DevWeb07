package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cadastro.dao.ProdutoDAO;
import br.com.cadastro.model.Produto;

@Controller
public class ProdutoController {
	
    @Autowired
    ProdutoDAO daoProduto;
    
    @RequestMapping("listaProdutos")
    public String lista(Model modelProduto) throws ClassNotFoundException {
        modelProduto.addAttribute("produtos", daoProduto.lista());
        return "produto/lista";
	}

	@RequestMapping("novoProduto")
	public String form() {
		return "produto/insere";
	}
	
	@RequestMapping("adicionaProduto")
	public String adiciona(@Valid Produto produto, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Nome") || result.hasFieldErrors("Endereco") || result.hasFieldErrors("Numero") || result.hasFieldErrors("Bairro") || result.hasFieldErrors("Cidade")) {
			 return "produto/insere";
	     }
		daoProduto.adiciona(produto);
		return "redirect:listaProdutos";
	}
	
	@RequestMapping("editaProduto")
    public String edita(Integer Codigo, Model modelProduto) throws ClassNotFoundException {
        modelProduto.addAttribute("produto", daoProduto.buscaPorCodigo(Codigo));
        return "produto/edita";
    }
	
	@RequestMapping("alteraProduto")
	public String altera(@Valid Produto produto, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("Nome") || result.hasFieldErrors("Endereco") || result.hasFieldErrors("Numero") || result.hasFieldErrors("Bairro") || result.hasFieldErrors("Cidade")) {
			 return "produto/edita";
	     }
		daoProduto.altera(produto);
        return "redirect:listaProdutos";
    }

    @RequestMapping("removeProduto")
    public String remove(Produto produto) throws ClassNotFoundException {
    	daoProduto.remove(produto);
        return "redirect:listaProdutos";
    }
}