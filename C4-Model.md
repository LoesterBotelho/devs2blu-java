# Modelo C4 para Engenharia de Software

O **Modelo C4** é uma técnica de documentação arquitetural criada por **Simon Brown** para visualizar, comunicar e projetar sistemas de software em diferentes níveis de abstração.

O nome **C4** representa os quatro níveis de diagramas:

1. Contexto (Context)
2. Containers
3. Componentes (Components)
4. Código (Code)

---

# 1. Diagrama de Contexto

## Objetivo

Apresentar o sistema como uma "caixa preta", mostrando:

- Usuários
- Sistemas externos
- Principais interações

## Exemplo

```text
+-------------+
|   Cliente   |
+-------------+
       |
       | utiliza
       v
+----------------------+
| Sistema de E-commerce|
+----------------------+
       |
       | integra
       v
+----------------------+
| Gateway de Pagamento |
+----------------------+
```

## Perguntas Respondidas

- Qual é o objetivo do sistema?
- Quem utiliza o sistema?
- Quais sistemas externos são integrados?

---

# 2. Diagrama de Containers

## Objetivo

Mostrar como o sistema está dividido em aplicações, bancos de dados e serviços.

## Exemplo

```text
+----------------------+
| Sistema E-commerce   |
+----------------------+

+-------------+
| Frontend    |
| React       |
+-------------+
       |
       v
+-------------+
| API Backend |
| Java/.NET   |
+-------------+
       |
       v
+-------------+
| PostgreSQL  |
+-------------+
```

## Exemplos de Containers

- Aplicação Web
- Aplicação Mobile
- API REST
- Microsserviço
- Banco de Dados
- Mensageria (RabbitMQ, Kafka)

## Perguntas Respondidas

- Como o sistema foi dividido?
- Onde cada responsabilidade está localizada?
- Como ocorre a comunicação entre os módulos?

---

# 3. Diagrama de Componentes

## Objetivo

Detalhar os componentes internos de um container.

## Exemplo

```text
+----------------------+
| API Backend          |
+----------------------+

PedidoController
        |
        v
PedidoService
        |
        v
PagamentoService
        |
        v
PedidoRepository
```

## Componentes Comuns

- Controllers
- Services
- Repositories
- Adaptadores
- Casos de Uso
- Facades

## Perguntas Respondidas

- Quais módulos compõem a aplicação?
- Como os módulos se relacionam?
- Onde está implementada cada regra de negócio?

---

# 4. Diagrama de Código

## Objetivo

Apresentar a implementação detalhada.

## Exemplo

```text
OrderController
        |
        v
OrderService
        |
        v
OrderRepository
        |
        v
PostgreSQL
```

Ou utilizando UML:

```text
+------------------+
| OrderService     |
+------------------+
| criarPedido()    |
| cancelarPedido() |
+------------------+

          |
          v

+------------------+
| OrderRepository  |
+------------------+
| salvar()         |
| buscarPorId()    |
+------------------+
```

## Perguntas Respondidas

- Como o sistema foi implementado?
- Quais classes existem?
- Como as dependências são organizadas?

---

# Exemplo Completo

## Nível 1 - Contexto

```text
Cliente
    |
    v
Sistema E-commerce
    |
    +--> Gateway de Pagamento
    |
    +--> Sistema de Entrega
```

---

## Nível 2 - Containers

```text
Frontend React
      |
      v
API REST
      |
      +--> PostgreSQL
      |
      +--> RabbitMQ
```

---

## Nível 3 - Componentes

```text
ProdutoController
PedidoController

ProdutoService
PedidoService

ProdutoRepository
PedidoRepository
```

---

## Nível 4 - Código

```text
Produto
Pedido
Cliente

ProdutoService
PedidoService

ProdutoRepository
PedidoRepository
```

---

# Benefícios do Modelo C4

- Simples de aprender.
- Fácil comunicação entre equipes técnicas e de negócio.
- Escalável para sistemas pequenos e grandes.
- Complementa UML sem excesso de complexidade.
- Amplamente utilizado em arquiteturas modernas.
- Excelente para microsserviços, APIs e sistemas em nuvem.

---

# Boas Práticas

- Sempre começar pelo diagrama de Contexto.
- Evoluir para Containers e Componentes.
- Manter os diagramas atualizados.
- Utilizar nomenclatura consistente.
- Focar na comunicação da arquitetura e não apenas na documentação.

---

# Resumo

| Nível | Objetivo |
|---------|----------|
| Contexto | Mostrar usuários e sistemas externos |
| Containers | Mostrar aplicações e tecnologias |
| Componentes | Mostrar módulos internos |
| Código | Mostrar implementação detalhada |

O ideal para a maioria dos projetos corporativos é documentar pelo menos os níveis **Contexto**, **Containers** e **Componentes**, utilizando o nível **Código** apenas quando for necessária maior profundidade técnica.