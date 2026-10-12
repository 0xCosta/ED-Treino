package Ficha4.src.part1.ex2;

import Ficha4.src.QueueADT;
import Ficha4.src.Exceptions.EmptyCollectionException;

public class CircularArrayQueue<T> implements QueueADT<T> {
    private T[] queue;
    private int head;
    private int tail;
    private int count;
    private final int DEFAULT_CAPACITY = 10;

    public CircularArrayQueue() {
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public CircularArrayQueue(int initialCapacity) {
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.queue = (T[]) new Object[initialCapacity];
    }

    @Override
    public void enqueue(T element) {
        if (this.size() == queue.length) {
            expandCapacity();
        }
        this.queue[this.tail] = element;
        this.tail = (this.tail + 1) % queue.length; // O(1)
        this.count++;
    }

    private void expandCapacity() {
        T[] temp = (T[]) new Object[queue.length * 2];

        // Copia os elementos por ordem desde o head
        for (int i = 0; i < count; i++) {
            temp[i] = queue[head];
            head = (head + 1) % queue.length;
        }

        this.head = 0;
        this.tail = this.count;
        this.queue = temp;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Queue esta vazia!");
        }

        T removed = this.queue[this.head];
        this.queue[this.head] = null; // limpa a referência
        this.head = (this.head + 1) % queue.length; // avança o head circularmente
        this.count--;

        return removed;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Queue esta vazia!");
        }

        return this.queue[this.head];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String s = "";
        int current = this.head;

        for (int i = 0; i < this.count; i++) {
            s += this.queue[current].toString() + "\n";
            current = (current + 1) % this.queue.length;
        }

        return s;
    }
}
