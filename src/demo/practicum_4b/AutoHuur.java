package demo.practicum_4b;

public class AutoHuur {
    public int aantalDagen;
    public Auto gehuurdeAuto = new Auto();
    public Klant huurder = new Klant();

    public AutoHuur() {
    }

    public void setAantalDagen(int aD) {
        aantalDagen = aD;
    }

    public int getAantalDagen() {
        return aantalDagen;
    }

    public void setGehuurdeAuto(Auto gA) {
        gehuurdeAuto = gA;
    }

    public Auto getGehuurdeAuto() {
        return gehuurdeAuto;
    }

    public void setHuurder(Klant k) {
        huurder = k;
    }

    public Klant getHuurder() {
        return huurder;
    }

    public double totaalPrijs() {
        return gehuurdeAuto.getPrijsPerDag() * aantalDagen / 100 * (100 - huurder.getKorting());
    }

    public String toString() {
        String a = "autotype: " + getGehuurdeAuto();
        String b = "op naam van: " + getHuurder();
        String c = getAantalDagen() + " en dat kost " + totaalPrijs();
        if (gehuurdeAuto.type == null || gehuurdeAuto.type.equals("")) {
            a = "er is geen auto bekend";
            c = "0 en dat kost 0.0"; // als de auto onbekend is kan hij ook niet worden uitgeleend
        }
        if (huurder.naam == null || huurder.naam.equals("")) {
            b = "er is geen huurder bekend";
            c = "0 en dat kost 0.0"; // als de huurder onbekend is mag de auto niet worden uitgeleend
        }
        return "  " + a + "\n  " + b + "\n  aantal dagen: " + c;
    }
}