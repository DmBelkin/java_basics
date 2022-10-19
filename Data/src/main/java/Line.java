import java.util.ArrayList;
import java.util.List;

public class Line {

    private final int number;
    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(int number, String name) {
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


    public int getNumber() {
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
}
