package exceptions;

/**
 * Exceção lançada quando se tenta adicionar ou comparar um elemento que
 * não implementa a interface Comparable numa coleção ordenada.
 */
public class NonComparableElementException extends RuntimeException {

    /**
     * Cria uma nova instância de NonComparableElementException com mensagem por omissão.
     */
    public NonComparableElementException() {
        super("O elemento não implementa a interface Comparable.");
    }

    /**
     * Cria uma instância de NonComparableElementException com a mensagem especificada.
     *
     * @param collection o nome da coleção ou mensagem de detalhe
     */
    public NonComparableElementException(String collection) {
        super("A coleção " + collection + " requer elementos comparáveis.");
    }
}

