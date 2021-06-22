package unoesc.edu.emprestimo.dao;

import java.util.List;

import unoesc.edu.emprestimo.model.Status;

public interface StatusDAO {

	Status getStatusById(int id);

	List<Status> getStatuses();

	void insertStatus(Status status);

	void updateStatus(Status status);

	void deleteStatus(Status status);

}