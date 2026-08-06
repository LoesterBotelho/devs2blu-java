# Capítulo XX — Nova Arquitetura do Angular Moderno
## Angular 17 → Angular 22

**Nível:** Arquiteto de Software Sênior / Google Developer Expert (GDE) em Angular  
**Escopo:** Standalone Components · Signals · Vite · ESBuild · SSR · Hydration  
**Fontes:** Documentação oficial (angular.dev), Angular Blog, RFCs, CHANGELOG e Update Guides oficiais

> Este capítulo explica **em profundidade** as seis tecnologias que formam a nova arquitetura do Angular moderno.  
> Cada seção cobre: história, conceitos, funcionamento interno, arquitetura, exemplos, comparações, vantagens, limitações, boas práticas e estratégias de migração.

---

## Objetivos do Capítulo

Ao final deste capítulo o leitor será capaz de:

- Entender por que o Angular mudou sua arquitetura entre 2023 e 2026.
- Compreender o fim da obrigatoriedade dos **NgModules**.
- Dominar o novo modelo reativo baseado em **Signals**.
- Conhecer o pipeline de build moderno com **Vite** + **ESBuild**.
- Entender **Server-Side Rendering (SSR)** e seu papel no Angular atual.
- Compreender o processo de **Hydration** (incluindo Incremental Hydration e Event Replay).
- Saber quando utilizar cada tecnologia em aplicações reais.
- Migrar projetos legados para a nova arquitetura com segurança.

---

## Visão Geral da Transformação Arquitetural

A partir do Angular 17 (novembro de 2023) o framework iniciou a maior transformação estrutural desde a introdução do Ivy.

A arquitetura clássica (NgModules + Zone.js + Webpack + renderização exclusivamente no cliente) começou a ser substituída por uma base mais moderna, composta por:

| Tecnologia              | Problema que resolve                          | Status em Angular 22      |
|-------------------------|-----------------------------------------------|---------------------------|
| **Standalone Components** | Elimina a complexidade dos NgModules         | Default (desde v19)      |
| **Signals**             | Reatividade precisa e performática            | Fundação estável         |
| **Vite**                | Dev server extremamente rápido + HMR          | Integrado ao Application Builder |
| **ESBuild**             | Compilação e bundling extremamente rápidos    | Base do Application Builder |
| **SSR**                 | HTML inicial no servidor (SEO + performance)  | Maduro + hybrid rendering |
| **Hydration**           | Reutiliza o HTML do servidor no cliente       | Stable + Incremental     |

Essas peças trabalham juntas para entregar:

- Menos boilerplate
- Melhor tree-shaking
- Change Detection mais preciso
- Builds e reloads muito mais rápidos
- Melhores Core Web Vitals (LCP, INP, CLS)
- Arquitetura mais alinhada com o futuro da web (Signals no TC39, Fetch, etc.)

---

# 1. Standalone Components

## 1.1 O que é Standalone Components

**Standalone Component** é um componente, diretiva ou pipe que **declara suas próprias dependências** e não precisa pertencer a um `NgModule`.

```ts
@Component({
  selector: 'app-user-card',
  standalone: true,                // a partir do Angular 19 este valor é o default
  imports: [CommonModule, RouterLink, CurrencyPipe],
  template: `...`
})
export class UserCard {}
```

### Evolução histórica

| Versão | Situação |
|--------|----------|
| Angular 2–13 | NgModules obrigatórios |
| Angular 14 | Standalone em Developer Preview |
| Angular 15 | Standalone stable |
| Angular 16–18 | Standalone recomendado, mas NgModules ainda dominantes |
| **Angular 19** | **Standalone se torna o default** (`standalone: true` implícito) |
| Angular 20–22 | NgModules são legados; Style Guide e CLI empurram fortemente standalone |

### Objetivos da mudança

1. Eliminar um conceito intermediário desnecessário (NgModule).
2. Tornar as dependências de cada componente **explícitas e localizadas**.
3. Melhorar tree-shaking e análise estática.
4. Reduzir a curva de aprendizado para novos desenvolvedores.
5. Facilitar lazy loading e micro-frontends.

## 1.2 Problemas do modelo antigo (NgModules)

### AppModule, Feature Modules, Shared Modules, Core Module

No modelo clássico era comum ter:

