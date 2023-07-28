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
                for (Voter anyVoter : voters) {
                    connection.countVoter(anyVoter.getName(), anyVoter.getBirthDay().toString());
                }
                connection.printVoterCounts();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setConnection(DBConnection connection) {
        this.connection = connection;
    }
}
