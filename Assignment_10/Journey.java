import java.util.Collections;
import java.util.Set;

public class Journey {
    private Set<Integer> xCoords;
    private Set<Integer> yCoords;

    public int calculatePrice() {
        int maxX = Collections.max(xCoords);
        int maxY = Collections.max(yCoords);
        int minX = Collections.min(xCoords);
        int minY = Collections.min(yCoords);
        int result = 12 + (maxX - minX + maxY - minY) * 3;
        if (result<12) {
            return 12;
        }
        return result < 50 ? result : 50;
    }
}
