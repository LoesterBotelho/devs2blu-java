## 📚 Documentações e Links Úteis Oficiais
Para aprofundar ainda mais seus conhecimentos direto das fontes oficiais, consulte:
- [Documentação Oficial do Java 17 API](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
- [Referência Oficial do Spring Framework](https://docs.spring.io/spring-framework/reference/index.html)
- [Javadoc do Spring Stereotype Packages](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/package-summary.html)

Feito com ☕ e dedicação para facilitar seus estudos em Spring Framework!

# Guia Definitivo das Anotações do Spring 🚀

Bem-vindo ao seu manual prático e descomplicado sobre as principais anotações do ecossistema **Spring**! Baseado no mapa mental oficial, este documento foi criado para transformar conceitos abstratos em analogias do dia a dia, acompanhadas de exemplos de código limpos e diretos.

---

## 📑 Sumário
1. [Boot (Inicialização e Configuração Automática)](#1-boot)
2. [Stereotype (Estereótipos e Camadas Arquiteturais)](#2-stereotype)
3. [Core -> Beans (Injeção e Gerenciamento de Dependências)](#3-core---beans)
4. [Core -> Context (Configuração de Contexto e Ambiente)](#4-core---context)
5. [Web (Controladores e Requisições HTTP)](#5-web)

---

## 1. Boot

### `@SpringBootApplication`
* **O que faz:** É a super-anotação que liga o motor do carro. Ela junta três funções cruciais: `@Configuration`, `@EnableAutoConfiguration` e `@ComponentScan`.
* **Analogia:** É a chave de ignição principal de um carro inteligente: ao girá-la, o painel acende, o motor liga e os assistentes automáticos começam a funcionar sozinhos.
* **Exemplo:**
```java
@SpringBootApplication
public class MeusAplicativoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeusAplicativoApplication.class, args);
    }
}
```

### `@EnableAutoConfiguration`
* **O que faz:** Diz para o Spring adivinhar o que você precisa com base nas bibliotecas que você adicionou no projeto (ex: se viu o driver do H2, configura o banco de dados sozinho).
* **Analogia:** É um mordomo prestativo que entra na sua casa nova e, só de olhar as caixas que você trouxe, já arruma a cozinha e liga a geladeira sem você pedir.
* **Exemplo:** Usado implicitamente pelo Spring Boot, mas conceitualmente ativa a inteligência de autoconfiguração.

### `@ConfigurationProperties`
* **O que faz:** Pega propriedades complexas de arquivos de configuração (`application.properties` ou `application.yml`) e joga direto para dentro de um objeto Java estruturado.
* **Analogia:** É preencher uma ficha cadastral automática: você escreve as configurações soltas num bloco de notas e o sistema distribui cada dado nos campos certos do formulário.
* **Exemplo:**
```java
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String nome;
    private int timeout;
    // getters e setters
}
```

---

## 2. Stereotype

### `@Component`
* **O que faz:** Marca uma classe qualquer como um componente gerenciado pelo Spring (um "bean"). O Spring cria e guarda essa classe no bolso dele para usar quando precisar.
* **Analogia:** É como registrar um funcionário coringa na empresa; ele está contratado e pronto para ser chamado para qualquer tarefa.
* **Exemplo:**
```java
@Component
public class ValidadorDeCpf {
    public boolean validar(String cpf) { return true; }
}
```

### `@Repository`
* **O que faz:** Especialização de `@Component` usada na camada de acesso ao banco de dados. Além de registrar o componente, ele traduz erros específicos de banco (como SQL exceptions) em erros padrão do Spring.
* **Analogia:** É o almoxarifado da empresa: o lugar especializado exclusivamente em guardar, buscar e organizar os itens (dados) que vêm de fora.
* **Exemplo:**
```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
```

### `@Service`
* **O que faz:** Indica que a classe contém regras de negócio da aplicação. Semântica pura para organizar o código.
* **Analogia:** É o cérebro ou o gerente da loja: ele não atende o cliente no caixa nem arruma o estoque, mas decide as regras de desconto, cálculo e fluxo do negócio.
* **Exemplo:**
```java
@Service
public class PedidoService {
    public void processarPedido() {
        // Regras de negócio aqui
    }
}
```

### `@Controller` / `@RestController`
* **O que faz:** Marca a classe como um controlador web que recebe requisições HTTP de clientes (navegadores, frontends). O `@RestController` já assume que as respostas serão em formato JSON/XML direto.
* **Analogia:** É o garçom de um restaurante: ele anota o pedido do cliente (requisição), leva para a cozinha processar e traz a comida pronta de volta à mesa (resposta).
* **Exemplo:**
```java
@RestController
@RequestMapping("/api")
public class ClienteController {
    // Endpoints aqui
}
```

---

## 3. Core -> Beans

### `@Autowired`
* **O que faz:** Injeta automaticamente uma dependência (um objeto gerenciado) dentro de outro. Você não precisa dar `new Objeto()`.
* **Analogia:** É pedir uma ferramenta na oficina e o ajudante adivinhar exatamente qual chave você precisa na hora, colocando-a na sua mão sem você precisar ir buscar.
* **Exemplo:**
```java
@Service
public class EmailService {
    @Autowired
    private SMTPClient smtpClient; // Injetado automaticamente
}
```

### `@Qualifier`
* **O que faz:** Quando existem duas classes implementando a mesma interface, o `@Qualifier` resolve a ambiguidade dizendo exatamente qual delas você quer injetar pelo nome.
* **Analogia:** É quando há dois mecânicos na oficina e você grita: "Chama o *João* (específico)", para evitar que venha o Pedro.
* **Exemplo:**
```java
@Autowired
@Qualifier("emailRapido")
private EnvieMensagem enviaMensagem;
```

### `@Value`
* **O que faz:** Injeta valores literais ou propriedades externas (vindas de arquivos como `application.properties`) diretamente em variáveis da classe.
* **Analogia:** É colar um post-it na parede com a senha do Wi-Fi que estava guardada num arquivo de configurações da casa.
* **Exemplo:**
```java
@Component
public class ConfigInfo {
    @Value("${servidor.porta:8080}")
    private int porta;
}
```

---

## 4. Core -> Context

### `@Configuration`
* **O que faz:** Indica que a classe possui métodos que criam e configuram beans personalizados para o ecossistema do Spring.
* **Analogia:** É a planta baixa da arquitetura de uma casa, definindo onde ficarão as tomadas principais e instalações elétricas especiais.
* **Exemplo:**
```java
@Configuration
public class SegurancaConfig {
    // Configurações personalizadas
}
```

### `@ComponentScan`
* **O que faz:** Diz ao Spring quais pacotes ele deve escanear para encontrar as classes anotadas com `@Component`, `@Service`, etc.
* **Analogia:** É dar um mapa com o setor exato da biblioteca onde os livros de receitas devem ser procurados.
* **Exemplo:**
```java
@ComponentScan(basePackages = "com.exemplo.projeto")
public class AppConfig {}
```

### `@Bean`
* **O que faz:** Usado dentro de classes `@Configuration` para dizer: "Spring, execute este método e guarde o objeto retornado como um bean no seu contêiner".
* **Analogia:** É você mesmo montar um móvel personalizado na marcenaria e entregá-lo pronto para uso na sala principal da empresa.
* **Exemplo:**
```java
@Configuration
public class AppConfig {
    @Bean
    public Relogio relogioSistema() {
        return new Relogio();
    }
}
```

### `@Lazy`
* **O que faz:** Adia a criação de um bean. Em vez de o Spring criar o objeto logo na inicialização da aplicação, ele só criará quando o objeto for chamado pela primeira vez.
* **Analogia:** É comprar um gerador de emergência: ele fica guardado no canto desligado e só é ligado de fato quando falta luz.
* **Exemplo:**
```java
@Component
@Lazy
public class RelatorioPesadoService {
    // Só carrega na memória quando for usado
}
```

### `@Primary`
* **O que faz:** Define a preferência padrão de um bean quando existem múltiplas implementações e nenhuma anotação `@Qualifier` foi especificada.
* **Analogia:** É o sabor padrão de sorvete (baunilha): se o cliente não escolher um sabor específico, o sistema serve o padrão automaticamente.
* **Exemplo:**
```java
@Component
@Primary
public class PagamentoCartao implements PagamentoService {
    // Será o escolhido por padrão se houver dúvida
}
```

### `@Scope`
* **O que faz:** Define o ciclo de vida/escopo de um bean (ex: `singleton` [uma única instância para a aplicação toda] ou `prototype` [uma nova instância criada toda vez que é injetado]).
* **Analogia:** Uma caneta da recepção (Singleton: todo mundo usa a mesma caneta) versus uma seringa descartável (Prototype: uma nova para cada paciente).
* **Exemplo:**
```java
@Component
@Scope("prototype")
public class SessaoUsuario {
    // Uma nova instância a cada requisição/injeção
}
```

### `@PropertySource`
* **O que faz:** Carrega um arquivo de propriedades customizado (`.properties`) para dentro do contexto do Spring.
* **Analogia:** É entregar uma pasta de documentos extras na recepção para que a secretária consulte regras específicas daquele contrato.
* **Exemplo:**
```java
@Configuration
@PropertySource("classpath:pagamento.properties")
public class ConfigPagamento {}
```

### `@PropertySources`
* **O que faz:** Permite agrupar e carregar **múltiplos** arquivos de propriedades de uma só vez.
* **Analogia:** É carregar várias pastas de arquivos diferentes de uma só vez no escritório.
* **Exemplo:**
```java
@Configuration
@PropertySources({
    @PropertySource("classpath:banco.properties"),
    @PropertySource("classpath:email.properties")
})
public class AppPropertiesConfig {}
```

### `@Profile`
* **O que faz:** Ativa componentes ou configurações específicas dependendo do ambiente em que a aplicação está rodando (ex: `dev`, `test`, `prod`).
* **Analogia:** O guarda-roupa de inverno só é aberto e utilizado quando o perfil do clima lá fora marca "Inverno".
* **Exemplo:**
```java
@Component
@Profile("prod")
public class BancoProducaoConfig {
    // Configurações exclusivas para produção
}
```

---

## 5. Web

### `@RestController`
* **O que faz:** Combinação de `@Controller` e `@ResponseBody`. Usada para criar APIs RESTful que retornam dados puros (JSON) diretamente para o cliente.
* **Analogia:** Um caixa automático de banco: você digita o comando e ele te entrega o dinheiro (dados JSON) direto, sem firulas visuais de HTML.
* **Exemplo:**
```java
@RestController
public class ProdutoController {
}
```

### `@RequestMapping`
* **O que faz:** Mapeia URLs gerais de requisição para uma classe ou método específico do controlador.
* **Analogia:** O ramal telefônico principal de um departamento: direciona a ligação para o setor correto da empresa.
* **Exemplo:**
```java
@RequestMapping("/api/v1/produtos")
public class ProdutoController {}
```

### `@GetMapping`
* **O que faz:** Atalho para mapear requisições HTTP do tipo **GET** (leitura/busca de dados).
* **Analogia:** Pedir para consultar o cardápio no balcão da lanchonete (você só quer ler a informação).
* **Exemplo:**
```java
@GetMapping("/{id}")
public Produto buscarPorId(@PathVariable Long id) {
    return new Produto();
}
```

### `@PostMapping`
* **O que faz:** Mapeia requisições HTTP do tipo **POST** (criação de novos recursos).
* **Analogia:** Enviar uma carta de cadastro para abrir uma conta nova no banco.
* **Exemplo:**
```java
@PostMapping
public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
    return ResponseEntity.status(201).body(produto);
}
```

### `@PutMapping`
* **O que faz:** Mapeia requisições HTTP do tipo **PUT** (atualização completa de um recurso existente).
* **Analogia:** Substituir um quadro antigo da parede por um quadro totalmente novo nas mesmas medidas.
* **Exemplo:**
```java
@PutMapping("/{id}")
public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
    return produto;
}
```

### `@DeleteMapping`
* **O que faz:** Mapeia requisições HTTP do tipo **DELETE** (remoção de um recurso).
* **Analogia:** Jogar um documento antigo na trituradora de papel.
* **Exemplo:**
```java
@DeleteMapping("/{id}")
public void deletar(@PathVariable Long id) {
    // lógica de exclusão
}
```

### `@RequestBody`
* **O que faz:** Informa ao Spring que os dados enviados no corpo da requisição HTTP (geralmente JSON) devem ser convertidos automaticamente para um objeto Java.
* **Analogia:** Desembrulhar um pacote de encomenda que veio pelo correio e organizar os itens dentro da gaveta correspondente.
* **Exemplo:**
```java
@PostMapping
public void salvar(@RequestBody Usuario novoUsuario) {
    // Objeto já pronto e mapeado
}
```

### `@PathVariable`
* **O que faz:** Extrai variáveis diretamente de partes da URL (ex: `/usuarios/{id}`).
* **Analogia:** Ler o número do apartamento impresso direto na fachada do prédio para saber a qual morador se refere a entrega.
* **Exemplo:**
```java
@GetMapping("/usuarios/{id}")
public void buscar(@PathVariable("id") Long idUsuario) {
    // idUsuario recebe o valor da URL
}
```

### `@RequestParam`
* **O que faz:** Extrai parâmetros de consulta (query parameters) passados após a interrogação na URL (ex: `/busca?nome=joao`).
* **Analogia:** Os filtros de busca em um site de e-commerce (ex: ?categoria=eletronicos&preco=ate100).
* **Exemplo:**
```java
@GetMapping("/pesquisa")
public void pesquisar(@RequestParam("nome") String nomeFiltro) {
    // nomeFiltro recebe "joao"
}
```

### `@CrossOrigin`
* **O que faz:** Libera o acesso a endpoints da sua API para origens/domínios externos (regra de segurança CORS).
* **Analogia:** O segurança da portaria da empresa que libera a entrada de visitantes vindos de outra cidade/empresa parceira.
* **Exemplo:**
```java
@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite requisições do Angular local
public class CorsController {}
```

---

Feito com ☕ e dedicação para facilitar seus estudos em Spring Framework!
