# Documento de Requisitos
# Blog API REST

## 1. Introdução

## 1.1 Objetivo do Projeto

Desenvolver uma API REST completa para gerenciamento de um Blog, permitindo o cadastro, gerenciamento e consulta de conteúdos publicados.

A aplicação deverá possuir:

- Gerenciamento de usuários
- Controle de autenticação e autorização
- Gerenciamento de autores
- Gerenciamento de categorias
- Gerenciamento de posts
- Gerenciamento de tags
- Gerenciamento de comentários
- Gerenciamento de curtidas
- Segurança utilizando JWT
- Documentação com Swagger
- Testes automatizados


---

# 2. Escopo do Sistema


O sistema deverá permitir que usuários autenticados possam criar e gerenciar conteúdos.

Usuários visitantes poderão consultar conteúdos públicos.


O sistema será dividido nos módulos:


```
Autenticação

Usuários

Autores

Categorias

Posts

Tags

Comentários

Likes

Relatórios

Administração

```


---

# 3. Perfis de Usuários


## 3.1 Visitante (PUBLIC)


Usuário sem autenticação.


Permissões:


- Visualizar posts publicados
- Pesquisar posts
- Visualizar categorias
- Visualizar autores
- Visualizar tags
- Visualizar comentários


---

## 3.2 USER


Usuário autenticado.


Permissões:


- Realizar login
- Atualizar dados pessoais
- Comentar posts
- Curtir posts
- Remover seus comentários


---

## 3.3 AUTHOR


Autor de conteúdos.


Permissões:


- Criar posts
- Editar seus posts
- Excluir seus posts
- Publicar conteúdos
- Gerenciar tags dos seus posts


---

## 3.4 ADMIN


Administrador do sistema.


Permissões:


- Gerenciar usuários
- Gerenciar autores
- Gerenciar categorias
- Gerenciar tags
- Gerenciar posts
- Remover comentários
- Controlar permissões


---

# 4. Requisitos Funcionais


# RF01 - Cadastro de Usuários


O sistema deverá permitir o cadastro de usuários.


Dados obrigatórios:


- Nome
- Email
- Senha
- Perfil de acesso


Regras:


- Email deve ser único
- Senha deve ser armazenada criptografada
- Usuário deve possuir uma role


---

# RF02 - Autenticação de Usuários


O sistema deverá permitir login através de email e senha.


Entrada:


```
email

senha
```


Saída:


```
accessToken JWT

refreshToken

tempo de expiração

```


---

# RF03 - Renovação de Token


O sistema deverá permitir renovar o JWT através do Refresh Token.


Regras:


- Refresh Token válido deve gerar novo Access Token
- Refresh Token expirado deve ser invalidado


---

# RF04 - Logout


O sistema deverá permitir logout.


Ao sair:


- Refresh Token deverá ser invalidado
- Sessão deverá ser encerrada


---

# RF05 - Gerenciamento de Autores


O sistema deverá permitir CRUD completo de autores.


Operações:


- Cadastrar autor
- Consultar autores
- Buscar autor por ID
- Atualizar autor
- Remover autor


Regras:


- Email não pode duplicar
- Autor inativo não pode publicar novos posts


---

# RF06 - Gerenciamento de Categorias


O sistema deverá permitir CRUD completo de categorias.


Operações:


- Criar categoria
- Listar categorias
- Buscar categoria
- Editar categoria
- Excluir categoria


Regras:


- Nome da categoria deve ser único
- Categoria utilizada por posts não deve ser removida


---

# RF07 - Gerenciamento de Tags


O sistema deverá permitir CRUD completo de tags.


Operações:


- Criar tag
- Listar tags
- Editar tag
- Excluir tag


Regras:


- Nome da tag único


---

# RF08 - Gerenciamento de Posts


O sistema deverá permitir criar e gerenciar posts.


Dados:


- Título
- Conteúdo
- Resumo
- Slug
- Categoria
- Autor
- Tags
- Status de publicação


Operações:


- Criar post
- Buscar post
- Listar posts
- Atualizar post
- Excluir post


---

# RF09 - Publicação de Posts


O sistema deverá permitir controlar o status do post.


Status:


```
RASCUNHO

PUBLICADO

```


Regras:


- Apenas posts publicados aparecem para visitantes
- Autor pode salvar rascunhos


---

# RF10 - Consulta de Posts


O sistema deverá permitir consultas:


Por:


- ID
- Título
- Categoria
- Autor
- Tag
- Data
- Popularidade


---

# RF11 - Paginação


O sistema deverá permitir paginação.


Exemplo:


```
GET /api/v1/posts?page=0&size=10
```


---

# RF12 - Ordenação


O sistema deverá permitir ordenar resultados.


Campos:


- Título
- Data criação
- Views


