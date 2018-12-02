import java.awt.*;
import java.util.List;

public class Triangle extends Polygon {

    private String type;

    public Triangle() throws InvalidShapeException {
        throw new InvalidShapeException("Invalid shape info m8");
    }

    public Triangle(List<Point> maPoints) throws InvalidShapeException {
        super(maPoints);
        if (this.points.size() != 3) {
            throw new InvalidShapeException("Invalid shape info m8");
        }
        this.addRestricted = true;
        findLengths();
        findAngles();

        if(lengths.get(0) == lengths.get(1) && lengths.get(0) == lengths.get(1)){
            this.type = "isosceles";
            if(lengths.get(0) == lengths.get(2)){
                this.type = "equilateral";
            }
        }else{
            this.type = "scalene";
        }
    }

    public Triangle(int[] x, int[] y) throws InvalidShapeException {
        super(x, y);
        if (this.points.size() != 3) {
            throw new InvalidShapeException("Invalid shape info m8");
        }
        this.addRestricted = true;
        findLengths();
        findAngles();
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        super();
        this.points.add(new Point(x1, y1));
        this.points.add(new Point(x2, y2));
        this.points.add(new Point(x3, y3));
        this.addRestricted = true;

        findLengths();
        findAngles();
    }
}
