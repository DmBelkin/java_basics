

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Url implements  ParseLevel{

    private String url;

    private ParseLevel parentElement;

    private String parentUrl;
    private volatile String directory;


    public Url (String url, ParseLevel parentElement, String directory) {
        this.url = url;
        this.parentElement = parentElement;
        this.directory = directory;
        setParentUrl(parentElement);
    }

    public String getDirectory() {
        return directory;
    }


    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(ParseLevel parentElement) {
        parentUrl = parentElement.getUrl();
    }

    @Override
    public String getQuery() {
         if (parentElement.getDirectory().equals("site")) {
             if (url.contains("photo")) {
                 return "a[class=card-photo]";
             }
             else if (url.contains("video")) {
                 return "a[class=card-big _parts-video _video]";
             }
            return "a[class=rubric-header__link]";
        }
        else if (parentElement.getDirectory().equals("directory")) {
            if (url.contains("mycountry")) {
                return "a[class=rubric-header__link]";
            }
            return "a[class=card-full-news _subrubric]";
        }
        else if (parentElement.getDirectory().equals("subdirectory")) {
             return "a[class=card-full-news _subrubric]";
         }
        return "unknown";
    }
    @Override
    public boolean containsDate() {
        String dateRegex = "\\/" + "[0-9]{4}" + "\\/" + "[0-9]{2}" +"\\/" + "[0-9]{2}";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String date = url.substring(start, end);
            if (!date.equals("")) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        System.out.println();
        return "parent: " + parentUrl + "\n" +
                "child: " + url + "\n" +
                "directory: " + directory;
    }
}
