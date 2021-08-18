package mk.ukim.finki.icareapp.web;

import mk.ukim.finki.icareapp.model.Feelings;
import mk.ukim.finki.icareapp.model.User;
import mk.ukim.finki.icareapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error,
                                  Model model){
        if (error != null) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", error);
        }
        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    @PostMapping
    public String register(Model model,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String gender,
                           @RequestParam String date_of_birth,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String confirmPassword,
                           HttpServletRequest request) {
        try{
            User user = this.userService.register(name, surname, gender, date_of_birth, username, password, confirmPassword);
            List<Feelings> feelings = Arrays.asList(Feelings.values());
            List<String> why_the_app_list = new ArrayList<>();
            why_the_app_list.add("Да го подобрам мојот сон");
            why_the_app_list.add("Да имам секогаш некого до мене");
            why_the_app_list.add("Да го подобрам моето ментално здравје");

            model.addAttribute("feelings", feelings);
            model.addAttribute("why_the_app_list", why_the_app_list);
            model.addAttribute("bodyContent", "test");
            return "master-template";
        } catch (RuntimeException ex) {
            return "redirect:/register?error=" + ex.getMessage();
        }
    }

    @PostMapping("/test")
    public String test(@RequestParam String start_feeling,
                       @RequestParam String frequent_feeling,
                       @RequestParam String panic_attack,
                       @RequestParam String why_the_app,
                       @RequestParam String stressed_period,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        this.userService.test(user.getUsername(), start_feeling, frequent_feeling, panic_attack, why_the_app, stressed_period);
        return "redirect:/login";
    }
}
