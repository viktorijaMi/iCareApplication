package mk.ukim.finki.icareapp.service;

import mk.ukim.finki.icareapp.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


public interface UserService {

    User findByUsername(String username);

    User login(String username,
               String password);

    User register(String name,
                  String surname,
                  String gender,
                  String date_of_birth,
                  String username,
                  String password,
                  String confirmPassword);

    User test(String username,
              String start_feeling,
              String frequent_feeling,
              String panic_attack,
              String why_the_app,
              String stressed_period);
}
