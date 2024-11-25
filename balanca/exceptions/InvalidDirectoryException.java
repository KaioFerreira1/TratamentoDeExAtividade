package br.com.balanca.exceptions;

public class InvalidDirectoryException extends RuntimeException {
    public InvalidDirectoryException(String message) {
        super(message);
    }
}
