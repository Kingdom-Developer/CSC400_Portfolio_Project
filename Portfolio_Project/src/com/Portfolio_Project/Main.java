package com.Portfolio_Project;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Queue<Person> personQueue = new Queue<>();


        personQueue.enqueue(new Person("Sam", "Welsh", 50));
        personQueue.enqueue(new Person("Adam", "Sandler",45));
        personQueue.enqueue(new Person("John", "Denver", 73));
        personQueue.enqueue(new Person("Hank", "Hill", 47));
        personQueue.enqueue(new Person("Jack", "Anderson", 64));

        ArrayList<Person> personList = personQueue.getQueue().toList();

        for (Object p : personList) {
            System.out.println(p.toString() + "\n");
        }

        System.out.println("_______________________________________________________\n");

        QuickSort.quickSort(personList, 0, personQueue.size() - 1, new AgeComparator());

        for (Object p : personList) {
            System.out.println(p.toString() + "\n");
        }

        System.out.println("_______________________________________________________\n");

        QuickSort.quickSort(personList, 0, personQueue.size() - 1, new LastNameComparator());

        for (Object p : personList) {
            System.out.println(p.toString() + "\n");
        }
    }
}