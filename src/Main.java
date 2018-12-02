import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String args[]) throws InvalidShapeException {
        Polygon s= new Triangle(new int[]
                {100, 200, 180}, new int[]
                {100, 100, 120});
//        s = new Polygon();
//        s.addPoint(300, 300, false);
//        s.addPoint(550, 550, false);
//        s.addPoint(300, 400, false);
//        s.addPoint(50, 550, true);
        s.printAngles();

        JFrame frame = new JFrame("shapes bud");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new JPanel() {
            private Timer tm = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s.move(1,1);
                    repaint();
                }
            });
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                graphics.setColor(Color.BLACK);
                s.draw(graphics);
                tm.start();
            }
        });
        frame.setVisible(true);


    }
}
