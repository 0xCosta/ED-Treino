package ADTs;

import exceptions.EmptyCollectionException;

/**
 * Interface que define o Tipo Abstrato de Dados (ADT) para uma Fila (Queue).
 * Funciona segundo o princípio FIFO (First In, First Out).
 *
 * @param <T> o tipo dos elementos guardados na fila
 */
public interface QueueADT<T> {

    /**
     * Adiciona um elemento ao fim (cauda) da fila.
     *
     * @param element elemento a ser inserido na fila
     */
    public void enqueue(T element);

    /**
     * Remove e devolve o elemento no início (cabeça) da fila.
     *
     * @return o elemento removido do início da fila
     * @throws EmptyCollectionException se a fila estiver vazia
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     * Devolve o elemento no início da fila sem o remover.
     *
     * @return o elemento no início da fila
     * @throws EmptyCollectionException se a fila estiver vazia
     */
    public T first() throws EmptyCollectionException;

    /**
     * Verifica se a fila está vazia.
     *
     * @return true se a fila não contiver elementos, false caso contrário
     */
    public boolean isEmpty();

    /**
     * Devolve o número de elementos presentes na fila.
     *
     * @return o número de elementos na fila
     */
    public int size();

    /**
     * Devolve uma representação em formato String da fila.
     *
     * @return a representação textual da fila
     */
    @Override
    public String toString();
}

