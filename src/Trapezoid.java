import java.awt.*;
import java.util.List;

public class Trapezoid extends Quadrilateral {
    public Trapezoid() throws InvalidShapeException {
        super();
    }

    public Trapezoid(List<Point> maPoints) throws InvalidShapeException {
        super(maPoints);
        if(angles.get(0) != 180-angles.get(1) && angles.get(1) != 180 - angles.get(2)){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }
    public Trapezoid(int[] x, int[] y) throws InvalidShapeException {
        super(x, y);
        if(angles.get(0) != 180-angles.get(1) && angles.get(1) != 180 - angles.get(2)){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }
    public Trapezoid(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) throws InvalidShapeException {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
        if (lengths.get(0) != lengths.get(2) || lengths.get(1) != lengths.get(3)) {
            throw new InvalidShapeException("Invalid shape info m8");
        }

    }
}
