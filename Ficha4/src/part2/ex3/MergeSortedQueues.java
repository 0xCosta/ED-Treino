package Ficha4.src.part2.ex3;

import exceptions.EmptyCollectionException;
import ADTs.QueueADT;
import Ficha4.src.part1.ex1.LinkedQueue;

public class MergeSortedQueues {

    /**
     * Junta duas filas já ordenadas numa nova fila também ordenada (Merge).
     *
     * @param q1 Primeira fila ordenada.
     * @param q2 Segunda fila ordenada.
     * @return Uma nova fila com todos os elementos de q1 e q2 ordenados.
     * @throws EmptyCollectionException se ocorrer erro ao aceder à fila vazia.
     */
    public static <T extends Comparable<T>> QueueADT<T> merge(QueueADT<T> q1, QueueADT<T> q2)
            throws EmptyCollectionException {
        QueueADT<T> resultado = new LinkedQueue<>();

        // Enquanto ambas tiverem elementos, compara as frentes (first)
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.first().compareTo(q2.first()) <= 0) {
                resultado.enqueue(q1.dequeue());
            } else {
                resultado.enqueue(q2.dequeue());
            }
        }

        // Despeja os elementos restantes da fila 1 (se existirem)
        while (!q1.isEmpty()) {
            resultado.enqueue(q1.dequeue());
        }

        // Despeja os elementos restantes da fila 2 (se existirem)
        while (!q2.isEmpty()) {
            resultado.enqueue(q2.dequeue());
        }

        return resultado;
    }

    public static void main(String[] args) throws EmptyCollectionException {
        QueueADT<Integer> q1 = new LinkedQueue<>();
        q1.enqueue(1);
        q1.enqueue(3);
        q1.enqueue(7);
        q1.enqueue(9);

        QueueADT<Integer> q2 = new LinkedQueue<>();
        q2.enqueue(2);
        q2.enqueue(4);
        q2.enqueue(5);
        q2.enqueue(8);
        q2.enqueue(10);

        System.out.println("--- Fila 1 inicial (ordenada) ---");
        System.out.print(q1);

        System.out.println("--- Fila 2 inicial (ordenada) ---");
        System.out.print(q2);

        QueueADT<Integer> merged = merge(q1, q2);

        System.out.println("--- Fila Resultante (ordenada) ---");
        System.out.print(merged);
    }
}
