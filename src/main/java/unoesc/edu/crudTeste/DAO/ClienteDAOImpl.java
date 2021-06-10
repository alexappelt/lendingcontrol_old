package unoesc.edu.crudTeste.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unoesc.edu.crudTeste.model.Cliente;

@Service(value = "ClienteDAO")
public class ClienteDAOImpl implements ClienteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Cliente getClienteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cliente c = (Cliente) session.get(Cliente.class, new Integer(id));

		return c;
	}

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		return this.sessionFactory.getCurrentSession().createQuery("from Cliente").list();
	}

	@Override
	@Transactional
	public void insertCliente(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cliente);
	}

	@Override
	@Transactional
	public void updateCliente(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cliente);
	}

	@Override
	@Transactional
	public void deleteCliente(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cliente);
	}

	@Override
	@Transactional
	public Cliente validaLogin(String usuario, String senha) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente p = (Cliente) session.createQuery("from Cliente where usuario=:usuario and senha=:pwd")
				.setParameter("usuario", usuario).setParameter("pwd", senha).uniqueResult();
		return p;
	}
}