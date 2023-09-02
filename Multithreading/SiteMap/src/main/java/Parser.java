import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class Parser extends RecursiveTask<Set<String>> {


    private SiteMap siteMap;

    private String url;

    public Parser(SiteMap siteMap, String url) {
        this.siteMap = siteMap;
        this.url = url;
    }

    @Override
    public Set<String> compute() {
        List<Parser> taskList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        try {
            Document document = Jsoup.connect(url).userAgent("Mozilla/5.0" +
                    " (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                    " Chrome/116.0.0.0 Safari/537.36").get();
            Elements elements = document.select("a");
            for (Element element : elements) {
                String url = element.absUrl("href");
                String[] parseWidth = element.attr("href").split("/");
                if (!url.startsWith("https://lenta.") ||
                        siteMap.getControlSet().contains(url) || url.contains("#") || parseWidth.length > 6) {
                    continue;
                }
                System.out.println(url);
                siteMap.setLinkSet(getSpaces(parseWidth.length) + url);
                siteMap.setControlSet(url);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Parser parser = new Parser(siteMap, url);
                parser.fork();
                taskList.add(parser);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (Parser parser : taskList) {
            for (String url : parser.join()) {
                siteMap.setLinkSet(url);
            }
        }
        return set;
    }

    public static String getSpaces(int count) {
        String result = "";
        for (int i = 0; i <= count; i++) {
            result += "\s";
        }
        return result;
    }

}
