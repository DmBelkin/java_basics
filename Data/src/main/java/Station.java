import java.time.LocalDate;

public class Station  {

    private final int number;
    private final double depth;
    private final String name;
    private final Line line;
    private final LocalDate date;

    private final boolean hasConnection;

    public Station (int number, double depth, String name, Line line, LocalDate date, boolean hasConnection) {
        this.number = number;
        this.depth = depth;
        this.name = name;
        this.line = line;
        this.date = date;
        this.hasConnection = hasConnection;
    }

    public int getNumber() {
        return number;
    }


    public String getName() {
        return name;
    }


    public double getDepth() {
        return depth;
    }


    public Line getLine() {
        return line;
    }



    public LocalDate getDate() {
        return date;
    }

    public boolean getHasConnetion() {
        return hasConnection;
    }

    @Override
    public  String toString() {
        String toString = "\n\n" + "Название: " + name + "\n" +
                "Дата строительства: " + date + "\n" +
                "Глубина: " + depth + "\n" +
                "Линия: " + line.getName() + "\n" +
                "Порядковый номер: " + number + "\n" +
                "Есть пересадка? " + hasConnection + "\n\n";
        return toString;
    }
}
