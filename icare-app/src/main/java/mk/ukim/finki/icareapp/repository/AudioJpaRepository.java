package mk.ukim.finki.icareapp.repository;

import mk.ukim.finki.icareapp.model.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioJpaRepository extends JpaRepository<Audio, Long> {
}
