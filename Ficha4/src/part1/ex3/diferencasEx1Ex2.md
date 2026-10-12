# Alterações e Diferenças: LinkedQueue (Ex. 1) vs. CircularArrayQueue (Ex. 2)

Para adaptar o cenário de teste do **Exercício 1 (`LinkedQueue`)** para o **Exercício 2 (`CircularArrayQueue`)**, enumeram-se as seguintes alterações e diferenças estruturais:

---

### 1. Alteração na Demonstração (Demo)
* **Instanciação da Estrutura:**
  - **Ex 1:** `LinkedQueue<String> queue = new LinkedQueue<>();`
  - **Ex 2:** `CircularArrayQueue<String> queue = new CircularArrayQueue<>();`
* **Transparência do ADT:** O código de teste (chamadas aos métodos `enqueue`, `dequeue`, `first`, `isEmpty`, `size` e `toString`) manteve-se **100% idêntico**, pois ambas as classes implementam a mesma interface `QueueADT<T>`.

---

### 2. Estrutura Interna e Representação em Memória
* **`LinkedQueue` (Fila Encadeada):**
  - Usa nós ligados em memória dinâmica (`LinearNode<T>`).
  - `head` e `tail` são referências/ponteiros para objetos `LinearNode<T>`.
  - Não tem limite de capacidade inicial.
* **`CircularArrayQueue` (Fila em Array Circular):**
  - Usa um array contíguo em memória (`T[] queue`).
  - `head` e `tail` são **índices inteiros (`int`)**.
  - Mantém uma variável `count` para controlar o número exato de elementos.

---

### 3. Mecanismo de Avanço e Circularidade
* **`LinkedQueue`:** Avança na sequência percorrendo as referências `node.getNext()`.
* **`CircularArrayQueue`:** Usa a operação de **resto da divisão (módulo `%`)**:
  - `tail = (tail + 1) % queue.length` (para inserir)
  - `head = (head + 1) % queue.length` (para remover)
  - Isto permite reaproveitar posições libertadas no início do array sem mover elementos.

---

### 4. Gestão de Capacidade (`expandCapacity`)
* **`LinkedQueue`:** Não precisa de redimensionamento — cria novos nós dinamicamente na Heap à medida que são necessários.
* **`CircularArrayQueue`:** Necessita do método `expandCapacity()` quando `count == queue.length`. Ao duplicar o array, é necessário **reorganizar/re alinhar os elementos** a começar do índice `0`.

---

### Resumo Comparativo

| Característica | LinkedQueue (Ex. 1) | CircularArrayQueue (Ex. 2) |
|---|---|---|
| **Tipo dos ponteiros `head`/`tail`** | Referências a objetos (`LinearNode<T>`) | Índices inteiros (`int`) |
| **Alocação de Memória** | Dinâmica (por cada nó) | Bloco pré-alocado (Array) |
| **Avanço nos elementos** | `node.getNext()` | `(index + 1) % queue.length` |
| **Redimensionamento** | Não necessário | Requer `expandCapacity()` |
| **Uso no Demo** | `new LinkedQueue<>()` | `new CircularArrayQueue<>()` |
