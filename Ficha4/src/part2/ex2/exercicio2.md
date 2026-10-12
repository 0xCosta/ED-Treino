# Exercício 2 - Análise de Complexidade (Big O) da Operação `dequeue`

## Pergunta
> **Qual o Big O para a operação `dequeue` nas diferentes implementações de uma Queue: array, array circular e lista ligada?**

---

## Tabela Resumo

| Implementação de Queue | Complexidade de `dequeue` | Justificação |
| :--- | :---: | :--- |
| **Array Linear (normal)** | **$O(N)$** | Ao remover no índice `0`, todos os restantes $N - 1$ elementos têm de ser deslocados uma posição para a esquerda para manter a continuidade a partir do início. |
| **Array Circular** | **$O(1)$** | O elemento é lido diretamente de `queue[head]`, a referência é limpa (`null`) e o índice avança usando `(head + 1) % queue.length`. Nenhum elemento é movido. |
| **Lista Ligada (`LinkedQueue`)** | **$O(1)$** | Basta aceder ao nó apontado por `head`, atualizar a referência para o próximo nó (`head = head.getNext()`) e decrementar o contador de tamanho. É uma operação local e direta. |

---

## Detalhe de cada implementação

### 1. Array Linear (Normal) - $O(N)$
* Num array linear com `front` fixo na posição `0`:
  ```java
  T removed = queue[0];
  for (int i = 0; i < count - 1; i++) {
      queue[i] = queue[i + 1]; // Desloca N-1 elementos
  }
  queue[count - 1] = null;
  count--;
  ```
* O ciclo `for` executa $N - 1$ iterações proporcionais ao número de elementos $N$, logo a complexidade é **$O(N)$**.

### 2. Array Circular - $O(1)$
* Com ponteiros circulares de início (`head`) e fim (`tail`):
  ```java
  T removed = queue[head];
  queue[head] = null;
  head = (head + 1) % queue.length; // Avanço circular em tempo constante
  count--;
  ```
* Executa um número constante de instruções aritméticas independentemente do tamanho da fila $N$, logo a complexidade é **$O(1)$**.

### 3. Lista Ligada (`LinkedQueue`) - $O(1)$
* Com referências de nós dinâmicos:
  ```java
  T removed = head.getElement();
  head = head.getNext(); // Avança a referência direta
  size--;
  ```
* Requer apenas a reatribuição de um ponteiro, sendo estritamente **$O(1)$**.
