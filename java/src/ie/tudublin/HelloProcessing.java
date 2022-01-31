package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

    public void settings()
    {
        size(500, 500);
    }

    public void setup() {
        // colorMode(HSB);
        background(0);
    }
    
    public void draw()
    {
        noStroke();
        background(255, 0, 0); // Greyscale
        fill(255,255,51);
        circle(250, 250, 400); // cx, cy, r
        fill(0, 255, 255);
        triangle(50,400,450, 400, 250, 25); //x1 y1, x2, y2,
        fill(192, 192, 192);
        ellipse(250, 225, 200, 90); //cx, cy, w, h
        fill(0,0,0);
        circle(250, 225, 60); // cx, cy, r
        

        stroke(0);

        point(20, 30);

    }
}
