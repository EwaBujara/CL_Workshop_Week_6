package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Meow;
import pl.coderslab.entity.PrivateMeow;
import pl.coderslab.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/private_meow")
public class PrivateMeowController {



    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("meow", new PrivateMeow());
        return "private_meow/form";
    }

    @PostMapping("/add")
    public String add(@Valid PrivateMeow privateMeow, BindingResult errors,
                      HttpServletRequest request,
                      HttpSession session){

        if(errors.hasErrors()){
            return "private_meow/form";
        }
        User currentUser = (User)session.getAttribute("currentUser");
        privateMeow.setAuthor(currentUser);
       // privateMeowRepository.save(privateMeow);
        return "redirect:"+request.getContextPath()+"/private_meow/list/"+currentUser.getId();
    }
}
