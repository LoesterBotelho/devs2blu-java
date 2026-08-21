# Formulário de Cadastro Completo — Angular 22
## Cadastro + Edição + Pesquisa + Tabela + Paginação (20 registros) + Validação

**Stack oficial Angular 22:**
- Standalone Components
- Signals
- Reactive Forms + Validações
- Control Flow (`@if`, `@for`)
- HttpClient + Fetch
- Paginação no frontend (fácil de adaptar para backend)

---

## 1. Pré-requisitos rápidos

```bash
# Criar projeto (caso ainda não tenha)
ng new clientes-app --routing --style=scss
cd clientes-app

# Instalar json-server (API fake)
npm install -D json-server
```

Crie o arquivo `db.json` na raiz:

```json
{
  "clientes": [
    { "id": 1, "nome": "Ana Silva", "email": "ana@email.com", "telefone": "(11) 98765-4321", "cidade": "São Paulo" },
    { "id": 2, "nome": "Bruno Costa", "email": "bruno@email.com", "telefone": "(21) 91234-5678", "cidade": "Rio de Janeiro" },
    { "id": 3, "nome": "Carla Mendes", "email": "carla@email.com", "telefone": "(31) 99876-5432", "cidade": "Belo Horizonte" }
  ]
}
```

Adicione no `package.json`:

```json
"scripts": {
  "server": "json-server --watch db.json --port 3000"
}
```

Rode em um terminal:

```bash
npm run server
```

---

## 2. Model

**src/app/features/clientes/cliente.model.ts**

```ts
export interface Cliente {
  id?: number;
  nome: string;
  email: string;
  telefone: string;
  cidade: string;
}
```

---

## 3. Service

**src/app/features/clientes/cliente.service.ts**

```ts
import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { Cliente } from './cliente.model';

@Injectable({ providedIn: 'root' })
export class ClienteService {
  private http = inject(HttpClient);
  private api = 'http://localhost:3000/clientes';

  listar(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.api).pipe(
      catchError(() => of([]))
    );
  }

  buscarPorId(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.api}/${id}`);
  }

  criar(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.api, cliente);
  }

  atualizar(id: number, cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${this.api}/${id}`, cliente);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/${id}`);
  }
}
```

---

## 4. Configuração Global (app.config.ts)

```ts
import { ApplicationConfig, provideZonelessChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZonelessChangeDetection(),
    provideRouter(routes),
    provideHttpClient(withFetch())
  ]
};
```

---

## 5. Componente Principal (Listagem + Formulário + Paginação)

**src/app/features/clientes/cliente-page.ts**

Este componente faz **tudo**: formulário (cadastrar/editar), pesquisa, tabela e paginação.

```ts
import { Component, inject, signal, computed, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ClienteService } from './cliente.service';
import { Cliente } from './cliente.model';

@Component({
  selector: 'app-cliente-page',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './cliente-page.html',
  styleUrl: './cliente-page.scss'
})
export class ClientePage implements OnInit {
  private fb = inject(FormBuilder);
  private service = inject(ClienteService);

  // ===== ESTADO =====
  clientes = signal<Cliente[]>([]);
  clienteEditando = signal<Cliente | null>(null);
  termoPesquisa = signal('');
  paginaAtual = signal(1);
  itensPorPagina = 20;               // ← 20 registros por página

  // ===== FORMULÁRIO COM VALIDAÇÕES =====
  form = this.fb.nonNullable.group({
    nome: ['', [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(80)
    ]],
    email: ['', [
      Validators.required,
      Validators.email
    ]],
    telefone: ['', [
      Validators.required,
      Validators.pattern(/^\(\d{2}\) \d{4,5}-\d{4}$/)
    ]],
    cidade: ['', [
      Validators.required,
      Validators.minLength(2)
    ]]
  });

  // Atalhos para o template
  get nome()     { return this.form.controls.nome; }
  get email()    { return this.form.controls.email; }
  get telefone() { return this.form.controls.telefone; }
  get cidade()   { return this.form.controls.cidade; }

