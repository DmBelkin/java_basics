

public class Station {

    private final int number;
    private final String depth;
    private final String name;
    private final Line line;
    private final String date;

    private final boolean hasConnection;

    public Station (int number, String depth, String name, Line line, String date, boolean hasConnection) {
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


    public String getDepth() {
        return depth;
    }


    public Line getLine() {
        return line;
    }



    public String getDate() {
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
