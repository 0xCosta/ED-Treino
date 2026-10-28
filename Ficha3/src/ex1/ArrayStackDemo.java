package Ficha3.src.ex1;

import exceptions.EmptyCollectionException;
import stack.ArrayStack;

public class ArrayStackDemo {

    public static void main(String[] args) throws EmptyCollectionException {
        ArrayStack<String> stack = new ArrayStack<>();

        // push
        System.out.println("push");
        stack.push("Ana");
        stack.push("Bruno");
        stack.push("Carlos");
        System.out.println("Adicionados: Ana, Bruno, Carlos");

        // size
        System.out.println("\nsize");
        System.out.println("Tamanho: " + stack.size()); // esperado: 3

        // isEmpty
        System.out.println("\nisEmpty");
        System.out.println("Esta vazia? " + stack.isEmpty()); // esperado: false

        // peek
        System.out.println("\npeek");
        System.out.println("Topo (sem remover): " + stack.peek()); // esperado: Carlos

        // toString
        System.out.println("\ntoString");
        System.out.println(stack);

        // pop
        System.out.println("pop");
        System.out.println("Removido: " + stack.pop()); // esperado: Carlos
        System.out.println("Removido: " + stack.pop()); // esperado: Bruno
        System.out.println("Tamanho apos pops: " + stack.size()); // esperado: 1

        // isEmpty apos remover tudo
        stack.pop(); // remove Ana
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
