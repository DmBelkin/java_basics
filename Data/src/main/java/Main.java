import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    private static final Metro metro = new Metro();
    private static final String LINE_REGEX = "[А-Я-]{3}+[0-9]{1}";

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
            Elements elements = document.select("h2");
            elements.forEach(System.out::println);
            parseLine(elements);
            parseStations(elements);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseLine(Elements elements) {
        String[] data = elements.text().split("\\d+");
        int lineNumber = 1;
        for (String result : data) {
            if (result.toLowerCase().contains("линия")) {
                String[] ary = result.replaceAll("\\.", "").
                        trim().split("\\s+");
                String lineName = ary[ary.length - 2] + " " + ary[ary.length - 1];
                metro.setLines(new Line(lineNumber, lineName));
                lineNumber++;
                /**
                 * недопарсил несколько линий
                 */
            }
        }
    }

    private static void parseStations(Elements elements) {
        String[] data = elements.text().split("\\d+");
        System.out.println(Arrays.toString(data));
        int stationNumber = 1;
        int check = 1;
        String stationName = "";
        for (Line line : metro.getLines()) {
            for (int i = check; i <= data.length - 1; i++) {
                if (!data[i].toLowerCase().contains("линия")) {
                    stationName = data[i].trim().replaceAll("\\.", "");
                    line.addStations(new Station(stationNumber, 0, stationName, line,
                            LocalDate.of(1, 1, 1)));
                    stationNumber++;
                    check++;
                }
                if (data[i].toLowerCase().contains("линия")) {
                    String[] ary = data[i].trim().split("\\s+");
                    if (ary.length == 3) {
                        stationName = ary[0].trim().replaceAll("\\.", "");
                    }
                    else if (ary.length > 3) {
                        stationName = (ary[0] + " " + ary[1]).trim().replaceAll("\\.", "");
                    }
                    line.addStations(new Station(stationNumber, 0, stationName, line,
                            LocalDate.of(1, 1, 1)));
                    stationNumber = 1;
                    check++;
                    break;
                }
            }
        }
        System.out.println(metro);
    }
}
