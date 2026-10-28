package exceptions;

/**
 * Exceção lançada quando se tenta aceder ou remover um elemento que
 * não existe na coleção.
 */
public class ElementNotFoundException extends Exception {

    /**
     * Cria uma nova instância de ElementNotFoundException com uma mensagem por omissão.
     */
    public ElementNotFoundException() {
        super("O elemento não foi encontrado na coleção.");
    }

    /**
     * Cria uma instância de ElementNotFoundException com a mensagem especificada.
     *
     * @param msg a mensagem de detalhe
     */
    public ElementNotFoundException(String msg) {
        super(msg);
    }
}

