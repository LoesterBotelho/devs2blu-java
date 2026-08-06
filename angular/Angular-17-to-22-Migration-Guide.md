# Angular 17 → Angular 22
## Guia Definitivo de Migração

**Autor:** Arquiteto de Software especialista em Angular e TypeScript  
**Baseado em:** Documentação oficial (angular.dev), Release Notes oficiais, Update Guides e blogs oficiais do time Angular (Google).  
**Data de referência:** Agosto 2026 (Angular 22.1.x estável)

> **Aviso importante:** Este documento é extremamente detalhado e técnico. Não resume. Cada alteração é explicada com contexto, motivo, exemplos de código ANTES/DEPOIS e impacto na migração.

---

## Sumário

- [Visão Geral](#visão-geral)
- [Linha do Tempo](#linha-do-tempo)
- [Mudanças por versão](#mudanças-por-versão)
  - [Angular 18](#angular-18)
  - [Angular 19](#angular-19)
  - [Angular 20](#angular-20)
  - [Angular 21](#angular-21)
  - [Angular 22](#angular-22)
- [Breaking Changes](#breaking-changes-consolidadas)
- [Novos Recursos](#novos-recursos-consolidados)
- [Recursos Removidos / Depreciados](#recursos-removidos--depreciados)
- [Alterações no Angular CLI](#alterações-no-angular-cli)
- [Alterações do Workspace](#alterações-do-workspace)
- [Mudanças na Configuração Inicial](#mudanças-na-configuração-inicial-do-projeto-ng-new)
- [Mudanças no Bootstrap](#mudanças-no-bootstrap)
- [Mudanças em Standalone Components](#mudanças-em-standalone-components)
- [Mudanças em Signals](#mudanças-em-signals)
- [Mudanças em Control Flow](#mudanças-em-control-flow)
- [Mudanças em SSR](#mudanças-em-ssr)
- [Mudanças em Hydration](#mudanças-em-hydration)
- [Mudanças em Router](#mudanças-em-router)
- [Mudanças em Forms](#mudanças-em-forms)
- [Mudanças em HttpClient](#mudanças-em-httpclient)
- [Mudanças em Builder / Build System](#mudanças-em-builder--build-system)
- [Mudanças em Testes](#mudanças-em-testes)
- [Mudanças em RxJS](#mudanças-em-rxjs)
- [Mudanças em TypeScript](#mudanças-em-typescript)
- [Mudanças em Zone.js](#mudanças-em-zonejs)
- [Mudanças em Vite / ESBuild](#mudanças-em-vite--esbuild)
- [Mudanças no package.json](#mudanças-no-packagejson)
- [Mudanças no angular.json](#mudanças-no-angularjson)
- [Mudanças no tsconfig](#mudanças-no-tsconfig)
- [Mudanças no main.ts](#mudanças-no-maints)
- [Mudanças no app.config.ts](#mudanças-no-appconfigts)
- [Mudanças no app.routes.ts](#mudanças-no-approutests)
- [Mudanças na estrutura de diretórios](#mudanças-na-estrutura-de-diretórios)
- [Como migrar um projeto Angular 17 para Angular 22](#como-migrar-um-projeto-angular-17-para-angular-22)
- [Checklist de Migração](#checklist-de-migração)

---

## Visão Geral

Entre Angular 17 (novembro de 2023) e Angular 22 (junho de 2026) o framework sofreu a maior transformação estrutural da sua história moderna.

Principais eixos de evolução:

1. **Reatividade moderna com Signals** → de experimental a estável e dominante.
2. **Zoneless Change Detection** → de experimental (v18) a default em novos projetos (v21+) e fortemente incentivado.
3. **Standalone Components** → de opcional a **default** (v19).
4. **Control Flow nativo** (`@if`, `@for`, `@switch`, `@defer`) → de preview a estável e substituto oficial de `*ngIf`/`*ngFor`.
5. **SSR + Hydration avançada** → Incremental Hydration, route-level render modes, event replay.
6. **Forms** → introdução e estabilização de **Signal Forms**.
7. **Acessibilidade** → pacote `@angular/aria` (headless).
8. **Build system** → migração completa para Application Builder baseado em ESBuild + Vite.
9. **Testes** → Vitest substitui Karma/Jasmine como default.
10. **Ciclo de releases** → a partir de v22, major releases passam a ser **anuais** (junho), com suporte de 24 meses.

O objetivo final do time Angular é: **framework mais performático, mais tipado, mais ergonomico, menos dependente de Zone.js e mais alinhado com o futuro da web (Signals nativos no TC39, Fetch API, etc.)**.

---

## Linha do Tempo

| Versão | Data de lançamento | Status atual (ago/2026) | Principais destaques |
|--------|--------------------|--------------------------|----------------------|
| **17** | 08 Nov 2023 | EOL (fim de suporte maio/2025) | Signals DP, Control Flow DP, Deferrable Views DP, Hydration estável, novo logo, angular.dev em construção |
| **18** | 22 Mai 2024 | EOL | Zoneless experimental, Control Flow + Defer estáveis, Material 3 estável, angular.dev oficial, coalescing default |
| **19** | 19 Nov 2024 | EOL (maio/2026) | Standalone **default**, Signal inputs/outputs/queries estáveis, `linkedSignal` + `resource` experimentais, Incremental Hydration DP |
| **20** | 28 Mai 2025 | LTS (até nov/2026) | `effect`/`linkedSignal`/`toSignal` estáveis, Zoneless DP, Incremental Hydration + Route Render Mode estáveis, Style Guide sem suffixes, `*ngIf`/`*ngFor` depreciados |
| **21** | 19 Nov 2025 | LTS (até jun/2027) | Signal Forms experimental, `@angular/aria` DP, Vitest default, Zoneless **default em novos projetos**, MCP Server |
| **22** | 03 Jun 2026 | **Active** | Signal Forms + Aria + `resource`/`httpResource` **estáveis**, OnPush default, HttpClient usa Fetch por default, TypeScript 6, Node ≥22, major anual |

---

# Mudanças por versão

# Angular 18

## Novidades

- **Experimental Zoneless Change Detection** (`provideExperimentalZonelessChangeDetection()`).
- **Control Flow** (`@if`, `@for`, `@switch`, `@defer`) graduado para **stable**.
- **Deferrable Views** (`@defer`) graduado para **stable**.
- **Angular Material 3** graduado para **stable**.
- **angular.dev** se torna o site oficial de documentação (angular.io redireciona).
- **Event Coalescing** habilitado por default em novos projetos zone-based.
- **Event Replay** (powered by event-dispatch / jsaction) em developer preview para hydration.
- **i18n Hydration** em developer preview.
- Unificação do scheduler entre apps zoneless e zone-based com coalescing.
- Signal Inputs, Signal Queries e novo output syntax continuam em developer preview (introduzidos em 17.1/17.2).

## Breaking Changes

- `async` de `@angular/core` → substituído por `waitForAsync`.
- `matchesElement` removido de `AnimationDriver`.
- `StateKey` e `TransferState` devem ser importados de `@angular/core` (não mais de `@angular/platform-browser`).
- `isPlatformWorkerUi` e `isPlatformWorkerApp` removidos (plataforma WebWorker removida).
- Node.js mínimo: **18.19.0+**.
- TypeScript mínimo: **5.4**.

### Exemplo de migração de `async`:

**Antes (Angular 17):**
```ts
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

beforeEach(async(() => {
  TestBed.configureTestingModule({...}).compileComponents();
}));
```

**Depois (Angular 18+):**
```ts
import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';

beforeEach(waitForAsync(() => {
  TestBed.configureTestingModule({...}).compileComponents();
}));
```

## Recursos novos

- `provideExperimentalZonelessChangeDetection()`
- `withEventReplay()` em `provideClientHydration`
- Material 3 theming APIs estáveis
- Fallback content para `ng-content`
- Unified control state change events (`AbstractControl.events`)
- Route redirect functions

## Recursos depreciados

- `HttpClientModule` (use `provideHttpClient()`)
- Alguns factories legados do Router

## Recursos removidos

- Plataforma WebWorker completa
- `matchesElement` de AnimationDriver

## Melhorias de performance

- Event coalescing por default → menos ciclos de change detection
- Scheduler unificado
- Native `async/await` em apps zoneless (sem downlevel para Promise)

## Mudanças na CLI

- Novos projetos já nascem com coalescing habilitado
- Melhor suporte a zoneless (remoção automática de zone.js polyfill quando solicitado)

## Mudanças no Build

- Continuação da consolidação do Application Builder (ESBuild)

## Mudanças no SSR

- Event Replay (DP)
- i18n hydration (DP)
- Melhor debugging de hydration no DevTools

## Mudanças no Router

- Redirect functions
- Melhorias internas de tipagem

## Mudanças em Signals

- Continuação do developer preview de inputs/outputs/queries baseados em signals

## Mudanças em Standalone

- Nenhuma breaking change grande; standalone continua opcional

## Mudanças em Forms

- Unified control events (`AbstractControl.events`)

## Mudanças em Testes

- Testes podem executar rounds extras de change detection
- Opção de fallback: `provideZoneChangeDetection({ignoreChangesOutsideZone: true})`

## Exemplos

### Zoneless experimental

**Angular 18:**
```ts
import { bootstrapApplication } from '@angular/platform-browser';
import { provideExperimentalZonelessChangeDetection } from '@angular/core';
import { AppComponent } from './app/app.component';

bootstrapApplication(AppComponent, {
  providers: [
    provideExperimentalZonelessChangeDetection()
  ]
});
```

Remova `zone.js` dos polyfills no `angular.json`.

---

# Angular 19

## Novidades

- **Standalone Components, Directives e Pipes são agora o default** (`standalone: true` implícito).
- Signal-based **inputs**, **outputs** e **view queries** graduados para **stable**.
- `@let` syntax graduado para **stable**.
- **Event Replay** graduado para **stable**.
- **Incremental Hydration** em developer preview.
- **Hybrid rendering** com server route configuration (route-level render mode).
- Novos primitivos reativos: `linkedSignal` (DP) e `resource` (experimental).
- HMR para styles habilitado por default.
- Schematics para modernização (inputs, outputs, queries, inject, novo build system).
- Reporting de unused imports em standalone components.
- Timepicker component (Material).
- Two-dimensional drag-and-drop no CDK.

## Breaking Changes

- Componentes/Directives/Pipes agora são standalone por default. Código em NgModules precisa de `standalone: false`.
- TypeScript mínimo: **5.5**.
- `BrowserModule.withServerTransition()` removido → use `APP_ID` token.
- `Router.errorHandler` → migrar para `withNavigationErrorHandler`.
- Timing changes no `effect` API (ainda DP).
- `this.foo` em templates não resolve mais variáveis de template context (use sem `this.`).

### Exemplo Standalone default

**Antes (Angular 17/18 – explícito):**
```ts
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  template: `...`
})
export class AppComponent {}
```

**Angular 19+ (standalone é default):**
```ts
@Component({
  selector: 'app-root',
  imports: [CommonModule], // standalone: true é implícito
  template: `...`
})
export class AppComponent {}
```

**Para manter em NgModule:**
```ts
@Component({
  selector: 'app-legacy',
  standalone: false, // agora obrigatório se estiver em NgModule
  template: `...`
})
export class LegacyComponent {}
```

O `ng update` aplica automaticamente `standalone: false` onde necessário.

## Recursos novos

- `linkedSignal`
- `resource()` (experimental)
- Incremental Hydration (DP)
- Server route config (`RenderMode.Server | Client | Prerender`)
- `@let` estável
- Unused imports reporting

## Recursos depreciados

- Continua a depreciação de `HttpClientModule`

## Recursos removidos

- `BrowserModule.withServerTransition()`
- Algumas factories legadas

## Melhorias de performance

- Event Replay estável → melhor TTI em apps SSR
- HMR de styles
- Incremental Hydration (ainda DP)

## Mudanças na CLI

- Schematics de modernização mais poderosos
- Unused import detection

## Mudanças no Build

- Melhor integração com o novo Application Builder

## Mudanças no SSR

- Incremental Hydration (DP)
- Route-level render modes
- Event Replay estável

## Mudanças no Router

- `withNavigationErrorHandler`
- Server route configuration

## Mudanças em Signals

- Inputs/Outputs/Queries estáveis
- `linkedSignal` e `resource` introduzidos

## Mudanças em Standalone

- **Torna-se o default**

## Mudanças em Forms

- Nenhuma grande mudança estrutural (ainda Reactive + Template-driven)

## Mudanças em Testes

- Timing de effects alterado

## Exemplos

### linkedSignal (Angular 19+)

```ts
import { signal, linkedSignal } from '@angular/core';

const items = signal([{id: 1, name: 'A'}, {id: 2, name: 'B'}]);
const selectedId = signal(1);

const selectedItem = linkedSignal({
  source: items,
  computation: (list) => list.find(i => i.id === selectedId()) ?? list[0]
});
```

---

# Angular 20

## Novidades

- `effect`, `linkedSignal`, `toSignal`, `toObservable` graduados para **stable**.
- **Zoneless** promovido para **Developer Preview**.
- **Incremental Hydration** e **Route-level Render Mode** graduados para **stable**.
- Style Guide atualizado: **CLI não gera mais suffixes** (`.component.ts`, `.service.ts`, etc.) por default.
- Template literals, operador `**` (exponentiation), `void` e `in` suportados em templates.
- Type checking para host bindings.
- Template HMR habilitado por default.
- `ng-reflect-*` attributes **não são mais emitidos** em dev mode por default.
- `resource` e `httpResource` continuam experimentais (com streaming).
- Parceria com Chrome DevTools: Angular track no Performance panel.

## Breaking Changes

- TypeScript mínimo: **5.8**.
- Node.js mínimo: **20.11.1** (ou 22.11+/24+). Node 18 removido.
- `TestBed.flushEffects()` removido → use `TestBed.tick()`.
- `afterRender` → renomeado para `afterEveryRender`.
- `provideExperimentalCheckNoChangesForDebug` → `provideCheckNoChangesConfig`.
- `ng-reflect-*` removidos do DOM em dev mode (quebra testes que dependiam deles).
- `TestBed.get()` removido (já depreciado desde v9).
- `InjectFlags` enum removido.
- View Engine metadata completamente removido.
- `*ngIf`, `*ngFor`, `*ngSwitch` **depreciados** (remoção planejada para v22).

### Exemplo de Style Guide (sem suffixes)

**Angular 17–19 (gerado pelo CLI):**
```
src/app/user/user.component.ts
src/app/user/user.service.ts
src/app/user/user.model.ts
```

**Angular 20+ (default do CLI):**
```
src/app/user/user.ts
src/app/user/user-service.ts   // ou apenas user.ts com service dentro
src/app/user/user-model.ts
```

Você ainda pode forçar suffixes via schematics options se desejar.

## Recursos novos

- Template literals em templates
- Host binding type checking
- Chrome DevTools Angular performance track
- `httpResource` (experimental)
- Streaming resources

## Recursos depreciados

- `*ngIf`, `*ngFor`, `*ngSwitch` (use control flow)
- HammerJS integration

## Recursos removidos

- `TestBed.flushEffects`
- `TestBed.get`
- `InjectFlags`
- View Engine

## Melhorias de performance

- Zoneless mais maduro
- Incremental Hydration estável
- Menos ruído no DOM (sem ng-reflect)

## Mudanças na CLI

- Não gera suffixes por default
- Template HMR default
- Melhor diagnóstico de unused imports e nullish coalescing inválido

## Mudanças no Build

- Consolidação contínua do ESBuild/Vite based builder

## Mudanças no SSR

- Incremental Hydration estável
- Route render mode estável

## Mudanças no Router

- Route-level render mode estável
- Melhorias de tipagem e `abort()` em navegação

## Mudanças em Signals

- Primitivos principais agora **stable**
- `resource` / `httpResource` experimentais com streaming

## Mudanças em Standalone

- Continua sendo o default

## Mudanças em Forms

- Nenhuma mudança estrutural grande ainda

## Mudanças em Testes

- `TestBed.tick()` substitui `flushEffects`
- Fake timers mais visíveis para `fakeAsync`

## Exemplos

### afterRender → afterEveryRender

**Antes:**
```ts
afterRender(() => {
  // roda a cada render
});
```

**Depois:**
```ts
afterEveryRender(() => {
  // mesmo comportamento
});
```

---

# Angular 21

## Novidades

- **Signal Forms** (experimental) – nova API de formulários baseada em Signals.
- **`@angular/aria`** (Developer Preview) – headless accessibility primitives.
- **Vitest** se torna o **test runner default** (substitui Karma/Jasmine).
- **Zoneless** se torna o **default para novos projetos** criados com `ng new`.
- **Angular MCP Server** estável (ferramentas para LLMs/agentes de IA).
- Typed `SimpleChanges`.
- Wildcard routes com trailing segments.
- Mais ferramentas de migração (incluindo `onpush_zoneless_migration` via MCP).

## Breaking Changes

- TypeScript mínimo: **5.9**.
- Node.js: `^20.19.0 || ^22.12.0 || ^24.0.0`.
- Apps zone-based existentes precisam adicionar explicitamente `provideZoneChangeDetection()`.
- Host binding type checking **habilitado por default** (pode gerar novos erros de tipo).
- UpgradeAdapter removido.

### Exemplo – Zone-based apps agora precisam declarar

**Angular 21+ (se você ainda usa Zone.js):**
```ts
import { provideZoneChangeDetection } from '@angular/core';

bootstrapApplication(App, {
  providers: [
    provideZoneChangeDetection(), // agora obrigatório se quiser Zone.js
    // ...
  ]
});
```

Novos projetos já nascem **sem** Zone.js.

## Recursos novos

- Signal Forms (experimental)
- `@angular/aria` (DP)
- Vitest como default
- MCP Server
- Typed SimpleChanges

## Recursos depreciados

- Continua depreciação de structural directives clássicas
- Karma/Jasmine (ainda suportados, mas não default)

## Recursos removidos

- UpgradeAdapter

## Melhorias de performance

- Zoneless default em novos apps
- Vitest 5–10× mais rápido que Karma

## Mudanças na CLI

- `ng new` não inclui mais Zone.js por default
- Vitest configurado automaticamente
- Schematic de migração Jasmine → Vitest

## Mudanças no Build

- Melhorias no Application Builder

## Mudanças no SSR

- Continuidade das melhorias de Incremental Hydration

## Mudanças no Router

- Wildcard com trailing segments
- Experimental AutoCleanup de injectors

## Mudanças em Signals

- Signal Forms (experimental)
- Continuação de `resource`

## Mudanças em Standalone

- Continua default

## Mudanças em Forms

- **Signal Forms** introduzidos (experimental)

## Mudanças em Testes

- **Vitest** default
- Schematic de migração disponível

## Exemplos

### Signal Forms (experimental em 21, stable em 22)

```ts
import { signal } from '@angular/core';
import { form, required, FormField } from '@angular/forms/signals';

@Component({
  selector: 'app-payment',
  imports: [FormField],
  template: `
    <form>
      <select [formField]="f.paymentType">
        <option value="">Selecione...</option>
        <option value="credit">Cartão</option>
      </select>
      @if (f.paymentType().invalid() && f.paymentType().touched()) {
        <p>{{ f.paymentType().errors()[0].message }}</p>
      }
      <button [disabled]="f().invalid()">Enviar</button>
    </form>
  `
})
export class Payment {
  paymentModel = signal({ paymentType: '', amount: 0 });
  f = form(this.paymentModel, (schema) => {
    required(schema.paymentType, { message: 'Obrigatório' });
  });
}
```

---

# Angular 22

## Novidades

- **Signal Forms** graduado para **stable**.
- **`@angular/aria`** graduado para **stable**.
- **`resource` e `httpResource`** graduados para **stable**.
- **OnPush** se torna a **Change Detection Strategy default** para novos componentes.
- **HttpClient** usa a **Fetch API por default** (em vez de XMLHttpRequest).
- Template enhancements adicionais.
- **Ciclo de releases muda para major anual** (junho de cada ano).
- Suporte estendido: majors agora têm **24 meses** de suporte.
- TypeScript **6.0** requerido.
- Node.js mínimo sobe (Node 20 removido; Node 22+ e 26 suportados).
- Webpack / `@angular-devkit/build-angular` builders **depreciados**.
- Novas ferramentas de AI (MCP tools, Agent Skills, experimental WebMCP).

## Breaking Changes

- TypeScript < 6.0 **não suportado**.
- Node.js 20 **não suportado**.
- OnPush default → componentes antigos que dependiam de Default strategy podem precisar de ajuste explícito.
- HttpClient agora usa Fetch → algumas opções de XHR deixam de funcionar da mesma forma.
- Diagnósticos mais rigorosos de nullish coalescing e optional chaining.
- `data-*` attributes não fazem mais binding de inputs/outputs.
- Elementos com múltiplos selectors matching agora geram erro de compilação.
- JSONP support depreciado (em 22.1).

### Exemplo – OnPush default

**Antes (Angular ≤21):**
```ts
@Component({
  selector: 'app-user',
  template: `...`
  // changeDetection: ChangeDetectionStrategy.Default (implícito)
})
export class User {}
```

**Angular 22+:**
```ts
@Component({
  selector: 'app-user',
  template: `...`
  // changeDetection: ChangeDetectionStrategy.OnPush (agora default)
})
export class User {}
```

Para forçar Default (não recomendado):
```ts
changeDetection: ChangeDetectionStrategy.Default
```

## Recursos novos

- Signal Forms stable
- Angular Aria stable
- resource / httpResource stable
- OnPush default
- Fetch-based HttpClient
- Agent Skills + mais MCP tools
- Experimental WebMCP

## Recursos depreciados

- Webpack builders / `@angular-devkit/build-angular`
- JSONP (`withJsonpSupport`)
- Continua a depreciação de `*ngIf`/`*ngFor` (remoção iminente)

## Recursos removidos

- Vários APIs legados internos
- Suporte a TypeScript 5.x e Node 20

## Melhorias de performance

- OnPush default → menos change detection desnecessário
- Fetch API nativa
- Signals + zoneless como caminho principal

## Mudanças na CLI

- Novos projetos já nascem OnPush + zoneless + Vitest + Signal-friendly
- Webpack builders depreciados

## Mudanças no Build

- Foco total no Application Builder (ESBuild + Vite)
- Depreciação oficial do caminho Webpack

## Mudanças no SSR

- Continuidade e estabilização das features de v20/v21

## Mudanças no Router

- Melhorias de tipagem e integração com signals

## Mudanças em Signals

- Ecossistema completo estável (incluindo Forms e async resources)

## Mudanças em Standalone

- Continua default + OnPush default

## Mudanças em Forms

- **Signal Forms se tornam a recomendação principal**

## Mudanças em Testes

- Vitest consolidado
- Mais harnesses para Aria

## Exemplos

### httpResource (agora stable)

```ts
import { httpResource } from '@angular/common/http';
import { signal } from '@angular/core';

@Component({...})
export class Weather {
  city = signal('São Paulo');
  weather = httpResource(() => `https://api.example.com/weather/${this.city()}`);
}
```

---

# Breaking Changes Consolidadas (17 → 22)

| Área | Mudança | Versão | Ação necessária |
|------|---------|--------|-----------------|
| Standalone | Default `true` | 19 | Adicionar `standalone: false` em NgModule-based |
| Zone.js | Default em novos apps = zoneless | 21 | Adicionar `provideZoneChangeDetection()` se ainda usar Zone |
| Change Detection | OnPush default | 22 | Revisar componentes que dependiam de Default |
| Structural Directives | `*ngIf`/`*ngFor` depreciados | 20 | Migrar para `@if`/`@for` |
| TestBed | `flushEffects` → `tick` | 20 | Atualizar testes |
| TypeScript | 5.4 → 5.5 → 5.8 → 5.9 → **6.0** | 18→22 | Atualizar TS |
| Node.js | 18 → 20 → **22+** | 18→22 | Atualizar Node |
| HttpClient | Fetch default | 22 | Verificar interceptors e opções XHR-only |
| ng-reflect | Removido do DOM | 20 | Atualizar testes de DOM |
| Suffixes | CLI não gera mais | 20 | Atualizar convenções de nome |
| Webpack builders | Depreciados | 22 | Migrar para Application Builder |

---

# Novos Recursos Consolidados

| Recurso | Introduzido | Estável em |
|---------|-------------|------------|
| Signals (core) | 16 (DP) | 17–20 |
| Control Flow (`@if/@for`) | 17 (DP) | 18 |
| Deferrable Views | 17 (DP) | 18 |
| Signal Inputs/Outputs/Queries | 17.1/17.2 | 19 |
| Zoneless | 18 (exp) | 20 (DP) / 21 (default new) |
| linkedSignal | 19 | 20 |
| resource / httpResource | 19/20 | **22** |
| Incremental Hydration | 19 (DP) | 20 |
| Signal Forms | 21 (exp) | **22** |
| @angular/aria | 21 (DP) | **22** |
| Vitest default | 21 | 21 |
| OnPush default | 22 | 22 |

---

# Recursos Removidos / Depreciados

- `*ngIf`, `*ngFor`, `*ngSwitch` → depreciados (v20), remoção esperada em breve
- `HttpClientModule` → use functional providers
- Webpack-based builders → depreciados em v22
- JSONP support → depreciado em 22.1
- UpgradeAdapter → removido em v21
- Vários APIs de TestBed legados
- `ng-reflect-*` attributes
- Plataforma WebWorker
- View Engine

---

# Alterações no Angular CLI

- `ng new` evoluiu drasticamente (ver seção de configuração inicial).
- Schematics de modernização (`ng generate @angular/core:standalone`, etc.).
- Vitest como default a partir de v21.
- MCP Server integrado (`ng mcp`).
- Não gera mais suffixes a partir de v20.
- Application Builder (ESBuild + Vite) consolidado; Webpack depreciado em v22.

---

# Alterações do Workspace

- Estrutura de pastas mais limpa (sem `.component` etc.).
- `app.config.ts` se tornou o padrão de configuração (em vez de módulos).
- `main.ts` usa apenas `bootstrapApplication`.
- Polyfills reduzidos (especialmente sem Zone.js).
- Environments e browserslist simplificados.

---

# Mudanças na Configuração Inicial do Projeto (`ng new`)

Esta é uma das seções mais importantes. Abaixo a comparação completa entre um projeto gerado com Angular 17 e um gerado com Angular 22.

## package.json

**Angular 17 (exemplo típico):**
```json
{
  "dependencies": {
    "@angular/animations": "^17.0.0",
    "@angular/common": "^17.0.0",
    "@angular/compiler": "^17.0.0",
    "@angular/core": "^17.0.0",
    "@angular/forms": "^17.0.0",
    "@angular/platform-browser": "^17.0.0",
    "@angular/platform-browser-dynamic": "^17.0.0",
    "@angular/router": "^17.0.0",
    "rxjs": "~7.8.0",
    "tslib": "^2.3.0",
    "zone.js": "~0.14.0"
  },
  "devDependencies": {
    "@angular-devkit/build-angular": "^17.0.0",
    "@angular/cli": "^17.0.0",
    "@angular/compiler-cli": "^17.0.0",
    "@types/jasmine": "~5.1.0",
    "jasmine-core": "~5.1.0",
    "karma": "~6.4.0",
    "karma-chrome-launcher": "~3.2.0",
    "karma-coverage": "~2.2.0",
    "karma-jasmine": "~5.1.0",
    "karma-jasmine-html-reporter": "~2.1.0",
    "typescript": "~5.2.0"
  }
}
```

**Angular 22 (exemplo típico):**
```json
{
  "dependencies": {
    "@angular/common": "^22.0.0",
    "@angular/compiler": "^22.0.0",
    "@angular/core": "^22.0.0",
    "@angular/forms": "^22.0.0",
    "@angular/platform-browser": "^22.0.0",
    "@angular/router": "^22.0.0",
    "rxjs": "~7.8.0",
    "tslib": "^2.3.0"
    // zone.js ausente por default
  },
  "devDependencies": {
    "@angular/build": "^22.0.0",          // novo pacote consolidado
    "@angular/cli": "^22.0.0",
    "@angular/compiler-cli": "^22.0.0",
    "typescript": "~6.0.0",
    "vitest": "^3.x"                      // em vez de Karma/Jasmine
    // sem @angular-devkit/build-angular (depreciado)
  }
}
```

**O que mudou e por quê:**
- `zone.js` removido por default → zoneless é o futuro.
- `@angular-devkit/build-angular` → `@angular/build` (Application Builder).
- Karma/Jasmine → Vitest.
- TypeScript 6.
- Menos dependências de animações/platform-browser-dynamic se não usadas.

## angular.json

Principais diferenças:

| Aspecto | Angular 17 | Angular 22 |
|---------|------------|------------|
| Builder de build | `@angular-devkit/build-angular:application` ou browser | `@angular/build:application` |
| Builder de test | Karma | Vitest (`@angular/build:unit-test`) |
| Polyfills | Inclui `zone.js` | Vazio ou mínimo |
| Styles | `styles.css` | Mesmo, mas HMR default |
| File replacements | environments | Continua, mas simplificado |

## tsconfig.json / tsconfig.app.json / tsconfig.spec.json

- Target e lib atualizados para suportar TypeScript 6 e features modernas.
- `angularCompilerOptions` ganhou `typeCheckHostBindings: true` (default a partir de 21).
- `strict` templates ainda mais rigorosos.
- Spec usa types do Vitest.

## main.ts

**Angular 17:**
```ts
import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
```

**Angular 22:** praticamente igual, porém `appConfig` já inclui providers zoneless/OnPush-friendly e não precisa de Zone.

## app.config.ts

**Angular 17:**
```ts
import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes)]
};
```

**Angular 22:**
```ts
import { ApplicationConfig, provideZonelessChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZonelessChangeDetection(), // default em novos projetos
    provideRouter(routes),
    provideHttpClient(withFetch())    // Fetch por default
  ]
};
```

## app.routes.ts

Praticamente igual, porém com suporte a route-level render modes e melhor tipagem.

## index.html / styles.css

Poucas mudanças visíveis. `index.html` continua minimalista.

## polyfills / browserslist / assets / environments

- Polyfills drasticamente reduzidos (sem Zone.js).
- Browserslist atualizado para targets modernos.
- Environments continuam existindo, mas o padrão de fileReplacements permanece.

## Builders / Vite / ESBuild

- Angular 17 já usava Application Builder experimental/early.
- Angular 22 consolida completamente o caminho ESBuild + Vite.
- Webpack builders oficialmente depreciados.

---

# Mudanças no Bootstrap

O padrão desde Angular 17 já era `bootstrapApplication` + `ApplicationConfig`.  
A grande mudança é o **conteúdo dos providers**:

- v17–18: Zone.js implícito
- v19–20: Standalone default + signals
- v21+: Zoneless default + necessidade de declarar Zone explicitamente se quiser
- v22: OnPush default + Fetch

---

# Mudanças em Standalone Components

- v17–18: `standalone: true` explícito recomendado
- v19+: `standalone: true` é o **default**. Só escreva `standalone: false` se estiver dentro de NgModule.

---

# Mudanças em Signals

Evolução completa:

| API | 17 | 18 | 19 | 20 | 21 | 22 |
|-----|----|----|----|----|----|----|
| signal / computed | DP → stable | stable | stable | stable | stable | stable |
| effect | DP | DP | DP | **stable** | stable | stable |
| input / output / model | DP | DP | **stable** | stable | stable | stable |
| linkedSignal | - | - | DP | **stable** | stable | stable |
| resource | - | - | exp | exp | exp | **stable** |
| httpResource | - | - | - | exp | exp | **stable** |
| Signal Forms | - | - | - | - | exp | **stable** |

---

# Mudanças em Control Flow

- Introduzido em 17 (DP)
- Stable em 18
- `*ngIf`/`*ngFor`/`*ngSwitch` depreciados em 20
- Sintaxe recomendada absoluta a partir de 20/21

**Antes:**
```html
<div *ngIf="user">{{ user.name }}</div>
<li *ngFor="let item of items">{{ item }}</li>
```

**Depois (obrigatório a médio prazo):**
```html
@if (user) {
  <div>{{ user.name }}</div>
}
@for (item of items; track item.id) {
  <li>{{ item }}</li>
} @empty {
  <li>Nenhum item</li>
}
```

---

# Mudanças em SSR / Hydration

- v17: Hydration estável
- v18: Event Replay (DP) + i18n hydration (DP)
- v19: Incremental Hydration (DP) + Server Route Config
- v20: Incremental Hydration + Route Render Mode **stable**
- v21–22: Continuação e polimento + melhor integração com zoneless

---

# Mudanças em Router

- Redirect functions (18)
- Navigation error handler funcional (19)
- Route-level render modes (19→20 stable)
- Melhor tipagem e integração com signals
- Wildcard trailing segments (21)

---

# Mudanças em Forms

- Reactive + Template-driven continuam suportados
- Signal Forms (21 experimental → 22 stable) é o novo caminho recomendado para apps modernos baseados em signals.

---

# Mudanças em HttpClient

- `HttpClientModule` depreciado → `provideHttpClient()`
- v22: **Fetch API** se torna o backend default (`withFetch()`)
- `httpResource` stable em 22

---

# Mudanças em Builder / Build System

- Consolidação do Application Builder (ESBuild)
- Vite para dev server
- Webpack path depreciado oficialmente em v22

---

# Mudanças em Testes

- Karma/Jasmine → Vitest (default a partir de 21)
- `TestBed.flushEffects` → `TestBed.tick`
- Mais harnesses (especialmente para Aria)

---

# Mudanças em RxJS / TypeScript / Zone.js / Vite / ESBuild

- RxJS: continua 7.x (sem breaking grande)
- TypeScript: 5.2 → 6.0 (subidas graduais)
- Zone.js: de obrigatório → opcional → ausente por default
- Vite + ESBuild: caminho oficial e único recomendado

---

# Como migrar um projeto Angular 17 para Angular 22

**Regra de ouro:** nunca pule mais de uma major por vez com `ng update` (o CLI não permite).

```bash
# 1. Atualize Node.js para 22 LTS ou superior
# 2. Faça commit limpo

# Passo a passo recomendado:
ng update @angular/core@18 @angular/cli@18
# resolva breaking changes + testes

ng update @angular/core@19 @angular/cli@19
# especialmente standalone: false automático

ng update @angular/core@20 @angular/cli@20
# style guide, TestBed, ng-reflect, etc.

ng update @angular/core@21 @angular/cli@21
# zoneless declaration, Vitest, host bindings

ng update @angular/core@22 @angular/cli@22
# OnPush, Fetch, Signal Forms, TS 6
```

Após cada major:

1. Rode os testes
2. Corrija erros de compilação
3. Rode o app e verifique comportamento
4. Commit

Use o [Update Guide oficial](https://angular.dev/update-guide) selecionando de-para em cada etapa.

---

# Checklist de Migração

- [ ] Node.js ≥ 22
- [ ] TypeScript 6
- [ ] `ng update` sequencial 17→18→19→20→21→22
- [ ] Todos os componentes standalone (ou `standalone: false` explícito)
- [ ] Control Flow (`@if/@for`) no lugar de `*ngIf/*ngFor`
- [ ] Signals adotados onde faz sentido
- [ ] Zone.js: ou removido (zoneless) ou `provideZoneChangeDetection()` explícito
- [ ] OnPush revisado (agora default)
- [ ] HttpClient com `provideHttpClient(withFetch())`
- [ ] Testes migrados para Vitest (ou Karma ainda funcionando)
- [ ] `angular.json` usando `@angular/build:*`
- [ ] Sem dependência de `ng-reflect-*`
- [ ] Signal Forms avaliados para novos formulários
- [ ] `@angular/aria` avaliado para componentes acessíveis
- [ ] Build e SSR testados em produção-like
- [ ] Bundle size e Core Web Vitals medidos antes/depois

---

**Fim do documento.**

Este guia foi gerado com base exclusiva em fontes oficiais do projeto Angular até agosto de 2026. Para detalhes de commits específicos, consulte o CHANGELOG.md do repositório angular/angular e o Update Guide interativo em angular.dev/update-guide.
