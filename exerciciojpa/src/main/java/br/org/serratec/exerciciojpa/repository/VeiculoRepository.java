package br.org.serratec.exerciciojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.exerciciojpa.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
