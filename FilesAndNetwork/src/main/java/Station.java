import java.time.LocalDate;

public class Station implements Comparable<Station> {
    private int number;

    private double depth;

    private String name;

    private Line line;

    private LocalDate date;

    private boolean hasConnection;


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

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    @Override
    public String toString() {
        return "\n\n" + "Название: " + name + "\n" +
                "Дата строительства: " + date + "\n" +
                "Глубина: " + depth + "\n" +
                "Линия: " + line.getName() + "\n" +
                "Порядковый номер: " + number + "\n" +
                "Есть пересадка?:  " + hasConnection + "\n\n";

    }

    @Override
    public int compareTo(Station station) {
        if (station.getNumber() > this.number) {
            return 1;
        } else if (station.getNumber() < this.number) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Station station) {
        if (this.name.equals(station.getName()) &&
        this.line.equals(station.getLine())) {
            return true;
        }
        return false;
    }
}
