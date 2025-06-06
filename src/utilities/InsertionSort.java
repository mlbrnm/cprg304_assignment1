package utilities;

import shapes.Shape;
import java.util.Comparator;

public class InsertionSort {

    // Sorts an array of Shapes using Insertion Sort.
    public static void sort(Shape[] shapes, Comparator<Shape> comparator) {
        if (shapes == null || shapes.length <= 1) {
            return;
        }

        int n = shapes.length;
        // Iterate from the second element.
        for (int i = 1; i < n; i++) {
            Shape key = shapes[i];
            int j = i - 1;
            // Taking j as the Key 

            // Move elements of shapes that are greater than key, to one position ahead of their current position.
            while (j >= 0 && comparator.compare(shapes[j], key) > 0) {
                shapes[j + 1] = shapes[j];
                j = j - 1;
            }

            // Place key in its correct sorted position.
            shapes[j + 1] = key;
        }
    }
}
