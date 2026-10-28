package queue;

import ADTs.QueueADT;
import exceptions.EmptyCollectionException;

/**
 * Implementação de uma Fila (Queue) circular baseada num array.
 * Funciona segundo o princípio FIFO (First In, First Out).
 *
 * @param <T> o tipo dos elementos guardados na fila
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    /**
     * Capacidade inicial padrão da fila circular.
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Array onde os elementos da fila são guardados circularmente.
     */
    private T[] queue;

    /**
     * Índice que aponta para o elemento na frente (cabeça) da fila.
     */
    private int head;

    /**
     * Índice que aponta para a próxima posição disponível na cauda da fila.
     */
    private int tail;

    /**
     * Número atual de elementos presentes na fila.
     */
    private int count;

    /**
     * Cria uma fila circular vazia com a capacidade por omissão (10).
     */
    public CircularArrayQueue() {
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Cria uma fila circular vazia com a capacidade inicial especificada.
     *
     * @param initialCapacity a capacidade inicial da fila
     */
    public CircularArrayQueue(int initialCapacity) {
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.queue = (T[]) new Object[initialCapacity];
    }

    /**
     * Adiciona o elemento especificado ao fim (cauda) desta fila.
     * Expande a capacidade se a fila estiver cheia.
     *
     * @param element o elemento a ser adicionado
     */
    @Override
    public void enqueue(T element) {
        if (this.size() == queue.length) {
            expandCapacity();
        }
        this.queue[this.tail] = element;
        this.tail = (this.tail + 1) % queue.length;
        this.count++;
    }

    /**
     * Duplica a capacidade do array e realinha os elementos a partir do índice zero.
     */
    private void expandCapacity() {
        T[] temp = (T[]) new Object[queue.length * 2];

        for (int i = 0; i < count; i++) {
            temp[i] = queue[head];
            head = (head + 1) % queue.length;
        }

        this.head = 0;
        this.tail = this.count;
        this.queue = temp;
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

        T removed = this.queue[this.head];
        this.queue[this.head] = null;
        this.head = (this.head + 1) % queue.length;
        this.count--;

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

        return this.queue[this.head];
    }

    /**
     * Verifica se a fila está vazia.
     *
     * @return true se a fila não contiver elementos, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Devolve o número atual de elementos na fila.
     *
     * @return a contagem de elementos na fila
     */
    @Override
    public int size() {
        return this.count;
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
        int current = this.head;

        for (int i = 0; i < this.count; i++) {
            s.append(this.queue[current].toString()).append("\n");
            current = (current + 1) % this.queue.length;
        }

        return s.toString();
    }
}
