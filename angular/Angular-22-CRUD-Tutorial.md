# Tutorial Completo — CRUD com Angular 22
## Standalone Components + Signals + Reactive Forms + JSON Server

**Autor:** Arquiteto de Software especialista em Angular 22  
**Nível:** Intermediário → Avançado  
**Stack:** Angular 22 · TypeScript · Standalone · Signals · Reactive Forms · HttpClient · Angular Router · JSON Server

> Este tutorial ensina a construir uma aplicação **CRUD completa de Clientes** seguindo as práticas oficiais e modernas do Angular 22.

---

## Sumário

1. [Visão Geral da Aplicação](#1-visão-geral-da-aplicação)
2. [Pré-requisitos](#2-pré-requisitos)
3. [Criando o Projeto](#3-criando-o-projeto)
4. [Configurando o JSON Server](#4-configurando-o-json-server)
5. [Estrutura de Pastas Profissional](#5-estrutura-de-pastas-profissional)
6. [Model e Interface](#6-model-e-interface)
7. [Service (HttpClient + Signals)](#7-service-httpclient--signals)
8. [Configuração Global (app.config.ts)](#8-configuração-global-appconfigts)
9. [Rotas](#9-rotas)
10. [Componente de Listagem](#10-componente-de-listagem)
11. [Componente de Formulário (Cadastro + Edição)](#11-componente-de-formulário-cadastro--edição)
12. [Componente de Detalhes](#12-componente-de-detalhes)
13. [Validações Avançadas](#13-validações-avançadas)
14. [Estilos Básicos](#14-estilos-básicos)
15. [Como Rodar o Projeto](#15-como-rodar-o-projeto)
16. [Melhorias Possíveis](#16-melhorias-possíveis)
17. [Checklist Final](#17-checklist-final)

---

## 1. Visão Geral da Aplicação

Vamos construir um **CRUD de Clientes** com as seguintes telas:

| Tela | Rota | Funcionalidade |
|------|------|----------------|
| Listagem | `/clientes` | Tabela + pesquisa + botões de ação |
| Cadastro | `/clientes/novo` | Formulário reativo com validações |
| Edição | `/clientes/:id/editar` | Mesmo formulário preenchido |
| Detalhes | `/clientes/:id` | Visualização somente leitura |
| Exclusão | — | Confirmação + remoção + atualização da lista |

**Tecnologias utilizadas (Angular 22):**

- Standalone Components (default)
- Signals para estado local
- Reactive Forms + validações
- `provideHttpClient(withFetch())`
- `provideRouter` + `withComponentInputBinding`
- Control Flow (`@if`, `@for`, `@empty`)
- JSON Server como API REST fake

---

## 2. Pré-requisitos

- Node.js **22+** (obrigatório no Angular 22)
- npm ou pnpm
- Angular CLI 22

```bash
node -v          # deve ser >= 22
npm install -g @angular/cli@22
```

---

## 3. Criando o Projeto

```bash
ng new clientes-app --routing --style=scss --ssr=false
cd clientes-app
```

> A partir do Angular 21/22 o CLI já cria o projeto **sem Zone.js** e com **Vitest** por default.  
> Aceite as opções padrão (Standalone já vem ativado).

Estrutura inicial relevante:

```text
src/
├── app/
│   ├── app.ts
│   ├── app.config.ts
│   ├── app.routes.ts
│   ├── app.html
│   └── app.scss
├── index.html
├── main.ts
└── styles.scss
```

---

## 4. Configurando o JSON Server

### 4.1 Instalar

```bash
npm install -D json-server
```

### 4.2 Criar o arquivo `db.json` na raiz do projeto

```json
{
  "clientes": [
    {
      "id": 1,
      "nome": "Ana Silva",
      "email": "ana.silva@email.com",
      "telefone": "(11) 98765-4321",
      "endereco": "Rua das Flores, 123 - São Paulo/SP"
    },
    {
      "id": 2,
      "nome": "Bruno Costa",
      "email": "bruno.costa@email.com",
      "telefone": "(21) 91234-5678",
      "endereco": "Av. Atlântica, 456 - Rio de Janeiro/RJ"
    },
    {
      "id": 3,
      "nome": "Carla Mendes",
      "email": "carla.mendes@email.com",
      "telefone": "(31) 99876-5432",
      "endereco": "Rua da Bahia, 789 - Belo Horizonte/MG"
    }
  ]
}
```

### 4.3 Script no `package.json`

```json
"scripts": {
  "start": "ng serve",
  "server": "json-server --watch db.json --port 3000",
  "build": "ng build"
}
```

Em um terminal rode:

```bash
npm run server
```

A API estará disponível em:

- `GET    http://localhost:3000/clientes`
- `GET    http://localhost:3000/clientes/:id`
- `POST   http://localhost:3000/clientes`
- `PUT    http://localhost:3000/clientes/:id`
- `DELETE http://localhost:3000/clientes/:id`

---

## 5. Estrutura de Pastas Profissional

Vamos organizar o código por **feature**:

```text
src/app/
├── core/
│   └── (interceptors, guards – opcional neste tutorial)
├── features/
│   └── clientes/
│       ├── cliente.model.ts
│       ├── cliente.service.ts
│       ├── cliente-list.ts
│       ├── cliente-form.ts
│       ├── cliente-detail.ts
│       └── clientes.routes.ts
├── app.config.ts
├── app.routes.ts
└── app.ts
```

Crie as pastas:

```bash
mkdir -p src/app/features/clientes
```

---

## 6. Model e Interface

**Arquivo:** `src/app/features/clientes/cliente.model.ts`

```ts
export interface Cliente {
  id?: number;
  nome: string;
  email: string;
  telefone: string;
  endereco: string;
}
```

---

## 7. Service (HttpClient + boas práticas)

**Arquivo:** `src/app/features/clientes/cliente.service.ts`

```ts
import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of, retry, timeout } from 'rxjs';
import { Cliente } from './cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private readonly http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:3000/clientes';

  /** Lista todos os clientes */
  listar(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.apiUrl).pipe(
      retry(2),
      timeout(8000),
      catchError(error => {
        console.error('Erro ao listar clientes', error);
        return of([]);
      })
    );
  }

  /** Busca um cliente pelo ID */
  buscarPorId(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.apiUrl}/${id}`);
  }

  /** Cria um novo cliente */
  criar(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.apiUrl, cliente);
  }

  /** Atualiza um cliente existente */
  atualizar(id: number, cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${this.apiUrl}/${id}`, cliente);
  }

  /** Remove um cliente */
  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
```

---

## 8. Configuração Global (app.config.ts)

**Arquivo:** `src/app/app.config.ts`

```ts
import { ApplicationConfig, provideZonelessChangeDetection } from '@angular/core';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { provideHttpClient, withFetch } from '@angular/common/http';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    // Zoneless (padrão em novos projetos Angular 21+)
    provideZonelessChangeDetection(),

    // Router com binding automático de parâmetros para @Input()
    provideRouter(routes, withComponentInputBinding()),

    // HttpClient usando Fetch API (padrão Angular 22)
    provideHttpClient(withFetch())
  ]
};
```

---

## 9. Rotas

### 9.1 Rotas da feature

**Arquivo:** `src/app/features/clientes/clientes.routes.ts`

```ts
import { Routes } from '@angular/router';

export const CLIENTES_ROUTES: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./cliente-list').then(m => m.ClienteList)
  },
  {
    path: 'novo',
    loadComponent: () =>
      import('./cliente-form').then(m => m.ClienteForm)
  },
  {
    path: ':id',
    loadComponent: () =>
      import('./cliente-detail').then(m => m.ClienteDetail)
  },
  {
    path: ':id/editar',
    loadComponent: () =>
      import('./cliente-form').then(m => m.ClienteForm)
  }
];
```

### 9.2 Rotas principais

**Arquivo:** `src/app/app.routes.ts`

```ts
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'clientes', pathMatch: 'full' },
  {
    path: 'clientes',
    loadChildren: () =>
      import('./features/clientes/clientes.routes').then(m => m.CLIENTES_ROUTES)
  },
  { path: '**', redirectTo: 'clientes' }
];
```

---

## 10. Componente de Listagem

**Arquivo:** `src/app/features/clientes/cliente-list.ts`

```ts
import { Component, inject, signal, computed, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ClienteService } from './cliente.service';
import { Cliente } from './cliente.model';

@Component({
  selector: 'app-cliente-list',
  imports: [RouterLink],
  template: `
    <div class="header">
      <h1>Clientes</h1>
      <a routerLink="novo" class="btn btn-primary">Novo Cliente</a>
    </div>

    <div class="search">
      <input
        type="search"
        placeholder="Pesquisar por nome ou e-mail..."
        [value]="termo()"
        (input)="onSearch($event)"
      />
    </div>

    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>E-mail</th>
          <th>Telefone</th>
          <th>Ações</th>
        </tr>
      </thead>
      <tbody>
        @for (cliente of clientesFiltrados(); track cliente.id) {
          <tr>
            <td>{{ cliente.id }}</td>
            <td>{{ cliente.nome }}</td>
            <td>{{ cliente.email }}</td>
            <td>{{ cliente.telefone }}</td>
            <td class="actions">
              <a [routerLink]="[cliente.id]" class="btn btn-sm">Ver</a>
              <a [routerLink]="[cliente.id, 'editar']" class="btn btn-sm btn-edit">Editar</a>
              <button (click)="excluir(cliente.id!)" class="btn btn-sm btn-danger">
                Excluir
              </button>
            </td>
          </tr>
        } @empty {
          <tr>
            <td colspan="5" class="empty">Nenhum cliente encontrado</td>
          </tr>
        }
      </tbody>
    </table>
  `,
  styles: [`
    .header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 1.5rem;
    }
    .search {
      margin-bottom: 1rem;
    }
    .search input {
      width: 100%;
      max-width: 400px;
      padding: 0.5rem 0.75rem;
      border: 1px solid #ccc;
      border-radius: 6px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      padding: 0.75rem;
      text-align: left;
      border-bottom: 1px solid #e0e0e0;
    }
    th {
      background: #f5f5f5;
      font-weight: 600;
    }
    .actions {
      display: flex;
      gap: 0.5rem;
    }
    .empty {
      text-align: center;
      color: #888;
      padding: 2rem;
    }
  `]
})
export class ClienteList implements OnInit {
  private readonly service = inject(ClienteService);

  clientes = signal<Cliente[]>([]);
  termo = signal('');

  /** Lista filtrada reativamente com base no termo de busca */
  clientesFiltrados = computed(() => {
    const termo = this.termo().toLowerCase().trim();
    if (!termo) return this.clientes();

    return this.clientes().filter(c =>
      c.nome.toLowerCase().includes(termo) ||
      c.email.toLowerCase().includes(termo)
    );
  });

  ngOnInit(): void {
    this.carregar();
  }

  carregar(): void {
    this.service.listar().subscribe(lista => {
      this.clientes.set(lista);
    });
  }

  onSearch(event: Event): void {
    const value = (event.target as HTMLInputElement).value;
    this.termo.set(value);
  }

  excluir(id: number): void {
    if (confirm('Tem certeza que deseja excluir este cliente?')) {
      this.service.excluir(id).subscribe(() => {
        this.carregar();
      });
    }
  }
}
```

---

## 11. Componente de Formulário (Cadastro + Edição)

**Arquivo:** `src/app/features/clientes/cliente-form.ts`

```ts
import { Component, inject, input, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-cliente-form',
  imports: [ReactiveFormsModule, RouterLink],
  template: `
    <h1>{{ isEditMode() ? 'Editar Cliente' : 'Novo Cliente' }}</h1>

    <form [formGroup]="form" (ngSubmit)="salvar()">
      <!-- Nome -->
      <div class="field">
        <label for="nome">Nome *</label>
        <input id="nome" formControlName="nome" />
        @if (nome.invalid && nome.touched) {
          <div class="error">
            @if (nome.errors?.['required']) {
              <span>Nome é obrigatório</span>
            }
            @if (nome.errors?.['minlength']) {
              <span>Mínimo de 3 caracteres</span>
            }
            @if (nome.errors?.['maxlength']) {
              <span>Máximo de 100 caracteres</span>
            }
          </div>
        }
      </div>

      <!-- E-mail -->
      <div class="field">
        <label for="email">E-mail *</label>
        <input id="email" type="email" formControlName="email" />
        @if (email.invalid && email.touched) {
          <div class="error">
            @if (email.errors?.['required']) {
              <span>E-mail é obrigatório</span>
            }
            @if (email.errors?.['email']) {
              <span>E-mail inválido</span>
            }
          </div>
        }
      </div>

      <!-- Telefone -->
      <div class="field">
        <label for="telefone">Telefone *</label>
        <input
          id="telefone"
          formControlName="telefone"
          placeholder="(11) 98765-4321"
        />
        @if (telefone.invalid && telefone.touched) {
          <div class="error">
            @if (telefone.errors?.['required']) {
              <span>Telefone é obrigatório</span>
            }
            @if (telefone.errors?.['pattern']) {
              <span>Formato inválido. Use (99) 99999-9999</span>
            }
          </div>
        }
      </div>

      <!-- Endereço -->
      <div class="field">
        <label for="endereco">Endereço *</label>
        <textarea id="endereco" formControlName="endereco" rows="3"></textarea>
        @if (endereco.invalid && endereco.touched) {
          <div class="error">
            @if (endereco.errors?.['required']) {
              <span>Endereço é obrigatório</span>
            }
            @if (endereco.errors?.['minlength']) {
              <span>Mínimo de 10 caracteres</span>
            }
          </div>
        }
      </div>

      <div class="actions">
        <button type="submit" class="btn btn-primary" [disabled]="form.invalid || saving()">
          {{ saving() ? 'Salvando...' : 'Salvar' }}
        </button>
        <a routerLink="/clientes" class="btn btn-secondary">Cancelar</a>
      </div>
    </form>
  `,
  styles: [`
    .field {
      margin-bottom: 1.25rem;
    }
    label {
      display: block;
      font-weight: 600;
      margin-bottom: 0.35rem;
    }
    input, textarea {
      width: 100%;
      padding: 0.5rem 0.75rem;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 1rem;
    }
    input.ng-invalid.ng-touched,
    textarea.ng-invalid.ng-touched {
      border-color: #e53935;
    }
    .error {
      color: #e53935;
      font-size: 0.875rem;
      margin-top: 0.25rem;
    }
    .actions {
      display: flex;
      gap: 0.75rem;
      margin-top: 1.5rem;
    }
  `]
})
export class ClienteForm implements OnInit {
  private readonly fb = inject(FormBuilder);
  private readonly service = inject(ClienteService);
  private readonly router = inject(Router);

  /** Parâmetro de rota :id (graças ao withComponentInputBinding) */
  id = input<string | undefined>();

  saving = signal(false);

  form = this.fb.nonNullable.group({
    nome: ['', [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(100)
    ]],
    email: ['', [
      Validators.required,
      Validators.email
    ]],
    telefone: ['', [
      Validators.required,
      Validators.pattern(/^\(\d{2}\) \d{4,5}-\d{4}$/)
    ]],
    endereco: ['', [
      Validators.required,
      Validators.minLength(10)
    ]]
  });

  // Atalhos para o template
  get nome()     { return this.form.controls.nome; }
  get email()    { return this.form.controls.email; }
  get telefone() { return this.form.controls.telefone; }
  get endereco() { return this.form.controls.endereco; }

  isEditMode = () => !!this.id();

  ngOnInit(): void {
    const id = this.id();
    if (id) {
      this.service.buscarPorId(+id).subscribe(cliente => {
        this.form.patchValue(cliente);
      });
    }
  }

  salvar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.saving.set(true);
    const valor = this.form.getRawValue();
    const id = this.id();

    const request$ = id
      ? this.service.atualizar(+id, valor)
      : this.service.criar(valor);

    request$.subscribe({
      next: () => {
        this.saving.set(false);
        this.router.navigate(['/clientes']);
      },
      error: () => {
        this.saving.set(false);
        alert('Erro ao salvar cliente. Tente novamente.');
      }
    });
  }
}
```

---

## 12. Componente de Detalhes

**Arquivo:** `src/app/features/clientes/cliente-detail.ts`

```ts
import { Component, inject, input, signal, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ClienteService } from './cliente.service';
import { Cliente } from './cliente.model';

@Component({
  selector: 'app-cliente-detail',
  imports: [RouterLink],
  template: `
    <div class="header">
      <h1>Detalhes do Cliente</h1>
      <div class="actions">
        <a [routerLink]="['/clientes', cliente()?.id, 'editar']" class="btn btn-edit">
          Editar
        </a>
        <a routerLink="/clientes" class="btn btn-secondary">Voltar</a>
      </div>
    </div>

    @if (cliente(); as c) {
      <div class="card">
        <p><strong>ID:</strong> {{ c.id }}</p>
        <p><strong>Nome:</strong> {{ c.nome }}</p>
        <p><strong>E-mail:</strong> {{ c.email }}</p>
        <p><strong>Telefone:</strong> {{ c.telefone }}</p>
        <p><strong>Endereço:</strong> {{ c.endereco }}</p>
      </div>
    } @else {
      <p>Carregando...</p>
    }
  `,
  styles: [`
    .header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 1.5rem;
    }
    .actions {
      display: flex;
      gap: 0.5rem;
    }
    .card {
      background: #f9f9f9;
      border: 1px solid #e0e0e0;
      border-radius: 8px;
      padding: 1.5rem;
      max-width: 600px;
    }
    .card p {
      margin: 0.75rem 0;
    }
  `]
})
export class ClienteDetail implements OnInit {
  private readonly service = inject(ClienteService);

  id = input.required<string>();
  cliente = signal<Cliente | null>(null);

  ngOnInit(): void {
    this.service.buscarPorId(+this.id()).subscribe(c => {
      this.cliente.set(c);
    });
  }
}
```

---

## 13. Validações Avançadas

No formulário já utilizamos:

| Validador | Campo | Regra |
|-----------|-------|-------|
| `Validators.required` | todos | Campo obrigatório |
| `Validators.minLength(3)` | nome | Mínimo 3 caracteres |
| `Validators.maxLength(100)` | nome | Máximo 100 caracteres |
| `Validators.email` | email | Formato de e-mail |
| `Validators.pattern(...)` | telefone | Máscara `(99) 99999-9999` |
| `Validators.minLength(10)` | endereço | Mínimo 10 caracteres |

### Exemplo de validador customizado (CPF – opcional)

```ts
import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function cpfValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value?.replace(/\D/g, '');
    if (!value) return null;
    if (value.length !== 11) return { cpfInvalido: true };
    // ... lógica completa de validação de CPF
    return null;
  };
}
```

Uso:

```ts
cpf: ['', [Validators.required, cpfValidator()]]
```

---

## 14. Estilos Básicos Globais

**Arquivo:** `src/styles.scss`

```scss
* {
  box-sizing: border-box;
}

body {
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif;
  margin: 0;
  padding: 2rem;
  background: #fafafa;
  color: #222;
}

.btn {
  display: inline-block;
  padding: 0.5rem 1rem;
  border-radius: 6px;
  border: none;
  cursor: pointer;
  text-decoration: none;
  font-size: 0.9rem;
  font-weight: 500;
}

.btn-primary {
  background: #1967d2;
  color: white;
}

.btn-secondary {
  background: #e0e0e0;
  color: #333;
}

.btn-edit {
  background: #f9a825;
  color: #000;
}

.btn-danger {
  background: #d32f2f;
  color: white;
}

.btn-sm {
  padding: 0.3rem 0.6rem;
  font-size: 0.8rem;
}

.btn:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}
```

---

## 15. Como Rodar o Projeto

Abra **dois terminais**:

**Terminal 1 – JSON Server**
```bash
npm run server
```

**Terminal 2 – Angular**
```bash
npm start
```

Acesse: [http://localhost:4200](http://localhost:4200)

---

## 16. Melhorias Possíveis (próximos passos)

| Melhoria | Como fazer |
|----------|------------|
| Loading global | Signal `loading` + spinner |
| Toast de sucesso/erro | Biblioteca leve ou componente próprio |
| Paginação | JSON Server suporta `_page` e `_limit` |
| Ordenação | Parâmetros `_sort` e `_order` |
| Máscara de telefone | Diretiva ou biblioteca (ngx-mask) |
| Confirmação de exclusão mais elegante | Dialog do Angular CDK |
| Auth + Interceptor JWT | Functional interceptor |
| Testes | Vitest + Testing Library |
| Signal Forms | Migrar o formulário para a nova API estável do Angular 22 |
| SSR + Hydration | Adicionar `--ssr` e `provideClientHydration` |

---

## 17. Checklist Final

- [ ] Projeto criado com Angular 22
- [ ] JSON Server rodando na porta 3000
- [ ] Interface `Cliente` criada
- [ ] `ClienteService` com CRUD completo
- [ ] `app.config.ts` com `provideZonelessChangeDetection`, `provideRouter` e `provideHttpClient(withFetch())`
- [ ] Rotas lazy-loaded por feature
- [ ] Listagem com Signals + `@for` + pesquisa
- [ ] Formulário reativo com validações e mensagens de erro
- [ ] Tela de detalhes
- [ ] Exclusão com confirmação
- [ ] Navegação funcionando entre todas as telas
- [ ] Estilos básicos aplicados

---

## Conclusão

Você construiu uma aplicação **CRUD completa** utilizando as práticas mais modernas do Angular 22:

- Standalone Components
- Signals para estado
- Reactive Forms com validações robustas
- Control Flow nativo
- HttpClient com Fetch
- Zoneless Change Detection
- Organização por features
- Lazy loading de rotas

Este projeto serve como base sólida para qualquer aplicação real.

---

**Próximos tutoriais sugeridos**

1. Migrar o formulário para **Signal Forms** (stable no Angular 22)
2. Adicionar autenticação JWT + functional interceptors
3. Implementar paginação e ordenação no grid
4. Adicionar testes com Vitest
5. Transformar em PWA com Service Worker
