import java.awt.*;
import java.util.List;

public class Rhombus extends Parallelogram {

    public Rhombus() throws InvalidShapeException {
        super();
    }

    public Rhombus(List<Point> maPoints) throws InvalidShapeException {
        super(maPoints);
        if(lengths.get(0) != lengths.get(1)){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }

    public Rhombus(int[] x, int[] y) throws InvalidShapeException {
        super(x, y);
        if(lengths.get(0) != lengths.get(1)){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }

    public Rhombus(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) throws InvalidShapeException {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
        if(lengths.get(0) != lengths.get(1)){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }
}
