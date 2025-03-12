package org.darkimpulsepoint.service;

import org.darkimpulsepoint.entity.Train;
import org.darkimpulsepoint.service.impl.TrainServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TrainServiceTest {

    private TrainService trainService;
    private Train[] trains;

    @BeforeMethod
    public void setUp() {
        trainService = new TrainServiceImpl();
        trains = new Train[]{
                new Train(1, "CityA", 101, LocalTime.of(10, 0), 50, 20, 30, 10),
                new Train(2, "CityB", 102, LocalTime.of(12, 0), 0, 20, 30, 10),
                new Train(3, "CityA", 103, LocalTime.of(14, 0), 50, 20, 30, 10),
                new Train(4, "CityC", 104, LocalTime.of(16, 0), 10, 10, 10, 10)
        };
    }

    @Test
    public void testGetTrainsByDestinationCityA() {
        List<Train> result = trainService.getTrainsByDestination(trains, "CityAA");
        assertEquals(result.size(), 0);

    }

    @Test
    public void testGetTrainsByDestinationCityB() {
        List<Train> result = trainService.getTrainsByDestination(trains, "CityB");
        assertEquals(result.size(), 1);
        assertTrue(result.stream().anyMatch(train -> train.getTrainNumber() == 102));
    }

    @Test
    public void testGetTrainsByDestinationNonExistent() {
        List<Train> result = trainService.getTrainsByDestination(trains, "NonExistentCity");
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetTrainsByDestinationAndTimeCityA() {
        List<Train> result = trainService.getTrainsByDestinationAndTime(trains, "CityA", LocalTime.of(11, 0));
        assertEquals(result.size(), 1);
        assertTrue(result.stream().anyMatch(train -> train.getTrainNumber() == 103));
    }

    @Test
    public void testGetTrainsByDestinationAndTimeCityB() {
        List<Train> result = trainService.getTrainsByDestinationAndTime(trains, "CityB", LocalTime.of(13, 0));
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetTrainsWithCommonSeatsCityA() {
        List<Train> result = trainService.getTrainsWithCommonSeats(trains, "CityA");
        assertEquals(result.size(), 2);
        assertTrue(result.stream().anyMatch(train -> train.getTrainNumber() == 101));
        assertTrue(result.stream().anyMatch(train -> train.getTrainNumber() == 103));
    }

    @Test
    public void testGetTrainsWithCommonSeatsCityB() {
        List<Train> result = trainService.getTrainsWithCommonSeats(trains, "CityB");
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetTrainsWithCommonSeatsCityC() {
        List<Train> result = trainService.getTrainsWithCommonSeats(trains, "CityC");
        assertEquals(result.size(), 1);
        assertTrue(result.stream().anyMatch(train -> train.getTrainNumber() == 104));
    }

    @Test
    public void testGetTrainsByDestinationEmptyString() {
        List<Train> result = trainService.getTrainsByDestination(trains, "");
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetTrainsByDestinationNull() {
        List<Train> result = trainService.getTrainsByDestination(trains, null);
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetTrainsByDestinationAndTimeNoTrainsAfterTime() {
        List<Train> result = trainService.getTrainsByDestinationAndTime(trains, "CityA", LocalTime.of(15, 0));
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetTrainsByDestinationAndTimeExactMatch() {
        List<Train> result = trainService.getTrainsByDestinationAndTime(trains, "CityA", LocalTime.of(10, 0));
        assertEquals(result.size(), 1);
        assertTrue(result.stream().anyMatch(train -> train.getTrainNumber() == 103));
    }

    @Test
    public void testGetTrainsWithCommonSeatsNoCommonSeats() {
        List<Train> result = trainService.getTrainsWithCommonSeats(trains, "CityB");
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetTrainsWithCommonSeatsNullDestination() {
        List<Train> result = trainService.getTrainsWithCommonSeats(trains, null);
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetTrainsWithCommonSeatsEmptyDestination() {
        List<Train> result = trainService.getTrainsWithCommonSeats(trains, "");
        assertEquals(result.size(), 0);
    }
}