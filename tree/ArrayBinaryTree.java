package tree;

import ADTs.BinaryTreeADT;
import exceptions.*;
import lists.ArrayUnorderedList;
import queue.LinkedQueue;
import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected T[] tree;
    protected int count;
    protected static final int INITIAL_CAPACITY = 10;

    public ArrayBinaryTree(){
        this.tree = (T[]) new Objetc[INITIAL_CAPACITY];
        this.count = 0;
    }

    public ArrayBinaryTree(T element) {
        this.tree = (T[]) new Object[INITIAL_CAPACITY];
        this.tree[0] = element;
        this.count = 1;

    }

    
}



