# Api Rest com Kotlin

## Obejtivo
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

## Dependências Utilizadas
- Bean Validation
 
## Nesse projeto você aprendeu
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