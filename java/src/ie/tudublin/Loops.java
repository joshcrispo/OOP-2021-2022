package ie.tudublin;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);

	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}
	
	float offset = 0;

	public void draw() 
	{
		switch (mode) {
			case 0:
				background(0);
				int bars = (int) (mouseX / 20.0f);
				float w = width/ (float) bars;
				for (int i=0;i<bars;i++)
				{
					noStroke();
					fill(map(i,0,bars,0,255),255,255);
					float x = map(i, 0, bars, 0, width);
					rect(x,0,w,height);
				}
				break;
			case 1:
				background(0);
				int squares = (int) (mouseX/ 20.0f);
				float h = width / (float) squares;
				for (int i=0;i<squares;i++)
				{
					fill(map(i,0,squares,0,255),255,255);
					float x = map(i,0,squares,0, width);
					rect(x,x,h,h);
					rect((width-h)-x,x,h,h);
				}
				break;
			case 2:
				background(0);
				int circles = (int) (mouseX/20.0f);
				float size = width / (float) circles;
				for (int i =0;i<circles;i++)
				{
					for (int j=0;j < circles; j++)
					{
						noStroke();
						float c = map((i + j), 0, circles * 2, 0, 255) % 256;
						fill(c, 255, 255);
						float x = map(i, 0, circles - 1, size / 2.0f, width - (size / 2.0f)); 
						float y = map(j, 0, circles - 1, size / 2.0f, width - (size / 2.0f)); 
						circle(x, y, size);
					}
				}
				break;
			case 3:
				background(0);
				stroke(255,0,255);
				float border = width * 0.1f;
				textAlign(CENTER, CENTER);
				textSize(20);
				for(int i = -5; i <=5; i ++)
				{
					float x = map(i, -5, 5, border, width - border);
					line(x, border, x, height - border);
					line(border, x, width - border, x);
					fill(255);
					text(i, x, border * 0.5f);
					text(i, border * 0.5f, x);
				}
				break;
			case 4:
				background(0);
				stroke(255, 255, 255);	
				float cx = width / 2;
				float cy = height / 2;	
				float radius = 200;		
				int points = (int)map(mouseX, 1, width, 5, 20);
				int sides = points * 2;
				float px = cx;
				float py = cy - radius; 
				for(int i = 0 ; i <= sides ; i ++)
				{
					float r = (i % 2 == 0) ? radius : radius / 2; 
					// float r = radius;
					float theta = map(i, 0, sides, 0, TWO_PI);
					float x = cx + sin(theta) * r;
					float y = cy - cos(theta) * r;
					
					//circle(x, y, 20);
					line(px, py, x, y);
					px = x;
					py = y;
				}
				break;

			case 5:
				background(0);
				beginShape();
				for(int i=0;i<mouseX;i++)
				{
					noFill();
					stroke(255);
					float sides1 = radians(i);
					float x = width/2;
					float y = height/2;
					float r = 150;

					float centerX = x + sin(sides1) * r;
					float centerY = y + cos(sides1) * r;

					vertex(centerX, centerY);
				}
				endShape();
				break;
		}
	}
}
