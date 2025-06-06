package utilities;

import shapes.Shape;
import java.util.Comparator;

public class MergeSort {

    // Sorts an array of Shapes using Merge Sort.
    public static void sort(Shape[] shapes, Comparator<Shape> comparator) {
        if (shapes == null || shapes.length <= 1) {
            return;
        }
        mergeSort(shapes, new Shape[shapes.length], 0, shapes.length - 1, comparator);
    }

    private static void mergeSort(Shape[] array, Shape[] temp, int left, int right, Comparator<Shape> comparator) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Sorting the left half
        mergeSort(array, temp, left, mid, comparator);
        // Sorting the right half
        mergeSort(array, temp, mid + 1, right, comparator);
        // Merging the sorted halves
        merge(array, temp, left, mid, right, comparator);
    }

    private static void merge(Shape[] array, Shape[] temp, int left, int mid, int right, Comparator<Shape> comparator) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        // Using temp to merge back to original array
        while (i <= mid && j <= right) {
            if (comparator.compare(temp[i], temp[j]) <= 0) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy remaining left elements
        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }
    }
}
