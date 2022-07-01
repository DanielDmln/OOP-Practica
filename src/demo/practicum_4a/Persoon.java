package demo.practicum_4a;

public class Persoon {
    public String naam;
    public int leeftijd;

    public Persoon(String nm, int lft) {
        naam = nm;
        leeftijd = lft;
    }

    public String toString() {
        return naam + "; leeftijd " + leeftijd + " jaar";
    }
}
