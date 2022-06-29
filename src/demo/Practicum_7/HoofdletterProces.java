package demo.Practicum_7;

import org.jetbrains.annotations.NotNull;

public class HoofdletterProces implements OpmaakProces{

    public HoofdletterProces() {}

    public String maakOp(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input mag niet null zijn");
        } else {
            return input.toUpperCase();
        }
    }
}
