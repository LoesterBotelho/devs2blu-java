## Covariância e Contravariância em Java (`? extends` e `? super`)

A forma mais comum de lembrar a diferença entre `? extends T` e `? super T` é através da regra **PECS**:

> **Producer Extends, Consumer Super**

- **Producer (`extends`)**: produz dados para você ler.
- **Consumer (`super`)**: consome dados que você quer adicionar.

---

### `? extends T` (Covariante)

Significa:

> "Uma coleção de algum tipo que é `T` ou uma subclasse de `T`."

```java
List<? extends Animal> animais = new ArrayList<Cachorro>();
```

Como todos os elementos são pelo menos do tipo `Animal`, você pode ler os itens com segurança:

```java
Animal animal = animais.get(0);
```

Porém, não pode adicionar novos elementos:

```java
animais.add(new Cachorro()); // ERRO
animais.add(new Gato());     // ERRO
```

O motivo é que o compilador não sabe qual é o tipo concreto da lista. Ela pode ser:

```java
List<Cachorro>
List<Gato>
List<Animal>
```

Como não há garantia do tipo exato, a escrita é bloqueada.

### Resumo

```java
? extends T
```

- ✅ Posso ler objetos como `T`
- ❌ Não posso adicionar objetos do tipo `T`

---

### `? super T` (Contravariante)

Significa:

> "Uma coleção de algum tipo que é `T` ou uma superclasse de `T`."

```java
List<? super Cachorro> cachorros = new ArrayList<Animal>();
```

Agora é seguro adicionar objetos do tipo `Cachorro`:

```java
cachorros.add(new Cachorro()); // OK
```

Mas ao ler, o compilador não sabe o tipo exato armazenado.

Por isso, apenas `Object` é garantido:

```java
Object obj = cachorros.get(0); // OK

// Cachorro c = cachorros.get(0); // ERRO
```

### Resumo

```java
? super T
```

- ✅ Posso adicionar objetos do tipo `T`
- ❌ Não posso ler como `T` (apenas como `Object`)

---

## Exemplo Completo

```java
class Animal {}

class Cachorro extends Animal {}

public class Main {

    public static void main(String[] args) {

        List<Cachorro> listaCachorros = new ArrayList<>();

        // Covariância
        List<? extends Animal> leitura = listaCachorros;
        Animal animal = leitura.get(0);

        // Contravariância
        List<? super Cachorro> escrita = new ArrayList<Animal>();
        escrita.add(new Cachorro());
    }
}
```

---

## Regra PECS

### Producer Extends

Use quando a coleção apenas fornece dados para leitura:

```java
void imprimirAnimais(List<? extends Animal> animais) {
    for (Animal animal : animais) {
        System.out.println(animal);
    }
}
```

A lista produz objetos do tipo `Animal`.

---

### Consumer Super

Use quando a coleção recebe objetos:

```java
void adicionarCachorros(List<? super Cachorro> animais) {
    animais.add(new Cachorro());
}
```

A lista consome objetos do tipo `Cachorro`.

---

## Resumo Final

```java
? extends T
```

> Covariante: posso ler objetos como `T`.

```java
? super T
```

> Contravariante: posso escrever objetos do tipo `T`.

Regra rápida para decorar:

```text
Producer Extends = READ
Consumer Super   = WRITE
```

ou

```text
? extends T -> READ
? super T   -> WRITE
```

Ou ainda:

- **Extends produz T → você lê**
- **Super consome T → você escreve**

---

# Polimorfismo, Covariância e Java (Java 25)

## Polimorfismo

Polimorfismo é a capacidade de uma referência de um tipo mais genérico apontar para objetos de tipos mais específicos.

```java
class Animal {
    void emitirSom() {
        System.out.println("Som genérico");
    }
}

class Cachorro extends Animal {
    @Override
    void emitirSom() {
        System.out.println("Au Au");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Cachorro();

        animal.emitirSom(); // Au Au
    }
}
```

Mesmo a variável sendo do tipo `Animal`, o método executado é o da classe `Cachorro`.

Isso é chamado de **polimorfismo em tempo de execução** (*Runtime Polymorphism*).

---

## Covariância e Polimorfismo

A covariância é uma extensão natural do polimorfismo.

