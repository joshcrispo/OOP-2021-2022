package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
    
    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};

    //float[] a1 = new float[100]; -> another way to initialise an array
    //float[] a2; -> null pointer error

    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEPT", "OCT", "NOV", "DEC"};

    int maxIndex = 0;
    int minIndex = 0;

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        for(int i = 0; i < rainfall.length; i ++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        
        //Limitations only can go forwards never backwards, also can only be used with one array
        for(float r:rainfall) //Iterates through the array [Enchanced for loop]
        {
            println(r);        
        }

        /* Only way for both arrays to work with enchanced loop
        int i;
        for(float r:rainfall)
        {
            println(r + months);
            i ++;
        }
        */

        //Decreasing
        for (int i = rainfall.length - 1; i >= 0 ; i --)
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        float minValue = rainfall[0];
        float maxValue = rainfall[0];
        String minMonth = months[0];
        String maxMonth = months[0];
        float totalValue = rainfall[0];
        float avgValue = rainfall[0];

        for(int i = 1; i < rainfall.length; i++)
        {
            if (minValue > rainfall[i])
            {
                minValue = rainfall[i];
                minMonth = months[i];
            }
            if (maxValue < rainfall[i])
            {
                maxValue = rainfall [i];
                maxMonth = months[i];
            }

            totalValue = totalValue + rainfall[i];
            
        }
        avgValue = totalValue / 12;
        println("MIN :" + minValue + "mm " + minMonth + " MAX :" +  maxValue + "mm " + maxMonth);
        println("Total Rainfall all year: " + totalValue + "mm" );
        println("Average Rainfall all year: " + avgValue + "mm" );

    
        //Bryans Solution:
        for(int i = 0; i < rainfall.length; i ++)
        {
            if(rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            else if(rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            }
        }
        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);
    }
    /*
    public void draw()
    {
        background(0);
        int index = 0;
        int widthOfBar = 500 /rainfall.length;
        int BarX = 0;
        for(int i = 0; i<rainfall.length; i++)
        {   
            rectMode(CORNER);
            rect(BarX, 0, rainfall[index], widthOfBar);
            BarX += widthOfBar;
        }

    }
    */
    
    //Bryans Solution: (my solution in lab3_practice)
        public void draw()
        {
            background(0);
            colorMode(HSB);
            noStroke();
            float w = width/ (float)rainfall.length;
            for(int i = 0; i < rainfall.length; i ++)
            {
                //float x = i * w;
                float x = map(i, 0, rainfall.length, 0, width);
                int c = (int)map(i ,0, rainfall.length, 0, 255);
                fill(c, 255, 255);
                float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
                rect(x, height, w, -rainfall[i]);
                fill(255);
                textAlign(CENTER, CENTER);
                text(months[i], x+ (w/2), height - 50);
            }
        }
}
