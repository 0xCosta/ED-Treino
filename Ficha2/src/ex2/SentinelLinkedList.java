package Ficha2.src.ex2;
import nodes.LinearNode;

public class SentinelLinkedList<T> {
    private LinearNode<T> head;
    private LinearNode<T> tail;

    /**
     * Numa lista com sentinelas, o head e o tail 
     * normalmente não começam a null.
     */
    public SentinelLinkedList() {
        this.head = new LinearNode<>(); // sentinela inicial (sem valor)
        this.tail = new LinearNode<>(); // sentinela final (sem valor)

        this.head.setNext(this.tail);   // no início, head aponta logo para tail
    }

    public LinearNode<T> getHead() {
        return this.head;
    }

    public LinearNode<T> getTail() {
        return this.tail;
    }

    public void setHead(LinearNode<T> head) {
        this.head = head;
    }

    public void setTail(LinearNode<T> tail) {
        this.tail = tail;
    }

    /**
     * Verifica se a lista está vazia.
     */
    public boolean isEmpty() {
        return this.head.getNext() == this.tail;
    }

    //Concetualmente, o tail substitui o null como o "marcador de fim da lista":
    public void add(T element){
        LinearNode<T> newNode = new LinearNode<>(element); //cria o nó
        LinearNode<T> current = head;

        while(current.getNext() != tail){ //percorre até ao tail
            current = current.getNext();
        }

        newNode.setNext(tail);
        current.setNext(newNode);
    }

    public boolean remove(T element){
        if(isEmpty()){
            return false;
        }

        /**
         * Com sentinelas, não precisas disto. O head é 
         * uma sentinela (não tem valor). Mesmo que queiras
         * apagar o primeiro elemento real, ele está a seguir
         * ao head, por isso o caso geral trata dele!
         * 
         * if (head.getElement().equals(element)) { ... }

         */

        LinearNode<T> current = this.head;

        // O elemento está no meio ou no fim
        while(current.getNext() != tail && !current.getNext().getElement().equals(element)){
            current = current.getNext();
        }

        // Se encontrou o nó com o elemento a seguir a current
        if(current.getNext() != tail){
            current.setNext(current.getNext().getNext());
            return true;
        }   
        return false;  
    }
    
    public void print(){
        if(isEmpty()){
            System.out.println("Lista vazia");
            return;
        }

        LinearNode<T> current = this.head.getNext();

        while(current != tail){
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
    }
}