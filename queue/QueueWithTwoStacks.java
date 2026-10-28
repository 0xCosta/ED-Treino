package queue;

import ADTs.QueueADT;
import ADTs.StackADT;
import exceptions.EmptyCollectionException;
import stack.ArrayStack;

/**
 * Implementação de uma Fila (Queue) com recurso a duas Pilhas (Stacks).
 * - stackIn: recebe novas inserções (enqueue).
 * - stackOut: fornece as remoções e consultas (dequeue e first).
 *
 * @param <T> o tipo dos elementos guardados na fila
 */
public class QueueWithTwoStacks<T> implements QueueADT<T> {

    /**
     * Pilha de entrada onde novos elementos são inseridos.
     */
    private StackADT<T> stackIn;

    /**
     * Pilha de saída donde os elementos são removidos ou consultados.
     */
    private StackADT<T> stackOut;

    /**
     * Cria uma fila vazia inicializando as duas pilhas internas.
     */
    public QueueWithTwoStacks() {
        this.stackIn = new ArrayStack<>();
        this.stackOut = new ArrayStack<>();
    }

    /**
     * Adiciona o elemento especificado ao fim desta fila (push em stackIn).
     *
     * @param element o elemento a ser adicionado
     */
    @Override
    public void enqueue(T element) {
        this.stackIn.push(element);
    }

    /**
     * Remove e devolve o elemento situado no início desta fila.
     * Transfere elementos de stackIn para stackOut caso stackOut esteja vazia.
     *
     * @return o elemento removido do início da fila
     * @throws EmptyCollectionException se a fila estiver vazia
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A fila está vazia.");
        }

        shiftStacks();

        try {
            return this.stackOut.pop();
        } catch (EmptyCollectionException e) {
            throw new EmptyCollectionException("A fila está vazia.");
        }
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

        shiftStacks();

        try {
            return this.stackOut.peek();
        } catch (EmptyCollectionException e) {
            throw new EmptyCollectionException("A fila está vazia.");
        }
    }

    /**
     * Verifica se a fila está vazia (ambas as pilhas vazias).
     *
     * @return true se a fila não contiver elementos, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return this.stackIn.isEmpty() && this.stackOut.isEmpty();
    }

    /**
     * Devolve o número total de elementos na fila.
     *
     * @return a contagem de elementos na fila
     */
    @Override
    public int size() {
        return this.stackIn.size() + this.stackOut.size();
    }

    /**
     * Método auxiliar privado que transfere todos os elementos da stackIn
     * para a stackOut caso a stackOut se encontre vazia, invertendo a ordem
     * LIFO para produzir o comportamento FIFO.
     */
    private void shiftStacks() {
        if (this.stackOut.isEmpty()) {
            while (!this.stackIn.isEmpty()) {
                try {
                    this.stackOut.push(this.stackIn.pop());
                } catch (EmptyCollectionException e) {
                    break;
                }
            }
        }
    }

    /**
     * Devolve uma representação em formato String dos elementos na fila,
     * da frente até ao fim.
     *
     * @return a representação textual da fila
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueueWithTwoStacks (Frente -> Fim):\n");

        StackADT<T> tempOut = new ArrayStack<>();
        while (!this.stackOut.isEmpty()) {
            try {
                T elem = this.stackOut.pop();
                sb.append("-> ").append(elem).append("\n");
                tempOut.push(elem);
            } catch (EmptyCollectionException e) {
                break;
            }
        }
        while (!tempOut.isEmpty()) {
            try {
                this.stackOut.push(tempOut.pop());
            } catch (EmptyCollectionException e) {
                break;
            }
        }

        StackADT<T> tempIn = new ArrayStack<>();
        while (!this.stackIn.isEmpty()) {
            try {
                tempIn.push(this.stackIn.pop());
            } catch (EmptyCollectionException e) {
                break;
            }
        }
        while (!tempIn.isEmpty()) {
            try {
                T elem = tempIn.pop();
                sb.append("-> ").append(elem).append("\n");
                this.stackIn.push(elem);
            } catch (EmptyCollectionException e) {
                break;
            }
        }

        return sb.toString();
    }
}
