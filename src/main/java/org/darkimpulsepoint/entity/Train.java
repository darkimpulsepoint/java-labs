package org.darkimpulsepoint.entity;

import java.time.LocalTime;
import java.util.Objects;


public class Train {
    private long id; // New field for the train ID
    private String destination;
    private int trainNumber;
    private LocalTime departureTime;
    private int commonSeats;
    private int coupeSeats;
    private int reservedSeats;
    private int luxurySeats;

    public Train(long id, String destination, int trainNumber, LocalTime departureTime, int commonSeats, int coupeSeats, int reservedSeats, int luxurySeats) {
        this.id = id;
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.commonSeats = commonSeats;
        this.coupeSeats = coupeSeats;
        this.reservedSeats = reservedSeats;
        this.luxurySeats = luxurySeats;
    }

    public long getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public int getCommonSeats() {
        return commonSeats;
    }

    public int getCoupeSeats() {
        return coupeSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public int getLuxurySeats() {
        return luxurySeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return id == train.id && // Include id in equality check
                trainNumber == train.trainNumber &&
                commonSeats == train.commonSeats &&
                coupeSeats == train.coupeSeats &&
                reservedSeats == train.reservedSeats &&
                luxurySeats == train.luxurySeats &&
                (destination == train.destination || (destination != null && destination.equals(train.destination))) &&
                (departureTime == train.departureTime || (departureTime != null && departureTime.equals(train.departureTime)));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(id); // Include id in hash code calculation
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + trainNumber;
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + commonSeats;
        result = 31 * result + coupeSeats;
        result = 31 * result + reservedSeats;
        result = 31 * result + luxurySeats;
        return result;
    }

    @Override
    public String toString() {
      StringBuilder str = new StringBuilder("Train{");
      str.append("id=");
      str.append(id);
      str.append(", destination=");
      str.append(destination);
      str.append(", trainNumber=");
      str.append(trainNumber);
      str.append(", departureTime=");
      str.append(departureTime);
      str.append(", commonSeats=");
      str.append(commonSeats);
      str.append(", coupeSeats=");
      str.append(coupeSeats);
      str.append(", reservedSeats=");
      str.append(reservedSeats);
      str.append(", luxurySeats=");
      str.append(luxurySeats);
      str.append("}");
      return str.toString();
    }
}
