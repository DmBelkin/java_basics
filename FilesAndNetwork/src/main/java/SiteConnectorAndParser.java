import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SiteConnectorAndParser {

    private String url;

    private List<String[]> depthList;

    private List<String[]> dateList;

    public SiteConnectorAndParser(String url) {
        this.url = url;
        depthList = new ArrayList<>();
        dateList = new ArrayList<>();
        getConnection(url);
    }

    public void getConnection(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements lines = document.select("#metrodata > div > " +
                    "div.js-toggle-depend.s-depend-control-single");
            Elements stations = document.select("#metrodata > div > " +
                    "div.js-depend");
            Metro metro = new Metro();
            metroForming(lines, stations, metro);
            ResultWriter writer = new ResultWriter(metro);
            System.out.println(metro);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getDataFromFolder() {
        FolderSearcher searcher = new FolderSearcher("data/data");
        CsvParser csvParser = new CsvParser(searcher);
        depthList.addAll(searcher.getParser().getDepthList());
        depthList.addAll(csvParser.getDepthList());
        dateList.addAll(searcher.getParser().getDateList());
        dateList.addAll(csvParser.getDateList());
    }


    public void metroForming(Elements lines, Elements stations, Metro metro) {
        for (Element element : lines) {
            Line line = new Line();
            line.setName(element.text());
            String[] lineRow = element.attr("data-depend").split("-");
            String lineNumber = lineRow[lineRow.length - 1].replaceAll("'", "").
                    replaceAll("}", "").trim();
            line.setNumber(lineNumber);
            metro.setLines(line);
            getDataFromFolder();
            List<Station> stationsToLine = stationParser(stations, line, metro);
            setDatesAndDepths(metro);
            line.setStations(stationsToLine);
        }
    }

    public List<Station> stationParser(Elements stations, Line line, Metro metro) {
        List<Station> result = new ArrayList<>();
        for (Element element : stations) {
            String lineNumber = element.children().attr("data-line").trim();
            if (lineNumber.equals(line.getNumber())) {
                Elements elements = element.getElementsByClass("single-station");
                for (Element element1 : elements) {
                    Station station = new Station();
                    station.setLine(line);
                    String[] stationData = element1.text().split("\\.");
                    station.setName(stationData[1].trim());
                    station.setNumber(Integer.parseInt(stationData[0]));
                    if (!element1.getElementsByClass("t-icon-metroln")
                            .attr("title").equals("")) {
                        station.setHasConnection(true);
                    }
                    result.add(station);
                    metro.setStations(station);
                }
            }
        }
        return result;
    }

    public void setDatesAndDepths(Metro metro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (Station station : metro.getStations()) {
            for (int i = 0; i <= depthList.size() - 1; i++) {
                String[] data = depthList.get(i);
                if (data[1].equals(station.getName())) {
                    if (getDuplicates(metro, station)) {
                        depthList.remove(data);
                        continue;
                    }
                    String num = data[0].trim();
                    if (num.contains(",")) {
                        num = num.replaceAll(",", "\\.");
                    }
                    if (!Character.isDigit(num.charAt(0))) {
                        num = num.substring(1);
                        num = "-" + num;
                        if (num.length() == 1) {
                            num = "0";
                        }
                    }
                    station.setDepth(Double.parseDouble(num));
                }
            }
            for (int j = 0; j <= dateList.size() - 1; j++) {
                String[] data = dateList.get(j);
                if (data[0].equals(station.getName())) {
                    if (getDuplicates(metro, station)) {
                        depthList.remove(data);
                        continue;
                    }
                    LocalDate date = LocalDate.parse(data[1].trim().
                            replaceAll("\\.", "\\."), formatter);
                    station.setDate(date);
                }
            }
        }
    }

    public boolean getDuplicates(Metro metro, Station station) {
        for (Station station1 : metro.getStations()) {
            if (station1.getName().equals(station.getName()) && !station1.equals(station)) {
                if (station.getDate() != null || station.getDepth() > 0) {
                    return true;
                }
            }
        }
        return false;
    }


}
