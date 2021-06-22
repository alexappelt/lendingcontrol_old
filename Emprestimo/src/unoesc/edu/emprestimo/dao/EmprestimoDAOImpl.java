package unoesc.edu.emprestimo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unoesc.edu.emprestimo.model.Emprestimo;

@Service(value="EmprestimoDAO")
public class EmprestimoDAOImpl implements EmprestimoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Emprestimo getEmprestimoById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Emprestimo c = session.get(Emprestimo.class, id);
		return c;
	}

	@Override
	@Transactional
	public List<Emprestimo> getEmprestimos() {
		Session session = sessionFactory.getCurrentSession();
		List <Emprestimo> emprestimos = (List) session.createQuery("FROM Emprestimo").list();
		return emprestimos;
	}

	@Override
	@Transactional
	public void insertEmprestimo(Emprestimo emprestimo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(emprestimo);
	}

	@Override
	@Transactional
	public void updateEmprestimo(Emprestimo emprestimo) {
		Session session = sessionFactory.getCurrentSession();
		session.update(emprestimo);	
	}

	@Override
	@Transactional
	public void deleteEmprestimo(Emprestimo emprestimo) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(emprestimo);
	}
}