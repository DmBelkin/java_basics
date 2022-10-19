
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Metro metro = new Metro();

    private static final String LINE_REGEX = "[А-Я-]{3}+[0-9]{1}$";
    private static final String file = "data/data";

    private static String path = "";

    private static final TreeMap<String, String> depthCollect = new TreeMap<>();
    private static final TreeMap<String, String> dateCollect = new TreeMap<>();
    private static final ArrayList<File> collectFiles = new ArrayList<>();
    private static StringBuilder jsonBuilder;
    private static StringBuilder depthBuilder;

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
            Elements elements = document.select("#metrodata");
            parseLine(elements);
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
        fileReader();
        parseStations(elements);
    }

    private static void parseStations(Elements elements) {
        String[] data = elements.text().split("\\d+");
        int stationNumber = 1;
        int check = 1;
        String stationName = "";
        double depth = 0;
        String date = "";
        for (Line line : metro.getLines()) {
            for (int i = check; i <= data.length - 1; i++) {
                if (!data[i].toLowerCase().contains("линия")) {
                    stationName = data[i].trim().replaceAll("\\.", "");
                    for (Map.Entry<String,String> entry : dateCollect.entrySet()) {
                        if (entry.getKey().equals(stationName.trim())){
                            date = entry.getValue();
                        }
                    }
                    for (Map.Entry<String,String> entry : depthCollect.entrySet()) {
                        if (entry.getKey().equals(stationName.trim())){
                            if (entry.getValue().charAt(0) == '-') {
                                System.out.println(entry.getValue());
                                depth = Double.parseDouble(entry.getValue().substring(1)) -
                                        2 * (Double.parseDouble(entry.getValue().substring(1)));
                            } else {
                                System.out.println(entry.getValue());
                                depth = Double.parseDouble(entry.getValue());
                            }
                        }
                    }
                    line.addStations(new Station(stationNumber, depth, stationName, line, date));
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
                    for (Map.Entry<String,String> entry : dateCollect.entrySet()) {
                        if (entry.getKey().equals(stationName.trim())){
                            date = entry.getValue();
                        }
                    }
                    for (Map.Entry<String,String> entry : depthCollect.entrySet()) {
                        if (entry.getKey().equals(stationName.trim())){
                            if (entry.getValue().charAt(0) == '-') {
                                System.out.println(entry.getValue());
                                depth = Double.parseDouble((entry.getValue().substring(1))) -
                                        2 * (Double.parseDouble(entry.getValue().substring(1)));
                            } else {
                                System.out.println(entry.getValue());
                                depth = Double.parseDouble(entry.getValue());
                            }
                        }
                    }
                    metro.setStations(new Station(stationNumber, depth, stationName, line, date));
                    line.addStations(new Station(stationNumber, depth, stationName, line, date));
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
            if (f.isFile()) {
                collectFiles.add(f);
            }
            if (f.isDirectory()) {
                for (File f1 : f.listFiles()) {
                    if (f1.isFile()) {
                        collectFiles.add(f1);
                    }
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
        jsonParser();
        return collectFiles;
    }

    private static String dateParser() {
        jsonBuilder = new StringBuilder();
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().equals("dates-2.json")) {
                        List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                        lines.forEach(line -> jsonBuilder.append(line));
                    }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return jsonBuilder.toString();
    }

    private static String depthParser() {
        depthBuilder = new StringBuilder();
        System.out.println(collectFiles.size());
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().equals("depths-1.json")) {
                    List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                    lines.forEach(line -> depthBuilder.append(line));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return depthBuilder.toString();
    }

    private static void jsonParser() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray dateArray = (JSONArray)parser.parse(dateParser());
            JSONArray depthArray = (JSONArray)parser.parse(depthParser());
            getDate(dateArray);
            getDepth(depthArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void getDate(JSONArray dateArray) {
        dateArray.forEach(o -> { JSONObject object = (JSONObject) o;
            String date = object.get("date").toString();
            String name = object.get("name").toString();
            dateCollect.put(name, date);
        });
    }

    private static  void  getDepth(JSONArray depthArray) {
        depthArray.forEach(o -> { JSONObject object = (JSONObject) o;
            String depth = object.get("depth").toString();
            String name = object.get("name").toString();
            depthCollect.put(name, depth);
        });

    }
}

