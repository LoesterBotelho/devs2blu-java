# Arrays e Collections em Java

## Sumário

1. [Introdução](#1-introdução)
2. [Arrays em Java](#2-arrays-em-java)
   - 2.1 Array Unidimensional (1D)
   - 2.2 Array Bidimensional (2D)
   - 2.3 Array Tridimensional (3D)
   - 2.4 Tipos de Arrays
   - 2.5 Arrays de Objetos
3. [Collections Framework](#3-collections-framework)
   - 3.1 O que são Collections
   - 3.2 Hierarquia das Collections
4. [Interface List](#4-interface-list)
   - 4.1 ArrayList
   - 4.2 LinkedList
   - 4.3 Vector
5. [Interface Set](#5-interface-set)
   - 5.1 HashSet
   - 5.2 LinkedHashSet
   - 5.3 TreeSet
6. [Interface Queue](#6-interface-queue)
   - 6.1 PriorityQueue
   - 6.2 ArrayDeque
7. [Interface Map](#7-interface-map)
   - 7.1 HashMap
   - 7.2 LinkedHashMap
   - 7.3 TreeMap
   - 7.4 Hashtable
8. [Pilha (Stack)](#8-pilha-stack)
9. [Comparação Array x Collection](#9-comparação-array-x-collection)
10. [Quando usar cada estrutura](#10-quando-usar-cada-estrutura)
11. [Resumo Geral](#11-resumo-geral)

---

# 1. Introdução

Java possui várias formas de armazenar conjuntos de dados.

As principais são:

- Arrays
- Collections Framework

A diferença principal:

```text
Array       → tamanho fixo
Collection  → tamanho dinâmico
```

---

# 2. Arrays em Java

Um **array** é uma estrutura que armazena vários valores do mesmo tipo.

Características:

- Tamanho fixo.
- Acesso através de índice.
- Armazena o mesmo tipo de dado.
- Faz parte da linguagem Java.

Exemplo:

```java
int[] numeros = {10,20,30};
```

---

# 2.1 Array Unidimensional (1D)

Um único conjunto de valores.

```java
int[] numeros = {10,20,30,40};
```

Representação:

```text
Índice:  0   1   2   3
Valor:  10  20  30  40
```

---

# 2.2 Array Bidimensional (2D)

Representa linhas e colunas.

Exemplo:

```java
int[][] matriz = {
    {1,2,3},
    {4,5,6},
    {7,8,9}
};
```

Visualização:

```text
1 2 3
4 5 6
7 8 9
```

---

# 2.3 Array Tridimensional (3D)

Representa várias matrizes.

Exemplo:

```java
int[][][] cubo = new int[3][3][3];
```

Uso:

- Jogos 3D.
- Simulações.
- Dados científicos.

---

# 2.4 Tipos de Arrays

## Inteiros

```java
int[] valores = {1,2,3};
```

## Decimais

```java
double[] notas = {7.5,8.0};
```

## Texto

```java
String[] nomes = {"Ana","João"};
```

---

# 2.5 Arrays de Objetos

Arrays também podem guardar objetos.

Exemplo:

```java
Pessoa[] pessoas = new Pessoa[10];
```

---

# 3. Collections Framework

Collections são estruturas prontas da biblioteca Java.

Importação:

```java
import java.util.*;
```

Vantagens:

- Crescem automaticamente.
- Possuem vários métodos.
- Facilitam manipulação de dados.

---

# 3.1 Hierarquia das Collections

```text
Collection

├── List
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector

├── Set
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet

└── Queue
    ├── PriorityQueue
    └── ArrayDeque


Map

├── HashMap
├── LinkedHashMap
├── TreeMap
└── Hashtable
```

---

# 4. Interface List

Características:

- Permite duplicados.
- Mantém ordem.
- Trabalha com índice.

Exemplo:

```java
List<String> nomes = new ArrayList<>();
```

---

# 4.1 ArrayList

Mais utilizado.

Características:

- Acesso rápido.
- Cresce automaticamente.
- Aceita duplicados.

---

# 4.2 LinkedList

Lista encadeada.

Características:

- Inserção rápida.
- Remoção rápida.
- Busca mais lenta.

---

# 4.3 Vector

Classe antiga.

Características:

- Sincronizada.
- Pouco utilizada atualmente.

---

# 5. Interface Set

Características:

- Não aceita duplicados.
- Não trabalha com índice.

---

# 5.1 HashSet

```java
Set<String> nomes = new HashSet<>();
```

Características:

- Muito rápido.
- Não garante ordem.

---

# 5.2 LinkedHashSet

Características:

- Não aceita duplicados.
- Mantém ordem de inserção.

---

# 5.3 TreeSet

Características:

- Ordena automaticamente.
- Não aceita duplicados.

---

# 6. Interface Queue

Representa uma fila.

Regra:

```text
FIFO

First In
First Out
```

---

# 6.1 PriorityQueue

Elementos possuem prioridade.

---

# 6.2 ArrayDeque

Pode funcionar como:

- Fila.
- Pilha.

---

# 7. Interface Map

Trabalha com:

```text
Chave → Valor
```

Exemplo:

```java
Map<Integer,String> alunos = new HashMap<>();
```

Resultado:

```text
1 → João
2 → Maria
```

---

# 7.1 HashMap

Características:

- Mais utilizado.
- Busca rápida.
- Não mantém ordem.

---

# 7.2 LinkedHashMap

Mantém ordem de inserção.

---

# 7.3 TreeMap

Ordena pelas chaves.

---

# 7.4 Hashtable

Classe antiga sincronizada.

---

# 8. Pilha (Stack)

Regra:

```text
LIFO

Last In
First Out
```

Exemplo:

```java
Stack<String> pilha = new Stack<>();

pilha.push("A");
pilha.push("B");

pilha.pop();
```

Resultado:

```text
B sai primeiro
```

---

# 9. Comparação Array x Collection

| Característica | Array | Collection |
|-|-|-|
| Tamanho | Fixo | Dinâmico |
| Crescimento | Manual | Automático |
| Métodos | Poucos | Muitos |
| Flexibilidade | Menor | Maior |

---

# 10. Quando usar cada estrutura

| Necessidade | Usar |
|-|-|
| Quantidade fixa | Array |
| Lista de dados | ArrayList |
| Muitas inserções | LinkedList |
| Remover duplicados | HashSet |
| Dados ordenados | TreeSet |
| Chave e valor | HashMap |
| Fila | Queue |
| Pilha | Stack / Deque |

---

# 11. Resumo Geral

```text
ARRAY

int[]
double[]
String[]

Tamanho fixo


LIST

ArrayList
LinkedList
Vector


SET

HashSet
LinkedHashSet
TreeSet


QUEUE

PriorityQueue
ArrayDeque


MAP

HashMap
LinkedHashMap
TreeMap
Hashtable


STACK

Stack
Deque
```

## Regra rápida:

```text
Precisa de tamanho fixo?
→ Array

Precisa adicionar/remover dinamicamente?
→ Collection

Precisa aceitar repetidos?
→ List

Não quer repetidos?
→ Set

Precisa chave e valor?
→ Map

Precisa fila?
→ Queue

Precisa pilha?
→ Stack
```