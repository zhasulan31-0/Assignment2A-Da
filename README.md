# Assignment2A-Da

Documentation

#### MyList
**MyList** is an interface that specifies fundamental operations such as adding, deleting, and retrieving elements.

**Methods:**
- **add(E item)**: Appends an element to the end of the list.
- **set(int index, E item)**: Replaces the element at the specified index.
- **add(int index, E item)**: Inserts an element at the specified index.
- **addFirst(E item)**: Adds an element to the beginning of the list.
- **addLast(E item)**: Adds an element to the end of the list.
- **get(int index)**: Retrieves the element at the specified index.
- **getFirst()**: Retrieves the first element of the list.
- **getLast()**: Retrieves the last element of the list.
- **remove(int index)**: Removes the element at the specified index.
- **removeFirst()**: Removes the first element of the list.
- **removeLast()**: Removes the last element of the list.
- **sort()**: Sorts the elements of the list.
- **indexOf(Object object)**: Returns the index of the first occurrence of the specified element.
- **lastIndexOf(Object object)**: Returns the index of the last occurrence of the specified element.
- **exists(Object object)**: Checks if the specified element is in the list.
- **toArray()**: Converts the list to an array.
- **clear()**: Removes all elements from the list.
- **size()**: Returns the number of elements in the list.

#### MyArrayList
**MyArrayList** is a concrete implementation of the `MyList` interface, utilizing an array for storage.

**Example usage:**
MyArrayList<String> list = new MyArrayList<>();
list.add("iPhone");
list.add("Samsung Galaxy");
String phone = list.get(0); // Returns "iPhone"
list.remove(1); // Removes "Samsung Galaxy"

#### MyLinkedList
**MyLinkedList** is a concrete implementation of the `MyList` interface, utilizing a doubly linked list for storage.

**Example usage:**
MyLinkedList<String> list = new MyLinkedList<>();
list.add("iPhone");
list.addFirst("Samsung Galaxy");
String phone = list.getFirst(); // Returns "Samsung Galaxy"
list.removeLast(); // Removes "iPhone"


#### MyStack
**MyStack** is a class implementing a stack data structure, internally using `MyLinkedList` for storage.

**Example usage (This example is not included in the Main class; copy it if needed):**
MyStack<String> stack = new MyStack<>();
stack.push("iPhone");
String phone = stack.peek(); // Returns "iPhone" without removing it
phone = stack.pop(); // Returns "iPhone", removing it

#### MyQueue
**MyQueue** is a class implementing a queue data structure, internally using `MyLinkedList` for storage.

**Example usage (This example is not included in the Main class; copy it if needed):**
MyQueue<String> queue = new MyQueue<>();
queue.enqueue("iPhone");
String phone = queue.peek(); // Returns "iPhone" without removing it
phone = queue.dequeue(); // Returns "iPhone", removing it

#### MyMinHeap
**MyMinHeap** is a class implementing a min-heap data structure, internally using `MyArrayList` for storage.

**Example usage (This example is not included in the Main class; copy it if needed):**
MyMinHeap<Integer> minHeap = new MyMinHeap<>();
minHeap.add(10);
minHeap.add(5);
int min = minHeap.peek(); // Returns 5 without removing it
min = minHeap.remove(); // Returns 5, removing it

#### Main
**Main** is a class that includes a `main` method for testing implementations of the aforementioned collections.

**Example usage (See 'Main.java' for additional operations):**
MyArrayList<String> list = new MyArrayList<>();
list.add("iPhone");
// Perform other operations with the list...
