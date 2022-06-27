package demo.Practicum_8;

import java.time.LocalDate;

public class Computer implements Goed {
    String type;
    String macAdres;
    double aanschafPrijs;
    int productieJaar;

    public Computer(String tp, String adr, double pr, int jr) {
        type = tp;
        macAdres = adr;
        aanschafPrijs = pr;
        productieJaar = jr;
    }

    public double huidigeWaarde() {
        int leeftijd = LocalDate.now().getYear() - productieJaar;

        double waarde = aanschafPrijs;
        for (int i = 0; i < leeftijd; i++) {
            waarde = waarde / 100 * 60;
        }

        return waarde;
    }

    public boolean equals(Object obj) {
        boolean gelijkeObjecten = false;

        if (obj instanceof Computer) {
            Computer computer = (Computer) obj;

            if (this.macAdres.equals(computer.macAdres)) {
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }

    public String toString() {
        return "Computer: " + type + " met productiejaar " + productieJaar + " heeft een waarde van: €" + huidigeWaarde() + ".";
    }
}
