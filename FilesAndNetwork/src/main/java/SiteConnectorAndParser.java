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
        JsonParser parser = new JsonParser(searcher);
        CsvParser csvParser = new CsvParser(searcher);
        depthList.addAll(parser.getDepthList());
        depthList.addAll(csvParser.getDepthList());
        dateList.addAll(parser.getDateList());
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
            line.setStations(stationsToLine);
        }
    }

    public List<Station> stationParser(Elements stations, Line line, Metro metro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<Station> result = new ArrayList<>();
        for (Element element : stations) {
            String lineNumber = element.children().attr("data-line").trim();
            if (lineNumber.equals(line.getNumber())) {
                Elements elements = element.getElementsByClass("single-station");
                for (Element element1 : elements) {
                    Station station = new Station();
                    String[] stationData = element1.text().split("\\.");
                    station.setName(stationData[1].trim());
                    station.setNumber(Integer.parseInt(stationData[0]));
                    if (!element1.getElementsByClass("t-icon-metroln")
                            .attr("title").equals("")) {
                        station.setHasConnection(true);
                    }
                    station.setLine(line);
                    for (String[] data : depthList) {
                        if (data[1].equals(station.getName())) {
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
                    for (String[] data : dateList) {
                        if (data[0].equals(station.getName())) {
                            LocalDate date = LocalDate.parse(data[1].trim().
                                    replaceAll("\\.", "\\."), formatter);
                            station.setDate(date);
                        }
                    }
                    result.add(station);
                    metro.setStations(station);
                }
            }
        }
        return result;
    }
}
