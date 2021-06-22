package unoesc.edu.emprestimo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk_emprestimos")
	private int id;

	@Column(name="data")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@Column(name = "classificacao")
	private Integer classificacao;
	
	@ManyToOne
	@JoinColumn(name = "id_mutuante", referencedColumnName ="id")
	private Usuario mutuante;
	
	@ManyToOne
	@JoinColumn(name = "id_beneficiario", referencedColumnName ="id")
	private Usuario beneficiario;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName ="id")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "id_status", referencedColumnName ="id")
	private Status status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

	public Usuario getMutuante() {
		return mutuante;
	}

	public void setMutuante(Usuario mutuante) {
		this.mutuante = mutuante;
	}

	public Usuario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Usuario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficiario == null) ? 0 : beneficiario.hashCode());
		result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + id;
		result = prime * result + ((mutuante == null) ? 0 : mutuante.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (beneficiario == null) {
			if (other.beneficiario != null)
				return false;
		} else if (!beneficiario.equals(other.beneficiario))
			return false;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (mutuante == null) {
			if (other.mutuante != null)
				return false;
		} else if (!mutuante.equals(other.mutuante))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
