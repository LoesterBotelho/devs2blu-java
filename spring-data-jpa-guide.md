## 📚 Documentações e Links Úteis Oficiais
Para aprofundar ainda mais seus conhecimentos direto das fontes oficiais, consulte:
- [Documentação Oficial do Java 17 API](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
- [Referência Oficial do Spring Framework](https://docs.spring.io/spring-framework/reference/index.html)
- [Javadoc do Spring Stereotype Packages](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/package-summary.html)

Feito com ☕ e dedicação para facilitar seus estudos em Spring Framework!

# Guia Prático: Spring Data JPA, Anotações e Relacionamentos 🗄️

Bem-vindo ao guia definitivo sobre persistência de dados no Spring Boot! Este documento cobre tudo o que você precisa para mapear tabelas, configurar colunas rigorosamente (`not null`, tamanhos, tipos) e estruturar relacionamentos complexos (`1:1`, `N:1`, `1:N`, `N:N`) para APIs REST profissionais.

---

## 📑 Sumário
1. [Configuração de Tabelas e Colunas (`@Entity`, `@Table`, `@Column`)](#1-configuração-de-tabelas-e-colunas)
2. [Tipos de Dados em Java vs SQL](#2-tipos-de-dados-em-java-vs-sql)
3. [Chaves Primárias e IDs (`@Id`, `@GeneratedValue`)](#3-chaves-primárias-e-ids)
4. [Mapeamento de Relacionamentos](#4-mapeamento-de-relacionamentos)
   - [N:1 (Muitos para Um) e 1:N (Um para Muitos)](#n1-muitos-para-um-e-1n-um-para-muitos)
   - [1:1 (Um para Um)](#11-um-para-um)
   - [N:N (Muitos para Muitos)](#nn-muitos-para-muitos)
5. [Validação de Dados de Entrada (`Bean Validation`)](#5-validação-de-dados-de-entrada)
6. [Exemplo Completo Prático Integrado](#6-exemplo-completo-prático-integrado)

---

## 1. Configuração de Tabelas e Colunas

### `@Entity`
* **O que faz:** Informa ao Spring que a classe Java é uma entidade de banco de dados e deve ser mapeada pelo Hibernate.
* **Analogia:** É a planta oficial registrada em cartório de que aquele objeto é um imóvel real na cidade.
* **Exemplo:**
```java
@Entity
@Table(name = "tb_cliente")
public class Cliente { ... }
```

### `@Table`
* **O que faz:** Personaliza o nome da tabela no banco de dados e restrições de unicidade (constraints).
* **Analogia:** É a placa na porta da sala que diz exatamente o nome do departamento.
* **Exemplo:**
```java
@Table(name = "tb_cliente", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
```

### `@Column`
* **O que faz:** Define as regras da coluna na tabela física: nome, tamanho (`length`), se pode ser nulo (`nullable`), se é único (`unique`) e precisão decimal.
* **Analogia:** É a ficha técnica de um formulário impresso que diz: "este campo aceita no máximo 100 letras e é de preenchimento obrigatório".
* **Atributos Principais:**
  * `name`: Nome da coluna no banco (ex: `ds_email`).
  * `nullable = false`: Equivalente ao `NOT NULL` do SQL.
  * `length = 150`: Tamanho máximo para strings (ex: `VARCHAR(150)`).
  * `unique = true`: Garante que não haverá valores duplicados.
  * `precision` / `scale`: Usados em números decimais/monetários (ex: `precision = 10, scale = 2` para valores até 99.999.999,99).

---

## 2. Tipos de Dados em Java vs SQL

Quando mapeamos entidades, escolhemos os tipos Java que melhor se traduzem para o banco de dados:

| Tipo Java | Tipo SQL Gerado (Comum) | Uso Ideal |
| :--- | :--- | :--- |
| `String` | `VARCHAR(length)` | Nomes, e-mails, descrições, códigos |
| `Long` / `Integer` | `BIGINT` / `INT` | IDs numéricos, quantidades, idades |
| `BigDecimal` | `DECIMAL(p, s)` | Valores monetários e preços (evita erros de arredondamento de float/double) |
| `LocalDate` | `DATE` | Datas puras (Aniversários, Data de emissão) |
| `LocalDateTime` | `TIMESTAMP` / `DATETIME` | Data e hora completas (Criação de registros, logs) |
| `Boolean` | `BOOLEAN` / `TINYINT` | Flags de status (Ativo/Inativo, Sim/Não) |

---

## 3. Chaves Primárias e IDs

### `@Id` e `@GeneratedValue`
* **O que faz:** Define o atributo identificador único da tabela e como o banco deve gerenciar a sua numeração automática (Auto Increment).
* **Analogia:** O número do RG ou CPF emitido sequencialmente de forma automática a cada novo cidadão cadastrado.
* **Exemplo:**
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento do banco (SERIAL / IDENTITY)
private Long id;
```

---

## 4. Mapeamento de Relacionamentos

### Relacionamento N:1 (Muitos para Um) e 1:N (Um para Muitos)
* **Contexto:** É o relacionamento mais comum. Por exemplo: *Muitos pedidos pertencem a 1 único cliente* (`N:1` no lado do Pedido) e *1 cliente possui vários pedidos* (`1:N` no lado do Cliente).
* **Anotações:** `@ManyToOne`, `@JoinColumn`, `@OneToMany`.
* **Exemplo (Lado N:1 - Pedido):**
```java
@ManyToOne
@JoinColumn(name = "id_cliente_fk", nullable = false) // Cria a FK na tabela tb_pedido
private Cliente cliente;
```
* **Exemplo (Lado 1:N - Cliente):**
```java
@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
private List<Pedido> pedidos;
```

### Relacionamento 1:1 (Um para Um)
* **Contexto:** Cada registro de uma tabela possui exatamente um único registro correspondente em outra. Exemplo: *Um Usuário tem apenas um Perfil de Acesso*.
* **Anotações:** `@OneToOne`, `@JoinColumn`.
* **Exemplo:**
```java
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "id_perfil_fk", referencedColumnName = "id", nullable = false)
private Perfil perfil;
```

### Relacionamento N:N (Muitos para Muitos)
* **Contexto:** Vários registros de uma tabela se ligam a vários registros de outra. Exemplo: *Um Aluno pode estar matriculado em vários Cursos, e um Curso possui vários Alunos*.
* **Anotações:** `@ManyToMany`, `@JoinTable`.
* **Exemplo:**
```java
@ManyToMany
@JoinTable(
    name = "tb_aluno_curso", // Tabela intermediária de junção
    joinColumns = @JoinColumn(name = "id_aluno"),
    inverseJoinColumns = @JoinColumn(name = "id_curso")
)
private List<Curso> cursos;
```

---

## 5. Validação de Dados de Entrada (`Bean Validation`)
Para garantir que a API receba dados íntegros antes mesmo de salvar no banco, combinamos anotações de validação (`jakarta.validation`):
* `@NotNull`: Não pode ser nulo.
* `@NotBlank`: Não pode ser nulo nem vazio (para strings).
* `@Size(min = X, max = Y)`: Define limites de caracteres.
* `@Email`: Valida formato correto de e-mail.
* `@Positive`: Garante números maiores que zero.

---

## 6. Exemplo Completo Prático Integrado

Abaixo, um modelo robusto de uma API voltada para gerenciamento de Produtos e Categorias com tipagem rigorosa, colunas customizadas e validações:

```java
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_produto", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sku_produto"})
})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // SKU único, obrigatório, máximo 30 caracteres
    @NotBlank(message = "O SKU é obrigatório")
    @Size(max = 30, message = "O SKU deve ter no máximo 30 caracteres")
    @Column(name = "sku_produto", length = 30, nullable = false, unique = true)
    private String sku;

    // Nome do produto, obrigatório, máximo 120 caracteres
    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(min = 3, max = 120, message = "O nome deve ter entre 3 e 120 caracteres")
    @Column(name = "ds_nome", length = 120, nullable = false)
    private String nome;

    // Preço decimal monetário exato (Até 10 dígitos, sendo 2 casas decimais)
    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    @Column(name = "vl_preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    // Data de cadastro automática
    @Column(name = "dt_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    // Relacionamento N:1 (Muitos produtos pertencem a uma Categoria)
    @NotNull(message = "A categoria é obrigatória")
    @ManyToOne
    @JoinColumn(name = "id_categoria_fk", nullable = false)
    private Categoria categoria;
}
```

---
Feito para impulsionar a construção de APIs robustas com Spring Data JPA! 🚀
