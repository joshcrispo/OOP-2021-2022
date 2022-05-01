package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{


	int mode = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	
	public void draw()
	{
		
		switch(mode)	
		{
			case 0:
				background(0);
				int bars = (int) (mouseX / 20.0f);
				float w = width / (float)bars;
				for(int i = 0 ; i < bars; i++)
				{
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
				break;
			case 1:
				background(0);
				beginShape();
				for(int i=0;i<360;i+=mouseX)
				{
					noFill();
					float sides1 = radians(i);
					float x = width/2;
					float y = height/2;
					float r = 150;

					float centerX = x + sin(sides1) * r;
					float centerY = y + cos(sides1) * r;
					stroke(255);
					line(x,y,centerX,centerY);
				}
				endShape();
				break;
		}
	}
}
