package Ficha5.src;

import Ficha5.src.Exceptions.ElementNotFoundException;
import Ficha5.src.Exceptions.EmptyCollectionException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

        this.list[--this.count] = null;

        this.modCount++;
        return element;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("A Lista esta Vazia!");
        }
        T element = this.list[this.count - 1];
        this.list[--this.count] = null;
        this.modCount++;
        return element;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if(isEmpty()){
            throw new EmptyCollectionException("A Lista esta Vazia!");
        }
        int index = this.find(element);

        if(index == -1){
            throw new ElementNotFoundException("O Elemento nao foi encontrado!");
        }

        T removed = this.list[index];

        for(int i = index; i < this.count -1; i++){
            this.list[i] = this.list[i+1];
        }

        this.list[--this.count] = null;

        this.modCount++;
        return removed;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("A Lista esta Vazia!");
        }
        return this.list[0];
    }

    @Override
    public T last() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("A Lista esta Vazia!");
        }
        return this.list[this.count-1];
    }

    @Override
    public boolean contains(T target) {
        for(int i = 0; i < this.count; i++){
            if(this.list[i].equals(target)){
                return true;
            }
        }
        return false;
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
                s += "->" + element.toString() + '\n';
            }
        }

        return s;
    }

    // fazer uma innerclass
    public class BasicIterator implements Iterator<T> {
        private int current;
        private int expectedModCount;

        public BasicIterator(){
            this.current = 0;
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            checkForConcurrentModification();
            return this.current < count;
        }

        @Override
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException("No More Elements In The List");
            }

            return list[this.current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private void checkForConcurrentModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("ModCount diff!");
            }
        }
    }
}
