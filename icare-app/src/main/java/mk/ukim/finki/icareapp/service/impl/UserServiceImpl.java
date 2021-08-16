package mk.ukim.finki.icareapp.service.impl;

import mk.ukim.finki.icareapp.model.Feelings;
import mk.ukim.finki.icareapp.model.User;
import mk.ukim.finki.icareapp.model.exceptions.IncorectPasswordOrUsername;
import mk.ukim.finki.icareapp.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.icareapp.model.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.icareapp.model.exceptions.UserNotFoundException;
import mk.ukim.finki.icareapp.repository.UserJpaRepository;
import mk.ukim.finki.icareapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    public UserServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User findByUsername(String username) {
        return this.userJpaRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public User login(String username, String password) {
        User user =  this.userJpaRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));
        if (!user.getPassword().equals(password)){
            throw new IncorectPasswordOrUsername();
        }
        return user;
    }

    @Override
    public User register(String name, String surname, String gender, String date_of_birth, String username, String password, String confirmPassword) {
        if (userJpaRepository.findById(username).isPresent()){
                throw new UserAlreadyExistsException(username);
        }
        if (!password.equals(confirmPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        User user = new User(name, surname, gender, date_of_birth, username, password);
        this.userJpaRepository.save(user);
        return user;
    }

    @Override
    public User test(String username,String start_feeling, String frequent_feeling, String panic_attack, String why_the_app, String stressed_period) {
        User user = this.userJpaRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));
        user.setStart_feeling(Feelings.valueOf(start_feeling));
        user.setFrequent_feeling(frequent_feeling.equals("Да"));
        user.setPanic_attack(panic_attack.equals("Да"));
        user.setWhy_the_app(why_the_app);
        user.setStressed_period(stressed_period.equals("Да"));

        this.userJpaRepository.save(user);
        return user;
    }
}
