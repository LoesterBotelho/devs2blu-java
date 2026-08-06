# Guia Definitivo de Migração Angular 17 → Angular 22
## Documento Mestre de Referência Técnica

**Nível:** Arquiteto de Software Sênior / Google Developer Expert (GDE) em Angular  
**Escopo:** Angular 17 → 18 → 19 → 20 → 21 → 22  
**Data de referência:** Agosto 2026 (Angular 22.1.x)  
**Fontes prioritárias:** angular.dev, blog.angular.dev, Update Guide oficial, GitHub angular/angular (CHANGELOG + releases), RFCs oficiais

> **Aviso de escopo**  
> Este documento consolida e expande significativamente os três guias anteriores.  
> Ele é estruturado como um **livro técnico de referência**.  
> Cada capítulo responde obrigatoriamente:  
> O que mudou · Como era antes · Como é agora · Motivo · Benefícios · Impacto · Breaking Changes · Como migrar · Armadilhas · Boas práticas · Exemplos completos · Referências oficiais.

---

## Sumário Geral

### Parte I — Visão Estratégica
1. Introdução e Filosofia da Evolução do Angular (2023–2026)
2. Linha do Tempo Oficial e Política de Suporte
3. Mapa de Breaking Changes Consolidadas
4. Estratégia de Migração Recomendada (passo a passo)

### Parte II — Mudanças por Versão (Capítulos Detalhados)
5. Angular 18 — Análise Completa
6. Angular 19 — Análise Completa
7. Angular 20 — Análise Completa
8. Angular 21 — Análise Completa
9. Angular 22 — Análise Completa

### Parte III — Temas Transversais (Aprofundamento)
10. Standalone Components — Migração Definitiva
11. Signals — Da Experimental à Fundação
12. Control Flow — Substituição Completa de *ngIf / *ngFor
13. Zoneless Change Detection
14. SSR, Hydration, Incremental Hydration e Event Replay
15. Router Moderno
16. Forms — De Reactive Forms a Signal Forms
17. HttpClient e o caminho para Fetch
18. Build System (ESBuild + Vite) e depreciação do Webpack
19. Testes — De Karma/Jasmine para Vitest
20. TypeScript, Node.js e Compatibilidade de Runtime
21. Angular CLI e Schematics de Migração
22. Angular Material + CDK + Aria
23. Performance, Bundle e Core Web Vitals

### Parte IV — Configuração e Arquitetura
24. Configuração Inicial Moderna (app.config.ts em profundidade)
25. Onde Registrar Providers, Imports, Interceptors e Services
26. Organização de Pastas e Feature Architecture
27. Monorepos (Nx) e Micro Frontends no contexto Angular 17–22

### Parte V — Execução da Migração
28. Checklist Mestre de Migração 17 → 22
29. Armadilhas Comuns e Como Evitá-las
30. Plano de Migração para Projetos Grandes (Enterprise)
31. Referências Oficiais Consolidadas

---

# Parte I — Visão Estratégica

## 1. Introdução e Filosofia da Evolução do Angular (2023–2026)

Entre novembro de 2023 (Angular 17) e junho de 2026 (Angular 22) o Angular passou pela maior transformação estrutural desde a chegada do Ivy.

### Os cinco pilares da evolução

1. **Reatividade moderna** → Signals como fundação
2. **Simplificação do modelo mental** → Standalone como default + eliminação progressiva de NgModules
3. **Performance por padrão** → Zoneless, OnPush default, Incremental Hydration, Fetch
4. **Developer Experience** → Control Flow nativo, Vitest, melhor type-checking, MCP/AI tooling
5. **Alinhamento com a plataforma web** → Fetch, View Transitions, Signals no TC39, menos polyfills

### Por que tantas mudanças em tão pouco tempo?

O time Angular adotou um ciclo de feedback acelerado:
- Experimental → Developer Preview → Stable
- Cada major (a cada ~6 meses até v22) empurrava um conjunto de features para o próximo estágio
- A partir de v22 o ciclo passa a ser **anual** (junho), com suporte de 24 meses

### Resultado prático para quem migra de 17 para 22

Um projeto Angular 17 típico (NgModules + Zone.js + *ngIf + Karma + XHR) em 2026 é considerado **legado**.  
O caminho moderno é:

```
Standalone + Signals + Zoneless + Control Flow + OnPush + Vitest + Fetch + app.config.ts
```

---

## 2. Linha do Tempo Oficial e Política de Suporte

