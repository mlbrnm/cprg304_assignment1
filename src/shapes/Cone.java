package shapes;

public class Cone extends Shape
{
    double height;
    double radius;
    double calcVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }
    double calcBaseArea() {
        return Math.PI * radius * radius;
    }
}
