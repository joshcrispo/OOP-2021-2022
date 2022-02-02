package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet{

    public void settings()
	{
        size(500, 500);
	}

	public void setup() 
    {
        colorMode(RGB);
		background(0);
        
        playerX = 250;
        playerY = 450;
        playerWidth = 50;
        bugX = 250;
        bugY = 450;
        bugWidth = 50;
	}

    float playerX, playerY, playerWidth;
    float bugX, bugY, bugWidth;

    public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
            if (playerX == 30)
            {
            }
            else
            {
                playerX -= 10;
            }

		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
            if (playerX == 470)
            {

            }
            else
            {
            playerX += 10;
            }
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
            drawLaser(playerX, playerY);
		}
	}	

    public void drawLaser(float x, float y)
    {
        line(x, 0, x, y-50);
        line(x+100, 0, x, y-50);
        line(x-100, 0, x, y-50);
    }

    public void drawPlayer(float x, float y, float w)
    {
        stroke(255,0,0);
        fill(0,0,0);
        circle(x,y,50);
        line(x, y-25, x, y-50);
        line(x-26, y-6, x, y-50);
        line(x+26, y-6, x, y-50);
    }

    public void drawBug(float x, float y, float w)
    {
        stroke(255,0,0);
        fill(0,0,0);
        ellipse(x, y-400, w-20, w-5);
        line(x, y-378, x-10, y-370);
        line(x, y-378, x+10, y-370);
        line(x, y-378, x, y-422);
        
    }

	public void draw()
	{	
        background(0);
        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugY, bugWidth);
	}
    
}
