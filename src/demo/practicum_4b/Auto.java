package demo.practicum_4b;

public class Auto {
    public String type;
    public double prijsPerDag;

    public Auto(String tp, double prPd) {
        type = tp;
        prijsPerDag = prPd;
    }

    public Auto() {}

    public void setPrijsPerDag(double prPd) {
        prijsPerDag = prPd;
    }

    public double getPrijsPerDag() {
        return prijsPerDag;
    }

    public String toString() {
        return type + " met prijs per dag: " + getPrijsPerDag();
    }
}