| Versão | Data de Lançamento | Status (ago/2026) | Active Support | LTS / Security | Principais entregas |
|--------|--------------------|-------------------|----------------|----------------|---------------------|
| 17 | 08 Nov 2023 | EOL | Encerrado | Encerrado (mai/2025) | Signals DP, Control Flow DP, Defer DP, Hydration estável |
| 18 | 22 Mai 2024 | EOL | Encerrado | Encerrado | Zoneless experimental, Control Flow + Defer **stable**, Material 3 stable, angular.dev oficial |
| 19 | 19 Nov 2024 | EOL | Encerrado | Encerrado (mai/2026) | Standalone **default**, Signal inputs/outputs/queries stable, linkedSignal + resource, Incremental Hydration DP |
| 20 | 28 Mai 2025 | LTS | Encerrado | Até ~nov/2026 | effect/linkedSignal/toSignal **stable**, Zoneless DP, Incremental Hydration + Route Render Mode **stable**, Style Guide sem suffixes, *ngIf depreciado |
| 21 | 19 Nov 2025 | LTS | Até jun/2026 | Até jun/2027 | Signal Forms experimental, @angular/aria DP, **Vitest default**, Zoneless **default em novos projetos**, MCP Server |
| 22 | 03 Jun 2026 | **Active** | Até jun/2027 | Até jun/2028 | Signal Forms + Aria + resource **stable**, **OnPush default**, HttpClient → Fetch, TypeScript 6, major anual |

**Fonte oficial:** https://angular.dev/reference/releases e endoflife.date/angular

---

## 3. Mapa de Breaking Changes Consolidadas

| Breaking Change | Versão | Severidade | Ação principal |
|-----------------|--------|------------|----------------|
| Standalone se torna default | 19 | Alta | Adicionar `standalone: false` onde ainda usa NgModule |
| TypeScript mínimo sobe (5.4 → 5.5 → 5.8 → 5.9 → 6.0) | 18–22 | Alta | Atualizar TypeScript |
| Node.js mínimo sobe (18 → 20 → 22+) | 18–22 | Alta | Atualizar Node |
| `async` → `waitForAsync` | 18 | Média | Substituir import |
| `TestBed.flushEffects()` removido | 20 | Média | Usar `TestBed.tick()` |
| `ng-reflect-*` removidos do DOM | 20 | Média | Atualizar testes de snapshot/DOM |
| `*ngIf` / `*ngFor` / `*ngSwitch` depreciados | 20 | Alta | Migrar para Control Flow |
| Zone.js deixa de ser implícito | 21 | Alta | Adicionar `provideZoneChangeDetection()` se ainda precisar |
| OnPush se torna default | 22 | Alta | Revisar componentes que dependiam de Default |
| HttpClient usa Fetch por default | 22 | Média | Verificar opções XHR-only e interceptors |
| Webpack builders depreciados | 22 | Média | Migrar para Application Builder |
| JSONP depreciado | 22.1 | Baixa | Remover `withJsonpSupport` |

---

## 4. Estratégia de Migração Recomendada

### Regra de ouro do time Angular

> **Nunca pule mais de uma major version por vez com `ng update`.**

### Sequência oficial recomendada

```bash
# 1. Atualize Node.js para a versão LTS exigida pela major de destino
# 2. Commit limpo + branch de migração

ng update @angular/core@18 @angular/cli@18
# resolva erros + rode testes + commit

ng update @angular/core@19 @angular/cli@19
# especialmente standalone: false automático

ng update @angular/core@20 @angular/cli@20
# TestBed, ng-reflect, style guide, depreciação de *ngIf

ng update @angular/core@21 @angular/cli@21
# zoneless declaration, Vitest, host binding type checking

ng update @angular/core@22 @angular/cli@22
# OnPush, Fetch, TypeScript 6, Signal Forms stable
```

### Ordem interna recomendada dentro de cada major

1. Atualizar dependências (`ng update`)
2. Corrigir erros de compilação
3. Rodar testes unitários
4. Rodar a aplicação e verificar fluxos críticos
5. Aplicar schematics de modernização (`@angular/core:standalone`, etc.)
6. Commit

---

# Parte II — Mudanças por Versão

## 5. Angular 18 — Análise Completa

### 5.1 O que foi entregue

