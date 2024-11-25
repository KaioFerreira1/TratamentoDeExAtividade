package br.com.balanca.exceptions;

public class InvalidProductValueException extends RuntimeException {
    public InvalidProductValueException(String message) {
        super(message);
    }
}
