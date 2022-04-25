package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
    float x, y;
    float w;
    float halfW;

    void drawPlayer(float x, float y, float w)
    {
        stroke(255);
        line(x-halfW, y + halfW, x, y - halfW);
        line(x, y - halfW, x + halfW, y + halfW);
        line(x + halfW, y + halfW, x, y);
        line(x, y, x - halfW, y + halfW);
    }

    Player p;
    Player p1;
    Health h;


    public void setup()
    {
        x = width / 2;
        y = height / 2;
        w = 100;
        halfW =  w/ 2.0f;
        p = new Player(250, 250, 50, this);
        p1 = new Player(50, 50, 100, this);
        h = new Health(50, this);
    }

    public void settings()
    {
        size(500,500);
    }

    public void draw()
    {
        background(0);
        p.update();        
        p.render();
        
        p1.update();
        p1.render();

        h.update();
        h.render();
    }    
}
