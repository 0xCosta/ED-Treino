package Ficha5.src.part1.ex1;

import Ficha5.src.ArrayList;
import Ficha5.src.Exceptions.ElementNotFoundException;
import Ficha5.src.Exceptions.EmptyCollectionException;
import Ficha5.src.OrderedListADT;


public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {
    
    @Override
    public void add(T element) {

        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (!(element instanceof Comparable)) {
            throw new IllegalArgumentException("Element must be comparable");
        }
        
        if (this.count == this.list.length) {
            this.expandCapacity();
        }

        Comparable<T> comparableElement = (Comparable<T>) element;

        int position = 0;

        while (position < this.count && comparableElement.compareTo(this.list[position]) > 0) {
            position++;
        }

        for (int i = this.count; i > position; i--) {
            this.list[i] = this.list[i - 1];
        }

        this.list[position] = element;
        this.count++;
    }
}
