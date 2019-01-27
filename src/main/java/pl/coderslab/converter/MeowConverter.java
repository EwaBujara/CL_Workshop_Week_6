package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Meow;
import pl.coderslab.repository.TweetRepository;

public class MeowConverter implements Converter<String, Meow> {

    @Autowired
    TweetRepository tweetRepository;

    @Override
    public Meow convert(String s) {
        return tweetRepository.findOne(Long.parseLong(s)) ;
    }
}
