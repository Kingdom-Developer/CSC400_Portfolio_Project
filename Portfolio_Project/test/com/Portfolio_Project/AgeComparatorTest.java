package com.Portfolio_Project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgeComparatorTest {
    @Test
    void testAgeComparatorDescending() {
        AgeComparator comp = new AgeComparator();

        Person young = new Person("Tim", "Young", 20);
        Person old = new Person("Olga", "Old", 80);

        // Older person should come first
        assertTrue(comp.compare(old, young) < 0);  // old < young means old comes first
        assertTrue(comp.compare(young, old) > 0);  // young > old means young comes later
    }
}