import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FolderSearcher {

    private List<File> fileList;

    private String path;

    private JsonParser parser;

    private List<String> csvCollect;

    public FolderSearcher(String path) {
        this.path = path;
        fileList = new ArrayList<>();
        csvCollect = new ArrayList<>();
        folderReader(path);
        try {
            fileParser(fileList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<File> folderReader(String path) {
        File file = new File(path);
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                folderReader(file1.getPath());
            } else {
                fileList.add(file1);
            }
        }
        return fileList;
    }

    public void fileParser(List<File> fileList) throws IOException {
        parser = new JsonParser();
        for (File file : fileList) {
            boolean isCsv = file.getName().endsWith(".csv");
            boolean isJason = file.getName().endsWith(".json");
            if (isCsv || isJason) {
                List<String> fileRows = Files.readAllLines(Paths.get(file.getPath()));
                if (isJason) {
                    StringBuilder jsonBuilder = new StringBuilder();
                    for (String row : fileRows) {
                        jsonBuilder.append(row + "\n");
                    }
                    parser.setSource(jsonBuilder);
                } else if (isCsv) {
                    for (String row : fileRows) {
                        csvCollect.add(row + "\n");
                    }
                }
            }
        }
    }

    public List<String> getCsvCollect() {
        return csvCollect;
    }

    public JsonParser getParser() {
        return parser;
    }
}
