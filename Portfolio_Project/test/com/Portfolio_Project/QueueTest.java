package com.Portfolio_Project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void size() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());

        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    void isEmpty() {
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue("A");
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void enqueue() {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(5);
        queue.enqueue(10);

        assertEquals(2, queue.size());
        assertEquals(5, queue.first());
    }

    @Test
    void first() {
        Queue<String> queue = new Queue<>();

        assertNull(queue.first());

        queue.enqueue("Hello");
        queue.enqueue("World");

        assertEquals("Hello", queue.first());
        assertEquals(2, queue.size());
    }

    @Test
    void dequeue() {
        Queue<Integer> queue = new Queue<>();

        assertNull(queue.dequeue());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        assertTrue(queue.isEmpty());
        assertNull(queue.dequeue());
    }
}