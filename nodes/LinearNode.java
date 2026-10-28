package nodes;

/**
 * Representa um nó (node) numa estrutura simplesmente ligada.
 *
 * @param <T> o tipo do elemento guardado no nó
 */
public class LinearNode<T> {

    /**
     * Referência para o próximo node na lista.
     */
    private LinearNode<T> next;

    /**
     * Elemento armazenado neste node.
     */
    private T element;

    /**
     * Cria um node vazio.
     */
    public LinearNode() {
        this.next = null;
        this.element = null;
    }

    /**
     * Cria um node que armazena o elemento especificado.
     *
     * @param element elemento a ser armazenado
     */
    public LinearNode(T element) {
        this.element = element;
        this.next = null;
    }

    /**
     * Retorna o node que se segue a este.
     *
     * @return referência para o próximo node
     */
    public LinearNode<T> getNext() {
        return this.next;
    }

    /**
     * Define o node que se segue a este.
     *
     * @param node node que se segue a este
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    /**
     * Retorna o elemento armazenado neste node.
     *
     * @return elemento armazenado neste node
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Define o elemento armazenado neste node.
     *
     * @param element elemento a ser armazenado neste node
     */
    public void setElement(T element) {
        this.element = element;
    }
}

