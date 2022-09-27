import com.sun.source.tree.NewArrayTree;
import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class RouteCalculatorTest extends TestCase {
    private final Line line3 = new Line(3, "Невско - Васиеоостровская");
    private final Line line5 = new Line(2, "Московско - Петроградская");
    private final Line line4 = new Line(4, "Правобережная");
    private final Line line2 = new Line(2,"Московско - Петроградская");
    private final StationIndex stationIndex = new StationIndex();
    private final RouteCalculator calculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception {

        String[] fourLineStations = {"Спасская", "Достоевская", "Лиговский проспект",
                "Площадь Александра Невского", "Новочеркасская"};

        String[] fiveLineStations = {"Садовая", "Звенигородская", "Обводный канал", "Волковская",
                "Бухарестская"};

        String[] threeLineStations = { "Василеостровская", "Гостиный двор", "Маяковская",
                "Площадь Александра Невского", "Елизаровская"};

        String[] twoLineStations = { "Горьковская", "Невский проспект", "Сенная площадь",
                "Технологический институт", "Фрунзенская"};

        stationIndex.addLine(line4);
        stationIndex.addLine(line5);
        stationIndex.addLine(line3);
        stationIndex.addLine(line2);
        for (int i = 0; i <= fourLineStations.length - 1; i++) {
            Station station = new Station(fourLineStations[i], line4);
            stationIndex.addStation(station);
            line4.addStation(station);
            Station station1 = new Station(fiveLineStations[i], line5);
            stationIndex.addStation(station1);
            line5.addStation(station1);
            Station station2 = new Station(threeLineStations[i], line3);
            stationIndex.addStation(station2);
            line3.addStation(station2);
            Station station3 = new Station(twoLineStations[i], line2);
            stationIndex.addStation(station3);
            line2.addStation(station3);
        }
        stationIndex.addConnection(new ArrayList<>() {
            {
                add(new Station("Площадь Восстания", line4));
                add(new Station("Маяковская", line3));
            }
        });
        stationIndex.addConnection(new ArrayList<>() {
            {
                add(new Station("Площадь Александра Невского", line3));
                add(new Station("Площадь Александра Невского", line4));
            }
        });
        stationIndex.addConnection(new ArrayList<>() {
            {
                add(new Station("Невский проспект", line2));
                add(new Station("Гостиный двор", line3));
            }
        });
        stationIndex.addConnection(new ArrayList<>() {
            {
                add(new Station("Сенная площадь", line2));
                add(new Station("Спасская", line4));
                add(new Station("Садовая", line5));
            }
        });
    }

    public void testRouteDurationTest() { //routeDuration
        ArrayList<Station> collect = new ArrayList<>() {{
            add(new Station("Спасская", line4));
            add(new Station("Достоевская", line4));
            add(new Station("Лиговский проспект", line4));
            add(new Station("Площадь Александра Невского", line4));
            add(new Station("Новочеркасская", line4));
        }};
        assertEquals(10.0, RouteCalculator.calculateDuration(collect));
    }

    public void testGetShortestRoute() { //getRouteWithOneConnection
        Station from = new Station("Гостиный двор", line3);
        Station to = new Station("Ладожская", line4);
        ArrayList<Station> collect = new ArrayList<>() {{
            add(new Station("Гостиный двор", line3));
            add(new Station("Маяковская", line3));
            add(new Station("Площадь Александра Невского", line3));
            add(new Station("Площадь Александра Невского", line4));
            add(new Station("Новочеркасская", line4));
        }};
        assertEquals(collect, calculator.getShortestRoute(from, to));
    }

    public void testGetRouteOnTheLine() { //withoutConnection
        Station from = new Station("Василеостровская", line3);
        Station to = new Station("Елизаровская", line3);
        ArrayList<Station> collect = new ArrayList<>() {{
            add(new Station("Василеостровская", line3));
            add(new Station("Гостиный двор", line3));
            add(new Station("Маяковская", line3));
            add(new Station("Площадь Александра Невского", line3));
            add(new Station("Елизаровская", line3));
        }};
        assertEquals(collect, calculator.getShortestRoute(from, to));
    }

    public void testGetRouteWithTwoConnections() { //getRouteWithTwoConnection
        Station from = new Station("Василеостровская", line3);
        Station to = new Station("Обводный канал", line5);
        ArrayList<Station> collect = new ArrayList<>() {{
            add(new Station("Василеостровская", line3));
            add(new Station("Гостиный двор", line3));
            add(new Station("Невский проспект", line2));
            add(new Station("Сенная площадь", line2));
            add(new Station("Садовая", line5));
            add(new Station("Звенигородская", line5));
            add(new Station("Обводный канал", line5));
        }};
        assertEquals(collect, calculator.getShortestRoute(from, to));
    }
}
