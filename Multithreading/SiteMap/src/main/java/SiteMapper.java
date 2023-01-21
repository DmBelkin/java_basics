import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.IIOException;
import java.io.*;
import java.sql.SQLTransactionRollbackException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SiteMapper {

    private static String mainURL = "https://lenta.ru/";

    private static List<String> siteMap = new ArrayList<>() {{
        add(mainURL + "\n");
    }};

    private static String[] query = {
            "a[class=menu__nav-link _is-extra]",
            "a[class=rubric-header__link]",
            "a[class=card-full-news _subrubric]"
    };

    private static Set<Element> set = new HashSet<>();

    public static void main(String[] args) {
        Elements elements = getDocs(mainURL, query[0]);
        elements.remove(0);
        for (Element element : elements) {
            mapper(element);
            System.out.println(element.text());
        }
        System.out.println(siteMap);
        System.out.println(siteMap.size());
    }

    public static Elements getDocs(String url, String query) {
        try {
            Document document = Jsoup.connect(url).userAgent("Mozilla").get();
            Elements linksMenu = document.select(query);
            return linksMenu;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new Elements();
    }

    public static void mapper(Element element) {
        try {
            Thread.sleep((int) (10 * Math.random()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        siteMap.add("\s\s" + element.absUrl("href") + "\n");
        Elements elements = getDocs(element.absUrl("href"), query[1]);
        for (Element element1 : elements) {
            siteMap.add("\s\s\s\s\s\s" + element1.absUrl("href") + "\n");
            Elements elements1 = getDocs(element1.absUrl("href"), query[2]);
            for (Element element2 : elements1) {
                siteMap.add("\s\s\s\s\s\s\s\s\s" + element2.absUrl("href") + "\n");
            }
        }
    }
}

