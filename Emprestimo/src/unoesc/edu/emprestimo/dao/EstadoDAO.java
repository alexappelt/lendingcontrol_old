package unoesc.edu.emprestimo.dao;

import java.util.List;

import unoesc.edu.emprestimo.model.Estado;

public interface EstadoDAO {

	Estado getEstadoById(int id);

	List<Estado> getEstados();

	void insertEstado(Estado estado);

	void updateEstado(Estado estado);

	void deleteEstado(Estado estado);

}