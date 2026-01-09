package com.Portfolio_Project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Custom linked list class that inserts at the tail and removes from the head
 *
 * @author Nolan_Hill
 */
public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Gets head of the CustomLinkedList
     *
     * @return the head of CustomLinkedList
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * Gets the size of the CustomLinkedList
     *
     * @return the size of CustomLinkedList
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Default constructor to create empty CustomLinkedList
     */
    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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

        // Increment size
        this.size++;
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

        // Decrement size
        this.size--;
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

    /**
     * Creates an array of items in the CustomLinkedList
     *
     * @return array of items in CustomLinkedList
     */
    public ArrayList<T> toList() {
        ArrayList<T> list = new ArrayList<>();

        int iteratorIndex = 0;
        Iterator<T> it = iterator();

        while (it.hasNext()) {
            list.add(iteratorIndex, it.next());
            iteratorIndex++;
        }

        return list;
    }
}