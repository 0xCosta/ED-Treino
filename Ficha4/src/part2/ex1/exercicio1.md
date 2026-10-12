# Exercício 1 - Array Circular vs. Array Normal (como numa Stack)

## Pergunta
> **Porquê que usamos uma implementação em array circular? Porque não um array normal como numa stack?**

---

## Resposta

### 1. A diferença entre os pontos de acesso (Stack vs. Queue)
* **Stack (LIFO):** Todas as operações (`push` e `pop`) acontecem no **mesmo extremo** (o topo da pilha).
  * No array, o topo fica no índice `count - 1`.
  * Ao inserir (`push`), adicionamos na posição `count`.
  * Ao remover (`pop`), retiramos da posição `count - 1`.
  * Nenhum outro elemento precisa de ser deslocado: ambas as operações são **$O(1)$**.

* **Queue (FIFO):** As operações ocorrem em **extremos opostos**:
  * Inserção (`enqueue`) no **fim** (`rear` / `tail`).
  * Remoção (`dequeue`) no **início** (`front` / `head`).

---

### 2. O problema de usar um Array Normal numa Queue
Se usássemos um array linear normal para uma fila:
1. **Com início fixo no índice `0`:**
   * O `enqueue` adiciona no fim: $O(1)$.
   * O `dequeue` retira o elemento do índice `0`. Para manter o início no índice `0`, **todos os restantes elementos têm de ser deslocados uma posição para a esquerda**.
   * Esse deslocamento tem complexidade **$O(N)$**, tornando a fila muito ineficiente para grandes volumes de dados.

2. **Com início móvel sem circularidade:**
   * Se apenas incrementarmos o índice do início a cada `dequeue` (para evitar deslocar elementos), o início e o fim vão avançando para a direita até atingirem o fim do array.
   * As posições libertadas à esquerda tornam-se **inutilizáveis**, provocando um falso esgotamento da capacidade (efeito de "deriva").

---

### 3. A solução: Array Circular
O **Array Circular** liga conceptualmente o fim do array de volta ao início através do operador resto da divisão inteira (módulo `%`):
* `tail = (tail + 1) % queue.length`
* `head = (head + 1) % queue.length`

**Vantagens:**
1. **$O(1)$ garantido:** Tanto o `enqueue` como o `dequeue` demoram tempo constante $O(1)$, pois nunca é necessário deslocar elementos.
2. **Reaproveitamento de memória:** As posições libertadas no início do array voltam a ser preenchidas quando o `tail` dá a volta.
