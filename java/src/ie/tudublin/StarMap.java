package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    //Arrow brackets are for generics, basically an array list that will hold data type of stars.
    ArrayList<Star> stars = new ArrayList<Star>();

    float border;
    
    void drawGrid()
    {
        colorMode(RGB);
        textAlign(CENTER,CENTER);
        textSize(20);
        for(int i = -5; i <= 5; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            stroke(255, 0, 255);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }

    void printStars()
    {
        for(Star s:stars)
        {
            System.out.println(s);
        }
    }

    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header"); //first parameter is name of CSV file, second parameter is header (0th row of the file)

        for( TableRow r: table.rows()) //Enchance for loop iterates over collections
        {
            Star s = new Star(r); //r creates the star from table rows 

            stars.add(s); //adds stars to the array list
        }
    }

    public void settings() {
        size(800, 800);
    }


    public void mouseClicked()
    {
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();

        border = width * 0.1f;
    }

    public void drawStars()
    {
    }

    public void draw() 
    {
        background(0);
        drawGrid();
    }
}