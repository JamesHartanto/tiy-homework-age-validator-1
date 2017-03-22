package com.theironyard;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by doug on 3/21/17.
 */
public class ValidatorTest {

    @Test
    /**
     * Given a validator and an age
     * When the age is 34
     * Then the age is valid
     */
    public void when34ThenValid() throws NonIntegerException, NonNumericException, InvalidAgeException {
        // Arrange
        Validator validator = new Validator();

        // Act
        boolean isValid = validator.validateAge("34");

        // Assert
        assertThat(isValid, equalTo(true));
    }

    @Test(expected = NonIntegerException.class)
    /**
     * Given a validator
     * When the age is 34.43
     * Then a Non-Integer exception is thrown
     */
    public void whenDoubleThenNonIntegerExceptionThrown() throws NonIntegerException, NonNumericException, InvalidAgeException {
        // Arrange
        Validator validator = new Validator();

        // Act
        validator.validateAge("34.43");

        // Assert
        fail("NonIntegerException not thrown!");
    }

    @Test(expected = NonIntegerException.class)
    /**
     * Given a validator
     * When any number has a decimal point
     * Then the noninteger exception thrown
     */
    public void whenDecimalPointThenInvalid() throws NonIntegerException, NonNumericException, InvalidAgeException {
        // Arrange
        Validator validator = new Validator();

        // Act
        validator.validateAge("34.0");

        // Assert
        fail("NonIntegerException not thrown!");
    }

    @Test(expected = NonNumericException.class)
    /**
     * Given a validator
     * When a string is provided
     * Then a nonnumeric exception is thrown
     */
    public void whenStringThenInvalid() throws NonIntegerException, NonNumericException, InvalidAgeException {
        // Arrange
        Validator validator = new Validator();

        // Act
        validator.validateAge("Twenty");

        // Assert
        fail("NonNumericException not thrown!");
    }

    @Test(expected = InvalidAgeException.class)
    /**
     * Given a validator
     * When age is 10
     * Then InvalidAgeException is thrown
     */
    public void when10ThenInvalidAge() throws NonNumericException, NonIntegerException, InvalidAgeException {
        // Arrange
        Validator validator = new Validator();

        // Act
        validator.validateAge("10");

        // Assert
        fail("InvalidAgeException not thrown!");

    }

    @Test(expected = InvalidAgeException.class)
    /**
     * Given a validator
     * When age is 116
     * Then InvalidAgeException is thrown
     */
    public void when116ThenInvalidAge() throws NonNumericException, NonIntegerException, InvalidAgeException {
        // Arrange
        Validator validator = new Validator();

        // Act
        validator.validateAge("116");

        // Assert
        fail("InvalidAgeException not thrown!");

    }
}
