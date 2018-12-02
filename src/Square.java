import java.awt.*;
import java.util.List;

public class Square extends Rectangle {
    public Square() throws InvalidShapeException {
        super();

    }

    public Square(List<Point> maPoints) throws InvalidShapeException {
        super(maPoints);
        if(lengths.get(0).doubleValue() != lengths.get(1).doubleValue()){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }

    public Square(int[] x, int[] y) throws InvalidShapeException {
        super(x, y);
        if(lengths.get(0).doubleValue() != lengths.get(1).doubleValue()){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }

    public Square(int x, int y, int size) throws InvalidShapeException {
        super(x, y, size, size);
        if(lengths.get(0).doubleValue() != lengths.get(1).doubleValue()){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }
    public Square(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)throws InvalidShapeException {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
        if(lengths.get(0).doubleValue() != lengths.get(1).doubleValue()){
            throw new InvalidShapeException("Invalid shape info m8");
        }
    }
}
