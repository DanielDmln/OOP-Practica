package demo.v1d;

public class Voetbalclub {

    private int aantalGewonnen = 0;
    private int aantalGelijk = 0;
    private int aantalVerloren = 0;
    public String naam;

    public Voetbalclub(int aantalGewonnen, int aantalGelijk, int aantalVerloren, String naam) {
        this.aantalGewonnen = aantalGewonnen;
        this.aantalGelijk = aantalGelijk;
        this.aantalVerloren = aantalVerloren;
        this.naam = naam;
    }

    public Voetbalclub(String naam) {
        this.naam = naam;
    }

    public Voetbalclub() {
    }

    public void verwerkResultaat(char ch) {
        if (ch == 'w')
            aantalGewonnen = aantalGewonnen + 1;
        if (ch == 'g')
            aantalGelijk = aantalGelijk + 1;
        if (ch == 'v')
            aantalVerloren = aantalVerloren + 1;
    }

    public int aantalPunten() {
        return (aantalGewonnen * 3) + aantalGelijk;
    }

    public int aantalGespeeld() {
        return aantalGewonnen + aantalGelijk + aantalVerloren;
    }

    @Override
    public String toString() {
        return naam + "   " + aantalGespeeld() + " " + aantalGewonnen + " " + aantalGelijk + " " + aantalVerloren + " " + aantalPunten();
    }
}