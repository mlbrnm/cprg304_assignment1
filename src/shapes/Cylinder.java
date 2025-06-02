package shapes;

public class Cylinder extends Shape
{
    double height;
    double radius;
    double calcVolume() {
        return Math.PI * radius * radius * height;
    }
    double calcBaseArea() {
        return Math.PI * radius * radius;
    }
}
