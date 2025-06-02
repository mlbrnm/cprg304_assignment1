package shapes;

public class Pyramid extends Shape
{
    double height;
    double side;
    double calcVolume() {
        return (1.0 / 3.0) * calcBaseArea() * height;
    }
    double calcBaseArea() {
        return side * side;
    }
}