```
AppModule
├── CoreModule          (singleton services)
├── SharedModule        (componentes, pipes e diretivas reutilizáveis)
└── FeatureModules      (cada área de negócio)
    ├── declarations
    ├── imports
    └── exports
```

### Problemas reais observados em projetos grandes

- **Acoplamento excessivo**: SharedModule crescia indefinidamente.
- **Barrel files** (`index.ts`) escondiam dependências e atrapalhavam tree-shaking.
- **Curva de aprendizado alta**: novos devs não entendiam por que precisavam de módulos.
- **Configuração verbosa**: um componente simples exigia declaração + import + export em vários lugares.
- **Circular dependencies** frequentes entre módulos.
- **Lazy loading complexo**: era preciso criar um módulo só para fazer lazy load de uma rota.

## 1.3 Arquitetura antiga (NgModules)

```ts
@NgModule({
  declarations: [HomeComponent, UserCardComponent],
  imports: [CommonModule, RouterModule, SharedModule],
  exports: [UserCardComponent],
  providers: [UserService],
  bootstrap: [AppComponent]   // só no AppModule
})
export class HomeModule {}
```

**Diagrama simplificado da arquitetura antiga:**

```text
AppModule
   │
   ├── imports → BrowserModule, AppRoutingModule, FeatureModules
   ├── declarations → AppComponent
   └── bootstrap → AppComponent

FeatureModule
   │
   ├── declarations → componentes da feature
   ├── imports → CommonModule, SharedModule, RouterModule.forChild()
   └── providers → services da feature (ou providedIn)
```

## 1.4 Arquitetura moderna (Standalone + ApplicationConfig)

```ts
// main.ts
bootstrapApplication(App, appConfig);

// app.config.ts
export const appConfig: ApplicationConfig = {
  providers: [
    provideZonelessChangeDetection(),
    provideRouter(routes),
    provideHttpClient(withFetch()),
    provideAnimationsAsync(),
    provideClientHydration(withIncrementalHydration())
  ]
};
```

**Não existe mais AppModule.**  
Toda a configuração de aplicação fica em `ApplicationConfig`.

## 1.5 O decorator `standalone`

A partir do Angular 19:

```ts
@Component({
  // standalone: true é o DEFAULT – não precisa escrever
  imports: [RouterLink, DatePipe]
})
export class ProductCard {}
```

Só é necessário escrever `standalone: false` quando o componente **ainda** está declarado em um NgModule (durante a migração).

## 1.6 Imports entre componentes

Cada componente standalone declara **exatamente** o que seu template utiliza:

```ts
imports: [
  CommonModule,          // NgClass, NgStyle, AsyncPipe, etc. (quando necessário)
  RouterLink,
  RouterOutlet,
  CurrencyPipe,
  ReactiveFormsModule,
  UserAvatar,            // outro componente standalone
  HighlightDirective     // diretiva standalone
]
```

**Control Flow (`@if`, `@for`, `@switch`, `@defer`) não precisa ser importado** – é nativo do template.

## 1.7 Dependency Injection em Standalone

| Escopo | Como registrar |
|--------|----------------|
| Singleton da aplicação | `providedIn: 'root'` ou `providers` em `app.config.ts` |
| Escopo de rota | `providers` na definição da rota |
| Escopo de componente | `providers` no decorator `@Component` |
| Environment providers | `makeEnvironmentProviders()` + `importProvidersFrom()` (casos avançados) |

```ts
// Forma moderna preferida
private userService = inject(UserService);
```

## 1.8 Lazy Loading com Standalone

```ts
export const routes: Routes = [
  {
    path: 'admin',
    loadComponent: () => import('./admin/admin-dashboard').then(m => m.AdminDashboard)
  },
  {
    path: 'products',
    loadChildren: () => import('./products/routes').then(m => m.PRODUCT_ROUTES)
  }
];
```

Não é mais necessário criar um `NgModule` só para fazer lazy load.

## 1.9 Organização de Projeto Recomendada

```text
src/app/
├── core/                 # Singletons, interceptors, guards
├── shared/               # Componentes, pipes e diretivas realmente reutilizáveis
├── features/
│   ├── products/
│   │   ├── product-list.ts
│   │   ├── product-detail.ts
│   │   ├── product-form.ts
│   │   ├── product.service.ts
│   │   └── products.routes.ts
│   └── orders/
├── layout/
├── app.config.ts
├── app.routes.ts
└── app.ts
```

