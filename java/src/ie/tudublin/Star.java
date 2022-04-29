package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star {

    private boolean hab;
    private String displayName;
    private float distance;
    private float Xg;
    private float Yg;
    private float Zg;
    private float absMag;

    public Star(boolean hab, String displayName, float distance, float xg, float yg, float zg, float absMag) {
        this.hab = hab;
        this.displayName = displayName;
        this.distance = distance;
        this.Xg = xg;
        this.Yg = yg;
        this.Zg = zg;
        this.absMag = absMag;
    }

    public Star(TableRow tr)
    {
        this(
            tr.getInt("Hab?") == 1, 
            tr.getString("Display Name"), 
            tr.getFloat("Distance"),
            tr.getFloat("Xg"),
            tr.getFloat("Yg"),
            tr.getFloat("Zg"),
            tr.getFloat("AbsMag")
        );
    }

    public boolean isHab() {
        return hab;
    }
    public void setHab(boolean hab) {
        this.hab = hab;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public float getDistance() {
        return distance;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }
    public float getxG() {
        return Xg;
    }
    public void setxG(float Xg) {
        this.Xg = Xg;
    }
    public float getyG() {
        return Yg;
    }
    public void setyG(float Yg) {
        this.Yg = Yg;
    }
    public float getzG() {
        return Zg;
    }
    public void setzG(float Zg) {
        this.Zg = Zg;
    }
    public float getAbsMag() {
        return absMag;
    }
    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    public void render(StarMap pa)
    {
        float x = PApplet.map(Xg, -5, 5, pa.border, pa.width - pa.border);
        float y = PApplet.map(Yg, -5, 5, pa.border, pa.height - pa.border);

        
        pa.stroke(255, 255, 0);
        pa.line(x, y -5, x, y + 5);
        pa.line(x-5, y, x + 5, y);
        pa.stroke(255, 0, 0);
        pa.noFill();
        pa.circle(x, y, absMag);
        pa.fill(255);
        pa.textSize(16);
        pa.textAlign(PApplet.LEFT, PApplet.CENTER);
        pa.text(displayName, x + 20, y);
    }
}
