package demo.practicum_4b;

public class Klant {
    public String naam;
    public double kortingsPercentage;

    public Klant(String nm) {
        naam = nm;
    }

    public Klant() {}

    public void setKorting(double kP) {
        kortingsPercentage = kP;
    }

    public double getKorting() {
        return kortingsPercentage;
    }

    public String toString() {
        return naam + " (korting: " + getKorting() + "%)";
    }
}