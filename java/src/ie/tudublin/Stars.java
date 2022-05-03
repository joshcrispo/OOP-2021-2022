package ie.tudublin;

import java.util.Random;


public class Stars {
    float x;
    float y;
    float z;
    Audio1 music;
    
    public Stars() {
        x = music.random(0, music.width);
        y = music.random(0, music.height);
        z = music.random(0, music.width);

    }

    void update() {

    }
    void show() {
        music.fill(255);
        music.noStroke();
        music.ellipse(x, y, 8, 8);
    }
    
}
