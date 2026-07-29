# Sobrescrita (Override) e Sobrecarga (Overload) em Java

São conceitos diferentes e muito importantes na Programação Orientada a Objetos (POO).

| Conceito | Inglês | Ocorre onde? | Objetivo |
|-----------|---------|-------------|----------|
| Sobrescrita | Override | Herança | Alterar comportamento herdado |
| Sobrecarga | Overload | Mesma classe | Criar várias versões do mesmo método |

---

# 1. Sobrescrita (Override)

Acontece quando uma classe filha redefine um método da classe pai.

## Exemplo

```java
class Animal {

    public void emitirSom() {
        System.out.println("Som genérico");
    }

}

class Cachorro extends Animal {

    @Override
    public void emitirSom() {
        System.out.println("Au Au");
    }

}
```

Uso:

```java
Animal animal = new Cachorro();
animal.emitirSom();
```

Saída:

```text
Au Au
```

O método da classe filha substituiu o comportamento do método da classe pai.

## Regras da Sobrescrita

- Deve existir herança (`extends`).
- Mesmo nome do método.
- Mesma lista de parâmetros.
- Mesmo tipo de retorno (ou compatível).
- Não pode reduzir a visibilidade.

Exemplo válido:

```java
public void salvar()
```

Não pode virar:

```java
private void salvar()
```

---

# 2. Sobrecarga (Overload)

Acontece quando existem vários métodos com o mesmo nome, mas parâmetros diferentes.

## Exemplo

```java
class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }

    public double somar(double a, double b) {
        return a + b;
    }

}
```

Uso:

```java
Calculadora calc = new Calculadora();

calc.somar(10, 20);
calc.somar(10, 20, 30);
calc.somar(1.5, 2.5);
```

O Java escolhe automaticamente qual método executar de acordo com os parâmetros.

---

# Comparação

## Sobrescrita (Override)

```java
class Veiculo {

    public void mover() {
        System.out.println("Movendo");
    }

}

class Carro extends Veiculo {

    @Override
    public void mover() {
        System.out.println("Carro andando");
    }

}
```

---

## Sobrecarga (Overload)

```java
class Impressora {

    public void imprimir(String texto) {
        System.out.println(texto);
    }

    public void imprimir(int numero) {
        System.out.println(numero);
    }

    public void imprimir(String texto, int copias) {
        System.out.println(texto);
    }

}
```

---

# Como Memorizar

## Sobrescrita (Override)

A classe filha substitui um método da classe pai.

```text
Filho -> sobrescreve -> Pai
```

---

## Sobrecarga (Overload)

A mesma classe possui vários métodos com o mesmo nome.

```text
somar(int, int)
somar(double, double)
somar(int, int, int)
```

---

# Relação com Polimorfismo

A sobrescrita é a base do polimorfismo.

```java
Animal animal = new Cachorro();
animal.emitirSom();
```

Saída:

```text
Au Au
```

Mesmo sendo do tipo `Animal`, o objeto real é um `Cachorro`, então o Java executa o método sobrescrito.

Isso é chamado de:

- Polimorfismo
- Despacho Dinâmico de Métodos (Dynamic Dispatch)
- Override

---

# Tempo de Resolução

| Conceito | Resolvido em |
|-----------|-------------|
| Sobrecarga (Overload) | Compilação |
| Sobrescrita (Override) | Execução |
| Polimorfismo | Execução |
| Despacho Dinâmico | Execução |

---

# Resumo

| Característica | Override | Overload |
|---------------|----------|----------|
| Exige herança | Sim | Não |
| Mesmo nome | Sim | Sim |
| Mesmos parâmetros | Sim | Não |
| Polimorfismo | Sim | Não |
| Resolvido em execução | Sim | Não |
| Resolvido em compilação | Não | Sim |

## Resumo Final

- **Override (Sobrescrita)** = Herança + mesmo método + comportamento diferente.
- **Overload (Sobrecarga)** = Mesmo nome + parâmetros diferentes.
- **Override** é utilizado no polimorfismo.
- **Overload** aumenta a flexibilidade da classe.