## 1.10 Comparação Standalone vs NgModules

| Aspecto                    | NgModules                          | Standalone                          |
|---------------------------|------------------------------------|-------------------------------------|
| Declaração de dependências| Indireta (via módulo)             | Explícita no componente             |
| Tree-shaking              | Mais difícil                      | Muito melhor                        |
| Lazy loading              | Precisa de módulo                 | Direto com `loadComponent`          |
| Curva de aprendizado      | Alta                              | Baixa                               |
| Boilerplate               | Alto                              | Baixo                               |
| Análise estática          | Limitada                          | Excelente                           |
| Status em Angular 22      | Legado                            | **Padrão oficial**                  |

## 1.11 Vantagens

- Código mais limpo e localizado
- Menos arquivos
- Melhor tree-shaking
- Lazy loading mais simples
- Melhor DX e onboarding
- Facilita micro-frontends e Web Components

## 1.12 Limitações e armadilhas

- Bibliotecas antigas que ainda exportam apenas NgModules exigem `importProvidersFrom()` ou `importProvidersFrom(SomeModule)`.
- Durante a migração é comum esquecer `standalone: false` em componentes que ainda estão em NgModules.
- O schematic `ng generate @angular/core:standalone` resolve a maior parte dos casos, mas projetos muito complexos precisam de revisão manual.

## 1.13 Exemplo prático (estrutura de um CRUD standalone)

```ts
// features/clients/client-list.ts
@Component({
  selector: 'app-client-list',
  imports: [RouterLink, DatePipe],
  template: `
    @for (client of clients(); track client.id) {
      <div>{{ client.name }} – {{ client.createdAt | date }}</div>
    }
  `
})
export class ClientList {
  private service = inject(ClientService);
  clients = signal<Client[]>([]);
  // ...
}
```

---

# 2. Angular Signals

## 2.1 O que são Signals

**Signal** é a primitiva reativa oficial do Angular.  
É um wrapper em torno de um valor que **notifica automaticamente** interessados quando o valor muda.

```ts
const count = signal(0);
count();          // ler (0)
count.set(1);     // escrever
count.update(v => v + 1);
```

### História e motivação

- Angular historicamente dependia de Zone.js para descobrir **quando** o estado poderia ter mudado.
- Zone.js patchava APIs assíncronas do browser e disparava Change Detection de forma ampla.
- Isso gerava ciclos desnecessários e dificultava a interoperabilidade com outros frameworks.
- Signals permitem reatividade **precisa e síncrona**, sem precisar de Zone.js.

Evolução:

| Versão | Status dos Signals |
|--------|--------------------|
| 16 | Developer Preview |
| 17 | Ampliação (inputs, queries) |
| 18–19 | Mais APIs |
| 20 | `effect`, `linkedSignal`, `toSignal` **stable** |
| 21 | Signal Forms experimental |
| **22** | Signal Forms + `resource`/`httpResource` **stable** |

## 2.2 Problemas que os Signals resolvem

- Change Detection excessivo (Zone.js)
- Dificuldade de saber **exatamente** o que mudou
- Stack traces confusos
- Bundle maior (Zone.js)
- Interoperabilidade ruim com outros sistemas reativos

## 2.3 Funcionamento interno (visão simplificada)

1. Ao ler um signal dentro de um `computed` ou `effect`, o Angular registra uma dependência.
2. Quando o signal é alterado (`set`/`update`), o grafo de dependências é invalidado.
3. Apenas os computeds e effects que realmente dependem daquele signal são reavaliados.
4. O Change Detection (especialmente em modo zoneless + OnPush) se torna muito mais preciso.

## 2.4 Principais APIs

```ts
import {
  signal,
  computed,
  effect,
  linkedSignal,
  resource,
  untracked,
  asReadonly
} from '@angular/core';

// Estado gravável
const user = signal<User | null>(null);

// Estado derivado (somente leitura)
const displayName = computed(() => user()?.name ?? 'Anônimo');

// Efeito colateral
effect(() => {
  console.log('Usuário atual:', user());
});

// Sinal ligado a outro (writable + reset automático)
const selectedId = linkedSignal(() => items()[0]?.id);

// Recurso assíncrono (stable em 22)
const userResource = resource({
  params: () => ({ id: userId() }),
  loader: ({ params }) => fetchUser(params.id)
});
```

## 2.5 Métodos principais

