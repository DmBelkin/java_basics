
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        SiteMap siteMap = new SiteMap();
        Parser parser = new Parser(new ParseLevel() {
            @Override
            public String getQuery() {
                return "a[class=menu__nav-link _is-extra]";
            }

            @Override
            public String getUrl() {
                return "https://lenta.ru/";
            }

            @Override
            public String getParentUrl() {
                return "";
            }
            @Override
            public String getDirectory() {
                return "site";
            }
        }, siteMap);
        Set<ParseLevel> list =  new ForkJoinPool().invoke(parser);
        siteMap.mapper();
        System.out.println(siteMap.getSiteMap());
        System.out.println(siteMap.getCount());
        fileWriter(siteMap.getSiteMap());
    }

    private static void fileWriter(StringBuilder stringBuilder) {
        try {
            String[] arr = stringBuilder.toString().split("\n");
            PrintWriter printWriter = new PrintWriter("data/sitemap.txt");
            for (String link : arr) {
                printWriter.write(link + "\n");
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
