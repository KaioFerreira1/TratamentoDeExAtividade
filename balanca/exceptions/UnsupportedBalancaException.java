package br.com.balanca.exceptions;

public class UnsupportedBalancaException extends RuntimeException {
    public UnsupportedBalancaException(String message) {
        super(message);
    }
}