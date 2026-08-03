# Verificação de Integridade de Banco de Dados

A forma de verificar a integridade depende do banco de dados utilizado. No Firebird, por exemplo, é comum utilizar o `gfix` e o `gbak` para identificar e corrigir problemas de corrupção.

## Firebird

### Verificar integridade

```bash
gfix -v -full banco.fdb
```

### Backup e Restore (método recomendado)

O processo de backup e restauração frequentemente detecta problemas estruturais:

```bash
gbak -b banco.fdb backup.fbk
gbak -c backup.fbk banco_novo.fdb
```

---

## SQL Server

Verifica a integridade lógica e física do banco de dados:

```sql
DBCC CHECKDB ('NomeDoBanco');
```

Verificações específicas:

```sql
DBCC CHECKALLOC ('NomeDoBanco');
DBCC CHECKTABLE ('NomeDaTabela');
```

---

## PostgreSQL

### Verificar consistência do banco

```bash
pg_amcheck -d nome_banco
```

### Reconstruir índices

```sql
REINDEX DATABASE nome_banco;
```

### Verificar checksums

```bash
pg_checksums --check
```

> Disponível apenas se o cluster foi criado com checksums habilitados.

---

## MySQL / MariaDB

### Verificar uma tabela

```sql
CHECK TABLE tabela;
```

### Verificar todas as bases

```bash
mysqlcheck -u root -p --all-databases --check
```

### Tentar corrigir problemas

```bash
mysqlcheck -u root -p --auto-repair banco
```

---

## Oracle

### Validar estrutura de uma tabela

```sql
ANALYZE TABLE tabela VALIDATE STRUCTURE;
```

### Verificar arquivos de dados

```bash
dbv FILE=arquivo.dbf
```

---

# Sintomas Comuns de Corrupção

Alguns sinais que podem indicar corrupção do banco de dados:

- Erros de leitura de páginas ou blocos.
- Índices inconsistentes.
- Registros desaparecendo ou duplicados.
- Falhas durante backups.
- Consultas retornando erro em tabelas específicas.
- Mensagens de erro como:
  - `checksum error`
  - `page corruption`
  - `database disk image is malformed`
  - `I/O error`

---

# Equivalência ao Firebird

| Banco | Verificação | Reparo/Reconstrução |
|---------|---------|---------|
| Firebird | `gfix -v -full` | `gbak` + restore |
| SQL Server | `DBCC CHECKDB` | `DBCC CHECKDB ... REPAIR_*` |
| PostgreSQL | `pg_amcheck` | `REINDEX`, restore de backup |
| MySQL/MariaDB | `CHECK TABLE` | `REPAIR TABLE` / `mysqlcheck` |
| Oracle | `ANALYZE TABLE`, `dbv` | RMAN, restore ou reconstrução |

## Recomendação

Independentemente do SGBD, a prática mais segura para detectar corrupção é:

1. Executar verificações periódicas de integridade.
2. Manter backups validados.
3. Realizar testes de restauração regularmente.
4. Monitorar logs do banco e do sistema operacional.
5. Utilizar armazenamento com verificação de integridade (RAID, ZFS, checksums, etc.).

Em termos de conceito, o equivalente mais próximo do processo `gfix` + `gbak` do Firebird é executar uma verificação de integridade seguida de um backup e teste de restauração do banco.