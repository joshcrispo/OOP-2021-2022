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
        background(255,0,0);
        noStroke();
        fill(255,255,0);
        circle(250,250, 400);
        fill(0,255,255);
        triangle(250,25,50,400,450,400);
        fill(200,200,200);
        ellipse(250,200,175,100);
        fill(0,0,0);
        circle(250,200,75);
    }
}
