
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static  String file = "data/data";

    private static final ArrayList<String[]> depthCollect = new ArrayList<>();
    private static final ArrayList<String[]> dateCollect = new ArrayList<>();
    private static final ArrayList<File> collectFiles = new ArrayList<>();


    public static void main(String[] args) {
        Metro metro = new Metro();
        try {
            Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
            Elements stations = document.select("p");
            Elements lines = document.select(".t-icon-metroln[data-line]");
            parseLine(lines, metro);
            parseStations(stations, metro);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        getMetroJson(metro);
        getStationsJson(metro);
    }

    private static void parseLine(Elements lines, Metro metro) {
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
        jsonParser(fileReader(file));
    }

    private static void parseStations(Elements stations, Metro metro) {
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
                double depth;
                LocalDate date = LocalDate.now();
                String[] nameAry = element.text().split("\\.");
                String stationName = nameAry[1].trim();
                boolean hasConnection = false;
                if (element.toString().contains("переход")) {
                    hasConnection = true;
                }
                for (String[] arr : dateCollect) {
                    if (arr[0].equals(stationName) && !arr[1].isEmpty()) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        try {
                            date = LocalDate.parse(arr[1].toLowerCase().
                                    trim().replaceAll("\\.", "."), formatter);
                            System.out.println(date);
                        } catch (DateTimeParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                depth = depthParser(stationName);
                line.addStations(new Station(stationNumber, depth, stationName, line, date, hasConnection));
                metro.setStations(new Station(stationNumber, depth, stationName, line, date, hasConnection));
                if (check == stations.size() - 1) {
                    i++;
                    break;
                }
            }
        }
        System.out.println(metro);
        System.out.println(depthCollect.size());
        System.out.println(dateCollect.size());
        System.out.println(metro.getStations().size());
    }

    private static Double depthParser(String stationName) {
        double depth = 0;
        for (String[] arr : depthCollect) {
            if (arr[0].equals(stationName)) {
                String depthS = arr[1];
                String forParse = "";
                for (int f = 0; f <= depthS.length() - 1; f++) {
                    if (Character.isDigit(depthS.charAt(f))) {
                        forParse = forParse + depthS.charAt(f);
                    } else if (Character.toString(depthS.charAt(f)).equals(",")) {
                        forParse = forParse + ".";
                    }
                }
                if (!forParse.isEmpty() && !forParse.equals("0")) {
                    try {
                        if (!Character.isDigit(depthS.trim().replaceAll("\"", "").charAt(0))) {
                            forParse = "-" + forParse;
                        }
                        depth = Double.parseDouble(forParse);
                    } catch (Exception ex) {
                        System.err.println(depthS);
                        ex.printStackTrace();
                    }
                }
            }
        }
        return depth;
    }


    private static ArrayList<File> fileReader(String path) {
        File dataFile = new File(file);
        for (File f : dataFile.listFiles()) {
            if (f.isFile()) {
                collectFiles.add(f);
            } else {
                file = f.getPath();
                fileReader(file);
            }
        }
        return collectFiles;
    }

    private static String jsonDateParser() {
        StringBuilder jsonDateBuilder = new StringBuilder();
        for (File file1 : collectFiles) {
            try {
                if (file1.getName().contains("dates") && file1.getName().contains(".json")) {
                    System.out.println(file1.getName());
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
                    System.out.println(file1.getName());
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
                    System.out.println(file1.getName());
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
                    System.out.println(file1.getName());
                    List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                    lines.forEach(line -> collect.add(line));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return collect;
    }

    private static void jsonParser(ArrayList<File> filereader) {
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
            dateCollect.add(new String[]{array[0].trim(), array[1].trim()});
        }
    }

    private static void cswGetDepth(ArrayList<String> collect) {
        for (int i = 0; i <= collect.size() - 1; i++) {
            String[] array = collect.get(i).split(",");
            depthCollect.add(new String[]{array[0].trim(), array[1].trim()});
        }
    }

    private static void getDate(JSONArray dateArray) {
        dateArray.forEach(o -> {
            JSONObject object = (JSONObject) o;
            String date = object.get("date").toString();
            String name = object.get("name").toString();
            dateCollect.add(new String[]{name, date});
        });
    }

    private static void getDepth(JSONArray depthArray) {
        depthArray.forEach(o -> {
            JSONObject object = (JSONObject) o;
            String depth = object.get("depth").toString();
            String name = object.get("name").toString();
            depthCollect.add(new String[]{name, depth});
        });
    }

    private static void getMetroJson(Metro metro) {
        JSONObject fullObject = new JSONObject();
        for (int i = 0; i <= metro.getLines().size() - 1; i++) {
            Line line = metro.getLines().get(i);
            JSONObject lineObject = new JSONObject();
            lineObject.put("name: " + line.getName(), "number: " + line.getNumber());
            JSONArray stationsArray = new JSONArray();
            for (int j = 0; j <= line.getStations().size() - 1; j++) {
                Station station = line.getStations().get(j);
                JSONObject stationObject = new JSONObject();
                stationObject.put("name: ", station.getName());
                if (!station.getDate().equals(LocalDate.now())) {
                    stationObject.put("date: ", station.getDate().toString());
                }
                if (station.getDepth() != 0) {
                    stationObject.put("depth: ", station.getDepth());
                }
                stationObject.put("hasConnection: ", station.getHasConnetion());
                stationObject.put("number: ", station.getNumber());
                stationObject.put("line: ", station.getLine().getName());
                stationsArray.add(j, stationObject);
            }
            fullObject.put(lineObject, stationsArray);
        }
        JSONObject object = new JSONObject(fullObject);
        try {
            PrintWriter writer = new PrintWriter("out/metro.json");
            object.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void getStationsJson(Metro metro) {
        JSONArray array = new JSONArray();
        for (int i = 0; i <= metro.getStations().size() - 1; i++) {
            Station station = metro.getStations().get(i);
            JSONObject stationObject = new JSONObject();
            stationObject.put("name: ", station.getName());
            stationObject.put("line: ", station.getLine().getName());
            if (!station.getDate().toString().equals("")) {
                stationObject.put("date: ", station.getDate().toString());
            }
            if (station.getDepth() != 0) {
                stationObject.put("depth: ", station.getDepth());
            }
            stationObject.put("hasConnection", station.getHasConnetion());
            stationObject.put("number: ", station.getNumber());
            array.add(i, stationObject);
        }
        try {
            PrintWriter writer = new PrintWriter("out/stations.json");
            array.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

