# Projeto de exemplo utilizando Spring Boot e AWS
Este projeto é um exemplo de como utilizar o Spring Boot e o AWS DynamoDB para criar, consultar e deletar registros.

## Pré-requisitos
JDK 8 ou superior
Maven
Uma conta na AWS e as credenciais de acesso configuradas

## Configuração
Clone o repositório para o seu ambiente de desenvolvimento
Adicione as suas credenciais de acesso da AWS em src/main/resources/application.properties
Configure o endpoint do DynamoDB em src/main/resources/application.properties

## Execução
Execute o comando mvn clean install para baixar as dependências e realizar o build do projeto
Execute o comando mvn spring-boot:run para iniciar a aplicação
Utilize as operações de criação, consulta e deleção de registros através do endpoint http://localhost:8080/registros
