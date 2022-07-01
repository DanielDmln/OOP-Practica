package demo.practicum_11;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;


public class Files {
    public static String data = "";

    public static File searchFile(String fileName) {
        fileName = fileName.toLowerCase(Locale.ROOT);

        String fileType = ".txt";
        if (fileName.endsWith(".txt"))
            fileType = "";

        return new File("src/demo/practicum_11/" + fileName + fileType);
    }

    public static void readFile(File file) {
        try {
            Scanner fileReader = new Scanner(file);

            if (file.length() == 0) {
                System.out.println("This file is empty. Please choose another file.");
                System.exit(1);
            }

            while (fileReader.hasNextLine()) {
                if (data.isEmpty())
                    data = fileReader.nextLine();
                else
                    data = data + "\n" + fileReader.nextLine();
            }
            fileReader.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("This file does not exist. Please check your spelling.");
            System.exit(1);
        }
    }

    public static void createFile(File destinationFile) {
        try {
            if (destinationFile.createNewFile() || destinationFile.length() == 0) {
                return;
            }
            else {
                System.out.println("This file already contains information. Please choose a different or non-existing filename.");
                System.exit(1);
            }
        }
        catch (IOException exception) {
            System.out.println("Sorry, something went wrong. Please try again.");
            System.exit(1);
        }
    }

    public static void writeFile(File destinationFile, String exchangeRate) {
        for (int i = 0; i < exchangeRate.length(); i++) {
            if (Character.isLetter(exchangeRate.charAt(i))) {
                System.out.println("\nPlease fill in a number for the exchange rate.");
                System.exit(1);
            }
        }
        if (exchangeRate.contains(",")) {
            System.out.println("\nPlease use a dot '.' before decimal numbers.");
            System.exit(1);
        }
        double rate = Double.parseDouble(exchangeRate) / 100;

        try {
            FileWriter fileWriter = new FileWriter(destinationFile);
            Scanner fileReader = new Scanner(data);

            while (fileReader.hasNextLine()) {
                String[] string = fileReader.nextLine().split(" : ");

                double oldPrice = Double.parseDouble(string[1]);
                double newPrice = oldPrice * rate;

                DecimalFormat df = new DecimalFormat("#.00");
                fileWriter.write(string[0] + " : " + df.format(newPrice) + "\n");
            }
            fileWriter.close();
            fileReader.close();
        }
        catch (IOException exception) {
            System.out.println("Sorry, something went wrong. Please try again.");
            System.exit(1);
        }
    }
}
