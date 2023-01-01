
import java.io.File;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        int coreAmount = Runtime.getRuntime().availableProcessors();

        String srcFolder = "C:/Desktop/images";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        try {
            ArrayList<File> collect = new ArrayList<>();
            int startIndex = 0;
            for (int i = 0; i <= files.length - 1; i++) {
                collect.add(files[i]);
                if (i % coreAmount == 0 || i == files.length - 1) {
                    Resizer resizer = new Resizer(new ArrayList<>(collect.
                            subList(startIndex, i)));
                    resizer.start();
                    startIndex += coreAmount;
                    if (startIndex > collect.size() - 1) {
                        startIndex = collect.size() - 1;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
