

public class Dimensions {

    private final int high;
    private final int length;
    private final int width;

    public Dimensions(int high, int length, int width) {
        this.high = high;
        this.length = length;
        this.width = width;
    }

    public Dimensions setHigh(int high) {
        return new Dimensions(high, length, width);
    }

    public Dimensions setLength(int length) {
        return new Dimensions(high, length, width);
    }

    public Dimensions setWidth(int width) {
        return new Dimensions(high, length, width);
    }

    public String Volume() {
        int volume = high * length * width;
        String result = "volume = " + volume + ";" + "high = " + high + ";" + "length = " + length + ";" + "width = " + width;
        System.out.println(result);
        return result;
    }
}

