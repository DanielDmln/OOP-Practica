package demo.practicum_7;

public class VoegToeProces implements OpmaakProces {
    private int plaats;
    private String toevoeging;

    public VoegToeProces(int plaats, String toevoeging) {
        this.plaats = plaats;
        this.toevoeging = toevoeging;
    }

    public String maakOp(String input) {
        String s = "";
        if (input.length() > plaats) {
            for (int i = 0; i < input.length(); i++) {
                if (i == plaats) {
                    s = s + toevoeging;
                }
                s = s + input.charAt(i);
            }
        } else {
            return "De gegeven inputString is kleiner dan de plaats die u heeft doorgegeven";
        }
        return s;
    }
}