# Exercício 3 - Cenários de Teste

## Pergunta:
> *Os cenários usados nos exercícios anteriores (1 e 2) foram adicionados elementos não comparáveis? O que aconteceu?*

---

### 1. Foram adicionados elementos não comparáveis nos cenários dos exercícios 1 e 2?

* **Nos testes habituais:** **Não.** Nos cenários de demonstração implementados nos exercícios 1 e 2 (`ArrayOrderedListDemo` e `DoubleLinkedOrderedListDemo`), foram utilizados tipos de dados padrão como `Integer` ou `String`. Estes tipos fornecidos pela biblioteca padrão do Java implementam nativamente a interface `java.lang.Comparable` (por exemplo, `Integer implements Comparable<Integer>`), sendo, por isso, **elementos comparáveis**.
* **Caso sejam testados elementos não comparáveis:** Se tentarmos adicionar um objeto de uma classe que **não** implementa a interface `Comparable` (por exemplo, instâncias de `Object` através de `new Object()`, ou de uma classe customizada sem `implements Comparable<T>`), força-se o comportamento limite da lista ordenada.

---

### 2. O que aconteceu / O que acontece se forem adicionados elementos não comparáveis?

O resultado depende da assinatura genérica da classe e da forma como o método `add` foi implementado:

#### A. Implementação clássica com tipo genérico não delimitado (`OrderedList<T>`)
Se a definição da classe for `public class ArrayOrderedList<T> ...` (abordagem clássica de Lewis & Chase):
1. **Em tempo de compilação:** O código **compila sem erros**, uma vez que o compilador aceita qualquer tipo `T` (compatível com `Object`).
2. **Em tempo de execução (*Runtime*):**
   * No método `add(T element)`, para inserir o elemento na posição correta e manter a lista ordenada, a estrutura necessita obrigatoriamente de comparar o novo elemento com os já existentes recorrendo ao método `compareTo()`.
   * Para conseguir invocar esse método, o código efetua um *cast* para a interface `Comparable`:
     ```java
     Comparable<T> comparableElement = (Comparable<T>) element;
     ```
   * **Resultado:**
     * Se for feito o *cast* direto, a JVM lança uma exceção do tipo **`java.lang.ClassCastException`** (por exemplo: `java.lang.Object cannot be cast to class java.lang.Comparable`), terminando a execução do programa de forma abrupta.
     * Se a implementação tiver uma validação defensiva prévia (`if (!(element instanceof Comparable))`), é lançada a exceção prevista pela biblioteca (por exemplo, **`NonComparableElementException`**).

#### B. Implementação com restrição genérica (`OrderedList<T extends Comparable<T>>`)
Se a classe tiver sido declarada forçando que `T` seja comparável (`<T extends Comparable<T>>`):
* **Resultado:** Ocorre um **erro em tempo de compilação** logo na declaração/instanciação da lista (ex.: `ArrayOrderedList<Object> lista = new ArrayOrderedList<>();`), impedindo o código de compilar e garantindo segurança de tipos (*type safety*).

---

### Conclusão

Uma **Lista Ordenada (`OrderedList`)** tem como invariante a manutenção de todos os seus elementos ordenados segundo uma relação de ordem total. Como elementos não comparáveis não possuem uma forma de comparação definida (não implementam `compareTo`), a lista não tem como determinar a sua posição na coleção, resultando numa exceção em tempo de execução (**`ClassCastException`** / **`NonComparableElementException`**) ou num erro de compilação.