Exemplo:


```
sort=dataCriacao,desc
```


---

# RF13 - Pesquisa


O sistema deverá permitir pesquisar posts.


Filtros:


- Palavra-chave
- Categoria
- Autor
- Status


---

# RF14 - Controle de Visualizações


O sistema deverá contabilizar acessos aos posts.


Cada visualização deverá:


- Incrementar contador
- Registrar quantidade de acessos


---

# RF15 - Comentários


O sistema deverá permitir comentários.


Operações:


- Criar comentário
- Listar comentários
- Buscar comentários por post
- Excluir comentário


Regras:


- Texto obrigatório
- Email válido


---

# RF16 - Curtidas


O sistema deverá permitir usuários curtirem posts.


Regras:


- Mesmo IP não pode curtir duas vezes
- Like deve ser associado ao post


---

# RF17 - Upload de Imagem


O sistema deverá permitir associar imagem ao post.


Informações:


- Nome arquivo
- Caminho
- Tipo
- Data upload


---

# RF18 - Documentação da API


O sistema deverá disponibilizar documentação Swagger.


Deverá apresentar:


- Endpoints
- Modelos
- Parâmetros
- Respostas
- Autorização JWT


---

# RF19 - Tratamento de Erros


O sistema deverá possuir tratamento global de exceções.


Erros:


- Dados inválidos
- Registro inexistente
- Email duplicado
- Permissão negada


---

# RF20 - Auditoria


O sistema deverá registrar:


- Data criação
- Data alteração
- Usuário responsável


---

# 5. Requisitos Não Funcionais


# RNF01 - Arquitetura


O sistema deverá utilizar arquitetura em camadas.


Camadas:


```
Controller

Service

Repository

Entity

Database

```


---

# RNF02 - Tecnologia


A aplicação deverá utilizar:


Backend:


- Java 25
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Security


---

# RNF03 - Banco de Dados


A aplicação deverá suportar:


Produção:


- MySQL 8
- MariaDB
- PostgreSQL


Testes:


- H2 Database


---

# RNF04 - Segurança


A aplicação deverá:


- Utilizar HTTPS em produção
- Utilizar JWT
- Criptografar senhas com BCrypt
- Controlar acesso por roles
- Validar permissões


---

# RNF05 - Performance


A API deverá:


- Suportar paginação
- Utilizar índices no banco
- Evitar consultas desnecessárias
- Utilizar Lazy Loading corretamente


---

# RNF06 - Disponibilidade


A aplicação deverá possuir:


- Tratamento de exceções
- Logs
- Monitoramento
- Recuperação de erros


---

# RNF07 - Manutenibilidade


O código deverá possuir:


- Padrão Clean Code
- SOLID
- Código organizado
- Baixo acoplamento


---

# RNF08 - Testabilidade


A aplicação deverá possuir:


Testes:


- Unitários
- Integração
- Repository
- Controller


Ferramentas:


- JUnit 5
- Mockito
- MockMvc


---

# RNF09 - Cobertura de Testes


Meta:


```
Services: 100%

Repositories: 95%

Controllers: 90%

```


---

# RNF10 - Documentação


O projeto deverá possuir:


- README.md
- Swagger
- Documentação dos endpoints
- Modelo do banco
- Diagrama ER


---

# RNF11 - Versionamento


A API deverá utilizar versionamento:


Exemplo:


```
/api/v1

/api/v2

```


---

# RNF12 - Logs


A aplicação deverá registrar:


- Erros
- Login
- Falhas de autenticação
- Operações importantes


---

# RNF13 - Deploy


O projeto deverá permitir:


- Docker
- Docker Compose
- CI/CD
- GitHub Actions


---

# RNF14 - Qualidade


O projeto deverá seguir:


- Boas práticas Java
- Padrões REST
- Princípios SOLID
- Separação de responsabilidades


---

# 6. Critérios de Aceitação


O projeto será considerado concluído quando:


## Backend


✅ CRUD completo funcionando

✅ JWT funcionando

✅ Refresh Token funcionando

✅ Spring Security configurado

✅ Swagger disponível

✅ Banco persistindo dados


## Testes


✅ Testes unitários

✅ Mockito configurado

✅ Testes integração

✅ H2 funcionando

✅ Cobertura mínima atingida


## Documentação


✅ README completo

✅ API documentada

✅ Modelo ER criado


---

# Resultado Esperado


Ao final do projeto será entregue uma API REST profissional utilizando:


- Java 25
- Spring Boot
- Spring Security
- JWT
- Refresh Token
- JPA/Hibernate
- MySQL/MariaDB/PostgreSQL
- JUnit 5
- Mockito
- Swagger
- Docker
- CI/CD


Projeto equivalente a uma aplicação Backend Java utilizada em ambiente corporativo.