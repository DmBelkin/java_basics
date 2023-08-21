import java.util.ArrayList;

public class Metro {
    private ArrayList<Line> lines = new ArrayList<>();

    private ArrayList<Station> stations = new ArrayList<>();

    public void setLines(Line line){
        lines.add(line);
    }
    public ArrayList<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public void setStations(Station station) {
        stations.add(station);
    }

    public ArrayList<Station> getStations() {
        return new ArrayList<>(stations);
    }

    @Override
    public String toString() {

        return "Линии" + "\n" + getLines();

    }

}
