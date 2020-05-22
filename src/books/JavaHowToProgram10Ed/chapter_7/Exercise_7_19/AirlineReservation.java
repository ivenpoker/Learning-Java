package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_19;

public class AirlineReservation {

    private final int DEFAULT_NUMBER_OF_SEATS = 10;
    private final boolean [] seats;
    private int nextFirstClassSeat = 0;
    private int nextEconomySeat = DEFAULT_NUMBER_OF_SEATS/2;

    public enum SeatType {FIRST_CLASS, ECONOMY}

    public AirlineReservation() {
        this.seats = new boolean[this.DEFAULT_NUMBER_OF_SEATS];
    }

    public boolean assignSeat(SeatType typeSelected) {
        switch (typeSelected) {
            case FIRST_CLASS:
                if (this.nextFirstClassSeat < this.seats.length / 2) {
                    this.seats[this.nextFirstClassSeat++] = true;
                    return true;
                } else {
                    return false;
                }
            case ECONOMY:
                if (this.nextEconomySeat < this.DEFAULT_NUMBER_OF_SEATS) {
                    this.seats[this.nextEconomySeat++] = true;
                    return true;
                } else {
                    return false;
                }

            default:
                System.out.printf("%%n\t======== [AIRLINE_SYSTEM_ERROR] =========%n%n");
        }
        return false;
    }

    public boolean isReservationAvailable() {
        for (boolean seat : this.seats) {
            if (!seat) {            // if seat has not bee taken yet.
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.seats.length; i++) {
            if (i < this.seats.length / 2) {
                sb.append(String.format("%s |", this.seats[i] ? "F" : "_"));
            } else {
                sb.append(String.format("%s |", this.seats[i] ? "E" : "_"));
            }
        }
        return sb.toString();
    }

}
