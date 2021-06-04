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
		
		@Column
		private String nome;
		@Column
		private String sobrenome;
		@Column
		private String usuario;
		@Column
		private String senha;
		@Column
		private Integer idade;
		
		
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
		public String getSobrenome() {
			return sobrenome;
		}
		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}
		public Integer getIdade() {
			return idade;
		}
		public void setIdade(Integer idade) {
			this.idade = idade;
		}


}