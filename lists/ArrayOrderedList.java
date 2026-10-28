package lists;

import ADTs.OrderedListADT;
import exceptions.NonComparableElementException;

/**
 * Implementação de uma Lista Ordenada baseada num array.
 * Estende ArrayList e implementa OrderedListADT.
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    public ArrayOrderedList() {
        super();
    }

    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("O elemento não pode ser nulo.");
        }
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("ArrayOrderedList");
        }

        if (this.count == this.list.length) {
            this.expandCapacity();
        }

        Comparable<T> comparableElement = (Comparable<T>) element;

        int position = 0;

        while (position < this.count && comparableElement.compareTo(this.list[position]) > 0) {
            position++;
        }

        for (int i = this.count; i > position; i--) {
            this.list[i] = this.list[i - 1];
        }

        this.list[position] = element;
        this.count++;
        this.modCount++;
    }
}

