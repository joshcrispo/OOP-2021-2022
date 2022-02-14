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
		colorMode(RGB);
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
		int rectHue;
		int circleW;
		int circleH;

		switch(mode)	
		{
			case 0:
				if (mouseX >= rectX + 50)
				{
					rectX += 50;
				}
				else if (mouseX <= rectX - 50)
				{
					rectX -= 50;
				}	
				background(0);
				rectMode(CENTER);
				rect(rectX, rectY, 150, 500);
				fill(93, 173, 226);
				noStroke();
				break;
			case 1:
				if (mouseY >= rectY + 50)
				{
					rectY += 50;
					rectX += 50;
				}
				else if(mouseY <= rectY -50)
				{
					rectY -= 50;
				}

				background(0);
				rectMode(CENTER);
				rect(mouseX, rectY, 150, 150);
				fill(93, 173, 226);
				noStroke();
				break;
			case 2:
				if (mouseX <= 150 || mouseX >=350 || mouseY <= 175 || mouseY > 325)
				{
					background(0);
					rectMode(CENTER);
					rect(250, 250, 200, 150);
					fill(93, 173, 226);
				}
				else
				{
					background(0);
					rectMode(CENTER);
					rect(250, 250, 200, 150);
					fill(192, 57, 43);
				}
				break;
			case 3:
					background(0);
					
					colorMode(HSB);
					rectHue = 0;

					for(rectX=-50;rectX<500;rectX+=50)
					{
						fill(rectHue,255,255);
						rectHue += 18;
						rectMode(CENTER);
						rect(rectX+25, 250, 50, 500);
					}
					break;
			case 4:
					background(0);
					colorMode(HSB);
					rectX = 25;
					rectY = 25;
					rectHue = 0;
					while (rectX<500 && rectY<500)
					{
						fill(rectHue,255,255);
						rectMode(CENTER);
						rect(rectX, rectY, 50, 50);
						rectX += 50;
						rectY += 50;
						rectHue += 25;
					}
					break;
			case 5:
				background(0);
				colorMode(HSB);
				rectX = 25;
				rectY = 25;
				float rectX2 = 475;
				float rectY2 = 25;
				rectHue = 0;
				while (rectX<500 && rectY<500 && rectX2>0)
				{
					fill(rectHue,255,255);
					rectMode(CENTER);
					rect(rectX, rectY, 50, 50);
					rectX += 50;
					rectY += 50;
					rect(rectX2, rectY2, 50, 50);
					rectX2 -= 50;
					rectY2 += 50;
					rectHue += 25;
				}
				break;
			case 6:
				background(0);
				colorMode(HSB);
				rectHue = 200;

				for(circleW = 500; circleW>0; circleW-= 50)
				{
					ellipse(250, 250, circleW, circleW);
					fill(rectHue, 255, 255);
					rectHue -= 20;
				}
				break;
			case 7:
				background(0);
				colorMode(HSB);
				
		}	
	}
}
