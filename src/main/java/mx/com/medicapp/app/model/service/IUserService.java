package mx.com.medicapp.app.model.service;

import mx.com.medicapp.app.model.entity.User;

import java.util.List;

public interface IUserService {

    User findByUsername(String username);

    List<User> findAllUsers();

    User createUser(User user);
}
