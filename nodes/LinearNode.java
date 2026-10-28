package nodes;

/**
 * Representa um nó (node) numa estrutura simplesmente ligada.
 *
 * @param <T> o tipo do elemento guardado no nó
 */
public class LinearNode<T> {

    /**
     * Referência para o próximo nó na estrutura ligada.
     */
    private LinearNode<T> next;

    /**
     * Elemento armazenado neste nó.
     */
    private T element;

    /**
     * Cria um nó vazio com referências a null.
     */
    public LinearNode() {
        this.next = null;
        this.element = null;
    }

    /**
     * Cria um nó que armazena o elemento especificado.
     *
     * @param element o elemento a ser armazenado
     */
    public LinearNode(T element) {
        this.element = element;
        this.next = null;
    }

    /**
     * Devolve o nó que se segue a este.
     *
     * @return a referência para o próximo nó
     */
    public LinearNode<T> getNext() {
        return this.next;
    }

    /**
     * Define o nó que se segue a este.
     *
     * @param node o próximo nó
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    /**
     * Devolve o elemento armazenado neste nó.
     *
     * @return o elemento armazenado neste nó
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Define o elemento armazenado neste nó.
     *
     * @param element o elemento a ser armazenado neste nó
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Devolve a representação textual do elemento contido no nó.
     *
     * @return a representação em String do elemento
     */
    @Override
    public String toString() {
        return (this.element == null) ? "null" : this.element.toString();
    }
}
