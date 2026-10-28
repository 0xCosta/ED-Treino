package stack;

import ADTs.StackADT;
import exceptions.EmptyCollectionException;

/**
 * Implementação de uma Pilha (Stack) baseada num array dinâmico.
 * Funciona segundo o princípio LIFO (Last In, First Out).
 *
 * @param <T> o tipo dos elementos guardados na pilha
 */
public class ArrayStack<T> implements StackADT<T> {

    /**
     * Capacidade inicial padrão da pilha.
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Array onde os elementos da pilha são armazenados.
     */
    private T[] stack;

    /**
     * Índice que aponta para a próxima posição livre no topo da pilha,
     * representando também o número atual de elementos.
     */
    private int top;

    /**
     * Cria uma pilha vazia com a capacidade por omissão (10).
     */
    public ArrayStack() {
        this.top = 0;
        this.stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Cria uma pilha vazia com a capacidade inicial especificada.
     *
     * @param initialCapacity a capacidade inicial da pilha
     */
    public ArrayStack(int initialCapacity) {
        this.top = 0;
        this.stack = (T[]) new Object[initialCapacity];
    }

    /**
     * Adiciona o elemento especificado ao topo desta pilha.
     * Expande a capacidade do array se a pilha estiver cheia.
     *
     * @param element o elemento a ser adicionado
     */
    @Override
    public void push(T element) {
        if (this.size() == stack.length) {
            expandCapacity();
        }

        this.stack[top++] = element;
    }

    /**
     * Duplica a capacidade do array subjacente para acomodar novos elementos.
     */
    private void expandCapacity() {
        T[] temp = (T[]) new Object[stack.length * 2];
        for (int i = 0; i < stack.length; i++) {
            temp[i] = stack[i];
        }

        stack = temp;
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

        this.top--;
        T element = this.stack[this.top];
        this.stack[this.top] = null;

        return element;
    }

    /**
     * Devolve o elemento no topo desta pilha sem o remover.
     *
     * @return o elemento atualmente no topo da pilha
     * @throws EmptyCollectionException se a pilha estiver vazia
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A pilha está vazia.");
        }

        return this.stack[this.top - 1];
    }

    /**
     * Verifica se a pilha está vazia.
     *
     * @return true se a pilha não contiver elementos, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return this.top == 0;
    }

    /**
     * Devolve o número atual de elementos na pilha.
     *
     * @return a contagem de elementos na pilha
     */
    @Override
    public int size() {
        return this.top;
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
        int p = this.top - 1;

        while (p >= 0) {
            s.append(this.stack[p--].toString()).append("\n");
        }

        return s.toString();
    }
}
