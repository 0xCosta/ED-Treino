package Ficha4.src.part1.ex1;

import nodes.LinearNode;
import ADTs.QueueADT;
import exceptions.EmptyCollectionException;

public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> head;
    private LinearNode<T> tail;
    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedQueue(T element) {
        this.head = new LinearNode<>(element);
        this.tail = this.head; // head e tail apontam para o mesmo nó
        this.size = 1;
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }

        this.tail = newNode; // atualiza o tail para o novo nó
        this.size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Queue esta vazia!");
        }

        T removed = this.head.getElement();
        this.head = this.head.getNext();
        this.size--;

        if (isEmpty()) {
            this.tail = null;
        }

        return removed;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Queue esta vazia!");
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

        while (p != null) { // podia ser tail.getNext()
            s += p.getElement().toString() + "\n";
            p = p.getNext();
        }

        return s;
    }
}
