package lists;

import ADTs.UnorderedListADT;
import nodes.DoubleLinearNode;

import java.util.NoSuchElementException;

/**
 * Implementação de uma Lista Não Ordenada duplamente ligada.
 * Estende DoubleLinkedList e implementa UnorderedListADT.
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    public DoubleLinkedUnorderedList() {
        super();
    }

    @Override
    public void addToFront(T element) {
        if (element == null) {
            throw new IllegalArgumentException("O elemento não pode ser nulo.");
        }

        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.setNext(front);
            front.setPrevious(newNode);
            front = newNode;
        }

        count++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        if (element == null) {
            throw new IllegalArgumentException("O elemento não pode ser nulo.");
        }

        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear = newNode;
        }

        count++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) {
        if (element == null || target == null) {
            throw new IllegalArgumentException("Nem o elemento nem o alvo podem ser nulos.");
        }

        DoubleLinearNode<T> current = front;

        while (current != null && !current.getElement().equals(target)) {
            current = current.getNext();
        }

        if (current == null) {
            throw new NoSuchElementException("Elemento alvo não encontrado na lista.");
        }

        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);

        if (current == rear) {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear = newNode;
        } else {
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            current.getNext().setPrevious(newNode);
            current.setNext(newNode);
        }

        count++;
        modCount++;
    }
}

