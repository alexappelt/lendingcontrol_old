package unoesc.edu.emprestimo.controller;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import unoesc.edu.emprestimo.dao.StatusDAO;
import unoesc.edu.emprestimo.model.Status;

public class StatusController {

	@ManagedProperty(value = "#{StatusDAO}")
	private StatusDAO statusDao;

	private Status status = new Status();
	private List<Status> statuses;


	public void edit(int id) {

		this.status = this.statusDao.getStatusById(id);
	}

	public void delete(int id) {

		Status c = this.statusDao.getStatusById(id);
		this.statusDao.deleteStatus(c);
	}

	public StatusDAO getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(StatusDAO statusDao) {
		this.statusDao = statusDao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

}
