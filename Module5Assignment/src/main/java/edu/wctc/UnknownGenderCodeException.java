package edu.wctc;

public class UnknownGenderCodeException extends Exception {

    public UnknownGenderCodeException(char genderCode) {
        super("Unknown gender code: " + genderCode);
    }
}
