package demo.practicum_8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BedrijfsInventarisTest {
    public Computer computer;
    public Computer dezelfdeComputer;
    public Auto auto;
    public Auto dezelfdeAuto;
    public Fiets fiets;
    public Fiets dezelfdeFiets;

    @BeforeEach
    void testBedrijfsInventaris() {
        computer = new Computer("MSI Superstation", "1234", 10000, 2022);
        dezelfdeComputer = new Computer("MSI Superstation", "1234", 10000, 2022);

        auto = new Auto("Porsche 911", 150000, 2015, "68-MP-LK");
        dezelfdeAuto = new Auto("Porsche 911", 150000, 2015, "68-MP-LK");

        fiets = new Fiets("Piaggio Zip", 2000, 2016, 4321);
        dezelfdeFiets = new Fiets("Piaggio Zip", 2000, 2016, 4321);
    }

    // Test of gelijke objecten aangeschaft kunnen worden
    @Test
    void testSchafAanGelijkeObjecten() {
        BedrijfsInventaris bedrijfsInventarisWaarAllesInGaat = new BedrijfsInventaris("geen naam", 1000000);
        BedrijfsInventaris bedrijfsInventarisWaarAlleenJuisteInGaan = new BedrijfsInventaris("betere naam", 1000000);

        bedrijfsInventarisWaarAllesInGaat.schafAan(computer);
        bedrijfsInventarisWaarAllesInGaat.schafAan(dezelfdeComputer);
        bedrijfsInventarisWaarAllesInGaat.schafAan(auto);
        bedrijfsInventarisWaarAllesInGaat.schafAan(dezelfdeAuto);
        bedrijfsInventarisWaarAllesInGaat.schafAan(fiets);
        bedrijfsInventarisWaarAllesInGaat.schafAan(dezelfdeFiets);

        bedrijfsInventarisWaarAlleenJuisteInGaan.schafAan(computer);
        bedrijfsInventarisWaarAlleenJuisteInGaan.schafAan(auto);
        bedrijfsInventarisWaarAlleenJuisteInGaan.schafAan(fiets);

        assertEquals(bedrijfsInventarisWaarAlleenJuisteInGaan.toString(), bedrijfsInventarisWaarAllesInGaat.toString(), "De 'stiekeme' goederen horen niet toegevoegd te kunnen worden aan de toString()");
    }

    // Test of objecten met een te hoge prijs aangeschaft kunnen worden
    @Test
    public void testSchafAanTeHogePrijs() {
        BedrijfsInventaris bedrijfsInventarisWaarAllesInGaat = new BedrijfsInventaris("bedrijf", 20000);
        BedrijfsInventaris bedrijfsInventarisWaarAlleenJuisteInGaan = new BedrijfsInventaris("bedrijfje", 20000);

        bedrijfsInventarisWaarAllesInGaat.schafAan(auto);
        bedrijfsInventarisWaarAllesInGaat.schafAan(fiets);

        bedrijfsInventarisWaarAlleenJuisteInGaan.schafAan(auto);
        bedrijfsInventarisWaarAlleenJuisteInGaan.schafAan(computer);
        bedrijfsInventarisWaarAlleenJuisteInGaan.schafAan(fiets);

        assertEquals(bedrijfsInventarisWaarAlleenJuisteInGaan.toString(), bedrijfsInventarisWaarAllesInGaat.toString(), "Er hoort een tekort te zijn waardoor alleen de auto en fiets aangeschaft kunnen worden.");
    }
}