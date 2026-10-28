package Ficha3.src.ex2_ex3_ex4;

import exceptions.EmptyCollectionException;
import stack.LinkedStack;

public class LinkedStackDemo {
    public static void main(String[] args) throws EmptyCollectionException {
        LinkedStack<String> stack = new LinkedStack<>();

        // push
        System.out.println("push");
        stack.push("Flow");
        stack.push("Swisser");
        stack.push("Darken");
        System.out.println("Adicionados: Flow, Swisser e Darken");

        // size
        System.out.println("\nsize");
        System.out.println("Tamanho: " + stack.size()); // esperado: 3

        // isEmpty
        System.out.println("\nisEmpty");
        System.out.println("Esta vazia? " + stack.isEmpty()); // esperado: false

        // peek
        System.out.println("\npeek");
        System.out.println("Topo (sem remover): " + stack.peek()); // esperado: Darken

        // toString
        System.out.println("\ntoString");
        System.out.println(stack);

        // pop
        System.out.println("pop");
        System.out.println("Removido: " + stack.pop()); // esperado: Darken
        System.out.println("Removido: " + stack.pop()); // esperado: Swisser
        System.out.println("Tamanho apos pops: " + stack.size()); // esperado: 1

        // isEmpty apos remover tudo
        stack.pop(); // remove Flow
        System.out.println("\nisEmpty apos remover tudo");
        System.out.println("Esta vazia? " + stack.isEmpty()); // esperado: true

        // pop em pilha vazia (lanca excecao)
        System.out.println("\npop em pilha vazia");
        try {
            stack.pop();
        } catch (EmptyCollectionException e) {
            System.out.println("Excecao apanhada: " + e.getMessage());
        }
    }
}
