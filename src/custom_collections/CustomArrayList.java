package src.custom_collections;

import java.util.Arrays;

public class CustomArrayList<T>{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public void put(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {

        try {
            return (T) elements[index];
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            return null;
        }

    }

    public T delete(int index) {

        T oldElement = null;
        try {
            oldElement = get(index);
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elements, index + 1, elements, index, numMoved);
            }
            elements[--size] = null;
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return oldElement;
    }

    public int size() {
        return size;
    }

    public Object[] getElements() {
        return elements;
    }

    public void showInstanceStateBehaviourAbilities() {
        System.out.println("CustomArrayList instance state:");
        System.out.println("Initial capacity by default: " + DEFAULT_CAPACITY);
        System.out.println("Current array list size is: " + size());
        System.out.println("Current capacity: " + elements.length);
        System.out.println();
        System.out.println("CustomArrayList instance behaviour:");
        System.out.println("Querying 2nd element: " + get(1));
        System.out.println("Deleting 2nd element: " + delete(1));
        System.out.println("Querying 2nd element: " + get(1));

    }
}
