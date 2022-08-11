
# API Palavras-Etiqueta

Projeto desenvolvido para o estudo do conceito de **REST API**, atividade que foi proposta pelo instrutor [Michel Menezes](https://www.linkedin.com/in/michelmpin/)
do programa Starter da GFT.

O projeto tem como base a ideia de um **CRUD** para cadastro de Etiquetas e Palavras, que possuem
um relacionamento **Many-to-Many** entre essas entidades, com operações de criação, exclusão, pesquisa
(por ID, Etiquetas em Palavras e Palavras em Etiquetas) e atualização, seguindo os princípios do REST API para
criação de uma **API RESTful**.

## API REST

É uma interface para a programação de programas que segue os princípios REST(*Representational State Transfer*).

**_Níveis do Rest Glory_**
- Nível 3: Hypermedia Controls;
- Nível 2: Verbos HTTP;
- Nível 1: Recuros;
- Nível 0: Pântano do POX.

Leia mais clicando [aqui](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api).

## "Run" no projeto

Para iniciar o projeto, faça o *download* da branch do modo que desejar e em um projeto spring starter
inicializado na sua IDE de preferência, com a branch dentro dele, aperte botão direito no projeto, e então
**"Run as > Spring Boot App"**.

O projeto possui a biblioteca do **Swagger** que pode ser acessado a partir do localhost iniciado(ex.: http://localhost:8080/swagger-ui.html), onde
estão listadas todas as requisições da API e a possibilidade de realizar elas, que também podem ser feitas através de outros "HTTP clients",
por exemplo, através do **Postman**.

> É necessário a utilização do MySql Workbench para a implementação com o banco de dados e atualize o application.properties em src > main > resources > application.properties com os dados do seu Workbench (usuário, senha e outros caso necessário).

**_ATENÇÃO_**: O projeto possui a implementação do **Spring Security**, sendo necessário que haja a autenticação via usuário e senha, na qual ja possuí
dois cadastrados:
`````
ADMIN (admin)
usuário: admin@gft.com
senha: 1234
___________________________

USUÁRIO (user)
usuário: usuario@gft.com
senha: 1234
`````
Ápos a autenticação, copiei o **token gerado no JSON** e abra o menu de "*Authorize*" do swagger, localizado na direita acima das requisições,
então escreva **"Bearer [seu token aqui]"** sem os colchetes, a partir disso as requisições devem estar permitidas nos endpoints abaixo:
## Endpoints da API

**Autenticação**
| MÉTODOS|             TRAJETO            |     FUNÇÃO         |   PERMISSÕES   |
| ------ | -------------------------------|------------------- |--------------- |
| POST   | /v1/auth                       | Gerar Token JWT    |     Todos      |

**Etiqueta**

| MÉTODOS|             TRAJETO                    |     FUNÇÃO         |   PERMISSÕES   |
| ------ | -------------------------------------- |------------------- | -------------- |
| GET    | /v1/etiquetas                          | Busca Etiquetas    |   admin, user  |
| GET    | /v1/etiquetas/{id}                     | Busca uma Etiqueta |   admin, user  |
| GET    | /v1/etiquetas/buscarEtiquetaPorPalavra | Busca por Palavra  |   admin, user  |            
| POST   | /v1/etiquetas/{id}                     | Adiciona Etiqueta  |   admin        |
| PUT    | /v1/etiquetas/{id}                     | Edita Etiqueta     |   admin        |
| DELETE | /v1/etiquetas/{id}                     | Deleta Etiqueta    |   admin        |

**Palavra**

| MÉTODOS|             TRAJETO            |     FUNÇÃO         |   PERMISSÕES   |
| ------ | -------------------------------| ------------------ |--------------- |
| GET    | /v1/palavras                   | Busca Palavra      |   admin, user  |
| GET    | /v1/palavras/{id}              | Busca uma Palavra  |   admin, user  |
| GET    | /v1/palavras/buscarPorEtiqueta | Busca por Etiqueta |   admin, user  |            
| POST   | /v1/palavras/{id}              | Adiciona Palavra   |   admin        |
| PUT    | /v1/palavras/{id}              | Edita Palavra      |   admin        |
| DELETE | /v1/palavras/{id}              | Deleta Palavra     |   admin        |

**Usuário**

| MÉTODOS|             TRAJETO            |     FUNÇÃO         |   PERMISSÕES   |
| ------ | -------------------------------|------------------- |--------------- |
| GET    | /v1/usuarios                   | Busca Usuário      |   admin, user  |
| GET    | /v1/usuarios/{id}              | Busca um Usuário   |   admin, user  |
| POST   | /v1/usuarios/{id}              | Adiciona Etiqueta  |   admin        |
| PUT    | /v1/usuarios/{id}              | Edita Usuário      |   admin        |
| DELETE | /v1/usuarios/{id}              | Deleta Usuário     |   admin        |


## Tecnologias Utilizadas

- [Java 17](https://docs.oracle.com/en/java/);
- [Spring Boot](https://spring.io/projects/spring-boot);
- [Spring Security](https://spring.io/projects/spring-security);
- [Spring Data](https://spring.io/projects/spring-data);
- [MySQL Workbench](https://dev.mysql.com/doc/workbench/en/);
- [Swagger](https://swagger.io/);
- Outras.

## Autores e Redes Sociais
Projeto desenvolvido em conjunto por Guilherme Albani Camargo e Luiz Felipe Kaercher de Oliveira.

***Guilherme Albani Camargo***
[![github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white
)](https://github.com/GuiACamargo) 
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/guilhermecamargodev/)

***Luiz Felipe Kaercher de Oliveira***
[![github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white
)](https://github.com/luizfelipe079) 
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/luiz-fk-oliveira/)






