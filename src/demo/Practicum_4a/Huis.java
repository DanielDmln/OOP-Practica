package demo.Practicum_4a;

public class Huis {
    public String adres;
    public int bouwjaar;
    public Persoon huisbaas;

    public Huis(String adr, int bwjr) {
        adres = adr;
        bouwjaar = bwjr;
    }

    public void setHuisbaas(Persoon hb) {
        huisbaas = hb;
    }

    public Persoon getHuisbaas() {
        return huisbaas;
    }

    public String toString() {
        return "Huis " + adres + " is gebouwd in " + bouwjaar + "\nen heeft huisbaas " + getHuisbaas();
    }
}
