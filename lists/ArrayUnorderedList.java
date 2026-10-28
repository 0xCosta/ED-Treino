package lists;

import ADTs.UnorderedListADT;

import java.util.NoSuchElementException;

/**
 * Implementação de uma Lista Não Ordenada baseada num array.
 * Estende ArrayList e implementa UnorderedListADT.
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList() {
        super();
    }

    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void addToFront(T element) {
        if (element == null) {
            throw new IllegalArgumentException("O elemento não pode ser nulo.");
        }

        if (this.count == this.list.length) {
            this.expandCapacity();
        }

        for (int i = this.count; i > 0; i--) {
            this.list[i] = this.list[i - 1];
        }

        this.list[0] = element;
        this.count++;
        this.modCount++;
    }

    @Override
    public void addToRear(T element) {
        if (element == null) {
            throw new IllegalArgumentException("O elemento não pode ser nulo.");
        }

        if (this.count == this.list.length) {
            this.expandCapacity();
        }

        this.list[this.count] = element;
        this.count++;
        this.modCount++;
    }

    @Override
    public void addAfter(T element, T target) {
        if (element == null || target == null) {
            throw new IllegalArgumentException("Nem o elemento nem o alvo podem ser nulos.");
        }

        if (this.count == this.list.length) {
            this.expandCapacity();
        }

        int scan = 0;
        while (scan < this.count && !target.equals(this.list[scan])) {
            scan++;
        }

        if (scan == this.count) {
            throw new NoSuchElementException("Elemento alvo não encontrado na lista.");
        }

        scan++;

        for (int i = this.count; i > scan; i--) {
            this.list[i] = this.list[i - 1];
        }

        this.list[scan] = element;
        this.count++;
        this.modCount++;
    }
}

