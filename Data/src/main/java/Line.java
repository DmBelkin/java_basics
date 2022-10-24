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
//       if (!Character.isLetter(number.charAt(number.length() - 1))) {
//           number.replace(Character.toString(number.charAt(number.length() - 1)), "");
//       }
//        if (!Character.isLetter(line.getNumber().charAt(line.getNumber().length() - 1))) {
//            line.getNumber().replace(Character.toString(line.getNumber().
//                    charAt(line.getNumber().length() - 1)), "");
//        }
//        return Integer.compare(Integer.parseInt(number), Integer.parseInt(line.getName()));
        return 0;
    }

//    @Override
//    public boolean equals (Object obj) {
//        return compareTo((Line) obj) == 0;
//    }
}
