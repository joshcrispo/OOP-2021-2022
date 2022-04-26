package ie.tudublin;

public class Player 
{
    float x, y;
    float w; 
    float fx, fy;
    float halfW;

    YASC yasc;
    float rotation;

    public Player(float x, float y, float w, YASC yasc)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        halfW = w / 2.0f;
        this.yasc = yasc;
        float rotation = 0;
    }

    void render()
    {
        yasc.pushMatrix(); //Push matrix removes parent translating
        yasc.translate(x,y); //Translate transform and centers the screen 
        yasc.rotate(rotation); // Built-in library command allows rotation
        yasc.stroke(255);
        yasc.line(-halfW, halfW, 0, -halfW);
        yasc.line(halfW, halfW, 0, -halfW);
        yasc.line(0,0, -halfW, halfW);
        yasc.line(0,0, halfW, halfW);
        yasc.popMatrix(); //Pops normal translating
    }

    public void update()
    {
        if (yasc.keyPressed)
        {
            if (yasc.key == 'w')
            {
                x += fx;
                y += fy;
            }
            if (yasc.key == 's')
            {
                x -=fx;
                y -=fy;
            }
            if (yasc.key == 'a')
            {
                rotation -= 0.01f;
            }
            if (yasc.key == 'd')
            {
                rotation += 0.01f;
            }
        }
        fx = YASC.sin(rotation);
        fy = - YASC.cos(rotation);

    }
    
}

