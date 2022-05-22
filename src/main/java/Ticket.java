import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;

public class Ticket implements Comparable<Ticket> {
    public String origin;
    public String origin_name;
    public String destination;
    public String destination_name;
    public String departure_date;
    public String departure_time;
    public String arrival_date;
    public String arrival_time;
    public String carrier;
    public Integer stops;
    public Integer price;

    public long flytime() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
                .appendPattern("[dd.MM.yy.HH:mm]")
                .appendPattern("[dd.MM.yy.H:mm]");

        DateTimeFormatter formatter = builder.toFormatter();

        LocalDateTime departure = LocalDateTime.parse(departure_date + "." + departure_time, formatter);
        LocalDateTime arrival = LocalDateTime.parse(arrival_date + "." + arrival_time, formatter);

        return ChronoUnit.MINUTES.between(departure, arrival);
    }

    @Override
    public int compareTo(Ticket t) {
        return (int) (this.flytime()-t.flytime());
    }
}
