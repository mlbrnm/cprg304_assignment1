package shapes;

public class Cylinder extends Shape
{
    double radius;
    double calcVolume() {
        return Math.PI * radius * radius * height;
    }
    double calcBaseArea() {
        return Math.PI * radius * radius;
    }
    public Cylinder(double radius, double height) {
        super(height);
        this.radius = radius;
    }
}
