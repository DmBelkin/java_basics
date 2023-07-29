import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler extends DefaultHandler {

    private Voter voter;

    private DBConnection connection;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private List<Voter> voters;

    public static int rowsCount = 0;

    public XMLHandler() {
        voters = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (voter == null && qName.equals("voter")) {
            LocalDate date = LocalDate.parse(attributes.getValue("birthDay"), formatter);
            voter = new Voter(attributes.getValue("name"), date);
            voters.add(voter);
        }
        if (voters.size() % 1000 == 0 && !voters.isEmpty()) {
           printDuplicates();
           rowsCount += 1000;
           System.out.println(rowsCount);

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            voter = null;
        }
    }

    public void printDuplicates() {
        if (connection != null) {
            try {
                Insertexecutor insertexecutor = new Insertexecutor(connection.getConnection(), voters);
                insertexecutor.execute();
                voters.clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setConnection(DBConnection connection) {
        this.connection = connection;
    }
}
