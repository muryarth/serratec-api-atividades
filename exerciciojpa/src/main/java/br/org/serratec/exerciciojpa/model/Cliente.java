package br.org.serratec.exerciciojpa.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;

	@NotBlank(message = "O preenchimento de *nome* é obrigatório para *Cliente*.")
	@Size(max = 15, message = "Tamanho máximo 15.")
	@Column(name = "nome", nullable = false, length = 15)
	private String nome;

	@NotBlank(message = "O preenchimento de *cpf* é obrigatório para *Cliente*.")
	@Size(max = 11, message = "Tamanho máximo 11.")
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@NotBlank(message = "O preenchimento de *email* é obrigatório para *Cliente*.")
	@Size(max = 15, message = "O campo email só aceita 15 caracteres.")
	@Column(name = "email", nullable = false, length = 15)
	private String email;

	@NotNull(message = "O preenchimento de *dataNascimento* é obrigatório para *Cliente*.")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
				+ dataNascimento + "]";
	}
}
