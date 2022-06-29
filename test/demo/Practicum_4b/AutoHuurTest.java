package demo.Practicum_4b;

import demo.v1d.Voetbalclub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutoHuurTest {
    public AutoHuur a1;
    public AutoHuur a2;
    public AutoHuur a3;
    public AutoHuur a4;
    public AutoHuur a5;
    public AutoHuur a6;

    @BeforeEach
    public void testAutoHuur() {

        a1 = new AutoHuur();
        a2 = new AutoHuur();
        a3 = new AutoHuur();
        a4 = new AutoHuur();
        a5 = new AutoHuur();
        a6 = new AutoHuur();

        a1.setAantalDagen(24);
        a2.setAantalDagen(33);
        a3.setAantalDagen(55);
        a4.setAantalDagen(90);
        a5.setAantalDagen(365);

        Klant b1 = new Klant("Meneer");
        Klant b2 = new Klant("Mevrouw");
        Klant b5 = new Klant("Jongen");
        Klant b6 = new Klant("Meisje");

        b2.setKorting(50);
        b5.setKorting(33.3);
        b6.setKorting(2);

        Auto c1 = new Auto("Lambourghini Aventador", 10000);
        Auto c2 = new Auto("", 500);
        Auto c3 = new Auto("Audi R8", 7500);
        Auto c5 = new Auto("Porsche 911", 8000);
        Auto c6 = new Auto("Toyota Supra mk4", 4000);

        a1.setHuurder(b1);
        a1.setGehuurdeAuto(c1);
        a2.setHuurder(b2);
        a2.setGehuurdeAuto(c2);
        a3.setGehuurdeAuto(c3);
        a5.setHuurder(b5);
        a5.setGehuurdeAuto(c5);
        a6.setHuurder(b6);
        a6.setGehuurdeAuto(c6);
    }


    @Test
    void testTotaalPrijs() {
        assertEquals("  autotype: Lambourghini Aventador met prijs per dag: 10000.0\n  op naam van: Meneer (korting: 0.0%)\n  aantal dagen: 24 en dat kost 240000.0", a1.toString(), "totaalPrijs() wordt verkeerd berekend");
    }

    @Test
    void testNaamIngevuld() {
        assertEquals("  er is geen auto bekend\n  op naam van: Mevrouw (korting: 50.0%)\n  aantal dagen: 0 en dat kost 0.0", a2.toString(), "niet invullen naam mag niet mogelijk zijn");
    }

    @Test
    void testHuurderAanwezig() {
        assertEquals("  autotype: Audi R8 met prijs per dag: 7500.0\n  er is geen huurder bekend\n  aantal dagen: 0 en dat kost 0.0", a3.toString(), "zonder huurder mag hij niet worden uitgeleend, aantalDagen() moet 0 zijn");
    }

    @Test
    void testAutoAanwezig() {
        assertEquals("  er is geen auto bekend\n  er is geen huurder bekend\n  aantal dagen: 0 en dat kost 0.0", a4.toString(), "zonder huurder en/of auto kan hij niet worden uitgeleend, aantalDagen() moet 0 zijn");
    }

    @Test
    void testKortingBerekening() {
        assertEquals("  autotype: Porsche 911 met prijs per dag: 8000.0\n  op naam van: Jongen (korting: 33.3%)\n  aantal dagen: 365 en dat kost 1947640.0", a5.toString(), "percentage korting wordt verkeerd berekend");
    }

    @Test
    void testGeenDagen() {
        assertEquals("  autotype: Toyota Supra mk4 met prijs per dag: 4000.0\n  op naam van: Meisje (korting: 2.0%)\n  aantal dagen: 0 en dat kost 0.0", a6.toString(), "zonder aantalDagen() moet totaalPrijs() 0.0 zijn");
    }
}