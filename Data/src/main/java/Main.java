
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    private static final Metro metro = new Metro();
    private static final String file = "data/data";

    private static String path = "";
    private static final TreeMap<String, String> depthCollect = new TreeMap<>();
    private static final TreeMap<String, String> dateCollect = new TreeMap<>();
    private static final ArrayList<File> collectFiles = new ArrayList<>();


    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
            Elements stations = document.select("p");
            Elements lines = document.select(".t-icon-metroln[data-line]");
            parseLine(lines);
            parseStations(stations);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        getMetroJson(metro);
        getStationsJson(metro);
    }

    private static void parseLine(Elements lines) {
        for (Element element : lines) {
            String lineName = element.text();
            String numberRegex = "[\"D0-9A-D]{3,5}";
            Pattern pattern = Pattern.compile(numberRegex);
            Matcher matcher = pattern.matcher(element.toString());
            String lineNumber = "";
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                lineNumber = element.toString().substring(start, end);
            }
            metro.setLines(new Line(lineNumber, lineName));
        }
        fileReader();
    }

    private static void parseStations(Elements stations) {
        int check = 0;
        for (int i = 0; i <= metro.getLines().size() - 1; ) {
            Line line = metro.getLines().get(i);
            for (int j = check; j <= stations.size() - 1; j++) {
                Element element = stations.get(j);
                int stationNumber = Integer.parseInt("" + element.text().substring(0,
                        element.text().indexOf('.')));
                if (!line.getStations().isEmpty() && stationNumber == 1) {
                    i++;
                    break;
                }
                String depth = "";
                String date = "";
                String[] nameAry = element.text().split("\\.");
                String stationName = nameAry[1].trim();
                boolean hasConnection = false;
                if (element.toString().contains("переход")) {
                    hasConnection = true;
                }
                for (Map.Entry<String, String> entry : dateCollect.entrySet()) {
                    if (entry.getKey().equals(stationName)) {
                        date = entry.getValue();
                    }
                }
                for (Map.Entry<String, String> entry : depthCollect.entrySet()) {
                    if (entry.getKey().equals(stationName)) {
                        depth = Character.isDigit(entry.getValue().charAt(0)) ? entry.getValue()
                                : entry.getValue().replace("" + entry.getValue().charAt(0), "-");
                    }
                }
                line.addStations(new Station(stationNumber, depth, stationName, line, date, hasConnection));
                metro.setStations(new Station(stationNumber, depth, stationName, line, date, hasConnection));
                if (check == stations.size() - 1) {
                    i++;
                    break;
                }
                check++;
            }
        }
        System.out.println(metro);
        System.out.println(metro.getStations().size());
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

    private static String jsonDateParser() {
        StringBuilder jsonDateBuilder = new StringBuilder();
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().contains("dates") && file1.getName().contains(".json")) {
                    List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                    lines.forEach(line -> jsonDateBuilder.append(line));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return jsonDateBuilder.toString();
    }

    private static String jsonDepthParser() {
        StringBuilder jsonDepthBuilder = new StringBuilder();
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().equals("depths-1.json")) {
                    List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                    lines.forEach(line -> jsonDepthBuilder.append(line));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return jsonDepthBuilder.toString();
    }

    private static ArrayList<String> cswDateParser() {
        ArrayList<String> collect = new ArrayList<>();
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().contains("dates") && file1.getName().contains(".csv")) {
                    List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                    lines.forEach(line -> collect.add(line));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return collect;
    }

    private static ArrayList<String> cswDepthParser() {
        ArrayList<String> collect = new ArrayList<>();
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().contains("depths") && file1.getName().contains(".csv")) {
                    List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                    lines.forEach(line -> collect.add(line));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return collect;
    }

    private static void jsonParser() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray dateArray = (JSONArray) parser.parse(jsonDateParser());
            JSONArray depthArray = (JSONArray) parser.parse(jsonDepthParser());
            getDate(dateArray);
            getDepth(depthArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        cswGetDate(cswDateParser());
        cswGetDepth(cswDepthParser());
    }

    private static void cswGetDate(ArrayList<String> collect) {
        for (int i = 0; i <= collect.size() - 1; i++) {
            String[] array = collect.get(i).split(",");
            dateCollect.put(array[0].trim(), array[1].trim());
        }
    }

    private static void cswGetDepth(ArrayList<String> collect) {
        for (int i = 0; i <= collect.size() - 1; i++) {
            String[] array = collect.get(i).split(",");
            depthCollect.put(array[0].trim(), array[1].trim());
        }
    }

    private static void getDate(JSONArray dateArray) {
        dateArray.forEach(o -> {
            JSONObject object = (JSONObject) o;
            String date = object.get("date").toString();
            String name = object.get("name").toString();
            dateCollect.put(name, date);
        });
    }

    private static void getDepth(JSONArray depthArray) {
        depthArray.forEach(o -> {
            JSONObject object = (JSONObject) o;
            String depth = object.get("depth").toString();
            String name = object.get("name").toString();
            depthCollect.put(name, depth);
        });
    }

    private static void getMetroJson(Metro metro) {
        JSONObject fullObject = new JSONObject();
        for (int i = 0; i <= metro.getLines().size() - 1; i++) {
            Line line = metro.getLines().get(i);
            JSONArray lineArray = new JSONArray();
            lineArray.add(0, "name: " + line.getName());
            lineArray.add(1, "number: " + line.getNumber());
            JSONArray stationsArray = new JSONArray();
            for (int j = 0; j <=line.getStations().size() - 1; j++) {
                Station station = line.getStations().get(j);
                JSONObject stationObject = new JSONObject();
                stationObject.put("name: " , station.getName());
                if (!station.getDate().equals("")) {
                    stationObject.put("date: ", station.getDate());
                }
                if (!station.getDepth().equals("")) {
                    stationObject.put("depth: ", station.getDepth());
                }
                stationObject.put("hasConnection: " , station.getHasConnetion());
                stationObject.put("number: " , station.getNumber());
                stationObject.put("line: ", station.getLine().getName());
                stationsArray.add(j, stationObject);
            }
            fullObject.put(lineArray, stationsArray);
        }
        JSONObject object = new JSONObject(fullObject);
        try {
            PrintWriter writer = new PrintWriter("data/metro.json");
            object.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void getStationsJson (Metro metro) {
        JSONArray array = new JSONArray();
        for (int i = 0; i <= metro.getStations().size() - 1; i++) {
            Station station = metro.getStations().get(i);
           JSONObject stationObject = new JSONObject();
           stationObject.put("name: ", station.getName());
           stationObject.put("line: ", station.getLine().getName());
            if (!station.getDate().equals("")) {
                stationObject.put("date: ", station.getDate());
            }
            if (!station.getDepth().equals("")) {
                stationObject.put("depth: ", station.getDepth());
            }
           stationObject.put("hasConnection", station.getHasConnetion());
           stationObject.put("number: ", station.getNumber());
           array.add(i, stationObject);
        }
        try {
            PrintWriter writer = new PrintWriter("data/stations.json");
            array.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

