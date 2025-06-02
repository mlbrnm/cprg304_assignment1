package shapes;

import java.util.Comparator;

public class ComparatorVolume implements Comparator<Shape>{
    public int compare(Shape s1, Shape s2) {
        double volume1 = s1.calcVolume();
        double volume2 = s2.calcVolume();
        
        if (volume1 > volume2) {
            return -1;
        } else if (volume1 < volume2) {
            return 1;
        } else {
            return 0;
        }
    }
}
