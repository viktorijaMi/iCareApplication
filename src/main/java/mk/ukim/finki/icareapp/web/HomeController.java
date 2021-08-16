package mk.ukim.finki.icareapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/"})
public class HomeController {

    @GetMapping
    public String getLoginAndRegisterPage(Model model){
        model.addAttribute("bodyContent", "home");
        return "master-template";
    }

    @GetMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("bodyContent", "home-page");
        model.addAttribute("navbar", "menu");
        return "master-template";
    }

    @GetMapping("/help")
    public String getHelpPage(Model model) {
        model.addAttribute("bodyContent", "help");
        return "master-template";
    }
}
