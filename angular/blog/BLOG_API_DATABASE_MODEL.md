# Blog API REST - Modelo de Banco de Dados

## Projeto

**Blog API REST com Java + Spring Boot**

Banco compatível:

- MySQL 8.x
- MariaDB 10.x / 11.x

Características:

- InnoDB
- UTF8MB4
- Foreign Keys
- Índices
- Relacionamentos 1:N e N:N
- Compatível com Hibernate / Spring Data JPA


---

# Objetivo

Criar a estrutura de banco de dados para uma API REST de Blog.

O sistema permitirá:

- Cadastro de autores
- Cadastro de categorias
- Cadastro de posts
- Cadastro de tags
- Comentários
- Curtidas
- Relacionamento entre posts e tags


---

# Modelo de Arquitetura

```
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

# Modelo Relacional


```
AUTHOR

1 -------- N

POST


CATEGORY

1 -------- N

POST


POST

N -------- N

TAG


POST

1 -------- N

COMMENT


POST

1 -------- N

LIKE
```


---

# Estrutura dos Scripts


```
database-blog

│
├── 01-create-database.sql
├── 02-author.sql
├── 03-category.sql
├── 04-tag.sql
├── 05-post.sql
├── 06-comment.sql
├── 07-like.sql
├── 08-post-tag.sql
└── 09-inserts.sql
```


---

# Criar Banco

Arquivo:

```
01-create-database.sql
```


```sql
CREATE DATABASE IF NOT EXISTS blog_api

CHARACTER SET utf8mb4

COLLATE utf8mb4_unicode_ci;


USE blog_api;
```


---

# Tabela Author


Responsável pelos autores dos artigos.


```sql
CREATE TABLE author (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(150) NOT NULL,

    email VARCHAR(150) NOT NULL UNIQUE,

    bio TEXT,

    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    ativo BOOLEAN DEFAULT TRUE

) ENGINE=InnoDB;
```


---

# Tabela Category


Categorias dos posts.


```sql
CREATE TABLE category (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(100) NOT NULL UNIQUE,

    descricao VARCHAR(255)

) ENGINE=InnoDB;
```


---

# Tabela Tag


Tags utilizadas nos posts.


```sql
CREATE TABLE tag (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    nome VARCHAR(80) NOT NULL UNIQUE

) ENGINE=InnoDB;
```


---

# Tabela Post


Tabela principal do Blog.


```sql
CREATE TABLE post (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    titulo VARCHAR(200) NOT NULL,

    conteudo LONGTEXT NOT NULL,

    resumo VARCHAR(500),

    slug VARCHAR(250) NOT NULL UNIQUE,

    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    data_atualizacao TIMESTAMP
    DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,


    publicado BOOLEAN DEFAULT FALSE,

    views BIGINT DEFAULT 0,


    author_id BIGINT NOT NULL,

    category_id BIGINT NOT NULL,


    CONSTRAINT fk_post_author

    FOREIGN KEY(author_id)

    REFERENCES author(id)

    ON DELETE RESTRICT,


    CONSTRAINT fk_post_category

    FOREIGN KEY(category_id)

    REFERENCES category(id)

    ON DELETE RESTRICT


) ENGINE=InnoDB;
```


---

# Tabela Comment


Comentários dos usuários.


```sql
CREATE TABLE comment (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    nome VARCHAR(150) NOT NULL,

    email VARCHAR(150) NOT NULL,

    texto TEXT NOT NULL,


    data_comentario TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    post_id BIGINT NOT NULL,


    CONSTRAINT fk_comment_post

    FOREIGN KEY(post_id)

    REFERENCES post(id)

    ON DELETE CASCADE


) ENGINE=InnoDB;
```


---

# Tabela Like


Controle de curtidas.


Regra:

> O mesmo IP não pode curtir o mesmo post duas vezes.


```sql
CREATE TABLE post_like (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    ip VARCHAR(45) NOT NULL,


    data_like TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


    post_id BIGINT NOT NULL,


    CONSTRAINT uk_like_ip_post

    UNIQUE(ip, post_id),


    CONSTRAINT fk_like_post

    FOREIGN KEY(post_id)

    REFERENCES post(id)

    ON DELETE CASCADE


) ENGINE=InnoDB;
```


---

# Relacionamento Post x Tag


Relacionamento muitos para muitos.


```sql
CREATE TABLE post_tag (

    post_id BIGINT NOT NULL,

    tag_id BIGINT NOT NULL,


    PRIMARY KEY(post_id, tag_id),


    CONSTRAINT fk_post_tag_post

    FOREIGN KEY(post_id)

    REFERENCES post(id)

    ON DELETE CASCADE,


    CONSTRAINT fk_post_tag_tag

    FOREIGN KEY(tag_id)

    REFERENCES tag(id)

    ON DELETE CASCADE


) ENGINE=InnoDB;
```


---

# Índices


```sql
CREATE INDEX idx_post_titulo

