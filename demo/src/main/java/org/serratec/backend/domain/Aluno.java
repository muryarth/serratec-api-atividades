package org.serratec.backend.domain;

public class Aluno {
	private Long matricula; // -> variável inteira que ocupa mais memória
	private String nome;
	private String telefone;
	
	public Aluno() {
		super();
	}
	
	public Aluno(Long matricula, String nome, String telefone) { // -> sobrescreve o construtor vazio
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
