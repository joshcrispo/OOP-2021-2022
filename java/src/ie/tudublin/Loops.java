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
				break;
		}
	}
}
