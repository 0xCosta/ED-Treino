package lists;

import ADTs.ListADT;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import nodes.DoubleLinearNode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Classe abstrata base para listas duplamente ligadas.
 * Implementa a interface ListADT.
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public abstract class DoubleLinkedList<T> implements ListADT<T> {
    protected DoubleLinearNode<T> front;
    protected DoubleLinearNode<T> rear;
    protected int count;
    protected int modCount;

    public DoubleLinkedList() {
        this.front = this.rear = null;
        this.count = this.modCount = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        checkIfEmpty();

        T element = this.front.getElement();
        removeNode(this.front);
        return element;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        checkIfEmpty();

        T element = this.rear.getElement();
        removeNode(this.rear);
        return element;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        checkIfEmpty();

        DoubleLinearNode<T> current = this.front;

        while (current != null) {
            if (current.getElement().equals(element)) {
                removeNode(current);
                return current.getElement();
            }
            current = current.getNext();
        }

        throw new ElementNotFoundException("Element not found in the list");
    }

    @Override
    public T first() throws EmptyCollectionException {
        checkIfEmpty();
        return this.front.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        checkIfEmpty();
        return this.rear.getElement();
    }

    @Override
    public boolean contains(T target) {
        DoubleLinearNode<T> current = this.front;

        while (current != null) {
            if (current.getElement().equals(target)) {
                return true;
            }
            current = current.getNext();
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

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private void removeNode(DoubleLinearNode<T> node) {
        if (node == this.front) {
            this.front = node.getNext();
            if (this.front != null) {
                this.front.setPrevious(null);
            } else {
                this.rear = null;
            }
        } else if (node == this.rear) {
            this.rear = node.getPrevious();
            if (this.rear != null) {
                this.rear.setNext(null);
            } else {
                this.front = null;
            }
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }

        this.count--;
        this.modCount++;
    }

    private void checkIfEmpty() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The List Is Empty");
        }
    }

    public class LinkedListIterator implements Iterator<T> {
        private DoubleLinearNode<T> current;
        private final int expectedModCount;

        public LinkedListIterator() {
            this.current = front;
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            checkForConcurrentModification();
            return current != null;
        }

        @Override
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException("No More Elements In The List");
            }

            T element = this.current.getElement();
            this.current = current.getNext();

            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not Supported");
        }

        private void checkForConcurrentModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("Concurrent Modification Detected");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("******\n List \n******\n");
        DoubleLinearNode<T> current = this.front;
        while (current != null) {
            s.append(" -> ").append(current.getElement().toString()).append("\n");
            current = current.getNext();
        }
        return s.toString();
    }
}

