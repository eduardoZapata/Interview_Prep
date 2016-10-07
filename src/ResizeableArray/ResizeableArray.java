package ResizeableArray;

import java.util.Arrays;

/**
 * Created by eduardozapata on 10/7/16.
 */
public class ResizeableArray<E> {

    private E[] container;
    private int capacity;
    private int size;

    public ResizeableArray() {
        this.container = (E[]) new Object[8];
        this.capacity = 8;
        this.size = 0;
    }

    public ResizeableArray(int size) {
        this.container = (E[]) new Object[size];
        this.capacity = size;
        this.size = 0;
    }

    public ResizeableArray(int size, E element) {
        this.container = (E[]) new Object[size];
        this.capacity = size;
        this.size = size;

        for(int i = 0; i < this.capacity; ++i) {
            this.container[i] = element;
        }
    }

    public void pushBack(E element) {
        if(size == capacity) {
            capacity = capacity * 2;
            container = Arrays.copyOf(container, capacity);
        }
        container[size] = element;
        ++size;

    }

    public E get(int index) {
        if(index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return container[index];
    }

    public void set(int index, E element) {
        if(index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        container[index] = element;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("[");

        for (int i = 0; i < size; i++) {
            output.append(container[i]);
            if(i != size - 1) {
                output.append(", ");
            }
        }
        output.append("]");

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println("New array");
        ResizeableArray<Integer> r = new ResizeableArray<Integer>();
        System.out.println(r.toString());
        System.out.println(r.size());
        r.pushBack(1);
        r.pushBack(2);
        r.pushBack(3);

        System.out.println(r.toString());
        System.out.println(r.size());

        System.out.println("Element at index 1: " + r.get(1));
        //System.out.println("Out of bounds: " + r.get(-1));

        r.set(1,10);
        System.out.println("Element at index 1: " + r.get(1));

    }
}

