
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Metro metro = new Metro();

    private static final String LINE_REGEX = "[А-Я-]{3}+[0-9]{1}$";
    private static final String file = "data/data";

    private static String path = "";
    private static final ArrayList<File> collectFiles = new ArrayList<>();
    private static StringBuilder jsonBuilder;
    private static StringBuilder depthBuilder;

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
            Elements elements = document.select("#metrodata");
//            parseLine(elements);
//            parseStations(elements);
            fileReader();
            dateParser();
            depthParser();
            jsonParser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseLine(Elements elements) {
        String[] data = elements.text().split("\\d+");
        int lineNumber = 1;
        for (String result : data) {
            System.out.println(result);
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
                    } else if (ary.length > 3) {
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

    private static ArrayList<File> fileReader() {
        File dataFile = new File(file);
        for (File f : dataFile.listFiles()) {
            if (f.isDirectory()) {
                for (File f1 : f.listFiles()) {
                    if (f1.isDirectory()) {
                        for (File file1 : f1.listFiles()) {
                            if (file1.isFile()) {
                                collectFiles.add(file1);
                            }
                        }
                    }
                }
            }
        }
        return collectFiles;
    }

    private static String dateParser() {
        jsonBuilder = new StringBuilder();
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().equals("dates-2.json")) {
                        List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                        lines.forEach(line -> jsonBuilder.append(line));
                        lines.forEach(System.out::println);
                    }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
        }
        return jsonBuilder.toString();
    }

    private static String depthParser() {
        depthBuilder = new StringBuilder();
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().equals("depths-1.json")) {
                    List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                    lines.forEach(line -> depthBuilder.append(line));
                    lines.forEach(System.out::println);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
        }
        return depthBuilder.toString();
    }

    private static void jsonParser() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(dateParser());
            JSONArray stationArray = (JSONArray) jsonData.get("name");
            getDate(stationArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static  void getDate(JSONArray stationArray) {
        stationArray.forEach(o -> { JSONObject object = (JSONObject) o;
                 String[] dates = object.get("date").toString().split("\\.");
                 LocalDate date = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]),
                         Integer.parseInt(dates[2]));
        metro.getLines().stream().forEach(line -> line.getStations().stream().forEach(station -> station.setDate(
        date)));}
        );
    }

    private static  void  getDepth() {

    }
}

