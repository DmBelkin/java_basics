import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    private FolderSearcher searcher;

    private List<String[]> dateList;

    private List<String[]> depthList;

    public CsvParser(FolderSearcher searcher) {
        this.searcher = searcher;
        dateList = new ArrayList<>();
        depthList = new ArrayList<>();
        csvParser(searcher.getCsvCollect());
    }


    public void csvParser(List<String> csvCollect) {
        for (String line : csvCollect) {
            String[] data = line.split(",");
            if (data[1].length() > 4) {
                dateList.add(data);
            } else {
                depthList.add(data);
            }
        }
    }

    public List<String[]> getDateList() {
        return dateList;
    }

    public List<String[]> getDepthList() {
        return depthList;
    }

}
