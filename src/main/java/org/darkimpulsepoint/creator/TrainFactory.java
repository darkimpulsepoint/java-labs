package org.darkimpulsepoint.creator;

import org.darkimpulsepoint.entity.Train;
import org.darkimpulsepoint.validator.impl.TrainValidatorImpl;

import java.time.LocalTime;
import java.util.Optional;

public class TrainFactory {

    public Optional<Train> createTrain(long id, String destination, int trainNumber, LocalTime departureTime, int commonSeats, int coupeSeats, int reservedSeats, int luxurySeats) {
        TrainValidatorImpl validator = new TrainValidatorImpl();
        if (validator.isValid(id, destination, trainNumber, departureTime, commonSeats, coupeSeats, reservedSeats, luxurySeats)) {
            Train train = new Train(id, destination, trainNumber, departureTime, commonSeats, coupeSeats, reservedSeats, luxurySeats);
            return Optional.of(train);
        } else {
            return Optional.empty();
        }
    }
}