package com.punk.aws.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.punk.aws.crud.model.Registro;
import com.punk.aws.crud.service.RegistroService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistroServiceTest {

	@Autowired
	private RegistroService registroService;

	@Test
	public void testSaveRegistro() {
		Registro registro = new Registro();
		registro.setId("1");
		registro.setNome("Registro de teste");
		registro.setDescricao("Descrição do registro de teste");
		registroService.salvarRegistro(registro);

		Registro registroSalvo = registroService.obterRegistro("1");
		assertEquals(registro, registroSalvo);
	}

	@Test
	public void testGetRegistro() {
		Registro registro = new Registro();
		registro.setId("1");
		registro.setNome("Registro de teste");
		registro.setDescricao("Descrição do registro de teste");
		registroService.salvarRegistro(registro);

		Registro registroObtido = registroService.obterRegistro("1");
		assertEquals(registro, registroObtido);
	}

	@Test
	public void testDeleteRegistro() {
		Registro registro = new Registro();
		registro.setId("1");
		registro.setNome("Registro de teste");
		registro.setDescricao("Descrição do registro de teste");
		registroService.salvarRegistro(registro);

		registroService.deletarRegistro("1");
		Registro registroDeletado = registroService.obterRegistro("1");
		assertNull(registroDeletado);
	}
}
