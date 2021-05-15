package edu.unoesc.project.DAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import edu.unoesc.project.models.Produto;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Produto getProdutoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produto p = (Produto) session.get(Produto.class, id);
		
		return p;
	}
	
	@Override
	@Transactional
	public List<Produto> getProdutos() {
		return this.sessionFactory.getCurrentSession().createQuery("from Produto").list();
	}
	
	@Override
	@Transactional
	public boolean deleteProduto(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produto p = (Produto) session.load(Produto.class, session);
		if (p!= null) {
			session.delete(p);
			return true;
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean insertProduto(Produto p) {
		this.sessionFactory.getCurrentSession().save(p);
		return false;
	}
	
	@Override
	@Transactional
	public boolean updateProduto(Produto p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		return true;
	}

}
