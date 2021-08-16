package mk.ukim.finki.icareapp.web;

import mk.ukim.finki.icareapp.model.BreathingExercise;
import mk.ukim.finki.icareapp.service.BreathingExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/breathing-exercises")
public class BreathingExerciseController {

    private final BreathingExerciseService breathingExerciseService;

    public BreathingExerciseController(BreathingExerciseService breathingExerciseService) {
        this.breathingExerciseService = breathingExerciseService;
    }

    @GetMapping
    public String getBreathingExercisePage(Model model){
        List<BreathingExercise> breathingExercises = this.breathingExerciseService.findAll();
        model.addAttribute("breathingExercises", breathingExercises);
        model.addAttribute("bodyContent", "breathing-exercise");

        return "master-template";
    }

    @PostMapping("/{id}")
    public String playVideo(@PathVariable Long id,
                            Model model){
        BreathingExercise exercise = this.breathingExerciseService.getExercise(id);
        model.addAttribute("title", "Ниво " + exercise.getLevel());
        model.addAttribute("exercise", exercise);
        model.addAttribute("bodyContent", "play-exercise");
        return "master-template";
    }
}
