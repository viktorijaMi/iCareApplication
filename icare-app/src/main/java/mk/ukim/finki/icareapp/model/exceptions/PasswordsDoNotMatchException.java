package mk.ukim.finki.icareapp.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords do not match. Try again!");
    }
}
