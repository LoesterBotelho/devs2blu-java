# Classe, Objeto e Instância em Java

Quando começamos em Java, **classe**, **objeto** e **instância** parecem a mesma coisa, mas não são.

---

# Analogia 1: Planta de uma Casa

## Classe

É o **projeto (planta)** da casa.

```java
class Casa {
    String cor;
    int quartos;
}
```

*A classe apenas descreve como uma casa deve ser.*

*Ainda não existe nenhuma casa de verdade.*

---

## Objeto

É uma casa construída a partir da planta.

```java
Casa casa1 = new Casa();
```

*Agora existe uma casa na memória.*

---

## Instância

É o ato de criar um objeto a partir de uma classe.

```java
Casa casa1 = new Casa();
```

*O objeto `casa1` é uma instância da classe `Casa`.*

Por isso você verá frases como:

> "casa1 é uma instância de Casa."

---

# Entendendo Melhor

```java
Casa casa1 = new Casa();
```

| Parte | Significado |
|---------|------------|
| Casa (esquerda) | Tipo / Classe |
| casa1 | Referência para o objeto |
| new Casa() | Instanciação (criação do objeto) |
| objeto criado | Instância da classe Casa |

---

# Exemplo: Pessoa

## Classe

```java
class Pessoa {
    String nome;
    int idade;
}
```

## Objetos

```java
Pessoa p1 = new Pessoa();
Pessoa p2 = new Pessoa();
```

## Atribuindo Valores

```java
p1.nome = "Ana";
p1.idade = 20;

p2.nome = "Carlos";
p2.idade = 35;
```

Representação:

```text
Pessoa
 ├─ p1 -> Ana, 20
 └─ p2 -> Carlos, 35
```

---

# Exemplo: Cachorro

```java
class Cachorro {
    String nome;
    int idade;
}
```

```java
Cachorro dog1 = new Cachorro();
Cachorro dog2 = new Cachorro();
```

```java
dog1.nome = "Rex";
dog2.nome = "Thor";
```

Ambos são objetos e instâncias da classe `Cachorro`.

---

# Resumo Rápido

| Conceito | O que é |
|-----------|----------|
| Classe | Molde, modelo ou projeto. |
| Objeto | Algo criado a partir da classe. |
| Instância | Objeto criado a partir da classe. |
| Instanciação | Processo de criação usando `new`. |

---

# Forma Mais Fácil de Lembrar

```text
CLASSE = Receita de bolo

OBJETO = Bolo pronto

INSTÂNCIA = O bolo foi criado usando a receita

INSTANCIAÇÃO = Fazer o bolo
```

```java
class Bolo {
}
```

```java
Bolo chocolate = new Bolo();
```

- `Bolo` → Classe
- `chocolate` → Objeto
- `new Bolo()` → Instanciação
- `chocolate` → Instância da classe `Bolo`

---

# Classes

| Recurso | Descrição |
|----------|----------|
| class | Classe comum. |
| abstract | Não pode ser instanciada diretamente. |
| final | Não pode ser herdada. |
| sealed | Restringe quais classes podem herdar. |
| non-sealed | Remove a restrição de uma classe sealed. |
| record | Classe imutável simplificada. |
| extends | Herda de outra classe. |
| implements | Implementa uma ou mais interfaces. |

---

# Métodos

| Recurso | Descrição |
|----------|----------|
| public | Acessível de qualquer lugar. |
| protected | Acessível no pacote e subclasses. |
| private | Acessível apenas na própria classe. |
| default | Acesso apenas dentro do pacote. |
| abstract | Deve ser implementado pela subclasse. |
| final | Não pode ser sobrescrito. |
| static | Pertence à classe. |
| synchronized | Controle de concorrência. |
| native | Implementado em código nativo (C/C++). |
| @Override | Sobrescreve método herdado. |
| default (interface) | Método com implementação em interface. |

---

# Variáveis / Atributos

| Recurso | Descrição |
|----------|----------|
| public | Acesso livre. |
| protected | Acesso no pacote e subclasses. |
| private | Acesso apenas na classe. |
| default | Acesso apenas no pacote. |
| static | Compartilhada por todos os objetos. |
| final | Valor não pode ser alterado. |
| transient | Ignorada na serialização. |
| volatile | Visibilidade entre threads. |

---

# Herança e Polimorfismo

| Conceito | Descrição |
|-----------|-----------|
| Herança | Reutilização através de `extends`. |
| Polimorfismo | Um objeto pode assumir vários tipos. |
| Sobrescrita (Override) | Redefine um método herdado. |
| Sobrecarga (Overload) | Mesmo método com parâmetros diferentes. |
| Upcasting | Filho → Pai. |
| Downcasting | Pai → Filho. |
| Dynamic Dispatch | Escolha do método em tempo de execução. |
| Interface | Contrato de comportamento. |
| Encapsulamento | Proteção dos dados da classe. |
| Abstração | Expor apenas o necessário. |

---

# Fórmula para Provas e Entrevistas

```text
Classe = definição

Objeto = instância da classe

Instância = objeto criado a partir da classe

Instanciação = uso do operador new para criar o objeto
```

Exemplo:

```java
Pessoa pessoa = new Pessoa();
```

- `Pessoa` → Classe
- `pessoa` → Referência
- `new Pessoa()` → Instanciação
- Objeto criado → Instância da classe `Pessoa`