package demo.v1d;

public class Cirkel {

    public int radius;
    public int xPositie;
    public int yPositie;

    public Cirkel(int radius, int xPositie, int yPositie) {
        this.radius = radius;
        this.xPositie = xPositie;
        this.yPositie = yPositie;
        if(radius <= 0) {
            throw new IllegalArgumentException("Radius moet groter dan 0 zijn!");
        }
    }

    public String toString() {
        return "cirkel (" + xPositie + ", " + yPositie + ") met radius: " + radius;
    }
}
