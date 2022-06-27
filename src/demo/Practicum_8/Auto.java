package demo.Practicum_8;

import java.time.LocalDate;

public class Auto extends Voertuig {
    private String kenteken;

    public Auto(String tp, double pr, int jr, String kt) {
        super(tp, pr, jr);
        kenteken = kt;
    }

    public double huidigeWaarde() {
        int leeftijd = LocalDate.now().getYear() - bouwjaar;

        double waarde = nieuwprijs;
        for (int i = 0; i < leeftijd; i++) {
            waarde = waarde / 100 * 70;
        }

        return waarde;
    }

    public boolean equals(Object obj) {
        boolean gelijkeObjecten = false;

        if (obj instanceof Auto) {
            Auto auto = (Auto) obj;

            if (this.kenteken.equals(auto.kenteken)) {
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }
}
