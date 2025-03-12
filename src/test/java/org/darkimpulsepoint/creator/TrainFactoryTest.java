package org.darkimpulsepoint.creator;

import org.darkimpulsepoint.entity.Train;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.Optional;

import static org.testng.Assert.*;

public class TrainFactoryTest {

    private final TrainFactory trainFactory = new TrainFactory();

    @Test
    public void testCreateValidTrain() {
        Optional<Train> optionalTrain = trainFactory.createTrain(1, "CityA", 101, LocalTime.of(10, 0), 50, 20, 30, 10);
        assertTrue(optionalTrain.isPresent());
        Train train = optionalTrain.get();
        assertEquals(train.getDestination(), "CityA");
        assertEquals(train.getTrainNumber(), 101);
        assertEquals(train.getDepartureTime(), LocalTime.of(10, 0));
        assertEquals(train.getCommonSeats(), 50);
        assertEquals(train.getCoupeSeats(), 20);
        assertEquals(train.getReservedSeats(), 30);
        assertEquals(train.getLuxurySeats(), 10);
    }

    @Test
    public void testCreateInvalidTrainWithNegativeTrainNumber() {
        Optional<Train> optionalTrain = trainFactory.createTrain(2, "CityA", -1, LocalTime.of(10, 0), 50, 20, 30, 10);
        assertFalse(optionalTrain.isPresent());
    }

    @Test
    public void testCreateInvalidTrainWithNegativeCommonSeats() {
        Optional<Train> optionalTrain = trainFactory.createTrain(3, "CityA", 101, LocalTime.of(10, 0), -10, 20, 30, 10);
        assertFalse(optionalTrain.isPresent());
    }

    @Test
    public void testCreateInvalidTrainWithNullDestination() {
        Optional<Train> optionalTrain = trainFactory.createTrain(4, null, 101, LocalTime.of(10, 0), 50, 20, 30, 10);
        assertFalse(optionalTrain.isPresent());
    }

    @Test
    public void testCreateInvalidTrainWithEmptyDestination() {
        Optional<Train> optionalTrain = trainFactory.createTrain(5, "", 101, LocalTime.of(10, 0), 50, 20, 30, 10);
        assertFalse(optionalTrain.isPresent());
    }

    @Test
    public void testCreateInvalidTrainWithNullDepartureTime() {
        Optional<Train> optionalTrain = trainFactory.createTrain(6, "CityA", 101, null, 50, 20, 30, 10);
        assertFalse(optionalTrain.isPresent());
    }


    @Test
    public void testCreateInvalidTrainWithNegativeCoupeSeats() {
        Optional<Train> optionalTrain = trainFactory.createTrain(7, "CityA", 101, LocalTime.of(10, 0), 50, -20, 30, 10);
        assertFalse(optionalTrain.isPresent());
    }

    @Test
    public void testCreateInvalidTrainWithNegativeReservedSeats() {
        Optional<Train> optionalTrain = trainFactory.createTrain(8, "CityA", 101, LocalTime.of(10, 0), 50, 20, -30, 10);
        assertFalse(optionalTrain.isPresent());
    }

    @Test
    public void testCreateInvalidTrainWithNegativeLuxurySeats() {
        Optional<Train> optionalTrain = trainFactory.createTrain(9, "CityA", 101, LocalTime.of(10, 0), 50, 20, 30, -10);
        assertFalse(optionalTrain.isPresent());
    }

    @Test
    public void testCreateTrainWithZeroSeats() {
        Optional<Train> optionalTrain = trainFactory.createTrain(10, "CityA", 101, LocalTime.of(10, 0), 0, 0, 0, 0);
        assertTrue(optionalTrain.isPresent());
        Train train = optionalTrain.get();
        assertEquals(train.getCommonSeats(), 0);
        assertEquals(train.getCoupeSeats(), 0);
        assertEquals(train.getReservedSeats(), 0);
        assertEquals(train.getLuxurySeats(), 0);
    }

    @Test
    public void testCreateTrainWithMaximumSeats() {
        Optional<Train> optionalTrain = trainFactory.createTrain(11, "CityA", 101, LocalTime.of(10, 0), Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertTrue(optionalTrain.isPresent());
        Train train = optionalTrain.get();
        assertEquals(train.getCommonSeats(), Integer.MAX_VALUE);
        assertEquals(train.getCoupeSeats(), Integer.MAX_VALUE);
        assertEquals(train.getReservedSeats(), Integer.MAX_VALUE);
        assertEquals(train.getLuxurySeats(), Integer.MAX_VALUE);
    }
}