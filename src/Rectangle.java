import java.awt.*;
import java.util.List;

public class Rectangle extends Parallelogram {
    public Rectangle() throws InvalidShapeException {
        super();
    }

    public Rectangle(List<Point> maPoints) throws InvalidShapeException {
        super(maPoints);
        if (angles.get(0).doubleValue() != 90) {
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }

    public Rectangle(int[] x, int[] y) throws InvalidShapeException {
        super(x, y);
        if (angles.get(0).doubleValue() != 90) {
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }

    public Rectangle(int x, int y, int w, int h) throws InvalidShapeException {
        super(new int[]{x, x + w, x + w, x}, new int[]{y, y, y + h, y + h});
    }

    public Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)throws InvalidShapeException {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
        if (angles.get(0).doubleValue() != 90) {
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }
}
