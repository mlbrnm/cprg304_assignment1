package utilities;

import shapes.Shape;
import java.util.Comparator;

public class SelectionSort {

    public static void sort(Shape[] shapes, Comparator<Shape> comparator) {
        if (shapes == null || shapes.length <= 1) {
            return;
        }

        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) //OUTER LOOP - passes
        {
            int minIndex = i; //Assume the first element is the minimum
            for (int j = i + 1; j < n; j++) //INNER LOOP - comparisons
            {
             if (comparator.compare(shapes[j], shapes[minIndex]) < 0) 
                {
                    minIndex = j; //Update the index of the minimum element
                }
            }
            //SWAP the found minimum element with first element
            Shape temp = shapes[minIndex];
            shapes[minIndex] = shapes[i];
            shapes[i] = temp;

        }

    }
}