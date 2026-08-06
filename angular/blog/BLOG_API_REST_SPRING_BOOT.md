# Blog API REST

## Projeto

API REST completa para gerenciamento de um Blog utilizando Java 25 + Spring Boot.

O projeto será desenvolvido seguindo padrões utilizados no mercado:

- Arquitetura em camadas
- RESTful API
- DTO Pattern
- Service Layer
- Repository Pattern
- Spring Security
- JWT Authentication
- Refresh Token
- OpenAPI Swagger
- Testes automatizados
- Banco relacional


---

# Objetivo


Desenvolver uma API REST profissional para gerenciamento de conteúdo de Blog.


A API deverá permitir:


## Gestão de usuários

- Login
- Logout
- Cadastro
- Autorização
- Controle de permissões


## Gestão de conteúdo

- Autores
- Categorias
- Posts
- Tags
- Comentários
- Likes


## Recursos adicionais

- Paginação
- Ordenação
- Filtros
- Upload de imagens
- Auditoria
- Segurança


---

# Arquitetura


```text

Controller

      ↓

Service

      ↓

Repository

      ↓

Entity

      ↓

Database


```


---

# Tecnologias


## Backend


- Java 25
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Spring Security
- JWT
- Refresh Token
- Bean Validation
- Lombok


## Banco de Dados


Produção:

- MySQL 8
- MariaDB 10/11
- PostgreSQL


Testes:

- H2 Database


## Testes


- JUnit 5
- Mockito
- Spring Boot Test
- MockMvc
- JaCoCo


## Documentação


- OpenAPI
- Swagger UI


## Build


- Maven


---

# Estrutura do Projeto


```

src/main/java


├── config
│
├── controller
│
├── service
│
├── repository
│
├── entity
│
├── dto
│
├── mapper
│
├── security
│
├── exception
│
├── validation
│
└── util



src/test/java


├── controller

├── service

├── repository

└── integration

```


---

# Banco de Dados


Modelo baseado:


- Author
- Category
- Tag
- Post
- Comment
- Like
- User
- RefreshToken


---

# Entidades


# User


Usuário responsável pela autenticação.


Campos:


```
id

nome

email

senha

role

ativo

dataCadastro

```


Relacionamento:


```

User

1

↓

N

RefreshToken

```


---

# Role


Controle de permissão.


Valores:


```
ADMIN

AUTHOR

USER

```


---

# Author


Campos:


```
id

nome

email

bio

dataCadastro

ativo

```


Relacionamento:


```

Author

1

↓

N

Post

```


---

# Category


Campos:


```
id

nome

descricao

```


Relacionamento:


```

Category

1

↓

N

Post

```


---

# Tag


Campos:


```
id

nome

```


Relacionamento:


```

Tag

N

↓

N

Post

```


---

# Post


Campos:


```
id

titulo

conteudo

resumo

slug

dataCriacao

dataAtualizacao

publicado

views

imagem

author

category

tags

```


Relacionamentos:


```

Author

1 -------- N

Post



Category

1 -------- N

Post



Post

N -------- N

Tag



Post

1 -------- N

Comment



Post

1 -------- N

Like

```


---

# Comment


Campos:


```
id

nome

email

texto

dataComentario

post

```


---

# Like


Campos:


```
id

ip

dataLike

post

```


---

# RefreshToken


Controle de renovação do JWT.


Campos:


```
id

token

dataExpiracao

usuario

```


---

# DTOs


A API nunca irá retornar Entity diretamente.


Utilizar:


```
Request DTO

Response DTO

```


---

# Author DTO


## AuthorResponseDTO


```json
{
"id":1,
"nome":"João",
"email":"joao@email.com",
"bio":"Java Developer"
}
```


## CreateAuthorDTO


```json
{
"nome":"João",
"email":"joao@email.com",
"bio":"Java Developer"
}
```


---

# Authentication DTO


## LoginRequestDTO


Endpoint:

```
POST /api/v1/auth/login
```


Request:


```json
{
"email":"admin@email.com",
"senha":"123456"
}

```


Response:


```json
{
"accessToken":"jwt-token",

"refreshToken":"refresh-token",

"type":"Bearer"

}

```


---

# Refresh Token DTO


Endpoint:


```
POST /api/v1/auth/refresh
```


Request:


```json
{

"refreshToken":"token"

}

```


Response:


