import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class Parser extends RecursiveTask<Set<ParseLevel>> {


    private volatile ParseLevel level;

    private SiteMap siteMap;

    public Parser(ParseLevel level, SiteMap siteMap) {
        this.level = level;
        this.siteMap = siteMap;
    }

    @Override
    public Set<ParseLevel> compute() {
        List<Parser> taskList = new ArrayList<>();
        Set<ParseLevel> set = new HashSet<>();
        try {
            Document document = Jsoup.connect(level.getUrl()).userAgent("Mozilla").get();
            Elements elements = document.select(level.getQuery());
            for (Element element : elements) {
                String urlChildName = element.absUrl("href");
                if (element.attr("href").startsWith("http") ||
                        urlChildName.equals("") || urlChildName.equals("/")) {
                    continue;
                }
                String[] ary = element.attr("href").split("/");
                if (ary.length == 3) {
                    Url url = new Url(urlChildName, level.getUrl(), "directory");
                    siteMap.setLevel(url);
                    set.add(url);
                    Parser parser = new Parser(url, siteMap);
                    parser.fork();
                    taskList.add(parser);
                } else if (ary.length == 4) {
                    LentaUrl lentaUrl = new LentaUrl(urlChildName, level.getUrl(), "subdirectory");
                    set.add(lentaUrl);
                    Parser parser = new Parser(lentaUrl, siteMap);
                    parser.fork();
                    taskList.add(parser);
                } else {
                    siteMap.setLevel(new LentaUrl(urlChildName, level.getUrl(), "news"));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (Parser parser : taskList) {
            for (ParseLevel parseLevel : parser.join()) {
                siteMap.setLevel(parseLevel);
            }
        }
        return set;
    }
}
