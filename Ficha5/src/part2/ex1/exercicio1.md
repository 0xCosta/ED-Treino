# Parte II - Exercício 1

## Pergunta:
> *Porquê que não existe um método `add(Element)` na interface `ListADT`?*

---

### Resposta:

A interface **`ListADT`** representa o conceito mais geral e abstrato de uma Lista, servindo como interface base comum para:
1. **Listas Ordenadas (`OrderedListADT`)**
2. **Listas Não Ordenadas (`UnorderedListADT`)**

Não existe um método `add(Element)` comum na `ListADT` pelas seguintes razões essenciais de desenho de software:

1. **Semântica de Inserção Divergente:**
   * Numa **Lista Ordenada**, a posição do novo elemento é estritamente determinada pelo seu valor intrínseco (relação de ordem fornecida pelo método `compareTo`). A assinatura adequada é `add(T element)`.
   * Numa **Lista Não Ordenada**, os elementos não possuem uma ordem natural de comparação. O utilizador deve especificar explicitamente onde o elemento deve ser inserido: à frente (`addToFront(T element)`), atrás (`addToRear(T element)`) ou após determinado elemento (`addAfter(T element, T target)`).

2. **Princípio da Segregação de Interfaces (ISP - SOLID):**
   * Se a interface `ListADT` definisse um método `add(T element)`, não haveria uma semântica clara e universal para ele nas listas não ordenadas (deveria inserir à frente? Atrás?).
   * Ao manter em `ListADT` apenas as operações universais (como `removeFirst()`, `removeLast()`, `remove()`, `first()`, `last()`, `isEmpty()`, `size()`, `iterator()`), delega-se nas subinterfaces a responsabilidade de definir os métodos de inserção condizentes com a sua natureza e invariantes estruturais.

