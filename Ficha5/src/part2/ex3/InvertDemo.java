package Ficha5.src.part2.ex3;

import ADTs.UnorderedListADT;
import Ficha5.src.part1.ex2.DoubleLinkedOrderedList;

/**
 * Demonstração do Exercício 3 da Parte II:
 * Inverter os elementos de uma DoubleLinkedOrderedList e devolver num TAD (UnorderedListADT).
 */
public class InvertDemo {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   PARTE II - EXERCÍCIO 3: Invert Demo");
        System.out.println("=========================================\n");

        DoubleLinkedOrderedList<Integer> orderedList = new DoubleLinkedOrderedList<>();

        System.out.println("1. Adicionar elementos à lista ordenada (50, 10, 30, 20, 40)...");
        orderedList.add(50);
        orderedList.add(10);
        orderedList.add(30);
        orderedList.add(20);
        orderedList.add(40);

        System.out.println("Lista Ordenada (ordem crescente):");
        System.out.println(orderedList);

        System.out.println("2. Inverter a lista recorrendo ao método invert()...");
        UnorderedListADT<Integer> invertedList = orderedList.invert();

        System.out.println("Lista Invertida devolvida (TAD UnorderedListADT - ordem decrescente):");
        System.out.println(invertedList);
    }
}

