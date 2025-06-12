package utilities;

import shapes.Shape;
import java.util.Comparator;

public class OurSpecialFunSort {

    public static void sort(Shape[] shapes, Comparator<Shape> comparator) {
        if (shapes == null || shapes.length <= 1) {
            return;
        }

        int n = shapes.length;

        // Step 1: Build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(shapes, n, i, comparator);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap first (largest) with last
            Shape temp = shapes[0];
            shapes[0] = shapes[i];
            shapes[i] = temp;

            // Re-heapify the reduced heap
            heapify(shapes, i, 0, comparator);
        }
    }

    // Helper function to maintain max-heap property
    private static void heapify(Shape[] shapes, int size, int i, Comparator<Shape> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is larger
        if (left < size && comparator.compare(shapes[left], shapes[largest]) > 0) {
            largest = left;
        }

        // Check if right child is larger
        if (right < size && comparator.compare(shapes[right], shapes[largest]) > 0) {
            largest = right;
        }

        // If the largest is not the current root
        if (largest != i) {
            Shape swap = shapes[i];
            shapes[i] = shapes[largest];
            shapes[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(shapes, size, largest, comparator);
        }
    }
}
