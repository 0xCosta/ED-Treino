package Ficha5.src.Exceptions;

/**
 * Exceção lançada quando se tenta aceder ou remover elementos de uma coleção
 * que está vazia.
 */
public class EmptyCollectionException extends Exception {

    /**
     * Cria uma nova instância de <code>EmptyCollectionException</code> sem mensagem
     * de detalhe.
     */
    public EmptyCollectionException() {
        super("A coleção está vazia.");
    }

    /**
     * Cria uma instância de <code>EmptyCollectionException</code> com a mensagem
     * especificada.
     *
     * @param msg a mensagem de detalhe
     */
    public EmptyCollectionException(String msg) {
        super(msg);
    }
}