```json
{

"accessToken":"novo-jwt",

"refreshToken":"novo-refresh"

}

```

---

# API REST Endpoints

Todos os endpoints seguem o padrão:

```
/api/v1
```

Formato:

```
HTTP METHOD + URL + JSON
```


---

# Authentication API

Responsável pelo login e renovação do token.


Base:

```
/api/v1/auth
```


---

# Login

## POST

```
POST /api/v1/auth/login
```


Permissão:

```
PUBLIC
```


Request:

```json
{
    "email":"admin@email.com",
    "senha":"123456"
}
```


Response:

```json
{
    "accessToken":"jwt-token",

    "refreshToken":"refresh-token",

    "expiresIn":900,

    "type":"Bearer"
}
```


---

# Refresh Token


## POST


```
POST /api/v1/auth/refresh
```


Request:


```json
{
    "refreshToken":"token"
}
```


Response:


```json
{

"accessToken":"novo-token",

"refreshToken":"novo-refresh-token"

}
```


---

# Logout


## POST


```
POST /api/v1/auth/logout
```


Ação:

- invalidar refresh token
- remover sessão


---

# User API


Gerenciamento dos usuários do sistema.


Base:


```
/api/v1/users
```


---

# Cadastrar Usuário


## POST


```
POST /api/v1/users
```


Permissão:

```
ADMIN
```


Request:


```json
{
"nome":"Administrador",

"email":"admin@email.com",

"senha":"123456",

"role":"ADMIN"

}
```


Response:


```json
{
"id":1,

"nome":"Administrador",

"email":"admin@email.com",

"role":"ADMIN"

}
```


---

# Listar Usuários


## GET


```
GET /api/v1/users
```


---

# Buscar Usuário


## GET


```
GET /api/v1/users/{id}
```


---

# Atualizar Usuário


## PUT


```
PUT /api/v1/users/{id}
```


---

# Remover Usuário


## DELETE


```
DELETE /api/v1/users/{id}
```


---

# Author API


Base:


```
/api/v1/authors
```


---

# Cadastrar Autor


## POST


```
POST /api/v1/authors
```


Request:


```json
{
"nome":"João Silva",

"email":"joao@email.com",

"bio":"Desenvolvedor Java"
}
```


---

# Listar Autores


## GET


```
GET /api/v1/authors
```


Com paginação:


```
GET /api/v1/authors?page=0&size=10
```


---

# Buscar Autor


## GET


```
GET /api/v1/authors/{id}
```


---

# Atualizar Autor


## PUT


```
PUT /api/v1/authors/{id}
```


---

# Deletar Autor


## DELETE


```
DELETE /api/v1/authors/{id}
```


---

# Category API


Base:


```
/api/v1/categories
```


---

# Criar Categoria


## POST


```
POST /api/v1/categories
```


Request:


```json
{
"nome":"Java",

"descricao":"Conteúdo Java"
}
```


---

# Listar Categorias


```
GET /api/v1/categories
```


---

# Buscar Categoria


```
GET /api/v1/categories/{id}
```


---

# Atualizar Categoria


```
PUT /api/v1/categories/{id}
```


---

# Excluir Categoria


```
DELETE /api/v1/categories/{id}
```


---

# Tag API


Base:


```
/api/v1/tags
```


---

# Criar Tag


```
POST /api/v1/tags
```


Request:


```json
{
"nome":"Spring Boot"
}
```


---

# Listar Tags


```
GET /api/v1/tags
```


---

# Buscar Tag


```
GET /api/v1/tags/{id}
```


---

# Atualizar Tag


```
PUT /api/v1/tags/{id}
```


---

# Excluir Tag


```
DELETE /api/v1/tags/{id}
```


---

# Post API


Principal recurso do Blog.


Base:


```
/api/v1/posts
```


---

# Criar Post


## POST


```
POST /api/v1/posts
```


Permissão:


```
AUTHOR
ADMIN
```


Request:


```json
{
"titulo":"Spring Boot REST",

"conteudo":"Criando API REST",

"resumo":"API Java",

"slug":"spring-boot-rest",

"publicado":true,

"authorId":1,

"categoryId":1,

"tags":[1,2,3]
}
```


---

# Listar Posts


```
GET /api/v1/posts
```


---

# Buscar Post


```
GET /api/v1/posts/{id}
```


---

# Atualizar Post


```
PUT /api/v1/posts/{id}
```


