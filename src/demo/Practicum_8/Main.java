package demo.Practicum_8;

import demo.practicum_9a.Utils;

public class Main {
    public static void main(String[] args) {

        BedrijfsInventaris bedrijfsInventaris = new BedrijfsInventaris("opEenDag", 1000000);

        Computer computer = new Computer("Asus ROG STRIX", "G531GW", 1800, 2019);
        Computer computer2 = new Computer("Asus ROG STRIX", "G531GW", 1800, 2019);
        Computer computerUniek = new Computer("HP Pavilion", "ABC01", 750, 2021);

        Auto auto = new Auto("Mercedes-Benz C63 AMG", 80000, 2020, "DGG-80-N");
        Auto auto2 = new Auto("Mercedes-Benz C63 AMG", 80000, 2020, "DGG-80-N");
        Auto autoUniek = new Auto("Tesla Model S", 100000, 2015, "MN-GT-33");

        Fiets fiets = new Fiets("Ducati Superleggera V4", 74999.99, 2022, 872362);
        Fiets fiets2 = new Fiets("Ducati Superleggera V4", 75000, 2022, 872362);
        Fiets fietsUniek = new Fiets("Kawasaki H2R", 60000, 2018, 715083);

        bedrijfsInventaris.schafAan(computer);
        bedrijfsInventaris.schafAan(computer2);
        bedrijfsInventaris.schafAan(computerUniek);
        bedrijfsInventaris.schafAan(auto);
        bedrijfsInventaris.schafAan(auto2);
        bedrijfsInventaris.schafAan(autoUniek);
        bedrijfsInventaris.schafAan(fiets);
        bedrijfsInventaris.schafAan(fiets2);
        bedrijfsInventaris.schafAan(fietsUniek);

        System.out.println(bedrijfsInventaris.toString());
        System.out.println();

        System.out.println("Practicum 9A:");
        System.out.println(Utils.euroBedrag(auto.huidigeWaarde()));
        System.out.println(Utils.euroBedrag(fiets.huidigeWaarde(), 1)); // let op: deze wordt afgerond
        System.out.println(Utils.euroBedrag(fiets.huidigeWaarde(), 2));
        System.out.println(Utils.euroBedrag(fiets.huidigeWaarde(), 3));
    }
}
