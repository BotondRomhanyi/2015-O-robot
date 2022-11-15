package Main;

public class Codes {
    public String name;
    public String code;

    public Codes(String dataLine) {
        String[] Data = dataLine.split(" ");
        this.name = Data[0];
        this.code = Data[1];
    }

    public boolean IsCodeCorrect() {
        boolean isCorrect = true;
        for (int i = 0; i < code.length(); i++) {
            if (!"EHJB".contains(code.subSequence(i, i + 1))) {
                isCorrect = false;
                break;
            }
        }
        return isCorrect;
    }

    public int DirectionChangeCounter() {
        int counter = 0;
        for (int i = 1; i < code.length(); i++) {
            if (code.charAt(i) != code.charAt(i - 1)) counter++;
        }
        return counter;
    }

    public double Distance() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < code.length(); i++) {
            switch (code.charAt(i)) {
                case 'E' -> x++;
                case 'H' -> x--;
                case 'J' -> y--;
                case 'B' -> y++;
            }
        }
        return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }
}
