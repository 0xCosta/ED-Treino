package Ficha4.src.part2.ex4;

import ADTs.StackADT;
import stack.ArrayStack;
import ADTs.QueueADT;
import exceptions.EmptyCollectionException;

/**
 * Implementação de uma Queue (FIFO) com recurso a duas Stacks (LIFO).
 * - stackIn: recebe novas inserções (enqueue).
 * - stackOut: fornece as remoções e consultas (dequeue e first).
 *
 * @param <T> Tipo dos elementos na fila.
 */
public class QueueWithTwoStacks<T> implements QueueADT<T> {

    private StackADT<T> stackIn;
    private StackADT<T> stackOut;

    public QueueWithTwoStacks() {
        this.stackIn = new ArrayStack<>();
        this.stackOut = new ArrayStack<>();
    }

    @Override
    public void enqueue(T element) {
        this.stackIn.push(element); // O(1)
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Queue está vazia!");
        }

        shiftStacks();

        try {
            return this.stackOut.pop();
        } catch (EmptyCollectionException e) {
            throw new EmptyCollectionException("A Queue está vazia!");
        }
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Queue está vazia!");
        }

        shiftStacks();

        try {
            return this.stackOut.peek();
        } catch (EmptyCollectionException e) {
            throw new EmptyCollectionException("A Queue está vazia!");
        }
    }

    /**
     * Se a stackOut estiver vazia, transfere todos os elementos da stackIn
     * para a stackOut. Ao inverter a ordem LIFO duas vezes, obtemos FIFO!
     */
    private void shiftStacks() {
        if (this.stackOut.isEmpty()) {
            while (!this.stackIn.isEmpty()) {
                try {
                    this.stackOut.push(this.stackIn.pop());
                } catch (EmptyCollectionException e) {
                    break;
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.stackIn.isEmpty() && this.stackOut.isEmpty();
    }

    @Override
    public int size() {
        return this.stackIn.size() + this.stackOut.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueueWithTwoStacks [tamanho = ").append(size()).append("]\n");

        // Para listar os elementos sem destruir a fila original,
        // criamos uma cópia temporária e extraímos os elementos
        QueueWithTwoStacks<T> tempQueue = new QueueWithTwoStacks<>();
        
        shiftStacks();
        // Os elementos em ordem FIFO estão na stackOut (do topo até ao fundo)
        // e depois na stackIn (do fundo até ao topo)
        return "Elementos na fila: " + size() + " elementos";
    }

    public static void main(String[] args) throws EmptyCollectionException {
        QueueADT<String> queue = new QueueWithTwoStacks<>();

        System.out.println("=== Teste de Queue com Duas Stacks ===");

        // Inserção
        queue.enqueue("Primeiro");
        queue.enqueue("Segundo");
        queue.enqueue("Terceiro");
        System.out.println("Enqueued: Primeiro, Segundo, Terceiro");

        // Remoção (FIFO)
        System.out.println("First (esperado: Primeiro): " + queue.first());
        System.out.println("Dequeued (esperado: Primeiro): " + queue.dequeue());

        // Inserção intermédia
        queue.enqueue("Quarto");
        System.out.println("Enqueued: Quarto");

        // Remoção de todos os elementos restantes
        System.out.println("Dequeued (esperado: Segundo): " + queue.dequeue());
        System.out.println("Dequeued (esperado: Terceiro): " + queue.dequeue());
        System.out.println("Dequeued (esperado: Quarto): " + queue.dequeue());

        System.out.println("Fila está vazia? " + queue.isEmpty());
    }
}
