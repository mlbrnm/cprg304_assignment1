package shapes;

import java.util.Comparator;

public class ComparatorBaseArea implements Comparator<Shape>{
    public int compare(Shape s1, Shape s2) {
        double area1 = s1.calcBaseArea();
        double area2 = s2.calcBaseArea();
        
        if (area1 > area2) {
            return -1;
        } else if (area1 < area2) {
            return 1;
        } else {
            return 0;
        }
    }
}
