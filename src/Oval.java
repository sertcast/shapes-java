import java.awt.*;

public class Oval implements Shapes {

    protected int x, y, centerX, centerY, w, h;

    public Oval(int centerX, int centerY, int w, int h) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.x = centerX - w / 2;
        this.y = centerY - h / 2;
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x, y, w, h);
    }

    @Override
    public void move(int xadd, int yadd) {
        this.x += xadd;
        this.y += yadd;
        this.centerX += xadd;
        this.centerY += yadd;
    }
}