  // ===== LISTA FILTRADA =====
  clientesFiltrados = computed(() => {
    const termo = this.termoPesquisa().toLowerCase().trim();
    if (!termo) return this.clientes();

    return this.clientes().filter(c =>
      c.nome.toLowerCase().includes(termo) ||
      c.email.toLowerCase().includes(termo) ||
      c.cidade.toLowerCase().includes(termo)
    );
  });

  // ===== PAGINAÇÃO =====
  totalPaginas = computed(() =>
    Math.ceil(this.clientesFiltrados().length / this.itensPorPagina) || 1
  );

  clientesPaginados = computed(() => {
    const inicio = (this.paginaAtual() - 1) * this.itensPorPagina;
    return this.clientesFiltrados().slice(inicio, inicio + this.itensPorPagina);
  });

  // Array de números das páginas (1 2 3 ...)
  paginas = computed(() => {
    const total = this.totalPaginas();
    return Array.from({ length: total }, (_, i) => i + 1);
  });

  // ===== CICLO DE VIDA =====
  ngOnInit() {
    this.carregar();
  }

  carregar() {
    this.service.listar().subscribe(lista => {
      this.clientes.set(lista);
      this.paginaAtual.set(1); // volta para a primeira página
    });
  }

  // ===== PESQUISA =====
  pesquisar(valor: string) {
    this.termoPesquisa.set(valor);
    this.paginaAtual.set(1);
  }

  // ===== SALVAR (com validação obrigatória) =====
  salvar() {
    // 1. Força a validação de todos os campos
    this.form.markAllAsTouched();

    // 2. Se o formulário estiver inválido → NÃO salva
    if (this.form.invalid) {
      return;
    }

    const dados = this.form.getRawValue();
    const editando = this.clienteEditando();

    if (editando?.id) {
      // ===== EDITAR =====
      this.service.atualizar(editando.id, dados).subscribe(() => {
        this.resetarFormulario();
        this.carregar();
      });
    } else {
      // ===== CADASTRAR =====
      this.service.criar(dados).subscribe(() => {
        this.resetarFormulario();
        this.carregar();
      });
    }
  }

  // ===== EDITAR =====
  editar(cliente: Cliente) {
    this.clienteEditando.set(cliente);
    this.form.patchValue({
      nome: cliente.nome,
      email: cliente.email,
      telefone: cliente.telefone,
      cidade: cliente.cidade
    });
    // Rola a página até o formulário
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  // ===== EXCLUIR =====
  excluir(id: number) {
    if (confirm('Tem certeza que deseja excluir este cliente?')) {
      this.service.excluir(id).subscribe(() => this.carregar());
    }
  }

  // ===== CANCELAR =====
  cancelar() {
    this.resetarFormulario();
  }

  private resetarFormulario() {
    this.form.reset();
    this.clienteEditando.set(null);
  }

  // ===== NAVEGAÇÃO DE PÁGINAS =====
  irParaPagina(pagina: number) {
    if (pagina >= 1 && pagina <= this.totalPaginas()) {
      this.paginaAtual.set(pagina);
    }
  }

  paginaAnterior() {
    this.irParaPagina(this.paginaAtual() - 1);
  }

  proximaPagina() {
    this.irParaPagina(this.paginaAtual() + 1);
  }

  // Helper de validação no template
  campoInvalido(campo: 'nome' | 'email' | 'telefone' | 'cidade'): boolean {
    const control = this.form.get(campo);
    return !!(control && control.invalid && control.touched);
  }
}
```

---

## 6. Template HTML

**src/app/features/clientes/cliente-page.html**

```html
<div class="container">

  <!-- ==================== FORMULÁRIO ==================== -->
  <section class="card form-card">
    <h2>
      {{ clienteEditando() ? 'Editar Cliente' : 'Cadastrar Cliente' }}
    </h2>

    <form [formGroup]="form" (ngSubmit)="salvar()">

      <!-- Nome -->
      <div class="campo">
        <label for="nome">Nome *</label>
        <input id="nome" type="text" formControlName="nome"
               placeholder="Digite o nome completo">
        @if (campoInvalido('nome')) {
          <small class="erro">
            @if (nome.errors?.['required']) { Nome é obrigatório }
            @else if (nome.errors?.['minlength']) { Mínimo 3 caracteres }
            @else if (nome.errors?.['maxlength']) { Máximo 80 caracteres }
          </small>
        }
      </div>

