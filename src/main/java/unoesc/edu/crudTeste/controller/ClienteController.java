package unoesc.edu.crudTeste.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;
import com.sun.istack.NotNull;

import unoesc.edu.crudTeste.DAO.ClienteDAO;
import unoesc.edu.crudTeste.model.Cliente;
import unoesc.edu.crudTeste.util.SessionContext;

@ManagedBean(name = "clienteMB")
@RequestScoped
public class ClienteController {

	@ManagedProperty(value = "#{ClienteDAO}")
	private ClienteDAO clienteDao;

	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;

	private boolean logado = false;

	private boolean isRoot = false;

	public void clientesave() {

		if (cliente.getId() == 0) {
			this.clienteDao.insertCliente(cliente);
		} else {
			this.clienteDao.updateCliente(cliente);
		}
		this.cliente = new Cliente();
	}

	public ClienteController() {
		Cliente user = (Cliente) SessionContext.getInstance().getAttribute("usuarioLogado");
		if (user != null) {
			logado = true;
			isRoot = user.getRoot();
		}
	}

	public void fazLogin() throws IOException {
		FacesMessage message = null;

		cliente = clienteDao.validaLogin(this.getCliente().getUsuario(),
				this.encryptSenha(this.getCliente().getSenha()));

		if (cliente != null) {
			logado = true;
			SessionContext.getInstance().setAttribute("usuarioLogado", cliente);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login realizado com sucesso!",
					this.getCliente().getUsuario());
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro no Login!", "Usuário ou senha inválido");
			SessionContext.getInstance().setAttribute("usuarioLogado", null);
			logado = false;
			cliente = new Cliente();
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", logado);

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect("index.xhtml");
		System.out.println("fez login");
		// return "redirect:views/Index.xhtml";
	}

	public void fazLogout() throws IOException {
		FacesMessage message = null;

		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout!", "Até mais.");
		SessionContext.getInstance().setAttribute("usuarioLogado", null);
		logado = false;
		isRoot = false;
		cliente = new Cliente();

		FacesContext.getCurrentInstance().addMessage(null, message);

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	private String encryptSenha(String senha) {
		MessageDigest mDigest;
		try {
			// Instanciamos o nosso HASH MD5, poderíamos usar outro como
			// SHA, por exemplo, mas optamos por MD5.
			mDigest = MessageDigest.getInstance("MD5");

			// Convert a String valor para um array de bytes em MD5
			byte[] valorMD5 = mDigest.digest(senha.getBytes("UTF-8"));

			// Convertemos os bytes para hexadecimal, assim podemos salvar
			// no banco para posterior comparação se senhas
			StringBuffer sb = new StringBuffer();
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
			}

			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void load(int id) {
		this.cliente = clienteDao.getClienteById(id);
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

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

}