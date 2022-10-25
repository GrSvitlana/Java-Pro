package hw26_Okt23_Exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Wrong password exception");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
