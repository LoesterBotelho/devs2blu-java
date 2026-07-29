# Princípios da Programação Orientada a Objetos (POO)

A Programação Orientada a Objetos é baseada em quatro pilares fundamentais:

1. Encapsulamento
2. Herança
3. Polimorfismo
4. Abstração

---

# 1. Encapsulamento

O encapsulamento consiste em proteger os dados de uma classe, permitindo o acesso apenas através de métodos definidos.

## Exemplo

```java
public class Conta {
    private double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
```

## Vantagens

- Protege os dados internos.
- Evita alterações indevidas.
- Facilita manutenção.
- Aumenta a segurança do código.

---

# 2. Herança

A herança permite que uma classe reutilize atributos e métodos de outra classe.

## Exemplo

```java
public class Animal {
    public void dormir() {
        System.out.println("Dormindo...");
    }
}
```

```java
public class Cachorro extends Animal {
    public void latir() {
        System.out.println("Au Au");
    }
}
```

## Uso

```java
Cachorro dog = new Cachorro();

dog.dormir(); // Método herdado
dog.latir();
```

## Hierarquia

```text
Animal
   ↑
Cachorro
```

## Vantagens

- Reutilização de código.
- Menor duplicação.
- Facilita manutenção.

---

# 3. Polimorfismo

O polimorfismo permite que um mesmo método tenha comportamentos diferentes dependendo do objeto utilizado.

## Classe Base

```java
public class Animal {
    public void emitirSom() {
        System.out.println("Som genérico");
    }
}
```

## Classes Derivadas

```java
public class Cachorro extends Animal {

    @Override
    public void emitirSom() {
        System.out.println("Au Au");
    }
}
```

```java
public class Gato extends Animal {

    @Override
    public void emitirSom() {
        System.out.println("Miau");
    }
}
```

## Uso

```java
Animal a1 = new Cachorro();
Animal a2 = new Gato();

a1.emitirSom();
a2.emitirSom();
```

## Saída

```text
Au Au
Miau
```

## Tipos de Polimorfismo em Java

| Tipo | Exemplo |
|--------|----------|
| Override | Sobrescrita de métodos |
| Interface | Implementações diferentes |
| Classe Abstrata | Métodos implementados nas subclasses |

---

# 4. Abstração

A abstração consiste em representar apenas as características importantes para o sistema, escondendo detalhes desnecessários.

## Exemplo

```java
public class Carro {

    public void acelerar() {
        System.out.println("Acelerando");
    }

    public void frear() {
        System.out.println("Freando");
    }
}
```

O usuário utiliza:

```java
carro.acelerar();
```

Sem precisar saber:

- Como o motor funciona.
- Como ocorre a combustão.
- Como a transmissão troca marchas.

## Vantagens

- Simplifica o sistema.
- Reduz complexidade.
- Facilita manutenção.

---

# Exemplo Completo dos 4 Pilares

## Classe Abstrata

```java
public abstract class Animal {

    private String nome; // Encapsulamento

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void emitirSom(); // Abstração
}
```

## Classe Cachorro

```java
public class Cachorro extends Animal {

    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Au Au");
    }
}
```

## Classe Gato

```java
public class Gato extends Animal {

    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau");
    }
}
```

## Programa Principal

```java
public class Main {

    public static void main(String[] args) {

        Animal a1 = new Cachorro("Rex");
        Animal a2 = new Gato("Mingau");

        a1.emitirSom();
        a2.emitirSom();
    }
}
```

---

# Resumo

| Pilar | Objetivo |
|---------|-----------|
| Encapsulamento | Proteger dados |
| Herança | Reutilizar código |
| Polimorfismo | Variar comportamentos |
| Abstração | Esconder detalhes |

## Forma Fácil de Memorizar

```text
Encapsulamento = Proteger
Herança        = Reutilizar
Polimorfismo   = Variar comportamento
Abstração      = Simplificar
```