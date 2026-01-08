package com.Portfolio_Project;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListPersonTest {

    @Test
    void testInsertPerson() {
        CustomLinkedList<Person> list = new CustomLinkedList<>();

        Person alice = new Person("Alice", "Smith", 30);
        list.insert(alice);

        Iterator<Person> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(alice, it.next());   // same instance
        assertFalse(it.hasNext());
    }

    @Test
    void testDeletePerson() {
        CustomLinkedList<Person> list = new CustomLinkedList<>();

        Person alice = new Person("Alice", "Smith", 30);
        Person bob = new Person("Bob", "Jones", 25);

        list.insert(alice);
        list.insert(bob);

        list.delete(alice);   // must pass same object reference

        Iterator<Person> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(bob, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testPersonIteratorOrder() {
        CustomLinkedList<Person> list = new CustomLinkedList<>();

        Person a = new Person("A", "One", 10);
        Person b = new Person("B", "Two", 20);
        Person c = new Person("C", "Three", 30);

        list.insert(a);
        list.insert(b);
        list.insert(c);

        Iterator<Person> it = list.iterator();
        assertEquals(a, it.next());
        assertEquals(b, it.next());
        assertEquals(c, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testIteratorThrowsExceptionWhenNoNext() {
        CustomLinkedList<Person> list = new CustomLinkedList<>();

        Person p = new Person("Zed", "Zero", 99);
        list.insert(p);

        Iterator<Person> it = list.iterator();
        it.next();
        assertThrows(NoSuchElementException.class, it::next);
    }
}