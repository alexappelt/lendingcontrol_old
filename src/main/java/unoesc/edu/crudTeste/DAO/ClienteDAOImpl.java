package unoesc.edu.crudTeste.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unoesc.edu.crudTeste.model.Cliente;

@Service(value="ClienteDAO")
public class ClienteDAOImpl implements ClienteDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Cliente getClienteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cliente c = session.get(Cliente.class, id);
		return c;
	}

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		Session session = sessionFactory.getCurrentSession();
		List <Cliente> clientes = (List) session.createQuery("FROM Cliente").list();
		return clientes;
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
}