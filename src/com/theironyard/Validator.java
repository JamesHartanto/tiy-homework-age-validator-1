package com.theironyard;

/**
 * Created by doug on 3/21/17.
 */
public class Validator {
    public boolean validateAge(String age) throws NonIntegerException, NonNumericException, InvalidAgeException {

        // try to parse the age as a double
        parseDouble(age);

        // if we get here it's numeric, but is it an int? parse to find out!
        int ageInt = parseInt(age);

        // is the age under 18?
        if(ageInt < 18 || ageInt > 115){
            throw new InvalidAgeException();
        }

        return true;
    }

    private int parseInt(String age) throws NonIntegerException {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            throw new NonIntegerException();
        }
    }

    private double parseDouble(String age) throws NonNumericException {
        try{
            return Double.parseDouble(age);
        } catch (NumberFormatException e){
            throw new NonNumericException();
        }
    }
}
