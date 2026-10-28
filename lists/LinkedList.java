package lists;

import nodes.LinearNode;

/**
 * Implementação simples de uma lista ligada simples (Singly Linked List).
 *
 * @param <T> o tipo dos elementos armazenados na lista
 */
public class LinkedList<T> {
    private LinearNode<T> head;

    public LinkedList() {
        this.head = null;
    }

    public LinearNode<T> getHead() {
        return this.head;
    }

    public void setHead(LinearNode<T> head) {
        this.head = head;
    }

    /**
     * Verifica se a lista está vazia.
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Adiciona um elemento no final da lista.
     */
    public void add(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (isEmpty()) {
            this.head = newNode;
        } else {
            LinearNode<T> current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    /**
     * Procura e remove a primeira ocorrência do elemento.
     * Retorna true se encontrou e removeu, false se não existia na lista.
     */
    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }

        if (head.getElement().equals(element)) {
            head = head.getNext();
            return true;
        }

        LinearNode<T> current = this.head;
        while (current.getNext() != null && !current.getNext().getElement().equals(element)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            return true;
        }

        return false;
    }

    /**
     * Imprime todos os elementos da lista.
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }

        LinearNode<T> current = this.head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

