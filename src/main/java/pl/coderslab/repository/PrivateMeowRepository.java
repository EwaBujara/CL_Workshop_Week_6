package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.PrivateMeow;
import pl.coderslab.entity.User;

import java.util.List;

public interface PrivateMeowRepository extends JpaRepository<PrivateMeow, Long> {
    List<PrivateMeow> findAllByAuthor(User user);
    List<PrivateMeow> findAllByRecipient(User user);
}
