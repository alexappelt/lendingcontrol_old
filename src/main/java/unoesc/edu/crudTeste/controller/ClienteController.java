package unoesc.edu.crudTeste.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import unoesc.edu.crudTeste.DAO.ClienteDAO;
import unoesc.edu.crudTeste.model.Cliente;

@ManagedBean(name="clienteMB")
@RequestScoped
public class ClienteController {
	
	@ManagedProperty(value="#{ClienteDAO}")
	private ClienteDAO clienteDao;
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes; 

	public void clientesave() {

		if (cliente.getId() == 0) {
			this.clienteDao.insertCliente(cliente);
		} else {
			this.clienteDao.updateCliente(cliente);
		}
		this.cliente = new Cliente();
	}


	public void edit(int id) {

		this.cliente = this.clienteDao.getClienteById(id);
	}


	public void delete(int id) {

		Cliente c = this.clienteDao.getClienteById(id);
		this.clienteDao.deleteCliente(c);
	}

	public ClienteDAO getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Cliente> getClientes() {
		this.clientes = clienteDao.getClientes();
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}