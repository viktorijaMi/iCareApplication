package mk.ukim.finki.icareapp.model.exceptions;

public class BreathingExerciseNotFoundException extends RuntimeException{
    public BreathingExerciseNotFoundException(Long id){
        super(String.format("Вежба за дишење со ID: %d не е пронајдена", id));
    }
}
