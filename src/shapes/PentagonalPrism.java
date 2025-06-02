package shapes;

public class PentagonalPrism extends Shape
{
    double side;

    double calcVolume() {
        return calcBaseArea() * height;
    }

    double calcBaseArea() {
        return (5.0 / 4.0) * side * side * (1.0 / Math.tan(Math.PI / 5.0));
    }
    
    public PentagonalPrism(double side, double height) {
        super(height);
        this.side = side;
    }
}
