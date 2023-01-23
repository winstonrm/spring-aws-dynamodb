package com.punk.aws.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.punk.aws.crud.model.Registro;
import com.punk.aws.crud.service.RegistroService;

@RestController
public class RegistroController {

	private RegistroService registroService;

	@Autowired
	public RegistroController(RegistroService registroService) {
		this.registroService = registroService;
	}

	@PostMapping("/registros")
	public void criarRegistro(@RequestBody Registro registro) {
		registroService.salvarRegistro(registro);
	}

	@GetMapping("/registros/{id}")
	public Registro obterRegistro(@PathVariable String id) {
		return registroService.obterRegistro(id);
	}

	@DeleteMapping("/registros/{id}")
	public void deletarRegistro(@PathVariable String id) {
		registroService.deletarRegistro(id);
	}
}