| Método | Uso |
|--------|-----|
| `set(value)` | Substitui o valor |
| `update(fn)` | Atualiza com base no valor anterior |
| `asReadonly()` | Retorna uma versão somente leitura |
| `mutate()` | (legado / menos usado) mutação interna |

## 2.6 Signals vs RxJS

| Situação                        | Recomendação          |
|---------------------------------|-----------------------|
| Estado local de componente      | **Signals**           |
| Streams complexos, operadores, retry, debounce, combinação de múltiplas fontes | **RxJS** |
| Resultado de HTTP simples       | `httpResource` ou `toSignal(http.get(...))` |
| Comunicação entre features distantes | RxJS Subject ou signal + service |

Signals e RxJS **não são inimigos** – eles se complementam.

## 2.7 Integração com o restante do Angular

- **Forms**: Signal Forms (stable em 22)
- **HTTP**: `httpResource` (stable em 22)
- **Router**: inputs de rota podem ser signals
- **Components**: `input()`, `output()`, `model()` baseados em signals
- **Services**: signals como estado reativo compartilhado

## 2.8 Performance

Com Signals + Zoneless + OnPush (default em 22):

- Menos ciclos de Change Detection
- Atualizações granulares
- Melhor INP (Interaction to Next Paint)
- Bundle menor (sem Zone.js)

## 2.9 Casos de uso recomendados

**Use Signals quando:**
- Estado local de UI
- Estado derivado simples
- Comunicação pai → filho via `input()` / `model()`
- Resultado de recursos assíncronos simples (`resource` / `httpResource`)

**Continue com RxJS quando:**
- Streams complexos
- Operadores avançados
- WebSockets, Server-Sent Events
- Lógica de retry, circuit breaker, etc.

## 2.10 Erros comuns

1. Ler signal fora de contexto reativo e esperar atualização automática.
2. Criar effects que causam loops infinitos.
3. Usar `mutate` em objetos complexos sem entender a detecção de mudanças.
4. Misturar signals e Zone.js sem necessidade.

## 2.11 Exemplo de estado com Signals

```ts
@Component({...})
export class Cart {
  private cartService = inject(CartService);

  items = signal<CartItem[]>([]);
  total = computed(() =>
    this.items().reduce((sum, item) => sum + item.price * item.qty, 0)
  );

  add(item: CartItem) {
    this.items.update(list => [...list, item]);
  }
}
```

---

# 3. Vite

## 3.1 O que é Vite

**Vite** é um build tool e dev server criado por Evan You (criador do Vue).  
Ele se baseia em **ES Modules nativos** no desenvolvimento e usa Rollup (ou ESBuild em alguns fluxos) para produção.

## 3.2 Por que o Angular adotou Vite

- Startup do dev server extremamente rápido
- Hot Module Replacement (HMR) quase instantâneo
- Uso de ES Modules nativos no browser durante o desenvolvimento
- Melhor DX em projetos grandes

No Angular, o Vite é usado **principalmente no dev server** através do **Application Builder**.

## 3.3 Funcionamento no Angular

```text
ng serve
   │
   ▼
Application Builder
   │
   ├── Vite (dev server + HMR)
   └── ESBuild (transformações e bundling)
```

## 3.4 Comparações

| Ferramenta   | Startup | HMR     | Uso no Angular 22      |
|--------------|---------|---------|------------------------|
| Webpack      | Lento   | Bom     | Depreciado             |
| Vite         | Muito rápido | Excelente | **Dev server oficial** |
| Turbopack    | Muito rápido | Bom   | Não oficial            |
| Rspack       | Rápido  | Bom     | Não oficial            |

## 3.5 Configuração

Na maioria dos projetos **não é necessário configurar Vite manualmente**.  
O Application Builder (`@angular/build`) gerencia a integração.

## 3.6 Limitações

- Algumas features avançadas de Webpack (certos loaders legados) podem exigir configuração extra ou migração.
- Plugins de Vite comunitários nem sempre têm equivalente oficial no Angular.

---

# 4. ESBuild

## 4.1 O que é ESBuild

**ESBuild** é um bundler e minifier escrito em **Go** por Evan Wallace.  
É extremamente rápido (muitas vezes 10–100× mais rápido que Webpack/Terser em tarefas equivalentes).

## 4.2 Por que o Angular o adotou

