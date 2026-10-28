package Ficha3.src.ex1;

import ADTs.StackADT;
import exceptions.EmptyCollectionException;

public class ArrayStack<T> implements StackADT<T> {
    private T[] stack;
    private int top;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        this.top = 0;
        this.stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int initialCapacity) {
        this.top = 0;
        this.stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T element) {
        if (this.size() == stack.length) {
            expandCapacity();
        }

        this.stack[top++] = element;
    }

    private void expandCapacity() {
        T[] temp = (T[]) new Object[stack.length * 2];
        for (int i = 0; i < stack.length; i++) {
            temp[i] = stack[i];
        }

        stack = temp;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A stack esta vazia!");
        }

        this.top--;
        T element = this.stack[this.top];
        this.stack[this.top] = null;

        return element;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A stack esta vazia!");
        }

        return this.stack[this.top - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.top == 0;
    }

    @Override
    public int size() {
        return this.top;
    }

    @Override
    public String toString() {
        String s = "";
        int p = this.top - 1;

        while (p >= 0) {
            s += this.stack[p--].toString() + "\n";
        }

        return s;
    }

}
