package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Meow;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/meow")
@Controller
public class MeowController {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("meow", new Meow());
        return "meow/form";
    }

    @PostMapping("/save")
    public String add(@Valid Meow meow, BindingResult errors, HttpServletRequest request){

        if(errors.hasErrors()){
            return "meow/form";
        }
        tweetRepository.save(meow);
        return "redirect:"+request.getContextPath()+"/meow/list";
    }

    @ModelAttribute("users")
    public List<User> usersList(){return userRepository.findAll();}
}

