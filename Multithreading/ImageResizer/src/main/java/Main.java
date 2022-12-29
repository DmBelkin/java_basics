
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:/Users/Дима и Ната/Desktop/images";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        try {
            ArrayList<File> collect = new ArrayList<>();
            for (File file : files) {
                collect.add(file);
            }
            Resizer resizer1 = new Resizer(new ArrayList<>(collect.subList(0, collect.size() / 2)));
            resizer1.start();

            Resizer resizer2 = new Resizer(new ArrayList<>(collect.subList(collect.size() / 2,
                    (collect.size()) - 1)));
            resizer2.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }

}
