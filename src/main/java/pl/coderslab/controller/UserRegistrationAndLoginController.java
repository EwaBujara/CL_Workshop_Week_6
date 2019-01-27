package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.UserValidator;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserRegistrationAndLoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "user/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult,
                               HttpSession session) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        userService.save(userForm);

        session.setAttribute("currentUser", userForm);

        return "meow/list";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userLog", new User());

        return "user/login";
    }

    @PostMapping("login")
    public String login(
            @ModelAttribute("userLog") User userLog,
            HttpSession session){

        return "";
    }
//    @GetMapping(value = "/login")
//    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and/or password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }


    @GetMapping("/withoutLogin")
    public String withoutLogin(){
        return "meow/list";
    }


    @RequestMapping("/all")
    public String showAll(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/add/{id}")
    public String add(Model model, @PathVariable Long id){
        model.addAttribute("user", userRepository.findOne(id));
        return "user/add";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        User user = userRepository.findOne(id);
        userRepository.delete(user);
        return "user/list";
    }

    @ModelAttribute("users")
    public List<User> users (){return userRepository.findAll();}
}