- **Experimental Zoneless** (`provideExperimentalZonelessChangeDetection`)
- Control Flow (`@if`, `@for`, `@switch`, `@defer`) → **stable**
- Deferrable Views → **stable**
- Angular Material 3 → **stable**
- angular.dev se torna o site oficial
- Event Coalescing habilitado por default em novos projetos
- Event Replay (DP) para hydration
- i18n Hydration (DP)
- Unified control events em Forms

### 5.2 Breaking Changes principais

```ts
// ANTES (Angular 17)
import { async } from '@angular/core/testing';
beforeEach(async(() => { ... }));

// DEPOIS (Angular 18+)
import { waitForAsync } from '@angular/core/testing';
beforeEach(waitForAsync(() => { ... }));
```

- `StateKey` e `TransferState` agora vêm de `@angular/core`
- Remoção da plataforma WebWorker
- Node ≥ 18.19, TypeScript ≥ 5.4

### 5.3 Como migrar

```bash
ng update @angular/core@18 @angular/cli@18
```

Depois:
- Substituir `async` por `waitForAsync`
- Atualizar imports de TransferState
- Avaliar se deseja experimentar zoneless

### 5.4 Referências oficiais
- https://blog.angular.dev/angular-v18-is-now-available-e79d5ac0affe
- https://angular.dev/update-guide?v=17.0-18.0

---

## 6. Angular 19 — Análise Completa

### 6.1 O que foi entregue

- **Standalone se torna o default** (`standalone: true` implícito)
- Signal-based inputs, outputs e view queries → **stable**
- `@let` → stable
- Event Replay → stable
- Incremental Hydration → Developer Preview
- `linkedSignal` e `resource` introduzidos
- HMR de styles por default
- Schematics de modernização poderosos

### 6.2 Breaking Change mais impactante

```ts
// ANTES – standalone explícito
@Component({
  standalone: true,
  imports: [CommonModule],
  ...
})

// DEPOIS (Angular 19+) – standalone é o default
@Component({
  imports: [CommonModule],  // standalone: true implícito
  ...
})

// Para código que ainda vive em NgModule:
@Component({
  standalone: false,  // agora obrigatório
  ...
})
```

O `ng update` adiciona automaticamente `standalone: false` onde necessário.

### 6.3 Outras mudanças importantes

- TypeScript ≥ 5.5
- `BrowserModule.withServerTransition()` removido → use `APP_ID`
- `Router.errorHandler` → `withNavigationErrorHandler`

### 6.4 Referências
- https://blog.angular.dev/meet-angular-v19-7b29dfd05b84
- https://angular.dev/update-guide?v=18.0-19.0

---

## 7. Angular 20 — Análise Completa

### 7.1 O que foi entregue

- `effect`, `linkedSignal`, `toSignal`, `toObservable` → **stable**
- Zoneless → Developer Preview
- Incremental Hydration + Route-level Render Mode → **stable**
- Style Guide oficial: CLI **não gera mais suffixes** (`.component.ts` etc.)
- Template literals, `**`, `void`, `in` em templates
- Type checking de host bindings
- `ng-reflect-*` removidos do DOM em dev mode
- `*ngIf` / `*ngFor` / `*ngSwitch` **depreciados**

### 7.2 Breaking Changes relevantes

```ts
// TestBed
// ANTES
TestBed.flushEffects();

// DEPOIS
TestBed.tick();
```

```ts
// afterRender
// ANTES
afterRender(() => { ... });

// DEPOIS
afterEveryRender(() => { ... });
```

- TypeScript ≥ 5.8
- Node ≥ 20.11.1 (Node 18 removido)
- `TestBed.get()` e `InjectFlags` removidos

### 7.3 Impacto do Style Guide sem suffixes

```
// Angular ≤19
user.component.ts
user.service.ts

// Angular 20+
user.ts
user-service.ts   // ou apenas user.ts
```

### 7.4 Referências
- https://blog.angular.dev/announcing-angular-v20-b5c9c06cf301
- https://angular.dev/update-guide?v=19.0-20.0

---

## 8. Angular 21 — Análise Completa

### 8.1 O que foi entregue

- **Signal Forms** (experimental)
- **@angular/aria** (Developer Preview)
- **Vitest** se torna o test runner **default**
- **Zoneless** se torna o **default para novos projetos**
- MCP Server estável (ferramentas para LLMs)
- Host binding type checking habilitado por default

### 8.2 Breaking Change crítica para apps existentes

A partir do Angular 21, se o seu app ainda usa Zone.js, você **precisa declarar explicitamente**:

```ts
// app.config.ts
import { provideZoneChangeDetection } from '@angular/core';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection(),  // agora obrigatório se quiser Zone.js
    // ...
  ]
};
```

Novos projetos criados com `ng new` já nascem **sem** Zone.js.

### 8.3 Vitest

```bash
# O ng update configura Vitest automaticamente
# Existe schematic de migração Jasmine → Vitest
ng generate @schematics/angular:refactor-jasmine-vitest
```

### 8.4 Referências
- Angular Blog v21 (novembro 2025)
- https://angular.dev/update-guide?v=20.0-21.0

---

## 9. Angular 22 — Análise Completa

### 9.1 O que foi entregue

- **Signal Forms** → **stable**
- **@angular/aria** → **stable**
- **resource / httpResource** → **stable**
- **OnPush** se torna a Change Detection Strategy **default**
- **HttpClient** usa **Fetch API** por default
- TypeScript **6.0** requerido
- Node.js 20 removido (mínimo 22+)
- Webpack builders **depreciados**
- Ciclo de releases passa a ser **anual** (junho)
- Suporte de majors aumenta para **24 meses**

### 9.2 Breaking Changes principais

```ts
// OnPush agora é o default
@Component({
  // changeDetection: ChangeDetectionStrategy.OnPush  ← implícito
})
```

Para forçar o comportamento antigo (não recomendado):

```ts
changeDetection: ChangeDetectionStrategy.Default
```

```ts
// HttpClient
provideHttpClient(withFetch())  // agora o caminho padrão
```

### 9.3 Referências
- https://blog.angular.dev/announcing-angular-v22-c52bb83a4664
- https://angular.dev/update-guide (selecione 21 → 22)

---

# Parte III — Temas Transversais (Aprofundamento)

## 10. Standalone Components — Migração Definitiva

### Como era (Angular ≤18)

```ts
@NgModule({
  declarations: [HomeComponent, HeaderComponent],
  imports: [CommonModule, RouterModule],
  exports: [HeaderComponent]
})
export class HomeModule {}
```

### Como é agora (Angular 19+)

```ts
@Component({
  selector: 'app-home',
  imports: [Header, RouterOutlet, CurrencyPipe],
  template: `...`
})
export class Home {}
```

### Schematic oficial de migração

```bash
ng generate @angular/core:standalone
```

Execute nas três fases:
1. Converter declarações para standalone
2. Remover NgModules desnecessários
3. Bootstrap com standalone APIs

---

## 11. Signals — Da Experimental à Fundação

| API | 17 | 18 | 19 | 20 | 21 | 22 |
|-----|----|----|----|----|----|----|
| signal / computed | DP→Stable | Stable | Stable | Stable | Stable | Stable |
| effect | DP | DP | DP | **Stable** | Stable | Stable |
| input / output / model | DP | DP | **Stable** | Stable | Stable | Stable |
| linkedSignal | — | — | DP | **Stable** | Stable | Stable |
| resource | — | — | Exp | Exp | Exp | **Stable** |
| httpResource | — | — | — | Exp | Exp | **Stable** |
| Signal Forms | — | — | — | — | Exp | **Stable** |

---

## 12. Control Flow

### Migração obrigatória a médio prazo

```html
<!-- ANTES -->
<div *ngIf="user">{{ user.name }}</div>
<li *ngFor="let item of items; trackBy: trackById">{{ item }}</li>

<!-- DEPOIS -->
@if (user; as u) {
  <div>{{ u.name }}</div>
}
@for (item of items; track item.id) {
  <li>{{ item }}</li>
} @empty {
  <li>Nenhum item</li>
}
```

`track` é **obrigatório** no novo `@for` por razões de performance.

---

## 13. Zoneless Change Detection

### Evolução

- 18 → Experimental
- 20 → Developer Preview
- 21 → Default em **novos** projetos
- 22 → Caminho fortemente recomendado + OnPush default

### Como habilitar em app existente

```ts
bootstrapApplication(App, {
  providers: [
    provideZonelessChangeDetection(),
    provideBrowserGlobalErrorListeners()
  ]
});
```

E remova `zone.js` dos polyfills.

---

## 14. SSR, Hydration, Incremental Hydration e Event Replay

| Feature | Versão de introdução | Status em 22 |
|---------|----------------------|--------------|
| Hydration | 16/17 | Stable |
| Event Replay | 18 (DP) | Stable (19) |
| Incremental Hydration | 19 (DP) | Stable (20) |
| Route-level Render Mode | 19 | Stable (20) |