- Velocidade de build de produção
- Velocidade de transformação no dev
- Tree-shaking eficiente
- Minificação de alta qualidade

## 4.3 Pipeline moderno do Angular

```text
Código TypeScript + Templates
         │
         ▼
   Angular Compiler (template type-checking, etc.)
         │
         ▼
      ESBuild
         │
         ├── Bundling
         ├── Tree-shaking
         └── Minificação
         │
         ▼
   Artefatos de produção
```

## 4.4 Comparações de desempenho (ordem de grandeza)

| Tarefa              | Webpack + Terser | ESBuild      |
|---------------------|------------------|--------------|
| Cold build          | 1×               | 10–40× mais rápido |
| Incremental         | 1×               | Muito mais rápido |
| Minificação         | 1×               | 10–30× mais rápido |

## 4.5 Configuração

Assim como o Vite, a configuração é gerenciada pelo **Application Builder**.  
A partir do Angular 17+ o caminho recomendado é:

```json
"builder": "@angular/build:application"
```

O antigo `@angular-devkit/build-angular:browser` (Webpack) está **depreciado** no Angular 22.

---

# 5. Server-Side Rendering (SSR)

## 5.1 O que é SSR

**Server-Side Rendering** significa que o Angular renderiza a aplicação **no servidor** e envia HTML já pronto para o browser.

```text
Browser → pede página
     ↓
Servidor Node (Angular Universal / Angular SSR)
     ↓
Renderiza componentes → gera HTML
     ↓
Envia HTML + estado transferido
     ↓
Browser mostra conteúdo imediatamente
     ↓
Hydration torna a página interativa
```

## 5.2 CSR vs SSR

| Aspecto           | CSR (Client-Side Rendering) | SSR                          |
|-------------------|-----------------------------|------------------------------|
| HTML inicial      | Quase vazio                 | Conteúdo completo            |
| SEO               | Mais difícil                | Excelente                    |
| FCP / LCP         | Pior                        | Melhor                       |
| TTFB              | Baixo                       | Um pouco mais alto           |
| Complexidade      | Menor                       | Maior                        |
| Quando usar       | Apps internos, dashboards   | Sites públicos, e-commerce, marketing |

## 5.3 Benefícios de performance e SEO

- Melhor **Largest Contentful Paint (LCP)**
- Melhor **First Contentful Paint (FCP)**
- Conteúdo indexável por buscadores
- Melhor experiência em redes lentas

## 5.4 Configuração moderna

```bash
ng new meu-app --ssr
```

Ou em projeto existente:

```bash
ng add @angular/ssr
```

Principais arquivos envolvidos:

- `server.ts`
- `app.config.server.ts`
- `main.server.ts`
- Configurações no `angular.json` (target `server` e `prerender`)

## 5.5 Hybrid Rendering (Angular 19+)

A partir do Angular 19/20 é possível definir **por rota** o modo de renderização:

```ts
export const serverRoutes: ServerRoute[] = [
  { path: '/login', renderMode: RenderMode.Server },
  { path: '/dashboard', renderMode: RenderMode.Client },
  { path: '/product/:id', renderMode: RenderMode.Prerender }
];
```

---

# 6. Hydration

## 6.1 O que é Hydration

**Hydration** é o processo pelo qual o Angular no browser **reutiliza** o HTML gerado no servidor, reconecta os event listeners e sincroniza o estado, em vez de destruir o DOM e renderizar tudo de novo.

## 6.2 Problema que resolve

Sem hydration o browser:

1. Recebe o HTML do servidor
2. Mostra o conteúdo
3. Baixa o JavaScript
4. **Destrói** o DOM existente
5. Renderiza tudo novamente do zero

Isso causa:
- Flash de conteúdo
- Trabalho duplicado
- Pior INP e CLS

Com hydration o Angular **reutiliza** os nós já existentes.

## 6.3 Event Replay

Enquanto o JavaScript ainda não carregou, o usuário pode clicar em botões.  
O **Event Replay** (stable desde Angular 19) grava esses eventos e os reproduz depois que a aplicação é hidratada.

```ts
provideClientHydration(withEventReplay())
```

## 6.4 Incremental Hydration (stable desde Angular 20)

Permite hidratar **partes** da página sob demanda:

```html
@defer (hydrate on viewport) {
  <app-heavy-chart />
}
```

Benefícios:
- Menor JavaScript inicial
- Hidratação sob demanda
- Melhor TTI e INP

