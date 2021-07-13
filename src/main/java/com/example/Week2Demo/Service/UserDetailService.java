package com.example.Week2Demo.Service;



import com.example.Week2Demo.Dao.UserDAO;
import com.example.Week2Demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {
    //Get DATA by JPA
    @Autowired
    private UserRepository repository;
    //Get DATA by Hibernate
    // Note(bug về sessionFactory)
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.example.Week2Demo.model.User user = userService.findByID(s);
        return new User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
//        return new User("foo", "foo", new ArrayList<>());
    }
}