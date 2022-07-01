package demo.practicum_9_en_10.a;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Utils {
    private static int aantalKeerGebruikt = 0;
    private static DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.GERMAN);

    public static int getAantalKeerGebruikt() {
        return aantalKeerGebruikt;
    }

    public static String euroBedrag(double bedrag) {
        DecimalFormat df = new DecimalFormat("#.##", dfs);

        aantalKeerGebruikt = aantalKeerGebruikt + 1;
        return "€" + df.format(bedrag);
    }

    public static String euroBedrag(double bedrag, int precisie) {
        String format = "#.";
        if (precisie <= 0)
            format = "#.-";

        DecimalFormat df = new DecimalFormat(format + "0".repeat(Math.max(0, precisie)), dfs);

        aantalKeerGebruikt = aantalKeerGebruikt + 1;
        return "€" + df.format(bedrag);
    }

}
