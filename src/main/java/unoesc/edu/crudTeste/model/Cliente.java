package unoesc.edu.crudTeste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente{
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk_clientes")
		private int id;
		
		@Column(name = "nome")
		private String nome;
		@Column(name = "idade")
		private Integer idade;
		@Column(name = "usuario")
		private String usuario;
		@Column(name = "senha")
		private String senha;
		@Column(name = "root")
		private Boolean root;
		
		public Cliente() {
			
		}
		
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getIdade() {
			return idade;
		}
		public void setIdade(Integer idade) {
			this.idade = idade;
		}
		public Boolean getRoot() {
			return root;
		}
		public void setRoot(Boolean root) {
			this.root = root;
		}
		@Override
		public int hashCode() {
			return this.id + this.usuario.length();
		}
		@Override
		public String toString() {
			return this.usuario;
		}
		
}