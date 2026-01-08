package com.Portfolio_Project;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Custom linked list class that inserts at the tail and removes from the head
 *
 * @author Nolan_Hill
 */
public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

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
    public void insert(T data) {
        // Create new Node with the data passed as an argument
        Node<T> newNode = new Node<>(data);

        // Check if the list is empty
        if (head == null) {
            // Set newNode as the head node
            head = newNode;
        }
        else {
            // Insert new node at the end of the list
            tail.next = newNode;
        }
        // Set newNode as the tail node
        tail = newNode;
    }

    /**
     * Deletes the head node (front of the CustomLinkedList)
     * @return the data to look for in node for deletion
     */
    public T deleteFirst() {
        // Check if CustomLinkedList is null
        if (head == null) {
            return null;
        }

        // Store the node to return
        Node<T> tempNode = head;

        // Move head forward
        head = head.next;

        // If list is now empty, update tail
        if (head == null) {
            tail = null;
        }

        return tempNode.getData();
    }

    /**
     * Creates an iterator for traversing the linked list
     * @return new LinkedListIterator object
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Node class to be used by CustomLinkedList
     */
    public static class Node<T> {
        T data;
        Node<T> next;

        /**
         * Gets the data of the node
         *
         * @return data of the node
         */
        public T getData() {
            return data;
        }

        /**
         * Parameterized constructor for Node
         * @param data the data to be stored within the Node
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Implements an iterator object for the CustomLinkedList
     */
    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

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
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}