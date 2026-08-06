# Guia Definitivo da Configuração Inicial do Angular Moderno
## Angular 17 → Angular 22

**Arquiteto de Software Sênior | Especialista em Angular, TypeScript e Arquitetura Front-end**

> Este documento responde de forma definitiva às perguntas mais comuns de configuração:
> - Onde importar Component / Directive / Pipe / Service?
> - Onde registrar Providers?
> - Onde configurar HttpClient, Router, Animations, SSR, Hydration, Service Worker?
> - Quando usar `imports` vs `providers` vs `inject()` vs `providedIn`?
>
> Baseado exclusivamente na documentação oficial, Update Guides e práticas recomendadas pelo time Angular (2023–2026).

---

## Sumário

1. [Estrutura Inicial do Projeto](#1-estrutura-inicial-do-projeto)
2. [Evolução da Estrutura entre as Versões](#2-evolução-da-estrutura-entre-as-versões)
3. [main.ts – Ponto de Entrada](#3-maints--ponto-de-entrada)
4. [app.config.ts – O Coração da Configuração](#4-appconfigts--o-coração-da-configuração)
5. [Onde Registrar cada tipo de Provider](#5-onde-registrar-cada-tipo-de-provider)
6. [Onde Importar Componentes, Diretivas e Pipes](#6-onde-importar-componentes-diretivas-e-pipes)
7. [Onde Importar e Registrar Services](#7-onde-importar-e-registrar-services)
8. [HttpClient – Configuração Completa](#8-httpclient--configuração-completa)
9. [Router – Configuração Completa](#9-router--configuração-completa)
10. [Animations](#10-animations)
11. [SSR, Hydration e Incremental Hydration](#11-ssr-hydration-e-incremental-hydration)
12. [Service Worker / PWA](#12-service-worker--pwa)
13. [Interceptors](#13-interceptors)
14. [Zone.js vs Zoneless](#14-zonejs-vs-zoneless)
15. [inject() vs Constructor Injection](#15-inject-vs-constructor-injection)
16. [providedIn vs providers array](#16-providedin-vs-providers-array)
17. [Tabela de Decisão Rápida](#17-tabela-de-decisão-rápida)
18. [Comparativo Angular 17 → 22 (Configuração)](#18-comparativo-angular-17--22-configuração)
19. [Boas Práticas Oficiais de Configuração](#19-boas-práticas-oficiais-de-configuração)
20. [Checklist de Configuração Inicial](#20-checklist-de-configuração-inicial)

---

## 1. Estrutura Inicial do Projeto

Quando você executa `ng new meu-projeto` (Angular 21/22), a estrutura gerada é aproximadamente:

```text
meu-projeto/
├── public/                          # Assets estáticos (favicon, robots.txt, imagens públicas)
├── src/
│   ├── app/
│   │   ├── app.ts                   # Componente raiz (sem suffix .component a partir do 20)
│   │   ├── app.html
│   │   ├── app.scss
│   │   ├── app.config.ts            # ★ Configuração central da aplicação
│   │   └── app.routes.ts            # Rotas da aplicação
│   ├── index.html
│   ├── main.ts                      # ★ Bootstrap da aplicação
│   └── styles.scss                  # Estilos globais
├── angular.json                     # Configuração do workspace e builders
├── package.json
├── tsconfig.json
├── tsconfig.app.json
├── tsconfig.spec.json
└── ...
```

### Função de cada peça-chave

| Arquivo / Pasta | Responsabilidade |
|-----------------|------------------|
| `main.ts` | Único ponto de entrada. Chama `bootstrapApplication`. |
| `app.config.ts` | Substitui o antigo `AppModule`. Contém **todos** os providers da aplicação. |
| `app.routes.ts` | Definição das rotas (passado para `provideRouter`). |
| `app.ts` | Componente raiz (`selector: 'app-root'`). |
| `angular.json` | Builders, styles, assets, budgets, configurações de serve/test. |
| `public/` | Arquivos que devem ser servidos na raiz do site (não passam pelo bundler). |
| `styles.scss` | Estilos globais (reset, variáveis CSS, temas). |

---

## 2. Evolução da Estrutura entre as Versões

| Aspecto | Angular 17 | Angular 18 | Angular 19 | Angular 20 | Angular 21 | Angular 22 |
|---------|------------|------------|------------|------------|------------|------------|
| `app.config.ts` | Já existia | Existia | Existia | Existia | Existia | Existia |
| Standalone default | Não | Não | **Sim** | Sim | Sim | Sim |
| Zone.js no polyfill | Sim | Sim | Sim | Sim | **Não (default)** | Não |
| Suffixes gerados pelo CLI | Sim | Sim | Sim | **Não** | Não | Não |
| Pasta `assets/` | Comum | Comum | Ainda existe | Ainda existe | Menos usada | Preferência por `public/` |
| Test runner default | Karma | Karma | Karma | Karma | **Vitest** | Vitest |
| Builder principal | Application Builder | Application Builder | Application Builder | Application Builder | `@angular/build` | `@angular/build` |

**Resumo da evolução:**
- Angular 17–18: transição para standalone + Application Builder.
- Angular 19: standalone se torna o default.
- Angular 20: Style Guide remove suffixes; OnPush começa a ser fortemente incentivado.
- Angular 21: zoneless se torna default em novos projetos + Vitest.
- Angular 22: OnPush default + Fetch como backend do HttpClient + TypeScript 6.

---

## 3. main.ts – Ponto de Entrada

### Forma moderna (Angular 17+)

```ts
import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';

bootstrapApplication(App, appConfig)
  .catch((err) => console.error(err));
```

### O que mudou ao longo das versões

| Versão | Mudança relevante |
|--------|-------------------|
| 17 | `bootstrapApplication` já era o caminho recomendado (em vez de `platformBrowserDynamic().bootstrapModule`) |
| 19 | Standalone se torna default → quase todos os apps novos usam apenas este padrão |
| 21 | Novos projetos já nascem sem Zone.js → `appConfig` já vem com `provideZonelessChangeDetection()` |
| 22 | Nenhuma mudança estrutural no `main.ts` |

**Regra de ouro:**  
Nunca coloque lógica de negócio ou providers no `main.ts`. Ele deve apenas bootstrapar.

---

## 4. app.config.ts – O Coração da Configuração

Este é o arquivo mais importante da configuração inicial moderna.

```ts
import { ApplicationConfig, provideZonelessChangeDetection } from '@angular/core';
import { provideRouter, withComponentInputBinding, withViewTransitions } from '@angular/router';
import { provideHttpClient, withFetch, withInterceptors } from '@angular/common/http';
import { provideClientHydration, withIncrementalHydration, withEventReplay } from '@angular/platform-browser';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideServiceWorker } from '@angular/service-worker';

import { routes } from './app.routes';
import { authInterceptor } from './core/interceptors/auth.interceptor';
import { errorInterceptor } from './core/interceptors/error.interceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    // 1. Change Detection
    provideZonelessChangeDetection(),

    // 2. Router
    provideRouter(
      routes,
      withComponentInputBinding(),
      withViewTransitions()
    ),

    // 3. HTTP
    provideHttpClient(
      withFetch(),                           // Angular 22 default
      withInterceptors([authInterceptor, errorInterceptor])
    ),

    // 4. Animações (carregadas de forma assíncrona)
    provideAnimationsAsync(),

    // 5. SSR / Hydration
    provideClientHydration(
      withIncrementalHydration(),
      withEventReplay()
    ),

    // 6. Service Worker (PWA) – apenas em produção
    provideServiceWorker('ngsw-worker.js', {
      enabled: !isDevMode(),
      registrationStrategy: 'registerWhenStable:30000'
    }),
  ]
};
```

### Por que tudo fica aqui?

No Angular antigo (NgModules) os providers ficavam espalhados em vários módulos (`AppModule`, `CoreModule`, `SharedModule`…).  
Com o modelo standalone + `ApplicationConfig`, **toda a configuração de aplicação** fica em um único lugar, facilitando:

- Tree-shaking
- Análise estática
- Onboarding de novos desenvolvedores
- Migração e auditoria

---

## 5. Onde Registrar cada tipo de Provider

| Tipo de Provider | Onde registrar | Exemplo |
|------------------|----------------|---------|
| **Singleton de aplicação** (AuthService, Logger, etc.) | `app.config.ts` **ou** `providedIn: 'root'` | `providedIn: 'root'` é o mais comum |
| **Interceptor HTTP** | `provideHttpClient(withInterceptors([...]))` dentro de `app.config.ts` | Functional interceptors |
| **Router** | `provideRouter(routes, ...)` em `app.config.ts` | - |
| **HttpClient** | `provideHttpClient(...)` em `app.config.ts` | - |
| **Animações** | `provideAnimationsAsync()` ou `provideAnimations()` | Preferir Async |
| **Hydration / SSR** | `provideClientHydration(...)` | - |
| **Service Worker** | `provideServiceWorker(...)` | - |
| **Provider de feature** (só usado em uma rota) | Na rota (`providers: [...]`) ou no componente | Escopo limitado |
| **Provider de componente** | No decorator `@Component({ providers: [...] })` | Nova instância por componente |

### Regra prática

1. Se o serviço deve existir **uma única vez** na aplicação → `providedIn: 'root'` ou `app.config.ts`.
2. Se o serviço deve existir **apenas enquanto a rota estiver ativa** → `providers` na rota.
3. Se o serviço deve existir **apenas enquanto o componente existir** → `providers` no `@Component`.

---

## 6. Onde Importar Componentes, Diretivas e Pipes

### Regra fundamental (Angular 19+)

> **Cada componente standalone declara explicitamente no array `imports` tudo o que seu template utiliza.**

```ts
import { Component } from '@angular/core';
import { NgClass, DatePipe, CurrencyPipe } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { MeuBotao } from '../shared/meu-botao';

@Component({
  selector: 'app-exemplo',
  imports: [
    NgClass,
    DatePipe,
    CurrencyPipe,
    RouterLink,
    RouterOutlet,
    ReactiveFormsModule,
    MeuBotao          // componente standalone
  ],
  template: `...`
})
export class Exemplo {}
```

### O que NÃO precisa ser importado

| Item | Motivo |
|------|--------|
| Control Flow (`@if`, `@for`, `@switch`, `@defer`) | Nativo do template desde Angular 17/18 |
| Signals (`signal()`, `computed()`, etc.) | Funções do `@angular/core` – import no TypeScript, não no template |
| `inject()` | Função do `@angular/core` |

### Pipes comuns e de onde vêm

| Pipe | Import de |
|------|-----------|
| `DatePipe`, `CurrencyPipe`, `JsonPipe`, `AsyncPipe`, `UpperCasePipe`… | `@angular/common` |
| Pipes customizados | Do arquivo onde foram declarados (e o pipe deve ser standalone) |

### Diretivas comuns

| Diretiva | Import de |
|----------|-----------|
| `NgClass`, `NgStyle` | `@angular/common` |
| `RouterLink`, `RouterLinkActive`, `RouterOutlet` | `@angular/router` |
| `FormControl`, `FormGroup`, `ReactiveFormsModule` | `@angular/forms` |
| Diretivas de `@angular/aria` (v21+) | `@angular/aria` |

---

## 7. Onde Importar e Registrar Services

### Forma recomendada (99% dos casos)

```ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'          // ← registra automaticamente como singleton
})
export class ClienteService {
  // ...
}
```

### Quando NÃO usar `providedIn: 'root'`

- Serviço com estado que deve ser resetado ao sair de uma feature → registre na rota.
- Serviço que deve ter uma instância por componente → registre no `@Component({ providers: [...] })`.

### Como consumir o serviço

```ts
// Forma moderna (recomendada)
private clienteService = inject(ClienteService);

// Forma clássica (ainda válida)
constructor(private clienteService: ClienteService) {}
```

---

## 8. HttpClient – Configuração Completa

### Onde configurar

**Sempre** em `app.config.ts`:

```ts
provideHttpClient(
  withFetch(),                    // Angular 22 – usa Fetch API nativa
  withInterceptors([
    authInterceptor,
    loggingInterceptor,
    errorInterceptor
  ]),
  // withJsonpSupport(),         // depreciado no 22.1
)
```

### O que mudou

| Versão | Mudança |
|--------|---------|
| 15+ | `HttpClientModule` começa a ser substituído por `provideHttpClient()` |
| 17–21 | `provideHttpClient()` se torna o padrão |
| 22 | **Fetch** passa a ser o backend default (`withFetch()`) |
| 22.1 | JSONP depreciado |

### Interceptors funcionais (único estilo recomendado)

```ts
// core/interceptors/auth.interceptor.ts
import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const token = inject(AuthService).token();
  if (token) {
    req = req.clone({
      setHeaders: { Authorization: `Bearer ${token}` }
    });
  }
  return next(req);
};
```

**Não use mais** classes com `implements HttpInterceptor` em projetos novos.

---

## 9. Router – Configuração Completa

### Onde configurar

```ts
// app.config.ts
provideRouter(
  routes,
  withComponentInputBinding(),    // @Input() recebe parâmetros de rota automaticamente
  withViewTransitions(),          // Transições de view nativas
  withInMemoryScrolling({...}),
  // withDebugTracing(),          // só em desenvolvimento
)
```

### Onde definir as rotas

```ts
// app.routes.ts
export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {
    path: 'clientes',
    loadChildren: () => import('./features/clientes/routes').then(m => m.CLIENTES_ROUTES)
  }
];
```

### Functional Guards (recomendado)

```ts
export const authGuard: CanActivateFn = () => {
  const auth = inject(AuthService);
  return auth.isAuthenticated() ? true : inject(Router).createUrlTree(['/login']);
};
```

---

## 10. Animations

```ts
// app.config.ts
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

providers: [
  provideAnimationsAsync()     // ← forma recomendada (lazy)
  // provideAnimations()       // forma síncrona (carrega tudo no bundle principal)
]
```

**Por que Async?**  
Reduz o tamanho do bundle inicial. As animações só são carregadas quando realmente usadas.

---

## 11. SSR, Hydration e Incremental Hydration

```ts
import {
  provideClientHydration,
  withIncrementalHydration,
  withEventReplay,
  withHttpTransferCache
} from '@angular/platform-browser';

providers: [
  provideClientHydration(
    withIncrementalHydration(),      // stable desde Angular 20
    withEventReplay(),               // stable desde Angular 19
    withHttpTransferCache({
      includeRequestsWithAuthHeaders: true
    })
  )
]
```

### Onde mais se configura SSR?

- `angular.json` → target `server` e `app-shell` / prerender
- Rotas com `RenderMode` (Server, Client, Prerender) – feature stable desde Angular 20

---

## 12. Service Worker / PWA

```ts
import { provideServiceWorker } from '@angular/service-worker';
import { isDevMode } from '@angular/core';

providers: [
  provideServiceWorker('ngsw-worker.js', {
    enabled: !isDevMode(),
    registrationStrategy: 'registerWhenStable:30000'
  })
]
```

Também é necessário:
- `@angular/service-worker` no `package.json`
- `ngsw-config.json`
- Build com configuração de service worker habilitada

---

## 13. Interceptors

**Local recomendado:** pasta `core/interceptors/`

**Registro:** exclusivamente via `withInterceptors([...])` dentro de `provideHttpClient()` no `app.config.ts`.

Nunca registre interceptors em componentes ou em módulos de feature (a não ser que seja um caso muito específico de escopo limitado).

---

## 14. Zone.js vs Zoneless

| Situação | Configuração |
|----------|--------------|
| **Novo projeto (Angular 21+)** | `provideZonelessChangeDetection()` (já vem por default) |
| **Projeto antigo que ainda precisa de Zone.js** | `provideZoneChangeDetection()` (agora é **explícito**) |
| **Migração gradual** | Comece com zoneless + Signals; mantenha Zone apenas onde necessário |

```ts
// Angular 21+ – se ainda quiser Zone.js
provideZoneChangeDetection({
  eventCoalescing: true,
  runCoalescing: true
})
```

---

## 15. inject() vs Constructor Injection

| Cenário | Recomendação |
|---------|--------------|
| Componentes, Services, Diretivas | Ambos são válidos. `inject()` é mais conciso. |
| **Guards, Interceptors, Resolvers, Functions** | **Obrigatório usar `inject()`** (não há constructor) |
| Testes | `inject()` também funciona muito bem |

```ts
// Moderno e limpo
export class ClienteList {
  private service = inject(ClienteService);
  private router = inject(Router);
}
```

---

## 16. providedIn vs providers array

| Forma | Quando usar |
|-------|-------------|
| `providedIn: 'root'` | Singleton de aplicação (padrão para 95% dos services) |
| `providedIn: 'platform'` | Extremamente raro (compartilhar entre múltiplas apps no mesmo page) |
| `providers: []` no `app.config.ts` | Quando você precisa de configuração extra ou de uma factory |
| `providers: []` na rota | Escopo da rota (destruído ao sair da rota) |
| `providers: []` no componente | Uma instância por instância do componente |

---

## 17. Tabela de Decisão Rápida

| Eu quero… | Onde faço? |
|-----------|------------|
| Importar um Pipe / Diretiva / Componente no template | `imports: []` do componente standalone |
| Registrar um Service singleton | `providedIn: 'root'` ou `app.config.ts` |
| Configurar HttpClient | `provideHttpClient(...)` em `app.config.ts` |
| Configurar Router | `provideRouter(...)` em `app.config.ts` |
| Registrar Interceptor | `withInterceptors([...])` dentro de `provideHttpClient` |
| Configurar Animações | `provideAnimationsAsync()` em `app.config.ts` |
| Configurar Hydration / SSR | `provideClientHydration(...)` em `app.config.ts` |
| Configurar Service Worker | `provideServiceWorker(...)` em `app.config.ts` |
| Usar um Service dentro de um Guard/Interceptor | `inject(MeuService)` |
| Ter um Service só em uma feature | `providers` na rota da feature |
| Usar Control Flow (`@if`, `@for`) | Nada – é nativo do template |
| Usar Signals | Importar de `@angular/core` no arquivo `.ts` |

---

## 18. Comparativo Angular 17 → 22 (Configuração)

| Item de Configuração | 17 | 19 | 21 | 22 |
|----------------------|----|----|----|----|
| Local dos providers | `app.config.ts` já existia | Idem | Idem | Idem |
| Standalone | Opcional | **Default** | Default | Default |
| Zone.js | Implícito | Implícito | **Explícito / ausente** | Ausente por default |
| HttpClient | `provideHttpClient` | Idem | Idem | + `withFetch()` default |
| Interceptors | Functional já existia | Idem | Idem | Idem |
| Animações | `provideAnimations` | Idem | Preferir Async | Preferir Async |
| Hydration | Básica | + Event Replay | + Incremental | Stable + polida |
| Test runner | Karma | Karma | **Vitest** | Vitest |
| Change Detection default | Default | Default | Default | **OnPush** |

---

## 19. Boas Práticas Oficiais de Configuração

1. **Um único `app.config.ts`** – não espalhe providers.
2. **Functional providers e interceptors** – evite classes antigas.
3. **`providedIn: 'root'`** para a grande maioria dos services.
4. **`inject()`** em guards, interceptors e onde não houver constructor.
5. **Standalone + imports explícitos** – nunca dependa de NgModules legados em código novo.
6. **Zoneless + Signals** em projetos novos.
7. **`provideAnimationsAsync()`** em vez da versão síncrona.
8. **`withFetch()`** no HttpClient (Angular 22+).
9. **Control Flow nativo** – não use mais `*ngIf` / `*ngFor` em código novo.
10. **Feature-based folders** + lazy loading com `loadComponent` / `loadChildren`.

---

## 20. Checklist de Configuração Inicial

- [ ] `main.ts` apenas chama `bootstrapApplication`
- [ ] Todos os providers estão em `app.config.ts`
- [ ] `provideZonelessChangeDetection()` (ou `provideZoneChangeDetection()` se necessário)
- [ ] `provideRouter(routes, withComponentInputBinding())`
- [ ] `provideHttpClient(withFetch(), withInterceptors([...]))`
- [ ] `provideAnimationsAsync()` (se usar animações)
- [ ] `provideClientHydration(...)` (se usar SSR)
- [ ] Services com `providedIn: 'root'`
- [ ] Interceptors funcionais
- [ ] Componentes standalone com `imports` explícitos
- [ ] Nenhum `HttpClientModule` ou `BrowserModule` legado
- [ ] Nenhum `*ngIf` / `*ngFor` em templates novos
- [ ] Vitest configurado (Angular 21+)
- [ ] TypeScript na versão mínima exigida pela major atual

---

**Fim do documento.**

Este guia deve ser usado como material de consulta rápida sempre que surgir a dúvida:

> “Onde eu configuro / importo / registro isso no Angular moderno?”
