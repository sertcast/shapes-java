import java.awt.*;
import java.util.List;

public class Quadrilateral extends Polygon {

    public Quadrilateral() throws InvalidShapeException {
        throw new InvalidShapeException("Invalid shape info m8");
    }

    public Quadrilateral(List<Point> maPoints) throws InvalidShapeException {
        super(maPoints);
        if (this.points.size() != 4) {
            throw new InvalidShapeException("Invalid shape info m8");
        }
        this.addRestricted = true;
        findLengths();
        findAngles();

    }

    public Quadrilateral(int[] x, int[] y) throws InvalidShapeException {
        super(x, y);
        if (this.points.size() != 4) {
            throw new InvalidShapeException("Invalid shape info m8");
        }
        this.addRestricted = true;
        findLengths();
        findAngles();
    }

    public Quadrilateral(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        super();
        this.points.add(new Point(x1, y1));
        this.points.add(new Point(x2, y2));
        this.points.add(new Point(x3, y3));
        this.points.add(new Point(x4, y4));
        this.addRestricted = true;

        findLengths();
        findAngles();
    }

}
