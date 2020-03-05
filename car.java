package org.dyn4j.samples;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.dyn4j.dynamics.World;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Capsule;
import org.dyn4j.geometry.Circle;
import org.dyn4j.geometry.Convex;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Polygon;
import org.dyn4j.geometry.Rectangle;
import org.dyn4j.geometry.Slice;
import org.dyn4j.geometry.Triangle;
import org.dyn4j.geometry.Vector2;


public class car extends JPanel implements ActionListener {

    Timer tm = new Timer(5, this);
    int x = 125, velX = 1;
    int y = 150, velY = 1;
    static int sum = 0, sum2 = 0, sum3 = 0, sum4 = 0;
    //set up map
    File file = new File("res/images/test_v2.png");
    BufferedImage image;

    {
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g)
        {
            //set up map
        super.paintComponent(g);
        ImageIcon i = new ImageIcon("res/images/test_v2.png");
        i.paintIcon(this, g, 0, 0);

        g.setColor(Color.BLUE);
        g.fillRect(x,y, 10,10);

        tm.start();
        }

    public thrust() {
        //set thrust of the car
        super("Thrust", 40);
    }
    protected void initializeWorld() {
        //create the world
            this.world.setGravity(World.ZERO_GRAVITY);
            //create square body
        Body square = new SimulationBody();
        square.addFixture(Geometry.createSquare(1.0));
        square.translate(new Vector2(1.5, 2.0));
        square.setMass(MassType.INFINITE);
        this.world.addBody(square);

    }
    public static void main(String[] args)
    {
        //set up jframe display
        JFrame jf = new JFrame();
        jf.setTitle("Racing");
        jf.setSize(512,512);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println(sum);
        Car myCar = new Car();
        myCar.up();
        myCar.down();
        myCar.left();
        myCar.right();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public class Car {
        private int left;
        private int right;


        public void left(int left) {
            this.left= left;
            System.out.println("left");
            return left;
        }

        public void right(int right) {
            this.right= right;
            System.out.println("right");
            return right;
        }

    }
//Car:
//drive(power)
//Power: drive power
//turn(heading)
//Heading: target heading
//checkColor(distance)
//Distance: distance to target pixel
//Return: pixel value


}
