package Ficha5.src.part1.ex5;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

/**
 * Demonstração da utilização da DoubleLinkedUnorderedList.
 */
public class DoubleLinkedUnorderedListDemo {

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   DEMONSTRAÇÃO: DoubleLinkedUnorderedList");
        System.out.println("==============================================\n");

        DoubleLinkedUnorderedList<Integer> list = new DoubleLinkedUnorderedList<>();

        System.out.println("1. Inserir 20 e depois 10 à frente (addToFront)...");
        list.addToFront(20);
        list.addToFront(10);
        System.out.println(list);

        System.out.println("2. Inserir 40 e 50 atrás (addToRear)...");
        list.addToRear(40);
        list.addToRear(50);
        System.out.println(list);

        System.out.println("3. Inserir 30 após o 20 (addAfter)...");
        list.addAfter(30, 20);
        System.out.println(list);

        System.out.println("4. Testar consultas:");
        try {
            System.out.println("Primeiro elemento: " + list.first());
            System.out.println("Último elemento: " + list.last());
            System.out.println("Tamanho atual: " + list.size());
            System.out.println("Contém 30? " + list.contains(30));
            System.out.println("Contém 99? " + list.contains(99));
        } catch (EmptyCollectionException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        System.out.println("\n5. Testar remoções:");
        try {
            System.out.println("removeFirst() -> " + list.removeFirst());
            System.out.println("removeLast()  -> " + list.removeLast());
            System.out.println("remove(30)    -> " + list.remove(30));
            System.out.println("\nLista após remoções:");
            System.out.println(list);
        } catch (EmptyCollectionException | ElementNotFoundException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        System.out.println("6. Iteração com foreach:");
        for (Integer num : list) {
            System.out.println("-> Número: " + num);
        }
    }
}
