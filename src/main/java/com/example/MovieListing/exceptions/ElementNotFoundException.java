package com.example.MovieListing.exceptions;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException() {
        super();
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
