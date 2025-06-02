package shapes;

public class OctagonalPrism extends Shape
{
    double side;
    double calcVolume() {
        return calcBaseArea() * height;
    }
    double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }
    public OctagonalPrism(double side, double height) {
        super(height);
        this.side = side;
    }
}