Se um `Cachorro` é um `Animal`, então um retorno do tipo `Cachorro` pode substituir um retorno do tipo `Animal`.

### Sem Covariância

```java
class AnimalFactory {
    Animal criar() {
        return new Animal();
    }
}
```

### Com Covariância

```java
class AnimalFactory {
    Animal criar() {
        return new Animal();
    }
}

class CachorroFactory extends AnimalFactory {

    @Override
    Cachorro criar() {
        return new Cachorro();
    }
}
```

Observe que:

```java
Animal criar()
```

foi sobrescrito por

```java
Cachorro criar()
```

Como `Cachorro` herda de `Animal`, o compilador permite esse retorno mais específico.

Isso é chamado de **Retorno Covariante (Covariant Return Type)**.

---

## Polimorfismo + Retorno Covariante

```java
AnimalFactory factory = new CachorroFactory();

Animal animal = factory.criar();
```

Fluxo:

```text
factory -> referência AnimalFactory
objeto  -> CachorroFactory
retorno -> Cachorro
variável -> Animal
```

Embora a variável seja `Animal`, o objeto retornado é um `Cachorro`.

---

## Covariância com Generics

### Permitido para leitura

```java
List<Cachorro> cachorros = new ArrayList<>();

List<? extends Animal> animais = cachorros;
```

Podemos ler:

```java
Animal animal = animais.get(0);
```

Mas não podemos adicionar:

```java
animais.add(new Cachorro()); // ERRO
```

---

## Contravariância

```java
List<? super Cachorro> cachorros =
        new ArrayList<Animal>();
```

Agora podemos escrever:

```java
cachorros.add(new Cachorro());
```

Porém, ao ler:

```java
Object obj = cachorros.get(0);
```

A única garantia é que o retorno seja um `Object`.

---

## Relação Entre os Conceitos

### Herança

```java
Cachorro extends Animal
```

### Polimorfismo

```java
Animal animal = new Cachorro();
```

### Covariância

```java
Cachorro criar()
```

substitui

```java
Animal criar()
```

### Contravariância

```java
List<? super Cachorro>
```

aceita escrita de `Cachorro`.

---

## Regra PECS

```text
Producer Extends
Consumer Super
```

### Producer (Covariante)

```java
List<? extends Animal>
```

- Produz `Animal`
- READ ✅
- WRITE ❌

### Consumer (Contravariante)

```java
List<? super Cachorro>
```

- Consome `Cachorro`
- WRITE ✅
- READ apenas como Object ✅

---

## Resumo para Entrevista

```text
Polimorfismo:
Uma referência de uma superclasse pode apontar para um objeto de uma subclasse.

Covariância:
Permite retornar um tipo mais específico ao sobrescrever métodos.

Contravariância:
Permite consumir/escrever tipos específicos usando ? super.

? extends T -> READ
? super T   -> WRITE

PECS:
Producer Extends
Consumer Super
```

**Java 25 continua utilizando os mesmos conceitos fundamentais de polimorfismo, herança, covariância e contravariância presentes nas versões anteriores da linguagem.**

---

# Polimorfismo e Covariância em Java 25 com Super-Heróis 🦸

## O que é Polimorfismo?

Polimorfismo é a capacidade de uma referência de uma classe pai apontar para objetos de classes filhas.

### Exemplo

```java
class SuperHeroi {
    void usarPoder() {
        System.out.println("Usando poder genérico");
    }
}

class HomemAranha extends SuperHeroi {

    @Override
    void usarPoder() {
        System.out.println("Lançando teia");
    }
}

class Superman extends SuperHeroi {

    @Override
    void usarPoder() {
        System.out.println("Visão de calor");
    }
}
```

Uso:

```java
SuperHeroi heroi1 = new HomemAranha();
SuperHeroi heroi2 = new Superman();

heroi1.usarPoder();
heroi2.usarPoder();
```

Saída:

```text
Lançando teia
Visão de calor
```

Observe que:

```java
SuperHeroi heroi1
```

aponta para:

```java
new HomemAranha()
```

e

```java
SuperHeroi heroi2
```

aponta para:

```java
new Superman()
```

Isso é **polimorfismo**.

---

