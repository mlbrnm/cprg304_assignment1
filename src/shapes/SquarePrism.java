package shapes;

public class SquarePrism extends Shape
{
    double height;
    double side;
    double calcVolume() {
        return calcBaseArea() * height;
    }
    double calcBaseArea() {
        return side * side;
    }
}
