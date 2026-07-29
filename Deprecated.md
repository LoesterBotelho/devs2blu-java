# Java Deprecated

## O que significa Deprecated?

Em Java, **deprecated** (obsoleto) significa que uma classe, método, atributo ou API:

- Ainda existe.
- Ainda funciona.
- Mas **não é recomendado utilizar em novos códigos**.

O Java marca esses recursos porque existe uma alternativa:

- Mais moderna.
- Mais segura.
- Mais eficiente.
- Com melhor suporte futuro.

---

# Deprecated não significa removido

Um recurso deprecated **não foi apagado do Java**.

Ele continua funcionando, porém o compilador gera um aviso.

Exemplo:

```java
Date data = new Date();

int ano = data.getYear();
```

O método:

```java
getYear()
```

está deprecated.

O Java informa:

```
warning: getYear() in Date has been deprecated
```

---

# Como o Java marca um recurso como Deprecated?

O Java utiliza a anotação:

```java
@Deprecated
public void metodoAntigo() {

    System.out.println("Método antigo");

}
```

Agora, quando alguém utilizar:

```java
obj.metodoAntigo();
```

o compilador exibirá um alerta.

---

# Deprecated com informações adicionais

A partir do Java 9 é possível informar detalhes:

```java
@Deprecated(
    since = "9",
    forRemoval = true
)
public void metodoAntigo() {

}
```

## since

Indica a versão onde o recurso ficou deprecated.

Exemplo:

```java
since = "9"
```

Significa:

> Este método ficou deprecated no Java 9.

---

## forRemoval

Indica que pode ser removido futuramente.

Exemplo:

```java
forRemoval = true
```

Significa:

> Este recurso pode desaparecer em versões futuras do Java.

---

# Exemplos de recursos Deprecated

---

# 1. Classe Date

## Forma antiga

```java
import java.util.Date;

public class Exemplo {

    public static void main(String[] args) {

        Date data = new Date();

        System.out.println(data.getYear());

    }
}
```

Problemas:

- O ano começa em 1900.
- API pouco intuitiva.
- Trabalha mal com fusos horários.

---

## Forma moderna

Usar a API `java.time`.

```java
import java.time.LocalDate;

public class Exemplo {

    public static void main(String[] args) {

        LocalDate data = LocalDate.now();

        int ano = data.getYear();

        System.out.println(ano);

    }
}
```

---

# 2. Thread.stop()

## Antigo

```java
thread.stop();
```

Problemas:

- Pode deixar objetos inconsistentes.
- Pode quebrar sincronização.
- Pode causar erros difíceis de encontrar.

---

## Atual

Usar interrupção:

```java
thread.interrupt();
```

---

# 3. Applet

## Antigo

```java
public class MeuApplet extends Applet {

}
```

Os Applets eram utilizados em navegadores.

Problemas:

- Navegadores modernos não suportam mais.
- Questões de segurança.
- Tecnologia abandonada.

---

# 4. Vector

## Antigo

```java
Vector<String> nomes = new Vector<>();
```

`Vector` ainda existe, porém é uma classe antiga.

Normalmente usamos:

```java
List<String> nomes = new ArrayList<>();
```

Exemplo:

```java
import java.util.ArrayList;
import java.util.List;

List<String> nomes = new ArrayList<>();

nomes.add("João");
nomes.add("Maria");
```

---

# Como identificar Deprecated no IntelliJ IDEA

O IntelliJ mostra:

- Código riscado.
- Aviso amarelo.
- Mensagem explicativa.

Exemplo:

```java
Date data = new Date();
```

Pode aparecer:

```
'Date()' is deprecated
```

---

# Como visualizar avisos Deprecated

## Usando javac

```bash
javac -Xlint:deprecation MinhaClasse.java
```

Exemplo de saída:

```
warning: [deprecation] getYear() in Date has been deprecated
```

---

## Usando Maven

Executar:

```bash
mvn clean compile
```

O Maven exibirá avisos de compilação.

---

# Deprecated em bibliotecas externas

Não acontece apenas no Java.

Exemplo:

Uma biblioteca:

```
biblioteca-versao-1.0
```

possui:

```java
metodoAntigo();
```

Na versão:

```
biblioteca-versao-2.0
```

o método continua funcionando, mas aparece:

```java
@Deprecated
public void metodoAntigo(){

}
```

A documentação normalmente indica:

```
Use novoMetodo() instead.
```

Ou seja:

> Utilize novoMetodo() no lugar.

---

# Boas práticas

Quando encontrar um método deprecated:

1. Leia a mensagem do compilador.

2. Consulte a documentação.

3. Procure a substituição recomendada.

4. Evite criar código novo usando APIs antigas.

---

# Exemplos de substituições comuns

| Antigo | Atual |
|---|---|
| `Date` | `LocalDate`, `LocalDateTime` |
| `Calendar` | `java.time` |
| `Thread.stop()` | `Thread.interrupt()` |
| `Vector` | `ArrayList` |
| `Hashtable` | `HashMap` |
| APIs antigas de IO | `NIO` (`java.nio`) |

---

# Resumo

```
DEPRECATED

      ↓

Ainda funciona

      ↓

Mas não é recomendado

      ↓

Existe uma alternativa melhor

      ↓

Use a nova API
```

## Em projetos modernos Java 17, 21 e 25:

Prefira:

✅ `java.time` no lugar de `Date`  
✅ `List` no lugar de coleções antigas  
✅ APIs modernas do Java  
✅ Bibliotecas atualizadas  

Deprecated é um aviso do Java dizendo:

> "Este recurso funciona, mas existe uma maneira melhor de fazer."