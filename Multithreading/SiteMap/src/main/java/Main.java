
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
        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        siteMap.mapper();
        System.out.println(siteMap.getSiteMap());
    }
}
