package com.Portfolio_Project;

import java.util.Comparator;

/**
 * Comparator class to compare People by age (oldest to youngest)
 *
 * @author Nolan_Hill
 */
public class AgeComparator implements Comparator<Person> {

    /**
     * Override the compare method to compare two people by their age
     * @param person1 the first person to be compared.
     * @param person2 the second person to be compared.
     * @return the negative value if person1 is younger than person2,
     * a positive value if person1 is older than person2,
     * and zero if they are the same age
     */
    @Override
    public int compare(Person person1, Person person2) {
        // Compare age of person1 to age of person2
        return Integer.compare(person2.getAge(), person1.getAge());
    }
}