package br.org.serratec.exerciciojpa.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id // Representa que esse atributo é a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Informa o incremento da primary key
	@Column(name = "id_produto")
	private Long id;
	
	@Column(name = "descricao", nullable = false, length = 40)
	private String descricao;
	
	@Column
	private BigDecimal valor;
	
	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	// Command + 3 -> ggas -> Gera getters e setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() { // Serve para mapear o objeto pelo id
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { // Evita comparar o objeto com endereço de memória
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}