package Ficha5.src;

/**
 * Interface que define o Tipo Abstrato de Dados (ADT) para uma Lista Ordenada
 * (Ordered List).
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public interface OrderedListADT<T> extends ListADT<T> {

    /**
     * Adiciona o elemento especificado a esta lista na posição correta
     * de acordo com a sua ordenação.
     *
     * @param element o elemento a ser adicionado a esta lista
     */
    public void add(T element);
}