import java.util.ArrayList;

public class Metro {

    private ArrayList<Line> lines = new ArrayList<>();

    private ArrayList<Station> stations = new ArrayList<>();

    public void setLines(Line line){
        lines.add(line);
        if (lines.isEmpty()) {
            System.err.println("Линий нет");
        }
    }
    public ArrayList<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public void setStations(Station station) {
        stations.add(station);
        if (stations.isEmpty()) {
            System.err.println("Станций нет");
        }
    }

    public ArrayList<Station> getStations() {
        return new ArrayList<>(stations);
    }

    @Override
    public String toString() {
        String toString =  "Линии" + "\n" + getLines() + "\n";
        return toString;
    }
}
