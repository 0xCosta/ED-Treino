package nodes;

/**
 * Representa um nó (node) numa estrutura duplamente ligada.
 *
 * @param <T> o tipo do elemento guardado no nó
 */
public class DoubleLinearNode<T> {

    private DoubleLinearNode<T> next;
    private DoubleLinearNode<T> previous;
    private T element;

    /**
     * Cria um node vazio.
     */
    public DoubleLinearNode() {
        this.next = null;
        this.previous = null;
        this.element = null;
    }

    /**
     * Cria um node que armazena o elemento especificado.
     *
     * @param element elemento a ser armazenado
     */
    public DoubleLinearNode(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public DoubleLinearNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoubleLinearNode<T> next) {
        this.next = next;
    }

    public DoubleLinearNode<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoubleLinearNode<T> previous) {
        this.previous = previous;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}

