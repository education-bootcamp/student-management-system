package lk.developersstack.lms.exceptions;

public class NotFoundException extends RuntimeException{

    private String message;

    public NotFoundException(String message) {
        super(message);
    }
}
