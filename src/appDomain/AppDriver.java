package appDomain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import shapes.*;

public class AppDriver
{

    public static void main( String[] args )
    {
        Shape[][] shapesArrays = loadShapesFromFiles();
        for (int i = 0; i < shapesArrays.length; i++) {
            System.out.println("Loaded " + shapesArrays[i].length + " shapes from file " + (i+1));
        }
    }

    public static Shape[][] loadShapesFromFiles() {
        File resFolder = new File("res");
        File[] files = resFolder.listFiles((dir, name) -> name.matches("shapes\\d+\\.txt"));
        if (files == null) {
            System.out.println("No shape files found in res folder.");
            return new Shape[0][0];
        }

        Shape[][] shapesArrays = new Shape[files.length][];
        for (int f = 0; f < files.length; f++) {
            File file = files[f];
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line == null) {
                    shapesArrays[f] = new Shape[0];
                    continue;
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

                    Shape shape = createShape(shapeType, height, param);
                    if (shape != null) {
                        shapes[i] = shape;
                    }
                }
                shapesArrays[f] = shapes;
            } catch (IOException e) {
                System.out.println("Error reading file: " + file.getName());
                e.printStackTrace();
                shapesArrays[f] = new Shape[0];
            }
        }

        return shapesArrays;
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
}
