package org.darkimpulsepoint.validator;

import org.darkimpulsepoint.entity.Train;

import java.time.LocalTime;

public interface TrainValidator {

    public boolean isValid(long id, String destination, int trainNumber, LocalTime departureTime,
                           int commonSeats, int coupeSeats, int reservedSeats, int luxurySeats);

}