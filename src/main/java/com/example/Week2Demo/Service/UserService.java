package com.example.Week2Demo.Service;

import com.example.Week2Demo.Dao.UserDAO;
import com.example.Week2Demo.model.Products;
import com.example.Week2Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;
    @Autowired
    public UserService(@Qualifier("userDAO") UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public User findByID(String name){
        return userDAO.getUserByName(name);
    }
    public List getInfo(){
        return userDAO.GetInfo();
    }
    public void save(User user){
        userDAO.save(user);
    }

}
