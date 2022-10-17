
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Metro metro = new Metro();
    private static final String LINE_REGEX = "[А-Я-]{3}+[0-9]{1}$";
    private static final String file = "Data/data";
    private static String path = "";
    private static final ArrayList<File> collectFiles = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
            Elements elements = document.select("h2");
            //parseLine(elements);
            //parseStations(elements);
            fileReader();
            fileParser(collectFiles);
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
        System.out.println(collectFiles);
        return collectFiles;
    }

    private static void fileParser(ArrayList<File> collectFiles) {
        for (File file1 : collectFiles) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(file1.getPath()));
                System.out.println(lines);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