# Covariância (Covariant Return Type)

A covariância permite que um método sobrescrito retorne um tipo mais específico.

## Classe Base

```java
class FabricaHeroi {

    SuperHeroi criarHeroi() {
        return new SuperHeroi();
    }
}
```

## Classe Filha

```java
class FabricaHomemAranha extends FabricaHeroi {

    @Override
    HomemAranha criarHeroi() {
        return new HomemAranha();
    }
}
```

Observe:

Classe pai:

```java
SuperHeroi criarHeroi()
```

Classe filha:

```java
HomemAranha criarHeroi()
```

Como:

```java
HomemAranha extends SuperHeroi
```

o Java permite esse retorno mais específico.

Isso é chamado de **covariância**.

---

# Polimorfismo + Covariância

```java
FabricaHeroi fabrica = new FabricaHomemAranha();

SuperHeroi heroi = fabrica.criarHeroi();

heroi.usarPoder();
```

Fluxo:

```text
Referência: FabricaHeroi
Objeto:     FabricaHomemAranha
Retorno:    HomemAranha
Variável:   SuperHeroi
```

Resultado:

```text
Lançando teia
```

---

# Covariância com Generics

Imagine uma equipe de heróis.

```java
List<HomemAranha> aranhas = List.of(
        new HomemAranha(),
        new HomemAranha()
);
```

Podemos fazer:

```java
List<? extends SuperHeroi> herois = aranhas;
```

Porque:

```java
HomemAranha é um SuperHeroi
```

Logo:

```java
? extends SuperHeroi
```

aceita qualquer subtipo de `SuperHeroi`.

---

## Leitura Permitida

```java
SuperHeroi heroi = herois.get(0);

heroi.usarPoder();
```

✅ Permitido

---

## Escrita Proibida

```java
herois.add(new Superman());
```

❌ Erro de compilação

Por quê?

Porque a lista pode ser:

```java
List<HomemAranha>
```

e inserir um `Superman` quebraria a consistência.

---

# Contravariância com Heróis

Agora queremos cadastrar heróis.

```java
List<? super HomemAranha> recrutamento =
        new ArrayList<SuperHeroi>();
```

Podemos adicionar:

```java
recrutamento.add(new HomemAranha());
```

✅ Permitido

---

Mas ao ler:

```java
Object obj = recrutamento.get(0);
```

A única garantia é:

```java
Object
```

✅ Permitido

```java
HomemAranha heroi =
        recrutamento.get(0);
```

❌ Erro de compilação

---

# Exemplo Mental

Imagine:

```text
SuperHeroi
│
├── HomemAranha
├── Superman
├── Batman
└── Flash
```

### Covariante

```java
List<? extends SuperHeroi>
```

Significa:

```text
Uma lista de algum herói específico.
```

Pode ser:

- HomemAranha
- Superman
- Batman
- Flash

Como você não sabe qual é o tipo exato:

✅ Ler

❌ Escrever

---

### Contravariante

```java
List<? super HomemAranha>
```

Pode ser:

- List<HomemAranha>
- List<SuperHeroi>
- List<Object>

Como todas aceitam um `HomemAranha`:

✅ Escrever HomemAranha

❌ Ler como HomemAranha

---

# Regra PECS

```text
Producer Extends
Consumer Super
```

## Producer

```java
List<? extends SuperHeroi>
```

Produz heróis.

```text
READ ✅
WRITE ❌
```

---

## Consumer

```java
List<? super HomemAranha>
```

Consome HomemAranha.

```text
WRITE ✅
READ apenas Object ✅
```

---

# Resumo para Entrevista

```text
Polimorfismo
=
Uma referência da superclasse aponta para objetos das subclasses.

Ex:
SuperHeroi heroi = new Superman();
```

```text
Covariância
=
Um método sobrescrito pode retornar um tipo mais específico.

Ex:
SuperHeroi criarHeroi()

↓ sobrescrito por ↓

HomemAranha criarHeroi()
```

```text
? extends SuperHeroi
=
Covariância
READ ✅
WRITE ❌
```

```text
? super HomemAranha
=
Contravariância
WRITE ✅
READ apenas Object ✅
```

```text
PECS

Producer Extends
Consumer Super
```