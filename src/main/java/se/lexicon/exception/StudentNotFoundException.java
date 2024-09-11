package se.lexicon.exception;

public class StudentNotFoundException extends RuntimeException {
    private int paramName;

    public StudentNotFoundException(String message, int paramName) {
        super(message);
        this.paramName = paramName;
    }
}
