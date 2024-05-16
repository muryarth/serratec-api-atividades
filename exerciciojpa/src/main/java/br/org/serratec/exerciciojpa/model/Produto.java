package br.org.serratec.exerciciojpa.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@NotBlank(message = "O preenchimento de *descricao* é obrigatório para *Produto*.")
	@Size(max = 40, message = "Tamanho máximo 40")
	@Column(name = "descricao", nullable = false, length = 40)
	private String descricao;

	@NotNull(message = "O preenchimento de *preco* é obrigatório para *Produto*.")
	@DecimalMax(value = "5000", message = "*preco* não pode ser maior que R${value}.00")
	@DecimalMin(value = "10", message = "*preco* não pode ser menor que R${value}.00")
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	@NotNull(message = "O preenchimento de *dataCadastro* é obrigatório para *Produto*.")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

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

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", dataCadastro=" + dataCadastro
				+ "]";
	}
}