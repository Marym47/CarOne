/*
 * Copyright (c) 2010-2016 William Bittle  http://www.dyn4j.org/
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted 
 * provided that the following conditions are met:
 * 
 *   * Redistributions of source code must retain the above copyright notice, this list of conditions 
 *     and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice, this list of conditions 
 *     and the following disclaimer in the documentation and/or other materials provided with the 
 *     distribution.
 *   * Neither the name of dyn4j nor the names of its contributors may be used to endorse or 
 *     promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND 
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.dyn4j.samples;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
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
        //create the ship for manipulation
        ship = new SimulationBody();
        ship.addFixture(Geometry.createRectangle(0.5, 1.5), 1, 0.2, 0.2);
        this.world.addBody(ship);

    }
    public static void main(String[] args)
    {
        //set up jframe display
        JFrame jf = new JFrame();
        jf.setTitle("Racing");
        jf.setSize(512,512);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thrust simulation = new Thrust();
        simulation.run();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public class Car {
        private int left;
        private int right;
        private int forward;


        public void left() {
                Vector2 f1 = r.product(force * 0.1).right();
                Vector2 f2 = r.product(force * 0.1).left();
                Vector2 p1 = c.sum(r.product(0.9));
                Vector2 p2 = c.sum(r.product(-0.9));
                ship.applyForce(f1, p1);
        }

        public void right() {
                    Vector2 f1 = r.product(force * 0.1).left();
                    Vector2 f2 = r.product(force * 0.1).right();
                    Vector2 p1 = c.sum(r.product(0.9));
                    Vector2 p2 = c.sum(r.product(-0.9));
                    ship.applyForce(f2, p2);
        }
                public void forward(){
                        Vector2 f = r.product(force);
                        Vector2 p = c.sum(r.product(-0.9));
                        ship.applyForce(f);

                    }

    }





}
