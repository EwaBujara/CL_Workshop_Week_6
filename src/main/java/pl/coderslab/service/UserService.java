package pl.coderslab.service;

import pl.coderslab.entity.User;

public interface UserService {
    void save(User user);

    boolean verify(User user);

    User findByUsername(String username);

    User findByEmail(String email);
}