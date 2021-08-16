package mk.ukim.finki.icareapp.model.exceptions;

public class IncorectPasswordOrUsername extends RuntimeException{
    public IncorectPasswordOrUsername(){
        super("Incorrect password or username");
    }
}
