package com.example.MovieListing.exceptions;

public class DataAlreadyAvailableException extends Exception {
    public DataAlreadyAvailableException() {
    }

    public DataAlreadyAvailableException(String message) {
        super(message);
    }
}
