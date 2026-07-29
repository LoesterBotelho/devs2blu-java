# Em engenharia de software, o processo normalmente começa pelos requisitos.

```
Ideia
 ↓
Levantamento de Requisitos
 ↓
Análise de Requisitos
 ↓
Casos de Uso
 ↓
Modelagem UML
 ↓
Modelagem Banco de Dados
 ↓
Arquitetura
 ↓
Implementação
 ↓
Testes
 ↓
Implantação
 ↓
Manutenção
```

# Ciclo de Desenvolvimento de Software

## 1. Requisitos

É a fase mais importante.

### Perguntas

- O que o sistema deve fazer?
- Quem vai usar?
- Quais regras de negócio existem?
- Quais relatórios são necessários?
- Quais integrações existem?

### Exemplo

**Sistema de Biblioteca**

#### Requisitos

- Cadastrar livros
- Cadastrar alunos
- Realizar empréstimos
- Realizar devoluções
- Emitir relatórios

---

## 2. Casos de Uso

Transforma requisitos em funcionalidades.

---

## 3. UML

Modela o sistema.

### Diagrama de Classes
### Diagrama de Sequência

---

## 4. Banco de Dados

### MER
### Modelo Lógico

---

## 5. Implementação
### Java
### SQL

---

# Resumo para Entrevistas e Provas

```text
1. Requisitos
2. Casos de Uso
3. UML
4. MER / DER
5. Modelo Lógico
6. Modelo Físico
7. Código
8. Testes
9. Produção
```

---

## Observação Importante

A maior parte dos erros de um software nasce na fase de **requisitos**.

Se os requisitos estiverem errados ou incompletos, o **UML**, o **banco de dados** e o **código** também estarão errados.

Por isso, em projetos profissionais, o levantamento e a validação dos requisitos costumam acontecer antes de qualquer modelagem ou implementação.


---

# Em um projeto bem organizado, a ordem normalmente é:

| Etapa | Artefato                               | Objetivo                                                   |
| ----- | -------------------------------------- | ---------------------------------------------------------- |
| 1     | Caso de Uso (UML)                      | Entender o que o sistema faz                               |
| 2     | Diagrama de Classes (UML)              | Modelar as entidades do negócio                            |
| 3     | MER (Modelo Entidade-Relacionamento)   | Modelar os dados                                           |
| 4     | DER (Diagrama Entidade-Relacionamento) | Desenhar visualmente o MER                                 |
| 5     | Modelo Lógico                          | Transformar entidades em tabelas                           |
| 6     | Modelo Físico                          | Criar o banco específico (MySQL, PostgreSQL, Oracle, etc.) |
| 7     | SQL DDL                                | CREATE TABLE, PK, FK, INDEX                                |

---

```
Levantamento de Requisitos
          ↓
Casos de Uso (UML)
          ↓
Diagrama de Classes (UML)
          ↓
MER
          ↓
DER
          ↓
Modelo Lógico
          ↓
Modelo Físico
          ↓
Banco de Dados
          ↓
SQL
```

---

# Diagramas UML 2.x

## Diagramas Estruturais (Structure Diagrams)

| Diagrama | Objetivo |
|-----------|-----------|
| Diagrama de Classes (Class Diagram) | Estrutura das classes, atributos, métodos e relacionamentos |
| Diagrama de Objetos (Object Diagram) | Instâncias reais das classes em determinado momento |
| Diagrama de Componentes (Component Diagram) | Organização dos componentes do sistema |
| Diagrama de Implantação (Deployment Diagram) | Infraestrutura física e distribuição do sistema |
| Diagrama de Pacotes (Package Diagram) | Organização lógica em pacotes e módulos |
| Diagrama de Estrutura Composta (Composite Structure Diagram) | Estrutura interna de uma classe ou componente |
| Diagrama de Perfil (Profile Diagram) | Extensão/customização da UML |

---

## Diagramas Comportamentais (Behavior Diagrams)

| Diagrama | Objetivo |
|-----------|-----------|
| Diagrama de Casos de Uso (Use Case Diagram) | Funcionalidades do sistema e atores |
| Diagrama de Atividades (Activity Diagram) | Fluxo de processos e regras de negócio |
| Diagrama de Máquina de Estados (State Machine Diagram) | Estados e transições de um objeto |

---

## Diagramas de Interação (Interaction Diagrams)

| Diagrama | Objetivo |
|-----------|-----------|
| Diagrama de Sequência (Sequence Diagram) | Troca de mensagens ao longo do tempo |
| Diagrama de Comunicação (Communication Diagram) | Interação entre objetos focando relacionamentos |
| Diagrama de Visão Geral de Interação (Interaction Overview Diagram) | Fluxo entre interações complexas |
| Diagrama de Tempo (Timing Diagram) | Comportamento dos objetos ao longo do tempo |

---

# Resumo

| Categoria | Quantidade |
|------------|------------|
| Estruturais | 7 |
| Comportamentais | 3 |
| Interação | 4 |
| Total UML 2.x | 14 |

---

# Mais usados no mercado

| Prioridade | Diagrama |
|------------|------------|
| 1 | Caso de Uso |
| 2 | Classes |
| 3 | Sequência |
| 4 | Atividades |
| 5 | Estados |
| 6 | Componentes |
| 7 | Implantação |
| 8 | Pacotes |

---

# Mais usados em Java

| Diagrama | Uso |
|-----------|------|
| Caso de Uso | Levantamento de requisitos |
| Classes | Modelagem OO |
| Sequência | Fluxo dos métodos |
| Atividades | Regras de negócio |
| Estados | Ciclo de vida de objetos |
| Componentes | APIs, módulos e microsserviços |
| Implantação | Docker, servidores, cloud |

---

# Fluxo comum em projetos
```
Requisitos
↓
Caso de Uso
↓
Diagrama de Classes
↓
Diagrama de Sequência
↓
Diagrama de Atividades
↓
MER / DER
↓
Modelo Lógico
↓
Modelo Físico
↓
Código Java + Banco de Dados
```

---