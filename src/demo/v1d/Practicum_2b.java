package demo.v1d;

public class Practicum_2b {
    public static void main(String[] args) {
        Voetbalclub ajx = new Voetbalclub("Ajax      ");
        Voetbalclub feij = new Voetbalclub("Feijneoord");

        feij.verwerkResultaat('w');
        feij.verwerkResultaat('w');
        feij.verwerkResultaat('w');
        feij.verwerkResultaat('g');

        System.out.println("Feijenoord punten: " + feij.aantalPunten());
        System.out.println("Ajax gespeeld: " + ajx.aantalGespeeld());
        System.out.println();

        System.out.println(ajx);
        System.out.println(feij);
    }
}