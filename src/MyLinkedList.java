import java.util.Iterator;

// MyLinkedList class declaration with a generic type E
public class MyLinkedList<E> implements MyList<E>{
    // Inner class representing a node in the linked list
    private class MyNode<E>{
        E element; // The element contained within the node
        MyNode<E> next; // Reference to the next node in the list
        MyNode<E> prev; // Reference to the previous node in the list

        // Constructor for creating a new node
        MyNode(E element, MyNode<E> next, MyNode<E> prev){
            this.element = element; // Assign the element
            this.next = next; // Assign the next node
            this.prev = prev; // Assign the previous node
        }
    }

    // References to the first and last nodes of the list
    private MyNode<E> head; // The first node of the list
    private MyNode<E> tail; // The last node of the list
    private int size; // The number of elements in the list

    // Constructor for initializing the linked list
    public MyLinkedList(){
        head = null; // Initially, the list is empty, so head is null
        tail = null; // Initially, the list is empty, so tail is null
        size = 0; // Initially, the list size is zero
    }

    // Method to add an item to the end of the list
    public void add (E item) {
        if (head == null) { // If the list is empty
            head = new MyNode(item, null, null); // Create a new node as the head
            tail = head; // The head is also the tail in a one-element list
        }
        else { // If the list is not empty
            MyNode<E> newNode = new MyNode<> (item, tail, null); // Create a new node after the current tail
            tail.next = newNode; // Link the current tail to the new node
            tail = newNode; // The new node becomes the new tail
        }
        size++; // Increase the size of the list
    }

    // Method to set/replace an item at a specific index
    public void set(int index, E item) {
        MyNode<E> current = getNode(index); // Get the node at the specified index
        if (current != null) { // If the node exists
            current.element = item; // Set the node's element to the new item
        }
        else { // If the node does not exist
            throw new IndexOutOfBoundsException(); // Throw an exception
        }
    }

    // Method to add an item at a specific index
    public void add(int index, E item) {
        if (index == size) { // If adding at the end of the list
            addLast(item); // Use the addLast method
        }
        else { // If adding somewhere in the middle
            MyNode<E> current = getNode(index); // Get the node at the specified index
            if (current != null) { // If the node exists
                MyNode<E> newNode = new MyNode<> (item, current.prev, current); // Create a new node before the current node
                if (current.prev != null) { // If the current node is not the head
                    current.prev.next = newNode; // Link the previous node to the new node
                }
                else { // If the current node is the head
                    head = newNode; // The new node becomes the new head
                }
                current.prev = newNode; // Link the current node back to the new node
                size++; // Increase the size of the list
            }
            else { // If the node does not exist
                throw new IndexOutOfBoundsException(); // Throw an exception
            }
        }
    }

    // Method to add an item at the beginning of the list
    public void addFirst(E item) {
        MyNode<E> newNode = new MyNode<>(item, null, head); // Create a new node before the current head
        if (head != null) { // If the list is not empty
            head.prev = newNode; // Link the current head back to the new node
        }
        else { // If the list is empty
            tail = newNode; // The new node is also the tail
        }
        head = newNode; // The new node becomes the new head
        size++; // Increase the size of the list
    }

    // Method to add an item at the end of the list
    public void addLast(E item) {
        if (tail == null) { // If the list is empty
            addFirst(item); // Use the addFirst method
        }
        else { // If the list is not empty
            MyNode<E> newNode = new MyNode<>(item, tail, null); // Create a new node after the current tail
            tail.next = newNode; // Link the current tail to the new node
            tail = newNode; // The new node becomes the new tail
            size++; // Increase the size of the list
        }
    }

    // Method to get an item at a specific index
    public E get(int index) {
        MyNode<E> current = getNode(index); // Get the node at the specified index
        return (current != null) ? current.element : null; // Return the element or null if the node does not exist
    }

    // Method to get the first item in the list
    public E getFirst() {
        return (head != null) ? head.element : null; // Return the head element or null if the list is empty
    }

    // Method to get the last item in the list
    public E getLast() {
        return (tail != null) ? tail.element : null; // Return the tail element or null if the list is empty
    }

    // Method to remove an item at a specific index
    public void remove(int index) {
        MyNode<E> current = getNode(index); // Get the node at the specified index
        if (current != null) { // If the node exists
            if (current.prev != null) { // If the node is not the head
                current.prev.next = current.next; // Link the previous node to the next node
            }
            else { // If the node is the head
                head = current.next; // The next node becomes the new head
            }
            if (current.next != null) { // If the node is not the tail
                current.next.prev = current.prev; // Link the next node back to the previous node
            }
            else { // If the node is the tail
                tail = current.prev; // The previous node becomes the new tail
            }
            size--; // Decrease the size of the list
        }
        else { // If the node does not exist
            throw new IndexOutOfBoundsException(); // Throw an exception
        }
    }

    // Method to remove the first item in the list
    public void removeFirst() {
        if (head != null) { // If the list is not empty
            head = head.next; // The next node becomes the new head
            if (head != null) { // If the list is not reduced to empty
                head.prev = null; // The new head has no previous node
            }
            else { // If the list is now empty
                tail = null; // There is no tail
            }
            size--; // Decrease the size of the list
        }
        else { // If the list is empty
            throw new IndexOutOfBoundsException(); // Throw an exception
        }
    }

