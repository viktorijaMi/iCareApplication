package mk.ukim.finki.icareapp.model.exceptions;

public class AudioNotFoundException extends RuntimeException{
    public AudioNotFoundException(Long id){
        super(String.format("Audio with id %d was not found", id));
    }
}
