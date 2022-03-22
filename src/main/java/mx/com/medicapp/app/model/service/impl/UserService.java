package mx.com.medicapp.app.model.service.impl;

import mx.com.medicapp.app.model.dao.IUserDao;
import mx.com.medicapp.app.model.entity.User;
import mx.com.medicapp.app.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService implements IUserService, UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return StreamSupport
                .stream(userDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userDb = userDao.findByUsername(username);

        if(userDb == null){
            throw new UsernameNotFoundException("User does not exist!");
        }else{
            return org.springframework.security.core.userdetails.User
                    .withUsername(userDb.getUsername())
                    .password(userDb.getPassword())
                    .authorities("ADMIN")
                    .build();
        }
    }
}
