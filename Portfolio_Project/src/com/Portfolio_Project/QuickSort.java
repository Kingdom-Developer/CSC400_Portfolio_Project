package com.Portfolio_Project;

import java.util.Comparator;
import java.util.List;

/**
 * Provides methods to sort a list of generic type using the Quick Sort algorithm
 * <p>Uses a divide-and-conquer approach by selecting a pivot value at the midpoint
 * and swapping out-of-place elements based on their comparison to the pivot</p>
 */
public class QuickSort {

    /**
     *
     * @param list input List of generic data type
     * @param low the start index of the input List
     * @param high the ending index of the input List
     * @param comp the comparator used to compare elements
     * @return the last index of the right subset
     * @param <T> the type of element in the list
     * @throws IllegalArgumentException if list is null or empty
     */
    private static <T> int partition(List<T> list, int low, int high, Comparator<T> comp) {
        // Check if the list is null
        if (list == null) {
            throw new IllegalArgumentException("The list cannot be null.");
        }

        // Check if list is empty
        if (list.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be empty.");
        }

        // Find middle of the list
        int mid = low + (high - low) / 2;
        // Set pivot value as the midpoint
        T pivot = list.get(mid);

        boolean done = false;

        while (!done) {
            // Move low index up until item that is greater than or equal to pivot values is found
            while (comp.compare(list.get(low), pivot) < 0) {
                low++;
            }

            // Move high index down until item that is less than or equal to pivot values is found
            while (comp.compare(pivot, list.get(high)) < 0) {
                high--;
            }

            // If indices cross, partition is complete
            if (low >= high) {
                done = true;
            }
            else {
                // Swap items that are out of place
                T temp = list.get(low);
                list.set(low, list.get(high));
                list.set(high, temp);

                low++;
                high--;
            }
        }
        return high;
    }

    /**
     * Recursive method that sorts using the Quick sort algorithm
     * @param list input List of generic data type
     * @param low the start index of the input List
     * @param high the ending index of the input List
     * @param comp the comparator used to compare elements
     * @param <T> the type of element in the list
     */
    public static <T> void quickSort(List<T> list, int low, int high, Comparator<T> comp) {
        // Check for base case
        if (low >= high) {
            return;
        }

        // Continue to partition
        int lowEndIndex = partition(list, low, high, comp);

        // Sort each subarray
        quickSort(list, low, lowEndIndex, comp);
        quickSort(list, lowEndIndex + 1, high, comp);
    }
}