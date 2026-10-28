package Ficha5.src.part1.ex2;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

public class DoubleLinkedOrderedListDEMO {

    public static void main(String[] args) throws EmptyCollectionException, ElementNotFoundException {

        System.out.println("=== Demo: DoubleLinkedOrderedList<Integer> ===\n");

        DoubleLinkedOrderedList<Integer> list = new DoubleLinkedOrderedList<>();

        // --- Inserção ordenada ---
        System.out.println("-- add() --");
        int[] values = {5, 2, 8, 1, 9, 3, 7, 4, 6, 10};
        for (int v : values) {
            list.add(v);
            System.out.println("add(" + v + ") -> " + list);
        }

        // --- Iterador ---
        System.out.println("-- iterator() --");
        System.out.print("Elementos em ordem: ");
        for (int n : list) {
            System.out.print(n + " ");
        }
        System.out.println("\n");

        // --- first() e last() ---
        System.out.println("-- first() / last() --");
        System.out.println("Primeiro: " + list.first());
        System.out.println("Último:   " + list.last());
        System.out.println();

        // --- contains() ---
        System.out.println("-- contains() --");
        System.out.println("contains(5): " + list.contains(5));
        System.out.println("contains(99): " + list.contains(99));
        System.out.println();

        // --- size() / isEmpty() ---
        System.out.println("-- size() / isEmpty() --");
        System.out.println("size(): " + list.size());
        System.out.println("isEmpty(): " + list.isEmpty());
        System.out.println();

        // --- remove(element) ---
        System.out.println("-- remove(5) (elemento do meio) --");
        list.remove(5);
        System.out.println(list);

        // --- removeFirst() ---
        System.out.println("-- removeFirst() --");
        System.out.println("Removido: " + list.removeFirst());
        System.out.println(list);

        // --- removeLast() ---
        System.out.println("-- removeLast() --");
        System.out.println("Removido: " + list.removeLast());
        System.out.println(list);

        // --- Teste de exceção: ElementNotFoundException ---
        System.out.println("-- ElementNotFoundException --");
        try {
            list.remove(99);
        } catch (ElementNotFoundException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        // --- Teste de exceção: EmptyCollectionException ---
        System.out.println("\n-- EmptyCollectionException --");
        DoubleLinkedOrderedList<String> emptyList = new DoubleLinkedOrderedList<>();
        try {
            emptyList.removeFirst();
        } catch (EmptyCollectionException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        // --- Demo com Strings ---
        System.out.println("\n=== Demo: DoubleLinkedOrderedList<String> ===\n");
        DoubleLinkedOrderedList<String> names = new DoubleLinkedOrderedList<>();
        names.add("Maria");
        names.add("Ana");
        names.add("Zé");
        names.add("Carlos");
        names.add("Bruno");
        System.out.println(names);
    }
}
