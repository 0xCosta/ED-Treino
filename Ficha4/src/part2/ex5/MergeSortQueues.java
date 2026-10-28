package Ficha4.src.part2.ex5;

import exceptions.EmptyCollectionException;
import ADTs.QueueADT;
import Ficha4.src.part1.ex1.LinkedQueue;

public class MergeSortQueues {

    /**
     * Junta duas filas já ordenadas numa única fila ordenada.
     */
    public static <T extends Comparable<T>> QueueADT<T> merge(QueueADT<T> q1, QueueADT<T> q2)
            throws EmptyCollectionException {
        QueueADT<T> resultado = new LinkedQueue<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.first().compareTo(q2.first()) <= 0) {
                resultado.enqueue(q1.dequeue());
            } else {
                resultado.enqueue(q2.dequeue());
            }
        }

        while (!q1.isEmpty()) {
            resultado.enqueue(q1.dequeue());
        }

        while (!q2.isEmpty()) {
            resultado.enqueue(q2.dequeue());
        }

        return resultado;
    }

    /**
     * Ordena um array de strings usando uma Queue de Queues (Merge Sort Bottom-Up).
     */
    public static QueueADT<String> ordenarStrings(String[] strings) throws EmptyCollectionException {
        if (strings == null || strings.length == 0) {
            return new LinkedQueue<>();
        }

        // 1. Criar uma Queue que guarda outras Queues
        QueueADT<QueueADT<String>> queueOfQueues = new LinkedQueue<>();

        // 2. Para cada string, criar uma fila com esse elemento e adicionar à fila principal
        for (String str : strings) {
            QueueADT<String> subQueue = new LinkedQueue<>();
            subQueue.enqueue(str);
            queueOfQueues.enqueue(subQueue);
        }

        int passo = 1;
        // 3. Enquanto existirem 2 ou mais filas, juntar as duas primeiras e reinserir no fim
        while (queueOfQueues.size() > 1) {
            QueueADT<String> q1 = queueOfQueues.dequeue();
            QueueADT<String> q2 = queueOfQueues.dequeue();

            QueueADT<String> qMerged = merge(q1, q2);
            queueOfQueues.enqueue(qMerged);

            System.out.println("Passo " + (passo++) + " (restam " + queueOfQueues.size() + " filas)");
        }

        // 4. A fila restante é a fila final completamente ordenada
        return queueOfQueues.dequeue();
    }

    public static void main(String[] args) throws EmptyCollectionException {
        String[] palavras = { "uva", "banana", "maca", "pera", "laranja", "ananás", "kiwi" };

        System.out.println("=== Exercício 5: Merge Sort com Queue de Queues ===");
        System.out.print("Palavras originais: ");
        for (String p : palavras) {
            System.out.print(p + " ");
        }
        System.out.println("\n");

        QueueADT<String> ordenada = ordenarStrings(palavras);

        System.out.println("\nFila Final Ordenada:");
        while (!ordenada.isEmpty()) {
            System.out.println("-> " + ordenada.dequeue());
        }
    }
}
