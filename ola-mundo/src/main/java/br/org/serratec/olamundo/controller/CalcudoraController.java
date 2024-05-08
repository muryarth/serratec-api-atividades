package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculadora")
public class CalcudoraController {
	
	@GetMapping("/soma")
	public Integer soma(@RequestParam Integer n1, @RequestParam Integer n2) {
		return n1 + n2;
	}
	
	@GetMapping("/subtracao")
	public Integer subtracao(@RequestParam Integer n1, @RequestParam Integer n2) {
		return n1 - n2;
	}
	
	@GetMapping("/multiplicacao")
	public Integer multiplicacao(@RequestParam Integer n1, @RequestParam Integer n2) {
		return n1 * n2;
	}
	
	@GetMapping("/divisao")
	public Integer divisao(@RequestParam Integer n1, @RequestParam Integer n2) {
		return n1 / n2;
	}
}
