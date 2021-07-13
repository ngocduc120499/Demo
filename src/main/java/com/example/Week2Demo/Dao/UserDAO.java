package com.example.Week2Demo.Dao;

import com.example.Week2Demo.model.User;

import java.util.List;

public interface UserDAO {
    List GetInfo();
    User getUserByName(String name);
    void save(User user);
}