      <!-- E-mail -->
      <div class="campo">
        <label for="email">E-mail *</label>
        <input id="email" type="email" formControlName="email"
               placeholder="exemplo@email.com">
        @if (campoInvalido('email')) {
          <small class="erro">
            @if (email.errors?.['required']) { E-mail é obrigatório }
            @else if (email.errors?.['email']) { E-mail inválido }
          </small>
        }
      </div>

      <!-- Telefone -->
      <div class="campo">
        <label for="telefone">Telefone *</label>
        <input id="telefone" type="text" formControlName="telefone"
               placeholder="(11) 98765-4321">
        @if (campoInvalido('telefone')) {
          <small class="erro">
            @if (telefone.errors?.['required']) { Telefone é obrigatório }
            @else if (telefone.errors?.['pattern']) { Formato: (99) 99999-9999 }
          </small>
        }
      </div>

      <!-- Cidade -->
      <div class="campo">
        <label for="cidade">Cidade *</label>
        <input id="cidade" type="text" formControlName="cidade"
               placeholder="Cidade">
        @if (campoInvalido('cidade')) {
          <small class="erro">
            @if (cidade.errors?.['required']) { Cidade é obrigatória }
            @else if (cidade.errors?.['minlength']) { Mínimo 2 caracteres }
          </small>
        }
      </div>

      <!-- BOTÕES -->
      <div class="botoes">
        <!-- Botão principal: Salvar (só envia se estiver válido) -->
        <button type="submit" class="btn btn-primary"
                [disabled]="form.invalid">
          {{ clienteEditando() ? 'Atualizar' : 'Cadastrar' }}
        </button>

        <!-- Botão secundário: Cancelar (aparece só na edição) -->
        @if (clienteEditando()) {
          <button type="button" class="btn btn-secondary" (click)="cancelar()">
            Cancelar
          </button>
        }
      </div>
    </form>
  </section>

  <!-- ==================== PESQUISA ==================== -->
  <section class="pesquisa">
    <input
      type="search"
      placeholder="Pesquisar por nome, e-mail ou cidade..."
      (input)="pesquisar($any($event.target).value)"
    >
  </section>

  <!-- ==================== TABELA / GRID ==================== -->
  <section class="card">
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>E-mail</th>
          <th>Telefone</th>
          <th>Cidade</th>
          <th>Ações</th>
        </tr>
      </thead>
      <tbody>
        @for (cliente of clientesPaginados(); track cliente.id) {
          <tr>
            <td>{{ cliente.id }}</td>
            <td>{{ cliente.nome }}</td>
            <td>{{ cliente.email }}</td>
            <td>{{ cliente.telefone }}</td>
            <td>{{ cliente.cidade }}</td>
            <td class="acoes">
              <button class="btn btn-sm btn-edit" (click)="editar(cliente)">
                Editar
              </button>
              <button class="btn btn-sm btn-danger" (click)="excluir(cliente.id!)">
                Excluir
              </button>
            </td>
          </tr>
        } @empty {
          <tr>
            <td colspan="6" class="vazio">Nenhum cliente encontrado</td>
          </tr>
        }
      </tbody>
    </table>

    <!-- ==================== PAGINAÇÃO ==================== -->
    <div class="paginacao">
      <button
        class="btn btn-sm"
        (click)="paginaAnterior()"
        [disabled]="paginaAtual() === 1">
        ← Anterior
      </button>

      <!-- Números das páginas: 1 2 3 ... -->
      @for (pagina of paginas(); track pagina) {
        <button
          class="btn btn-sm"
          [class.ativa]="pagina === paginaAtual()"
          (click)="irParaPagina(pagina)">
          {{ pagina }}
        </button>
      }

      <button
        class="btn btn-sm"
        (click)="proximaPagina()"
        [disabled]="paginaAtual() === totalPaginas()">
        Próxima →
      </button>

      <span class="info">
        Página {{ paginaAtual() }} de {{ totalPaginas() }}
        ({{ clientesFiltrados().length }} registros)
      </span>
    </div>
  </section>
</div>
```

---

## 7. Estilos (SCSS)

**src/app/features/clientes/cliente-page.scss**

```scss
.container {
  max-width: 1100px;
  margin: 2rem auto;
  padding: 0 1rem;
  font-family: system-ui, sans-serif;
}

.card {
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0,0,0,.08);
  padding: 1.5rem;
  margin-bottom: 1.5rem;
}