---

# Excluir Post


```
DELETE /api/v1/posts/{id}
```


---

# Buscar Posts por Categoria


```
GET /api/v1/posts/category/{categoryId}
```


Exemplo:


```
GET /api/v1/posts/category/1
```


---

# Buscar Posts por Autor


```
GET /api/v1/posts/author/{authorId}
```


---

# Buscar Posts por Tag


```
GET /api/v1/posts/tag/{tagId}
```


---

# Pesquisar Posts


```
GET /api/v1/posts/search?titulo=java
```


---

# Últimos Posts


```
GET /api/v1/posts/latest
```


Retorna:

```
Top 5 posts recentes
```


---

# Posts Populares


```
GET /api/v1/posts/popular
```


Ordenação:

```
views DESC
```


---

# Incrementar Views


Quando usuário abrir um post:


```
POST /api/v1/posts/{id}/view
```


---

# Comment API


Base:


```
/api/v1/comments
```


---

# Criar Comentário


```
POST /api/v1/comments
```


Request:


```json
{
"nome":"Maria",

"email":"maria@email.com",

"texto":"Excelente artigo",

"postId":1
}
```


---

# Listar Comentários


```
GET /api/v1/comments
```


---

# Buscar Comentário


```
GET /api/v1/comments/{id}
```


---

# Buscar Comentários do Post


```
GET /api/v1/posts/{postId}/comments
```


---

# Excluir Comentário


```
DELETE /api/v1/comments/{id}
```


---

# Like API


Base:


```
/api/v1/posts/{postId}/likes
```


---

# Curtir Post


```
POST /api/v1/posts/{postId}/likes
```


Regra:


```
Mesmo IP não pode curtir duas vezes.
```


---

# Remover Like


```
DELETE /api/v1/posts/{postId}/likes
```


---

# Paginação


Todos os GET de lista suportam:


```
?page=0
&size=10
&sort=dataCriacao
```


Exemplo:


```
GET /api/v1/posts?page=0&size=20&sort=views,desc
```


---

# Filtros


## Por título


```
GET /api/v1/posts?titulo=spring
```


## Por categoria


```
GET /api/v1/posts?categoria=1
```


## Por autor


```
GET /api/v1/posts?autor=2
```


## Publicados


```
GET /api/v1/posts?publicado=true
```


---

# Segurança Spring Security


Rotas públicas:


```
POST /api/v1/auth/login

POST /api/v1/auth/refresh

GET /api/v1/posts

GET /api/v1/categories

GET /api/v1/tags

```


---

Rotas autenticadas:


```
POST /api/v1/posts

PUT /api/v1/posts/{id}

DELETE /api/v1/posts/{id}

POST /api/v1/comments

DELETE /api/v1/comments/{id}

```


---

# Permissões


## ADMIN


Pode:

- criar usuários
- excluir usuários
- gerenciar tudo


## AUTHOR


Pode:

- criar posts
- editar seus posts
- excluir seus posts


## USER


Pode:

- comentar
- curtir


---

# Swagger OpenAPI


URL:


```
http://localhost:8080/swagger-ui/index.html
```


Documentação:


```
http://localhost:8080/v3/api-docs
```


Configurar:

- JWT Bearer Authentication
- Models
- Responses
- Examples JSON


---

# Resumo dos Controllers


```
AuthController

UserController

AuthorController

CategoryController

TagController

PostController

CommentController

LikeController

```


Cada Controller deverá possuir:


```
@GetMapping

@PostMapping

@PutMapping

@DeleteMapping

```


Seguindo padrão RESTful.

---

# Estratégia de Testes - JUnit 5 + Mockito

## Objetivo

Garantir qualidade da API REST através de testes automatizados.

Tipos de testes:

- Testes Unitários com Mockito
- Testes de Repository com H2
- Testes de Integração com Spring Boot Test
- Testes dos Controllers com MockMvc


---

# Estrutura de Testes


```
src/test/java


com.blog.api


├── controller

│   ├── AuthControllerTest

│   ├── AuthorControllerTest

│   ├── CategoryControllerTest

│   ├── PostControllerTest

│   └── CommentControllerTest


├── service

│   ├── AuthorServiceTest

│   ├── CategoryServiceTest

│   ├── PostServiceTest

│   ├── CommentServiceTest

│   └── AuthServiceTest


├── repository

│   ├── AuthorRepositoryTest

│   ├── PostRepositoryTest

│   └── UserRepositoryTest


└── integration

    └── BlogApiIntegrationTest

```


