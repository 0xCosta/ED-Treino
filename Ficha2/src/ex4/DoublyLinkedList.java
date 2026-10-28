package Ficha2.src.ex4;

import nodes.DoubleLinearNode;

public class DoublyLinkedList<T> {
   private DoubleLinearNode<T> head;
   private DoubleLinearNode<T> tail;

   public DoublyLinkedList() {
      this.head = null;
      this.tail = null;
   }

   public DoubleLinearNode<T> getHead() {
      return head;
   }

   public void setHead(DoubleLinearNode<T> head) {
      this.head = head;
   }

   public DoubleLinearNode<T> getTail() {
      return tail;
   }

   public void setTail(DoubleLinearNode<T> tail) {
      this.tail = tail;
   }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T element) {
        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        } 
    }

    public boolean removeFirst() {
        if (head == null) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }

        return true;
    }

    public void addLast(T element) {
        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public boolean removeLast() {
        if (tail == null) {
            return false; // Lista vazia
        }

        if (head == tail) {
            // Lista com 1 só elemento
            head = null;
            tail = null;
        } else {
            // Mais de 1 elemento
            tail = tail.getPrevious();
            tail.setNext(null);
        }

        return true;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }

        DoubleLinearNode<T> current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
