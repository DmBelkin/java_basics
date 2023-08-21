import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private final List<String[]> dateList;

    private final List<String[]> depthList;


    public JsonParser() {
        depthList = new ArrayList<>();
        dateList = new ArrayList<>();
    }

    public void setSource(StringBuilder builder) {
        jsonParser(builder);
    }

    public void jsonParser(StringBuilder builder) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(builder.toString());
            array.forEach(o -> {
                JSONObject object = (JSONObject) o;
                if (object.containsKey("date")) {
                    String date = object.get("date").toString();
                    String name = object.get("name").toString();
                    dateList.add(new String[]{date, name});
                } else if (object.containsKey("depth")) {
                    String depth = object.get("depth").toString();
                    String name = object.get("station_name").toString();
                    depthList.add(new String[]{depth, name});
                }
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getDateList() {
        return dateList;
    }

    public List<String[]> getDepthList() {
        return depthList;
    }

}
