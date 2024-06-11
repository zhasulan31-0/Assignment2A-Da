import java.util.LinkedList;

// MyStack class declaration with a generic type E
public class MyStack<E> {
    // Using MyLinkedList to store the stack elements
    private MyLinkedList<E> list = new MyLinkedList<>();

    // Method to push an item onto the stack
    public void push(E item) {
        list.addFirst(item); // Add the item to the beginning of the list
    }

    // Method to pop an item off the stack
    public E pop() {
        if (list.size() == 0) { // If the stack is empty
            return null; // Return null instead of throwing an exception
        }
        E item = list.getFirst(); // Get the first item of the list
        list.removeFirst(); // Remove the first item of the list
        return item; // Return the popped item
    }

    // Method to peek at the top item of the stack without removing it
    public E peek() {
        if (list.size() == 0) { // If the stack is empty
            return null; // Return null instead of throwing an exception
        }
        return list.getFirst(); // Return the first item of the list
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0; // Return true if the list size is zero
    }
}
