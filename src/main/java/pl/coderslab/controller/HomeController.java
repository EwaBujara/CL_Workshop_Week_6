package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homeSender(){
        return "index";
    }

    @Autowired
    TweetRepository tweetRepository;

    @RequestMapping("/user/{id}/tweets")
    public String userTweets(@PathVariable Long id, Model model){
        List<Tweet> tweets = tweetRepository.findAllByUserId(id);
        model.addAttribute("tweets", tweets);
        return "tweetList";
    }

    @RequestMapping("/user/search-tweets")
    public String searchedTweets(Model model){
        String titleStart = "tit";
        List<Tweet> tweets = tweetRepository.findAllByTitleStartingWithOrderByCreatedDesc(titleStart);
        model.addAttribute(tweets);
        return "tweetList";
    }
}
