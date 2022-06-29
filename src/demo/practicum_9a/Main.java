package demo.practicum_9a;

import jdk.jshell.execution.Util;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        System.out.println(Utils.euroBedrag(3.11314));
        System.out.println(Utils.euroBedrag(123123.123));
        System.out.println();

        System.out.println(Utils.euroBedrag(3.11314, 0));
        System.out.println(Utils.euroBedrag(3.11314, 1));
        System.out.println(Utils.euroBedrag(3.11314, 2));
        System.out.println(Utils.euroBedrag(3.11314, 3));
        System.out.println(Utils.euroBedrag(3.11314, 4));
        System.out.println(Utils.euroBedrag(3.11314, 5));
        System.out.println();

        System.out.println(Utils.euroBedrag(123123.123123, 0));
        System.out.println(Utils.euroBedrag(123123.123123, 1));
        System.out.println(Utils.euroBedrag(123123.123123, 2));
        System.out.println(Utils.euroBedrag(123123.123123, 3));
        System.out.println(Utils.euroBedrag(123123.123123, 4));
        System.out.println(Utils.euroBedrag(123123.123123, 5));
        System.out.println();

        System.out.println(Utils.euroBedrag(123123123.123123, 0));
        System.out.println(Utils.euroBedrag(123123123.199, 1));  // Controle of afronden van toepassing is
        System.out.println(Utils.euroBedrag(123123123.123123, 2));
        System.out.println(Utils.euroBedrag(123123123.123123, 3));
        System.out.println(Utils.euroBedrag(123123123.123123, 4));
        System.out.println(Utils.euroBedrag(123123123.123123, 5));
        System.out.println();

        System.out.println(Utils.getAantalKeerGebruikt());
    }
}
