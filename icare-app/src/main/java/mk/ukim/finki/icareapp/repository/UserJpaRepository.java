package mk.ukim.finki.icareapp.repository;

import mk.ukim.finki.icareapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, String> {
}
