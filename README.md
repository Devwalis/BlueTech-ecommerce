E-commerce API

Este repositório contém a implementação de uma API para um sistema de e-commerce, desenvolvido em Java com Spring Boot. O sistema segue a arquitetura de microsserviços e utiliza bancos de dados relacionais para armazenamento.

Modelo Relacional Lógico:
Relacionamento de Usuário e Endereço
![image](https://github.com/user-attachments/assets/41f0b5b5-78fe-47b5-988e-47210f2a412b)

Relacionamento de Produto e Categoria
![image](https://github.com/user-attachments/assets/56427894-65a1-4431-ac91-45a5f301ce3a)


Tecnologias Utilizadas

Java 17

Spring Boot 3.x (Spring Web, Spring Data JPA, Spring Security, etc.)

Banco de Dados MySQL

Hibernate (ORM)

JWT (JSON Web Token) para autenticação e segurança

Maven para gerenciamento de dependências

Lombok para redução de boilerplate

Swagger para documentação da API

Estrutura do Projeto

A API é composta por módulos distintos para cada funcionalidade principal:

api-produto: Gerenciamento de produtos.

api-usuario: Cadastro, autenticação e gestão de usuários.

api-compras: Processamento de compras e pedidos.

api-arquivos: Upload e gestão de arquivos.

Cada módulo segue os padrões do Spring Boot e está estruturado em:

controllers/ - Camada de controle (exposição de endpoints REST).

services/ - Camada de serviço (regras de negócio e lógica de aplicação).

repositories/ - Camada de persistência (interação com o banco de dados).

models/ - Entidades do banco de dados.

dtos/ - Objetos de transferência de dados.

Configuração do Ambiente

1. Requisitos

Certifique-se de ter instalado:

Java 17

Maven

Docker (opcional, para rodar o MySQL localmente)

3.Sistem Desing

[Client]  
   |  
[API Gateway (Spring Cloud Gateway)]  
   |  
[Microservices (Docker Containers)]  
   ├── User Service (ECS/EKS Task) → RDS  
   ├── Product Service (ECS/EKS Task) → RDS + S3  
   ├── Order Service (ECS/EKS Task) → DynamoDB  
   ├── Payment Service (ECS/EKS Task) → Lambda  
   └── Notification Service (ECS/EKS Task) → SQS + SES  
   |  
[VPC AWS]  
   ├── Subnets Públicas/Privadas  
   └── Security Groups (Restrição de tráfego)  

2. Configurar Banco de Dados

Se estiver usando MySQL localmente, crie um banco de dados:

CREATE DATABASE ecommerce;

Altere o arquivo application.properties ou application.yml conforme sua configuração.

3. Rodar a API

mvn spring-boot:run

A API estará disponível em: http://localhost:8080

Autenticação com JWT

A API usa JWT para autenticação. Para acessar os endpoints protegidos:

Registre-se em /api/usuarios/register

Faça login em /api/usuarios/login e copie o token JWT.

Envie o token no cabeçalho Authorization: Bearer {TOKEN} nas requisições protegidas.

Documentação da API

A documentação interativa da API está disponível no Swagger:

http://localhost:8080/swagger-ui.html

Contribuição

Fork este repositório

Crie um branch para sua funcionalidade (git checkout -b feature-nova)

Commit suas mudanças (git commit -m 'Adicionando nova funcionalidade')

Push para o branch (git push origin feature-nova)

Abra um Pull Request

Autor

Desenvolvido por Walisson.
