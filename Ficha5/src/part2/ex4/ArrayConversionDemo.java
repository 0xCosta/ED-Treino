package Ficha5.src.part2.ex4;

import lists.DoubleLinkedUnorderedList;

import java.util.Arrays;

/**
 * Demonstração do Exercício 4 da Parte II:
 * Cenário onde se tem uma DoubleLinkedUnorderedList e se precisa
 * de converter os seus elementos para um array simples para operar.
 */
public class ArrayConversionDemo {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   PARTE II - EXERCÍCIO 4: Array Demo");
        System.out.println("=========================================\n");

        // 1. Criar e preencher a DoubleLinkedUnorderedList com dados
        DoubleLinkedUnorderedList<Integer> list = new DoubleLinkedUnorderedList<>();
        list.addToRear(42);
        list.addToRear(17);
        list.addToRear(89);
        list.addToRear(5);
        list.addToRear(23);

        System.out.println("Elementos na DoubleLinkedUnorderedList:");
        System.out.println(list);

        // 2. Extrair os elementos da lista ligada para um array simples
        int n = list.size();
        Integer[] array = new Integer[n];

        int index = 0;
        for (Integer val : list) {
            array[index++] = val;
        }

        System.out.println("Array simples resultante: " + Arrays.toString(array));

        // 3. Operar sobre o array (por exemplo, calcular a média, encontrar o máximo e ordenar)
        int soma = 0;
        int maximo = array[0];
        for (int val : array) {
            soma += val;
            if (val > maximo) {
                maximo = val;
            }
        }
        double media = (double) soma / array.length;

        System.out.println("\nOperações efetuadas sobre o array:");
        System.out.printf("- Média dos valores: %.2f\n", media);
        System.out.println("- Valor máximo: " + maximo);

        // Ordenar o array usando algoritmo nativo de arrays
        Arrays.sort(array);
        System.out.println("- Array ordenado com Arrays.sort: " + Arrays.toString(array));
    }
}

