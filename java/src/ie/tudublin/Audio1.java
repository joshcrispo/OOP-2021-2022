package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings() {
        size(1024, 500);
    }

    public void setup() {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        colorMode(HSB);
        y = height/2;
        smoothedY = y;
    }

    public void draw() {
        background(0);
        stroke(255);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        // everytime we do a draw the ab.size is 1024 samples
        for (int i = 0; i < ab.size(); i++) {
            // float c = map(ab.get(i), -1, 1, 0, 255);
            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);
            line(i, halfH, i, halfH + ab.get(i) * halfH);
            sum += abs(ab.get(i));
        }

        average = sum / (float) ab.size();
        stroke(0);
        fill(100, 255, 255);
        lerpedA = lerp(lerpedA, average, 0.1f);
        circle(width / 2, halfH, lerpedA * 10000);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);
        circle(200, smoothedY, 50);
    }

    // lerp() function c = lerp(a,b,t)
    // c = a + (b - a ) * t
    float y;
    float smoothedY;
    float lerpedA = 0;
}