package com.app;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValidationAPIUnitTest {
    public static Validator getValidator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void manufacturerIsNull() {
        CarDTO carDTO = new CarDTO(null, "prado", 2005, "BI4565CA");
        Set<ConstraintViolation<CarDTO>> constraintViolations = getValidator().validate(carDTO);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void licensePlateTooShort() {
        CarDTO carDTO = new CarDTO("Toyota", "Prado", 2005, "4565");
        Set<ConstraintViolation<CarDTO>> constraintViolations = getValidator().validate(carDTO);
        assertEquals(1, constraintViolations.size());
        assertEquals("size must be between 6 and 8", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void licensePlateIsNull() {
        CarDTO carDTO = new CarDTO("Toyota", "Prado", 2005, null);
        Set<ConstraintViolation<CarDTO>> constraintViolations = getValidator().validate(carDTO);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void theCarIsTooOld() {
        CarDTO carDTO = new CarDTO("Toyota", "Prado", 1900, "BI4565CA");
        Set<ConstraintViolation<CarDTO>> constraintViolations = getValidator().validate(carDTO);
        assertEquals(1, constraintViolations.size());
        assertEquals("cars not older than 1990", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void carsFromTheFuture() {
        CarDTO carDTO = new CarDTO("Toyota", "Prado", 2023, "BI4565CA");
        Set<ConstraintViolation<CarDTO>> constraintViolations = getValidator().validate(carDTO);
        assertEquals(1, constraintViolations.size());
        assertEquals("year of manufacture of the car no more than 2022",
                constraintViolations.iterator().next().getMessage());
    }

    @Test
    void carModelIsNull() {
        CarDTO carDTO = new CarDTO("Toyota", null, 2005, "BI4565CA");
        Set<ConstraintViolation<CarDTO>> constraintViolations = getValidator().validate(carDTO);
        assertEquals(2, constraintViolations.size());
        //assertEquals("cannot be an empty field", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void carModelIsEmpty() {
        CarDTO carDTO = new CarDTO("Toyota", "", 2005, "BI4565CA");
        Set<ConstraintViolation<CarDTO>> constraintViolations = getValidator().validate(carDTO);
        assertEquals(1, constraintViolations.size());
        assertEquals("cannot be an empty field", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void licensePlateloInLowerCase() {
        CarDTO carDTO = new CarDTO("Toyota", "yaris", 2005, "bi4565ca");
        Set<ConstraintViolation<CarDTO>> constraintViolations = getValidator().validate(carDTO);
        assertEquals(1, constraintViolations.size());
        assertEquals("only in uppercase", constraintViolations.iterator().next().getMessage());
    }
}