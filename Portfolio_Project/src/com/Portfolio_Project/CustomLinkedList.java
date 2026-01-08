package com.Portfolio_Project;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Custom linked list class that inserts at the tail and removes from the head
 *
 * @author Nolan_Hill
 */
public class CustomLinkedList {
    private Node head;
    private Node tail;

    /**
     * Default constructor to create empty CustomLinkedList
     */
    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts a new node with the given data
     * @param data the data assigned to a node
     */
    public void insert(int data) {
        // Create new Node with the data passed as an argument
        Node newNode = new Node(data);

        // Check if the list is empty
        if (head == null) {
            // Set newNode as the head and tail node
            head = newNode;
            tail = newNode;
        }
        else {
            // Insert new node at the end of the list
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Deletes the first occurrence of a node with the given data
     * @param data the data to look for in node for deletion
     */
    public void delete(int data) {
        // Check if the list is empty
        if (head == null) {
            return;
        }

        // Check if head Node contains first occurrence of data
        if (head.data == data) {
            head = head.next;

            // Check if list is now empty and set tail to null if it is
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node currentNode = head;
        // Traverse through list to check if any Node's data matches the input data and if so, remove the Node
        while (currentNode.next != null) {
            // Check if currentNode's next Node's data matches
            if (currentNode.next.data == data) {
                // Remove currentNode's next Node
                currentNode.next = currentNode.next.next;

                // Check if the removed Node was the tail
                if (currentNode.next == null) {
                    tail = currentNode;
                }
                return;
            }

            // Move to next Node in list
            currentNode = currentNode.next;
        }
        // When method reaches this point, print that the value was not found
        System.out.println("Unable to delete '" + data + "', value not found.");
    }

    /**
     * Creates an iterator for traversing the linked list
     * @return new LinkedListIterator object
     */
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Node class to be used by CustomLinkedList
     */
    private class Node {
        int data;
        Node next;

        /**
         * Parameterized constructor for Node
         * @param data the data to be stored within the Node
         */
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Implements a iterator object for the CustomLinkedList
     */
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        /**
         * Override hasNext method for LinkedListIterator
         * @return true if the there is a next Node or false if there is not
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Override next method for LinkedListIterator
         * @return data of current Node
         */
        @Override
        public Integer next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}