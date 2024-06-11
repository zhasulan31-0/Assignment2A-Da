// MyMinHeap class declaration with a generic type E that must be Comparable
public class MyMinHeap<E extends Comparable<E>>{
    // Using MyArrayList to store the heap elements
    private MyArrayList<E> list = new MyArrayList<>();

    // Method to add an item to the heap
    public void add(E item) {
        list.add(item); // Add the item to the end of the list
        int i = list.size() - 1; // Start with the last element
        // Heapify-up procedure to maintain the heap property
        while (i > 0) {
            int parent = (i - 1) / 2; // Calculate the parent's index
            E currentItem = list.get(i); // Get the current item
            E parentItem = list.get(parent); // Get the parent item
            // If the current item is less than the parent item, swap them
            if (currentItem.compareTo(parentItem) < 0) {
                list.set(i, parentItem); // Set the parent's item to the current index
                list.set(parent, currentItem); // Set the current item to the parent's index
                i = parent; // Move up to the parent's index
            }
            else {
                break; // If the heap property is satisfied, break the loop
            }
        }
    }

    // Method to remove the minimum item from the heap
    public E remove() {
        if (list.size() == 0) { // If the heap is empty
            return null; // Return null instead of throwing an exception
        }

        E minItem = list.get(0); // Get the minimum item (at the root of the heap)
//        E lastItem = list.removeLast(); // Get the last item and remove it from the list
        if (list.size() > 0) {
//            list.set(0, lastItem); // Set the last item to the root
            minHeapify(0); // Heapify-down procedure to maintain the heap property
        }
        return minItem; // Return the minimum item
    }

    // Helper method to maintain the heap property from a given index down the heap
    private void minHeapify(int i) {
        int left = 2 * i + 1; // Calculate the left child's index
        int right = 2 * i + 2; // Calculate the right child's index
        int smallest = i; // Assume the smallest item is at the current index
        // If the left child exists and is smaller than the current item, update the smallest index
        if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
            smallest = left;
        }
        // If the right child exists and is smaller than the current smallest item, update the smallest index
        if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
            smallest = right;
        }
        // If the smallest item is not at the current index, swap with the smallest child
        if (smallest != i) {
            E temp = list.get(i); // Temporarily store the current item
            list.set(i, list.get(smallest)); // Set the smallest child's item to the current index
            list.set(smallest, temp); // Set the current item to the smallest child's index
            minHeapify(smallest); // Recursively heapify-down from the smallest child's index
        }
    }

    // Method to get the minimum item from the heap without removing it
    public E peek() {
        if (list.size() == 0) { // If the heap is empty
            return null; // Return null instead of throwing an exception
        }
        return list.get(0); // Return the item at the root of the heap
    }

    // Method to check if the heap is empty
    public boolean isEmpty() {
        return list.size() == 0; // Return true if the list size is zero
    }
}
