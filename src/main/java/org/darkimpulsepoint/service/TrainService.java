package org.darkimpulsepoint.service;

import org.darkimpulsepoint.entity.Train;

import java.time.LocalTime;
import java.util.List;


public interface TrainService {

    public List<Train> getTrainsByDestination(Train[] trains, String destination);

    public List<Train> getTrainsByDestinationAndTime(Train[] trains, String destination, LocalTime time);

    public List<Train> getTrainsWithCommonSeats(Train[] trains, String destination);
}