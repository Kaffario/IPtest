import java.util.Collections;
import java.util.List;

public class TicketList {
    List<Ticket> tickets;

    public long avgFlightTimeVTA() {

        long fulltime =0;
        int counter =0;

        for (Ticket t:tickets) {
            if (t.origin.equals("VVO")&&t.destination.equals("TLV")) {
                fulltime += t.flytime();
                counter++;
            }
        }
        return fulltime/counter;
    }

    public long percentile90() {
        Collections.sort(tickets);
        int perc = (int) Math.ceil(0.9*tickets.size());
        return tickets.get(perc-1).flytime();
    }

}
