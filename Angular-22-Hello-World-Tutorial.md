# Tutorial Completo — Hello World em Angular 22
## Foco total nas Configurações Iniciais

**Baseado na documentação oficial:** [angular.dev](https://angular.dev)  
**Versão de referência:** Angular 22 (agosto 2026)

> Este tutorial mostra o caminho **oficial e moderno** para criar o clássico "Hello World" em Angular, com ênfase especial em **todas as configurações iniciais** geradas pelo CLI e no que cada arquivo faz.

---

## 1. Pré-requisitos (Oficial)

De acordo com a [documentação de instalação](https://angular.dev/installation):

| Requisito | Versão mínima recomendada |
|-----------|---------------------------|
| **Node.js** | v22.22.3 ou superior (LTS ativo) |
| **npm** | Vem junto com o Node.js |
| **Editor** | Visual Studio Code (recomendado) + Angular Language Service |
| **Terminal** | Qualquer terminal (PowerShell, bash, zsh…) |

Verifique a versão do Node:

```bash
node --version
```

Se estiver abaixo de 22, atualize em [nodejs.org](https://nodejs.org).

---

## 2. Instalar o Angular CLI

```bash
npm install -g @angular/cli
```

Confirme a instalação:

```bash
ng version
```

Você deve ver a versão 22.x do CLI e do Angular.

---

## 3. Criar o Projeto (Configuração Inicial)

```bash
ng new hello-world
```

### Perguntas que a CLI faz (e recomendações oficiais)

| Pergunta | Recomendação para Hello World | Motivo |
|----------|-------------------------------|--------|
| **Which stylesheet format?** | CSS (ou SCSS) | CSS é suficiente para começar |
| **Do you want to enable Server-Side Rendering (SSR)?** | **No** | Para o primeiro exemplo mantenha simples |
| **Do you want to create a zoneless application?** | **Yes** (default em Angular 21+) | Caminho moderno |
| Outras opções | Aceite o padrão | O CLI já configura Standalone + Vitest |

Após a criação:

```bash
cd hello-world
```

---

## 4. Estrutura Gerada pelo CLI (o que cada arquivo faz)

```text
hello-world/
├── public/                     # Arquivos estáticos (favicon, etc.)
├── src/
│   ├── app/
│   │   ├── app.ts              # ★ Componente raiz (Standalone)
│   │   ├── app.html            # Template do componente raiz (ou inline)
│   │   ├── app.css             # Estilos do componente raiz
│   │   ├── app.config.ts       # ★ Configuração central da aplicação
│   │   └── app.routes.ts       # Rotas (mesmo que vazio no início)
│   ├── index.html              # HTML de entrada
│   ├── main.ts                 # ★ Ponto de entrada (bootstrap)
│   └── styles.css              # Estilos globais
├── angular.json                # Configuração do workspace e builders
├── package.json                # Dependências e scripts
├── tsconfig.json               # Configuração TypeScript base
├── tsconfig.app.json           # Configuração TypeScript da aplicação
└── ...
```

### Arquivos mais importantes da configuração inicial

| Arquivo | Função |
|---------|--------|
| `main.ts` | Chama `bootstrapApplication` e inicia a aplicação |
| `app.config.ts` | Contém todos os **providers** (Router, HttpClient, etc.) |
| `app.ts` | Componente raiz (`selector: 'app-root'`) |
| `index.html` | Contém a tag `<app-root></app-root>` onde o Angular monta a app |
| `angular.json` | Define como o projeto é buildado e servido |

---

## 5. main.ts — Bootstrap da Aplicação

Arquivo gerado (simplificado e comentado):

```ts
// src/main.ts
import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';

bootstrapApplication(App, appConfig)
  .catch((err) => console.error(err));
```

**O que acontece aqui?**

1. `bootstrapApplication` é a forma moderna (desde Angular 14+) de iniciar uma aplicação **Standalone**.
2. O primeiro argumento é o **componente raiz** (`App`).
3. O segundo argumento é o objeto de configuração (`appConfig`) que contém os providers.

> **Fonte oficial:** [bootstrapApplication API](https://angular.dev/api/platform-browser/bootstrapApplication)

---

## 6. app.config.ts — Coração da Configuração

```ts
// src/app/app.config.ts
import { ApplicationConfig, provideZonelessChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZonelessChangeDetection(),   // Padrão em novos projetos (Angular 21+)
    provideRouter(routes)               // Habilita o Angular Router
  ]
};
```

### Explicação de cada provider

| Provider | O que faz |
|----------|-----------|
| `provideZonelessChangeDetection()` | Remove a dependência do Zone.js (mais performático e moderno) |
| `provideRouter(routes)` | Registra as rotas da aplicação |

Você pode adicionar outros providers aqui conforme a necessidade:

```ts
provideHttpClient(withFetch()),           // HTTP
provideAnimationsAsync(),                 // Animações
provideClientHydration(...),              // SSR / Hydration
```

---

## 7. app.ts — Componente Raiz (Hello World)

Este é o arquivo que você vai editar para ver o "Hello World".

### Versão gerada pelo CLI (aproximada)

```ts
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = 'hello-world';
}
```

### Transformando em Hello World (versão inline – recomendada para aprendizado)

Substitua o conteúdo de `src/app/app.ts` por:

```ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  // standalone: true é o DEFAULT a partir do Angular 19 – não precisa escrever
  imports: [],
  template: `
    <h1>Hello World!</h1>
    <p>Meu primeiro aplicativo Angular 22</p>
  `,
  styles: [`
    h1 {
      color: #dd0031;          /* cor oficial do Angular */
      font-family: system-ui, sans-serif;
      text-align: center;
      margin-top: 3rem;
    }
    p {
      text-align: center;
      color: #333;
    }
  `]
})
export class App {}
```

> **Fonte oficial do Hello World:** [angular.dev/tutorials/first-app/01-hello-world](https://angular.dev/tutorials/first-app/01-hello-world)

---

## 8. index.html — Ponto de Montagem

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>HelloWorld</title>
  <base href="/">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body>
  <app-root></app-root>   <!-- ★ Aqui o Angular injeta o componente raiz -->
</body>
</html>
```

O `selector: 'app-root'` do componente `App` corresponde exatamente a esta tag.

---

## 9. Rodando a Aplicação

```bash
ng serve
# ou
npm start
```

Abra o navegador em:

**http://localhost:4200**

Você verá:

```
Hello World!
Meu primeiro aplicativo Angular 22
```

O servidor de desenvolvimento (baseado em **Vite** + **ESBuild**) observa os arquivos e recarrega automaticamente quando você salva alterações.

---

## 10. Resumo das Configurações Iniciais Modernas (Angular 22)

| Aspecto | Configuração atual (Angular 22) | Observação |
|---------|----------------------------------|------------|
| Bootstrap | `bootstrapApplication` | Substituiu `platformBrowserDynamic().bootstrapModule` |
| Configuração | `app.config.ts` + `ApplicationConfig` | Substituiu o `AppModule` |
| Componentes | Standalone por default | `standalone: true` implícito desde v19 |
| Change Detection | Zoneless por default em novos projetos | `provideZonelessChangeDetection()` |
| Estilo de arquivo | Sem suffixes (`.component.ts`) | Style Guide desde Angular 20 |
| Build / Dev Server | Application Builder (ESBuild + Vite) | Webpack depreciado |
| Testes | Vitest | Substituiu Karma/Jasmine como default |

---

## 11. Próximos Passos Oficiais

Depois do Hello World, a documentação oficial recomenda:

1. [Your first Angular app](https://angular.dev/tutorials/first-app) — tutorial completo de uma aplicação de imóveis
2. [Essentials](https://angular.dev/essentials) — conceitos fundamentais
3. [Signals](https://angular.dev/guide/signals)
4. [Components](https://angular.dev/guide/components)

---

## 12. Checklist do Hello World

- [ ] Node.js ≥ 22 instalado
- [ ] Angular CLI 22 instalado globalmente
- [ ] Projeto criado com `ng new hello-world`
- [ ] Entendi o papel de `main.ts`
- [ ] Entendi o papel de `app.config.ts`
- [ ] Alterei o template de `app.ts` para "Hello World!"
- [ ] Rodei `ng serve` e vi o resultado em http://localhost:4200

---

**Referências oficiais utilizadas**

- https://angular.dev/installation
- https://angular.dev/tutorials/first-app
- https://angular.dev/tutorials/first-app/01-hello-world
- https://angular.dev/cli/new
- https://angular.dev/api/platform-browser/bootstrapApplication
- https://angular.dev/reference/configs/file-structure

---

**Fim do Tutorial Hello World**

Este é o caminho mais limpo e alinhado com as práticas oficiais do Angular 22 para começar.
