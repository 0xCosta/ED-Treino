package queue;

import ADTs.QueueADT;
import exceptions.EmptyCollectionException;
import nodes.DoubleLinearNode;

/**
 * Implementação de uma Fila (Queue) duplamente ligada.
 * Funciona segundo o princípio FIFO (First In, First Out).
 *
 * @param <T> o tipo dos elementos guardados na fila
 */
public class DoubleLinkedQueue<T> implements QueueADT<T> {

    /**
     * Número atual de elementos na fila.
     */
    private int size;

    /**
     * Referência para o nó no início (frente) da fila.
     */
    private DoubleLinearNode<T> front;

    /**
     * Referência para o nó no fim (cauda) da fila.
     */
    private DoubleLinearNode<T> rear;

    /**
     * Cria uma fila duplamente ligada vazia.
     */
    public DoubleLinkedQueue() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    /**
     * Cria uma fila duplamente ligada contendo inicialmente o elemento especificado.
     *
     * @param element o primeiro elemento a inserir na fila
     */
    public DoubleLinkedQueue(T element) {
        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);
        this.front = newNode;
        this.rear = newNode;
        this.size = 1;
    }

    /**
     * Adiciona o elemento especificado ao fim (cauda) desta fila.
     *
     * @param element o elemento a ser adicionado
     */
    @Override
    public void enqueue(T element) {
        DoubleLinearNode<T> newElement = new DoubleLinearNode<>(element);

        if (isEmpty()) {
            this.front = newElement;
            this.rear = newElement;
        } else {
            this.rear.setNext(newElement);
            newElement.setPrevious(this.rear);
            this.rear = newElement;
        }

        this.size++;
    }

    /**
     * Remove e devolve o elemento situado no início (frente) desta fila.
     *
     * @return o elemento removido do início da fila
     * @throws EmptyCollectionException se a fila estiver vazia
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("A fila está vazia.");
        }

        DoubleLinearNode<T> removedNode = this.front;

        this.front = this.front.getNext();
        this.size--;

        if (isEmpty()) {
            this.rear = null;
        } else {
            this.front.setPrevious(null);
        }

        return removedNode.getElement();
    }

    /**
     * Devolve o elemento no início desta fila sem o remover.
     *
     * @return o elemento atualmente no início da fila
     * @throws EmptyCollectionException se a fila estiver vazia
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("A fila está vazia.");
        }

        return this.front.getElement();
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
     * Devolve uma representação em formato String dos elementos na fila,
     * incluindo referências previous e next de cada nó.
     *
     * @return a representação textual detalhada da fila
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        DoubleLinearNode<T> current = this.front;

        while (current != null) {
            s.append(current.getElement().toString()).append('\n');

            if (current.getPrevious() != null) {
                s.append("anterior: ").append(current.getPrevious().getElement().toString()).append('\n');
            } else {
                s.append("anterior: null \n");
            }

            if (current.getNext() != null) {
                s.append("seguinte: ").append(current.getNext().getElement().toString()).append('\n');
            } else {
                s.append("seguinte: null \n");
            }
            s.append("---\n");

            current = current.getNext();
        }

        return s.toString();
    }
}
