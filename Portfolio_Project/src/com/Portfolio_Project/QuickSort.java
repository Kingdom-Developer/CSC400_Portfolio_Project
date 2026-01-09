package com.Portfolio_Project;

import java.util.Comparator;
import java.util.List;

public class QuickSort {
    private static int partition(List<Person> list, int lowIndex, int highIndex,
                                 Comparator<Person> comp) {

        int midpoint = lowIndex + (highIndex - lowIndex) / 2;
        Person pivot = list.get(midpoint);

        boolean done = false;

        while (!done) {

            // Move lowIndex right while list[lowIndex] < pivot (according to comparator)
            while (comp.compare(list.get(lowIndex), pivot) < 0) {
                lowIndex++;
            }

            // Move highIndex left while pivot < list[highIndex]
            while (comp.compare(pivot, list.get(highIndex)) < 0) {
                highIndex--;
            }

            // If indices cross, partition is complete
            if (lowIndex >= highIndex) {
                done = true;
            } else {
                // Swap
                Person temp = list.get(lowIndex);
                list.set(lowIndex, list.get(highIndex));
                list.set(highIndex, temp);

                lowIndex++;
                highIndex--;
            }
        }

        return highIndex;
    }

    public static void quickSort(List<Person> list, int lowIndex, int highIndex,
                                 Comparator<Person> comp) {

        if (lowIndex >= highIndex) {
            return; // base case
        }

        int lowEndIndex = partition(list, lowIndex, highIndex, comp);

        quickSort(list, lowIndex, lowEndIndex, comp);
        quickSort(list, lowEndIndex + 1, highIndex, comp);
    }
}
