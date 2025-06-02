package shapes;

public class TriangularPrism extends Shape
{
    double side;
    double calcVolume() {
        return calcBaseArea() * height;
    }
    double calcBaseArea() {
        return (Math.sqrt(3) / 4) * side * side;
    }
    public TriangularPrism(double side, double height) {
        super(height);
        this.side = side;
    }
}
