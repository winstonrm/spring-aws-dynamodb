package com.punk.aws.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.punk.aws.crud.model.Registro;

@SpringBootApplication
public class SpringAwsDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsDynamodbApplication.class, args);

		RestTemplate restTemplate = new RestTemplate();

		// Criando um novo registro
		Registro registro = new Registro();
		registro.setId("1");
		registro.setNome("Registro 1");
		registro.setDescricao("Descrição do Registro 1");
		HttpEntity<Registro> request = new HttpEntity<>(registro);
		restTemplate.postForEntity("http://localhost:8080/registros", request, Registro.class);

		// Consultando um registro
		Registro registroConsultado = restTemplate.getForObject("http://localhost:8080/registros/1", Registro.class);
		System.out.println(registroConsultado.getNome());

		// Deletando um registro
		restTemplate.delete("http://localhost:8080/registros/1");

		// Tentando consultar o registro novamente (deve retornar erro 404)
		try {
			registroConsultado = restTemplate.getForObject("http://localhost:8080/registros/1", Registro.class);
		} catch (HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
		}
	}

}