.form-card h2 {
  margin-top: 0;
  color: #1967d2;
}

.campo {
  margin-bottom: 1.1rem;

  label {
    display: block;
    font-weight: 600;
    margin-bottom: .3rem;
  }

  input {
    width: 100%;
    padding: .55rem .75rem;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 1rem;

    &.ng-invalid.ng-touched {
      border-color: #d32f2f;
    }
  }
}

.erro {
  color: #d32f2f;
  font-size: .85rem;
  margin-top: .25rem;
  display: block;
}

.botoes {
  display: flex;
  gap: .75rem;
  margin-top: 1.5rem;
}

.btn {
  padding: .55rem 1.2rem;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-weight: 500;
  font-size: .95rem;

  &:disabled {
    opacity: .55;
    cursor: not-allowed;
  }
}

.btn-primary { background: #1967d2; color: white; }
.btn-secondary { background: #e0e0e0; color: #333; }
.btn-edit { background: #f9a825; color: #000; }
.btn-danger { background: #d32f2f; color: white; }
.btn-sm { padding: .3rem .7rem; font-size: .85rem; }

.pesquisa {
  margin-bottom: 1rem;

  input {
    width: 100%;
    max-width: 420px;
    padding: .6rem 1rem;
    border: 1px solid #ccc;
    border-radius: 8px;
    font-size: 1rem;
  }
}

table {
  width: 100%;
  border-collapse: collapse;

  th, td {
    padding: .75rem;
    text-align: left;
    border-bottom: 1px solid #eee;
  }

  th {
    background: #f5f7fa;
    font-weight: 600;
  }
}

.acoes {
  display: flex;
  gap: .4rem;
}

.vazio {
  text-align: center;
  color: #888;
  padding: 2rem !important;
}

.paginacao {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: .4rem;
  margin-top: 1.25rem;

  .btn.ativa {
    background: #1967d2;
    color: white;
  }

  .info {
    margin-left: 1rem;
    color: #666;
    font-size: .9rem;
  }
}
```

---

## 8. Como usar

1. Crie a pasta e os arquivos acima.
2. No `app.routes.ts`:

```ts
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'clientes', pathMatch: 'full' },
  {
    path: 'clientes',
    loadComponent: () =>
      import('./features/clientes/cliente-page').then(m => m.ClientePage)
  }
];
```

3. Rode os dois terminais:

```bash
# Terminal 1
npm run server

# Terminal 2
ng serve
```

4. Acesse: http://localhost:4200/clientes

---

## Funcionalidades implementadas

| Funcionalidade | Como foi feito |
|----------------|----------------|
| **Cadastrar** | `POST` + formulário limpo |
| **Editar** | `patchValue` + `PUT` |
| **Validação antes de salvar** | `markAllAsTouched()` + `if (form.invalid) return` |
| **Mensagens de erro** | `@if` + `errors` de cada controle |
| **Botão Salvar desabilitado** | `[disabled]="form.invalid"` |
| **Pesquisa** | Signal + `computed` filtrando nome/email/cidade |
| **Tabela / Grid** | `@for` com `track` |
| **Paginação 20 registros** | `slice` no `computed` |
| **Números das páginas** | Array gerado dinamicamente (1 2 3…) |
| **Anterior / Próxima** | Botões com disabled nas extremidades |
| **Excluir** | Confirmação + `DELETE` |

---

## Resumo das Validações

| Campo | Regras |
|-------|--------|
| Nome | Obrigatório · Mín. 3 · Máx. 80 |
| E-mail | Obrigatório · Formato de e-mail |
| Telefone | Obrigatório · Padrão `(99) 99999-9999` |
| Cidade | Obrigatório · Mín. 2 caracteres |

O botão **Salvar/Atualizar** só fica habilitado quando **todo o formulário está válido**.  
Ao clicar, ainda é chamado `markAllAsTouched()` para garantir que as mensagens de erro apareçam.

---

**Pronto!**  
Você tem um cadastro completo, moderno e alinhado com as melhores práticas do Angular 22.
```
