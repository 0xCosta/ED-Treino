package Ficha2.src.ex1;

import nodes.LinearNode;

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
     * Verifica se a lista está vazia (head aponta para null).
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
     * eleminar sempre na posiçao anterior para apagar a proxima
     */
    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }

        // O elemento a remover é o primeiro nó
        if (head.getElement().equals(element)) { // tem de ser equals porque tratamos de strings, == so para endereços
                                                 // de memoria.
            head = head.getNext();
            return true;
        }

        // O elemento está no meio ou no fim
        LinearNode<T> current = this.head;
        while (current.getNext() != null && !current.getNext().getElement().equals(element)) {
            current = current.getNext();
        }

        // Se encontrou o nó com o elemento a seguir a current
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            return true;
        }

        return false; // Não encontrado
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
            System.out.print(current.getElement()+ " ");
            current = current.getNext();
        }
    }
}
