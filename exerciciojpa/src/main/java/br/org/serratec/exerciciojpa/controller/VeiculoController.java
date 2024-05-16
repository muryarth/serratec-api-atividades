package br.org.serratec.exerciciojpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.exerciciojpa.model.Veiculo;
import br.org.serratec.exerciciojpa.repository.VeiculoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping
	public ResponseEntity<List<Veiculo>> listar() {
		return ResponseEntity.ok(veiculoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
		Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);

		if (veiculoOpt.isEmpty()) { // Verifica se retornou uma lista vazia
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(veiculoOpt.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // Garante que o status de retorno dessa requisição seja um "201 Created"
	public Veiculo inserir(@Valid @RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizar(@PathVariable Long id,@Valid @RequestBody Veiculo veiculo) {
		if (veiculoRepository.existsById(id)) {
			/*
			 * Verifica se já tem algum elemento com esse id, se não houver, não faz sentido
			 * fazer uma tentativa de PUT
			 */
			
			veiculo.setId(id);
			veiculo = veiculoRepository.save(veiculo);
			return ResponseEntity.ok(veiculo);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (veiculoRepository.existsById(id)) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
