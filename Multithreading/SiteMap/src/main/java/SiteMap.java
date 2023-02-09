

import java.util.*;
import java.util.stream.Collectors;

public class SiteMap {

    private Set<ParseLevel> firstLevel = new HashSet<>();
    private  Set<ParseLevel> subLevel = new HashSet<>();
    private Set<ParseLevel> thirdLevel = new HashSet<>();
    private StringBuilder siteMap = new StringBuilder().append("https://lenta.ru/" + "\n");

    private int count = 0;


    public void setLevel(ParseLevel parseLevel) {
        if (parseLevel.getDirectory().equals("directory")) {
            firstLevel.add(parseLevel);
        } else if (parseLevel.getDirectory().equals("subdirectory")) {
            subLevel.add(parseLevel);
        } else if (parseLevel.getDirectory().equals("news")) {
            thirdLevel.add(parseLevel);
        }
    }

    public void mapper() {
        for (ParseLevel url : firstLevel) {
            siteMap.append("\s" + url.getUrl() + "\n");
            count++;
            for (ParseLevel url4 : thirdLevel) {
                if (url.getUrl().equals(url4.getParentUrl())) {
                    siteMap.append("\s\s\s\s\s" + url4.getUrl() + "\n");
                    count++;
                }
            }
            for (ParseLevel url1 : subLevel) {
                if (url1.getParentUrl().equals(url.getUrl())) {
                    siteMap.append("\s\s" + url1.getUrl() + "\n");
                    count++;
                    for (ParseLevel url2 : thirdLevel) {
                        if (url1.getUrl().equals(url2.getParentUrl())) {
                            siteMap.append("\s\s\s\s\s" + url2.getUrl() + "\n");
                            count++;
                        }
                    }
                }
            }
        }
        for (ParseLevel url1 : subLevel) {
            if (url1.getUrl().contains("mycountry")) {
                siteMap.append("\s\s" + url1.getUrl() + "\n");
                count++;
                for (ParseLevel url2 : thirdLevel) {
                    if (url1.getUrl().equals(url2.getParentUrl())) {
                        siteMap.append("\s\s\s\s\s" + url2.getUrl() + "\n");
                        count++;
                    }
                }
            }
        }
    }

    public StringBuilder getSiteMap() {
        return siteMap;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return siteMap.toString();
    }
}