    // Method to remove the last item in the list
    public void removeLast() {
        if (tail != null) { // If the list is not empty
            tail = tail.prev; // The previous node becomes the new tail
            if (tail != null) { // If the list is not reduced to empty
                tail.next = null; // The new tail has no next node
            }
            else { // If the list is now empty
                head = null; // There is no head
            }
            size--; // Decrease the size of the list
        }
        else { // If the list is empty
            throw new IndexOutOfBoundsException(); // Throw an exception
        }
    }

    // Method to sort the list (currently the method body is commented out)
    public void sort() {
        if (size > 1) {
            head = mergeSort(head); // Sort the list starting from the head
            tail = head; // Start with the head as the tail
            while (tail.next != null) { // Traverse to the end of the list
                tail = tail.next; // Move the tail to the next node
            }
        }
    }

    // Helper method for merge sort algorithm
    private MyNode<E> mergeSort(MyNode<E> head) {
        if (head == null || head.next == null) { // If the list is empty or has one element
            return head; // Return the head as is
        }

        MyNode<E> middle = getMiddle(head); // Find the middle of the list
        MyNode<E> nextOfMiddle = middle.next; // The node after the middle
        middle.next = null; // Split the list into two halves

        MyNode<E> left = mergeSort(head); // Sort the left half
        MyNode<E> right = mergeSort(nextOfMiddle); // Sort the right half

        return merge(left, right); // Merge both sorted halves
    }

    // Helper method to merge two sorted lists
    private MyNode<E> merge(MyNode<E> left, MyNode<E> right) {
        MyNode<E> result = null; // Initialize the result list

        // Base cases for recursion
        if (left == null) {
            return right; // If left list is empty, return right list
        }
        if (right == null) {
            return left; // If right list is empty, return left list
        }

        // Uncomment and complete the comparison logic based on the type E
//         if (left.element.compareTo(right.element) <= 0) {
//             result = left;
//             result.next = merge(left.next, right);
//         }
//         else {
//             result = right;
//             result.next = merge(left, right.next);
//         }

        return result; // Return the merged list
    }

    // Helper method to find the middle node of the list
    private MyNode<E> getMiddle(MyNode<E> head) {
        if (head == null) {
            return head; // If the list is empty, return the head
        }

        MyNode<E> slow = head, fast = head; // Initialize two pointers, slow and fast

        // Move fast pointer two steps and slow pointer one step until fast reaches the end
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; // Slow pointer moves one step
            fast = fast.next.next; // Fast pointer moves two steps
        }
        return slow; // Slow pointer will be at the middle
    }

    // Method to find the index of a specific object in the list
    public int indexOf(Object object) {
        MyNode<E> current = head; // Start from the head of the list
        int index = 0; // Initialize the index counter

        // Iterate through the list until the end
        while (current != null) {
            if (current.element.equals(object)) { // If the current element matches the object
                return index; // Return the current index
            }
            current = current.next; // Move to the next node
            index++; // Increment the index counter
        }
        return -1; // If the object is not found, return -1
    }

    // Method to find the last index of a specific object in the list
    public int lastIndexOf(Object object) {
        MyNode<E> current = tail; // Start from the tail of the list
        int index = size - 1; // Initialize the index counter from the end of the list

        // Iterate through the list backwards until the beginning
        while (current != null) {
            if (current.element.equals(object)) { // If the current element matches the object
                return index; // Return the current index
            }
            current = current.prev; // Move to the previous node
            index--; // Decrement the index counter
        }
        return -1; // If the object is not found, return -1
    }

    // Method to check if an object exists in the list
    public boolean exists(Object object) {
        return indexOf(object) >= 0; // Use indexOf to check existence
    }

    // Method to convert the list into an array
    public Object[] toArray() {
        Object[] array = new Object[size]; // Create a new array with the size of the list
        MyNode<E> current = head; // Start from the head of the list
        int index = 0; // Initialize the index counter

        // Iterate through the list until the end
        while (current != null) {
            array[index++] = current.element; // Add the element to the array
            current = current.next; // Move to the next node
        }
        return array; // Return the array containing all elements
    }

    // Method to clear the list
    public void clear() {
        head = null; // Set the head to null
        tail = null; // Set the tail to null
        size = 0; // Set the size of the list to zero
    }

    // Method to get the size of the list
    public int size() {
        return size; // Return the size
    }

    // Helper method to get the node at a specific index
    private MyNode<E> getNode(int index) {
        if (index < 0 || index >= size) { // If the index is out of bounds
            return null; // Return null
        }
        MyNode<E> current = head; // Start from the head of the list
        for (int i = 0; i < index; i++) { // Iterate to the specified index
            current = current.next; // Move to the next node
        }
        return current; // Return the node at the specified index
    }

    // Iterator implementation to iterate over the list elements
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyNode<E> current = head; // Start from the head of the list

            public boolean hasNext() {
                return current != null; // Return true if there is a next element
            }

            public E next() {
                if (!hasNext()) { // If there is no next element
                    return null; // Return null
                }
                E item = current.element; // Get the current element
                current = current.next; // Move to the next node
                return item; // Return the current element
            }

            public void remove() {
                throw new UnsupportedOperationException(); // Remove operation is not supported
            }
        };
    }
}
