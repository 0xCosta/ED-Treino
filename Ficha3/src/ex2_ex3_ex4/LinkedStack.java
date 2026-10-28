package Ficha3.src.ex2_ex3_ex4;

import nodes.LinearNode;
import ADTs.StackADT;
import exceptions.EmptyCollectionException;

public class LinkedStack<T> implements StackADT<T> {
    private LinearNode<T> head;
    private int size;

    public LinkedStack() {
        this.size = 0;
        this.head = null;
    }

    public LinkedStack(T element) {
        this.head = new LinearNode<>(element);
        this.size = 1;
    }

    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A stack esta vazia!");
        }

        LinearNode<T> removed = this.head;
        this.head = this.head.getNext(); // avança o head antes de apagar o next
        removed.setNext(null);
        this.size--;

        return removed.getElement();
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("A stack esta vazia!");
        }

        return this.head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String s = "";
        LinearNode<T> p = this.head;

        while (p != null) {
            s += p.getElement().toString() + "\n";

            p = p.getNext();
        }

        return s;
    }
}
