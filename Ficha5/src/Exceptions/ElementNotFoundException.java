package Ficha5.src.Exceptions;

/**
 * Exceção lançada quando se tenta aceder ou remover um elemento que
 * não existe na coleção.
 */
public class ElementNotFoundException extends Exception {

    /**
     * Cria uma nova instância de <code>ElementNotFoundException</code> com uma
     * mensagem por omissão.
     */
    public ElementNotFoundException() {
        super("O elemento não foi encontrado na coleção.");
    }

    /**
     * Cria uma instância de <code>ElementNotFoundException</code> com a mensagem
     * especificada.
     *
     * @param msg a mensagem de detalhe
     */
    public ElementNotFoundException(String msg) {
        super(msg);
    }
}
