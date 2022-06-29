package demo.v1d;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoetbalclubTest {

    @Test
    void testClubnaam() {
        Voetbalclub a = new Voetbalclub("");
        assertEquals("FC", a.naam, "Naam niet ingevuld of null levert geen 'FC' op");
    }

    @Test
    void testResultaten() {
        Voetbalclub a = new Voetbalclub();
        a.verwerkResultaat('w');
        a.verwerkResultaat('g');
        a.verwerkResultaat('v');
        a.verwerkResultaat('1');
        assertEquals(4, a.aantalPunten(), "puntentelling klopt niet of foutieve invoer wordt meegerekend");
        assertEquals(3, a.aantalGespeeld(), "foutieve invoer word als gespeelde wedstrijd gerekend");
        assertEquals(a.naam + "   " + a.aantalGespeeld() + " " + 1 + " " + 1 + " " + 1 + " " + a.aantalPunten(), a.toString(), "toString() klopt niet");
    }
}