---

# Dependências


## JUnit 5


Utilizar:


```java
org.junit.jupiter.api.Test
```


---

## Mockito


Utilizar:


```java
@Mock

@InjectMocks

@InjectCaptor

when()

given()

verify()

ArgumentCaptor

```


---

# Testes Unitários - Services


# AuthorServiceTest


Classe:


```java
AuthorServiceTest
```


## Criar Autor


Nome:


```java
salvar_AutorComDadosValidos_DeveCadastrarAutor()
```


Cenário:


- Email não existe
- Dados válidos
- Repository salva


Validar:


```java
verify(authorRepository)
.save()
```


---

## Email duplicado


```java
salvar_AutorComEmailExistente_DeveLancarEmailDuplicadoException()
```


Cenário:


- Email já cadastrado


Esperado:


```java
EmailDuplicadoException
```


---

## Buscar por ID


```java
buscarPorId_AutorExistente_DeveRetornarAutor()
```


---

## Buscar ID inexistente


```java
buscarPorId_AutorNaoEncontrado_DeveLancarResourceNotFoundException()
```


---

## Atualizar Autor


```java
editar_AutorExistente_DeveAtualizarDados()
```


---

## Excluir Autor


```java
remover_AutorExistente_DeveExcluirAutor()
```


---

## Excluir inexistente


```java
remover_AutorNaoEncontrado_DeveLancarException()
```


---

# CategoryServiceTest


## Criar categoria


```java
salvar_CategoriaValida_DeveCadastrarCategoria()
```


---

## Nome duplicado


```java
salvar_CategoriaComNomeExistente_DeveLancarException()
```


---

## Buscar categoria


```java
buscarPorId_CategoriaExistente_DeveRetornarCategoria()
```


---

## Atualizar categoria


```java
editar_CategoriaExistente_DeveAtualizarCategoria()
```


---

## Remover categoria


```java
remover_CategoriaExistente_DeveExcluirCategoria()
```


---

# TagServiceTest


## Criar Tag


```java
salvar_TagValida_DeveCadastrarTag()
```


---

## Tag duplicada


```java
salvar_TagExistente_DeveLancarException()
```


---

## Atualizar


```java
editar_TagExistente_DeveAtualizarTag()
```


---

## Excluir


```java
remover_TagExistente_DeveExcluirTag()
```


---

# PostServiceTest


Principal regra de negócio.


---

## Criar Post


```java
salvar_PostValido_DeveCadastrarPost()
```


Validar:


- Autor existe
- Categoria existe
- Slug não existe


---

## Autor inexistente


```java
salvar_PostComAutorInexistente_DeveLancarException()
```


---

## Categoria inexistente


```java
salvar_PostComCategoriaInexistente_DeveLancarException()
```


---

## Slug duplicado


```java
salvar_PostComSlugExistente_DeveLancarException()
```


---

## Título vazio


```java
salvar_PostSemTitulo_DeveLancarValidationException()
```


---

## Buscar Post


```java
buscarPorId_PostExistente_DeveRetornarPost()
```


---

## Post inexistente


```java
buscarPorId_PostNaoEncontrado_DeveLancarException()
```


---

## Atualizar Post


```java
editar_PostExistente_DeveAtualizarDados()
```


---

## Excluir Post


```java
remover_PostExistente_DeveExcluirPost()
```


---

## Incrementar views


```java
incrementarViews_PostExistente_DeveAdicionarVisualizacao()
```


---

## Buscar populares


```java
buscarMaisVisualizados_DeveRetornarPostsOrdenadosPorViews()
```


---

## Buscar recentes


```java
buscarMaisRecentes_DeveRetornarPostsOrdenadosPorData()
```


---

# CommentServiceTest


## Criar comentário


```java
salvar_ComentarioValido_DeveCadastrarComentario()
```


---

## Email inválido


```java
salvar_ComentarioComEmailInvalido_DeveLancarException()
```


---

## Texto vazio


```java
salvar_ComentarioSemTexto_DeveLancarException()
```


---

## Post inexistente


```java
salvar_ComentarioComPostInexistente_DeveLancarException()
```


---

## Excluir comentário


```java
remover_ComentarioExistente_DeveExcluirComentario()
```


