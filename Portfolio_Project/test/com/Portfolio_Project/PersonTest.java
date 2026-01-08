package com.Portfolio_Project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("John", "Smith", 34);
    }

    @Test
    void getFirstName() {
        assertEquals("John", person.getFirstName());
    }

    @Test
    void setFirstName() {
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    void setFirstNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(""));
    }

    @Test
    void setFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(null));
    }

    @Test
    void getLastName() {
        assertEquals("Smith", person.getLastName());
    }

    @Test
    void setLastName() {
        person.setLastName("Doe");
        assertEquals("Doe", person.getLastName());
    }

    @Test
    void setLastNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> person.setLastName(""));
    }

    @Test
    void getAge() {
        assertEquals(34, person.getAge());
    }

    @Test
    void setAge() {
        person.setAge(25);
        assertEquals(25, person.getAge());
    }

    @Test
    void setAgeLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }

    @Test
    void setAgeGreaterThan125() {
        assertThrows(IllegalArgumentException.class, () -> person.setAge(126));
    }

    @Test
    void testToString() {
        String expected = "First name: John\nLast name: Smith\nAge: 34";
        assertEquals(expected, person.toString());
    }
}