# Tutorial Completo: Gerando Documentação HTML com Javadoc e Maven 📖☕

Este guia prático ensina como transformar os comentários do seu código Java em um portal de documentação HTML profissional (exatamente igual às documentações oficiais da Oracle e do Spring) utilizando o **Maven**.

---

## 📑 Sumário
1. [O que é o Javadoc e como funciona](#1-o-que-é-o-javadoc-e-como-funciona)
2. [Configurando o Maven para gerar a documentação (`pom.xml`)](#2-configurando-o-maven-para-gerar-a-documentação)
3. [Principais Tags do Javadoc](#3-principais-tags-do-javadoc)
4. [Exemplo Prático 1: Classe de Regra de Negócio (Service)](#4-exemplo-prático-1-classe-de-regra-de-negócio-service)
5. [Exemplo Prático 2: Classe de Modelo / DTO (Produto)](#5-exemplo-prático-2-classe-de-modelo--dto-produto)
6. [Exemplo Prático 3: Classe Controladora Web (RestController)](#6-exemplo-prático-3-classe-controladora-web-restcontroller)
6. [Como Executar e Visualizar o HTML Gerado](#6-como-executar-e-visualizar-o-html-gerado)

---

## 1. O que é o Javadoc e como funciona
O **Javadoc** é a ferramenta padrão do ecossistema Java para extrair comentários especiais estruturados (iniciados por `/**` e terminados por `*/`) diretamente do código-fonte e convertê-los em páginas HTML hiperlinkadas.

---

## 2. Configurando o Maven para gerar a documentação (`pom.xml`)
Para automatizar a geração da documentação no Maven, você deve adicionar o plugin `maven-javadoc-plugin` na seção `<build>` ou `<plugins>` do seu arquivo `pom.xml`:

```xml
<build>
    <plugins>
        <!-- Plugin do Javadoc para Maven -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-javadoc-plugin</artifactId>
            <version>3.6.3</version>
            <configuration>
                <charset>UTF-8</charset>
                <encoding>UTF-8</encoding>
                <docencoding>UTF-8</docencoding>
                <show>protected</show>
                <nohelp>false</nohelp>
            </configuration>
        </plugin>
    </plugins>
</build>
```

---

## 3. Principais Tags do Javadoc
* `@author`: Nome do autor da classe ou método.
* `@version`: Versão atual do componente.
* `@param`: Descreve os parâmetros de entrada de um método.
* `@return`: Descreve o que o método retorna.
* `@throws` / `@exception`: Documenta exceções que o método pode lançar.
* `@see`: Cria links de referência para outras classes ou métodos.

---

## 4. Exemplo Prático 1: Classe de Regra de Negócio (Service)

Abaixo está uma classe de serviço (`CalculadoraFreteService`) documentada detalhadamente com Javadoc:

```java
package com.exemplo.service;

import java.math.BigDecimal;

/**
 * Serviço responsável por calcular custos de frete logístico 
 * com base no peso e na região de entrega do produto.
 * 
 * <p>Esta classe implementa as regras de negócio de cubagem e taxação.</p>
 *
 * @author Loester Franco Botelho
 * @version 1.0
 * @since 2026
 */
public class CalculadoraFreteService {

    private static final BigDecimal VALOR_BASE_KM = new BigDecimal("1.50");

    /**
     * Calcula o valor total do frete com base na distância em quilômetros e no peso do pacote.
     * 
     * @instanciaExemplo
     * <pre>
     *   BigDecimal frete = service.calcularFrete(100.0, new BigDecimal("5.0"));
     * </pre>
     *
     * @param distanciaKm A distância total do trajeto em quilômetros (deve ser maior que zero).
     * @param pesoKg O peso físico do pacote em quilogramas.
     * @return O valor monetário total do frete calculado com precisão decimal.
     * @throws IllegalArgumentException Se a distância ou o peso forem menores ou iguais a zero.
     * @see java.math.BigDecimal
     */
    public BigDecimal calcularFrete(double distanciaKm, BigDecimal pesoKg) {
        if (distanciaKm <= 0 || pesoKg == null || pesoKg.signum() <= 0) {
            throw new IllegalArgumentException("Distância e peso devem ser maiores que zero.");
        }

        BigDecimal fatorPeso = pesoKg.multiply(new BigDecimal("2.5"));
        BigDecimal custoDistancia = VALOR_BASE_KM.multiply(BigDecimal.valueOf(distanciaKm));
        
        return custoDistancia.add(fatorPeso);
    }
}
```

---

---

## 5. Exemplo Prático 2: Classe de Modelo / DTO (`Produto`)

Antes de ver o Controller, precisamos da classe de entidade/modelo que representa o dado que trafega na aplicação:

```java
package com.exemplo.model;

/**
 * Representa um Produto comercializado no sistema de e-commerce.
 * Contém informações básicas como identificador, nome e preço unitário.
 *
 * @author Loester Franco Botelho
 * @version 1.0
 * @since 2026
 */
public class Produto {

    private Long id;
    private String nome;
    private java.math.BigDecimal preco;

    /**
     * Construtor padrão vazio (necessário para serialização/deserialização JSON).
     */
    public Produto() {
    }

    /**
     * Construtor completo para inicialização rápida de um produto.
     *
     * @param id    Identificador único do produto.
     * @param nome  Nome comercial do produto.
     * @param preco Preço de venda em moeda corrente.
     */
    public Produto(Long id, String nome, java.math.BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    /**
     * Retorna o identificador único do produto.
     *
     * @return O ID numérico do produto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do produto.
     *
     * @param id O novo ID a ser atribuído.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o nome comercial do produto.
     *
     * @return Uma string contendo o nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome comercial do produto.
     *
     * @param nome O novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o preço atual de venda do produto.
     *
     * @return Um {@link java.math.BigDecimal} representando o valor monetário.
     */
    public java.math.BigDecimal getPreco() {
        return preco;
    }

    /**
     * Define o preço de venda do produto.
     *
     * @param preco O novo valor monetário do produto.
     */
    public void setPreco(java.math.BigDecimal preco) {
        this.preco = preco;
    }
}
```


---

## 6. Exemplo Prático 3: Classe Controladora Web (`RestController`)

Abaixo temos o controlador Spring REST que consome a classe `Produto` e utiliza o Javadoc nos métodos e construtores:

```java
package com.exemplo.controller;

import com.exemplo.model.Produto;
import com.exemplo.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST responsável por expor os endpoints HTTP 
 * para gerenciamento de produtos no e-commerce.
 * 
 * <p>Mapeia requisições sob o contexto base {@code /api/produtos}.</p>
 *
 * @author Loester Franco Botelho
 * @version 1.2
 * @see com.exemplo.service.ProdutoService
 * @see com.exemplo.model.Produto
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    /**
     * Construtor para injeção de dependência do serviço de produtos.
     *
     * @param produtoService O serviço de regras de negócio de produtos.
     */
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /**
     * Busca um produto específico cadastrado no sistema através do seu identificador único.
     *
     * @param id O identificador numérico único (ID) do produto na base de dados.
     * @return Um {@link ResponseEntity} contendo o objeto {@link Produto} caso encontrado, 
     *         ou status HTTP 404 (Not Found) caso contrário.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Produto produto = produtoService.encontrarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }
}
```


---

## 7. Como Executar e Visualizar o HTML Gerado

Com o plugin configurado no seu `pom.xml` e as classes documentadas, abra o terminal na raiz do projeto Maven e execute o seguinte comando:

```bash
mvn javadoc:javadoc
```

### Onde encontrar o resultado?
Após a execução bem-sucedida do comando, o Maven gerará toda a estrutura de páginas HTML em:
`target/site/apidocs/index.html`

Basta abrir o arquivo `index.html` em qualquer navegador web para navegar pela documentação completa das suas classes, pacotes, métodos e parâmetros!
