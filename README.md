# Api Rest com Kotlin

## Curso 2 - Camada Persitência
- JPA e H2 Database

### Dependências Utilizadas
- JPA & Hibernate
- Flyway
 
### Nesse projeto você aprendeu
- Adicionar o Spring Data JPA na API, incluindo suas dependências no arquivo pom.xml
- Configurar o Spring Data JPA via propriedades no arquivo application.yml;
- Mapear as classes de domínio como entidades JPA, utilizando as anotações @Entity, @Id, @ManyToOne e @OneToMany;
- Criar interfaces repository para acesso ao banco de dados, herdando da interface JpaRepository do Spring Data JPA;
- Como adicionar o Flyway como ferramenta de migration na API, via dependência no arquivo pom.xml;
- Como definir as migrations da API, criando scripts SQL na pasta src/main/resources/db/migrations;
- A criar métodos de consultas com filtros nos repositórios da API, utilizando o padrão de nomenclatura findBy do Spring Data JPA;
- Como realizar paginação e ordenação nas consultas ao banco de dados utilizando a interface Pageable do Spring Data JPA;
- A modificar os parâmetros default de paginação e ordenação com a utilização da anotação @PageableDefault.

## Curso 1 - Camada Web
### Obejtivo
- Criar uma API utilizando Kotlin com o framework Spring com MVC.
- Criação de Models/ Domínios.
- Criação de Controller.
- Crud.
- Service.
    - Lógica da aplicação.
- DTO.
    - Representação de dados da API.
- Mappers.
    - Conversão de Dados DTO<->Domínio
- Tratamento de Erros.
- Boas práticas de Rest.

### Dependências Utilizadas
- Bean Validation
 
### Nesse projeto você aprendeu
- Criar um projeto Kotlin com Spring Boot utilizando o site do ***Spring Initializr***.
- Criar classes de domínio que representam os recursos da API (***model***).
- A trabalhar com requisições ***GET*** na API utilizando a anotação @GetMapping.
- Como trabalhar com requisições ***POST*** na API com as anotações ***@PostMapping*** e ***@RequestBody***;
- A criar uma camada ***Service*** na API para isolar as regras de negócio.
- Como receber um parâmetro pela URI utilizando a anotação ***@PathVariable***.
- A criar classes ***DTO*** para representar os dados da API;
- A criar classes ***Mapper*** para a conversão de objetos DTO;
- Como realizar validações utilizando o ***Bean Validation*** com as anotações ***@Valid***, ***@NotEmpty*** e ***@Size***.
- A trabalhar com requisições PUT na API com a anotação ***@PutMapping***.
- A trabalhar com requisições DELETE na API com a anotação ***@DeleteMapping***.
- A seguir ***boas práticas do REST*** nos retornos da API, com a utilização correta dos códigos HTTP.
- A criar uma classe ***Controller Advice*** para tratamento de erros na API, utilizando as anotações ***@RestControllerAdvice*** e ***@ExceptionHandler***.
- A realizar o tratamento de erros 500 que ocorrerem na API.
- A realizar o tratamento de erros 400 que ocorrerem na API.