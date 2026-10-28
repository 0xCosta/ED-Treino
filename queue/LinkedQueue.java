package queue;

import ADTs.QueueADT;
import exceptions.EmptyCollectionException;
import nodes.LinearNode;

/**
 * Implementação de uma Fila (Queue) baseada numa lista simplesmente ligada.
 * Funciona segundo o princípio FIFO (First In, First Out).
 *
 * @param <T> o tipo dos elementos guardados na fila
 */
public class LinkedQueue<T> implements QueueADT<T> {

    /**
     * Referência para o nó no início (cabeça) da fila.
     */
    private LinearNode<T> head;

    /**
     * Referência para o nó no fim (cauda) da fila.
     */
    private LinearNode<T> tail;

    /**
     * Número atual de elementos na fila.
     */
    private int size;

    /**
     * Cria uma fila ligada vazia.
     */
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Cria uma fila ligada contendo inicialmente o elemento especificado.
     *
     * @param element o primeiro elemento a inserir na fila
     */
    public LinkedQueue(T element) {
        this.head = new LinearNode<>(element);
        this.tail = this.head;
        this.size = 1;
    }

    /**
     * Adiciona o elemento especificado ao fim (cauda) desta fila.
     *
     * @param element o elemento a ser adicionado
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }

        this.tail = newNode;
        this.size++;
    }

    /**
     * Remove e devolve o elemento situado no início (cabeça) desta fila.
     *
     * @return o elemento removido do início da fila
     * @throws EmptyCollectionException se a fila estiver vazia
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A fila está vazia.");
        }

        T removed = this.head.getElement();
        this.head = this.head.getNext();
        this.size--;

        if (isEmpty()) {
            this.tail = null;
        }

        return removed;
    }

    /**
     * Devolve o elemento no início desta fila sem o remover.
     *
     * @return o elemento atualmente no início da fila
     * @throws EmptyCollectionException se a fila estiver vazia
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A fila está vazia.");
        }
        return this.head.getElement();
    }

    /**
     * Verifica se a fila está vazia.
     *
     * @return true se a fila não contiver elementos, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Devolve o número atual de elementos na fila.
     *
     * @return a contagem de elementos na fila
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Devolve uma representação em formato String desta fila,
     * do início até ao fim.
     *
     * @return a representação textual da fila
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        LinearNode<T> p = this.head;

        while (p != null) {
            s.append(p.getElement().toString()).append("\n");
            p = p.getNext();
        }

        return s.toString();
    }
}
