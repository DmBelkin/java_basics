import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultWriter {

    private Metro metro;

    public ResultWriter(Metro metro) {
        this.metro = metro;
        try {
            fileWriterMetroMap(metro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWriterMetroMap(Metro metro) throws IOException {
        File mapFile = new File("out/map.json");
        File stationsFile = new File("out/stations.json");
        PrintWriter writer = new PrintWriter(mapFile);
        JSONObject metroObject = new JSONObject();
        JSONArray fullStationsArray = new JSONArray();
        for (Line line : metro.getLines()) {
            JSONObject lineObject = new JSONObject();
            JSONArray stationArray = new JSONArray();
            for (Station station : line.getStations()) {
                JSONObject object = new JSONObject();
                object.put("name", station.getName());
                object.put("line", station.getLine().getName());
                object.put("date", station.getDate() + "");
                object.put("hasConnection", station.getHasConnetion());
                object.put("depth", station.getDepth());
                stationArray.add(object);
                fullStationsArray.add(object);
            }
            lineObject.put("number", line.getNumber());
            lineObject.put("stations", stationArray);
            metroObject.put(line.getName(), lineObject);
        }
        metroObject.writeJSONString(writer);
        writer.flush();
        writer.close();
        writer = new PrintWriter(stationsFile);
        fullStationsArray.writeJSONString(writer);
        writer.flush();
        writer.close();
    }

}
