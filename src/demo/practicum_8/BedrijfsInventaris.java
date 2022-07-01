package demo.practicum_8;

import java.util.ArrayList;

public class BedrijfsInventaris {
    private ArrayList<Goed> alleGoederen = new ArrayList<>();

    private String bedrijfsnaam;
    private double budget;

    public BedrijfsInventaris(String nm, double bud) {
        bedrijfsnaam = nm;
        budget = bud;
    }

    public void schafAan(Goed g) {

        if (!alleGoederen.contains(g) && budget >= g.huidigeWaarde()) {

            budget = budget - g.huidigeWaarde();
            alleGoederen.add(g);
        } else {
            System.out.println("Dit goed heeft u hier al aan toegevoegd of u heeft hier niet genoeg budget voor.");
        }
    }

    public String toString() {

        for (Goed goed : alleGoederen) {
            System.out.println(goed.toString());
        }
        return "";
    }
}
