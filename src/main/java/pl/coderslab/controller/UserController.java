package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/save")
    public String add(@Valid User user, BindingResult errors, HttpServletRequest request){

        if(errors.hasErrors()){
            return "tweetForm";
        }
        userRepository.save(user);
        return "redirect:"+request.getContextPath()+"/user/all";
    }
}

