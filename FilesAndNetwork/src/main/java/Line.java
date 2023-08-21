import java.util.ArrayList;
import java.util.List;

public class Line {
    private  String number;

    private  String name;

    private List<Station> stations;


    public List<Station> getStations() {
        return new ArrayList<>(stations);
    }


    public String getNumber() {
        return number;
    }


    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return   "\n" +"Номер: " + number + "\n" +
                "Количество станций: " + this.stations.size() + "\n " +
                "Название: " + name + "\n" +
                "Перечень станций: " + getStations() + "\n";

    }

    public boolean equals(Line line) {
        if (line.getName().equals(this.name)) {
            return true;
        }
        return false;
    }


}
