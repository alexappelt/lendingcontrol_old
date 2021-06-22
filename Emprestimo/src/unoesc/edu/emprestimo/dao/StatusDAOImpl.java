package unoesc.edu.emprestimo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unoesc.edu.emprestimo.model.Status;

@Service(value = "StatusDAO")
public class StatusDAOImpl implements StatusDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Status getStatusById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Status c = session.get(Status.class, id);
		return c;
	}

	@Override
	@Transactional
	public List<Status> getStatuses() {
		Session session = sessionFactory.getCurrentSession();
		List<Status> statuses = (List) session.createQuery("FROM Status").list();
		return statuses;
	}

	@Override
	@Transactional
	public void insertStatus(Status status) {
		Session session = sessionFactory.getCurrentSession();
		session.save(status);
	}

	@Override
	@Transactional
	public void updateStatus(Status status) {
		Session session = sessionFactory.getCurrentSession();
		session.update(status);
	}

	@Override
	@Transactional
	public void deleteStatus(Status status) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(status);
	}
}