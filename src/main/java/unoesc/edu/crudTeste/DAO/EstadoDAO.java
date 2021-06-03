package unoesc.edu.crudTeste.DAO;

import java.util.List;

import unoesc.edu.crudTeste.model.Estado;
	
public interface EstadoDAO {

	Estado getEstadoById (int id);
	List<Estado> getEstados();
	void insertEstado(Estado estado);
	void updateEstado(Estado estado);
	void deleteEstado(Estado estado);
	
}