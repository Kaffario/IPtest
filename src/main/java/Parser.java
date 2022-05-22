import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Parser {
    public TicketList parse() {

        Gson gson = new Gson();

        try (InputStream in = getClass().getResourceAsStream("/tickets.json");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            TicketList tickets = gson.fromJson(reader, TicketList.class);
            return tickets;

        } catch (Exception e) {e.printStackTrace();}

        return null;
    }
}
