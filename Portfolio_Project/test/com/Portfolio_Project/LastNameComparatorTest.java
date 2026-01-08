package com.Portfolio_Project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LastNameComparatorTest {
    @Test
    void testLastNameComparatorDescending() {
        LastNameComparator comp = new LastNameComparator();

        Person a = new Person("Alice", "Smith", 30);
        Person b = new Person("Bob", "Jones", 25);

        assertTrue(comp.compare(a, b) < 0);
        assertTrue(comp.compare(b, a) > 0);
    }
}