package mk.ukim.finki.icareapp.service;

import mk.ukim.finki.icareapp.model.BreathingExercise;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BreathingExerciseService {
    List<BreathingExercise> findAll();
    BreathingExercise getExercise(Long id);
}
