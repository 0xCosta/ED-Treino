package nodes;

/**
 * Representa um nó (node) numa estrutura duplamente ligada.
 * Possui referências para o nó seguinte e para o nó anterior.
 *
 * @param <T> o tipo do elemento guardado no nó
 */
public class DoubleLinearNode<T> {

    /**
     * Referência para o próximo nó.
     */
    private DoubleLinearNode<T> next;

    /**
     * Referência para o nó anterior.
     */
    private DoubleLinearNode<T> previous;

    /**
     * Elemento armazenado neste nó.
     */
    private T element;

    /**
     * Cria um nó vazio com todas as referências a null.
     */
    public DoubleLinearNode() {
        this.next = null;
        this.previous = null;
        this.element = null;
    }

    /**
     * Cria um nó que armazena o elemento especificado.
     *
     * @param element o elemento a ser armazenado
     */
    public DoubleLinearNode(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    /**
     * Devolve o nó que se segue a este.
     *
     * @return a referência para o próximo nó
     */
    public DoubleLinearNode<T> getNext() {
        return this.next;
    }

    /**
     * Define o nó que se segue a este.
     *
     * @param next o próximo nó
     */
    public void setNext(DoubleLinearNode<T> next) {
        this.next = next;
    }

    /**
     * Devolve o nó anterior a este.
     *
     * @return a referência para o nó anterior
     */
    public DoubleLinearNode<T> getPrevious() {
        return this.previous;
    }

    /**
     * Define o nó anterior a este.
     *
     * @param previous o nó anterior
     */
    public void setPrevious(DoubleLinearNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Devolve o elemento armazenado neste nó.
     *
     * @return o elemento armazenado
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Define o elemento armazenado neste nó.
     *
     * @param element o novo elemento a ser guardado
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
