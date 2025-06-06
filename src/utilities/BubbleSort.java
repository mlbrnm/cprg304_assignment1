package utilities;

import shapes.Shape;
import java.util.Comparator;

public class BubbleSort {

    // Sorts an array of Shapes using Bubble Sort.
    public static void sort(Shape[] shapes, Comparator<Shape> comparator) {
        if (shapes == null || shapes.length <= 1) {
            return;
        }

        int n = shapes.length;
        boolean swapped;

        // Outer loop for passes.
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparisons and swaps.
            for (int j = 0; j < n - 1 - i; j++) {

                // Comparing shapes swaping positions if necessary
                if (comparator.compare(shapes[j], shapes[j + 1]) > 0) {
                    Shape temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, then the array is sorted
            if (!swapped) {
                break;
            }
        }
    }
}
