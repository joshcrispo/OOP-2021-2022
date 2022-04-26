package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
    float x, y;
    float w;
    float halfW;

    Player p, p1, p2;
    Health h;

    public void setup()
    {
        p = new Player(200, 200, 150, this);
        p1 = new Player(100,100, 50, this);
        p2 = new Player(400, 100, 50, this);
        h = new Health(100, this);
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

        p2.update();
        p2.render();
        
        h.update();
        h.render();
    }    
}
