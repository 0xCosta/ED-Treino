package Ficha5.src;

import java.util.Iterator;

/**
 * Interface que define o Tipo Abstrato de Dados (ADT) para uma Lista (List).
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public interface ListADT<T> extends Iterable<T> {
    /**
     * Remove e devolve o primeiro elemento desta lista.
     *
     * @return o primeiro elemento desta lista
     */
    public T removeFirst();

    /**
     * Remove e devolve o último elemento desta lista.
     *
     * @return o último elemento desta lista
     */
    public T removeLast();

    /**
     * Remove e devolve o elemento especificado desta lista.
     *
     * @param element o elemento a ser removido da lista
     * @return o elemento removido da lista
     */
    public T remove(T element);

    /**
     * Devolve uma referência para o primeiro elemento desta lista.
     * 
     * @return uma referência para o primeiro elemento desta lista
     */
    public T first();

    /**
     * Devolve uma referência para o último elemento desta lista.
     * 
     * @return uma referência para o último elemento desta lista
     */
    public T last();

    /**
     * Devolve true se esta lista contiver o elemento especificado.
     * 
     * @param target o elemento a procurar na lista
     * @return true se a lista contiver este elemento, false caso contrário
     */
    public boolean contains(T target);

    /**
     * Verifica se a lista está vazia.
     * 
     * @return true se a lista não contiver elementos, false caso contrário
     */
    public boolean isEmpty();

    /**
     * Devolve o número de elementos presentes nesta lista.
     *
     * @return o número de elementos nesta lista
     */
    public int size();

    /**
     * Devolve um iterador para os elementos desta lista.
     *
     * @return um iterador sobre os elementos desta lista
     */
    public Iterator<T> iterator();

    /**
     * Devolve uma representação em formato String desta lista.
     *
     * @return a representação textual desta lista
     */
    @Override
    public String toString();

}
