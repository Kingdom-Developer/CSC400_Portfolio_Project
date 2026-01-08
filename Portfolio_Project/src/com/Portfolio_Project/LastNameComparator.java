package com.Portfolio_Project;

import java.util.Comparator;

/**
 * Comparator class to compare People by last name (descending order).
 *
 * author Nolan_Hill
 */
public class LastNameComparator implements Comparator<Person> {

    /**
     * Compares two people by last name in descending alphabetical order.
     *
     * @param person1 the first person to be compared
     * @param person2 the second person to be compared
     * @return a negative value if person1's last name comes after person2's,
     * a positive value if person1's last name comes before person2's,
     * and zero if the last names are equal (ignoring case)
     */
    @Override
    public int compare(Person person1, Person person2) {
        // Compare last name of person1 to last name of person2
        return person2.getLastName().compareToIgnoreCase(person1.getLastName());
    }
}