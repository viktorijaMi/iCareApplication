package mk.ukim.finki.icareapp.service.impl;

import mk.ukim.finki.icareapp.model.Audio;
import mk.ukim.finki.icareapp.model.exceptions.AudioNotFoundException;
import mk.ukim.finki.icareapp.repository.AudioJpaRepository;
import mk.ukim.finki.icareapp.service.AudioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioServiceImpl implements AudioService {

    private final AudioJpaRepository audioJpaRepository;

    public AudioServiceImpl(AudioJpaRepository audioJpaRepository) {
        this.audioJpaRepository = audioJpaRepository;
    }

    @Override
    public List<Audio> findAll() {
        return this.audioJpaRepository.findAll();
    }

    @Override
    public Audio getAudioById(Long id) {
        return this.audioJpaRepository.findById(id).orElseThrow(() -> new AudioNotFoundException(id));
    }


}
