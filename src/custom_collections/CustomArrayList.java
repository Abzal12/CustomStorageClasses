package src.custom_collections;

import java.util.Arrays;

public class CustomArrayList<T>{
    private Object[] elementSpaces;
    private int actualSize = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList() {
        elementSpaces = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        if (actualSize == elementSpaces.length) {
            elementSpaces = Arrays.copyOf(elementSpaces, elementSpaces.length * 2);
        }
    }

    public void put(T element) {
        ensureCapacity();
        elementSpaces[actualSize++] = element;
    }

    public T get(int index) {

        try {
            return (T) elementSpaces[index];
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            return null;
        }

    }

    public T delete(int index) {

        T oldElement = null;
        try {
            oldElement = get(index);
            int numMoved = actualSize - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elementSpaces, index + 1, elementSpaces, index, numMoved);
            }
            elementSpaces[--actualSize] = null;
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return oldElement;
    }

    public int size() {
        return actualSize;
    }

    public Object[] getElementSpaces() {
        return elementSpaces;
    }

    public void showInstanceStateBehaviourAbilities() {
        System.out.println("CustomArrayList instance state:");
        System.out.println("Initial capacity by default: " + DEFAULT_CAPACITY);
        System.out.println("Current array list size is: " + size());
        System.out.println("Current capacity: " + getElementSpaces().length);
        System.out.println();
        System.out.println("CustomArrayList instance behaviour:");
        System.out.println("Querying 2nd element: " + get(1));
        System.out.println("Deleting 2nd element: " + delete(1));
        System.out.println("Querying 2nd element: " + get(1));
    }
}
