package mk.ukim.finki.icareapp.web;

import mk.ukim.finki.icareapp.model.User;
import mk.ukim.finki.icareapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String loginPage(@RequestParam(required = false) String error,
                            Model model){
        if (error != null){
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", error);
        }
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    @PostMapping
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest request) {
        try{
            User user = this.userService.login(username, password);
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        } catch (RuntimeException ex) {
            return "redirect:/login?error="+ ex.getMessage();
        }
    }
}
