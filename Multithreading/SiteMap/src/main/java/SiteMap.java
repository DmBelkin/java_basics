import java.util.*;

public class SiteMap {

    private Set<ParseLevel> firstLevel = new HashSet<>();
    private Set<ParseLevel> subLevel = new HashSet<>();
    private Set<ParseLevel> thirdLevel = new HashSet<>();
    private StringBuilder siteMap = new StringBuilder().append("https://lenta.ru/" + "\n");

    private int count = 0;


    public void setLevel (ParseLevel parseLevel) {
        if (parseLevel.getDirectory().equals("directory")) {
            firstLevel.add(parseLevel);
        }
        else if (parseLevel.getDirectory().equals("subdirectory")) {
            subLevel.add(parseLevel);
        }
        else if (parseLevel.getDirectory().equals("news")){
            thirdLevel.add(parseLevel);
        }
    }

    public void mapper() {
        for (ParseLevel parseLevel : firstLevel) {
            siteMap.append("\s" + parseLevel.getUrl() + "\n");
            count++;
            for (ParseLevel parseLevel1 : subLevel) {
                if (parseLevel1.getParentUrl().equals(parseLevel.getUrl())) {
                    siteMap.append("\s\s" + parseLevel1.getUrl() + "\n");
                    count++;
                    for (ParseLevel parseLevel2 : thirdLevel) {
                        if (parseLevel1.getUrl().equals(parseLevel2.getParentUrl())) {
                            siteMap.append("\s\s\s\s\s" + parseLevel2.getUrl() + "\n");
                            count++;
                        }
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
