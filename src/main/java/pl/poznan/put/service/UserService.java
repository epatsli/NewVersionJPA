package pl.poznan.put.service;


import pl.poznan.put.model.User;

public interface UserService {

    User findByLogin(String login);
}
