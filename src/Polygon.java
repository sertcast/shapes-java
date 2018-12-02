
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polygon implements Shapes {
    protected List<Point> points;
    protected List<Double> lengths;
    protected int numLines;
    protected List<Double> angles;
    protected boolean addRestricted = false;

    public Polygon() {
        this(null);
    }

    public Polygon(int[] x, int[] y) {
        this();
        if (x == null || y == null) {
            return;
        }
        int len;
        if (x.length > y.length)
            len = y.length;
        else
            len = x.length;

        for (int i = 0; i < len; i++) {
            this.addPoint(x[i], y[i], false);
        }
        findLengths();
        findAngles();
    }

    public Polygon(List<Point> maPoints) {
        if (maPoints != null && maPoints.size() != 0) {
            this.points = maPoints;
            findLengths();

            if (this.points.size() == 2) {
                numLines = 1;
            } else {
                numLines = this.points.size();
            }

        } else {
            this.points = new ArrayList<Point>();
            this.lengths = new ArrayList<Double>();
            this.angles = new ArrayList<Double>();
            numLines = 0;
        }
    }

    @Override
    public void draw(Graphics g) {
        int numPoints = this.points.size();
        for (int i = 0; i < numPoints - 1; i++) {
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
        }
        g.drawLine(points.get(0).x, points.get(0).y, points.get(numPoints - 1).x, points.get(numPoints - 1).y);
    }

    @Override
    public void move(int xadd, int yadd) {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setLocation(points.get(i).x + xadd, points.get(i).y + yadd);
        }

    }


    public void addPoint(int x, int y) {
        addPoint(x, y, true);
    }

    public void addPoint(int x, int y, boolean reCalculateLength) {
        if (!addRestricted) {
            this.points.add(new Point(x, y));
            if (this.points.size() == 2) {
                numLines = 1;
            } else {
                numLines = this.points.size();
            }
            if (reCalculateLength) {
                findLengths();
                findAngles();
            }
        }
    }

    public void addPoint(Point point) {
        addPoint(point.x, point.y);
    }

    public void removePoint(Point point) {
        this.points.remove(point);
        if (this.points.size() == 2) {
            numLines = 1;
        } else {
            numLines = this.points.size();
        }
        findLengths();
        findAngles();
    }

    protected void findLengths() {
        this.lengths = new ArrayList<Double>();
        double length;
        for (int i = 0; i < this.points.size() - 1; i++) {
            length = findLength(this.points.get(i + 1), this.points.get(i));
            this.lengths.add(length);
        }
        length = findLength(this.points.get(this.points.size() - 1), this.points.get(0));
        this.lengths.add(length);

        if (this.points.size() == 2) {
            numLines = 1;
        } else {
            numLines = this.points.size();
        }
    }

    protected void findAngles() {
        double angle;
        this.angles = new ArrayList<Double>();

        for (int i = 0; i < points.size(); i++) {
            int next = i + 1;
            int prev = i - 1;
            if (prev < 0) prev = points.size() - 1;
            else if (next == points.size()) next = 0;

            double a = lengths.get(i);
            double b = lengths.get(prev);
            double oppLength = findLength(points.get(next), points.get(prev));
            angle = findAngle(a, b, oppLength);

            if (points.size() > 3) {
                int prev1 = (prev == 0) ? points.size() - 1 : prev - 1;
                int next1 = (next == points.size() - 1) ? 0 : next + 1;
                double sPrev = findSlope(points.get(i), points.get(prev));
                double sPrev1 = findSlope(points.get(prev), points.get(prev1));
                double sNext = findSlope(points.get(i), points.get(next));
                double sNext1 = findSlope(points.get(next), points.get(next1));

                boolean prevs = (sPrev > 0 && sPrev1 > 0 && sPrev < sPrev1) || (sPrev < 0 && sPrev1 < 0 && sPrev > sPrev1);
                boolean nexts = (sNext > 0 && sNext1 > 0 && sNext < sNext1) || (sNext < 0 && sNext1 < 0 && sNext > sNext1);
                if (prevs && nexts) {
                    angle = 360 - angle;
                }
            }
            angles.add(angle);
        }

    }

    private double findLength(Point a, Point b) {
        return Math.sqrt(Math.pow(a.y - b.y, 2) + Math.pow(a.x - b.x, 2));
    }


    private double findAngle(double a, double b, double c) {
        double angle = Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2);
        angle /= 2 * a * b;
        angle = Math.acos(angle);
        angle = Math.toDegrees(angle);
        angle = round(angle, 2);
        return angle;
    }

    protected double findSlope(Point a, Point b) {
        return ((double) (b.y - a.y)) / (b.x - a.x);
    }

    private double round(double num, int decplaces) {
        return Math.round(num * Math.pow(10, decplaces)) / Math.pow(10, decplaces);
    }

    public void printAngles() {
        for (Double angle : angles) {
            System.out.println(angle);
        }
        System.out.println();
    }

    public void printLengths() {
        for (Double length : lengths) {
            System.out.println(length);
        }
        System.out.println();
    }
}
