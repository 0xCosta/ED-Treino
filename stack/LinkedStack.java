package stack;

import ADTs.StackADT;
import exceptions.EmptyCollectionException;
import nodes.LinearNode;

/**
 * Implementação de uma Pilha (Stack) baseada numa lista ligada simples.
 * Funciona segundo o princípio LIFO (Last In, First Out).
 *
 * @param <T> o tipo dos elementos guardados na pilha
 */
public class LinkedStack<T> implements StackADT<T> {

    /**
     * Referência para o nó no topo da pilha.
     */
    private LinearNode<T> head;

    /**
     * Número atual de elementos presentes na pilha.
     */
    private int size;

    /**
     * Cria uma pilha ligada vazia.
     */
    public LinkedStack() {
        this.size = 0;
        this.head = null;
    }

    /**
     * Cria uma pilha ligada contendo inicialmente o elemento especificado.
     *
     * @param element o primeiro elemento a inserir no topo da pilha
     */
    public LinkedStack(T element) {
        this.head = new LinearNode<>(element);
        this.size = 1;
    }

    /**
     * Adiciona o elemento especificado ao topo desta pilha.
     *
     * @param element o elemento a ser adicionado
     */
    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }

    /**
     * Remove e devolve o elemento situado no topo desta pilha.
     *
     * @return o elemento removido do topo da pilha
     * @throws EmptyCollectionException se a pilha estiver vazia
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A pilha está vazia.");
        }

        LinearNode<T> removed = this.head;
        this.head = this.head.getNext();
        removed.setNext(null);
        this.size--;

        return removed.getElement();
    }

    /**
     * Devolve o elemento no topo desta pilha sem o remover.
     *
     * @return o elemento atualmente no topo da pilha
     * @throws EmptyCollectionException se a pilha estiver vazia
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("A pilha está vazia.");
        }

        return this.head.getElement();
    }

    /**
     * Verifica se a pilha está vazia.
     *
     * @return true se a pilha não contiver elementos, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Devolve o número atual de elementos na pilha.
     *
     * @return a contagem de elementos na pilha
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Devolve uma representação em formato String desta pilha,
     * do topo até à base.
     *
     * @return a representação textual da pilha
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
