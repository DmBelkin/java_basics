import java.util.ArrayList;
import java.util.List;

public class Line implements Comparable<Line> {

    private final String number;
    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public void addStations(Station station) {
        stations.add(station);
        if (stations.isEmpty()) {
            System.err.println("Станций нет");
        }
    }

    public List<Station> getStations() {
        return new ArrayList<>(stations);
    }


    public String getNumber() {
        return number;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String toString =  "\n" +"Номер: " + number + "\n" +
                "Название: " + name + "\n" +
                "Перечень станций: " + getStations() + "\n";
        return toString;

    }

    @Override
    public int compareTo(Line line) {
        return 0;
    }
}
