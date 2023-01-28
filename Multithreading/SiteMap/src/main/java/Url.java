

public class Url implements  ParseLevel{

    private String childUrl;
    private String parentUrl;
    private String directory;


    public Url (String childUrl, String parentUrl, String directory) {
        this.childUrl = childUrl;
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
        return childUrl;
    }

    @Override
    public String getQuery() {
        return "a[class=rubric-header__link]" ;
    }
    @Override
    public String getUrl() {
        return childUrl;
    }
}