## 6.5 Configuração

```ts
provideClientHydration(
  withIncrementalHydration(),
  withEventReplay(),
  withHttpTransferCache()
)
```

## 6.6 Comparação

| Cenário                    | Sem Hydration          | Com Hydration              | Com Incremental Hydration |
|---------------------------|------------------------|----------------------------|---------------------------|
| Tempo até interatividade  | Pior                   | Melhor                     | Ainda melhor              |
| Trabalho no main thread   | Alto (re-render)       | Baixo                      | Mais baixo ainda          |
| Complexidade              | Baixa                  | Média                      | Média-Alta                |

---

# 7. Comparação Geral das Tecnologias

| Tecnologia              | Problema que resolve                     | Substitui / Complementa          | Obrigatória? | Quando utilizar                  |
|-------------------------|------------------------------------------|----------------------------------|--------------|----------------------------------|
| Standalone Components   | Complexidade dos NgModules               | AppModule / Feature Modules      | **Sim** (default) | Sempre em projetos novos        |
| Signals                 | Reatividade precisa + menos Zone.js      | Parte do uso de RxJS             | Não          | Estado local e derivado         |
| Vite                    | Dev server lento                         | Webpack dev server               | Sim (via builder) | Sempre                          |
| ESBuild                 | Builds lentos                            | Webpack + Terser                 | Sim (via builder) | Sempre                          |
| SSR                     | SEO + HTML inicial vazio                 | CSR puro                         | Não          | Sites públicos, e-commerce      |
| Hydration               | Re-render desnecessário após SSR         | Renderização completa no cliente | Não          | Sempre que usar SSR             |

---

# 8. Fluxo da Nova Arquitetura Angular

```text
                    Código Fonte (Standalone + Signals)
                                    │
                                    ▼
                         Angular Compiler
                                    │
                    ┌───────────────┴───────────────┐
                    ▼                               ▼
            Vite (ng serve)                  ESBuild (ng build)
            Dev Server + HMR                 Bundle + Minify
                    │                               │
                    └───────────────┬───────────────┘
                                    ▼
                          Artefatos de produção
                                    │
                    ┌───────────────┴───────────────┐
                    ▼                               ▼
              SSR (opcional)                  CSR puro
                    │
                    ▼
            HTML + Estado transferido
                    │
                    ▼
                 Browser
                    │
                    ▼
               Hydration
         (Event Replay + Incremental)
                    │
                    ▼
          Aplicação totalmente interativa
```

---

# 9. Checklist de Migração para a Nova Arquitetura

- [ ] Migrar AppModule → `bootstrapApplication` + `app.config.ts`
- [ ] Converter componentes para Standalone
- [ ] Remover NgModules desnecessários
- [ ] Adotar Control Flow (`@if`, `@for`, `@defer`)
- [ ] Introduzir Signals para estado local
- [ ] Avaliar zoneless (`provideZonelessChangeDetection`)
- [ ] Garantir que o builder é `@angular/build:application`
- [ ] Configurar SSR se o caso de uso exigir
- [ ] Habilitar Hydration + Event Replay + Incremental Hydration
- [ ] Migrar testes para Vitest
- [ ] Remover dependências de `ng-reflect-*`
- [ ] Medir Core Web Vitals antes e depois
- [ ] Atualizar bibliotecas de terceiros incompatíveis com standalone / signals

---

## Resumo Final do Capítulo

A nova arquitetura do Angular (17→22) é construída sobre seis pilares:

1. **Standalone Components** → simplicidade e explicitação de dependências
2. **Signals** → reatividade precisa e caminho para zoneless
3. **Vite** → experiência de desenvolvimento extremamente rápida
4. **ESBuild** → builds de produção muito mais rápidos
5. **SSR** → HTML inicial e SEO
6. **Hydration** (incluindo Incremental + Event Replay) → reutilização inteligente do HTML do servidor

Juntas, essas tecnologias tornam o Angular mais simples de aprender, mais rápido de desenvolver e mais performático em produção.

---

**Referências oficiais**

- https://angular.dev/guide/components/importing
- https://angular.dev/guide/signals
- https://angular.dev/guide/ssr
- https://angular.dev/guide/hydration
- https://angular.dev/tools/cli/build
- https://blog.angular.dev (posts de v17 a v22)
- Angular Update Guide: https://angular.dev/update-guide
