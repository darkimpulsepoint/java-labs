package org.darkimpulsepoint.validator;

import org.darkimpulsepoint.entity.Train;
import org.darkimpulsepoint.validator.impl.TrainValidatorImpl;
import org.testng.annotations.Test;

import java.time.LocalTime;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class TrainValidatorTest {

    @Test
    public void testValidTrainData() {
        TrainValidatorImpl validator = new TrainValidatorImpl();
        boolean isValid = validator.isValid(1, "CityA", 101, LocalTime.of(10, 0), 50, 20, 30, 10);
        assertTrue(isValid);
    }

    @Test
    public void testInvalidTrainNumber() {
        TrainValidatorImpl validator = new TrainValidatorImpl();
        boolean isValid = validator.isValid(45, "CityA", -1, LocalTime.of(10, 0), 50, 20, 30, 10);
        assertFalse(isValid);
    }

    @Test
    public void testInvalidCommonSeats() {
        TrainValidatorImpl validator = new TrainValidatorImpl();
        boolean isValid = validator.isValid(798, "CityA", 101, LocalTime.of(10, 0), -1, 20, 30, 10);
        assertFalse(isValid);
    }

    @Test
    public void testInvalidDepartureTime() {
        TrainValidatorImpl validator = new TrainValidatorImpl();
        boolean isValid = validator.isValid(2, "CityA", 101, null, 50, 20, 30, 10);
        assertFalse(isValid);
    }

    @Test
    public void testInvalidDestination() {
        TrainValidatorImpl validator = new TrainValidatorImpl();
        boolean isValid = validator.isValid(45, "", 101, LocalTime.of(10, 0), 50, 20, 30, 10);
        assertFalse(isValid);
    }
}