package shapes;

public class Pyramid extends Shape
{
    double side;

    double calcVolume() {
        return (1.0 / 3.0) * calcBaseArea() * height;
    }

    double calcBaseArea() {
        return side * side;
    }
    
    public Pyramid(double side, double height) {
        super(height);
        this.side = side;
    }
}
