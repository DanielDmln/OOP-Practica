package demo.Practicum_7;

public class VervangProces implements OpmaakProces {
    private String oud;
    private String nieuw;

    public VervangProces(String oud, String nieuw) {
        this.oud = oud;
        this.nieuw = nieuw;
    }

    public String maakOp(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input mag niet null zijn");
        } else {
            return input.replace(oud, nieuw);
        }
    }
}
