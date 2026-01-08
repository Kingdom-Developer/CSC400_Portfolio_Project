package com.Portfolio_Project;

public class Queue<T> {
    private CustomLinkedList<T> queue = new CustomLinkedList<>();

    /**
     * Retrieves the size of the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return queue.getSize();
    }

    /**
     * Checks if the queue is empty or not
     *
     * @return true if queue is empty and false if it is not empty
     */
    public boolean isEmpty() {
        return queue.getSize() == 0;
    }

    /**
     * Adds item to the back of the queue
     *
     * @param item the item to be added
     */
    public void enqueue(T item) {
        queue.insert(item);
    }

    /**
     * Retrieves first item in queue without removing it
     *
     * @return data of the first item in the queue
     */
    public T first() {
        // Check if the head is null
        if (queue.getHead() == null) {
            return null;
        }
        return queue.getHead().getData();
    }

    /**
     * Removes the first item in the queue and returns it
     *
     * @return the first item in queue that was removed
     */
    public T dequeue() {
        // Dequeue first item from queue and return the data of the item
        return queue.deleteFirst();
    }
}