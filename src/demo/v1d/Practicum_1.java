package demo.v1d;
import java.sql.SQLOutput;
import java.text.DecimalFormat;

public class Practicum_1 {
    public static void main(String[] args){
        System.out.println("Opdracht 1:");
        for(int x=1; x<11; x++) {
            System.out.println(x);
        }
        System.out.println("\nOpdracht 2:");
        Opdracht_2();
        System.out.println("\nOpdracht 3:");
        Opdracht_3();
        System.out.println("\n Opdracht 4:");
        Opdracht_4();
        System.out.println("\nOpdracht 5:");
        Opdracht_5();
    }
    public static void Opdracht_2() {
        int x = 1;
        while (x < 11) {
            System.out.println(x);
            x++;
        }
    }
    public static void Opdracht_3() {
        int a = 0;
        DecimalFormat s = new DecimalFormat("#.#");
        while (a < 10) {
            double x = Math.random();
            if (x <= 0.9) {
                System.out.println(s.format(x));
                a++;
            }
        }
    }
    public static void Opdracht_4() {
        int a = 0;
        for(int x=0; x<40; x++) {
            a = a + x;
        }
        System.out.println(a);
    }
    public static void Opdracht_5() {
        String a = "s";
        for (int x = 0; x < 4; x++) {
            System.out.println(a);
            a = a + "s";
            if (x % 2 == 1) {
                a = "s";
            }
        }
    }
}