ON post(titulo);



CREATE INDEX idx_post_data

ON post(data_criacao);



CREATE INDEX idx_post_views

ON post(views);



CREATE INDEX idx_post_publicado

ON post(publicado);



CREATE INDEX idx_comment_email

ON comment(email);
```


---

# Dados Iniciais


## Author


```sql
INSERT INTO author
(nome,email,bio)
VALUES

(
'João Silva',
'joao@email.com',
'Desenvolvedor Java Spring'
),

(
'Maria Souza',
'maria@email.com',
'Especialista em Banco de Dados'
);
```


---

## Category


```sql
INSERT INTO category
(nome,descricao)
VALUES

(
'Java',
'Conteúdos Java e Spring'
),

(
'Banco de Dados',
'SQL MySQL MariaDB'
),

(
'Arquitetura',
'Boas práticas de software'
);
```


---

## Tag


```sql
INSERT INTO tag(nome)

VALUES

('Spring Boot'),

('REST API'),

('JPA'),

('Hibernate'),

('JUnit');
```


---

## Post


```sql
INSERT INTO post

(
titulo,
conteudo,
resumo,
slug,
publicado,
views,
author_id,
category_id
)

VALUES

(
'Criando API REST com Spring Boot',

'Aprenda criar uma API profissional',

'API REST Java',

'api-rest-spring',

TRUE,

150,

1,

1
),


(
'Testes Unitários com Mockito',

'Aprenda Mockito e JUnit 5',

'Testes Java',

'testes-unitarios-java',

TRUE,

80,

1,

3
);
```


---

## Post Tag


```sql
INSERT INTO post_tag

(post_id,tag_id)

VALUES

(1,1),

(1,2),

(1,3),

(2,5);
```


---

## Comment


```sql
INSERT INTO comment

(nome,email,texto,post_id)

VALUES

(
'Ana',
'ana@email.com',
'Excelente artigo!',
1
),

(
'Carlos',
'carlos@email.com',
'Muito bem explicado',
1
);
```


---

## Like


```sql
INSERT INTO post_like

(ip,post_id)

VALUES

(
'192.168.0.10',
1
),

(
'192.168.0.11',
1
);
```


---

# Mapeamento JPA


Exemplo da entidade Post:


```java
@Entity
@Table(name="post")
public class Post {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
@JoinColumn(name="author_id")
private Author author;


@ManyToOne
@JoinColumn(name="category_id")
private Category category;



@ManyToMany

@JoinTable(

name="post_tag",

joinColumns =
@JoinColumn(name="post_id"),

inverseJoinColumns =
@JoinColumn(name="tag_id")

)

private List<Tag> tags;



@OneToMany(

mappedBy="post",

cascade=CascadeType.ALL

)

private List<Comment> comments;


}
```


---

# Próximas Etapas


## Backend

Criar:

```
entity

repository

service

dto

controller

exception
```


---

## Testes Unitários


Tecnologias:

- JUnit 5
- Mockito


Testar:

- Cadastro
- Alteração
- Exclusão
- Validações
- Regras de negócio


---

## Testes de Integração


Tecnologias:

- Spring Boot Test
- MockMvc
- H2


Testar:

- Endpoints REST
- JSON
- Status HTTP
- Persistência


---

# Evolução do Projeto


Adicionar futuramente:


- JWT Authentication
- Spring Security
- Swagger OpenAPI
- Docker
- PostgreSQL
- Cache Redis
- Upload de imagens
- Paginação
- Filtros avançados
- GitHub Actions


---

# Resultado Esperado


Projeto completo utilizando:

- Java 25
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL/MariaDB
- DTO Pattern
- Service Layer
- Repository Pattern
- JUnit 5
- Mockito
- Testes de Integração
- Boas práticas de arquitetura