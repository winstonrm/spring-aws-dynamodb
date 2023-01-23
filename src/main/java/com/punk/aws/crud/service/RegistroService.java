package com.punk.aws.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.punk.aws.crud.model.Registro;

@Service
public class RegistroService {

	private AmazonDynamoDB dynamoDB;

	@Autowired
	public RegistroService(AmazonDynamoDB dynamoDB) {
		this.dynamoDB = dynamoDB;
	}

	public void salvarRegistro(Registro registro) {
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
		mapper.save(registro);
	}

	public Registro obterRegistro(String id) {
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
		return mapper.load(Registro.class, id);
	}

	public void deletarRegistro(String id) {
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
		mapper.delete(new Registro().withId(id));
	}
}
