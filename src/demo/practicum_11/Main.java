package demo.practicum_11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        System.out.println("Name of source file:");
        File sourceFile = Files.searchFile(scanner.nextLine());
        System.out.println();
        Files.readFile(sourceFile);

        System.out.println("Name of destination file:");
        File destinationFile = Files.searchFile(scanner.nextLine());
        System.out.println();
        Files.createFile(destinationFile);

        System.out.print("Exchange rate (in cents):\n1.00 : ");
        String exchangeRate = scanner.nextLine();
        Files.writeFile(destinationFile, exchangeRate);
    }
}
