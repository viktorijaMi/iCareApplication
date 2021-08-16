package mk.ukim.finki.icareapp.web;

import mk.ukim.finki.icareapp.model.Audio;
import mk.ukim.finki.icareapp.service.AudioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/calming-sounds")
public class AudioController {

    private final AudioService audioService;

    public AudioController(AudioService audioService) {
        this.audioService = audioService;
    }

    @GetMapping
    public String getAudioPage(Model model){
        List<Audio> audios = this.audioService.findAll();
        List<Audio> list1 = audios.subList(0,2);
        List<Audio> list2 = audios.subList(2,4);

        model.addAttribute("navbar", "menu");
        model.addAttribute("audios1", list1);
        model.addAttribute("audios2", list2);
        model.addAttribute("bodyContent", "audio");
        return "master-template";
    }

    @PostMapping("/{id}")
    public String playAudio(@PathVariable Long id,
                            Model model){
        Audio audio =  this.audioService.getAudioById(id);

        model.addAttribute("audio", audio);
        model.addAttribute("bodyContent", "play-audio");
        return "master-template";
    }
}
