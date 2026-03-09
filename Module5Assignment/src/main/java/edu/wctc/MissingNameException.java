package edu.wctc;

public class MissingNameException extends Exception {

    public MissingNameException(String nameType) {
        super(nameType + " may not be blank.");
    }
}
