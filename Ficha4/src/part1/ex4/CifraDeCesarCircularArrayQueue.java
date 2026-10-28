package Ficha4.src.part1.ex4;

import exceptions.EmptyCollectionException;
import queue.CircularArrayQueue;

public class CifraDeCesarCircularArrayQueue {

    public static void main(String[] args) throws EmptyCollectionException {
        int[] chave = { 3, 1, 7, 4, 2, 5 };
        String mensagem = "knowledge is power";

        // Carregar a chave para a fila
        CircularArrayQueue<Integer> fila = new CircularArrayQueue<>();
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
                fila.enqueue(shift); // Volta a pôr no fim para repetir

                codificada += (char) ('a' + (c - 'a' + shift) % 26);
            }
        }

        // Descodificar
        CircularArrayQueue<Integer> filaDecod = new CircularArrayQueue<>();
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
