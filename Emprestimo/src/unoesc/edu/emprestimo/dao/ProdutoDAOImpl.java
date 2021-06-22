package unoesc.edu.emprestimo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unoesc.edu.emprestimo.model.Produto;
import unoesc.edu.emprestimo.model.Usuario;
import unoesc.edu.emprestimo.util.SessionContext;

@Service(value="ProdutoDAO")
public class ProdutoDAOImpl implements ProdutoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Produto getProdutoById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Produto c = session.get(Produto.class, id);
		return c;
	}

	@Override
	@Transactional
	public List<Produto> getProdutos() {		
		Usuario user =	(Usuario) SessionContext.getInstance().getAttribute("usuarioLogado");
		Integer id_usuario = user.getId();
		String consulta = "from Produto WHERE id_usuario =  "+ id_usuario.toString();
		Session session = sessionFactory.getCurrentSession();
		List <Produto> produtos = (List) session.createQuery(consulta , Produto.class).list();
		

		return produtos;
	}

	@Override
	@Transactional
	public void insertProduto(Produto produto) {
		Session session = sessionFactory.getCurrentSession();
		session.save(produto);
	}

	@Override
	@Transactional
	public void updateProduto(Produto produto) {
		Session session = sessionFactory.getCurrentSession();
		session.update(produto);	
	}

	@Override
	@Transactional
	public void deleteProduto(Produto produto) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(produto);
	}
}