package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{

	float rectX, rectY = 250;

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
				int bars = (int) mouseX/50; //change variable width to mouseX if you want to make it interactive
				float w = width / (float) bars; 
				for (int i = 0; i<bars; i++)
				{
					noStroke();
					float x = map(i,0,bars,0,width);
					float c = map(i, 0, bars, 0, 255);
					fill (c, 255, 255);
					rect(x,width, w, -width);
				}
				break;
			case 1:
				background(0);
				int squares = (int) width/50; 
				float w1 = width/ (float)squares;
				for( int i = 0; i < squares; i++)
				{
					noStroke();
					float x = map(i, 0, squares, 0, width);
					float c = map(i, 0, squares, 0, 255);
					fill (c, 255,255);
					rect(x,x, w1, w1);
					rect((width-w1) - x,x, w1, w1);
				}
				break;
			case 2:
				background(0);
				int circles = (int) width/50;
				float dia = width/ (float)circles;
				for(int i = 0;i < circles; i++)
				{
					noStroke();
					float x = map(i,0,circles,0,width);
					float c = map(i,0,circles,0,255);
					ellipse(width/2, width/2, width-x, width-x);
					colorMode(HSB);
					fill(c,255,255);
				}
				break;
			case 3:
				background(0);
				int circles1 = (int) width/50;
				for(int i = 0; i<circles1;i++)
				{
					for(int j = 0; j<circles1;j++)
					{
						noStroke();
						float x = map(j,0,circles1,0,width);
						float h = map(i,0,circles1,0,width);
						ellipse(x+(50/2), h+(50/2), 50, 50);
						float c = map(i,0,circles1,0,255);
						colorMode(HSB);
						fill(c,255,255);
					}
				}
				break;
			case 4:
				background(0);
				int squares1 = (int) width/50;
				float w2 = width/(float)squares1;
				String xaxis[]= {"-5", "-4", "-3", "-2", "-1", "0", "1", "2", "3", "4", "5"};
				int yaxis= -5;
				colorMode(RGB);

				for(int i = 0; i < squares1; i++)
				{
					for(int j = 0; j<squares1; j++)
					{
						float x = map(j,0,squares1,0,width);
						float h = map(i,0,squares1,0,width);
						rectMode(CENTER);
						rect((x+25), (h+25), w2, w2);
						stroke(255);

						
						
					}
					//textAlign(alignX);
				}
				for(int i = 0;i<squares1;i++)
				{
					float x = map(i,0,squares1,0,width);
					textAlign(CENTER, CENTER);
					fill(255,0,0);
					text(xaxis[i], x, w2/2);
				}
				fill(0,0,0);

		}	
	}
}
