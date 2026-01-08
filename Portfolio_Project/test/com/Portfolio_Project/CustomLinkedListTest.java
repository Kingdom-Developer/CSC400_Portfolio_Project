package com.Portfolio_Project;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {
    @Test
    void testInsertSingleElement() {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(1);

        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testDeleteSingleElement() {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(1);
        list.insert(2);
        list.delete(1);

        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testLinkedListIterator() {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        Iterator<Integer> it = list.iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertEquals(4, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testIteratorThrowsExceptionWhenNoNext() {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(10);

        Iterator<Integer> it = list.iterator();
        it.next();
        assertThrows(NoSuchElementException.class, it::next);
    }
}