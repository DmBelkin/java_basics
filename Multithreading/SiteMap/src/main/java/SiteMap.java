
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class SiteMap {


    private Set<String> controlSet;
    private Set<String> linkSet;

  public SiteMap() {
      linkSet = new CopyOnWriteArraySet<>();
      controlSet = new CopyOnWriteArraySet<>();
  }


    public void setLinkSet(String url) {
        linkSet.add(url);
        if (linkSet.size() % 1000 == 0 && linkSet.size() > 0 ) {
            StringBuilder builder = new StringBuilder();
            for (String u : linkSet) {
                builder.append(u + "\n");
            }
            fileWriter(builder);
            linkSet.clear();
        }
    }

    public Set<String> getControlSet() {
        return controlSet;
    }

    public void setControlSet(String url) {
        controlSet.add(url);
    }

    public void fileWriter(StringBuilder stringBuilder) {
        try {
            String[] arr = stringBuilder.toString().split("\n");
            FileWriter writer = new FileWriter("data/sitemap.txt", true);
            for (String link : arr) {
                writer.write(link + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
