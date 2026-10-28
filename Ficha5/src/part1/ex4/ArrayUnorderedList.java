package Ficha5.src.part1.ex4;

import lists.ArrayList;
import ADTs.UnorderedListADT;

import java.util.NoSuchElementException;

/**
 * Implementação de uma Lista Não Ordenada baseada num array.
 * Estende ArrayList e implementa UnorderedListADT.
 *
 * @param <T> o tipo dos elementos guardados na lista
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    /**
     * Cria uma lista vazia usando a capacidade por omissão.
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     * Cria uma lista vazia com a capacidade inicial especificada.
     *
     * @param initialCapacity a capacidade inicial da lista
     */
    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Adiciona o elemento especificado no início desta lista.
     *
     * @param element o elemento a ser adicionado
     */
    @Override
    public void addToFront(T element) {
        if (element == null) {
            throw new IllegalArgumentException("O elemento não pode ser nulo.");
        }

        if (this.count == this.list.length) {
            this.expandCapacity();
        }

        // Desloca todos os elementos uma posição para a direita
        for (int i = this.count; i > 0; i--) {
            this.list[i] = this.list[i - 1];
        }

        this.list[0] = element;
        this.count++;
        this.modCount++;
    }

    /**
     * Adiciona o elemento especificado no fim desta lista.
     *
     * @param element o elemento a ser adicionado
     */
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

    /**
     * Adiciona o elemento especificado após o elemento alvo especificado.
     *
     * @param element o elemento a ser adicionado
     * @param target  o elemento de referência existente na lista
     */
    @Override
    public void addAfter(T element, T target) {
        if (element == null || target == null) {
            throw new IllegalArgumentException("Nem o elemento nem o alvo podem ser nulos.");
        }

        if (this.count == this.list.length) {
            this.expandCapacity();
        }

        // Procura a posição do elemento alvo
        int scan = 0;
        while (scan < this.count && !target.equals(this.list[scan])) {
            scan++;
        }

        if (scan == this.count) {
            throw new NoSuchElementException("Elemento alvo não encontrado na lista.");
        }

        scan++; // Posição onde o novo elemento deve ficar (logo a seguir ao target)

        // Desloca os elementos para a frente
        for (int i = this.count; i > scan; i--) {
            this.list[i] = this.list[i - 1];
        }

        this.list[scan] = element;
        this.count++;
        this.modCount++;
    }
}
