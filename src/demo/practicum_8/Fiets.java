package demo.practicum_8;

import java.time.LocalDate;

public class Fiets extends Voertuig {
    private int framenummer;

    public Fiets(String tp, double pr, int jr, int fnr) {
        super(tp, pr, jr);
        framenummer = fnr;
    }

    public double huidigeWaarde() {
        int leeftijd = LocalDate.now().getYear() - bouwjaar;

        double waarde = nieuwprijs;
        for (int i = 0; i < leeftijd; i++) {
            waarde = waarde / 100 * 90;
        }

        return waarde;
    }

    public boolean equals(Object obj) {
        boolean gelijkeObjecten = false;

        if (obj instanceof Fiets) {
            Fiets fiets = (Fiets) obj;

            if (this.framenummer == fiets.framenummer) {
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }
}
