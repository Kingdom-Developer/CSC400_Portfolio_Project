package com.Portfolio_Project;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    void quickSort_sortsPersonsByAgeDescending() {
        List<Person> people = Arrays.asList(
                new Person("Alice", "Smith", 30),
                new Person("Bob", "Jones", 20),
                new Person("Charlie", "Brown", 40)
        );

        AgeComparator comp = new AgeComparator();

        QuickSort.quickSort(people, 0, people.size() - 1, comp);

        assertEquals(40, people.get(0).getAge());
        assertEquals(30, people.get(1).getAge());
        assertEquals(20, people.get(2).getAge());
    }

    @Test
    void quickSort_sortsPersonsByLastNameDescending() {
        List<Person> people = Arrays.asList(
                new Person("Alice", "Smith", 30),
                new Person("Bob", "Jones", 20),
                new Person("Charlie", "Brown", 40)
        );

        LastNameComparator comp = new LastNameComparator();

        QuickSort.quickSort(people, 0, people.size() - 1, comp);

        assertEquals("Smith", people.get(0).getLastName());
        assertEquals("Jones", people.get(1).getLastName());
        assertEquals("Brown", people.get(2).getLastName());
    }
}