package org.darkimpulsepoint.entity;

import org.testng.annotations.Test;

import java.time.LocalTime;

import static org.testng.Assert.assertEquals;

public class TrainTest {

    @Test
    public void testTrainConstructorAndGetters() {
        Train train = new Train(1, "CityA", 101, LocalTime.of(10, 0), 50, 20, 30, 10);

        assertEquals(train.getDestination(), "CityA");
        assertEquals(train.getTrainNumber(), 101);
        assertEquals(train.getDepartureTime(), LocalTime.of(10, 0));
        assertEquals(train.getCommonSeats(), 50);
        assertEquals(train.getCoupeSeats(), 20);
        assertEquals(train.getReservedSeats(), 30);
        assertEquals(train.getLuxurySeats(), 10);
    }
}