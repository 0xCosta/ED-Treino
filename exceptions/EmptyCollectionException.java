package exceptions;

/**
 * Exceção lançada quando se tenta aceder ou remover elementos de uma coleção
 * que se encontra vazia.
 */
public class EmptyCollectionException extends Exception {

    /**
     * Cria uma nova instância de EmptyCollectionException com mensagem por omissão.
     */
    public EmptyCollectionException() {
        super("A coleção está vazia.");
    }

    /**
     * Cria uma instância de EmptyCollectionException com a mensagem especificada.
     *
     * @param msg a mensagem de detalhe
     */
    public EmptyCollectionException(String msg) {
        super(msg);
    }
}

