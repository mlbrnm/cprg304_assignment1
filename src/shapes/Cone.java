package shapes;

public class Cone extends Shape
{
    double radius;

    double calcVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    double calcBaseArea() {
        return Math.PI * radius * radius;
    }
    
    public Cone(double radius, double height) {
        super(height);
        this.radius = radius;
    }
}
