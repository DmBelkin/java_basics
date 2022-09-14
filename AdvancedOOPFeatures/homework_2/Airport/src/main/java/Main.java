import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import org.apache.commons.collections.collection.CompositeCollection;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        LocalDateTime time = LocalDateTime.now().plusHours(2);
        LocalDateTime nowTime = LocalDateTime.now();
        return airport.getTerminals().stream()
                .flatMap((terminal -> terminal.getFlights().stream()
                        .filter(flight -> flight.getDate().toInstant().
                                atZone(ZoneId.systemDefault()).toLocalDateTime().isBefore(time) &&
                                flight.getDate().toInstant().
                                        atZone(ZoneId.systemDefault()).toLocalDateTime().isAfter(nowTime))))
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE)).collect(Collectors.toList());
    }

}