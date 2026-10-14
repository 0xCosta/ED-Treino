package Ficha5.src;

/**
 * Interface que define o Tipo Abstrato de Dados (ADT) para uma Lista Não
 * Ordenada (Unordered List).
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public interface UnorderedListADT<T> extends ListADT<T> {

    /**
     * Adiciona o elemento especificado no início desta lista.
     *
     * @param element o elemento a ser adicionado no início desta lista
     */
    public void addToFront(T element);

    /**
     * Adiciona o elemento especificado no fim desta lista.
     *
     * @param element o elemento a ser adicionado no fim desta lista
     */
    public void addToRear(T element);

    /**
     * Adiciona o elemento especificado após o elemento alvo especificado.
     *
     * @param element o elemento a ser adicionado após o alvo
     * @param target  o elemento após o qual o novo elemento será adicionado
     */
    public void addAfter(T element, T target);
}
