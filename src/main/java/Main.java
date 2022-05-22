public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser();
        TicketList tl = parser.parse();

        System.out.println("avg flytime from VVO to TLV " + tl.avgFlightTimeVTA() + " minutes");
        System.out.println("90 percentile "+ tl.percentile90() + " minutes");
    }
}
