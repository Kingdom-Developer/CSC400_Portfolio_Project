package com.Portfolio_Project;

/**
 * Class to hold a person's first and last name, and age.
 * <p>Contains functionality to retrieve and set the information of a person</p>
 *
 * @author Nolan_Hill
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    /**
     * Gets the first name of the person.
     *
     * @return the first name as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName the first name to set
     * @throws IllegalArgumentException if firstName is null or empty
     */
    public void setFirstName(String firstName) {
        // Check if firstName input is null or empty
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty or null.");
        }
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return the last name as a String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastName the first name to set
     * @throws IllegalArgumentException if lastName is null or empty
     */
    public void setLastName(String lastName) {
        // Check if lastName input is null or empty
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty or null.");
        }
        this.lastName = lastName;
    }

    /**
     * Gets the age of the person.
     *
     * @return the age as an int
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age the age to set
     * @throws IllegalArgumentException if age is less than 0 or greater than 125
     */
    public void setAge(int age) {
        // Check if age input is not within '0' to '125'
        if (age < 0 || age > 125) {
            throw new IllegalArgumentException("Age cannot be less than '0' or greater than '125'.");
        }
        this.age = age;
    }

    /**
     * Constructs a Person object with the specified first name, last name, and age.
     *
     * @param firstName the first name of the person (cannot be null or empty)
     * @param lastName the last name of the person (cannot be null or empty)
     * @param age the age of the person (must be between 0 and 125)
     * @throws IllegalArgumentException if firstName or lastName is null or empty,
     * or if age is not between 0 and 125 (inclusively).
     */
    public Person(String firstName, String lastName, int age) {
        // Check if firstName input is null or empty
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty or null.");
        }

        // Check if lastName input is null or empty
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty or null.");
        }

        // Check if age input is not within '0' to '125'
        if (age < 0 || age > 125) {
            throw new IllegalArgumentException("Age cannot be less than '0' or greater than '125'.");
        }

        // Set Person's information
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Returns a string representation of the Person object.
     * The format includes the first name, last name, and age.
     *
     * @return a string in the format: "First name: [first name]\nLast name: [last name]\nAge: [age]"
     */
    @Override
    public String toString() {
        return "First name: " + getFirstName() + "\n" + "Last name: " + getLastName() + "\n" + "Age: " + getAge();
    }
}
