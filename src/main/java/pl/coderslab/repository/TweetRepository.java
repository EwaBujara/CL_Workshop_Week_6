package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Meow;

import java.util.List;

public interface TweetRepository extends JpaRepository<Meow, Long> {

//    Tweetów dla zadanego id użytkownika.
    List<Meow> findAllByUserId(Long id);

//    Tweetów o tytule, który zaczyna się od ciągu znaków,
//    np. Programo , posortowane od najnowszego względem daty utworzenia.
//    Ciąg znaków do wyszukiwania ma być określony jako parametr.

    List<Meow> findAllByTitleStartingWithOrderByCreatedDesc(String titleStart);


}

