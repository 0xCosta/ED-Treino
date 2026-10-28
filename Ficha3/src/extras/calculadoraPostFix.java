package Ficha3.src.extras;

import exceptions.EmptyCollectionException;
import Ficha3.src.ex1.ArrayStack;
import Ficha3.src.ex2_ex3_ex4.LinkedStack;

public class calculadoraPostFix {

    public static double calcular(String expressao) throws EmptyCollectionException { // COMENTAR O QUE NAO QUERES USAR
        // ArrayStack<Double> stack = new ArrayStack<>();
        LinkedStack<Double> stack = new LinkedStack<>();

        // 1. Separar a expressão em tokens por espaços como no pyton ["3", "4", "+",
        // "2", "*"]
        String[] tokens = expressao.split(" ");

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                double b = stack.pop();
                double a = stack.pop();

                double resultado = 0;

                if (token.equals("+"))
                    resultado = a + b;
                else if (token.equals("-"))
                    resultado = a - b;
                else if (token.equals("/"))
                    resultado = a / b;
                else if (token.equals("*"))
                    resultado = a * b;

                stack.push(resultado);
            } else {
                double num = Double.parseDouble(token); // pega na String "3" e converte-a no número real 3.0 (do tipo
                                                        // double).
                stack.push(num);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws EmptyCollectionException {
        String c = "3 4 + 2 *";
        System.out.println("Resultado de '" + c + "': " + calcular(c));
    }
}

/**
 * Por que é que todo o resto do código fica 100% igual?
 * Porque tanto a ArrayStack como a LinkedStack implementam
 * a mesma interface (StackADT), por isso ambas têm exatamente
 * os mesmos métodos: push(), pop(), peek(), isEmpty() e size().
 * O ciclo for, os push(), os pop() e o split funcionam exatamente
 * da mesma maneira!
 */
