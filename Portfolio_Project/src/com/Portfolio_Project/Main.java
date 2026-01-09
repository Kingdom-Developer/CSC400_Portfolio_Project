package com.Portfolio_Project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program that uses that stores five Person objects with information provided by the user
 */
public class Main {
    public static void main(String[] args) {
        // Declare variables to be used
        String firstName;
        String lastName;
        int age;

        // Create an empty Queue to store Person objects
        Queue<Person> personQueue = new Queue<>();

        // Create Scanner object
        Scanner scnr = new Scanner(System.in);

        // Prompts that will be used for first name and last name respectively
        String firstNamePrompt = "Please enter the first name: ";
        String lastNamePrompt = "Please enter the last name: ";

        // Create five Person objects from user's input and store them to the Queue
        for (int i = 0; i < 5; i++) {
            // Retrieve information for new Person
            firstName = getInputString(scnr, firstNamePrompt);
            lastName = getInputString(scnr, lastNamePrompt);
            age = getInputAge(scnr);

            // Create new Person object and add them to the Queue
            personQueue.enqueue(new Person(firstName, lastName, age));

            System.out.println("Person " + (i + 1) + " successfully created!");
        }

        // Convert the Queue into a List
        ArrayList<Person> personList = personQueue.getQueue().toList();

        System.out.println("_______________________________UNSORTED_______________________________\n");

        for (Object p : personList) {
            System.out.println(p.toString() + "\n");
        }

        System.out.println("____________________________SORTED BY AGE_____________________________\n");

        // Sort the list of Person objects by age (descending)
        QuickSort.quickSort(personList, 0, personQueue.size() - 1, new AgeComparator());

        for (Object p : personList) {
            System.out.println(p.toString() + "\n");
        }

        System.out.println("_________________________SORTED BY LAST NAME__________________________\n");

        // Sort the list of Person objects by last name (descending)
        QuickSort.quickSort(personList, 0, personQueue.size() - 1, new LastNameComparator());

        for (Object p : personList) {
            System.out.println(p.toString() + "\n");
        }
    }

    /**
     * Helper method to obtain validated user input as a String
     *
     * @param scnr the scanner object to read in user input
     * @return the validated user input as a String
     */
    public static String getInputString(Scanner scnr, String promptMessage) {
        // Variable to hold user input
        String input;

        // Keep prompting user for input if their input is empty
        System.out.print(promptMessage);
        while (true) {
            input = scnr.nextLine();

            // Check if user input is empty
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.print("Field cannot be empty, please try again: ");
        }
    }

    /**
     * Helper method to obtain validated user input for age as an int
     *
     * @param scnr the scanner object to read in user input
     * @return the validated user number between 0 and 125
     */
    public static int getInputAge(Scanner scnr) {
        // Declare variable to store valid int
        int age;

        // Prompt User for int number
        System.out.print("Please enter an age between 0 and 125 (inclusive): ");

        // Keep checking for user int till received
        while (!scnr.hasNextInt()) {
            System.out.print("Incorrect entry, please try again: ");
            // Clear invalid input
            scnr.next();
        }

        // Store valid int to variable
        age = scnr.nextInt();
        scnr.nextLine();

        // Validate that user int is between 0 and 125
        while (age < 0 || age > 125) {
            System.out.print("The entered age is out of range, please enter a value between 0 and 125 (inclusive): ");
            while (!scnr.hasNextInt()) {
                System.out.print("Incorrect entry, please try again: ");
                scnr.next();
            }
            age = scnr.nextInt();
            scnr.nextLine();
        }
        return age;
    }
}