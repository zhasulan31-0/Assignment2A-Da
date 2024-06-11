public interface MyList<E> extends Iterable<E>{
    // Method to add an item to the list
    void add(E item);
    // Method to set/replace an item at a specific index
    void set(int index, E item);
    // Method to add an item at a specific index
    void add(int index, E item);
    // Method to add an item at the beginning of the list
    void addFirst(E item);
    // Method to add an item at the end of the list
    void addLast(E item);
    // Method to get an item at a specific index
    E get(int index);
    // Method to get the first item in the list
    E getFirst();
    // Method to get the last item in the list
    E getLast();
    // Method to remove an item at a specific index
    void remove(int index);
    // Method to remove the first item in the list
    void removeFirst();
    // Method to remove the last item in the list
    void removeLast();
    // Method to sort the items in the list
    void sort();
    // Method to find the index of an object in the list
    int indexOf(Object object);
    // Method to find the last index of an object in the list
    int lastIndexOf(Object object);
    // Method to check if an object exists in the list
    boolean exists(Object object);
    // Method to convert the list into an array
    public Object[] toArray();
    // Method to clear the list
    void clear();
    // Method to get the size of the list
    int size();
}
