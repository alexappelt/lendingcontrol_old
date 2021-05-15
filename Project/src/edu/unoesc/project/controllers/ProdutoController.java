package edu.unoesc.project.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.unoesc.project.models.Produto;
import edu.unoesc.project.DAO.ProdutoDAO;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public String acessoCliente(Model model, HttpSession session) {
		System.out.println("chamou produto");
		
		List<Produto> listaProduto = this.produtoDao.getProdutos();
		
		model.addAttribute("listaProduto", listaProduto);
		Produto p = new Produto();
		model.addAttribute("produto", p);

		return "produtos/index";
	}
	
	@RequestMapping(path = "produtoSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("produto") Produto prod, HttpSession session) {
		
		if (prod.getId() == 0) {
			produtoDao.insertProduto(prod);
		}else {
			Produto p = (Produto) produtoDao.getProdutoById(prod.getId());
			p.setDescricao(prod.getDescricao());
			p.setMarca(prod.getMarca());
			p.setCor(prod.getCor());
			p.setValor(prod.getValor());
		}
		
		return "redirect:/produto";
	}
	
	@RequestMapping(path = "produtoEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		
		List<Produto> listaProdutos = produtoDao.getProdutos();
		model.addAttribute("produto", listaProdutos);
		
		Produto p = produtoDao.getProdutoById(id);
		model.addAttribute("produto", p);
		
		return "produtoCrud";
	}
	
	public ProdutoDAO getProdutoDao() {
		return produtoDao;
	}
	
	public void setProdutoDao(ProdutoDAO produtoDao) {
		this.produtoDao = produtoDao;
	}
}
