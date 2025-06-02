package shapes;

public class SquarePrism extends Shape
{
    double side;
    double calcVolume() {
        return calcBaseArea() * height;
    }
    double calcBaseArea() {
        return side * side;
    }
    public SquarePrism(double side, double height) {
        super(height);
        this.side = side;
    }
}
