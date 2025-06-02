package shapes;

public abstract class Shape implements Comparable<Shape>{
    double height;
    double calcVolume() {
        return 0.0;
    }

    double calcBaseArea() {
        return 0.0;
    }

    @Override
    public int compareTo(Shape other) {
        if (this.height > other.height) {
            return -1;
        } else if (this.height < other.height) {
            return 1;
        } else {
            return 0;
        }
    }


    public int compareBaseArea(Shape other) {
        if (this.calcBaseArea() > other.calcBaseArea()) {
            return -1;
        } else if (this.calcBaseArea() < other.calcBaseArea()) {
            return 1;
        } else {
            return 0;
        }
    }


    public int compareVolume(Shape other) {
        if (this.calcVolume() > other.calcVolume()) {
            return -1;
        } else if (this.calcVolume() < other.calcVolume()) {
            return 1;
        } else {
            return 0;
        }
    }

    public Shape(double height) {
        this.height = height;
    }
}
