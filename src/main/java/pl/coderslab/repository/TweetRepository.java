package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Tweet;

import java.awt.print.Book;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

//    Tweetów dla zadanego id użytkownika.
    List<Tweet> findAllByUserId(Long id);

//    Tweetów o tytule, który zaczyna się od ciągu znaków,
//    np. Programo , posortowane od najnowszego względem daty utworzenia.
//    Ciąg znaków do wyszukiwania ma być określony jako parametr.

    List<Tweet> findAllByTitleStartingWithOrderByCreatedDesc(String titleStart);


}

