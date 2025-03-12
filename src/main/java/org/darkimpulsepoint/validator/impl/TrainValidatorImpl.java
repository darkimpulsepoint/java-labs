package org.darkimpulsepoint.validator.impl;

import org.darkimpulsepoint.entity.Train;
import org.darkimpulsepoint.validator.TrainValidator;

import java.time.LocalTime;

public class TrainValidatorImpl implements TrainValidator {

    
    public boolean isValid(long id,String destination, int trainNumber, LocalTime departureTime,
                          int commonSeats, int coupeSeats, int reservedSeats, int luxurySeats) {
        return id>0 &&
                trainNumber > 0 &&
               commonSeats >= 0 &&
               coupeSeats >= 0 &&
               reservedSeats >= 0 &&
               luxurySeats >= 0 &&
               departureTime != null &&
               destination != null && !destination.isEmpty();
    }
}