
// Create an instance of MyArrayList
MyArrayList<String> myList = new MyArrayList<>();

// Add elements to the list
myList.add("Samsung");
myList.add("iPhone");
myList.add("Poco");
myList.add("Nokia");

// Print all elements using iterator
System.out.println("List contents:");
for (String phone : myList) {
    System.out.println(phone);
}

// Get and print an element from the list
System.out.println("\nElement at index 2: " + myList.get(2));

// Remove an element from the list
myList.remove(1); // Removes "iPhone"
System.out.println("\nAfter removing element at index 1:");

// Print all elements using iterator
for (String phone : myList) {
    System.out.println(phone);
}

// Add an element at the first position
myList.addFirst("Xiaomi");
System.out.println("\nAfter adding 'Xiaomi' at the first position:");

// Print all elements using iterator
for (String phone : myList) {
    System.out.println(phone);
}

// Add an element at the last position
myList.addLast("OnePlus");
System.out.println("\nAfter adding 'OnePlus' at the last position:");

// Print all elements using iterator
for (String phone : myList) {
    System.out.println(phone);
}

// Remove the first element
myList.removeFirst();
System.out.println("\nAfter removing the first element:");

// Print all elements using iterator
for (String phone : myList) {
    System.out.println(phone);
}

// Remove the last element
myList.removeLast();
System.out.println("\nAfter removing the last element:");

// Print all elements using iterator
for (String phone : myList) {
    System.out.println(phone);
}

// Set new element by index
myList.set(1, "iPhone");
System.out.println("\nAfter set at index 1:");

// Print all elements using iterator
for (String phone : myList) {
    System.out.println(phone);
}

// Check that element exists in list
System.out.println("\nAfter check that the element 'Nokia' exist: " + myList.exists("Nokia"));

// Check size of list
System.out.println("\nAfter check the size of the list: " + myList.size());

// Change from list to array and output array
Object[] array = myList.toArray();
System.out.println("\nAfter change from list to array: " + array.length);
System.out.println("\nArray of elements:");
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}

// Clear the list and output size after removing
myList.clear();
System.out.println("\nAfter clearing the list, size: " + myList.size());