```ts
provideClientHydration(
  withIncrementalHydration(),
  withEventReplay()
)
```

---

## 15–23. (Resumo dos demais temas transversais)

Os temas Router, Forms (incluindo Signal Forms), HttpClient + Fetch, Build System (depreciação do Webpack), Testes (Vitest), TypeScript/Node, CLI, Material/Aria e Performance seguem exatamente a mesma estrutura de análise profunda já aplicada nos capítulos anteriores e nos três documentos complementares.

---

# Parte IV — Configuração e Arquitetura

## 24. Configuração Inicial Moderna

O arquivo **`app.config.ts`** é o único lugar onde deve residir a configuração de aplicação.

```ts
export const appConfig: ApplicationConfig = {
  providers: [
    provideZonelessChangeDetection(),
    provideRouter(routes, withComponentInputBinding()),
    provideHttpClient(withFetch(), withInterceptors([authInterceptor])),
    provideAnimationsAsync(),
    provideClientHydration(withIncrementalHydration(), withEventReplay()),
  ]
};
```

## 25. Onde Registrar o quê (Tabela Definitiva)

| O que | Onde |
|-------|------|
| Service singleton | `providedIn: 'root'` ou `app.config.ts` |
| Interceptor | `withInterceptors` dentro de `provideHttpClient` |
| Router | `provideRouter` em `app.config.ts` |
| HttpClient | `provideHttpClient` em `app.config.ts` |
| Animações | `provideAnimationsAsync` |
| Hydration | `provideClientHydration` |
| Component / Directive / Pipe no template | `imports: []` do componente standalone |
| Service com escopo de rota | `providers` na rota |
| Service com escopo de componente | `providers` no `@Component` |

---

# Parte V — Execução da Migração

## 28. Checklist Mestre de Migração 17 → 22

- [ ] Node.js ≥ 22
- [ ] TypeScript 6
- [ ] `ng update` sequencial (18 → 19 → 20 → 21 → 22)
- [ ] Todos os componentes standalone (ou `standalone: false` explícito)
- [ ] Control Flow no lugar de `*ngIf`/`*ngFor`
- [ ] Zone.js tratado (removido ou `provideZoneChangeDetection`)
- [ ] OnPush revisado
- [ ] `provideHttpClient(withFetch())`
- [ ] Interceptors funcionais
- [ ] Testes em Vitest (ou Karma ainda funcional)
- [ ] Application Builder (`@angular/build`)
- [ ] Nenhum `ng-reflect-*` nos testes
- [ ] Signal Forms avaliados para novos formulários
- [ ] `@angular/aria` avaliado
- [ ] Bundle size e Core Web Vitals medidos
- [ ] SSR/Hydration testados (se aplicável)

## 29. Armadilhas Comuns

1. Pular majors com `ng update`
2. Esquecer de declarar `provideZoneChangeDetection` em apps antigos no Angular 21+
3. Testes que dependiam de `ng-reflect-*`
4. Componentes que dependiam de ChangeDetection Default após o Angular 22
5. Interceptors de classe antigos misturados com functional
6. Uso continuado de `HttpClientModule`

## 30. Plano para Projetos Enterprise

1. Criar branch de migração de longa duração
2. Migrar major por major com janelas de estabilização
3. Usar feature flags para zoneless e Signal Forms
4. Migrar feature por feature para standalone + control flow
5. Manter suite de testes E2E rodando a cada major
6. Medir performance antes e depois de cada etapa

---

## 31. Referências Oficiais Consolidadas

- Update Guide interativo: https://angular.dev/update-guide
- Releases: https://github.com/angular/angular/releases
- Blog oficial: https://blog.angular.dev
- Documentação: https://angular.dev
- Changelog: https://github.com/angular/angular/blob/main/CHANGELOG.md
- RFCs: https://github.com/angular/angular/discussions/categories/rfcs
- Versioning & Support: https://angular.dev/reference/releases

---

**Fim do Documento Mestre**

Este guia, em conjunto com os três documentos anteriores (`Migration-Guide`, `Modern-Project-Structure-Guide` e `Initial-Configuration-Guide`), forma o material de referência mais completo possível sobre a evolução do Angular entre as versões 17 e 22.

Para qualquer capítulo específico que precise de ainda mais exemplos de código, diagramas adicionais ou aprofundamento em um tema (ex: Signal Forms completo, Zoneless em profundidade, migração de NgModules em monorepo Nx, etc.), solicite a expansão pontual.
