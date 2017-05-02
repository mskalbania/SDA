public class Run {

    public static void main(String[] args) {

        Cinema cinema = new Cinema("Helios",10,15);
        cinema.showSeats();
        cinema.reserveSeat("A15");
        cinema.reserveSeat("A05");
        cinema.showSeats();
        cinema.reserveSeat("G04");
        cinema.reserveSeat("A01");
        cinema.reserveSeat("A02");
        cinema.showSeats();
    }


}
