package Ficha4.src.part1.ex5;

import exceptions.EmptyCollectionException;
import queue.LinkedQueue;

public class CifraDeCesarLinkedQueue {

    public static void main(String[] args) throws EmptyCollectionException {
        int[] chave = { 3, 1, 7, 4, 2, 5 };
        String mensagem = "knowledge is power";

        // Carregar a chave para a LinkedQueue
        LinkedQueue<Integer> fila = new LinkedQueue<>();
        for (int k : chave) {
            fila.enqueue(k);
        }

        // Codificar
        String codificada = "";
        for (int i = 0; i < mensagem.length(); i++) {
            char c = mensagem.charAt(i);

            if (c == ' ') {
                codificada += c; // Mantém o espaço sem mexer na fila
            } else {
                int shift = fila.dequeue();
                fila.enqueue(shift); // Volta a pôr no fim da fila para repetir ciclicamente

                codificada += (char) ('a' + (c - 'a' + shift) % 26);
            }
        }

        // Descodificar (com uma LinkedQueue no estado inicial)
        LinkedQueue<Integer> filaDecod = new LinkedQueue<>();
        for (int k : chave) {
            filaDecod.enqueue(k);
        }

        String descodificada = "";
        for (int i = 0; i < codificada.length(); i++) {
            char c = codificada.charAt(i);

            if (c == ' ') {
                descodificada += c;
            } else {
                int shift = filaDecod.dequeue();
                filaDecod.enqueue(shift);

                descodificada += (char) ('a' + (c - 'a' - shift + 26) % 26);
            }
        }

        System.out.println("Original:      " + mensagem);
        System.out.println("Codificada:    " + codificada);
        System.out.println("Descodificada: " + descodificada);
    }
}

/**
 * Como tanto a CircularArrayQueue como a LinkedQueue implementam a interface
 * QueueADT, a lógica do algoritmo é exatamente a mesma. A única alteração é a
 * classe
 * instanciada para gerir a fila da chave:
 * No Ex 4: Usou-se new CircularArrayQueue<Integer>() (baseada em array
 * circular).
 * No Ex 5: Usa-se new LinkedQueue<Integer>() (baseada em nós ligados
 * LinearNode).
 */