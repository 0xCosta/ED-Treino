package Ficha5.src;

import Ficha5.src.Exceptions.ElementNotFoundException;
import Ficha5.src.Exceptions.EmptyCollectionException;
import java.util.Iterator;

public abstract class ArrayList<T> implements ListADT<T> {
    protected final int DEFAULT_CAPACITY = 10;
    protected T[] list;
    protected int count;
    protected int modCount;

    public ArrayList() {
        this.count = modCount = 0;
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        this.count = modCount = 0;
        this.list = (T[]) new Object[initialCapacity];
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Lista esta Vazia!");
        }
        T element = this.list[0];

        for (int i = 0; i < this.count - 1; i++) {
            this.list[i] = this.list[i + 1];
        }

        this.list[this.list--] = null;
        this.modCount++;
        return element;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {

    }

    @Override
    public T remove(T element) throws EmptyCollectionException {

    }

    @Override
    public T first() throws EmptyCollectionException {

    }

    @Override
    public T last() throws EmptyCollectionException {

    }

    @Override
    public boolean contains(T target) {

    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    private int find(T element) {
        int position = -1;

        for (int i = 0; i < this.count; i++) {
            if (this.list[i].equals(element)) {
                position = i;
                break;
            }
        }

        return position;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator();
    }

    protected void expandCapacity() {
        T[] temp = (T[]) (new Object[this.list.length * 2]);
        System.arraycopy(this.list, 0, temp, 0, this.count);
        this.list = temp;
    }

    @Override
    public String toString() {
        String s = "******\n List \n******\n";

        for (T element : this.list) {
            if (element != null) {
                s += "➯ " + element.toString() + '\n';
            }
        }

        return s;
    }

    // fazer uma innerclass
    public class BasicIterator implements Iterator<T> {

    }
}
