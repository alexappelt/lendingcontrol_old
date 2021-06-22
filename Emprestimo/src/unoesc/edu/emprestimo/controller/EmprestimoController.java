package unoesc.edu.emprestimo.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import unoesc.edu.emprestimo.dao.EmprestimoDAO;
import unoesc.edu.emprestimo.dao.ProdutoDAO;
import unoesc.edu.emprestimo.dao.StatusDAO;
import unoesc.edu.emprestimo.dao.UsuarioDAO;
import unoesc.edu.emprestimo.model.Emprestimo;
import unoesc.edu.emprestimo.model.Produto;
import unoesc.edu.emprestimo.model.Status;
import unoesc.edu.emprestimo.model.Usuario;
import unoesc.edu.emprestimo.util.SessionContext;

@ManagedBean(name = "emprestimoMB")
@RequestScoped
public class EmprestimoController {

	private List<Emprestimo> emprestimos;
	private List<Produto> produtos;
	private List<Status> statuses;
	private List<Usuario> usuarios;
	private Emprestimo emprestimo = new Emprestimo();
	
	@ManagedProperty(value = "#{EmprestimoDAO}")
	private EmprestimoDAO emprestimoDao;
	
	@ManagedProperty(value = "#{ProdutoDAO}")
	private ProdutoDAO produtoDao;
	
	@ManagedProperty(value = "#{StatusDAO}")
	private StatusDAO statusDao;
	
	@ManagedProperty(value = "#{UsuarioDAO}")
	private UsuarioDAO usuarioDao;

	public void save() {
		Usuario user =	(Usuario) SessionContext.getInstance().getAttribute("usuarioLogado");
		if (emprestimo.getId() == 0) {
			emprestimo.setMutuante(user);
			this.emprestimoDao.insertEmprestimo(emprestimo);
		} else {
			emprestimo.setMutuante(user);
			this.emprestimoDao.updateEmprestimo(emprestimo);
		}
		this.emprestimo = new Emprestimo();
	}

	public void edit(int id) {

		this.emprestimo = this.emprestimoDao.getEmprestimoById(id);
	}

	public void delete(int id) {

		Emprestimo c = this.emprestimoDao.getEmprestimoById(id);
		this.emprestimoDao.deleteEmprestimo(c);
	}

	public EmprestimoDAO getEmprestimoDao() {
		return emprestimoDao;
	}

	public void setEmprestimooDao(EmprestimoDAO emprestimoDao) {
		this.emprestimoDao = emprestimoDao;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public List<Emprestimo> getEmprestimos() {
		this.emprestimos = emprestimoDao.getEmprestimos();
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<Produto> getProdutos() {
		this.produtos = produtoDao.getProdutos();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public ProdutoDAO getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDAO produtoDao) {
		this.produtoDao = produtoDao;
	}

	public void setEmprestimoDao(EmprestimoDAO emprestimoDao) {
		this.emprestimoDao = emprestimoDao;
	}
	
	public List<Status> getStatuses() {
		this.statuses = statusDao.getStatuses();
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public StatusDAO getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(StatusDAO statusDao) {
		this.statusDao = statusDao;
	}

	public List<Usuario> getUsuarios() {
		this.usuarios = usuarioDao.getUsuarios();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
}