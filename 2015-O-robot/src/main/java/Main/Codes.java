package Main;

public class Codes {
    public String name;
    public String code;

    public Codes(String dataLine) {
        String[] Data = dataLine.split(" ");
        this.name = Data[0];
        this.code = Data[1];
    }
}
