import java.util.ArrayList;
import java.util.List;

class Cinema {
    private final String cinemaName;
    private List<Seat> seatsList;
    private int seatsPerRow;

    Cinema(String cinemaName, int numberOfRows, int seatsPerRow) {
        this.cinemaName = cinemaName;
        this.seatsPerRow = seatsPerRow;
        seatsList = new ArrayList<>();
        int lastRow = 'A' + (numberOfRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                seatsList.add(new Seat(row + String.format("%02d", seat)));
            }
        }
    }

    void showSeats() {
        for (int i = 0; i < seatsList.size(); i++) {
            if ((i % seatsPerRow) == 0) {
                System.out.println();
            }
            if (seatsList.get(i).isReserved) {
                System.out.print("*");
            }
            System.out.print(seatsList.get(i).getSeatNumber() + "  ");
        }
        System.out.println("\n\n \"*\" - reserved");
    }

    private Seat findSeat(String seatNumber){
        for(Seat seat: seatsList){
            if(seat.getSeatNumber().equals(seatNumber)){
                return seat;
            }
        }
        return null;
    }

    void reserveSeat(String seatNumber){
        Seat tempSeat = findSeat(seatNumber);
        if(tempSeat == null){
            System.out.println("Seat " + seatNumber + " not found.");
        }
        else{
            if(tempSeat.reserve()){
                System.out.println("Seat " + seatNumber + " successfully reserved.");
            }
            else {
                System.out.println("Seat " + seatNumber + " already reserved.");
            }
        }
    }

    void cancelReservation(String seatNumber){

        Seat tempSeat = findSeat(seatNumber);
        if(tempSeat == null){
            System.out.println("Seat " + seatNumber + " not found.");
        }
        else {
            if(tempSeat.cancelReservation()){
                System.out.println("Reservation on seat " + seatNumber + " successfully canceled.");
            }
            else {
                System.out.println("Seat " + seatNumber + " not reserved.");
            }

        }


    }

    public String getCinemaName() {
        return cinemaName;
    }


    private class Seat {
        private final String seatNumber;
        private boolean isReserved = false;

        Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        String getSeatNumber() {
            return seatNumber;
        }

        boolean reserve() {
            if (this.isReserved) {
                return false;
            } else {
                this.isReserved = true;
                return true;
            }
        }

        public boolean cancelReservation() {
            if (this.isReserved) {
                this.isReserved = false;
                return true;
            } else {
                return false;
            }
        }


    }

}


