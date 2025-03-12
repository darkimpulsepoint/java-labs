package org.darkimpulsepoint.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.darkimpulsepoint.entity.Train;
import org.darkimpulsepoint.service.TrainService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TrainServiceImpl implements TrainService {

    private static final Logger logger = LogManager.getLogger(TrainServiceImpl.class);

    @Override
    public List<Train> getTrainsByDestination(Train[] trains, String destination) {
        logger.info("Getting trains by destination: {}", destination);
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equals(destination)) {
                result.add(train);
            }
        }
        logger.info("Found {} trains for destination {}", result.size(), destination);
        return result;
    }

    @Override
    public List<Train> getTrainsByDestinationAndTime(Train[] trains, String destination, LocalTime time) {
        logger.info("Getting trains by destination: {} and time after: {}", destination, time);
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equals(destination) && train.getDepartureTime().isAfter(time)) {
                result.add(train);
            }
        }
        logger.info("Found {} trains for destination {} after time {}", result.size(), destination, time);
        return result;
    }

    @Override
    public List<Train> getTrainsWithCommonSeats(Train[] trains, String destination) {
        logger.info("Getting trains with common seats for destination: {}", destination);
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equals(destination) && train.getCommonSeats() > 0) {
                result.add(train);
            }
        }
        logger.info("Found {} trains with common seats for destination {}", result.size(), destination);
        return result;
    }
}