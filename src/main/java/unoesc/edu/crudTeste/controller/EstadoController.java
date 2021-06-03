package unoesc.edu.crudTeste.controller;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import unoesc.edu.crudTeste.DAO.EstadoDAO;
import unoesc.edu.crudTeste.model.Estado;

public class EstadoController {

	@ManagedProperty(value="#{EstadoDAO}")
	private EstadoDAO estadoDao;
	
	private Estado estado = new Estado();
	private List<Estado> estados; 

	public void clientesave() {

		if (estado.getId() == 0) {
			this.estadoDao.insertEstado(estado);
		} else {
			this.estadoDao.updateEstado(estado);
		}
		this.estado = new Estado();
	}


	public void edit(int id) {

		this.estado = this.estadoDao.getEstadoById(id);
	}


	public void delete(int id) {

		Estado c = this.estadoDao.getEstadoById(id);
		this.estadoDao.deleteEstado(c);
	}


	public EstadoDAO getEstadoDao() {
		return estadoDao;
	}


	public void setEstadoDao(EstadoDAO estadoDao) {
		this.estadoDao = estadoDao;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public List<Estado> getEstados() {
		return estados;
	}


	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
}
