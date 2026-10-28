package Ficha5.src.part2.ex5;

/**
 * Representa um piloto de Fórmula 1 na simulação.
 * Implementa Comparable para permitir ordenação por tempo de volta na qualificação (Pole Position).
 */
public class Piloto implements Comparable<Piloto> {
    private String nome;
    private String equipa;
    private double tempoVolta; // Tempo em segundos (ex.: 72.450 s)
    private int pontos;

    public Piloto(String nome, String equipa, double tempoVolta) {
        this.nome = nome;
        this.equipa = equipa;
        this.tempoVolta = tempoVolta;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getEquipa() {
        return equipa;
    }

    public double getTempoVolta() {
        return tempoVolta;
    }

    public void setTempoVolta(double tempoVolta) {
        this.tempoVolta = tempoVolta;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    /**
     * Ordenação natural por tempo de volta (crescente).
     * O menor tempo fica em primeiro lugar (Pole Position).
     */
    @Override
    public int compareTo(Piloto outro) {
        return Double.compare(this.tempoVolta, outro.tempoVolta);
    }

    @Override
    public String toString() {
        int minutos = (int) (tempoVolta / 60);
        double segundos = tempoVolta % 60;
        return String.format("%-20s | %-16s | %d:%06.3f", nome, equipa, minutos, segundos);
    }
}

