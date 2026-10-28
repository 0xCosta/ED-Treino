package lists;

import ADTs.OrderedListADT;
import ADTs.UnorderedListADT;
import exceptions.NonComparableElementException;
import nodes.DoubleLinearNode;

/**
 * Implementação de uma Lista Ordenada duplamente ligada.
 * Estende DoubleLinkedList e implementa OrderedListADT.
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    public DoubleLinkedOrderedList() {
        super();
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("O elemento não pode ser nulo.");
        }
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("DoubleLinkedOrderedList");
        }

        DoubleLinearNode<T> current = front;
        Comparable<T> comparableElement = (Comparable<T>) element;

        while (current != null && comparableElement.compareTo(current.getElement()) > 0) {
            current = current.getNext();
        }

        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);

        if (current == null) {
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.setNext(newNode);
                newNode.setPrevious(rear);
                rear = newNode;
            }
        } else if (current == front) {
            newNode.setNext(front);
            front.setPrevious(newNode);
            front = newNode;
        } else {
            newNode.setPrevious(current.getPrevious());
            newNode.setNext(current);
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
        }

        count++;
        modCount++;
    }

    /**
     * Inverte e devolve todos os elementos num Tipo Abstrato de Dados (UnorderedListADT).
     *
     * @return uma lista não ordenada contendo os elementos por ordem invertida
     */
    public UnorderedListADT<T> invert() {
        DoubleLinkedUnorderedList<T> inverted = new DoubleLinkedUnorderedList<>();
        DoubleLinearNode<T> current = rear;

        while (current != null) {
            inverted.addToRear(current.getElement());
            current = current.getPrevious();
        }

        return inverted;
    }
}

