package demo.Practicum_5;

public class Leerling {
    public String naam;
    public double cijfer;

    public Leerling(String nm) {
        naam = nm;
    }

    public Leerling() {}

    public String getNaam() {
        return naam;
    }
    public double getCijfer() {
        return cijfer;
    }
    public void setCijfer(double c) {
        cijfer = c;
    }

    public String toString() {
        return naam + " heeft cijfer: " + getCijfer() + "\n";
    }
}