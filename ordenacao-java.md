# Ordenação em Java sem usar `sort()`

Em Java, é possível ordenar elementos sem usar `Arrays.sort()` ou `Collections.sort()`, implementando algoritmos de ordenação manualmente.

---

# 1. Bubble Sort

Compara elementos vizinhos e os troca de posição quando necessário.

## Exemplo

```java
int[] numeros = {5, 2, 8, 1, 3};

for (int i = 0; i < numeros.length - 1; i++) {
    for (int j = 0; j < numeros.length - 1 - i; j++) {
        if (numeros[j] > numeros[j + 1]) {
            int temp = numeros[j];
            numeros[j] = numeros[j + 1];
            numeros[j + 1] = temp;
        }
    }
}

for (int n : numeros) {
    System.out.print(n + " ");
}
```

### Saída

```text
1 2 3 5 8
```

---

# 2. Selection Sort

Procura o menor elemento e o coloca na posição correta.

## Exemplo

```java
int[] numeros = {5, 2, 8, 1, 3};

for (int i = 0; i < numeros.length - 1; i++) {
    int menor = i;

    for (int j = i + 1; j < numeros.length; j++) {
        if (numeros[j] < numeros[menor]) {
            menor = j;
        }
    }

    int temp = numeros[i];
    numeros[i] = numeros[menor];
    numeros[menor] = temp;
}
```

---

# 3. Insertion Sort

Insere cada elemento na posição correta dentro da parte já ordenada do vetor.

## Exemplo

```java
int[] numeros = {5, 2, 8, 1, 3};

for (int i = 1; i < numeros.length; i++) {
    int chave = numeros[i];
    int j = i - 1;

    while (j >= 0 && numeros[j] > chave) {
        numeros[j + 1] = numeros[j];
        j--;
    }

    numeros[j + 1] = chave;
}
```

---

# Comparação dos Algoritmos

| Algoritmo | Fácil de Entender | Velocidade | Uso Didático |
|------------|------------------|------------|--------------|
| Bubble Sort | ✅ | ❌ | ✅ |
| Selection Sort | ✅ | ❌ | ✅ |
| Insertion Sort | ✅ | ⚠️ | ✅ |
| Quick Sort | ❌ | ✅ | ⚠️ |
| Merge Sort | ❌ | ✅ | ⚠️ |

---

# Ordenando uma Lista sem `Collections.sort()`

```java
List<Integer> lista = new ArrayList<>(List.of(5, 2, 8, 1, 3));

for (int i = 0; i < lista.size() - 1; i++) {
    for (int j = 0; j < lista.size() - 1 - i; j++) {

        if (lista.get(j) > lista.get(j + 1)) {

            int temp = lista.get(j);

            lista.set(j, lista.get(j + 1));
            lista.set(j + 1, temp);
        }
    }
}
```

---

# Resumo

| Algoritmo | Como Funciona |
|------------|----------------|
| Bubble Sort | Troca elementos vizinhos |
| Selection Sort | Seleciona o menor elemento |
| Insertion Sort | Insere na posição correta |
| Quick Sort | Divide e conquista |
| Merge Sort | Divide, ordena e junta |

---

# Quando usar?

- **Aprendizado:** Bubble Sort, Selection Sort e Insertion Sort.
- **Produção:** Quick Sort, Merge Sort ou `Arrays.sort()`.
- **Entrevistas:** É comum pedirem implementação manual de Bubble Sort, Selection Sort ou Insertion Sort para avaliar lógica de programação.

```java
// Ordenação crescente
if (a > b) {
    troca();
}

// Ordenação decrescente
if (a < b) {
    troca();
}
```