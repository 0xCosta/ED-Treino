package Ficha5.src.part2.ex5;

import exceptions.EmptyCollectionException;
import Ficha5.src.part1.ex1.ArrayOrderedList;
import Ficha5.src.part1.ex2.DoubleLinkedOrderedList;

/**
 * Simulação da qualificação para a Pole Position de Fórmula 1
 * recorrendo a uma Lista Ordenada (OrderedList).
 */
public class PolePositionSimulation {

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("      SIMULAÇÃO FÓRMULA 1 - QUALIFICAÇÃO PARA A POLE POSITION         ");
        System.out.println("======================================================================\n");

        // Usamos uma DoubleLinkedOrderedList (ou ArrayOrderedList) para ordenar automaticamente os pilotos
        DoubleLinkedOrderedList<Piloto> qualificacao = new DoubleLinkedOrderedList<>();

        System.out.println("A registar tempos dos pilotos na sessão de qualificação...\n");

        // Registo de tempos (em segundos)
        qualificacao.add(new Piloto("Max Verstappen", "Red Bull Racing", 71.361));
        qualificacao.add(new Piloto("Lewis Hamilton", "Mercedes-AMG", 71.584));
        qualificacao.add(new Piloto("Charles Leclerc", "Ferrari", 71.200));
        qualificacao.add(new Piloto("Lando Norris", "McLaren", 71.425));
        qualificacao.add(new Piloto("Fernando Alonso", "Aston Martin", 71.890));
        qualificacao.add(new Piloto("Carlos Sainz", "Ferrari", 71.512));
        qualificacao.add(new Piloto("Oscar Piastri", "McLaren", 71.650));
        qualificacao.add(new Piloto("George Russell", "Mercedes-AMG", 71.490));

        // Apresentação da Grelha de Partida
        System.out.println("----------------------------------------------------------------------");
        System.out.println(String.format("%-4s | %-20s | %-16s | %s", "POS", "PILOTO", "EQUIPA", "TEMPO"));
        System.out.println("----------------------------------------------------------------------");

        int posicao = 1;
        for (Piloto p : qualificacao) {
            String etiquetaPosicao = (posicao == 1) ? "1º (POLE)" : String.format("%2dº", posicao);
            System.out.println(String.format("%-9s | %s", etiquetaPosicao, p));
            posicao++;
        }

        System.out.println("----------------------------------------------------------------------");

        try {
            Piloto poleMan = qualificacao.first();
            System.out.println("\n>>> VENCEDOR DA POLE POSITION: " + poleMan.getNome() + " (" + poleMan.getEquipa() + ") <<<");
        } catch (EmptyCollectionException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

