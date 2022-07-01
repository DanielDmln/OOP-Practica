package demo.practicum_5;

import java.util.ArrayList;

public class Klas {
    public String klasCode;

    ArrayList<Leerling> leerlingen = new ArrayList<>();

    public Klas(String kC) {
        klasCode = kC;
    }

    public void voegLeerlingToe(Leerling l) {
        leerlingen.add(l);
    }
    public void wijzigCijfer(String nm, double nweCijfer) {
        for (Leerling x : leerlingen) {
            if (x.naam.equals(nm))
                x.setCijfer(nweCijfer);
        }
    }

    public ArrayList<Leerling> getLeerlingen() {
        return leerlingen;
    }
    public int aantalLeerlingen() {
        return leerlingen.size();
    }

    public String toString() {
        return "In klas " + klasCode + " zitten de volgende leerlingen:\n" +
                getLeerlingen().get(0) + getLeerlingen().get(1) + getLeerlingen().get(2);
    }
}