package shapes;

public class TriangularPrism extends Shape
{
    double height;
    double side;
    double calcVolume() {
        return calcBaseArea() * height;
    }
    double calcBaseArea() {
        return (Math.sqrt(3) / 4) * side * side;
    }
}