---

# LikeServiceTest


## Curtir Post


```java
curtir_PostSemLike_DeveRegistrarLike()
```


---

## Like duplicado


```java
curtir_PostComMesmoIp_DeveBloquearSegundoLike()
```


---

## Remover Like


```java
remover_LikeExistente_DeveExcluirLike()
```


---

# AuthServiceTest


## Login correto


```java
login_ComCredenciaisValidas_DeveGerarTokenJWT()
```


---

## Senha inválida


```java
login_ComSenhaInvalida_DeveLancarException()
```


---

## Usuário inexistente


```java
login_ComUsuarioInexistente_DeveLancarException()
```


---

## Refresh Token


```java
refreshToken_Valido_DeveGerarNovoAccessToken()
```


---

## Refresh Token expirado


```java
refreshToken_Expirado_DeveNegarAcesso()
```


---

# Repository Tests


Utilizar:


```java
@DataJpaTest
```


Banco:


```
H2 Database
```


---

# AuthorRepositoryTest


```java
findByEmail_EmailExistente_DeveRetornarAutor()
```


```java
existsByEmail_EmailExistente_DeveRetornarTrue()
```


```java
findByNome_NomeExistente_DeveRetornarLista()
```


---

# PostRepositoryTest


```java
findByTituloContaining_TituloExistente_DeveRetornarPosts()
```


```java
findTop10ByOrderByViewsDesc_DeveRetornarPostsPopulares()
```


```java
findTop5ByOrderByDataCriacaoDesc_DeveRetornarPostsRecentes()
```


```java
findByPublicadoTrue_DeveRetornarSomentePublicados()
```


---

# UserRepositoryTest


```java
findByEmail_EmailExistente_DeveRetornarUsuario()
```


```java
existsByEmail_EmailExistente_DeveRetornarTrue()
```


---

# Testes de Integração


Utilizar:


```java
@SpringBootTest

@AutoConfigureMockMvc

@Transactional

```


---

# AuthControllerIntegrationTest


## Login


```java
login_ComDadosValidos_DeveRetornarJWT()
```


Validar:


```
HTTP 200

accessToken

refreshToken

```


---

# AuthorControllerIntegrationTest


## POST


```java
post_AuthorValido_DeveRetornar201()
```


## GET


```java
get_AuthorExistente_DeveRetornar200()
```


## PUT


```java
put_AuthorExistente_DeveAtualizar()
```


## DELETE


```java
delete_AuthorExistente_DeveRetornar204()
```


---

# PostControllerIntegrationTest


## Criar


```java
post_PostValido_DeveRetornar201()
```


---

## Buscar


```java
get_PostExistente_DeveRetornar200()
```


---

## Atualizar


```java
put_PostExistente_DeveRetornar200()
```


---

## Excluir


```java
delete_PostExistente_DeveRetornar204()
```


---

# Validação dos Controllers


Utilizar:


```java
MockMvc
```


Validar:


```java
status()

jsonPath()

contentType()

header()
```


Exemplo:


```java
mockMvc.perform(post("/api/v1/posts"))

.andExpect(status().isCreated())

.andExpect(jsonPath("$.titulo").exists());

```


---

# Mockito Verification


Sempre validar:


```java
verify(repository).save(any());


verify(repository,times(1))

.findById(id);


verify(repository,never())

.delete(any());

```


---

# Cobertura Esperada


| Camada | Cobertura |
|-|-|
| Controller | 90% |
| Service | 100% |
| Repository | 95% |
| Security | 90% |
| DTO Validation | 90% |


---

# Total esperado de testes


Estimativa:


```
AuthorServiceTest        10 testes

CategoryServiceTest       8 testes

TagServiceTest            8 testes

PostServiceTest          15 testes

CommentServiceTest        8 testes

LikeServiceTest           6 testes

AuthServiceTest           8 testes


Repository Tests         15 testes


Integration Tests        25 testes


Total aproximado:

108 testes automatizados

```


---

# Objetivo Final


O projeto deverá possuir:


✅ API REST completa

✅ CRUD completo

✅ JWT Authentication

✅ Refresh Token

✅ Spring Security

✅ Swagger

✅ JPA/Hibernate

✅ MySQL/MariaDB/PostgreSQL

✅ H2 Test Database

✅ JUnit 5

✅ Mockito

✅ MockMvc

✅ Alta cobertura de testes
