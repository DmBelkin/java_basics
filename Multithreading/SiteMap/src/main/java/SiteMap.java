import java.util.*;

public class SiteMap {

    private Set<ParseLevel> firstLevel = new HashSet<>();
    private Set<ParseLevel> subLevel = new HashSet<>();

    private Set<ParseLevel> thirdLevel = new HashSet<>();
    private StringBuilder siteMap = new StringBuilder().append("https://lenta.ru/" + "\n");


    public synchronized void setLevel (ParseLevel parseLevel) {
        if (parseLevel.getDirectory().equals("directory")) {
            System.out.println("1");
            firstLevel.add(parseLevel);
        }
        else if (parseLevel.getDirectory().equals("subdirectory")) {
            System.out.println("2");
            subLevel.add(parseLevel);
        }
        else if (parseLevel.getDirectory().equals("news")){
            System.out.println("3");
            thirdLevel.add(parseLevel);
        }
    }

    public void mapper() {
        for (ParseLevel parseLevel : firstLevel) {
            System.out.println("+++");
            siteMap.append("\s" + parseLevel.getUrl() + "\n");
            for (ParseLevel parseLevel1 : subLevel) {
                if (parseLevel1.getParentUrl().equals(parseLevel.getUrl())) {
                    siteMap.append("\s\s" + parseLevel1.getUrl() + "\n");
                    for (ParseLevel parseLevel2 : thirdLevel) {
                        if (parseLevel1.getUrl().equals(parseLevel2.getParentUrl()))
                        siteMap.append("\s\s\s\s\s" + parseLevel2.getUrl() + "\n");
                    }
                }
            }
        }
    }

    public StringBuilder getSiteMap() {
        return siteMap;
    }

    @Override
    public String toString() {
        return siteMap.toString();
    }
}
