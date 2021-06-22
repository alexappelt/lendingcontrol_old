package unoesc.edu.emprestimo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unoesc.edu.emprestimo.model.Estado;

@Service(value = "EstadoDAO")
public class EstadoDAOImpl implements EstadoDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Estado getEstadoById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Estado c = session.get(Estado.class, id);
		return c;
	}

	@Override
	@Transactional
	public List<Estado> getEstados() {
		Session session = sessionFactory.getCurrentSession();
		List<Estado> estados = (List) session.createQuery("FROM Estado").list();
		return estados;
	}

	@Override
	@Transactional
	public void insertEstado(Estado estado) {
		Session session = sessionFactory.getCurrentSession();
		session.save(estado);
	}

	@Override
	@Transactional
	public void updateEstado(Estado estado) {
		Session session = sessionFactory.getCurrentSession();
		session.update(estado);
	}

	@Override
	@Transactional
	public void deleteEstado(Estado estado) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(estado);
	}
}