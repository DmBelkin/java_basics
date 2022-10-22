
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
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
        for (int i = 0; i <= metro.getLines().size() - 1;) {
            Line line = metro.getLines().get(i);
            for (int j = check; j <= stations.size() - 1; j ++) {
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
                if (check == stations.size() - 1) {
                    i++;
                    break;
                }
                check++;
            }
        }
        System.out.println(depthCollect.size());
        System.out.println(dateCollect.size());
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
        StringBuilder jsonBuilder = new StringBuilder();
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
        StringBuilder depthBuilder = new StringBuilder();
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
            JSONArray dateArray = (JSONArray) parser.parse(dateParser());
            JSONArray depthArray = (JSONArray) parser.parse(depthParser());
            getDate(dateArray);
            getDepth(depthArray);
        } catch (Exception ex) {
            ex.printStackTrace();
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
}

