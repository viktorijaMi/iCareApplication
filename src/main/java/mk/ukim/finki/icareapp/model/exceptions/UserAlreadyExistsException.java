package mk.ukim.finki.icareapp.model.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username) {
        super(String.format("User with username %s already exists", username));
    }
}
