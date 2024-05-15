package br.org.serratec.exerciciojpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeController {

	@Value("${minha-propriedade}") // Anotação para pegar um valor de application.properties
	private String propriedade; // Variável que guarda o valor vindo "minha-propriedade"

	@GetMapping // GET para retornar propriedade
	public String retornaMinhaPropriedade() {
		return propriedade;
	}
}
