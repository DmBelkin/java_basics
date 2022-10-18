
import java.time.LocalDate;

public class Station {

    private final int number;
    private final double depth;
    private final String name;
    private final Line line;
    private final LocalDate date;

    public Station (int number, double depth, String name, Line line, LocalDate date) {
        this.number = number;
        this.depth = depth;
        this.name = name;
        this.line = line;
        this.date = date;
    }

    public void setNumber(int number) {
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {

    }

    public void setDepth(double depth) {
    }

    public double getDepth() {
        return depth;
    }

    public void setLine(Line line) {

    }

    public Line getLine() {
        return line;
    }

    public void setDate(LocalDate date) {

    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public  String toString() {
        String toString = "\n\n" + "Название: " + name + "\n" +
                "Дата строительства: " + date + "\n" +
                "Глубина: " + depth + "\n" +
                "Линия: " + line.getName() + "\n" +
                "Порядковый номер: " + number + "\n\n";
        return toString;
    }
}

enum StationFunction {

}