import java.util.LinkedList;

// MyQueue class declaration with a generic type E
public class MyQueue<E>{
    // Using MyLinkedList to store the queue elements
    private MyLinkedList<E> list = new MyLinkedList<>();

    // Method to enqueue an item to the queue
    public void enqueue(E item) {
        list.addLast(item); // Add the item to the end of the list
    }

    // Method to dequeue an item from the queue
    public E dequeue() {
        if (list.size() == 0) { // If the queue is empty
            return null; // Return null instead of throwing an exception
        }

        E item = list.getFirst(); // Get the first item of the list
        list.removeFirst(); // Remove the first item of the list
        return item; // Return the dequeued item
    }

    // Method to peek at the front item of the queue without removing it
    public E peek() {
        if (list.size() == 0) { // If the queue is empty
            return null; // Return null instead of throwing an exception
        }
        return list.getFirst(); // Return the first item of the list
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0; // Return true if the list size is zero
    }
}
