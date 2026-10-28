package Ficha4.src.part1.ex1;

import exceptions.EmptyCollectionException;
import queue.LinkedQueue;

public class LinkedQueueDemo {
    public static void main(String[] args) throws EmptyCollectionException {
        LinkedQueue<String> queue = new LinkedQueue<>();

        // enqueue
        System.out.println("enqueue");
        queue.enqueue("Flow");
        queue.enqueue("Swisser");
        queue.enqueue("Darken");
        System.out.println("Adicionados à fila: Flow, Swisser e Darken");

        // size
        System.out.println("\nsize");
        System.out.println("Tamanho: " + queue.size()); // esperado: 3

        // isEmpty
        System.out.println("\nisEmpty");
        System.out.println("Esta vazia? " + queue.isEmpty()); // esperado: false

        // first
        System.out.println("\nfirst");
        System.out.println("Primeiro da fila (sem remover): " + queue.first()); // esperado: Flow (FIFO!)

        // toString
        System.out.println("\ntoString");
        System.out.println(queue);

        // dequeue
        System.out.println("dequeue");
        System.out.println("Removido: " + queue.dequeue()); // esperado: Flow
        System.out.println("Removido: " + queue.dequeue()); // esperado: Swisser
        System.out.println("Tamanho apos dequeues: " + queue.size()); // esperado: 1

        // isEmpty apos remover tudo
        queue.dequeue(); // remove Darken
        System.out.println("\nisEmpty apos remover tudo");
        System.out.println("Esta vazia? " + queue.isEmpty()); // esperado: true

        // dequeue em fila vazia (lanca excecao)
        System.out.println("\ndequeue em fila vazia");
        try {
            queue.dequeue();
        } catch (EmptyCollectionException e) {
            System.out.println("Excecao apanhada: " + e.getMessage());
        }
    }
}
