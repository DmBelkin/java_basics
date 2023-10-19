import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveAction;

public class Parser extends RecursiveAction {


    private SiteMap siteMap;

    private String url;

    public Parser(SiteMap siteMap, String url) {
        this.siteMap = siteMap;
        this.url = url;
    }

    @Override
    public void compute() {
        List<Parser> taskList = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).userAgent("Mozilla/5.0" +
                    " (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                    " Chrome/116.0.0.0 Safari/537.36").ignoreHttpErrors(true).get();
            Elements elements = document.select("a");
            for (Element element : elements) {
                String url = element.absUrl("href");
                String[] parseWidth = element.attr("href").split("/");
                if (!url.startsWith(this.url) || siteMap.getControlSet().contains(url) ||
                        url.contains("#") || parseWidth.length > 6) {
                    continue;
                }
                System.out.println(url);
                siteMap.setLinkSet(getSpaces(parseWidth.length) + url);
                siteMap.setControlSet(url);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (taskList.size() > 252) {
                    joiner(taskList);
                    taskList.clear();
                }
                Parser parser = new Parser(siteMap, url);
                parser.fork();
                taskList.add(parser);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        joiner(taskList);
    }

    public void joiner(List<Parser> taskList) {
        for (Parser parser : taskList) {
            parser.join();
        }
    }

    public static String getSpaces(int count) {
        String result = "";
        for (int i = 0; i <= count; i++) {
            result += "\s";
        }
        return result;
    }
}
