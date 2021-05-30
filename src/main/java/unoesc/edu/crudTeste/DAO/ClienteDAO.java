package unoesc.edu.crudTeste.DAO;

import java.util.List;

import unoesc.edu.crudTeste.model.Cliente;
	
public interface ClienteDAO {

	Cliente getClienteById (int id);
	List<Cliente> getClientes();
	void insertCliente(Cliente cliente);
	void updateCliente(Cliente cliente);
	void deleteCliente(Cliente cliente);
	
}