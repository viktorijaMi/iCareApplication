package mk.ukim.finki.icareapp.service.impl;

import mk.ukim.finki.icareapp.model.BreathingExercise;
import mk.ukim.finki.icareapp.model.exceptions.BreathingExerciseNotFoundException;
import mk.ukim.finki.icareapp.repository.BreathingExerciseJpaRepository;
import mk.ukim.finki.icareapp.service.BreathingExerciseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreathingExerciseImpl implements BreathingExerciseService {

    private final BreathingExerciseJpaRepository breathingExerciseJpaRepository;

    public BreathingExerciseImpl(BreathingExerciseJpaRepository breathingExerciseJpaRepository) {
        this.breathingExerciseJpaRepository = breathingExerciseJpaRepository;
    }

    @Override
    public List<BreathingExercise> findAll() {
        return this.breathingExerciseJpaRepository.findAll();
    }

    @Override
    public BreathingExercise getExercise(Long id) {
        return this.breathingExerciseJpaRepository.findById(id).orElseThrow(() -> new BreathingExerciseNotFoundException(id));
    }


}
