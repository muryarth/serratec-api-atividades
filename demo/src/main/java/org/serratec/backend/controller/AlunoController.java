package org.serratec.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.domain.Aluno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private static List<Aluno> lista = new ArrayList<>();

	static {
		lista.add(new Aluno(2354L, "Fulano", "2222-4444"));
		lista.add(new Aluno(2465L, "Ciclano", "3333-4444"));
		lista.add(new Aluno(1111L, "Triclano", "1111-4444"));
	}

	@GetMapping
	public List<Aluno> listar() {
		return lista;
	}

	@GetMapping("/{matricula}")
	public Aluno buscar(@PathVariable Long matricula) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getMatricula().equals(matricula)) {
				return lista.get(i);
			}
		}
		return null;
	}
	
	@PostMapping
	public Aluno inserir(@RequestBody Aluno aluno) {
		lista.add(aluno);
		return aluno;
	}
}
