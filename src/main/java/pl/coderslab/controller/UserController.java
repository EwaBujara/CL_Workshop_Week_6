package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
            return "userForm";
        }
        userRepository.save(user);
        return "redirect:"+request.getContextPath()+"/user/all";
    }

    @RequestMapping("/all")
    public String showAll(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
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
        return "userList";
    }
}


