# Guia Abrangente e Definitivo de Arquitetura de APIs RESTful & HATEOAS

Um manual técnico completo com conceitos, teoria da arquitetura REST, Modelo de Maturidade de Richardson, especificação HATEOAS, implementação prática com Spring Boot / Java 25, boas práticas, tratamento de erros e checklist para produção.

---

## Sumário

- [1. Introdução ao REST](#1-introdução-ao-rest)
- [2. O que é REST](#2-o-que-é-rest)
- [3. Princípios REST](#3-princípios-rest)
- [4. Recursos (Resources)](#4-recursos-resources)
- [5. URI x URL x URN x Endpoint](#5-uri-x-url-x-urn-x-endpoint)
- [6. Métodos HTTP](#6-métodos-http)
  - [GET](#get)
  - [POST](#post)
  - [PUT](#put)
  - [PATCH](#patch)
  - [DELETE](#delete)
  - [OPTIONS](#options)
  - [HEAD](#head)
- [7. Idempotência](#7-idempotência)
- [8. Segurança (Safe Methods)](#8-segurança-safe-methods)
- [9. Status HTTP](#9-status-http)
  - [1xx - Informativos](#1xx---informativos)
  - [2xx - Sucesso](#2xx---sucesso)
  - [3xx - Redirecionamento](#3xx---redirecionamento)
  - [4xx - Erros do Cliente](#4xx---erros-do-cliente)
  - [5xx - Erros do Servidor](#5xx---erros-do-servidor)
- [10. Richardson Maturity Model (RMM)](#10-richardson-maturity-model-rmm)
  - [Nível 0: The Swamp of POX](#nível-0---the-swamp-of-pox)
  - [Nível 1: Resources](#nível-1---resources)
  - [Nível 2: HTTP Verbs & Status Codes](#nível-2---http-verbs--status-codes)
  - [Nível 3: HATEOAS](#nível-3---hateoas)
- [11. HATEOAS](#11-hateoas)
- [12. Exemplos sem HATEOAS](#12-exemplos-sem-hateoas)
- [13. Exemplos com HATEOAS](#13-exemplos-com-hateoas)
- [14. Fluxo de Navegação](#14-fluxo-de-navegação)
- [15. Mudança de Links Conforme o Estado](#15-mudança-de-links-conforme-o-estado)
- [16. Spring Boot + Spring HATEOAS](#16-spring-boot--spring-hateoas)
- [17. Exemplo Completo de Controller e Camadas (Java 25)](#17-exemplo-completo-de-controller-e-camadas-java-25)
- [18. Exemplo Completo de JSON (HAL Standard)](#18-exemplo-completo-de-json-hal-standard)
- [19. Vantagens](#19-vantagens)
- [20. Desvantagens](#20-desvantagens)
- [21. Quando Utilizar](#21-quando-utilizar)
- [22. Boas Práticas REST](#22-boas-práticas-rest)
- [23. Convenções de URLs](#23-convenções-de-urls)
- [24. Convenções de Status HTTP](#24-convenções-de-status-http)
- [25. Checklist para Criar APIs REST](#25-checklist-para-criar-apis-rest)
- [26. Conclusão](#26-conclusão)

---

## 1. Introdução ao REST

Na era da computação distribuída, microsserviços e integração contínua de software, a forma como os sistemas trocam dados determina a escalabilidade, resiliência e facilidade de manutenção de toda uma infraestrutura.

Antes do surgimento do REST, a integração entre sistemas heterogêneos apoiava-se majoritariamente em especificações RPC (*Remote Procedure Call*) rígidas, como **SOAP** (*Simple Object Access Protocol*) e **XML-RPC**. Essas arquiteturas exigiam esquemas contratuais complexos (arquivos WSDL), possuíam payloads pesados em XML e tratavam o protocolo HTTP apenas como um "túnel" cego para enviar requisições.

A evolução da Web demandava um modelo mais simples, desacoplado, leve e que aproveitasse as características intrínsecas e nativas do protocolo HTTP. Foi nesse contexto que o conceito de REST foi formalizado.

---

## 2. O que é REST

**REST** é a sigla para **Representational State Transfer** (Transferência de Estado Representacional). 

Trata-se de um **estilo arquitetural** — e não de um protocolo, linguagem ou ferramenta — apresentado em 2000 por **Roy Fielding** em sua tese de doutorado na *University of California, Irvine* (*"Architectural Styles and the Design of Network-based Software Architectures"*). Fielding foi também um dos principais coautores das especificações fundamentais da Web moderna: HTTP e URI.

### A Ideia Central do REST:
- A aplicação é vista como uma coleção de **Recursos**.
- O cliente interage com a aplicação transferindo **Representações** desses recursos (JSON, XML, HTML).
- O cliente avança no fluxo da aplicação ao acionar links e ações que provocam a **Mudança de Estado** do recurso.

---

## 3. Princípios REST

Para que um sistema seja considerado **RESTful** (ou seja, aderente ao estilo REST), ele precisa cumprir **6 restrições arquiteturais**:

```
┌─────────────────────────────────────────────────────────────────┐
│                     REST ARCHITECTURAL CONSTRAINTS              │
├─────────────────────────────────────────────────────────────────┤
│ 1. Cliente-Servidor (Client-Server)                             │
│ 2. Sem Estado (Stateless)                                       │
│ 3. Cache (Cacheable)                                            │
│ 4. Interface Uniforme (Uniform Interface)                       │
│ 5. Sistema em Camadas (Layered System)                           │
│ 6. Código sob Demanda (Code on Demand - Opcional)               │
└─────────────────────────────────────────────────────────────────┘
```

1. **Cliente-Servidor:** Separação clara entre a interface e experiência do usuário (Cliente) e a persistência/regras de negócio (Servidor). Permite que ambos evoluam de forma independente.
2. **Sem Estado (Stateless):** O servidor não armazena nenhuma sessão de contexto do cliente entre as chamadas. Todas as requisições devem ser auto-suficientes e conter todos os dados necessários (incluindo credenciais/tokens) para serem processadas.
3. **Cache:** As respostas do servidor devem explicitar se podem ou não ser armazenadas em cache pelo cliente ou intermediários, reduzindo a carga do servidor e melhorando o tempo de resposta.
4. **Interface Uniforme:** O pilar do desacoplamento REST. Exige a identificação de recursos por URIs, a manipulação via representações, mensagens autoexplicativas e o uso de hipermídia (HATEOAS).
5. **Sistema em Camadas:** O cliente não precisa saber se está conectado diretamente ao servidor final ou a intermediários (Proxies, Load Balancers, API Gateways, Firewalls).
6. **Código sob Demanda (Opcional):** Permite que o servidor envie trechos de código executável para o cliente (ex.: scripts JavaScript).

---

## 4. Recursos (Resources)

O **Recurso** é o conceito fundamental da abstração RESTful. É qualquer elemento, informação ou entidade de negócio que possa ser nomeado e manipulado.

- **Exemplos de Recursos:**
  - *Entidades do Negócio:* `Cliente`, `ContaBancaria`, `Produto`, `Pedido`.
  - *Coleções:* `Lista de Clientes`, `Histórico de Transações`.
  - *Processos / Computações:* `Relatório Mensal`, `Processo de Fechamento`.

É essencial diferenciar o **Recurso** da sua **Representação**:
- O recurso `Pedido #100` é um registro conceitual no banco de dados.
- Ele pode ser representado em JSON para um aplicativo mobile, em XML para um sistema legado ou em PDF/HTML para exibição web.

---

## 5. URI x URL x URN x Endpoint

```
                         URI (Uniform Resource Identifier)
      ┌──────────────────────────────────┴──────────────────────────────────┐
      │                                                                     │
    URL (Uniform Resource Locator)                        URN (Uniform Resource Name)
    Identifica ONDE e COMO acessar                         Identifica pelo NOME em um namespace
    Ex: https://api.loja.com/v1/pedidos/10                Ex: urn:isbn:978-0-13-468599-1
```

- **URI:** O termo guarda-chuva para todos os identificadores de recursos.
- **URL:** Uma URI que inclui a localização na rede e o protocolo necessário para acesso (`https://...`).
- **URN:** Uma URI que identifica o recurso sem dizer como ou onde encontrá-lo.
- **Endpoint:** É a combinação exata de uma URL com um Método HTTP no servidor (Ex.: `POST /v1/pedidos`).

---

## 6. Métodos HTTP

Os métodos HTTP (ou verbos) definem a intenção semântica da operação sobre o recurso.

### GET
Recupera uma representação do recurso. Não deve possuir corpo na requisição nem alterar dados no servidor.

### POST
Submete uma representação para criação de um novo recurso no servidor ou para acionar um processamento genérico.

### PUT
Substitui completamente o recurso na URI informada pelos dados enviados no corpo da requisição.

### PATCH
Aplica modificações parciais a um recurso existente, alterando apenas os campos explicitamente enviados.

### DELETE
Remove o recurso localizado na URI especificada.

### OPTIONS
Retorna os métodos HTTP suportados e autorizados para a URI em questão. Utilizado amplamente em validações de CORS (*Preflight Requests*).

### HEAD
Idêntico ao GET, contudo o servidor responde apenas com os cabeçalhos HTTP, omitindo o corpo da resposta. Útil para verificar existência ou metadados de arquivos pesados.

---

## 7. Idempotência

Uma operação é considerada **idempotente** quando realizar **uma única requisição** ou **N requisições idênticas consecutivas** produz exatamente o mesmo resultado e estado final no servidor.

| Método | Idempotente? | Comentário |
| :--- | :---: | :--- |
| **GET** | **SIM** | Apenas consulta dados sem alterar estado. |
| **POST** | **NÃO** | Chamar `POST /pedidos` 3 vezes cria 3 pedidos distintos. |
| **PUT** | **SIM** | Sobrescrever o recurso com o mesmo payload N vezes deixa o estado idêntico ao da primeira vez. |
| **PATCH** | **NÃO/SIM** | Se for `incrementarSaldo +10`, não é. Se for `alterarNome = 'Ana'`, é. |
| **DELETE** | **SIM** | Deletar o recurso na 1ª vez o remove; nas subsequentes ele continua inexistente. |
| **HEAD / OPTIONS** | **SIM** | Somente leitura de cabeçalhos/opções. |

---

## 8. Segurança (Safe Methods)

Métodos **Seguros** (*Safe Methods*) são aqueles que **não provocam alterações de estado no servidor**. São exclusivamente destinados à leitura.

- **Métodos Seguros:** `GET`, `HEAD`, `OPTIONS`.
- **Métodos Não Seguros:** `POST`, `PUT`, `PATCH`, `DELETE`.

---

## 9. Status HTTP

Os códigos de status HTTP informam a resposta da requisição divididos em 5 famílias principais:

### 1xx - Informativos
- `100 Continue`: Servidor aceitou o início do request e o cliente pode prosseguir enviando o body.

### 2xx - Sucesso
- `200 OK`: Requisição processada com sucesso.
- `201 Created`: Recurso criado com sucesso. Retorna o header `Location`.
- `202 Accepted`: Requisição aceita para processamento assíncrono (em fila).
- `204 No Content`: Operação concluída com sucesso sem dados no corpo da resposta (comum para `DELETE` ou `PUT`).

### 3xx - Redirecionamento
- `301 Moved Permanently`: URI mudou permanentemente.
- `304 Not Modified`: O recurso não sofreu alterações desde o último acesso (uso de cache via `ETag`).

### 4xx - Erros do Cliente
- `400 Bad Request`: Erro de sintaxe, JSON malformado ou campos inválidos.
- `401 Unauthorized`: Requer autenticação (token ausente ou expirado).
- `403 Forbidden`: Cliente autenticado mas sem permissão de acesso ao recurso.
- `404 Not Found`: Recurso não localizado.
- `405 Method Not Allowed`: Verbo HTTP não suportado nesta URI.
- `409 Conflict`: Conflito de estado (ex.: e-mail/CPF já cadastrado).
- `422 Unprocessable Entity`: Erro de regra de negócio.

### 5xx - Erros do Servidor
- `500 Internal Server Error`: Exceção ou falha não tratada no backend.
- `502 Bad Gateway`: Servidor recebeu uma resposta inválida de um gateway superior.
- `503 Service Unavailable`: Servidor indisponível temporariamente por sobrecarga ou manutenção.
- `504 Gateway Timeout`: Servidor intermediário estourou o tempo de espera.

---

## 10. Richardson Maturity Model (RMM)

Criado por Leonard Richardson, este modelo classifica o grau de conformidade de uma API web em relação às restrições do estilo REST.

```
                    ┌──────────────────────────────────────────────┐
                    │     Nível 3: HATEOAS (Navegação Dinâmica)    │
                    ├──────────────────────────────────────────────┤
                    │     Nível 2: Verbos HTTP + Status Codes      │
                    ├──────────────────────────────────────────────┤
                    │     Nível 1: Recursos (URIs Únicas)          │
                    ├──────────────────────────────────────────────┤
                    │     Nível 0: HTTP como Túnel RPC (POX)       │
                    └──────────────────────────────────────────────┘
```

### Nível 0 - The Swamp of POX
Usa o HTTP apenas como meio de transporte RPC. Possui um único endpoint genérico e utiliza apenas o método `POST`.
```http
POST /apiService HTTP/1.1
{ "action": "findCustomer", "id": 10 }
```

### Nível 1 - Resources
Identifica recursos individualizados via URIs distintas, porém utiliza os métodos HTTP incorretamente (ex.: tudo via `POST`).
```http
POST /clientes/consultar/10 HTTP/1.1
POST /clientes/deletar/10 HTTP/1.1
```

### Nível 2 - HTTP Verbs & Status Codes
O padrão mais comum da indústria. Utiliza URIs corretas, combina verbos HTTP semânticos e responde com os códigos de status adequados.
```http
GET /clientes/10 HTTP/1.1       ──► 200 OK
DELETE /clientes/10 HTTP/1.1    ──► 204 No Content
```

### Nível 3 - HATEOAS
Conformidade plena com o REST. O servidor fornece juntamente com os dados do recurso os links de hipermídia contendo as próximas ações e rotas possíveis.

---

## 11. HATEOAS

**HATEOAS** (*Hypermedia As The Engine Of Application State*) é a restrição que torna a API autodescritiva. Em vez de hardcodear as rotas na aplicação frontend, o cliente descobre dinamicamente como interagir com a aplicação ao interpretar os links hipertexto fornecidos nas respostas.

---

## 12. Exemplos sem HATEOAS

Resposta padrão Nível 2 para um pedido:

```json
{
  "id": 500,
  "status": "APROVADO",
  "valorTotal": 450.00,
  "clienteId": 42
}
```

*Problema:* O cliente precisa consultar uma documentação externa (ex.: Swagger) para descobrir qual endpoint chamar para cancelar ou rastrear este pedido.

---

## 13. Exemplos com HATEOAS

Resposta equivalente em conformidade com o padrão **HAL** (*JSON Hypertext Application Language*):

```json
{
  "id": 500,
  "status": "APROVADO",
  "valorTotal": 450.00,
  "_links": {
    "self": {
      "href": "https://api.empresa.com/v1/pedidos/500"
    },
    "cancelar": {
      "href": "https://api.empresa.com/v1/pedidos/500/cancelamento"
    },
    "rastreio": {
      "href": "https://api.empresa.com/v1/pedidos/500/entrega"
    },
    "cliente": {
      "href": "https://api.empresa.com/v1/clientes/42"
    }
  }
}
```

---

## 14. Fluxo de Navegação

A aplicação cliente navega entre os estados consumindo e seguindo os relacionamentos (`rel`) declarados no bloco `_links`.

```
                  ┌───────────────────────────────┐
                  │ GET /v1/pedidos/500           │
                  └──────────────┬────────────────┘
                                 │
                 ┌───────────────┴───────────────┐
                 ▼                               ▼
  ┌──────────────────────────────┐ ┌──────────────────────────────┐
  │  rel: "cliente"              │ │  rel: "cancelar"             │
  │  GET /v1/clientes/42         │ │  POST /v1/pedidos/500/cancel │
  └──────────────────────────────┘ └──────────────────────────────┘
```

---

## 15. Mudança de Links Conforme o Estado

Os links retornados variam dinamicamente conforme as regras de negócio e o estado atual do recurso no servidor.

### Pedido com Status `PENDENTE_PAGAMENTO`:
```json
{
  "id": 500,
  "status": "PENDENTE_PAGAMENTO",
  "_links": {
    "self": { "href": "/v1/pedidos/500" },
    "pagar": { "href": "/v1/pedidos/500/pagamento" },
    "cancelar": { "href": "/v1/pedidos/500/cancelar" }
  }
}
```

### Pedido com Status `ENVIADO` (Após Processamento):
```json
{
  "id": 500,
  "status": "ENVIADO",
  "_links": {
    "self": { "href": "/v1/pedidos/500" },
    "rastrear": { "href": "/v1/pedidos/500/rastreamento" },
    "segundaViaNota": { "href": "/v1/pedidos/500/notafiscal" }
  }
}
```
*Note que as ações `pagar` e `cancelar` foram removidas automaticamente pelo backend por não serem mais permitidas.*

---

## 16. Spring Boot + Spring HATEOAS

No ecossistema Java, o projeto **Spring HATEOAS** faz a gestão e geração simplificada de modelos com suporte ao padrão HAL.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```

---

## 17. Exemplo Completo de Controller e Camadas (Java 25)

### 1. Entidade de Domínio (`Cliente.java`)
```java
package com.exemplo.api.domain;

public class Cliente {
    private Long id;
    private String nome;
    private String email;

    public Cliente() {}

    public Cliente(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

### 2. DTO de Requisição (`ClienteDTO.java`)
```java
package com.exemplo.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(
    @NotBlank(message = "O nome não pode estar em branco")
    String nome,

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    String email
) {}
```

### 3. Controller HATEOAS (`ClienteController.java`)
```java
package com.exemplo.api.controller;

import com.exemplo.api.domain.Cliente;
import com.exemplo.api.dto.ClienteDTO;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    private static final List<Cliente> REPOSITORIO = new ArrayList<>(List.of(
            new Cliente(1L, "Carlos Eduardo", "carlos@email.com"),
            new Cliente(2L, "Fernanda Lima", "fernanda@email.com")
    ));

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> buscarPorId(@PathVariable Long id) {
        Cliente cliente = REPOSITORIO.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado para o ID: " + id));

        EntityModel<Cliente> model = EntityModel.of(cliente);

        model.add(linkTo(methodOn(ClienteController.class).buscarPorId(id)).withSelfRel());
        model.add(linkTo(methodOn(ClienteController.class).atualizar(id, null)).withRel("atualizar"));
        model.add(linkTo(methodOn(ClienteController.class).excluir(id)).withRel("excluir"));
        model.add(linkTo(methodOn(ClienteController.class).listarTodos()).withRel("listar-todos"));

        return ResponseEntity.ok(model);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Cliente>>> listarTodos() {
        List<EntityModel<Cliente>> lista = REPOSITORIO.stream()
                .map(c -> EntityModel.of(c,
                        linkTo(methodOn(ClienteController.class).buscarPorId(c.getId())).withSelfRel()
                ))
                .toList();

        CollectionModel<EntityModel<Cliente>> collection = CollectionModel.of(lista);
        collection.add(linkTo(methodOn(ClienteController.class).listarTodos()).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Cliente>> criar(@Valid @RequestBody ClienteDTO dto) {
        Long novoId = (long) (REPOSITORIO.size() + 1);
        Cliente cliente = new Cliente(novoId, dto.nome(), dto.email());
        REPOSITORIO.add(cliente);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();

        EntityModel<Cliente> model = EntityModel.of(cliente);
        model.add(linkTo(methodOn(ClienteController.class).buscarPorId(cliente.getId())).withSelfRel());

        return ResponseEntity.created(location).body(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = REPOSITORIO.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());

        EntityModel<Cliente> model = EntityModel.of(cliente);
        model.add(linkTo(methodOn(ClienteController.class).buscarPorId(id)).withSelfRel());

        return ResponseEntity.ok(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        REPOSITORIO.removeIf(c -> c.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}
```

---

## 18. Exemplo Completo de JSON (HAL Standard)

Saída da requisição `GET /v1/clientes/1`:

```json
{
  "id": 1,
  "nome": "Carlos Eduardo",
  "email": "carlos@email.com",
  "_links": {
    "self": {
      "href": "http://localhost:8080/v1/clientes/1"
    },
    "atualizar": {
      "href": "http://localhost:8080/v1/clientes/1"
    },
    "excluir": {
      "href": "http://localhost:8080/v1/clientes/1"
    },
    "listar-todos": {
      "href": "http://localhost:8080/v1/clientes"
    }
  }
}
```

---

## 19. Vantagens

- **Total Desacoplamento:** Mudar rotas no backend não quebra o frontend caso ele consuma via relações (`rel`).
- **Autodescoberta:** Facilita a exploração da API e reduz o overhead de manutenção documental.
- **Expressão de Estado:** Regras de negócio são refletidas diretamente na disponibilidade dos links.

---

## 20. Desvantagens

- **Aumento do Payload:** A inclusão constante de metadados e URLs aumenta o volume trafegado.
- **Complexidade de Implementação:** Exige maior esforço no backend para montar os relacionamentos de links.
- **Falta de Suporte em SDKs Client:** Muitas bibliotecas client HTTP tradicionais não utilizam os links de forma nativa.

---

## 21. Quando Utilizar

- **Utilizar HATEOAS:** Em APIs públicas, ecossistemas com múltiplos clientes desconhecidos, ou domínios complexos baseados em máquinas de estado rigorosas (fintechs, e-commerce).
- **Usar Nível 2:** Em microsserviços internos, APIs de uso restrito por equipe própria (BFF) ou projetos com requisitos estritos de menor tamanho de payload.

---

## 22. Boas Práticas REST

1. Use substantivos no plural (`/clientes`, `/produtos`).
2. Utilize versionamento de API na URI (`/v1/pedidos`).
3. Filtros, ordenação e paginação devem ser Query Parameters (`/produtos?page=1&size=10&sort=preco,desc`).
4. Retorne payloads padronizados de erro (RFC 7807 - Problem Details).

---

## 23. Convenções de URLs

```
❌ INCORRETO (Padrão RPC / Anti-pattern):
GET  /getClienteById?id=10
POST /salvarCliente
POST /deleteCliente/10

✅ CORRETO (Padrão RESTful):
GET    /v1/clientes/10
POST   /v1/clientes
DELETE /v1/clientes/10
```

---

## 24. Convenções de Status HTTP

- `200 OK`: Sucesso em `GET`, `PUT`, `PATCH`.
- `201 Created`: Sucesso em `POST` com criação de recurso.
- `204 No Content`: Sucesso em `DELETE` ou atualizações sem retorno.
- `400 Bad Request`: Dados incorretos na requisição.
- `401 Unauthorized`: Requer login/token.
- `403 Forbidden`: Acesso negado.
- `404 Not Found`: Recurso não localizado.

---

## 25. Checklist para Criar APIs REST

- [ ] Recursos identificados no plural via substantivos?
- [ ] Verbos HTTP adequados para cada operação?
- [ ] Códigos de status HTTP corretos em cada cenário?
- [ ] Erros formatados de forma padronizada?
- [ ] Suporte a paginação em coleções?
- [ ] HATEOAS e links hipermídia implementados (se aplicável Nível 3)?

---

## 26. Conclusão

A adoção do estilo arquitetural REST e a evolução pelo Modelo de Maturidade de Richardson trazem clareza, padronização e eficiência no desenvolvimento de software moderno. Ao atingir o Nível 3 com HATEOAS, a API torna-se verdadeiramente auto-descritiva e flexível, alinhando-se aos princípios fundamentais que tornaram a Web global tão escalável.
