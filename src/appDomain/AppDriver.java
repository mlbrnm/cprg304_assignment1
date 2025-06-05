package appDomain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import shapes.*;
import utilities.BubbleSort;
import utilities.InsertionSort;
import utilities.SelectionSort;
import utilities.MergeSort;
import utilities.QuickSort;
import utilities.OurSpecialFunSort;
import shapes.ComparatorBaseArea;
import shapes.ComparatorVolume;

public class AppDriver {

    public static void main(String[] args) {
        String sortField = "h";
        String fileName = "shapes1.txt";
        if(args.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter filename (default shapes1.txt): ");
            String input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                fileName = input;
            }
            System.out.print("Enter sort field (h/v/a, default h): ");
            input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                sortField = input;
            }
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-t") && i + 1 < args.length) {
                    sortField = args[i + 1];
                    i++;
                } else if (args[i].equals("-f") && i + 1 < args.length) {
                    fileName = args[i + 1];
                    i++;
                }
            }
        }


        Shape[] shapes = loadShapesFromFile(fileName);
        if (shapes == null) {
            System.out.println("No shapes loaded from file: " + fileName);
            return;
        }
        System.out.println("Loaded " + shapes.length + " shapes from file " + fileName);


        java.util.Comparator<Shape> comparator;
        if (sortField.equalsIgnoreCase("h")) {
            comparator = (s1, s2) -> s1.compareTo(s2);
        } else if (sortField.equalsIgnoreCase("v")) {
            comparator = new ComparatorVolume();
        } else if (sortField.equalsIgnoreCase("a")) {
            comparator = new ComparatorBaseArea();
        } else {
            System.out.println("Unknown sort field: " + sortField + ". Using height as default.");
            comparator = (s1, s2) -> s1.compareTo(s2);
        }

        // Sort with each algorithm and time the sort operations (sorting only the shape array)
        sortAndTime("BubbleSort", shapes, comparator, (arr, comp) -> BubbleSort.sort(arr, comp));
        //sortAndTime("InsertionSort", shapes, comparator, (arr, comp) -> InsertionSort.sort(arr, comp));
        sortAndTime("SelectionSort", shapes, comparator, (arr, comp) -> SelectionSort.sort(arr, comp));
        //sortAndTime("MergeSort", shapes, comparator, (arr, comp) -> MergeSort.sort(arr, comp));
        //sortAndTime("QuickSort", shapes, comparator, (arr, comp) -> QuickSort.sort(arr, comp));
        //sortAndTime("OurSpecialFunSort", shapes, comparator, (arr, comp) -> OurSpecialFunSort.sort(arr, comp));
    }

    public static Shape[] loadShapesFromFile(String fileName) {
        File file = new File("res" + File.separator + fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return null;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if (line == null) {
                return new Shape[0];
            }
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
            case "OctagonalPrism":
                return new OctagonalPrism(param, height);
            case "Pyramid":
                return new Pyramid(param, height);
            case "TriangularPrism":
                return new TriangularPrism(param, height);
            case "Cylinder":
                return new Cylinder(param, height);
            case "Cone":
                return new Cone(param, height);
            case "PentagonalPrism":
                return new PentagonalPrism(param, height);
            case "SquarePrism":
                return new SquarePrism(param, height);
            default:
                System.out.println("Unknown shape type: " + shapeType);
                return null;
        }
    }


    interface Sorter {
        void sort(Shape[] shapes, java.util.Comparator<Shape> comparator);
    }

    public static void sortAndTime(String sortName, Shape[] original, java.util.Comparator<Shape> comparator, Sorter sorter) {
        // Create a copy of the original array for sorting
        Shape[] copy = Arrays.copyOf(original, original.length);
        long startTime = System.nanoTime();
        sorter.sort(copy, comparator);
        long endTime = System.nanoTime();
        System.out.println(sortName + " run time was " + ((endTime - startTime) / 1000000) + " milliseconds.");
        //print the first, 1000th, and last elements of the sorted array
        printSortedShapes(copy);
    }
    
    // This method prints the first, 1000th, and last elements of the sorted shapes array
    public static void printSortedShapes(Shape[] shapes)
    {
        if (shapes == null || shapes.length == 0) {
            System.out.println("No shapes to display.");
            return;
        }
        //First element
        System.out.println("First element is: " + shapes[0].getClass().getName() + "    Height: " + shapes[0].getHeight());
        //1000th element
        for (int i = 1000; i <= shapes.length; i += 1000)
        {
            System.out.println(i + "-th element is: " + shapes[i-1].getClass().getName() + "    Height: " + shapes[i-1].getHeight());
        }
        //Last element
        System.out.println("Last element is: " + shapes[shapes.length - 1].getClass().getName() + "    Height: " + shapes[shapes.length - 1].getHeight());
    }
}
