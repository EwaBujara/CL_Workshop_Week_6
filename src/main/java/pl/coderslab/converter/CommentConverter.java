package pl.coderslab.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Comment;
import pl.coderslab.repository.CommentRepository;

public class CommentConverter implements Converter <String, Comment> {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment convert(String s) {
        return commentRepository.findOne(Long.parseLong(s));
    }
}

//public class UserConverter implements Converter<String, User> {
//
//    @Autowired
//    UserRepository userRepository;
//    @Override
//    public User convert(String s) {
//        return userRepository.findOne(Long.parseLong(s));
//    }
//}