package appDomain;

import java.io.*;
import java.util.*;
import shapes.*;
import utilities.*;

import shapes.ComparatorBaseArea;
import shapes.ComparatorVolume;

public class AppDriver {

    public static void main(String[] args) {
        String sortField = "h"; // h = height, v = volume, a = base area
        String fileName = "shapes1.txt";
        String sortAlgo = "b"; // default: bubble sort

        // ✅ Read from command-line arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-f")) {
                fileName = args[i].substring(2); // -fshapes1.txt
            } else if (args[i].startsWith("-t")) {
                sortField = args[i].substring(2); // -tv / -th / -ta
            } else if (args[i].startsWith("-s")) {
                sortAlgo = args[i].substring(2); // -sz / -sb etc.
            }
        }

        Shape[] shapes = loadShapesFromFile(fileName);
        if (shapes == null || shapes.length == 0) {
            System.out.println("No shapes loaded from file: " + fileName);
            return;
        }

        System.out.println("Loaded " + shapes.length + " shapes from file " + fileName);

        Comparator<Shape> comparator;

        switch (sortField.toLowerCase()) {
            case "v":
                comparator = new ComparatorVolume();
                break;
            case "a":
                comparator = new ComparatorBaseArea();
                break;
            default:
                comparator = Comparator.naturalOrder(); // uses compareTo() for height
        }

        // ✅ Only call the algorithm selected with -s
        switch (sortAlgo.toLowerCase()) {
            case "b":
                sortAndTime("BubbleSort", shapes, comparator, BubbleSort::sort, sortField);
                break;
            case "s":
                sortAndTime("SelectionSort", shapes, comparator, SelectionSort::sort, sortField);
                break;
            case "i":
                sortAndTime("InsertionSort", shapes, comparator, InsertionSort::sort, sortField);
                break;
            case "m":
                sortAndTime("MergeSort", shapes, comparator, MergeSort::sort, sortField);
                break;
            case "q":
                sortAndTime("QuickSort", shapes, comparator, QuickSort::sort, sortField);
                break;
            case "z":
                sortAndTime("OurSpecialFunSort (HeapSort)", shapes, comparator, OurSpecialFunSort::sort, sortField);
                break;
            default:
                System.out.println("Invalid sort type: " + sortAlgo + ". Defaulting to BubbleSort.");
                sortAndTime("BubbleSort", shapes, comparator, BubbleSort::sort, sortField);
        }
    }

    public static Shape[] loadShapesFromFile(String fileName) {
        File file = new File("res" + File.separator + fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if (line == null) return new Shape[0];

            int numShapes = Integer.parseInt(line.trim());
            Shape[] shapes = new Shape[numShapes];

            for (int i = 0; i < numShapes; i++) {
                line = br.readLine();
                if (line == null) break;

                String[] parts = line.split("\\s+");
                if (parts.length != 3) continue;

                String shapeType = parts[0];
                double height = Double.parseDouble(parts[1]);
                double param = Double.parseDouble(parts[2]);

                shapes[i] = createShape(shapeType, height, param);
            }

            return shapes;
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
            return null;
        }
    }

    private static Shape createShape(String shapeType, double height, double param) {
        switch (shapeType) {
            case "OctagonalPrism": return new OctagonalPrism(param, height);
            case "Pyramid": return new Pyramid(param, height);
            case "TriangularPrism": return new TriangularPrism(param, height);
            case "Cylinder": return new Cylinder(param, height);
            case "Cone": return new Cone(param, height);
            case "PentagonalPrism": return new PentagonalPrism(param, height);
            case "SquarePrism": return new SquarePrism(param, height);
            default:
                System.out.println("Unknown shape type: " + shapeType);
                return null;
        }
    }

    interface Sorter {
        void sort(Shape[] shapes, Comparator<Shape> comparator);
    }

    public static void sortAndTime(String sortName, Shape[] original, Comparator<Shape> comparator,
                                   Sorter sorter, String sortField) {
        Shape[] copy = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        sorter.sort(copy, comparator);
        long end = System.nanoTime();
        printSortedShapes(copy, sortField);
        System.out.println(sortName + " runtime: " + ((end - start) / 1_000_000) + " ms");
    }

    public static void printSortedShapes(Shape[] shapes, String sortField) {
        if (shapes.length == 0) {
            System.out.println("No shapes to display.");
            return;
        }

        String label = getPropertyName(sortField);
        System.out.printf("First element: %-20s %s: %.3f%n", shapes[0].getClass().getSimpleName(), label, getValue(shapes[0], sortField));

        for (int i = 1000; i <= shapes.length; i += 1000) {
            System.out.printf("%d-th element: %-20s %s: %.3f%n", i, shapes[i - 1].getClass().getSimpleName(), label, getValue(shapes[i - 1], sortField));
        }

        System.out.printf("Last element: %-20s %s: %.3f%n", shapes[shapes.length - 1].getClass().getSimpleName(), label, getValue(shapes[shapes.length - 1], sortField));
    }

    private static String getPropertyName(String sortField) {
        switch (sortField.toLowerCase()) {
            case "v": return "Volume";
            case "a": return "Base Area";
            default: return "Height";
        }
    }

    private static double getValue(Shape shape, String sortField) {
        switch (sortField.toLowerCase()) {
            case "v": return shape.getVolume();
            case "a": return shape.getBaseArea();
            default: return shape.getHeight();
        }
    }
}
