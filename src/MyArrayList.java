import java.util.Arrays;
import java.util.Iterator;

// MyArrayList class declaration implementing MyList interface
public class MyArrayList<E> implements MyList<E> {
    // Array to store the list elements
    private Object[] elements;
    // Variable to keep track of the number of elements in the list
    private int size;

    // Constructor to initialize the list with an initial capacity
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    // Method to add an item to the end of the list
    public void add(E item) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = item;
    }

    // Method to set/replace an item at a specific index
    public void set(int index, E item) {
        checkIndex(index);
        elements[index] = item;
    }

    // Method to add an item at a specific index
    public void add(int index, E item) {
        checkIndexForAdd(index);
        if (size == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    // Method to add an item at the beginning of the list
    public void addFirst(E item) {
        add(0, item);
    }

    // Method to add an item at the end of the list
    public void addLast(E item) {
        add(item);
    }

    // Method to get an item at a specific index
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    // Method to get the first item in the list
    public E getFirst() {
        return get(0);
    }

    // Method to get the last item in the list
    public E getLast() {
        return get(size - 1);
    }

    // Method to remove an item at a specific index
    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    // Method to remove the first item in the list
    public void removeFirst() {
        remove(0);
    }

    // Method to remove the last item in the list
    public void removeLast() {
        remove(size - 1);
    }

    // Method to sort the items in the list
    public void sort() {
        Arrays.sort((E[]) elements, 0, size);
    }

    // Method to find the index of an object in the list
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Method to find the last index of an object in the list
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        else {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Method to check if an object exists in the list
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    // Method to convert the list into an array
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    // Method to clear the list
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Iterator implementation to iterate over the list elements
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private  int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < size;
            }

            public E next() {
                return (E) elements[currentIndex++];
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }
        };
    }

    // Helper method to increase the capacity of the list when it's full
    private void increaseCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    // Helper method to check if the index is within the bounds of the list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index = " + index + ", Size = " + size);
        }
    }

    // Helper method to check if the index is within the bounds for adding an item
    private void checkIndexForAdd(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index = " + index + ", Size = " + size);
        }
    }
}