
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String url = "https://lenta.ru/";

    public static void main(String[] args) {
        SiteMap siteMap = new SiteMap();
        Parser parser = new Parser(siteMap, url);
        Set<String> urlsSet = new ForkJoinPool().invoke(parser);
        System.out.println(urlsSet.size());
    }

}
