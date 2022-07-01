package demo.practicum_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    // Deze tests zouden ook werken op Auto en Computer, het enige verschil zou de vermenigvuldiging zijn i.v.m. de
    // verschillende percentages.
    @Test
    void huidigeWaarde() {
        Computer computer22 = new Computer("Asus ROG STRIX", "G531GW", 1800, 2022);
        Computer computer21 = new Computer("Asus ROG STRIX", "G531GW", 1800, 2021);
        Computer computer20 = new Computer("Asus ROG STRIX", "G531GW", 1800, 2020);
        Computer computer19 = new Computer("Asus ROG STRIX", "G531GW", 1800, 2019);
        Computer computer18 = new Computer("Asus ROG STRIX", "G531GW", 1800, 2018);

        assertEquals(1800, computer22.huidigeWaarde());    // aanschafprijs in 2022
        assertEquals(1080, computer21.huidigeWaarde());    // 1800 / 100 * 60
        assertEquals(648, computer20.huidigeWaarde());     // 1080 / 100 * 60
        assertEquals(388.8, computer19.huidigeWaarde());   // 648 / 100 * 60
        assertEquals(233.28, computer18.huidigeWaarde());  // 388.8 / 100 * 60
    }
}