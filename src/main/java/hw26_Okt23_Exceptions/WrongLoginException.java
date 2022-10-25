package hw26_Okt23_Exceptions;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Wrong login exception");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
