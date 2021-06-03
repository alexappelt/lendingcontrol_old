package unoesc.edu.crudTeste.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import unoesc.edu.crudTeste.DAO.EstadoDAO;
import unoesc.edu.crudTeste.DAO.ProdutoDAO;
import unoesc.edu.crudTeste.model.Estado;
import unoesc.edu.crudTeste.model.Produto;

@ManagedBean(name="produtoMB")
@RequestScoped
public class ProdutoController {
	
	private List<Produto> produtos; 
	private List<Estado> estados;
	private Produto produto = new Produto();
	
	@ManagedProperty(value="#{ProdutoDAO}")
	private ProdutoDAO produtoDao;
	
	@ManagedProperty(value="#{EstadoDAO}")
	private EstadoDAO estadoDao;

	public void produtosave() {

		if (produto.getId() == 0) {
			this.produtoDao.insertProduto(produto);
		} else {
			this.produtoDao.updateProduto(produto);
		}
		this.produto = new Produto();
	}


	public void edit(int id) {

		this.produto = this.produtoDao.getProdutoById(id);
	}


	public void delete(int id) {

		Produto c = this.produtoDao.getProdutoById(id);
		this.produtoDao.deleteProduto(c);
	}

	public ProdutoDAO getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDAO produtoDao) {
		this.produtoDao = produtoDao;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public List<Produto> getProdutos() {
		this.produtos = produtoDao.getProdutos();
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public List<Estado> getEstados() {
		return estados;
	}


	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}


	public EstadoDAO getEstadoDao() {
		return estadoDao;
	}


	public void setEstadoDao(EstadoDAO estadoDao) {
		this.estadoDao = estadoDao;
	}
	
	
}