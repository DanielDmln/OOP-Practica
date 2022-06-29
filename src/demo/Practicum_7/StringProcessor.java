package demo.Practicum_7;

import java.util.ArrayList;

public class StringProcessor {
    ArrayList<OpmaakProces> processen = new ArrayList<>();

    public StringProcessor() {}

    public String verwerk(String input) {
        for (OpmaakProces opmaakProces : processen) {
            input = opmaakProces.maakOp(input);
        }
        return input;
    }

    public void voegProcesToe(OpmaakProces proces) {
        if (proces == null) {
            throw new IllegalArgumentException("Proces mag niet null zijn");
        }
        if (!processen.contains(proces)) {
            processen.add(proces);
        }
    }
}
