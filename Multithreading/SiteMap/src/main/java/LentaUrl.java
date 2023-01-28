

public class LentaUrl implements ParseLevel{

    private String childNameUrl;

    private String parentUrl;

    private String directory;


    public LentaUrl(String childNameUrl, String parentUrl, String directory) {
        this.childNameUrl = childNameUrl;
        this.parentUrl = parentUrl;
        this.directory = directory;
    }

    @Override
    public String getDirectory() {
        return directory;
    }
    @Override
    public String getParentUrl() {
        return parentUrl;
    }


    @Override
    public String toString() {
        return childNameUrl;
    }

    @Override
    public String getQuery() {
        return "a[class=card-full-news _subrubric]";
    }

    @Override
    public String getUrl() {
        return childNameUrl;
    }
}
