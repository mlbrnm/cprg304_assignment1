package utilities;

import shapes.Shape;
import java.util.Comparator;

public class QuickSort {
    public static void sort(Shape[] shapes, Comparator<Shape> comparator) {
        if (shapes == null || shapes.length < 2) {
            return;
        }
        // quick sort algorithm

        quickSort(shapes, 0, shapes.length - 1, comparator);
    }

    // recursive quick sort function
    private static void quickSort(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
        if (low < high) {
            int pivotIndex = partition(shapes, low, high, comparator);

            // recursively sort elements before and after partition
            quickSort(shapes, low, pivotIndex - 1, comparator);
            quickSort(shapes, pivotIndex + 1, high, comparator);
        }
    }

    // partitions the array and returns the index of the pivot
    private static int partition(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
        Shape pivot = shapes[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // compare current element with pivot using comparator
            if (comparator.compare(shapes[j], pivot) <= 0) {
                i++;

                // swap shapes[i] and shapes[j]
                Shape temp = shapes[i];
                shapes[i] = shapes[j];
                shapes[j] = temp;
            }
        }

        // swap shapes[i+1] and shapes[high] (pivot)
        Shape temp = shapes[i + 1];
        shapes[i + 1] = shapes[high];
        shapes[high] = temp;

        return i + 1;
    }
}
