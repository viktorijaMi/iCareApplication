package mk.ukim.finki.icareapp.service;

import mk.ukim.finki.icareapp.model.Audio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AudioService {
    List<Audio> findAll();
    Audio getAudioById(Long id);
}
