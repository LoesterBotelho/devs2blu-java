# Banco de Dados em Arquitetura de Microserviços

Em uma arquitetura de microserviços, a recomendação é que **cada microserviço seja responsável pelos seus próprios dados**, possuindo autonomia para definir sua estrutura, regras de negócio e tecnologia de persistência.

Isso significa que cada serviço:

- Possui seu próprio esquema ou estrutura de dados.
- Define suas próprias regras de negócio.
- Pode utilizar a tecnologia de banco mais adequada para sua necessidade.
- Evolui de forma independente, sem impactar outros serviços.
- Não permite acesso direto aos seus dados por outros microserviços.

## Exemplo

Um ambiente pode conter diferentes microserviços utilizando tecnologias distintas:

```text
Microserviço Usuários
    |
    └── PostgreSQL
        └── schema_usuarios

Microserviço Catálogo
    |
    └── MongoDB
        └── catalogo_db

Microserviço Cache
    |
    └── Redis
        └── chaves do serviço
```

Neste cenário, cada microserviço é proprietário dos seus dados e escolhe a tecnologia mais adequada para seu contexto.

## Exemplo de Organização dos Dados

### Microserviço de Usuários

```text
PostgreSQL
└── schema_usuarios
    ├── usuarios
    ├── perfis
    └── permissoes
```

### Microserviço de Catálogo

```text
MongoDB
└── catalogo_db
    ├── produtos
    ├── categorias
    └── atributos
```

### Microserviço de Sessão

```text
Redis
├── sessao:123
├── sessao:456
└── token:abc
```

## Por que utilizar tecnologias diferentes?

Cada banco de dados possui características específicas que o tornam mais adequado para determinados cenários.

### PostgreSQL

Utilizado quando há necessidade de:

- Transações ACID.
- Integridade referencial.
- Relacionamentos complexos.
- Consultas SQL avançadas.

Exemplo:

```text
Microserviço Usuários
    └── PostgreSQL
```

### MongoDB

Utilizado quando os dados possuem estrutura flexível ou variável.

Exemplo:

```text
Microserviço Catálogo
    └── MongoDB
```

Produtos podem possuir atributos diferentes sem necessidade de alterar o schema continuamente.

### Redis

Utilizado para:

- Cache.
- Sessões.
- Tokens.
- Dados temporários.
- Processamento de alta performance.

Exemplo:

```text
Microserviço Sessão
    └── Redis
```

## Polyglot Persistence

A utilização de diferentes tecnologias de persistência dentro da mesma arquitetura é conhecida como **Polyglot Persistence**.

Nesse modelo, cada microserviço escolhe o banco mais adequado às suas necessidades.

Exemplo:

```text
Usuários  -> PostgreSQL
Catálogo  -> MongoDB
Sessões   -> Redis
Busca     -> Elasticsearch
```

O objetivo é utilizar a ferramenta certa para cada problema, em vez de forçar todos os serviços a utilizarem o mesmo tipo de banco de dados.

## Arquitetura Comum

Uma arquitetura corporativa frequentemente encontrada é a seguinte:

```text
MS Usuários
├── PostgreSQL
└── Redis

MS Pedidos
├── PostgreSQL
└── Redis

MS Busca
└── Elasticsearch

MS Catálogo
└── MongoDB
```

Nesse exemplo:

- PostgreSQL armazena os dados transacionais.
- Redis é utilizado para cache e desempenho.
- Elasticsearch fornece mecanismos de busca avançada.
- MongoDB armazena dados semiestruturados do catálogo.

## Regra Mais Importante

O principal conceito não é necessariamente ter um banco físico para cada microserviço, mas garantir que:

> Cada microserviço seja o único responsável e proprietário dos seus dados.

Portanto, o seguinte **não é recomendado**:

```text
Microserviço Pedidos
    └── SELECT diretamente na tabela usuarios

Microserviço Estoque
    └── UPDATE diretamente na tabela usuarios
```

O correto é que o acesso ocorra por meio de APIs ou eventos:

```text
Microserviço Pedidos
    |
    └── API Usuários

ou

Microserviço Usuários
    |
    └── Evento "Usuário Criado"
            |
            ├── Pedidos
            └── Estoque
```

Dessa forma os serviços permanecem desacoplados, independentes e mais fáceis de evoluir e escalar.

## Comentário sobre o BizChat

Para o BizChat, a abordagem mais adequada tende a ser uma arquitetura em que cada domínio funcional possua seu próprio contexto de dados. Por exemplo:

```text
MS Autenticação
    └── PostgreSQL

MS Conversas
    └── MongoDB

MS Notificações
    └── Redis

MS Busca
    └── Elasticsearch

MS Arquivos
    └── Object Storage
```

Essa separação favorece:

- Escalabilidade por domínio.
- Menor acoplamento entre funcionalidades.
- Evolução independente dos serviços.
- Melhor desempenho ao utilizar a tecnologia adequada para cada tipo de dado.
- Maior resiliência operacional.

Para sistemas de colaboração e comunicação como o BizChat, é comum combinar bancos relacionais para dados transacionais, bancos documentais para mensagens, Redis para cache e sessões, e mecanismos especializados de busca para indexação de conversas e arquivos.