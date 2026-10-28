package Ficha5.src.part1.ex4;

import Ficha5.src.Exceptions.ElementNotFoundException;
import Ficha5.src.Exceptions.EmptyCollectionException;

/**
 * Classe de demonstração para a ArrayUnorderedList.
 */
public class ArrayUnorderedListDEMO {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   DEMONSTRAÇÃO: ArrayUnorderedList");
        System.out.println("=========================================\n");

        ArrayUnorderedList<String> lista = new ArrayUnorderedList<>();

        System.out.println("1. Adicionar 'B' e depois 'A' à frente (addToFront)...");
        lista.addToFront("B");
        lista.addToFront("A");
        System.out.println(lista);

        System.out.println("2. Adicionar 'D' e 'E' ao fim (addToRear)...");
        lista.addToRear("D");
        lista.addToRear("E");
        System.out.println(lista);

        System.out.println("3. Adicionar 'C' após 'B' (addAfter)...");
        lista.addAfter("C", "B");
        System.out.println(lista);

        System.out.println("4. Testar consultas:");
        try {
            System.out.println("Primeiro elemento: " + lista.first());
            System.out.println("Último elemento: " + lista.last());
            System.out.println("Tamanho atual: " + lista.size());
            System.out.println("Contém 'C'? " + lista.contains("C"));
            System.out.println("Contém 'Z'? " + lista.contains("Z"));
        } catch (EmptyCollectionException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        System.out.println("\n5. Testar remoções:");
        try {
            System.out.println("removeFirst() -> " + lista.removeFirst());
            System.out.println("removeLast()  -> " + lista.removeLast());
            System.out.println("remove('C')   -> " + lista.remove("C"));
            System.out.println("\nLista após remoções:");
            System.out.println(lista);
        } catch (EmptyCollectionException | ElementNotFoundException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        System.out.println("6. Iteração com foreach:");
        for (String s : lista) {
            System.out.println("-> Item: " + s);
        }
    }
}
