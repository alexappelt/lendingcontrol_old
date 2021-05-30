package unoesc.edu.crudTeste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto{
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk_produtos")
		private int id;
		
		@Column
		private String descricao;
		@Column
		private String marca;
		@Column
		private String cor;
		@Column
		private Float valor;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
		public Float getValor() {
			return valor;
		}
		public void setValor(Float valor) {
			this.valor = valor;
		}

}